(function () {

    describe('AvaliacaoSkillComponent', function () {
        beforeEach(module('avaliacaoApp'));

        var $componentController, $httpBackend;
        var skills = ['HTML', 'CSS'];
        var bindings = {skills: []};

        beforeEach(inject(function (_$componentController_, _$httpBackend_) {
            $componentController = _$componentController_;
            $httpBackend = _$httpBackend_;
        }));

        afterEach(function () {
            $httpBackend.verifyNoOutstandingExpectation();
            $httpBackend.verifyNoOutstandingRequest();
        });

        describe('Inicializando componente', function () {
            it('Deve carregar os skills com sucesso', function () {
                $httpBackend.expectGET('/skill').respond(200, skills);
                var ctrl = $componentController('avaliacaoSkill', null, bindings);
                $httpBackend.flush();
                expect(ctrl.skills).toBeDefined();
                expect(ctrl.error).toBeFalsy();
                expect(ctrl.skills).toEqual([
                    {tipo: 'CSS', grauConhecimento: 0},
                    {tipo: 'HTML', grauConhecimento: 0}
                ]);
            });

            it('Deve dar erro ao carregar os skills', function () {
                $httpBackend.expectGET('/skill').respond(400, '');
                var ctrl = $componentController('avaliacaoSkill', null, bindings);
                $httpBackend.flush();
                expect(ctrl.error).toBeTruthy();
            });

            it('Deve inicializar a config do rating', function () {
                $httpBackend.expectGET('/skill')
                    .respond(200, '');
                var ctrl = $componentController('avaliacaoSkill', null, bindings);
                $httpBackend.flush();
                expect(ctrl.ratings.max).toBe(10);
            });
        });

        describe('Validar funções do ratings', function () {
            var ctrl;
            beforeEach(function () {
                $httpBackend.expectGET('/skill')
                    .respond(200, skills);
                ctrl = $componentController('avaliacaoSkill', null, bindings);
                $httpBackend.flush();
            });

            it('Cor do rating deve ser vazio', function () {
                var skill = {};
                ctrl.ratings.onHover(skill, -1)
                expect(skill.color).toEqual('');

                ctrl.ratings.onHover(skill, 11)
                expect(skill.color).toEqual('');
            });

            it('Cor do rating deve ser warning', function () {
                var skill = {};
                for(var i = 0 ; i < 3; i++){
                    ctrl.ratings.onHover(skill, i)
                    expect(skill.color).toEqual('warning');
                }
                ctrl.ratings.onHover(skill, 3)
                expect(skill.color).not.toEqual('warning');
            });

            it('Cor do rating deve ser info', function () {
                var skill = {};
                for(var i = 3 ; i < 7; i++){
                    ctrl.ratings.onHover(skill, i)
                    expect(skill.color).toEqual('info');
                }
                ctrl.ratings.onHover(skill, 8)
                expect(skill.color).not.toEqual('info');
            });

            it('Cor do rating deve ser success', function () {
                var skill = {};
                for(var i = 8; i < 11; i++){
                    ctrl.ratings.onHover(skill, i)
                    expect(skill.color).toEqual('success');
                }
                ctrl.ratings.onHover(skill,11)
                expect(skill.color).not.toEqual('success');
            });


            it('Reset na cor', function () {
                var skill = {color: 'info'};
                ctrl.ratings.onLeaver(skill)
                expect(skill.color).toEqual('');
            });
        });
    });
})();
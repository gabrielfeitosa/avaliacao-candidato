(function(){

    describe('AvaliacaoController', function() {
        beforeEach(module('avaliacaoApp'));

        var $controller, $httpBackend;


        beforeEach(inject(function(_$controller_, _$httpBackend_){
            $httpBackend = _$httpBackend_;
            $controller = _$controller_;
        }));

        afterEach(function() {
            $httpBackend.verifyNoOutstandingExpectation();
            $httpBackend.verifyNoOutstandingRequest();
        });

        describe('Deve iniciar o candidato', function() {
            it('Candidato definido', function() {
                var ctrl = $controller('AvaliacaoController');
                expect(ctrl.candidato).toBeDefined();
                expect(ctrl.candidato.nome).toBe('');
                expect(ctrl.candidato.email).toBe('');
                expect(ctrl.candidato.skills.length).toBe(0);
            });
        });

        describe('Método submeter', function() {
            it('Submeter com sucesso', function() {
                var ctrl = $controller('AvaliacaoController');
                ctrl.candidato.nome = 'Fulano';
                ctrl.candidato.email = 'teste@teste.com'
                ctrl.candidato.skills = [];
                var retorno = {mensagem: 'Enviado para avaliação'};
                $httpBackend.expectPOST('/avaliacao', ctrl.candidato)
                    .respond(200, retorno);
                ctrl.submeter();
                expect(ctrl.form.submetido).toBeFalsy();
                expect(ctrl.form.mensagem).toEqual('');
                $httpBackend.flush();
                expect(ctrl.form.submetido).toBeTruthy();
                expect(ctrl.form.mensagem).toEqual(retorno.mensagem);
            });
        });
    });
})();
(function () {

    'use strict';

    angular.module('avaliacaoApp')
        .component('avaliacaoSkill', {
            templateUrl: 'src/templates/avaliacao-skill.html',
            bindings: {
                skills: '='
            },
            controller: 'AvaliacaoSkillController'
        })
        .controller('AvaliacaoSkillController', function ($http, $filter) {
            var ctrl = this;
            ctrl.error = false;
            $http.get('skill').then(function (response) {
                response.data.forEach(function (skill) {
                    ctrl.skills.push({tipo: skill, grauConhecimento: 0});
                });
                ctrl.skills = $filter('orderBy')(ctrl.skills, 'tipo');
                ctrl.error = false;
            }).catch(function () {
                ctrl.error = true;
            });

            ctrl.ratings = {
                max: 10,
                titles: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10'],
                onHover: function (skill, value) {
                    skill.color = (value < 0 || value > 10) ? '' : (value < 3) ? 'warning' : (value < 7) ? 'info' : 'success';
                },
                onLeaver: function (skill) {
                    skill.color = '';
                }
            };
        });
})();

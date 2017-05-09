(function () {
    'use strict';

    angular.module('avaliacaoApp')
        .controller('AvaliacaoController', function ($http) {
            var self = this;
            self.form = {
                submetido: false,
                mensagem: ''
            };

            self.candidato = {
                nome: '',
                email: '',
                skills: []
            };

            self.submeter = function () {
                $http.post('avaliacao', self.candidato).then(function (response) {
                    self.form.submetido = true;
                    self.form.mensagem = response.data.mensagem;
                });
            };
        });
})();
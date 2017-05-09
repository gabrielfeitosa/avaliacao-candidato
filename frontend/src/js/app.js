(function () {
    'use strict';

    angular.module('avaliacaoApp', ['ui.bootstrap', 'ngMessages'])
        .constant('EMAIL_PATTERN', /^[a-z]+[a-z0-9._]+@[a-z]+\.[a-z.]+$/)
        .run(function ($rootScope, EMAIL_PATTERN) {
            $rootScope.EMAIL_PATTERN = EMAIL_PATTERN;
        });
})();
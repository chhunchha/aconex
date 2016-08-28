(function () {
    'use strict';

    angular.module('contractApp', ['ngRoute', 'ui.bootstrap', 'ngMessages'])
        .config(function ($routeProvider) {

            $routeProvider
                .when('/contracts', {
                    controller: 'ContractsCtrl',
                    controllerAs: 'ContractsCtrl',
                    templateUrl: '/components/contract/index.html'
                })
                .when('/contract', {
                    controller: 'ContractCtrl',
                    controllerAs: 'ContractCtrl',
                    templateUrl: '/components/contract/contract.html'
                })
                .when('/contract/:id', {
                    controller: 'ContractCtrl',
                    controllerAs: 'ContractCtrl',
                    templateUrl: '/components/contract/contract.html'
                })
                .otherwise({
                    redirectTo: '/contracts'
                });

        });
})();

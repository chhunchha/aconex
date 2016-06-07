(function () {
    angular.module('contractApp')
        .controller('ContractsCtrl', function ($http) {

            var self = this;

            this.setContracts = function (response) {
                self.contracts = response.data;
            };

            $http.get('/api/contracts').then(this.setContracts).catch(function (err) {
                console.error(err);
            });
        })
}());
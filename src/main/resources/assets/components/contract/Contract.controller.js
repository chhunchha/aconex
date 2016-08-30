 angular.module('contractApp')
    .controller('ContractCtrl', ContractCtrl);

ContractCtrl.$inject = ['$routeParams', '$http', 'dialogService','dataService', '$location'];

function ContractCtrl($routeParams, $http, dialogService, dataService, $location) {
    var ctrl = this;

    ctrl.contract = {};

    if($routeParams.id != undefined) {
        dataService.getContract($routeParams.id)
        .then(function(data) {
            ctrl.contract = data;
        });
    }

    var goToContracts = function() {
        $location.path('/contracts')
    };

    ctrl.save = function(frmContract) {
        if(frmContract.$invalid) {
            angular.forEach(frmContract.$error, function (field) {
                angular.forEach(field, function(errorField){
                    errorField.$setTouched();
                })
            });
        } else {
            dataService.createContract(angular.toJson(ctrl.contract))
            .then(function(data) {
                if(data) {
                    dialogService.showMessage(data.code +  " contract saved");
                    goToContracts();
                }
            });
        }

    }

    ctrl.cancel = function() {
        goToContracts();
    }

    ctrl.projects = [];

    var getProjects = function() {
        dataService.getProjects()
        .then(function(data){
            ctrl.projects = data;
        });
    }

    getProjects();

}

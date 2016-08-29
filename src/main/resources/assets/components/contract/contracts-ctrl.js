(function () {
    angular.module('contractApp')
    .controller('ContractsCtrl', ContractsCtrl);

    ContractsCtrl.$inject = ['$http', 'dialogService','dataService', '$location', '$scope', 'searchService'];

    function ContractsCtrl($http, dialogService, dataService, $location, $scope, searchService) {

        var self = this;

        self.search = {};
        self.search.text = searchService.getSearchText();
        $scope.$on('search', function(event, text) {
            self.search.text = text;
        });

        this.setContracts = function (data) {
            self.contracts = data;
//            console.log(data);
        };

        self.getContracts = function() {
            dataService.getContracts()
            .then(this.setContracts);
        }

        self.getContracts();

//        self.contract = {
//            code : '',
//            description: '',
//            vendor: 'ZZZ Inc',
//            percentComplete: 10.0,
//            budget: 20000.0,
//            paid: 10000.0,
//            forecast: 19000.0,
//            committed: 20000.0
//        };
//
//         self.saveNewContract = function() {
//            var rand = ('000' + Math.floor((Math.random() * 100) + 1)).slice(-3);
//            self.contract.code = 'CON-' + rand;
//            self.contract.description = 'Contract ' + rand;
//
//            dataService.createContract(angular.toJson(self.contract))
//            .then(function(data) {
//                dialogService.showMessage("New Contract created - " + data.code);
//                self.getContracts();
//            });
//        }

        self.addContract = function() {
            $location.path('/contract');
        }

        var contractToDelete = {};
        self.deleteContractConfirm = function(contract) {
            contractToDelete = contract;
            dialogService.confirmMessage("Are you sure you want to delete "  + contract.code + " contract?",
                self.deleteContract, self.cancelDelete);
        }

        self.deleteContract = function() {
            if(contractToDelete.id != undefined) {
                dataService.deleteContract(contractToDelete.id)
                .then(function(data) {
                    if(data) {
                        dialogService.showMessage("Contract deleted.");
                        self.getContracts();
                    }
                });
            }
        }

        self.cancelDelete = function() {
            contractToDelete = {};
        }

        self.editContract = function(id) {
            $location.path("/contract/" + id);
        }
    }
}());
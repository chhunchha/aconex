angular.module('contractApp')
.factory('dialogService', dialogService);

dialogService.$inject = ['$uibModal'];

function dialogService($uibModal) {

    var service = {
        showMessage: showMessage,
        confirmMessage: confirmMessage
    };

    return service;

//////

    function showMessage(message) {
        var modalInstance = $uibModal.open({
            animation: true,
            ariaDescribedBy: 'modal-body',
            templateUrl: '/commonServices/MessageDialog.html',
            controller: 'MessageDialogController',
            controllerAs: '$ctrl',
            size: 'sm',
            resolve: {
                message: function () {
                  return message;
                }
            }
        });
    }

    function confirmMessage(question, okCallback, cancelCallback) {
        var modalInstance = $uibModal.open({
            animation: true,
            ariaDescribedBy: 'modal-body',
            templateUrl: '/commonServices/ConfirmDialog.html',
            controller: 'ConfirmDialogController',
            controllerAs: '$ctrl',
            size: 'lg',
            resolve: {
                question: function () {
                  return question;
                },
                okCallback: function() {
                    return okCallback;
                },
                cancelCallback: function() {
                    return cancelCallback;
                }
            }
        });
    }
}

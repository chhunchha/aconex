'use strict';

angular.module('contractApp')
.controller('MessageDialogController', MessageDialogController);

MessageDialogController.$inject = ['$uibModalInstance', 'message'];
function MessageDialogController($uibModalInstance, message) {
    var $ctrl = this;
    $ctrl.message = message;

//    $ctrl.ok = function () {
//        $uibModalInstance.close();
//    };
//
//    $ctrl.cancel = function () {
//        $uibModalInstance.dismiss('cancel');
//    };
}

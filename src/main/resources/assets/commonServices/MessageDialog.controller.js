'use strict';

angular.module('contractApp')
.controller('MessageDialogController', MessageDialogController);

MessageDialogController.$inject = ['$uibModalInstance', 'message', '$timeout'];
function MessageDialogController($uibModalInstance, message, $timeout) {
    var ctrl = this;
    ctrl.message = message;

    ctrl.ok = function () {
        $uibModalInstance.close();
    };
//
//    ctrl.cancel = function () {
//        $uibModalInstance.dismiss('cancel');
//    };

    $timeout(function(){
        ctrl.ok();
    }, 2000);
}

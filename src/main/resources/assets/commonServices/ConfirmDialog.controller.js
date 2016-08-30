'use strict';

angular.module('contractApp')
.controller('ConfirmDialogController', ConfirmDialogController);

ConfirmDialogController.$inject = ['$uibModalInstance', 'question', 'okCallback', 'cancelCallback'];
function ConfirmDialogController($uibModalInstance, question, okCallback, cancelCallback) {
    var ctrl = this;
    ctrl.question = question;

    ctrl.ok = function () {
        $uibModalInstance.close();
        if(okCallback != undefined) okCallback();

    };

    ctrl.cancel = function () {
        $uibModalInstance.dismiss('cancel');
        if(cancelCallback != undefined) cancelCallback();
    };
}

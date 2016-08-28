angular.module('contractApp')
.factory('dataService', dataService);

dataService.$inject = ['$http'];

function dataService($http) {

    var service = {
        getContracts : getContracts,
        createContract: createContract,
        deleteContract: deleteContract,
        getContract: getContract
    };

    return service;

//////

    function successCallBack(response) {
        return response.data;
    }

    function failedCallBack(error) {
        console.error(error.data);
    }

//////

    function getContracts() {
        return $http.get('/api/contracts')
                .then(successCallBack)
                .catch(failedCallBack);
    }

    function deleteContract(id) {
        return $http.delete('/api/contracts/' + id)
                .then(successCallBack)
                .catch(failedCallBack);
    }

    function createContract(data) {
        return $http.post('/api/contracts/post', data)
                .then(successCallBack)
                .catch(failedCallBack);
    }

    function getContract(id) {
        return $http.get('/api/contracts/' + id)
                .then(successCallBack)
                .catch(failedCallBack);
    }
}

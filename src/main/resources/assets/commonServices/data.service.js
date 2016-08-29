angular.module('contractApp')
.factory('dataService', dataService);

dataService.$inject = ['$http', '$q'];

function dataService($http, $q) {

    var service = {
        getContracts : getContracts,
        createContract: createContract,
        deleteContract: deleteContract,
        getContract: getContract,

        getProjects: getProjects
    };

    return service;

//////

    function successCallBack(response) {
        return response.data;
    }

    function failedCallBack(error) {
        console.error(error);
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

    function getProjects() {
        return $http.get('/api/projects')
                .then(successCallBack)
                .catch(failedCallBack);
    }
}

angular.module('contractApp')
.factory('searchService', searchService);

searchService.$inject = ['$rootScope'];

function searchService($rootScope) {

    var search = { text : ""};
    var service = {
        setSearchText: setSearchText,
        getSearchText: getSearchText
    };

    return service;

//////

    function setSearchText(text) {
        search.text = text;
        $rootScope.$broadcast("search", text);
    }

    function getSearchText() {
        return search.text;
    }
}

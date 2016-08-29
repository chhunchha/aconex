 angular.module('contractApp')
    .controller('SearchCtrl', SearchCtrl);

SearchCtrl.$inject = ['searchService'];

function SearchCtrl(searchService) {

    var ctrl = this;

    ctrl.search = { text: ""};

    ctrl.updateSearchText = function() {
        searchService.setSearchText(ctrl.search.text);
    }
}
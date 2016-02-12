angular.module('crudApp.controllers', []).controller('PhraseListController', function ($scope, $state, popupService, $window, Phrase) {

    $scope.phrases = Phrase.query();

    $scope.deletePhrase = function (phrase) {
        if (popupService.showPopup('Really delete this?')) {
            phrase.$delete(function () {
                $window.location.href = '';
            });
        }
    }

}).controller('PhraseViewController', function ($scope, $stateParams, Phrase) {

    $scope.phrase = Phrase.get({id: $stateParams.id});

}).controller('PhraseCreateController', function ($scope, $state, $stateParams, Phrase) {

    $scope.phrase = new Phrase();

    $scope.addPhrase = function () {
        $scope.phrase.$save(function () {
            $state.go('phrases');
        });
    }

}).controller('PhraseEditController', function ($scope, $state, $stateParams, Phrase) {

    $scope.updatePhrase = function () {
        $scope.phrase.$update(function () {
            $state.go('phrases');
        });
    };

    $scope.loadPhrase = function () {
        $scope.phrase = Phrase.get({id: $stateParams.id});
    };

    $scope.loadPhrase();

}).controller('PhraseSearchController', function ($scope, $http) {

    $scope.searchPhrase = function () {
        $http.get('api/entities/search', {params: {q: $scope.query}}).success(function (data) {
            $scope.results = data;
        });
    };

});
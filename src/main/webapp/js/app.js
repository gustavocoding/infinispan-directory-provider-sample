angular.module('crudApp', ['ui.router', 'ngResource', 'crudApp.controllers', 'crudApp.services']);

angular.module('crudApp').config(function($stateProvider) {
    $stateProvider.state('phrases', { // state for showing all phrases
        url: '/phrases',
        templateUrl: 'partials/phrases.html',
        controller: 'PhraseListController'
    }).state('viewPhrase', { //state for showing single Phrase
        url: '/phrases/:id/view',
        templateUrl: 'partials/phrase-view.html',
        controller: 'PhraseViewController'
    }).state('newPhrase', { //state for adding a new Phrase
        url: '/phrases/new',
        templateUrl: 'partials/phrase-add.html',
        controller: 'PhraseCreateController'
    }).state('editPhrase', { //state for updating a Phrase
        url: '/phrases/:id/edit',
        templateUrl: 'partials/phrase-edit.html',
        controller: 'PhraseEditController'
    }).state('searchPhrase', {  //state for querying
        url: '/phrases/search',
        templateUrl: 'partials/phrase-search.html',
        controller: 'PhraseSearchController'
    });
}).run(function($state) {
    $state.go('phrases'); //make a transition to phrases state when app starts
});
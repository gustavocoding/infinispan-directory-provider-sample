angular.module('crudApp.services', []).factory('Phrase', function ($resource) {
    return $resource('api/entities/:id', {id: '@id'}, {
        update: {
            method: 'PUT'
        }
    });
}).service('popupService', function ($window) {
    this.showPopup = function (message) {
        return $window.confirm(message);
    }
});
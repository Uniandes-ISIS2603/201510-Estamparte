angular.module('barraModule', [])
.controller('barraCtrl', ['$scope', function($scope) {}])
.directive('barra', function() {
  return {
    templateUrl: 'src/modules/barra/barra.tpl.html'
  };
});
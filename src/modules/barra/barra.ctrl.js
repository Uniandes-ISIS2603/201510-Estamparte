angular.module('barraModule', [])
.controller('barraCtrl', ['$scope', function($scope) {
        this.alertar=function(){
            alert('df');
        };
}])
.directive('barra', function() {
  return {
    templateUrl: 'src/modules/barra/barra.tpl.html'
  };
});
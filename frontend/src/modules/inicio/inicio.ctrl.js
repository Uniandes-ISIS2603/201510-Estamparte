angular.module('inicioModule', [])
.controller('inicioCtrl', ['$scope', function($scope) {}])
.directive('inicio', function() {
	return {
		templateUrl: 'src/modules/inicio/inicio.tpl.html'
	};
});
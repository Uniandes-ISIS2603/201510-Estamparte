angular.module('navbarModule', [])
.controller('navbarCtrl', ['$scope', function($scope) {}])
.directive('navbar', function() {
	return {
		templateUrl: 'src/modules/navbar/navbar.tpl.html'
	};
});
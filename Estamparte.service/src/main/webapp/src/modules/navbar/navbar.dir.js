(function () {
	angular.module('navbarModule')
	.directive('navbarDirective', navbarDirective);

	function navbarDirective() {
		return {
			controller: 'navbarController',
			controllerAs: 'navbarCtrl',
			replace: true,
			scope: {},
			templateUrl: 'src/modules/navbar/navbar.tpl.html'
		};
	}
})();
(function () {
	angular.module('loginModule')
	.directive('loginDirective', loginDirective);

	function loginDirective() {
		return {
			controller: 'loginController',
			controllerAs: 'loginCtrl',
			replace: true,
			scope: {},
			templateUrl: 'src/modules/login/login.tpl.html'
		}
	}
})();
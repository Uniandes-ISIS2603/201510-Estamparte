(function () {	
	angular.module('footerModule')
	.directive('footerDirective', footerDirective);

	function footerDirective() {
		return {
			controller: 'footerController',
			controllerAs: 'footerCtrl',
			replace: true,
			scope: {},
			templateUrl: 'src/modules/footer/footer.tpl.html'
		};
	}
})();
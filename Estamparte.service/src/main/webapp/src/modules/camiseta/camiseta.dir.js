(function () {
	var app = angular.module('camisetaModule');

	app.directive('camisetaDir', function () {
		return {
			controller: 'camisetaCtrl',
			replace: true,
			templateUrl: 'src/modules/camiseta/camiseta.tpl.html'
		}
	});
})();
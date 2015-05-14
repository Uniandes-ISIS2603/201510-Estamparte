(function () {	
	var app = angular.module('camisetaModule', ['CrudModule', 'MockModule']);

	app.constant('camiseta.context', 'camisetas');
	
	app.config(['camiseta.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
		urlsProvider.registerUrl(context);
	}]);
})();
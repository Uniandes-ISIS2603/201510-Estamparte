(function () {	
	var app = angular.module('compradorModule', ['CrudModule', 'MockModule']);

	app.constant('comprador.context', 'comprador');

	app.config(['comprador.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
		urlsProvider.registerUrl(context);
	}]);
})();
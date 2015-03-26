(function () {	
	var app = angular.module('estampasModule', ['CrudModule', 'MockModule']);

	app.constant('estampas.context', 'estampas');

	app.config(['estampas.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
		urlsProvider.registerUrl(context);
	}]);
})();
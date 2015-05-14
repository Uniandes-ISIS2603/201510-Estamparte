(function () {	
	var app = angular.module('estampasModule', ['CrudModule', 'MockModule']);

	app.constant('estampas.context', 'estampas');
        app.constant('estampas.skipMock', true);

	app.config(['estampas.context', 'MockModule.urlsProvider','estampas.skipMock', function (context, urlsProvider,skipMock) {
		urlsProvider.registerUrl(context,skipMock);
	}]);
})();
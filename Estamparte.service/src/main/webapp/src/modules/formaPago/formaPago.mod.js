(function () {
	var app = angular.module('formaPagoModule', ['CrudModule', 'MockModule']);

	app.constant('formaPago.context', 'formaPago');
        
        app.constant('formaPago.skipMock', true);

        app.config(['formaPago.context', 'MockModule.urlsProvider','formaPago.skipMock', function (context, urlsProvider, skipMock) {
                urlsProvider.registerUrl(context, skipMock);
        }]);

	app.config(['formaPago.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
		urlsProvider.registerUrl(context);
	}]);
})();

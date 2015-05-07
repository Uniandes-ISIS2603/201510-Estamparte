(function () {	
	var app = angular.module('carritoModule', ['CrudModule', 'MockModule']);

	app.constant('carrito.context', 'carrito');

        app.constant('carrito.skipMock', true);

        app.config(['carrito.context', 'MockModule.urlsProvider','carrito.skipMock', function (context, urlsProvider, skipMock) {
                urlsProvider.registerUrl(context, skipMock);
        }]);

	app.config(['carrito.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
		urlsProvider.registerUrl(context);
	}]);
})();


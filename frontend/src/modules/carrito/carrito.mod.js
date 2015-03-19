(function () {	
	var app = angular.module('carritoModule', ['CrudModule', 'MockModule']);

	app.constant('carrito.context', 'carrito');

	app.config(['carrito.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
		urlsProvider.registerUrl(context);
	}]);
})();
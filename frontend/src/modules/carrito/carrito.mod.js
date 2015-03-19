angular.module('carritoModule', ['CrudModule', 'MockModule'])
.constant('carrito.context', 'carrito')
.config(['carrito.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
	urlsProvider.registerUrl(context);
}]);


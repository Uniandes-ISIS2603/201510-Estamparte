angular.module('facturaModule', ['CrudModule', 'MockModule'])
.constant('factura.context', 'factura')
.config(['factura.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
	urlsProvider.registerUrl(context);
}]);
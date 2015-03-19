angular.module('formaPagoModule', ['CrudModule', 'MockModule'])
.constant('formaPago.context', 'formaPago')
.config(['formaPago.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
	urlsProvider.registerUrl(context);
}]);


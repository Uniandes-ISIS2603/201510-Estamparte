(function () {
	var app = angular.module('facturaModule', ['CrudModule', 'MockModule']);

	app.constant('factura.context', 'factura');

	app.config(['factura.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
		urlsProvider.registerUrl(context);
	}]);
})();
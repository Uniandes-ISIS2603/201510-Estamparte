(function () {
	var app = angular.module('formaPagoModule', ['CrudModule', 'MockModule']);

	app.constant('formaPago.context', 'formaPago');

	app.config(['formaPago.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
		urlsProvider.registerUrl(context);
	}]);
})();
(function () {
	var app = angular.module('misestampasModule', ['CrudModule', 'MockModule']);

	app.constant('misestampas.context', 'misestampas');

	app.config(['misestampas.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
		urlsProvider.registerUrl(context);
	}]);
})();
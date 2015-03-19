(function () {
	var app = angular.module('artistaModule', ['CrudModule', 'MockModule', 'estampaModule', 'angularFileUpload']);

	app.constant('artista.context', 'artista');

	app.config(['artista.context', 'MockModule.urlsProvider', function (context,urlsProvider) {
		urlsProvider.registerUrl(context);
	}]);
})();
(function () {
	var app = angular.module('artistaModule', ['CrudModule', 'MockModule', 'estampaModule', 'angularFileUpload']);

	app.constant('artista.context', 'artista');
        app.constant('artista.skipMock', true);

	app.config(['artista.context', 'MockModule.urlsProvider','artista.skipMock', function (context,urlsProvider,skipMock) {
		urlsProvider.registerUrl(context,skipMock);
	}]);
})();
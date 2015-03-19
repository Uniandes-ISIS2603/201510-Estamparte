angular.module('artistaModule', ['CrudModule', 'MockModule', 'estampaModule', 'angularFileUpload'])
.constant('artista.context', 'artista')
.config(['artista.context', 'MockModule.urlsProvider', function (context,urlsProvider) {
	urlsProvider.registerUrl(context);
}]);
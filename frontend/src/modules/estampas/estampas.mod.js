angular.module('estampasModule', ['CrudModule', 'MockModule', 'estampaModule', 'misestampasModule'])
.constant('estampas.context', 'estampas')
.config(['estampas.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
	urlsProvider.registerUrl(context);
}]);
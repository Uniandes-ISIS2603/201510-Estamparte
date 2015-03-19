angular.module('misestampasModule', ['CrudModule', 'MockModule'])
.constant('misestampas.context', 'misestampas')
.config(['misestampas.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
	urlsProvider.registerUrl(context);
}]);
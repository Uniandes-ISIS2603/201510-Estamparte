angular.module('camisetaModule', ['CrudModule', 'MockModule','carritoModule','estampaModule'])
.constant('camiseta.context', 'camisetas')
.config(['camiseta.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
	urlsProvider.registerUrl(context);
}]);

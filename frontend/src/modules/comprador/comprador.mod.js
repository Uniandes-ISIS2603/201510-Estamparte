angular.module('compradorModule', ['CrudModule', 'MockModule'])
.constant('comprador.context', 'comprador')
.config(['comprador.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
	urlsProvider.registerUrl(context);
}]); 


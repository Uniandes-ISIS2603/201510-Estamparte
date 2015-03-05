/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function () {

	var mainApp = angular.module('mainApp', ['ngRoute', 'facturaModule', 'compradorModule','artistaModule', 'estampa',
	'barra']);

	mainApp.config(['$routeProvider', function ($routeProvider) {
			$routeProvider.when('/factura', {
				templateUrl: 'src/modules/factura/factura.tpl.html'
                        }).when('/comprador', {
				templateUrl: 'src/modules/comprador/comprador.tpl.html'
			}).when('/artista',{
                                templateUrl: 'src/modules/artista/artista.tpl.html'
                        }).otherwise('/');
		}]);

	//Configuración módulo factura
	var facturaModule = angular.module('facturaModule', ['CrudModule', 'MockModule']);

	facturaModule.constant('factura.context', 'factura');

	facturaModule.config(['factura.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
			urlsProvider.registerUrl(context);
		}]);
            
            //Configuración módulo comprador
	var compradorModule = angular.module('compradorModule', ['CrudModule', 'MockModule']);

	compradorModule.constant('comprador.context', 'comprador');

	compradorModule.config(['factura.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
			urlsProvider.registerUrl(context);
		}]);
            
            //Configuracion de modulo de artista
            var artistaModule = angular.module('artistaModule',['CrudModule','MockModule']);
            
            artistaModule.constant('artista.context', 'artista');

            artistaModule.config(['artista.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
			urlsProvider.registerUrl(context);
		}]);
            
            
           
})();
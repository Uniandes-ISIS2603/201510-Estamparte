/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function () {

	var mainApp = angular.module('mainApp', ['ngRoute', 'facturaModule', 'compradorModule','artistaModule','estampaModule','barraModule']);

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
            
            //Configuracion del modulo de estampa
            var estampaModule = angular.module('estampaModule',['CrudModule','MockModule']);
            
            estampaModule.constant('estampa.context','estampa');
            
            estampaModule.config(['estampa.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
			urlsProvider.registerUrl(context);
		}]);
            
            
           
})();

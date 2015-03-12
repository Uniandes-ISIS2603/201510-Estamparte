/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function () {

	var mainApp = angular.module('mainApp', ['ngRoute', 'facturaModule', 'compradorModule','artistaModule','estampaModule','barraModule','carritoModule','formaPagoModule','moduloCamiseta']);
        mainApp.config(['$routeProvider', function ($routeProvider) {
            $routeProvider.when('/factura', {
                templateUrl: 'src/modules/factura/factura.tpl.html'
            }).when('/carrito', {
                templateUrl: 'src/modules/carrito/carrito.tpl.html'
            }).when('/formaPago', {
                templateUrl: 'src/modules/formaPago/formaPago.tpl.html'
            }).when('/camiseta', {
                templateUrl: 'src/modules/camiseta/camiseta.tpl.html'
            }).when('/artista', {
                templateUrl: 'src/modules/artista/artista.tpl.html'
            }).otherwise('src/principal.html');
        }]);
        
	
            
            //Configuración módulo comprador
	var compradorModule = angular.module('compradorModule', ['CrudModule', 'MockModule']);

	compradorModule.constant('comprador.context', 'comprador');

	compradorModule.config(['factura.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
			urlsProvider.registerUrl(context);
		}]); 
            
           
})();

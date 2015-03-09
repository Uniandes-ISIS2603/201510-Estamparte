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
            
                       
            //Modulo de carrito
            var carritoModule = angular.module('carritoModule',['CrudModule','MockModule']);
            
            carritoModule.constant('carrito.context','carrito');
            
            carritoModule.config(['carrito.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
			urlsProvider.registerUrl(context);
		}]);
            
            //Modulo de forma de pago
            var formaPagoModule = angular.module('formaPagoModule',['CrudModule','MockModule']);
            
            formaPagoModule.constant('formaPago.context','carrito');
            
            formaPagoModule.config(['formaPago.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
			urlsProvider.registerUrl(context);
		}]);
            
           
})();

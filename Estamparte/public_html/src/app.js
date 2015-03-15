/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function () {

	var mainApp = angular.module('mainApp', [
        'ngRoute',
        'facturaModule',
        'compradorModule',
        'artistaModule',
        'estampaModule',
        'navbarModule',
        'carritoModule',
        'formaPagoModule',
        'moduloCamiseta',
        'footerModule',
        'inicioModule',
        'estampasModule',
        'equipoModule'
    ]);
    
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
        }).otherwise('src/modules/inicio/inicio.tpl.html');
    }]);
 
})();

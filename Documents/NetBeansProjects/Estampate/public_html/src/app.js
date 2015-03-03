/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function () {

	var mainApp = angular.module('mainApp', ['ngRoute', 'facturaModule', 'compradorModule']);

	mainApp.config(['$routeProvider', function ($routeProvider) {
			$routeProvider.when('/factura', {
				templateUrl: 'src/modules/factura/factura.tpl.html'
                        }).when('/comprador', {
				templateUrl: 'src/modules/comprador/comprador.tpl.html'
			}).otherwise('/');
		}]);

	//Configuración módulo sport
	var facturaModule = angular.module('facturaModule', ['CrudModule', 'MockModule']);

	facturaModule.constant('factura.context', 'factura');

	facturaModule.config(['factura.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
			urlsProvider.registerUrl(context);
		}]);
            
            //Configuración módulo sport
	var compradorModule = angular.module('compradorModule', ['CrudModule', 'MockModule']);

	comprador.constant('comprador.context', 'comprador');

	comprador.config(['factura.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
			urlsProvider.registerUrl(context);
		}]);
            
           
})();
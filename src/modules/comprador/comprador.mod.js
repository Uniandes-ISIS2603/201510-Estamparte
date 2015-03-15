/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(){
    //Configuración módulo comprador
	var compradorModule = angular.module('compradorModule', ['CrudModule', 'MockModule']);

	compradorModule.constant('comprador.context', 'comprador');

	compradorModule.config(['comprador.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
			urlsProvider.registerUrl(context);
		}]); 
})();


/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function(){
    var facturaModule = angular.module('facturaModule',['CrudModule','MockModule']);
    
    facturaModule.constant('factura.context','factura');
    
    facturaModule.config(['factura.context','MockModule.urlsProvider',function(context,urlsProvider){
        urlsProvider.registerUrl(context);
    }]);
})();
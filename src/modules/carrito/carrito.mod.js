/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(){
    var carritoModule = angular.module('carritoModule',['CrudModule','MockModule']);
    
    carritoModule.constant('carrito.context','carrito');
    
    carritoModule.config(['carrito.context','MockModule.urlsProvider',function(context,urlsProvider){
        urlsProvider.registerUrl(context);
    }]);
})();


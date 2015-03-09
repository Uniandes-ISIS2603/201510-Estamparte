/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(){
    var formaPagoModule = angular.module('formaPagoModule',['CrudModule','MockModule']);
    
    formaPagoModule.constant('formaPago.context','formaPago');
    
    formaPagoModule.config(['formaPago.context','MockModule.urlsProvider'],function(context,urlsProvider){
        urlsProvider.registerUrl(context);
    });
})();


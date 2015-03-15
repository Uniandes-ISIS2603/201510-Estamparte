/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function(){
    var facturaModule = angular.module('facturaModule');
    facturaModule.service('servicioFactura',['CRUDUtils','factura.context',function(CRUDUtils,context){
            this.url = context;
            CRUDUtils.extendService(this);
    }]);
})();
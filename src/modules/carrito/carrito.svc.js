/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(){
    var carritoModule = angular.module('carritoModule');
    carritoModule.service('servicioCarrito',['CRUDUtils','carrito.context',function(CRUDUtils,context){
            this.url = context;
            CRUDUtils.extendService(this);
    }]);
})();


/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(){
    var moduloCamiseta = angular.module('moduloCamiseta');
    
    moduloCamiseta.service('servicioCamiseta',['CRUDUtils','camiseta.context',function(CRUDUtils,context){
            this.url = context;
            CRUDUtils.extendService(this);
            
            this.camisetas = [];
            
            this.darCamisetas = function(){
                return camisetas;
            };
            
            this.agregarCamiseta = function(camiseta)
            {
               camisetas.push(camiseta);
            };
     
            
    }]);
})();



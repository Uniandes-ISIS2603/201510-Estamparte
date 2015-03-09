/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(){
    var formaPagoModule = angular.module('formaPagoModule');
    formaPagoModule.service('servicioFormaPago', ['CRUDUtils', 'formaPago.context', function(CRUDUtils, context){
        this.url = context;
	CRUDUtils.extendService(this);
    }]);
})();

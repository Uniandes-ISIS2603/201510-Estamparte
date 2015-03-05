/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function(){
    
   var app = angular.module('facturaModule');

	app.controller('facturaCtrl', ['$scope', 'CRUDUtils', 'factura.context', function ($scope, CRUDUtils, context) {
			this.url = context;
                        this.editMode = false;
			CRUDUtils.extendCtrl(this, $scope);
                        
                        this.eliminarFactura = function(){
                            //Pre: se tiene en $scope.datoActual la factura a eliminar
                            //Pos: se elimina la factura
                            this.eliminarDato($scope.datoActual);
                            return 'Factura Eliminiada';
                        };
                       
		}]);
    
})();

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(){
    
   var app = angular.module('artistaModule');

	app.controller('artistaCtrl', ['$scope', 'CRUDUtils', 'artista.context', function ($scope, CRUDUtils, context) {
			this.url = context;
			CRUDUtils.extendCtrl(this, $scope);
                        
                        this.eliminarEstampa = function(){
                            //Pre: se tiene en $scope.datoActual la estampa a eliminar
                            //Pos: se elimina la estampa y se notifica al usuario
                            this.eliminarDato($scope.datoActual);
                            return 'Estampa Eliminiada';
                        };
		}]);
    
})();



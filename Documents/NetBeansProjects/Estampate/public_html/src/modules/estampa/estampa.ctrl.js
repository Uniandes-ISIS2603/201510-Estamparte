/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(){
    
    var app = angular.module('estampaModule');

	app.controller('estampaCtrl', ['$scope', 'CRUDUtils', 'estampa.context', function ($scope, CRUDUtils, context) {
			this.url = context;
			CRUDUtils.extendCtrl(this, $scope);
                        this.estampasSeleccionadas = [];
                        this.estampaDeArtista=false;
                        this.mostrarPop = false;
                        
                        $scope.datos = [
		{
			id: 1,
			nombre: "Estampa de la flor",
			autor: "elgenio",
			siGusta: 381,
			noGusta: 212
		},
		{
			id: 2,
			nombre: "El super fuego",
			autor: "elburro",
			siGusta: 121,
			noGusta: 1420
		},
		{
			id: 3,
			nombre: "Agua mas agua",
			autor: "elsa pato",
			siGusta: 3019,
			noGusta: 1425
		},
		{
			id: 4,
			nombre: "Come tierra",
			autor: "elsa pito",
			siGusta: 121,
			noGusta: 12
		}
	];
                        this.alertar = function(){alert('Click');};
                        this.eliminarEstampa = function(){
                            //Pre: se tiene en $scope.datoActual la estampa a eliminar
                            //Pos: se elimina la estampa y se notifica al usuario
                           
                            this.eliminarDato($scope.datoActual);
                            this.mostrarPop=true;
                          
                        };
                        
                        this.actualizarInformacion = function(){
                            //Pre: el modelo de la informacion responde al dato actual
                            //Pos: se guarda el dato actual que representa la estampa actualizada
                            this.guardarDato();
                        };
                        
                        this.registrarCalificacion = function(cal){
                            //Pre: se tiene la estampa en datoActual
                            //Pos: se califica la estampa
                            if(cal===1)
                                $scope.datoActual.rating = $scope.datoActual.rating+1;
                            else
                                $scope.datoActual.rating = $scope.datoActual.rating-1;
                            
                            this.guardarDato();
                        };
                        
                        this.agregarEstampaACamiseta = function(){
                            //Pre: Se tiene la estampa en datoActual
                            //Pos: al arreglo de datos se adiciona la estampa
                            this.estampasSeleccionadas.push($scope.datoActual);
                        };
                        
		}]);
            
        app.directive('estampa', function() {
                return {
                  templateUrl: 'src/modules/estampa/estampa.tpl.html'
                }
            });
    
})();


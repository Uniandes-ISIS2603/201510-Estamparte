/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(){
    
    var app = angular.module('estampaModule');

	app.controller('estampaCtrl', ['$scope', 'servicioEstampa','$rootScope', function ($scope, servicioEstampa,$rootScope) {
			
			servicioEstampa.extendCtrl(this, $scope);
                        this.estampasSeleccionadas = [];
                        this.estampaDeArtista=true;
                        this.mostrarPop = false;
                        datos = [
                        {
                                
                                nombre: "Estampa de la flor",
                                autor: "elgenio",
                                siGusta: 381,
                                noGusta: 212,
                                precio: 100
                        },
                        {
                               
                                nombre: "El super fuego",
                                autor: "elburro",
                                siGusta: 121,
                                noGusta: 1420,
                                precio: 100
                        },
                        {
                                
                                nombre: "Agua mas agua",
                                autor: "elsa pato",
                                siGusta: 3019,
                                noGusta: 1425,
                                precio: 100
                        },
                        {
                               
                                nombre: "Come tierra",
                                autor: "elsa pito",
                                siGusta: 121,
                                noGusta: 12,
                                precio: 100
                        }
                ];
                        for(var i=0;i<datos.length;i++){
                        $scope.datoActual=datos[i];
                        this.guardarDato();
                    }
                    
                        this.consultarDatos();
                        
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
                                $scope.datoActual.siGusta = $scope.datoActual.siGusta+1;
                            else
                                $scope.datoActual.noGusta = $scope.datoActual.noGusta+1;
                           
                            this.guardarDato();
                            this.consultarDatos();
                        };
                        
                        this.agregarEstampaACamiseta = function(){
                            //Pre: Se tiene la estampa en datoActual
                            //Pos: al arreglo de datos se adiciona la estampa
                            this.estampasSeleccionadas.push($scope.datoActual);
                        };
                        
                        this.cambiarPop = function(){
                            this.mostrarPop=!this.mostrarPop;
                        };
                        
		}]);
            
        
    
})();


/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(){
    
   var app = angular.module('artistaModule');

	app.controller('artistaCtrl', ['$scope', 'servicioArtista','servicioEstampa', function ($scope, servicioArtista,servicioEstampa) {
			servicioArtista.extendCtrl(this,$scope);
                        this.crearEstampaTpl = false;
                        
                        //Temas para la creacion de una estampa
                        temas=['TemaA','TemaB','TemaC'];
                        //Ids de las estampas
                        this.idEstampa = 1;
                        
                        this.popCrearEstampa= function(){
                            this.crearDato();
                            this.crearEstampaTpl=true;
                        };
                        
                        
                        this.crearEstampa = function(){
                            //Se obtiene la estampa a crear
                            var estampa = $scope.datoActual;
                            estampa.id = this.idEstampa;
                            //El usuario debe ser configurado en $scope!!!!
                            estampa.idAutor = $scope.idUsuario;
                            this.idEstampa = this.idEstampa + 1;
                            servicioEstampa.guardarDato(estampa);
                            $scope.datoActual=estampa;
                        };
                        
                        this.cancelarCrearEstampa = function(){
                            this.crearEstampaTpl=false;
                        };
                        
		}]);
    
})();



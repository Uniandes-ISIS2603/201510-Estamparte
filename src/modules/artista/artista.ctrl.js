/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(){
    
   var app = angular.module('artistaModule');

	app.controller('artistaCtrl', ['$scope', 'servicioArtista','servicioEstampa','$rootScope', function ($scope, servicioArtista,servicioEstampa,$rootScope) {
			servicioArtista.extendCtrl(this,$scope);
                        this.crearEstampaTpl = false;
                        this.editarEstampa=false;
                        
                        //Sesion temporal de usuario!!
                        $rootScope.idUsuario=1;
                        $rootScope.usuario="elgenio";
                        
                        //Temas para la creacion de una estampa
                        $scope.temas=['TemaA','TemaB','TemaC'];
                        
                        this.popCrearEstampa= function(){
                            this.crearDato();
                            this.crearEstampaTpl=true;
                            this.editarEstampa=false;
                        };
                        
                        
                        this.crearEstampa = function(){
                            //Se obtiene la estampa a crear
                            var estampa = $scope.datoActual;
                            //El usuario debe ser configurado en $rootScope!!!!
                            estampa.idAutor = $rootScope.idUsuario;
                            estampa.autor = $rootScope.usuario;
                            estampa.imagenes=[];
                            estampa.siGusta=0;
                            estampa.noGusta=0;
                            servicioEstampa.guardarDato(estampa);
                            servicioEstampa.consultarDatos();
                            $rootScope.datoActual=estampa;
                            servicioEstampa.consultarDatos();
                            this.popEditarEstampa();
                        };
                        
                        this.cancelarCrearEstampa = function(){
                            this.crearEstampaTpl=false;
                        };
                        
                        this.popEditarEstampa = function(){
                            this.crearEstampaTpl=false;
                            this.editarEstampa=true;
                        };
                        
                        

		}]);
    
})();



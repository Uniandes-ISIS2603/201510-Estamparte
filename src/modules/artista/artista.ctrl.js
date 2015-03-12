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

                            //El usuario debe ser configurado en $rootScope!!!!
                            $scope.datoActual.idAutor = $rootScope.idUsuario;
                            $scope.datoActual.autor = $rootScope.usuario;
                            $scope.datoActual.imagenes=[];
                            $scope.datoActual.siGusta=0;
                            $scope.datoActual.noGusta=0;
                            servicioEstampa.setEstampaCreada($scope.datoActual);
                            this.crearEstampaTpl=false;
                            this.editarEstampa=true;
                        };
                        
                        this.cancelarCrearEstampa = function(){
                            this.crearEstampaTpl=false;
                        };
                        
                        this.buscarEstampasPropias=function(){
                            servicioEstampa.estampasDeArtista().then(function(data){
                                $scope.datos=data;
                                var r=''
                                for(var i=0;i<data.length;i++){
                                   r=r+'Nombre de estampa: '+data[i].nombre+'\n ';
                                }
                                alert(r);
                            });
                        };
                        
                        

		}]);
    
})();



/* 
 *Controlador de artista
 */
(function(){
    
   var app = angular.module('artistaModule');

	app.controller('artistaCtrl', ['$scope', 'servicioArtista','servicioEstampa','$rootScope', function ($scope, servicioArtista,servicioEstampa,$rootScope) {
                        //Estension de servicios CRUD
			servicioArtista.extendCtrl(this,$scope);
                        
                        //Variables de visualizacion
                        this.crearEstampaTpl = false;
                        this.editarEstampa=false;
                        this.estampasPropias=false;
                        //Datos a usar en $scope
                        $scope.datos=[];
                        //Sesion temporal de usuario (debera ser configurada en el login)
                        $rootScope.idUsuario=1;
                        $rootScope.usuario="elgenio";
                        
                        //Temas para la creacion de una estampa (Temporales)
                        $scope.temas=['TemaA','TemaB','TemaC'];
                        
                        //Seccion de creacion de una estampa
                        this.popCrearEstampa= function(){
                            this.crearDato();
                            this.crearEstampaTpl=true;
                            this.editarEstampa=false;
                            this.estampasPropias=false;
                        };
                        
                        //Crea una nueva estampa y almacena en memoria
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
                            this.estampasPropias=false;
                        };
                        
                        //Cancela la operacion de creacion de estampa
                        this.cancelarCrearEstampa = function(){
                            this.crearEstampaTpl=false;
                            this.estampasPropias=false;
                            this.editarEstampa=false;
                        };
                        
                        //Busca las estampas del artista en sesion
                        this.buscarEstampasPropias=function(){
                            this.estampasPropias=true;
                            this.editarEstampa=false;
                            this.crearEstampaTpl=false;
                            servicioEstampa.estampasDeArtista().then(function(data){
                               $scope.datos=data;
                            });
                        };
                        
                        

		}]);
    
})();



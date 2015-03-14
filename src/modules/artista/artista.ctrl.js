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
                        this.estampasPropias=false;
                        this.subirImagenesNuevaEstampa=false;
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
                            this.estampasPropias=false;
                            this.subirImagenesNuevaEstampa=false;
                            $scope.datoActual.imagenes=[];
                        };
                        
                        //Crea una nueva estampa y almacena en memoria
                        this.crearEstampa = function(){
                                if($scope.datoActual.imagenes.length!==0){
                                //El usuario debe ser configurado en $rootScope!!!!
                                $scope.datoActual.idAutor = $rootScope.idUsuario;
                                $scope.datoActual.autor = $rootScope.usuario;
                                $scope.datoActual.siGusta=0;
                                $scope.datoActual.noGusta=0;
                                servicioEstampa.guardarDato($scope.datoActual);
                                this.crearEstampaTpl=false;
                                this.estampasPropias=false;
                                this.subirImagenesNuevaEstampa=false;
                                alert('Estampa '+$scope.datoActual.nombre+' guardada!');
                            }
                        };
                        
                        //Cancela la operacion de creacion de estampa
                        this.cancelarCrearEstampa = function(){
                            this.crearEstampaTpl=false;
                            this.estampasPropias=false;
                            this.subirImagenesNuevaEstampa=false;
                        };
                        
                        //Busca las estampas del artista en sesion
                        this.buscarEstampasPropias=function(){
                            this.estampasPropias=true;
                            this.crearEstampaTpl=false;
                            this.subirImagenesNuevaEstampa=false;
                            servicioEstampa.estampasDeArtista().then(function(data){
                               $scope.datos=data;
                            });
                        };
                        
                        //Sube imagenes a una nueva estampa
                        this.subirImagenesAEstampa=function(){
                            this.subirImagenesNuevaEstampa=true;
                            
                        };
                        
                        this.subirImg = function(){
                            
                            $scope.datoActual.imagenes.push($scope.datoActual.url);
                            delete $scope.datoActual.url;
                        };
                        
                        this.finSubirImg = function(){
                            this.subirImagenesNuevaEstampa=false;
                        };

		}]);
    
})();



/* 
 *Controlador de artista
 */
(function(){
    
   var app = angular.module('artistaModule');

	app.controller('artistaCtrl', ['$scope', '$upload','servicioEstampa','$rootScope','servicioArtista', function ($scope, $upload,servicioEstampa,$rootScope,servicioArtista) {
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
                                $scope.datoActual={};
                                alert('Estampa '+$scope.datoActual.nombre+' guardada!');
                            }
                        };
                        
                        //Cancela la operacion de creacion de estampa
                        this.cancelarCrearEstampa = function(){
                            this.crearEstampaTpl=false;
                            this.estampasPropias=false;
                            this.subirImagenesNuevaEstampa=false;
                            $scope.datoActual={};
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
                        
                        /*`primera forma de subir imagenes
                        $scope.$watch('files',function(){
                            $scope.upload($scope.files);
                        });
                        
                        $scope.upload=function(files){
                            if(files && files.length){
                                for(var i=0; i<files.length; i++){
                                    var file = files[i];
                                }
                            }
                        };
                        */
                       //Seguna forma
                        $scope.imageUpload = function(element){
                            var reader = new FileReader();
                            reader.onload = $scope.imageIsLoaded;
                            reader.readAsDataURL(element.files[0]);
                        };

                        $scope.imageIsLoaded = function(e){
                            $scope.$apply(function() {
                                $scope.datoActual.imagenes.push(e.target.result);
                            });
                        };

		}]);
    
})();



/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(){
    
    var app = angular.module('estampaModule');

	app.controller('estampaCtrl', ['$scope', 'servicioEstampa', '$rootScope', function ($scope, servicioEstampa, $rootScope) {
			
			servicioEstampa.extendCtrl(this, $scope);
                        $rootScope.estampasSeleccionadas = [];
                        this.mostrarPop = false;
                        this.editarEstampa=false;
                        this.informacion=true;
                        datos = [
                        {
                                
                                nombre: "Estampa de la flor",
                                idAutor: 1,
                                autor: "elgenio",
                                siGusta: 381,
                                noGusta: 212,
                                precio: 100,
                                imagenes: []
                        },
                        {
                               
                                nombre: "El super fuego",
                                idAutor: 1,
                                autor: "elgenio",
                                siGusta: 121,
                                noGusta: 1420,
                                precio: 100,
                                imagenes: []
                        },
                        {
                                
                                nombre: "Agua mas agua",
                                idAutor: 2,
                                autor: "elsa pato",
                                siGusta: 3019,
                                noGusta: 1425,
                                precio: 100,
                                imagenes: []
                        },
                        {
                               
                                nombre: "Come tierra",
                                idAutor: 3,
                                autor: "elsa pito",
                                siGusta: 121,
                                noGusta: 12,
                                precio: 100,
                                imagenes: []
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
                        
                        this.agregarEstampaACamiseta = function(estampa){
                            //Pre: Se tiene la estampa en datoActual
                            //Pos: al arreglo de datos se adiciona la estampa
                            alert('Agregada');
                            $rootScope.estampasSeleccionadas.push(estampa);
                        };
                        
                        this.cambiarPop = function(){
                            this.mostrarPop=!this.mostrarPop;
                        };
                        
                        this.editarEstampaSeleccionara=function(){
                            this.editarEstampa=true;
                            $scope.datoActual=$rootScope.datoActual;
                        };
                        
                        this.subirImagen=function(){
                            this.informacion=false;
                        };
                        
                        this.esDeArtista=function(){
                            //TODO
                        };
                        
                        this.subirImg=function(){
                            $scope.datoActual.imagenes.push($scope.datoActual.url);
                            delete $scope.datoActual.url;
                            this.guardarDato();
                            this.informacion=true;
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
            alert('Agregada');
            $rootScope.estampasSeleccionadas.push($scope.datoActual);
        };
        
        this.cambiarPop = function(){
            this.mostrarPop=!this.mostrarPop;
        };
        
        this.editarEstampaSeleccionara=function(){
            this.editarEstampa=true;
            $scope.datoActual=$rootScope.datoActual;
        };
        
        this.subirImagen=function(){
            this.informacion=false;
        };
        
        this.esDeArtista=function(){
            //TODO
        };
        
        this.subirImg=function(){
            $scope.datoActual.imagenes.push($scope.datoActual.url);
            delete $scope.datoActual.url;
            this.guardarDato();
            this.informacion=true;
        };
                        
	}]);

})();


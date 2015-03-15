/* 
 * Controlador de una estampa
 */
(function(){
    
    var app = angular.module('estampaModule');

	app.controller('estampaCtrl', ['$scope', 'servicioEstampa', '$location','$rootScope', function ($scope, servicioEstampa, $location,$rootScope) {
			
    	servicioEstampa.extendCtrl(this, $scope);
        $rootScope.estampasSeleccionadas = [];
        this.mostrarPop = false;
        this.editarEstampa=false;
        this.informacion=true;
        
        datos = [
            {  
                nombre: "Estampa de flor",
                idAutor: 1,
                autor: "elgenio",
                siGusta: 381,
                noGusta: 212,
                precio: 100,
                imagenes: [
                    'src/assets/img/estampa.jpg'
                ],
                tema: 'TemaA'
            },
            {  
                nombre: "El super fuego",
                idAutor: 1,
                autor: "elgenio",
                siGusta: 121,
                noGusta: 1420,
                precio: 100,
                imagenes: [
                    'src/assets/img/estampa.jpg'
                ],
                tema: 'TemaA'
            },
            {
                nombre: "Agua mas agua",
                idAutor: 2,
                autor: "elsa pato",
                siGusta: 3019,
                noGusta: 1425,
                precio: 100,
                imagenes: [
                    'src/assets/img/estampa.jpg'
                ]
            },
            {  
                nombre: "Estampa de amor",
                idAutor: 1,
                autor: "crash",
                siGusta: 1381,
                noGusta: 712,
                precio: 100,
                imagenes: [
                    'src/assets/img/estampa.jpg'
                ]
            },
            {
                nombre: "Agua mas amarillo",
                idAutor: 2,
                autor: "pedro mar",
                siGusta: 656,
                noGusta: 978,
                precio: 100,
                imagenes: [
                    'src/assets/img/estampa.jpg'
                ]
            },
            {  
                nombre: "El super bombero",
                idAutor: 1,
                autor: "elma sato",
                siGusta: 912,
                noGusta: 1029,
                precio: 100,
                imagenes: [
                    'src/assets/img/estampa.jpg'
                ],
                tema: 'TemaA'
            }
        ];

        for(var i=0;i<datos.length;i++){
            $scope.datoActual=datos[i];
            this.guardarDato();
        }
    
     
        this.eliminarEstampa = function(){
            //Pre: se tiene en $scope.datoActual la estampa a eliminar
            //Pos: se elimina la estampa y se notifica al usuario                          
            this.eliminarDato($scope.datoActual);
            this.mostrarPop=true;
          
        };
        
        this.registrarCalificacion = function(cal){
            //Pre: se tiene la estampa en datoActual
            //Pos: se califica la estampa
           
            if(cal===1)
                $scope.datoActual.siGusta = $scope.datoActual.siGusta+1;
            else
                $scope.datoActual.noGusta = $scope.datoActual.noGusta+1;
           
            this.guardarDato();

        };
        
        this.agregarEstampaACamiseta = function(estampa){
            //Pre: Se tiene la estampa en datoActual
            //Pos: al arreglo de datos se adiciona la estampa
            estampa.seleccionada=true;
            servicioEstampa.addEstampaSeleccionada(estampa);
            
        };
        
        this.cambiarPop = function(){
            this.mostrarPop=!this.mostrarPop;
        };
        
        this.editarEstampaSeleccionada=function(){
            this.editarEstampa=true;
            $scope.datoActual=servicioEstampa.estampaSeleccionada;
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
            this.informacion=true;
        };

        this.actualizarInformacion = function(){
            //Pre: el modelo de la informacion responde al dato actual
            //Pos: se guarda el dato actual que representa la estampa actualizada
            this.guardarDato();
            $location.path('/');
            $scope.datos=[];
            this.consultarDatos();
        };
                        
	}]);
    

})();


angular.module('estampaModule')
.controller('estampaCtrl', ['$scope', 'servicioEstampa','$rootScope', function ($scope, servicioEstampa, $rootScope) {
		
    // Extension de los servicion del CRUD.

	servicioEstampa.extendCtrl(this, $scope);

    // Variables de visualizacion.

    this.detalle=false;
    this.informacion=true;

    // Habilita los tooltip de Bootstrap.

    angular.element('[data-toggle="tooltip"]').tooltip();
    
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
            ],
            tema: 'TemaA'
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
            ],
            tema: 'TemaA'
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
            ],
            tema: 'TemaA'
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

    this.mostrarDetalle=function(estampaSeleccionada){
        this.detalle=!this.detalle;
        this.editarEstampa=false;
        this.informacion=true;
        $scope.datoActual=estampaSeleccionada;
    };
 
    this.eliminarEstampa = function(){
        //Pre: se tiene en $scope.datoActual la estampa a eliminar
        //Pos: se elimina la estampa y se notifica al usuario                          
        this.eliminarDato($scope.datoActual);
      
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

        servicioEstampa.addEstampaSeleccionada(estampa);
        
    };
    
    this.editarEstampaSeleccionada=function(){
        this.informacion=false;
        $scope.datoActual=servicioEstampa.estampaSeleccionada;
    };
    
    this.subirImagen=function(){
        this.informacion=false;
    };
    
    this.esDeArtista=function(){
        return $scope.datoActual.idAutor === $rootScope.idUsuario;
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
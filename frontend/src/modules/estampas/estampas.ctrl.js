angular.module('estampasModule')
.controller('estampasCtrl', ['$scope', 'servicioEstampa', 'servicioMisestampas', function ($scope, servicioEstampa, servicioMisestampas) {

    var _this = this;

    servicioEstampa.extendCtrl(_this, $scope);

    _this.consultarDatos();

	$scope.prueba = [
        {  
            nombre: "Estampa de flor",
            idAutor: 1,
            autor: "elgenio",
            siGusta: 381,
            noGusta: 212,
            precio: 100,
            imagenes: [
                'src/assets/img/estampa.jpg'
            ]
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
            ]
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
            ]
        },
        {
            nombre: "Agua mas tierra",
            idAutor: 2,
            autor: "pedro guz",
            siGusta: 656,
            noGusta: 978,
            precio: 100,
            imagenes: [
                'src/assets/img/estampa.jpg'
            ]
        },
        {  
            nombre: "El super perro",
            idAutor: 1,
            autor: "elma lote",
            siGusta: 912,
            noGusta: 1029,
            precio: 100,
            imagenes: [
                'src/assets/img/estampa.jpg'
            ]
        }
    ];

    this.agregarPrueba = function() {
        for (var i = 0; i < $scope.prueba.length; i++) {
            var estampa = $scope.prueba[i];
            this.editarDato(estampa);
            this.guardarDato();
        }
    }
    this.agregarPrueba();

    $scope.darAnchoEstampa = function (index) {
        var ans = '';

        if ($scope.datos.length - index >= 3) {
            ans = 'col-md-4';
        } else if ($scope.datos.length - index == 2) {
            ans = 'col-md-6';
        } else {
            ans = 'col-md-12';
        }

        return ans;
    }

    _this.verMisEstampas = function () {
        var misestampas = angular.element('#misestampas');
        if (misestampas.css('display') === 'none')
            misestampas.animate({width: 'toggle'});
    }

    $scope.busquedaAvanzada = function () {
        alert('Busqueda avanzada disponible pronto, esperala!');
    }

    $scope.agregar = function (estampa) {
        _this.editarDato(estampa);

        servicioMisestampas.guardarDato($scope.datoActual);

        _this.guardarDato();
        _this.verMisEstampas();
    }

    $scope.gusta = function (estampa, seleccion) {
        _this.editarDato(estampa);

        if (seleccion === 'si')
            $scope.datoActual.siGusta += 1;
        else if (seleccion === 'no')
            $scope.datoActual.noGusta += 1
        
        _this.guardarDato();
    }

}]);
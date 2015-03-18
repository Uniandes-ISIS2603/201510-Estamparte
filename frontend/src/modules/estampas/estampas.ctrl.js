angular.module('estampasModule')
.controller('estampasCtrl', ['$scope', function ($scope) {

	$scope.estampas = [
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

    $scope.darAnchoEstampa = function (index) {
        var ans = '';

        if ($scope.estampas.length - index >= 3) {
            ans = 'col-md-4';
        } else if ($scope.estampas.length - index == 2) {
            ans = 'col-md-6';
        } else {
            ans = 'col-md-12';
        }

        return ans;
    };

}]);
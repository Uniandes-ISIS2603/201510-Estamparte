(function () {	
	var app = angular.module('estampasModule');

	app.controller('estampasCtrl', ['$scope', 'servicioEstampa', 'servicioMisestampas', function ($scope, servicioEstampa, servicioMisestampas) {

		var _this = this;

		servicioEstampa.extendCtrl(_this, $scope);

		_this.fetchRecords();

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

		_this.agregarPrueba = function () {
			for (var i = 0; i < $scope.prueba.length; i++) {
				var estampa = $scope.prueba[i];
				_this.editRecord(estampa);
				_this.saveRecord();
			}
		}
		_this.agregarPrueba();

		$scope.darAnchoEstampa = function (index) {
			var ans = '';

			if ($scope.records.length - index >= 3) {
				ans = 'col-md-4';
			} else if ($scope.records.length - index == 2) {
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
			servicioMisestampas.agregar(estampa);
			_this.verMisEstampas();
		}

		$scope.gusta = function (estampa, seleccion) {
			_this.editRecord(estampa);

			if (seleccion === 'si')
				$scope.currentRecord.siGusta += 1;
			else if (seleccion === 'no')
				$scope.currentRecord.noGusta += 1
			
			_this.saveRecord();
		}

	}]);
})();
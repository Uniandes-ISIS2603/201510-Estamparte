(function () {	
	var app = angular.module('camisetaModule');

	app.controller('camisetaCtrl', ['$scope', '$window', 'servicioCamiseta', function ($scope, $window, servicioCamiseta) {

		$scope.list3 = ['s'];

		// Extension de servicios CRUD.

		servicioCamiseta.extendCtrl(this, $scope);

		// Estilos para el formulario.

		$scope.estilos = [
			{
				id: 1,
				nombre: 'Manga corta'
			},
			{
				id: 2,
				nombre: 'Manga larga'
			},
			{
				id: 3,
				nombre: 'Sin mangas'
			}
		];

		$scope.estilo = $scope.estilos[0].id;

		$scope.darCamisa = function (estampa) {
			var respuesta = 'src/assets/img/camiseta/%s.png'.replace('%s', estampa);
			return respuesta;
		}

		// Tallas para el formulario.

		$scope.tallas = [
			{
				id: 1,
				nombre: 'XS'
			},
			{
				id: 2,
				nombre: 'S'
			},
			{
				id: 3,
				nombre: 'M'
			},
			{
				id: 4,
				nombre: 'L'
			},
			{
				id: 5,
				nombre: 'XL'
			}
		];

		$scope.talla = $scope.tallas[0].id;

		// Colores para el formulario.

		$scope.colores = [
			{
				id: 1,
				nombre: 'Amarillo'
			},
			{
				id: 2,
				nombre: 'Azul'
			},
			{
				id: 3,
				nombre: 'Verde'
			},
			{
				id: 4,
				nombre: 'Morado'
			},
			{
				id: 5,
				nombre: 'Rojo'
			}
		];

		$scope.color = $scope.colores[0].id;

		$scope.darColor = function (color) {
			var valores = [
				'rgba(255, 255, 000, 0.6)',
				'rgba(000, 000, 255, 0.6)',
				'rgba(000, 255, 000, 0.6)',
				'rgba(255, 000, 255, 0.6)',
				'rgba(255, 000, 000, 0.6)',
			];

			return valores[color-1];
		}

		// Estilo de la vista previa.

		$scope.estilocamiseta = {}

		$scope.darEstilo = function () {
			$scope.estilocamiseta = {
				'background-color': $scope.darColor($scope.color) + '',
				'background-image': 'url("' + $scope.darCamisa($scope.estilo) + '")'
			}
		};

		// Configuracion visual.

		var w = angular.element($window);
		w.bind('resize', function() {
			alinearAltura();
		})

		alinearAltura();
		function alinearAltura() {
			var inicio = angular.element('#vistaprevia');
			var altura = Math.max(w.height() - 250, 480);
			inicio.height(altura);

			var propiedades = angular.element('#propiedades');
			propiedades.height(inicio.height());
		}

		$scope.estiloEstampa = function (estampa) {
			var id = '#estampa' + estampa.estampa.id;
			var li = angular.element(id);
			var style = {
				'list-style': 'none',
				'position': 'absolute',
				'top': estampa.coordy,
				'left': estampa.coordx,
				'height': estampa.height,
			};

			return style;
		}

		$scope.estiloImagen = function (estampa) {
			var id = '#estampaimg' + estampa.estampa.id;
			var img = angular.element(id);
			var style = {
				'height': estampa.height,
			}

			return style;
		}

		// Configuracion del boton del mouse.

		$scope.configurarBoton = function (estampa) {
			var id = '#estampa' + estampa.estampa.id;
			var estampa = angular.element(id);
			console.log(estampa);
			estampa.mousedown(function () {
				alert('estampa presionada');
			});
		}

		// Datos de las estampas agregadas.

		$scope.records = servicioCamiseta.darEstampas();

		// $scope.datoActual.camiseta.estampasUsadas = [];
		// $scope.datoActual.camiseta.idCamiseta;
		// $scope.datoActual.camiseta.nombreCamiseta;

		// this.contiene = function (id) {
		// 	var respuesta = false;
		// 	var estampasUsadas = $scope.datoActual.camiseta.estampasUsadas;

		// 	for (var i = 0; i < estampasUsadas.length; i++) {
		// 		if ($scope.datoActual.estampasUsadas[i] === id) {
		// 			respuesta = true;
		// 		}
		// 	}

		// 	return respuesta;
		// }

		// this.agregarEstampa = function (id) {
		// 	$scope.datoActual.camiseta.estampasUsadas.push(id);
		// }

		// this.eliminarEstampa = function (id) {
		// 	var encontrado = false;
		// 	var estampasUsadas = $scope.datoActual.camiseta.estampasUsadas;

		// 	for (var i = 0; i < estampasUsadas.length && !encontrado; i++) {
		// 		if (estampasUsadas[i] === id) {
		// 			estampasUsadas.splice(i, 1);
		// 			encontrado = true
		// 		}
		// 	}
		// }

		// this.estampasSeleccionadas = function() {
		// 	return servicioEstampa.darEstampasSeleccionadas();
		// }

		// this.cadenaAleatoria = function (longitud) {
		// 	var numeros = '0123456789';
		// 	var mayusculas = 'ABCDEFGHIJKLMNOPQRSTUVWXTZ';
		// 	var minusculas = 'abcdefghiklmnopqrstuvwxyz';
		// 	var caracteres = (numeros + mayusculas + minusculas).split('');

		// 	if (longitud === null) {
		// 		longitud = 0;
		// 	}

		// 	var respuesta = '';
		// 	for (var i = 0; i < longitud; i++) {
		// 		var index = Math.floor(Math.random() * chars.length);
		// 		respuesta += caracteres[index];
		// 	}

		// 	return respuesta;
		// }

		// this.continuar = function () {
		// 	$scope.datoActual.camiseta.idCamiseta = "C"+ this.randomString(10);

		// 	var mensaje = "";
		// 	var estampasUsadas = $scope.datoActual.camiseta.estampasUsadas;

		// 	for (var i = 0; i < estampasUsadas.length; i++) {
		// 		if (estampasUsadas[i]) {
		// 			mensaje += (i + 1) + ")" + estampasUsadas[i].valueOf() + "\n\t";
		// 		}
		// 	}

		// 	alert(mensaje);

		// 	//servicioCamiseta.agregarCamiseta($scope.datoActual.camiseta);
		// }

	}]);
})();
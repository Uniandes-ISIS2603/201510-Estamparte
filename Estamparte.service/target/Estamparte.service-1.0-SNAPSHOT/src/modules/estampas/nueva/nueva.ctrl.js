(function () {
	var app = angular.module('nuevaModule');

	app.controller('nuevaCtrl', ['$scope', 'FileUploader', 'estampasService', function ($scope, FileUploader, servicioEstampa) {

		// Mantiene la estampa a crear.

		$scope.currentRecord = {};

		// Cola de imagenes a cargar.

		$scope.uploader = new FileUploader();

		// Permite solo un elemento en la cola.

		$scope.uploader.onAfterAddingFile = function (item) {
			if ($scope.uploader.queue.length > 1) {
				$scope.uploader.removeFromQueue(0);
			}
			$scope.noImagen = false;
		}

		// Muestra la imagen de la nueva estampa.

		$scope.darImagen = function () {
			if ($scope.currentRecord.imagenes)
				return $scope.currentRecord.imagenes[0];
			else
				return '';
		}

		// Comprueba que haya alguna imagen seleccionada.

		$scope.noImagen = true;

		// Crea la estampa

		$scope.crearEstampa = function () {

			// Agrega los datos extra a la estampa.

			$scope.currentRecord.idAutor = 4;
			$scope.currentRecord.autor = 'elma lote';
			$scope.currentRecord.siGusta = 0;
			$scope.currentRecord.noGusta = 0;
			$scope.currentRecord.imagenes = [
				'src/assets/img/estampa.jpg'
			];

			// Guarda la estampa.

			servicioEstampa.saveRecord($scope.currentRecord).then( function () {

				// Limpia el Queue (mas adelante subira imagen).

				$scope.uploader.clearQueue();

				// Limpia los datos de formulario para el dato actual.

				$scope.currentRecord.nombre = "";
				$scope.currentRecord.precio = "";
				$scope.currentRecord = {};

				// Oculta el panel para crear estampa.

				angular.element('#nueva').animate({width: 'toggle'});

			});
		}

	}]);
})();
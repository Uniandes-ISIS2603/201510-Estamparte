(function () {
	angular.module('estampasModule')
	.service('estampasService', estampasService);

	function estampasService(crudService) {

		var _this = this;

		// Here we extend our service.
        crudService.extendService(_this, 'estampas', null);

        // Some test data.
		testEstampas();
		function testEstampas() {
			var testEstampas = [
				{  
					nombre: 'Estampa de flor',
					idAutor: 1,
					autor: 'elgenio',
					siGusta: 381,
					noGusta: 212,
					precio: 100,
					imagenes: [
						'src/assets/img/estampa.jpg'
					]
				},
				{  
					nombre: 'El super fuego',
					idAutor: 1,
					autor: 'elgenio',
					siGusta: 121,
					noGusta: 1420,
					precio: 100,
					imagenes: [
						'src/assets/img/estampa.jpg'
					]
				},
				{
					nombre: 'Agua mas agua',
					idAutor: 2,
					autor: 'elsa pato',
					siGusta: 3019,
					noGusta: 1425,
					precio: 100,
					imagenes: [
						'src/assets/img/estampa.jpg'
					]
				},
				{  
					nombre: 'Estampa de amor',
					idAutor: 1,
					autor: 'crash',
					siGusta: 1381,
					noGusta: 712,
					precio: 100,
					imagenes: [
						'src/assets/img/estampa.jpg'
					]
				},
				{
					nombre: 'Agua mas amarillo',
					idAutor: 2,
					autor: 'pedro mar',
					siGusta: 656,
					noGusta: 978,
					precio: 100,
					imagenes: [
						'src/assets/img/estampa.jpg'
					]
				},
				{  
					nombre: 'El super bombero',
					idAutor: 1,
					autor: 'elma sato',
					siGusta: 912,
					noGusta: 1029,
					precio: 100,
					imagenes: [
						'src/assets/img/estampa.jpg'
					]
				},
				{
					nombre: 'Agua mas tierra',
					idAutor: 2,
					autor: 'pedro guz',
					siGusta: 656,
					noGusta: 978,
					precio: 100,
					imagenes: [
						'src/assets/img/estampa.jpg'
					]
				},
				{  
					nombre: 'El super perro',
					idAutor: 1,
					autor: 'elma lote',
					siGusta: 912,
					noGusta: 1029,
					precio: 100,
					imagenes: [
						'src/assets/img/estampa.jpg'
					]
				}
			];
			angular.forEach(testEstampas, post);
			function post(value, index) {
				_this.postBasic(value);
			}
		}
	}
})();
angular.module('equipoModule', [])
.controller('equipoCtrl', ['$scope', function($scope) {

	$scope.miembros = [
		{
			nombre: 'Juan Camilo Bages',
			rol: 'Lider de soporte',
			foto: 'src/assets/img/equipo/juancamilo.jpg'
		},
		{
			nombre: 'Nicolas Castro',
			rol: 'Lider de calidad',
			foto: 'src/assets/img/equipo/nicolas.jpg'
		},
		{
			nombre: 'Juan Sebastian Martinez',
			rol: 'Lider general',
			foto: 'src/assets/img/equipo/juansebastian.jpg'
		},
		{
			nombre: 'Samuel Salazar',
			rol: 'Lider de desarrollo',
			foto: 'src/assets/img/equipo/samuel.jpg'
		},
		{
			nombre: 'Meili Vanegas',
			rol: 'Lider de planeacion',
			foto: 'src/assets/img/equipo/meili.jpg'
		}
	]

	$scope.agregarFoto = function (index, foto) {
		$('.miembro-foto')[index].css('background-image', 'url("%s")'.replace("%s", foto))
	}

}])
.directive('equipo', function() {
	return {
		templateUrl: 'src/modules/equipo/equipo.tpl.html'
	};
});
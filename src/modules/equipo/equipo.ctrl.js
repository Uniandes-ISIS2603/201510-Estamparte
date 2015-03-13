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
	];

	$scope.agregarFoto = function (index, foto) {
		var id = '#miembro%d'.replace('%d', index);
		$(id).css('background-image', 'url("%s")'.replace("%s", foto));
		console.log($(id));
	};

	$scope.darAncho = function (length) {
		var ans = ''
		if ($scope.miembros.length - length >= 3)
			ans = 'col-md-4';
		else if ($scope.miembros.length - length == 2)
			ans = 'col-md-6';
		else
			ans = 'col-md-12';
		return ans;
	};

}])
.directive('equipo', function() {
	return {
		templateUrl: 'src/modules/equipo/equipo.tpl.html'
	};
});
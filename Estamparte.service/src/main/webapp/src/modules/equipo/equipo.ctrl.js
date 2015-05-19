(function () {	
	angular.module('equipoModule')
	.controller('equipoController', equipoController);

	function equipoController() {

		var _this = this;

		_this.members = [
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

		_this.getMemberWidth = getMemberWidth;

		function getMemberWidth(index) {
			var ans = '';
			if (_this.members.length - index >= 3) {
				ans = 'col-md-4';
			} else if (_this.members.length - index == 2) {
				ans = 'col-md-6';
			} else {
				ans = 'col-md-12';
			}
			return ans;
		}
	}
})();
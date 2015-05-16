(function () {	
	angular.module('registrarseModule')
	.controller('registrarseController', registrarseController);

	function registrarseController(usuarioService) {

		var _this = this;

		_this.options = [ 
			'artista',
			'comprador'
		];

		_this.option = 'artista';

		_this.signupArtista = {};
		_this.signupComprador = {};

		_this.signup = signup;

		function signup() {
			if (_this.option === 'artista')
				usuarioService.signup(_this.signupArtista, _this.option, callback);
			else if (_this.option === 'comprador')
				usuarioService.signup(_this.signupComprador, _this.option, callback);
			function callback() {
				_this.signupArtista = {};
				_this.signupComprador = {};
				angular.element('#registrarse').animate({width: 'toggle'});
			}
		}
	}
})();
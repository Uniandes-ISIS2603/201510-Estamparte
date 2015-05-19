(function () {	
	angular.module('loginModule')
	.controller('loginController', loginController);

	function loginController(usuarioService) {

		var _this = this;

		_this.usr = {};

		_this.login = login;

		_this.msg = '';

		function login() {
			usuarioService.login(_this.usr, callback);
			function callback(ans) {
				if (ans === null) _this.msg = 'No encontramos tu usuario!';
				else {
					_this.usr = {};
					_this.msg = '';
					angular.element('#iniciarsesion').animate({width: 'toggle'});
				}
			}
		}
	}
})();
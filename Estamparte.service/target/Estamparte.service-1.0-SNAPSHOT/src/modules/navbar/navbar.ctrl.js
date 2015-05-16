(function () {
	angular.module('navbarModule')
	.controller('navbarController', navbarController);
	
	function navbarController(usuarioService,$rootScope) {
            $rootScope.usuario = { nombre: "Samuel", tipo: "artista" }

		var _this = this;

		// Bootstrap tooltip initialization.
		angular.element('[data-toggle="tooltip"]').tooltip();

		// Here we save the current window position.
		_this.actualDiv = 'inicio';

		// Here we save all the existing panels.
		_this.panels = [
			'carrito',
			'misestampas',
			'nueva',
			'formapago',
			'adminestampas',
			'factura',
			'iniciarsesion',
			'registrarse'
		];

		_this.getActualStatus = getActualStatus;

		_this.getActualDiv = getActualDiv;
		_this.setActualDiv = setActualDiv;

		_this.slidePanel = slidePanel;
		_this.showPanel = showPanel;
		_this.hidePanel = hidePanel;
		_this.hideAllPanels = hideAllPanels;

		_this.isType = isType;
		_this.getUserName = getUserName;
		_this.logout = logout;

		// Returns active is the actualDiv is
		// equals to the one given by arg,
		// otherwise returns an empty string.
		function getActualStatus(div) {
			return (_this.actualDiv === div) ? 'active' : '';
		}

		// Returns the window current position.
		function getActualDiv() {
			return _this.actualDiv;
		}

		// Change the window current position and
		// the nav section that represents it.
		function setActualDiv(actualDiv) {
			_this.actualDiv = actualDiv;

			angular.element('html, body').animate({
				scrollTop: angular.element('#' + actualDiv).offset().top
			}, 700);

			if (actualDiv === 'camiseta') {
				showPanel('misestampas');
			} else {
				hidePanel('misestampas');
			}
		}

		// Shows or hide a panel depending
		// on it's visibility.
		function slidePanel(panel) {
			var div = angular.element('#'+panel);
			if (div.css('display') === 'none')
				showPanel(panel);
			else
				hidePanel(panel);
		}

		// Show a right panel with an slide
		// animation that makes it visible.
		function showPanel(panel) {
			hideAllPanels();
			angular.element('#'+panel).animate({width: 'toggle'});
		}

		// Hide a right panel with an slide
		// animation that makes it nonvisible.
		function hidePanel(panel) {
			var div = angular.element('#'+panel);
			if (div.css('display') !== 'none')
				div.animate({width: 'toggle'});
		}

		// Iterate over all the existing panels
		// calling the hidePanel function on each one.
		function hideAllPanels() {
			angular.forEach(_this.panels, hide);
			function hide(value, index) {
				hidePanel(value);
			}
		}

		// Returns either true or false depending
		// on if the given type is equals to the logged
		// user's type. If there is no user, returns false.
		function isType(userType) {
			return usuarioService.getType() === userType;
		}

		// Returns the logged username, if there
		// is no user, returns an empty string.
		function getUserName() {
			return usuarioService.getName();
		}

		// Make the logout procedure.
		function logout() {
			return usuarioService.logout();
		}
	}
})();
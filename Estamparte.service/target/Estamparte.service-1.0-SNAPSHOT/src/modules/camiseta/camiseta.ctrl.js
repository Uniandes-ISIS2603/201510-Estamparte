(function () {	
	angular.module('camisetaModule')
	.controller('camisetaController', camisetaController);

	function camisetaController($window, camisetaService, carritoService) {

		var _this = this;

		// Hold the camisetaService tshirt.
		_this.tshirt = camisetaService.tshirt;

		// The tshirt CSS style.
		_this.CSS = camisetaService.CSS;

		// Tshirt styles.
		_this.styles = camisetaService.styles;

		// Tshirt sizes.
		_this.sizes = camisetaService.sizes;

		// Tshirt colors.
		_this.colors = camisetaService.colors;

		_this.addCamisetaCarrito = addCamisetaCarrito;
		_this.setCSS = setCSS;
		_this.estampaCSS = estampaCSS;

		// Adds the current tshirt to carrito.
		function addCamisetaCarrito() {
			if (_this.tshirt.id) {
				carritoService.putCustom(_this.tshirt).then(camisetaService.setTshirtDefaults);
			} else {
				_this.tshirt.cantidad = 1;
				carritoService.postCustom(_this.tshirt).then(camisetaService.setTshirtDefaults);
			}
		}

		// Set the CSS Attribute depending on
		// the given object properties.
		function setCSS() {
			camisetaService.setCSS();
		}

		// Set the CSS attribute depending on
		// the given object properties.
		function estampaCSS(target) {
			camisetaService.estampaCSS(target);
		}

		// Visual accomodations.
		var w = angular.element($window);
		w.bind('resize', resize);

		resize();
		function resize() {
			var div = angular.element('#vistaprevia');
			var height = Math.max(w.height() - 250, 480);
			div.height(height);

			var properties = angular.element('#propiedades');
			properties.height(div.height());
		}
	}
})();
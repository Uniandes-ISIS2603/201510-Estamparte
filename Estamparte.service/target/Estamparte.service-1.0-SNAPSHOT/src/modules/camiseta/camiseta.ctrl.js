(function () {	
	angular.module('camisetaModule')
	.controller('camisetaController', camisetaController);

	function camisetaController($window, camisetaService, carritoService, usuarioService) {

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
		_this.isType = isType;

		// Get the user type
		function isType(target) {
			return usuarioService.getType() === target;
		}

		// Adds the current tshirt to carrito.
		function addCamisetaCarrito() {
			var id = usuarioService.getCarrito();
			var clone = setupClone();
			if (clone.id) {
				carritoService.putCustom(clone, id).then(camisetaService.setTshirtDefaults);
			} else {
				carritoService.postCustom(clone, id).then(camisetaService.setTshirtDefaults);
			}
		}

		// Makes a clone and fix estampas array.
		function setupClone() {
			var estampas = []
			var clone = JSON.parse(JSON.stringify(_this.tshirt));
			angular.forEach(clone.estampas, set);
			function set(value, index) { estampas.push(value.id); }
			clone.estampas = estampas;
			clone.cantidad = 1;
			return clone;
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
(function () {	
	angular.module('camisetaModule')
	.controller('camisetaController', camisetaController);

	function camisetaController($window, camisetaService) {

		var _this = this;

		// Some T-shirt styles.
		_this.styles = [
			{ id: 1, nombre: 'Manga corta' },
			{ id: 2, nombre: 'Manga larga' },
			{ id: 3, nombre: 'Sin mangas'  }
		];

		// T-shirt sizes
		_this.sizes = [
			{ id: 1, nombre: 'XS' },
			{ id: 2, nombre: 'S'  },
			{ id: 3, nombre: 'M'  },
			{ id: 4, nombre: 'L'  },
			{ id: 5, nombre: 'XL' }
		];

		// T-shirt colors.
		_this.colors = [
			{ id: 1, nombre: 'Amarillo' },
			{ id: 2, nombre: 'Azul'     },
			{ id: 3, nombre: 'Verde'    },
			{ id: 4, nombre: 'Morado'   },
			{ id: 5, nombre: 'Rojo'     }
		];

		// This is the current T-shirt.
		_this.tshirt = {
			color: _this.colors[0].id,
			talla:  _this.sizes[0].id,
			estilo: _this.styles[0].id
		};

		// The T-shirt preview style.
		_this.CSS = {};

		_this.getColor = getColor;
		_this.getCamiseta = getCamiseta;
		_this.setCSS = setCSS;
		_this.estampaCSS = estampaCSS;
		_this.getPrice = getPrice;

		// Returns the corresponding rgba CSS
		// property for a given color id.
		function getColor(id) {
			var vals = [
				'rgba(255, 255, 000, 0.6)',
				'rgba(000, 000, 255, 0.6)',
				'rgba(000, 255, 000, 0.6)',
				'rgba(255, 000, 255, 0.6)',
				'rgba(255, 000, 000, 0.6)',
			];
			return vals[id-1];
		}

		// Returns the corresponding T-shirt image
		// depending on the actually chosen style.
		function getCamiseta(style) {
			var respuesta = 'src/assets/img/camiseta/%s.png'.replace('%s', style);
			return respuesta;
		}

		// Assign the CSS variable with the
		// corresponding T-shirt values.
		function setCSS() {
			_this.CSS = {
				'background-color': getColor(_this.tshirt.color) + '',
				'background-image': 'url("' + getCamiseta(_this.tshirt.estilo) + '")'
			};
		}

		// Returns the CSS style for a
		// giver estampa object for preview.
		function estampaCSS(target) {
			var css = {
				'list-style': 'none',
				'position': 'absolute',
				'top': target.coordy,
				'left': target.coordx,
				'height': target.height,
			};
			return css;
		}

		// Returns the tshirt price based
		// on the objects added
		function getPrice() {
			// TODO
			return 0;
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
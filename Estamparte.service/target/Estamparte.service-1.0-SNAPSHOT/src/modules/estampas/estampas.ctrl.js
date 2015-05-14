(function () {	
	var app = angular.module('estampasModule');

	app.controller('estampasController', estampasController);

	function estampasController(estampasService) {

		var _this = this;

		// Hold records from estampas.
		_this.estampasRecords = estampasService.records;

		_this.getItemWidth = getItemWidth;
		_this.advancedSearch = advancedSearch;

		function getItemWidth(index) {
			var ans = '';
			if (_this.estampasRecords.basicRecords.length - index >= 3) {
				ans = 'col-md-4';
			} else if (_this.estampasRecords.basicRecords.length - index == 2) {
				ans = 'col-md-6';
			} else {
				ans = 'col-md-12';
			}
			return ans;
		}

		function advancedSearch() {
			alert('Busqueda avanzada disponible pronto, esperala!');
		}
	}
})();
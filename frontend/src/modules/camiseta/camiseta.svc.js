(function () {	
	var app = angular.module('camisetaModule');

	app.service('servicioCamiseta', ['CRUDUtils', 'camiseta.context', function (CRUDUtils, context) {

		CRUDUtils.extendService(this);

		this.url = context;
		
		this.camisetas = [];
		
		this.darCamisetas = function() {
			return this.camisetas;
		};
		
		this.agregarCamiseta = function(camiseta) {
		   this.camisetas.push(camiseta);
		};
		
	}]);
})();
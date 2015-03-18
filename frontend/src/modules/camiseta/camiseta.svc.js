angular.module('camisetaModule')
.service('servicioCamiseta', ['CRUDUtils', 'camiseta.context', function (CRUDUtils, context) {

	// Extension de los servicios del CRUD.

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

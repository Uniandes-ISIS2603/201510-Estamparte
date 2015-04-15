(function () {	
	var app = angular.module('compradorModule');

	app.service('servicioComprador', ['CRUDUtils', 'comprador.context', function (CRUDUtils, context) {
		this.url = context;
		CRUDUtils.extendService(this);
	}]);
})();
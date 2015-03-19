(function () {	
	var app = angular.module('artistaModule');

	app.service('servicioArtista', ['CRUDUtils', 'artista.context', function (CRUDUtils, context) {
		this.url = context;
		CRUDUtils.extendService(this);
	}]);
})();
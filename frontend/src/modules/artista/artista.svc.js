angular.module('artistaModule')
.service('servicioArtista', ['CRUDUtils', 'artista.context', function (CRUDUtils,context) {
	this.url = context;
	CRUDUtils.extendService(this);
}]);



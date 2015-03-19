angular.module('misestampasModule')
.service('servicioMisestampas', ['CRUDUtils', 'misestampas.context', function (CRUDUtils, context) {

	this.url = context;

	CRUDUtils.extendService(this);

}]);
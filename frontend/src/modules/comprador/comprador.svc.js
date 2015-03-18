angular.module('compradorModule')
.service('servicioComprador', ['CRUDUtils', 'comprador.context', function (CRUDUtils, context) {
	this.url = context;
	CRUDUtils.extendService(this);
}]);
(function () {
	var app = angular.module('misestampasModule');

	app.service('servicioMisestampas', ['CRUDUtils', 'misestampas.context', function (CRUDUtils, context) {

		this.url = context;

		CRUDUtils.extendService(this);

	}]);
})();	
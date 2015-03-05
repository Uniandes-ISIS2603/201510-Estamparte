(function () {
	var app = angular.module('formaPagoModule');

	app.controller('formaPagoCtrl', ['$scope', 'CRUDUtils', 'formaPago.context', function ($scope, CRUDUtils, context) {
			this.url = context;
			CRUDUtils.extendCtrl(this, $scope);
			this.fetchRecords();
		}]);
})();
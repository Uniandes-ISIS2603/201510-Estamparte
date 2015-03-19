(function () {
	var app = angular.module('CrudModule', ['restangular', 'ui.bootstrap']);

	app.config(['RestangularProvider', function (rp) {
		rp.setBaseUrl('webresources');
		rp.addResponseInterceptor(function (data, operation) {
			var extractedData;

			if (operation === "getList") {
				extractedData = data.records;
				extractedData.totalRecords = data.totalRecords;
			} else {
				extractedData = data;
			}
			
			return extractedData;
		});
	}]);
})();
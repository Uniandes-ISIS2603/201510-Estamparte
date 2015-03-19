(function () {	
	var app = angular.module('compradorModule');

	app.controller('compradorCtrl', ['$scope', 'servicioComprador', function ($scope, servicioComprador) {

		// Extension de los servicion del CRUD
		servicioComprador.extendCtrl(this, $scope);

	}]);
})();
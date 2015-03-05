(function () {
	var app = angular.module('carritoModule');

	app.controller('carritoCtrl', ['$scope', 'CRUDUtils', 'carrito.context', function ($scope, CRUDUtils, context) {
			this.url = context;
			CRUDUtils.extendCtrl(this, $scope);
			this.fetchRecords();
		}]);
        $scope.go = function ( path ) {
            $location.path( path );
};
})();

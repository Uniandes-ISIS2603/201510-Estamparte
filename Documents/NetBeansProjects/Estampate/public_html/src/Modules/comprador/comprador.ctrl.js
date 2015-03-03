(function () {
	var app = angular.module('comprador.module');

	app.controller('compradorCtrl', ['$scope', 'CRUDUtils', 'cmoprador.context', function ($scope, CRUDUtils, context) {
			this.url = context;
			CRUDUtils.extendCtrl(this, $scope);
                        
                        
                        
			this.fetchRecords();
		}]);
            
            
                                    
            
            
})();
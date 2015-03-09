(function(){
    
   var app = angular.module('carritoModule');

	app.controller('carritoCtrl', ['$scope', 'serviciocarrito', function ($scope, serviciocarrito) {
			serviciocarrito.extendCtrl(this,$scope);    
		}]);
    
})();
(function(){
    
   var app = angular.module('carritoModule');

	app.controller('carritoCtrl', ['$scope', 'servicioCarrito', function ($scope, serviciocarrito) {
			serviciocarrito.extendCtrl(this,$scope);    
		}]);
    
})();
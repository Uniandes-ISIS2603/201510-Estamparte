(function(){
    
   var app = angular.module('formaPagoModule');

	app.controller('formaPagoCtrl', ['$scope', 'servicioFormaPago', function ($scope, servicioFormaPago) {
			servicioFormaPago.extendCtrl(this,$scope);    
		}]);
    
})();
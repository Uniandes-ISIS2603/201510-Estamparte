angular.module('carritoModule')
.directive('carritoDir', function () {
	return {
		controller: 'carritoCtrl',
		replace: true,
		templateUrl: 'src/modules/carrito/carrito.tpl.html'
	}
});
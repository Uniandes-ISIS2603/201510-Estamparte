angular.module('footerModule')
.controller('footerCtrl', ['$scope', function ($scope) {
	
	var w = angular.element($window);
	w.bind('resize', function() {
		alinearAltura();
	})

	alinearAltura();
	function alinearAltura() {
		var footer = angular.element('#footer');
		var altura = footer.height();

		var contenedor = angular.element('.container');
		var padding = altura / 3;
		contenedor.css('padding-top', padding);
	}

}]);
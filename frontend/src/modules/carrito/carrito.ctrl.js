angular.module('carritoModule')
.controller('carritoCtrl', ['$scope', 'servicioCarrito', 'servicioCamiseta', function ($scope, servicioCarrito, servicioCamiseta) {
	
	// Extension de los servicion del CRUD
	servicioCarrito.extendCtrl(this,$scope);                        
				
	this.crearCamiseta = function () {
		var camiseta = {
			estilo: $scope.datoActual.selected.estilo,
			talla:  $scope.datoActual.selected.talla,
			color: $scope.datoActual.selected.color,
			estampas: $scope.datoActual.estampasUsadas,
			id: "C"+randomString(10),
			nombre: $scope.datoActual.nombreCamiseta
		};

		servicioEstampa.guardarDato(camiseta);
		servicioEstampa.consultarDatos();
		$rootscope.datoActual = camiseta;
				
		alert("Camiseta: " + camiseta.id + camiseta.nombre + camiseta.talla + camiseta.estilo + camiseta.color );				
	};
				
	this.cancelarCrearCamiseta = function () {
		this.crearCamisetaTpl = false;
	};
	
	this.popEditarCamiseta = function () {
		this.crearCamisetaTpl = false;
		this.editarCamiseta = true;
	};
	
	this.buscarCamisetasPropias=function () {
		servicioCamiseta.camisetasDeComprador().then(function (data) {
			$scope.datos = [];

			var r = '';
			for(var i=0; i < data.length; i++) {
			   r = r + 'Nombre de camiseta: ' + data[i].nombre + '\n ';
			}

			alert(r);
	   });
	};

}]);
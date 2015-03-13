(function () {
    var carritoModule = angular.module('carritoModule');
    app.controller('carritoModule', ['$scope', 'servicioCarrito', 'servicioCamiseta', '$rootscope', function ($scope, servicioCarrito, servicioCamiseta, $rootscope) {
            servicioCarrito.extendCtrl(this, $scope);
            this.url = context;
            CRUDUtils.extendService(this);
        }]);
    this.darCarritoActual = function () {

        var respuesta = '';
        var dat = $scope.datos;
        for (var i = 0; i < data.length; i++) {
            respuesta = respuesta +  'Camiseta ' + i+1 + data[i].nombre + '\n ';
        }
        return respuesta;
    }
})();
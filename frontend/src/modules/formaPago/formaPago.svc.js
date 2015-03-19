(function () {    
    var app = angular.module('formaPagoModule');

    app.service('ServicioFormaPago', ['CRUDUtils','formaPago.context',function(CRUDUtils,context){
        this.url = context;

    	CRUDUtils.extendService(this);
            
        this.formaPagoSeleccionada={};

        this.formaPagosDisponibles=[];

        // Actualiza una formaPago seleccionada

        this.setFormaPagoCreada = function (formaPago) {
            this.formaPagoSeleccionada = formaPago;
        };

        // Agrega una formaPago a las formaPagos disponibles para el cliente

        this.addFormaPagoDisponible = function (formaPago) {
            this.formaPagosDisponibles.push(formaPago);
        };

        // Obtiene las formaPagos registradas para un cliente

        this.formaPagosCliente = function () {
            return this.api.customGET('formaPagosCliente');
        };

        this.darFormaPagoActual = function(){
            return $scope.datoActual;
        }

    }]);
})();
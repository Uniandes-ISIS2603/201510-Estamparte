(function () {    
    var app = angular.module('formaPagoModule');

    app.service('servicioFormaPago', ['CRUDUtils', 'formaPago.context', function (CRUDUtils, context) {

        // Variable que apunta a this.

        var _this = this;

        // Configuracion de URL.

        _this.url = context;

        // Extension de los servicios del CRUD.

    	CRUDUtils.extendService(_this);
            
        // this.formaPagoSeleccionada={};

        // this.formaPagosDisponibles=[];

        // Actualiza una formaPago seleccionada

        // this.setFormaPagoCreada = function (formaPago) {
        //     this.formaPagoSeleccionada = formaPago;
        // };

        // Agrega una formaPago a las formaPagos disponibles para el cliente

        // this.addFormaPagoDisponible = function (formaPago) {
        //     this.formaPagosDisponibles.push(formaPago);
        // };

        // Obtiene las formaPagos registradas para un cliente

        // this.formaPagosCliente = function () {
        //     return this.api.customGET('formaPagosCliente');
        // };

        // this.darFormaPagoActual = function(){
        //     return $scope.datoActual;
        // }

    }]);
})();
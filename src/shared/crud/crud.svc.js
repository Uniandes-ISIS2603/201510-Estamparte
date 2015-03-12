(function () {
    var crud = angular.module('CrudModule');

    crud.factory('CRUDUtils', ['Restangular', function (RestAngular) {
            function crudConstructor() {
                this.api = RestAngular.all(this.url);

                this.consultarDatos = function (paginaActual, itemsPorPagina) {
                    return this.api.getList(null, {page: paginaActual, maxRecords: itemsPorPagina});
                };
                this.guardarDato = function (datoActual) {
                    if (datoActual.id) {
                        return datoActual.put();
                    } else {
                        return this.api.post(datoActual);
                    }
                };
                this.eliminarDato = function (dato) {
                    return dato.remove();
                };
                this.extendCtrl = function (ctrl, scope) {
                    //Variables para el scope
                    scope.datoActual = {};
                    scope.datos = [];

                    //Variables de paginacion
                    scope.maxSize = 5;
                    scope.itemsPorPagina = 5;
                    scope.totalItems = 0;
                    scope.paginaActual = 1;


                    //Funciones que no requieren del servicio
                    ctrl.crearDato = function () {
                        scope.datoActual = {};
                    };
                    ctrl.editarDato = function (dato) {
                        scope.datoActual = RestAngular.copy(dato);
                    };

                    //Funciones que usan el servicio CRUD
                    var service = this;

                    ctrl.pageChanged = function () {
                        this.consultarDatos();
                    };

                    ctrl.consultarDatos = function () {
                        return service.consultarDatos(scope.paginaActual, scope.itemsPorPagina).then(function (data) {
                            scope.datos=[];
                            scope.datos = data;
                            scope.totalItems = data.totalRecords;
                            //scope.datoActual = {};
                            return data;
                        });
                    };
                    ctrl.guardarDato = function () {
                        return service.guardarDato(scope.datoActual).then(function () {
                            ctrl.consultarDatos();
                        });
                    };
                    ctrl.eliminarDato = function (dato) {
                        return service.eliminarDato(dato).then(function () {
                            ctrl.consultarDatos();
                        });
                    };
                };
            }
            return {extendService: function (svc) {
                    crudConstructor.call(svc);
                }};
        }]);
})();

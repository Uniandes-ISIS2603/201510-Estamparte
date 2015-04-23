(function () {
	var app = angular.module('CrudModule');

	app.factory('CRUDUtils', ['Restangular', function (RestAngular) {

		function crudConstructor() {

			// Variable que apunta a _this.

			var _this = this;

			// Asignacion de URLs.

			_this.api = RestAngular.all(_this.url);

			// ############################################################################
			// ############################## Seccion CRUD ################################
			// ############################################################################

			// Trae todos los elementos con GET, letra R en CRUD (Read).

			_this.fetchRecords = function (currentPage, itemsPerPage) {
				return _this.api.getList(null, {page: currentPage, maxRecords: itemsPerPage});
			}

			// Guarda el elemento con POST, creandolo o actualizandolo.
			// Letras C y U en CRUD (Create y Update).

			_this.saveRecord = function (currentRecord) {
				if (currentRecord.id) {
					return currentRecord.put().then(function (data) {
						_this.llamarEventos();
						return data;
					});
				} else {
					return _this.api.post(currentRecord).then(function (data) {
						_this.llamarEventos();
						return data;
					});
				}
			}

			// Elimina el elemento con DELETE, letra en CRUD (Delete).

			_this.deleteRecord = function (record) {
				return record.remove().then(function () {
					_this.llamarEventos();
				});
			}

			// ############################################################################
			// ############################# Seccion Eventos ##############################
			// ############################################################################

			// Mantiene los eventos registrados.

			_this.eventos = [];

			// Registra un nuevo evento.

			_this.registrarEvento = function (evento) {
				_this.eventos.push(evento);
			}

			// Llama los eventos registrados.

			_this.llamarEventos = function () {
				angular.forEach(_this.eventos, function (evento) {
					evento();
				})
			}

			// ############################################################################
			// ############################## Seccion CTRL ################################
			// ############################################################################

			// Extiende el controlador del modulo con funciones para
			// llamar al servicio y mantener los datos en variables
			// del scope validas dentro del controlador.

			_this.extendCtrl = function (ctrl, scope) {

				// Variables para el scope.

				scope.currentRecord = {};
				scope.records = [];

				// Variables de paginacion.

				// scope.maxSize = 5;
				// scope.itemsPerPage = 5;
				// scope.totalItems = 0;
				// scope.currentPage = 2;

				// Variables para el controlador.

				ctrl.editMode = false;

				// Funciones que no requieren del servicio.

				ctrl.createRecord = function () {
					_this.editMode = true;
					scope.currentRecord = {};
				}

				ctrl.editRecord = function (record) {
					scope.currentRecord = RestAngular.copy(record);
					_this.editMode = true;
				}

				// Funciones que usan el servicio CRUD.

				ctrl.pageChanged = function () {
					_this.fetchRecords();
				}

				ctrl.fetchRecords = function () {
					return _this.fetchRecords().then(function (data) {
						scope.records = data;
						scope.totalItems = data.totalRecords;
						scope.currentRecord = {};
						ctrl.editMode = false;
						return data;
					});
				}

				ctrl.saveRecord = function () {
					return _this.saveRecord(scope.currentRecord).then(function () {
						ctrl.fetchRecords();
					});
				}

				ctrl.deleteRecord = function (record) {
					return _this.deleteRecord(record).then(function () {
						ctrl.fetchRecords();
					});
				}
			}
		}

		return {
			extendService: function (svc) {
				crudConstructor.call(svc);
			}
		};
	}]);
})();
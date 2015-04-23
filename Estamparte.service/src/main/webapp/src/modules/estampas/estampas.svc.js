(function () {
	var app = angular.module('estampasModule');

	app.service('servicioEstampa', ['CRUDUtils', 'estampas.context', function (CRUDUtils, context) {

		var _this = this;

		// Extension de los servicios del CRUD.

		_this.url = context;

		CRUDUtils.extendService(_this);

		// Estampa seleccionada en particular.

		// this.estampaSeleccionada = {};

		// Estampas selecionadas para una camiseta.

		// this.estampasSeleccionadas = [];

		// Actualiza un estampa seleccionada.

		// this.setEstampaCreada = function (estampa) {
		// 	this.estampaSeleccionada = estampa;
		// };
		
		// Agrega una estampa a las estampas,
		// seleccionadas para la camiseta.

		// this.addEstampaSeleccionada = function (estampa) {
		// 	this.estampasSeleccionadas.push(estampa);
		// };
		
		// Obtiene las estampas de un artista.

		// this.estampasDeArtista = function () {
		// 	return this.api.customGET('estampasDe');
		// };
		
		// Retorna las estampas seleccionadas.
		
		// this.darEstampasSeleccionadas = function() {
		// 	return this.estampasSeleccionadas;
		// };

	}]);
})();
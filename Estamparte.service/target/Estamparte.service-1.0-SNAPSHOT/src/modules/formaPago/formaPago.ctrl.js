(function () {
	angular.module('formaPagoModule')
	.controller('formaPagoController', formaPagoController);

	function formaPagoController(formaPagoService, usuarioService) {

		var _this = this;

		// The object for creating new payments.
		_this.payment = {};

		// Check if we are adding a payment.
		_this.adding = false;

		// Hold records from formaPago.
		_this.formaPagoRecords = formaPagoService.records;

		_this.removePayment = removePayment;
		_this.closePanel = closePanel;
		_this.closeAddPayment = closeAddPayment;

		_this.preAddPayment = preAddPayment;
		_this.addPayment = addPayment;

		_this.cleanPayment = cleanPayment;


		// Remove some payment form.
		function removePayment(target) {
			var id = usuarioService.getUser().id;
			formaPagoService.deleteCustom(target, id);
		}

		// Close this panel.
		function closePanel() {
			angular.element('#formapago').animate({width: 'toggle'});
		}

		// Close the payment creation.
		function closeAddPayment() {
			cleanPayment();
		}

		// Open a new add payment form.
		function preAddPayment() {
			_this.adding = true;
		}

		// Add the payment with the form data.
		function addPayment() {
			var id = usuarioService.getUser().id;
			_this.payment.idComprador = id;
			formaPagoService.postCustom(_this.payment, id).then(cleanPayment);
		}

		// Clean the payment creation.
		function cleanPayment() {
			_this.payment = {};
			_this.adding = false;
		}
	}
})();
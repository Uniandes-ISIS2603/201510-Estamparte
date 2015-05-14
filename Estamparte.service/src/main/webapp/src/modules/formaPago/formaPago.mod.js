(function () {
	angular.module('formaPagoModule', [])
	.config(formaPagoConfig);

	function formaPagoConfig(mockProvider) {
		var basicReg = 'comprador', customReg = 'formaPago';
		mockProvider.addCustomReg(basicReg, customReg);
	}
})();
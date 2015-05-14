(function () {
	angular.module('facturaModule', [])
	.config(facturaConfig);

	function facturaConfig(mockProvider) {
		var basicReg = 'comprador', customReg = 'factura';
		mockProvider.addCustomReg(basicReg, customReg);
	}
})();
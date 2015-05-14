(function () {	
	angular.module('carritoModule', [])
	.config(carritoConfig);

	function carritoConfig(mockProvider) {
		var basicReg = 'comprador', customReg = 'carrito';
		mockProvider.addCustomReg(basicReg, customReg);
	}
})();
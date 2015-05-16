(function () {	
	angular.module('carritoModule', [])
	.config(carritoConfig);

	function carritoConfig(mockProvider) {
		var basicReg = 'carrito', customReg = 'camisetas';
		mockProvider.addCustomReg(basicReg, customReg);
	}
})();
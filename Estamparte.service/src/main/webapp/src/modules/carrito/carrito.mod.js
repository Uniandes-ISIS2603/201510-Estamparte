(function () {	
	angular.module('carritoModule', [])
	.config(carritoConfig);

	function carritoConfig(mockProvider) {
		var basicReg = 'carrito';
		mockProvider.addBasicReg(basicReg);
	}
})();
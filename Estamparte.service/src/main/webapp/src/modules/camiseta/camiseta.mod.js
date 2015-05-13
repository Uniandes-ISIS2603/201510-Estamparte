(function () {	
	angular.module('camisetaModule', [])
	.config(camisetaConfig);

	function camisetaConfig(mockProvider) {
		var basicReg = 'comprador', customReg = 'camiseta';
		mockProvider.addCustomReg(basicReg, customReg);
	}
})();
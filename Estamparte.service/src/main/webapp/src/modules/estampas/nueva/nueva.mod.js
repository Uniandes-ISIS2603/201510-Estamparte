(function () {	
	angular.module('nuevaModule', [])
	.config(nuevaConfig);

	function nuevaConfig(mockProvider) {
		var basicReg = 'artistas'; customReg = 'estampas';
		mockProvider.addCustomReg(basicReg, customReg);
	}
})();
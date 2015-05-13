(function () {
	angular.module('artistaModule', [])
	.config(artistaConfig);

	function artistaConfig(mockProvider) {
		var basicReg = 'artista';
		mockProvider.addBasicReg(basicReg);
	}
})();
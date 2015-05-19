(function () {
	angular.module('artistaModule', [])
	.config(artistaConfig);

	function artistaConfig(mockProvider) {
		var basicReg = 'artistas';
		mockProvider.addBasicReg(basicReg);
	}
})();
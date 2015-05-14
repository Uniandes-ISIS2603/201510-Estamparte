(function () {	
	angular.module('estampasModule', ['estampaModule'])
	.config(estampasConfig);

	function estampasConfig(mockProvider) {
		var basicReg = 'estampas';
		mockProvider.addBasicReg(basicReg);
	}
})();
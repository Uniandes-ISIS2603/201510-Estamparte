(function () {	
	angular.module('compradorModule', [])
	.config(compradorConfig);

	function compradorConfig(mockProvider) {
		var basicReg = 'comprador';
		mockProvider.addBasicReg(basicReg);
	}
})();
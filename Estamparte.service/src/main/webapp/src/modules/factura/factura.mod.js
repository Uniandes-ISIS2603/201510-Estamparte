(function () {
	angular.module('facturaModule', []);
	.config(facturaConfig);

	function facturaConfig(mockProvider) {
		var basicReg = 'comprador';
		mockProvider.addBasicReg(basicReg);

		var customReg = ['formaPago'];
		angular.forEach(customReg, addCustomReg);
		function addCustomReg(value, index) {
			mockProvider.addCustomReg(basicReg, value);
		}
	}]);
})();
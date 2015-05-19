(function () {
	angular.module('misestampasModule')
	.service('misestampasService', misestampasService);

	function misestampasService() {

		var _this = this;

		// Hold the records.
		_this.records = {
			basicRecords: []
		};

		_this.existMisEstampas = existMisEstampas;
		_this.addMisEstampas = addMisEstampas;
		_this.removeMisEstampas = removeMisEstampas;

		function indexMisEstampas(target) {
			var ans = -1;
			angular.forEach(_this.records.basicRecords, find);
			function find(value, index) {
				if (value === target)
					ans = index;
			}
			return ans;
		}

		function existMisEstampas(target) {
			return indexMisEstampas(target) !== -1;
		}

		function addMisEstampas(target) {
			if (!existMisEstampas(target))
				_this.records.basicRecords.push(target);
		}

		function removeMisEstampas(target) {
			var index = indexMisEstampas(target);
			if (index !== -1)
				_this.records.basicRecords.splice(index, 1);
		}
	}
})();	
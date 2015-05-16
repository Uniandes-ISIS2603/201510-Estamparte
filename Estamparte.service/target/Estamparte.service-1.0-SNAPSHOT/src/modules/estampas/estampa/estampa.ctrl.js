(function () {
	angular.module('estampaModule')
	.controller('estampaController', estampaController);

	function estampaController(usuarioService, estampasService, misestampasService) {

		var _this = this;

		_this.showEstampa = showEstampa;
		_this.isType = isType;
		_this.addMisEstampas = addMisEstampas;
		_this.voteEstampa = voteEstampa;
		
		function showEstampa(target) {
			alert('Esta funcion aun no esta implementada, esperala!');
		}

		function isType(userType) {
			return usuarioService.getType() === userType;
		}

		function addMisEstampas(target) {
			misestampasService.addMisEstampas(target);
		}

		function voteEstampa(target, val) {
			if (val === 'like')
				target.siGusta += 1;
			else if (val === 'dislike')
				target.noGusta += 1
			estampasService.putBasic(target);
		}
	}
})();
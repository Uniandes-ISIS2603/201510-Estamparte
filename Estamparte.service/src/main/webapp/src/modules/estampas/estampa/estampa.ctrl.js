(function () {
	angular.module('estampaModule')
	.controller('estampaController', estampaController);

	function estampaController(usuarioService, estampasService, misestampasService, nuevaService) {

		var _this = this;

		_this.showEstampa = showEstampa;
		_this.isType = isType;
		_this.addMisEstampas = addMisEstampas;
		_this.voteEstampa = voteEstampa;
		_this.removeEstampa = removeEstampa;
		_this.isOwner = isOwner
		
		function showEstampa(target) {
			alert('Esta funcion aun no esta implementada, esperala!');
		}

		function isType(userType) {
			return usuarioService.getType() === userType;
		}

		function addMisEstampas(target) {
			misestampasService.addMisEstampas(target);

			var div = angular.element('#misestampas');
			if (div.css('display') === 'none')
				div.animate({width: 'toggle'});
		}

		function removeEstampa(target) {
			estampasService.deleteBasic(target);
		}

		function isOwner(target) {
			var user = usuarioService.getUser(), ans = false;
			if (user && target && user.id === target.idArtista)
				ans = true;
			return ans;
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
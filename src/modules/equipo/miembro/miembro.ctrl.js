(function(){
    angular.module('miembroModule', [])
.controller('miembroCtrl', ['$scope', function($scope) {}])
.directive('miembro', function () {
	return {
		scope: {
			persona: '=miembro'
		},
		templateUrl: 'src/modules/equipo/miembro/miembro.tpl.html',
	};
});
})();
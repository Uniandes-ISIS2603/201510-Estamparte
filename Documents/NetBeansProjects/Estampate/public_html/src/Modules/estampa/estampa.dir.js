angular.module('estampa', [])
.controller('estampaCtrl', ['$scope', function($scope) {
	$scope.estampas = [
		{
			id: 1,
			nombre: "Estampa de la flor",
			autor: "elgenio",
			siGusta: 381,
			noGusta: 212
		},
		{
			id: 2,
			nombre: "El super fuego",
			autor: "elburro",
			siGusta: 121,
			noGusta: 1420
		},
		{
			id: 3,
			nombre: "Agua mas agua",
			autor: "elsa pato",
			siGusta: 3019,
			noGusta: 1425
		},
		{
			id: 4,
			nombre: "Come tierra",
			autor: "elsa pito",
			siGusta: 121,
			noGusta: 12
		}
	];
}])
.directive('estampa', function() {
  return {
    templateUrl: 'src/modules/estampa/estampa.tpl.html'
  };
});
angular.module('footerModule', [])
.controller('footerCtrl', ['$scope', function($scope) {}])
.directive('footer', function() {
	return {
		templateUrl: 'src/modules/footer/footer.tpl.html'
	};
});
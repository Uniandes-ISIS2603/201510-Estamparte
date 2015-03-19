angular.module('footerModule')
.directive('footerDir', function () {
	return {
		controller: "footerCtrl",
		replace: true,
		templateUrl: 'src/modules/footer/footer.tpl.html'
	};
});
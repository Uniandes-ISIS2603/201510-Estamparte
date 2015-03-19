angular.module('navbarModule')
.directive('navbarDir', function () {
	return {
		controller: 'navbarCtrl',
		replace: true,
		templateUrl: 'src/modules/navbar/navbar.tpl.html'
	};
});
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function () {
	var app = angular.module('compradorModule');

	app.controller('compradorCtrl', ['$scope', 'servicioComprador', function ($scope,servicioComprador) {
			servicioComprador.extendCtrl(this, $scope);
		}]);
                    
            
})();

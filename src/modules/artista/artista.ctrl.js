/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(){
    
   var app = angular.module('artistaModule');

	app.controller('artistaCtrl', ['$scope', 'servicioArtista', function ($scope, servicioArtista) {
			servicioArtista.extendCtrl(this,$scope);    
		}]);
    
})();



(function(){
    
   var app = angular.module('formaPagoModule');

	app.controller('formaPagoCtrl', ['$scope', 'servicioFormaPago', '$location','$rootScope', function ($scope, servicioFormaPago, $location, $rootScope) {
            servicioFormaPago.extendCtrl(this,$scope);    
            
            datos = [
            {  
                tipo: "Visa",
                numeroTarjeta: 123456789
                fechaVencimiento: ("October 13, 2014 11:13:00"),
                siGusta: 381,
                noGusta: 212,
                precio: 100,
                imagenes: [
                    'src/assets/img/estampa.jpg'
                ],
                tema: 'TemaA'
            }
            
        }]);
    
})();
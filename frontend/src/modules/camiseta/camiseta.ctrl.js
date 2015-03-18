/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function () {
    var app = angular.module('moduloCamiseta');
    
    app.controller('camisetaCtrl', ['$scope', 'servicioCamiseta','servicioEstampa', function ($scope, servicioCamiseta, servicioEstampa) {
            servicioCamiseta.extendCtrl(this, $scope);
            $scope.datoActual.camiseta.estampasUsadas = [];
            $scope.datoActual.camiseta.idCamiseta;
            $scope.datoActual.camiseta.nombreCamiseta;

            this.contiene = function (id)
            {
                for (var i = 0; i < $scope.datoActual.camiseta.estampasUsadas.length; i++)
                {
                    if ($scope.datoActual.estampasUsadas[i] === id)
                        return true;
                }
                return false;
            };
            this.agregarEstampa = function (id)
            {
                $scope.datoActual.camiseta.estampasUsadas.push(id);
            };
            this.eliminarEstampa = function (id)
            {

                for (var i = 0; i < $scope.datoActual.camiseta.estampasUsadas.length; i++)
                {
                    if ($scope.datoActual.estampasUsadas[i] === id)
                    {
                        $scope.datoActual.camiseta.estampasUsadas.splice(i, 1);
                        break;
                    }
                }
            };

            this.estampasSeleccionadas = function()
             {
                 return servicioEstampa.darEstampasSeleccionadas();
             }
            function randomString(length) {
                var chars = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz'.split('');

                if (!length) {
                    length = Math.floor(Math.random() * chars.length);
                }

                var str = '';
                for (var i = 0; i < length; i++) {
                    str += chars[Math.floor(Math.random() * chars.length)];
                }
                return str;
            }
            
            this.continuar = function () {
                $scope.datoActual.camiseta.idCamiseta = "C"+ randomString(10);
                var msj = "";
                for (var i = 0; i < $scope.datoActual.camiseta.estampasUsadas.length; i++)
                    if ($scope.datoActual.estampasUsadas[i])
                        msj += (i + 1) + ")" + $scope.datoActual.camiseta.estampasUsadas[i].valueOf() + "\n\t";
                
                
                servicioCamiseta.agregarCamiseta($scope.datoActual.camiseta);
                alert("\tDETALLES:\n\tNombre:\t"+$scope.datoActual.nombreCamiseta+"\n\tID:\t"+$scope.datoActual.idCamiseta+"\n\tEstilo:\t" + $scope.datoActual.camiseta.selected.estilo + "\n\tTalla:\t" + $scope.datoActual.camiseta.selected.talla + "\n\tColor:\t" + $scope.datoActual.camiseta.selected.color
                        + "\n\tESTAMPAS USADAS:\n\t" + msj);
            };
        }]);
})();


/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function () {
    var app = angular.module('moduloCamiseta');
    
    app.controller('camisetaCtrl', ['$scope', 'servicioCamiseta', function ($scope, servicioCamiseta) {
            servicioCamiseta.extendCtrl(this, $scope);
            $scope.datoActual.estampasUsadas = [];
            $scope.datoActual.idCamiseta;
            $scope.datoActual.nombreCamiseta;

            this.contiene = function (id)
            {
                for (var i = 0; i < $scope.datoActual.estampasUsadas.length; i++)
                {
                    if ($scope.datoActual.estampasUsadas[i] === id)
                        return true;
                }
                return false;
            };
            this.agregarEstampa = function (id)
            {
                $scope.datoActual.estampasUsadas.push(id);
            };
            this.eliminarEstampa = function (id)
            {

                for (var i = 0; i < $scope.datoActual.estampasUsadas.length; i++)
                {
                    if ($scope.datoActual.estampasUsadas[i] === id)
                    {
                        $scope.datoActual.estampasUsadas.splice(i, 1);
                        break;
                    }
                }
            };


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
                $scope.datoActual.idCamiseta = "C"+ randomString(10);
                //TODO reiniciar dato actual y proceder con el flujo de la aplicaion
                var msj = "";
                for (var i = 0; i < $scope.datoActual.estampasUsadas.length; i++)
                    if ($scope.datoActual.estampasUsadas[i])
                        msj += (i + 1) + ")" + $scope.datoActual.estampasUsadas[i].valueOf() + "\n\t";
                alert("\tDETALLES:\n\tNombre:\t"+$scope.datoActual.nombreCamiseta+"\n\tID:\t"+$scope.datoActual.idCamiseta+"\n\tEstilo:\t" + $scope.datoActual.selected.estilo + "\n\tTalla:\t" + $scope.datoActual.selected.talla + "\n\tColor:\t" + $scope.datoActual.selected.color
                        + "\n\tESTAMPAS USADAS:\n\t" + msj);
            };
        }]);
})();


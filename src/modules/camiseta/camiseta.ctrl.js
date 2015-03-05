/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function () {
    var app = angular.module('moduloCamiseta');

    app.controller('camisetaCtrl', ['$scope', 'CRUDUtils', 'camiseta.context', function ($scope, CRUDUtils, context) {
            this.url = context;
            CRUDUtils.extendCtrl(this, $scope);
            $scope.datoActual.estampasUsadas = [];

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



            this.continuar = function () {
                var msj = "";
                for (var i = 0; i < $scope.datoActual.estampasUsadas.length; i++)
                    if ($scope.datoActual.estampasUsadas[i])
                        msj += (i + 1) + ")" + $scope.datoActual.estampasUsadas[i].valueOf() + "\n\t";
                alert("\tDETALLES:\n\tEstilo:\t" + $scope.datoActual.selected.estilo + "\n\tTalla:\t" + $scope.datoActual.selected.talla + "\n\tColor:\t" + $scope.datoActual.selected.color
                        + "\n\tESTAMPAS USADAS:\n\t" + msj);
            };
        }]);
})();


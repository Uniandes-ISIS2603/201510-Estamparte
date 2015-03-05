(function(){
    
    var crud = angular.module('CrudModule');
    
    crud.factory('CRUDUtils',['Restangular',function(Restangular){
            
            function CRUD($scope){
                
                this.api = Restangular.all(this.url);
                $scope.datoActual={};
                $scope.datos=[];
                
            this.consultarDatos = function () {
                    this.api.getList().then(function (data) {
                            $scope.datos = data;
                            $scope.datoActual = {};
                    });
                    
            };
            this.crearDato = function () {
                    
                    $scope.datoActual = {};
                   
            };
            this.guardarDato = function () {
                    
                    if ($scope.datoActual.id) {
                            $scope.datoActual.put().then(function () {
                                    $scope.datoActual = {};
                            });
                    } else {
                            this.api.post($scope.datoActual).then(function () {
                                    $scope.datoActual = {};
                            });
                    }
                  
            };
            this.eliminarDato = function (dato) {
                   
                    dato.remove().then(function () {
                            $scope.datoActual = {};
                    });
                    
            };
            this.editarDato = function (dato) {
                    $scope.datoActual = Restangular.copy(dato);
                    
            };
                
            };
            return {
                extendCtrl: function(obj,scope){
                    CRUD.call(obj,scope);
                }
            };
    }]);
    
})();

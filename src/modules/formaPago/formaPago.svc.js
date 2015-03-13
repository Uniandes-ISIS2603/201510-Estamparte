(function(){
    var formaPagoModule = angular.module('formaPagoModule');
    app.controller('formaPagoModule', ['$scope', 'servicioFormaPago', '$rootscope', function ($scope, servicioFormaPago, $rootscope) {
        this.url = context;
	CRUDUtils.extendService(this);
    }]);
    
    this.darFormaPagoActual = function(){
        return $scope.datoActual;
    }

})();

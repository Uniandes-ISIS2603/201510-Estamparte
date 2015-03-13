(function(){
    var formaPagoModule = angular.module('formaPagoModule',['CrudModule','MockModule']);
    
    formaPagoModule.constant('formaPago.context','formaPago');
    
    formaPagoModule.config(['formaPago.context','MockModule.urlsProvider',function(context,urlsProvider){
        urlsProvider.registerUrl(context);
    }]);
})();


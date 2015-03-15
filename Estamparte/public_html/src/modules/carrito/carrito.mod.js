(function(){
    var carritoModule = angular.module('carritoModule',['CrudModule','MockModule']);
    
    carritoModule.constant('carrito.context','carrito');
    
    carritoModule.config(['carrito.context','MockModule.urlsProvider',function(context,urlsProvider){
        urlsProvider.registerUrl(context);
    }]);
})();


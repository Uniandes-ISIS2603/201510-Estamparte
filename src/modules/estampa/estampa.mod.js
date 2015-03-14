/* 
 * Modulo de una estampa
 */
(function(){

    var estampaModule = angular.module('estampaModule',['CrudModule','MockModule','artistaModule']);

    //Configuracion de variable de contexto para le Mock
    estampaModule.constant('estampa.context','estampa');

    estampaModule.config(['estampa.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
        urlsProvider.registerUrl(context);
    }]);
        
    //Directiva para ver los detalles de una estampa    
    estampaModule.directive('estampad', function() {
        return {
            templateUrl: 'src/modules/estampa/estampaDetalle.tpl.html'
        };
    });
})();

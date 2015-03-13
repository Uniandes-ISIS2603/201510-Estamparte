/* 
 * Modulo de artista
 */
(function(){
    var artistaModule = angular.module('artistaModule',['CrudModule','MockModule','estampaModule']);
    
    //Configura una constante de contexto para el funcionamiento del Mock
    
    artistaModule.constant('artista.context','artista');
    
    artistaModule.config(['artista.context','MockModule.urlsProvider',function(context,urlsProvider){
        urlsProvider.registerUrl(context);
    }]);

    //Directiva para crear una nueva estampa
    artistaModule.directive('nuevaestampa',function(){
        return {
            templateUrl: 'src/modules/artista/nuevaEstampa.tpl.html'
        };
    });

})();


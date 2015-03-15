/* 
 * Modulo de artista
 */
(function(){
    var artistaModule = angular.module('artistaModule',['CrudModule','MockModule','estampaModule','angularFileUpload']);
    
    //Configura una constante de contexto para el funcionamiento del Mock
    
    artistaModule.constant('artista.context','artista');
    
    artistaModule.config(['artista.context','MockModule.urlsProvider',function(context,urlsProvider){
        urlsProvider.registerUrl(context);
    }]);

    //Directiva para crear una nueva estampa
    artistaModule.directive('nuevae', function() {
                return {
                  templateUrl: 'src/modules/artista/nuevaEstampa.tpl.html'
                };
            });

})();


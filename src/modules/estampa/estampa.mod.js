/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(){
    //Configuracion del modulo de estampa
    var estampaModule = angular.module('estampaModule',['CrudModule','MockModule','artistaModule']);

        estampaModule.constant('estampa.context','estampa');

        estampaModule.config(['estampa.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
                    urlsProvider.registerUrl(context);
            }]);
    
        estampaModule.directive('estampa', function() {
                return {
                  templateUrl: 'src/modules/estampa/estampa.tpl.html'
                };
            });
            
        estampaModule.directive('estampad', function() {
                return {
                  templateUrl: 'src/modules/estampa/estampaDetalle.tpl.html'
                };
            });
})();

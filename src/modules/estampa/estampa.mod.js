/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(){
    //Configuracion del modulo de estampa
    var estampaModule = angular.module('estampaModule',['CrudModule','MockModule']);

    estampaModule.constant('estampa.context','estampa');

    estampaModule.config(['estampa.context', 'MockModule.urlsProvider', function (context, urlsProvider) {
                urlsProvider.registerUrl(context);
        }]);
})();

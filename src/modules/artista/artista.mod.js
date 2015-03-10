/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(){
    var artistaModule = angular.module('artistaModule',['CrudModule','MockModule','estampaModule']);
    
    artistaModule.constant('artista.context','artista');
    
    artistaModule.config(['artista.context','MockModule.urlsProvider',function(context,urlsProvider){
        urlsProvider.registerUrl(context);
    }]);
})();


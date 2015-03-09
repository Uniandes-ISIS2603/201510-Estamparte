/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(){
    var artistaModule = angular.module('artistaModule');
    artistaModule.service('servicioArtista',['CRUDUtils','artista.context',function(CRUDUtils,context){
            this.url = context;
            CRUDUtils.extendService(this);
    }]);
})();



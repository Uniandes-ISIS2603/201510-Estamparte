/* 
 * Servicio CRUD de un artista
 */
(function(){
    var artistaModule = angular.module('artistaModule');
    artistaModule.service('servicioArtista',['CRUDUtils','artista.context',function(CRUDUtils,context){
            this.url = context;
            CRUDUtils.extendService(this);
    }]);
})();



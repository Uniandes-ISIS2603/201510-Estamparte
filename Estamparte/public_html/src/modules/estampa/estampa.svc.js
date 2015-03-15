/* 
 * Servicios CRUD para una estampa
 */
(function(){
    var estampaModule = angular.module('estampaModule');
    
    estampaModule.service('servicioEstampa',['CRUDUtils','estampa.context',function(CRUDUtils,context){
            this.url=context;
            CRUDUtils.extendService(this);
            
            //Estampa seleccionada en particular
            this.estampaSeleccionada={};
            //Estampas selecionadas para una camiseta
            this.estampasSeleccionadas=[];

            //Actualiza un estampa seleccionada
            this.setEstampaCreada = function(estampa){
                this.estampaSeleccionada=estampa;
            };
            
            //Agrega una estampa a las estampas seleccionadas para la camiseta
            this.addEstampaSeleccionada=function(estampa){
                this.estampasSeleccionadas.push(estampa);
            };
            
            //Obtiene las estampas de un artista
            this.estampasDeArtista=function(){
                return this.api.customGET('estampasDe');
            };

    }]);
})();



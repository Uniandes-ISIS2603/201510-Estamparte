/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(){
    var estampaModule = angular.module('estampaModule');
    
    estampaModule.service('servicioEstampa',['CRUDUtils','estampa.context',function(CRUDUtils,context){
            this.url=context;
            CRUDUtils.extendService(this);
            this.estampaSeleccionada={};
            this.estampasSeleccionadas=[];
            this.setEstampaCreada = function(estampa){
                this.estampaSeleccionada=estampa;
            };
            this.addEstampaSeleccionada=function(estampa){

                this.estampasSeleccionadas.push(estampa);
            };
            this.estampasDeArtista=function(){
                return this.api.customGET('estampasDe');
            };
    }]);
})();



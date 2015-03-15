/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function(){
    
   var app = angular.module('facturaModule');

	app.controller('facturaCtrl', ['$scope','servicioFactura', 'servicioFormaPago', 'servicioCarrito'
            , function ($scope, servicioFactura, servicioFormaPago, servicioCarrito) {	servicioFactura.extendCtrl(this,$scope);
	                this.editMode = false;
                        //this.camisetas = servicioCarrito.darCamisetas;
                        //this.formaPago = servicioFormaPago.darFormaPago();
                        
                        this.editar = function(dato){
                            this.editMode = true;
                            this.editarDato(dato);
                        }
                        
                        this.cancelar = function(){
                            this.editMode = false;
                            this.consultarDatos();
                        };
                        
                        this.guardar = function(){
                            this.editMode = false;
                            
                            this.guardarDato();
                        };
                       
                       this.crear = function(){
                           this.editMode = true;
                           this.crearDato();
                           
                       };
		}]);
    
})();

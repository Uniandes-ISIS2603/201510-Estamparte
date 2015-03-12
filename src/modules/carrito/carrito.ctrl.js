(function(){
    
   var app = angular.module('carritoModule');

	app.controller('carritoCtrl', ['$scope', 'servicioCarrito', function ($scope, serviciocarrito) {
			serviciocarrito.extendCtrl(this,$scope);
                       
                        this.popCrearCamiseta= function(){
                            this.crearDato();
                            this.crearCamisetaTpl=true;
                            this.editarCamiseta=false;
                        };
                        
                        
                        this.crearCamiseta = function(camiseta){
                            //El usuario debe ser configurado en $rootScope!!!!
                            $rootScope.datoActual=camiseta;
                            alert("Camiseta: " + camiseta.id + camiseta.nombre + camiseta.talla + camiseta.estilo + camiseta.color );
                        };
                        
                        this.cancelarCrearCamiseta = function(){
                            this.crearCamisetaTpl=false;
                        };
                        
                        this.popEditarCamiseta = function(){
                            this.crearCamisetaTpl=false;
                            this.editarCamiseta=true;
                        };
                        
                        this.buscarCamisetasPropias=function(){
                            servicioCamiseta.camisetasDeComprador().then(function(data){
                                $scope.datos=[];
                                var r=''
                                for(var i=0;i<data.length;i++){
                                   r=r+'Nombre de camiseta: '+data[i].nombre+'\n ';
                                }
                                alert(r);
                           });
                        };
                        
                        

		}]);
    
})();
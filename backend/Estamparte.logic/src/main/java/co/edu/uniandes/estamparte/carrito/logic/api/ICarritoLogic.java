/*
 * Funcionalidades de la estampa
 */
package co.edu.uniandes.estamparte.carrito.logic.api;

import co.edu.uniandes.estamparte.carrito.logic.dto.CarritoDTO;
import java.util.List;

public interface ICarritoLogic {
   
    public CarritoDTO crearCarrito (CarritoDTO formaPago);
    
    public List<CarritoDTO> darFormasPago();
    
    public void actualizarCarrito(CarritoDTO formaPago);
    
    public void eliminarCarrito(String nombre);    
}

/*
 * Funcionalidades de la estampa
 */
package co.edu.uniandes.estamparte.carrito.logic.api;

import co.edu.uniandes.estamparte.carrito.logic.dto.CarritoDTO;
import java.util.List;

public interface ICarritoLogic {
   
    public CarritoDTO crearCarrito (CarritoDTO carrito);
    
    public List<CarritoDTO> darCarritos();
    
    public void actualizarCarrito(CarritoDTO carrito);
    
    public void eliminarCarrito(String nombre);    
}

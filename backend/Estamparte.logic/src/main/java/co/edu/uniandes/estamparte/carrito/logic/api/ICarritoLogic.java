/*
 * Funcionalidades de la estampa
 */
package co.edu.uniandes.estamparte.carrito.logic.api;

import co.edu.uniandes.estamparte.camiseta.logic.dto.CamisetaDTO;
import co.edu.uniandes.estamparte.camiseta.logic.dto.CamisetaPageDTO;
import co.edu.uniandes.estamparte.carrito.logic.dto.CarritoDTO;
import co.edu.uniandes.estamparte.carrito.logic.dto.CarritoPageDTO;
import java.util.List;

public interface ICarritoLogic {
   
    public CarritoDTO crearCarrito (CarritoDTO carrito);
    
    public List<CarritoDTO> darCarritos();
    
    public CarritoPageDTO darCarritos(Integer pagina, Integer datosMaximos);
    
    public CamisetaDTO crearEstampaDeArtista(Long idArtista, CamisetaDTO camiseta);
    
    public CamisetaPageDTO darCamisetasCarrito(String idCarrito, Integer pagina, Integer datosMaximos);
    
    public CamisetaDTO actualizarCamisetaCarrito(String idCarrito, CamisetaDTO camiseta);
    
    public void eliminarCamisetaCarrito(String idCarrito, String idCamiseta);
    
    public void actualizarCarrito(CarritoDTO carrito);
    
    public void eliminarCarrito(String nombre);    
}

/*
 * DTO's de varias estampas
 */
package co.edu.uniandes.estamparte.carrito.logic.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CarritoPageDTO {
    
    private Long cantidad;
    
    private List<CarritoDTO> carritos;
    
    public Long darCantidad(){
        return cantidad;
    }
    
    public List<CarritoDTO> darCarritos(){
        return carritos;
    }
    
    public void asignarCarritos (List<CarritoDTO> carritos){
        this.carritos = carritos;
    }
    
    public void asignarCantidad(Long cantidad){
        this.cantidad = cantidad;
    }
}

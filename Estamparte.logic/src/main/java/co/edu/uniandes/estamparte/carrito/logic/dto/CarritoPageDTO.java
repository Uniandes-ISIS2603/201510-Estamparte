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
    
    public Long getCantidad(){
        return cantidad;
    }
    
    public List<CarritoDTO> getCarritos(){
        return carritos;
    }
    
    public void setCarritos (List<CarritoDTO> carritos){
        this.carritos = carritos;
    }
    
    public void setCantidad(Long cantidad){
        this.cantidad = cantidad;
    }
}

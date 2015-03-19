/*
 * DTO's de varias estampas
 */
package co.edu.uniandes.estamparte.carrito.logic.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CarritoPageDTO {
    
    private List<CarritoDTO> carritos;
    
    public int getNumeroCarritos(){
        return carritos.size();
    }
    
    public List<CarritoDTO> darCarritos(){
        return carritos;
    }
    
    public void asignarCarritos (List<CarritoDTO> carritos){
        this.carritos = carritos;
    }
}

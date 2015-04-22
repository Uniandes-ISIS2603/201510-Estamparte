/*
 * DTO de la estampa
 */
package co.edu.uniandes.estamparte.carrito.logic.dto;

import co.edu.uniandes.estamparte.camiseta.logic.dto.CamisetaDTO;
import co.edu.uniandes.estamparte.comprador.logic.dto.CompradorDTO;
import co.edu.uniandes.estamparte.factura.logic.dto.FacturaDTO;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CarritoDTO {
    
    private long idCarrito;
    
        
    
    public long getIdCarrito(){
        return idCarrito;
    }
    
    public void setIdCarrito(long idCarrito){
        this.idCarrito = idCarrito;
    }
    
  
}

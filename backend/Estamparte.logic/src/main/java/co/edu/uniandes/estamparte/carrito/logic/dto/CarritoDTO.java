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
    
    private String idComprador;
        
    private long idFactura;
    
    public long getIdCarrito(){
        return idCarrito;
    }
    
    public void setIdCarrito(long idCarrito){
        this.idCarrito = idCarrito;
    }
    
    public String getComprador(){
        return idComprador;
    }
    
    public void setComprador(String nComprador){
        idComprador = nComprador;
    }

    public void setFactura(long nFactura){
        idFactura = nFactura;
    }
    
    public long getFactura(){
        return idFactura;
    }
}

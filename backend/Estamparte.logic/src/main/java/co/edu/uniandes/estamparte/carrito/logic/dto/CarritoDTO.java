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
    
    private String idCarrito;
    
    private CompradorDTO comprador;
    
    private List<CamisetaDTO> camisetas;
    
    private FacturaDTO factura;
    
    public String getIdCarrito(){
        return idCarrito;
    }
    
    public void setIdCarrito(String idCarrito){
        this.idCarrito = idCarrito;
    }
    
    public CompradorDTO getComprador(){
        return comprador;
    }
    
    public void setComprador(CompradorDTO nComprador){
        comprador = nComprador;
    }
    
    public int getNumeroCamisetas(){
        return camisetas.size();
    }
    
    public List<CamisetaDTO> getCamisetas(){
        return camisetas;
    }
    
    public void setCamisetas(List<CamisetaDTO> camisetas){
        this.camisetas.addAll(camisetas);
    }
    
    public void agregarCamiseta (CamisetaDTO camiseta){
        camisetas.add(camiseta);
    }
    
    public void eliminarCamiseta(CamisetaDTO camiseta){
        camisetas.remove(camiseta);
    }
    
    public void eliminarListaDeCamisetas(List<CamisetaDTO> aEliminar){
        camisetas.removeAll(aEliminar);
    }
    
    public void setFactura(FacturaDTO nFactura){
        factura = nFactura;
    }
    
    public FacturaDTO getFactura(){
        return factura;
    }
}

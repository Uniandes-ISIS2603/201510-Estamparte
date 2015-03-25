/*
 * DTO de la estampa
 */
package co.edu.uniandes.estamparte.comprador.logic.dto;

import co.edu.uniandes.estamparte.carrito.logic.dto.*;
import co.edu.uniandes.estamparte.artista.logic.dto.*;
import co.edu.uniandes.estamparte.camiseta.logic.dto.*;
import co.edu.uniandes.estamparte.estampa.logic.dto.*;
import co.edu.uniandes.estamparte.formaPago.logic.dto.FormaPagoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CompradorDTO 
{
    private String nombre;
    private String id;
    private CarritoDTO carrito;
    private List<FormaPagoDTO> formasPago;
    
    public String getNombre()
    {
        return nombre;
    }
    
    public void setNombre(String pNom)
    {
        nombre = pNom;
    }
    public String getId()
    {
        return id;
    }
    
    public void setId(String pId)
    {
        id = pId;
    }
    
    public CarritoDTO getCarrito()
    {
        return carrito;
    }
    
    public void setCarrito(CarritoDTO pCarrito)
    {
        carrito = pCarrito;
    }
    
    public void agregarFormaPago(FormaPagoDTO formaPago){
        formasPago.add(formaPago);
    }
    
    public void eliminarFormasPago(){
        formasPago = new ArrayList<FormaPagoDTO>();
    }
    
    public void eliminarFormaPago(FormaPagoDTO formaPago){
        formasPago.remove(formaPago);
    }
    
    public List<FormaPagoDTO> darFormasPago(){
        return formasPago;
    }
    
    public void asignarFormasPago(List<FormaPagoDTO> nuevasFormasPago){
        formasPago = nuevasFormasPago;
    }
}

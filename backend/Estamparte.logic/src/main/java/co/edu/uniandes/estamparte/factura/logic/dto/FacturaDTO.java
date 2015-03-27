/*
 * DTO de la estampa
 */
package co.edu.uniandes.estamparte.factura.logic.dto;

import co.edu.uniandes.estamparte.camiseta.logic.dto.CamisetaDTO;
import co.edu.uniandes.estamparte.carrito.logic.dto.CarritoDTO;
import co.edu.uniandes.estamparte.comprador.logic.dto.CompradorDTO;
import co.edu.uniandes.estamparte.estampa.logic.dto.*;
import co.edu.uniandes.estamparte.formaPago.logic.dto.FormaPagoDTO;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;
import java.util.Date;
import java.util.List;

@XmlRootElement
public class FacturaDTO {
    
    private CompradorDTO comprador;
    private FormaPagoDTO formaPago;
    private String fechaCompra;
    private long id;
    private CarritoDTO carrito;
    
    public List<CamisetaDTO> getArticulos(){
        return carrito.getCamisetas();
    }
       
    public void setCarrito(CarritoDTO pCarrito)
    {
        carrito = pCarrito;
    }
    
    public CarritoDTO getCarrito()
    {
        return carrito;
    }
    
    public void setComprador(CompradorDTO pComprador)
    {
        comprador = pComprador;
    }
    
    public CompradorDTO getComprador()
    {
        return comprador;
    }
    
    public String getNombreComprador()
    {
        return comprador.getNombre();
    }
    
    public String getIdComprador()
    {
        return comprador.getId();
    }
    
    public void setFormaPago(FormaPagoDTO pFormaPago)
    {
        formaPago = pFormaPago;
    }
    
    public FormaPagoDTO getFormaPago()
    {
        return formaPago;
    }
    
    public String getTipoFormPago()
    {
        return formaPago.getNombre();
    }
    
    public Long getNumeroTarjeta()
    {
        return formaPago.getNumTarjeta();
    }
    
    public Date getFechaVencimiento()
    {
        return formaPago.getFechaVencimiento();
    }
    
    public int getCodigoSeguridad()
    {
        return formaPago.getCodSeguridad();                
    }
    
    public String getDireccionCorrespondencia()
    {
        return formaPago.getDireccion();
    }
    
    public double getMontoTotal()
    {
        double respuesta = 0;
        for(int i=0; i<carrito.getCamisetas().size();i++)
        {
            respuesta += carrito.getCamisetas().get(i).getCosto();
        }
        return respuesta;
    }
    
    public void setFechaCompra(String pFecha)
    {
        fechaCompra = pFecha;
    }
    
    public String getFechaCompra()
    {
        return fechaCompra;
    }
    
    public void setIdFactura(Long pId)
    {
        id = pId;
    }
    
    public Long getIdFactura()
    {
        return id;
    }
}
                                     
/*
 * DTO de la estampa
 */
package co.edu.uniandes.estamparte.factura.logic.dto;

import co.edu.uniandes.estamparte.camiseta.logic.dto.CamisetaDTO;
import co.edu.uniandes.estamparte.comprador.logic.dto.CompradorDTO;
import co.edu.uniandes.estamparte.estampa.logic.dto.*;
import co.edu.uniandes.estamparte.fromaPago.logic.dto.FormaPagoDTO;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

public class FacturaDTO {
    
    private CompradorDTO comprador;
    private FormaPagoDTO formaPago;
    private String fechaCompra;
    private long id;
    private ArrayList<CamisetaDTO> articulos;
    
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
    
    public void setArticulos(ArrayList<CamisetaDTO> pCamisetas)
    {
        articulos = pCamisetas;
    }
    
    public ArrayList<CamisetaDTO> getArticulos()
    {
        return articulos;
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
        return formaPago.getTipo();
    }
    
    public Long getNumeroTarjeta()
    {
        return formaPago.getNumeroTarjeta();
    }
    
    public String getFechaVencimiento()
    {
        return formaPago.getFechaVencimiento();
    }
    
    public int getCodigoSeguridad()
    {
        return formaPago.getCodigoSeguridad();                
    }
    
    public String getDireccionCorrespondencia()
    {
        return formaPago.getDireccionCorrespondencia();
    }
    
    public double getMontoTotal()
    {
        double respuesta = 0;
        for(int i=0; i<articulos.size();i++)
        {
            respuesta += articulos.get(i).getCosto();
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
                                     
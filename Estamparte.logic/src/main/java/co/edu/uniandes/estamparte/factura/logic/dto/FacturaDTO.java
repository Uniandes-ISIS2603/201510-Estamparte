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
    
    private long idComprador;
    private long idFormaPago;
    private String fechaCompra;
    private long id;
    private long idCarrito;

    public long getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(long idComprador) {
        this.idComprador = idComprador;
    }

    public long getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(long idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(long idCarrito) {
        this.idCarrito = idCarrito;
    }
    

}
                                     

/*
 * DTO de la estampa
 */
package co.edu.uniandes.estamparte.factura.logic.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FacturaDTO {
    
    private long idComprador;
    private long idFormaPago;
    private String fechaCompra;
    private long id;
    private long idCarrito;
    private double monto;
    
    public double getMonto(){
        return monto;
    }
    
    public void setMonto(double monto){
        this.monto  = monto;
    }

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
                                     

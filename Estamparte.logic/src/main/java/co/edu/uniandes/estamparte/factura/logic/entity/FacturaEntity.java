/*
 * Entidad de estampa
 */
package co.edu.uniandes.estamparte.factura.logic.entity;

import co.edu.uniandes.estamparte.camiseta.logic.entity.CamisetaEntity;
import co.edu.uniandes.estamparte.carrito.logic.entity.CarritoEntity;
import co.edu.uniandes.estamparte.comprador.logic.entity.CompradorEntity;
import co.edu.uniandes.estamparte.formaPago.logic.entity.FormaPagoEntity;
import java.util.*;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class FacturaEntity {
    
    @ManyToOne
    @JoinColumn(name="COMPRADOR_ID")
    private CompradorEntity comprador;
    
    @OneToOne
    @JoinColumn(name="FORMAPAGO_ID")
    private FormaPagoEntity formaPago;
    
    private String fechaCompra;
    
    @Id
    @GeneratedValue(generator="Factura")
    @Column(name="FACTURA_ID")
    private long id;
    
    @OneToOne
    @JoinColumn(name="CARRITO_ID")
    private CarritoEntity carrito;
    
    private double monto;
    
    public void setMonto(double monto){
        this.monto = monto;
    }
    
    public double getMonto(){
        return monto;
    }
    
    public List<CamisetaEntity> getArticulos(){
        return carrito.getCamisetas();
    }
    
    public void setCarrito(CarritoEntity pCarrito)
    {
        carrito = pCarrito;
    }
    
    public CarritoEntity getCarrito()
    {
        return carrito;
    }
    
    public void setComprador(CompradorEntity pComprador)
    {
        comprador = pComprador;
    }
    
    public CompradorEntity getComprador()
    {
        return comprador;
    }
    
    public String getNombreComprador()
    {
        return comprador.getNombre();
    }
    
    public long getIdComprador()
    {
        return comprador.getId();
    }
    
    public void setFormaPago(FormaPagoEntity pFormaPago)
    {
        formaPago = pFormaPago;
    }
    
    public FormaPagoEntity getFormaPago()
    {
        return formaPago;
    }
    
    public String getTipoFormPago()
    {
        return formaPago.getNombre();
    }
    
    public Long getNumeroTarjeta()
    {
        return formaPago.getNumeroTarjeta();
    }
    
    public Date getFechaVencimiento()
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
        List<CamisetaEntity> camisetas = carrito.getCamisetas();
        for (int i=0; i<camisetas.size();i++)
        {
            respuesta += camisetas.get(i).getCosto();
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

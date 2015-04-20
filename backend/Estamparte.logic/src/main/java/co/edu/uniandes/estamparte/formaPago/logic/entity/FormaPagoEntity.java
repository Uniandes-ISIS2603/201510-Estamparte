/*
 * Entidad de estampa
 */
package co.edu.uniandes.estamparte.formaPago.logic.entity;

import co.edu.uniandes.estamparte.comprador.logic.entity.CompradorEntity;
import co.edu.uniandes.estamparte.factura.logic.entity.FacturaEntity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class FormaPagoEntity {
    
    @Id
    @GeneratedValue(generator = "FormaPago")
    @Column(name="FORMAPAGO_ID")
    private Long numeroTarjeta;
    
    private String nombre;
    
    @ManyToOne
    @JoinColumn(name="COMPRADOR_ID")
    private CompradorEntity comprador;
    
    @OneToOne
    @JoinColumn(name="FACTURA_ID")
    private FacturaEntity factura;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaVencimiento;
    
    private int codigoSeguridad;
    
    private String direccionCorrespondencia;
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nNombre){
        nombre = nNombre;
    }
    
    public CompradorEntity getComprador(){
        return comprador;
    }
    
    public void setComprador(CompradorEntity nCliente){
        comprador = nCliente;
    }
    
    public void setFechaVencimiento(Date fecha){
        fechaVencimiento = fecha;
    }
    
    public Date getFechaVencimiento(){
        return fechaVencimiento;
    }
    
    public long getNumTarjeta(){
        return numeroTarjeta;
    }
    
    public void setNumTarjeta(long nNumTarjeta){
        numeroTarjeta = nNumTarjeta;
    } 
    
    public int getCodSeguridad(){
        return codigoSeguridad;
    }
    
    public void setCodSeguridad(int nCodSeguridad){
        codigoSeguridad = nCodSeguridad;
    }
    
    public String getDireccion(){
        return direccionCorrespondencia;
    }
    
    public void setDireccion(String nDireccion){
        direccionCorrespondencia = nDireccion;
    } 
    
    public FacturaEntity getFactura(){
        return factura;
    }
    
    public void setFactura(FacturaEntity pFactura){
        factura = pFactura;
    }
}

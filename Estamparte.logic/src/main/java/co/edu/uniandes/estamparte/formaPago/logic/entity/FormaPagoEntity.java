/*
 * Entidad de estampa
 */
package co.edu.uniandes.estamparte.formaPago.logic.entity;

import co.edu.uniandes.estamparte.comprador.logic.entity.CompradorEntity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class FormaPagoEntity {
    
    //Id autogenerado
    @Id
    @GeneratedValue(generator = "FormaPago")
    @Column(name="FORMAPAGO_ID")
    private long id;
    
    //Nombre de la forma de pago
    private String nombre;
    
    //Tipo de la forma de pago
    private String tipo;
    
    //Numero de tarjeta
    private long numeroTarjeta;
    
    //Fecha de vencimiento
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaVencimiento;
    
    //Codigo de seguridad
    private int codigoSeguridad;
    
    //Direccion de correspondencia
    private String direccionCorrespondencia;
    
    //Comprador duenio
    @ManyToOne
    @JoinColumn(name="COMPRADOR_ID")
    private CompradorEntity comprador;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public long getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(long numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(int codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    public String getDireccionCorrespondencia() {
        return direccionCorrespondencia;
    }

    public void setDireccionCorrespondencia(String direccionCorrespondencia) {
        this.direccionCorrespondencia = direccionCorrespondencia;
    }

    public CompradorEntity getComprador() {
        return comprador;
    }

    public void setComprador(CompradorEntity comprador) {
        this.comprador = comprador;
    }
        

    
    
}

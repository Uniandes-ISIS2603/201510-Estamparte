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
    
    private Date fechaVencimiento;
    
    private int codigoSeguridad;
    
    private String direccionCorrespondencia;
    
    public String darNombre(){
        return nombre;
    }
    
    public void asignarNombre(String nNombre){
        nombre = nNombre;
    }
    
    public CompradorEntity darComprador(){
        return comprador;
    }
    
    public void asignarComprador(CompradorEntity nIdCliente){
        comprador = nIdCliente;
    }
    
    public void asignarFechaVencimiento(Date fecha){
        fechaVencimiento = fecha;
    }
    
    public Date darFechaVencimiento(){
        return fechaVencimiento;
    }
    
    public long darNumTarjeta(){
        return numeroTarjeta;
    }
    
    public void asignarNumTarjeta(long nNumTarjeta){
        numeroTarjeta = nNumTarjeta;
    } 
    
    public int darCodSeguridad(){
        return codigoSeguridad;
    }
    
    public void asignarCodSeguridad(int nCodSeguridad){
        codigoSeguridad = nCodSeguridad;
    }
    
    public String darDireccion(){
        return direccionCorrespondencia;
    }
    
    public void asignarDireccion(String nDireccion){
        direccionCorrespondencia = nDireccion;
    } 
}

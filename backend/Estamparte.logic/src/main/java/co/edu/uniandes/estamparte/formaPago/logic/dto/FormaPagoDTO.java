/*
 * DTO de la estampa
 */
package co.edu.uniandes.estamparte.formaPago.logic.dto;

import co.edu.uniandes.estamparte.comprador.logic.dto.CompradorDTO;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FormaPagoDTO {
    
    private String nombre;
    
    private CompradorDTO idComprador;
    
    private Long numeroTarjeta;
    
    private Date fechaVencimiento;
    
    private int codigoSeguridad;
    
    private String direccionCorrespondencia;
    
    public String darNombre(){
        return nombre;
    }
    
    public void asignarNombre(String nNombre){
        nombre = nNombre;
    }
    
    public CompradorDTO darComprador(){
        return idComprador;
    }
    
    public void asignarComprador(CompradorDTO nComprador){
        idComprador = nComprador;
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
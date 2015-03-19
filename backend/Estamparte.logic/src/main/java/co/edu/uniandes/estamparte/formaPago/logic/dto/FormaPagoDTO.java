/*
 * DTO de la estampa
 */
package co.edu.uniandes.estamparte.formaPago.logic.dto;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FormaPagoDTO {
    
    private String nombre;
    
    private Long numeroTarjeta;
    
    private Date fechaVencimiento;
    
    private int codigoSeguridad;
    
    private String direccionCorrespondencia;
    
     public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nNombre){
        nombre = nNombre;
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
}
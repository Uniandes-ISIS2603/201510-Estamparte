/*
 * DTO de la estampa
 */
package co.edu.uniandes.estamparte.formaPago.logic.dto;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FormaPagoDTO {
    
    //Id
    private long id;
    
    //Nombre de la forma de pago
    private String nombre;
    
    //Tipo de la forma de pago
    private String tipo;
    
    //Numero de tarjeta
    private long numeroTarjeta;
    
    //Fecha de vencimiento
    private String fechaVencimiento;
    
    //Codigo de seguridad
    private int codigoSeguridad;
    
    //Direccion de correspondencia
    private String direccionCorrespondencia;
    
    //Id del comprador duenio
    private long idComprador;

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

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
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
    
    public long getIdComprador(){
        return idComprador;
    }
    
    public void setIdComprador(long idComprador){
        this.idComprador = idComprador;
    }
    
  
}
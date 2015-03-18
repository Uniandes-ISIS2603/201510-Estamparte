/*
 * DTO de la estampa
 */
package co.edu.uniandes.estamparte.fromaPago.logic.dto;

import co.edu.uniandes.estamparte.factura.logic.dto.*;
import co.edu.uniandes.estamparte.estampa.logic.dto.*;


public class FormaPagoDTO {
    private String tipo;
    private long numeroTarjeta;
    private String fechaVencimiento;
    private int codigoSeguridad;
    private String direccionCorrespondencia;
    
    public void setTipo(String pTipo)
    {
        tipo = pTipo;
    }
    public String getTipo()
    {
        return tipo;
    }    
    public void setNumeroTarjeta(Long pNum)
    {
        numeroTarjeta = pNum;
    }
    public Long getNumeroTarjeta()
    {
        return numeroTarjeta;
    }
    public void setFechaVencimiento(String pFecha)
    {
        fechaVencimiento = pFecha;
    }
    public String getFechaVencimiento()
    {
        return fechaVencimiento;
                
    }
    
    public void setCodigoSeguridad(int pCodigo)
    {
        codigoSeguridad = pCodigo;
    }
    public int getCodigoSeguridad()
    {
        return codigoSeguridad;
    }
    
    public void setDireccioncorrespondencia(String pDireccion)
    {
        direccionCorrespondencia = pDireccion;
    }
    public String getDireccionCorrespondencia()
    {
        return direccionCorrespondencia;
    }
}
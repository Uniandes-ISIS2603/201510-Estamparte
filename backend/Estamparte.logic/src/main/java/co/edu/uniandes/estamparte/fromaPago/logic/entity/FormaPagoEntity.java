/*
 * Entidad de estampa
 */
package co.edu.uniandes.estamparte.fromaPago.logic.entity;

import co.edu.uniandes.estamparte.factura.logic.entity.*;
import co.edu.uniandes.estamparte.estampa.logic.entity.*;

public class FormaPagoEntity {
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
    
    public void setDireccionCorrespondencia(String pDireccion)
    {
        direccionCorrespondencia = pDireccion;
    }
    public String getDireccionCorrespondencia()
    {
        return direccionCorrespondencia;
    }
}

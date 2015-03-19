/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.estamparte.estamparte.service;

import co.edu.uniandes.estamparte.fromaPago.logic.api.IFormaPagoLogic;
import co.edu.uniandes.estamparte.fromaPago.logic.dto.FormaPagoDTO;
import co.edu.uniandes.estamparte.fromaPago.logic.dto.FormaPagoPageDTO;
import java.util.ArrayList;

/**
 *
 * @author estudiante
 */
public class ServicioFormaPago {
    
    @Inject
    protected IFormaPagoLogic formaPagoLogic;
    
    @POST
    public FormaPagoDTO createFormaPago(FormaPagoDTO detalles)
    {
        return formaPagoLogic.createFormaPago(detalles);
    }
    
    @GET
    public FormaPagoPageDTO getFormaPago(Integer numPagina, Integer maxRecords)
    {
        return formaPagoLogic.getFormaPago(numPagina, maxRecords);
    }
    
    @GET
    public ArrayList<FormaPagoDTO> getFormasPago()
    {
        return formaPagoLogic.getFormasPago();
    }
    
    @GET
    public FormaPagoDTO getFormaPago(Long id)
    {
        return formaPagoLogic.getFormaPago(id);
    }
    
    @DELETE
    public FormaPagoDTO deleteFormaPago(Long id)
    {
        return formaPagoLogic.deleteFormaPago(id);
    }
    
    @PUT
    public void updateFormaPago(FormaPagoDTO detalles)
    {
        formaPagoLogic.updateFormaPago(detalles);
    }
    
}

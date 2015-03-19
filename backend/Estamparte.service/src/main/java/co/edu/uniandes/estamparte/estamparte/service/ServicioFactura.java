/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.estamparte.estamparte.service;

import co.edu.uniandes.estamparte.factura.logic.api.IFacturaLogic;
import co.edu.uniandes.estamparte.factura.logic.dto.FacturaDTO;
import java.util.*;
import javax.ejb.Stateless;
import javax.ws.rs.Produces;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/factura")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ServicioFactura 
{
    @Inject
    protected IFacturaLogic facturalogic;
    
    @POST
    public FacturaDTO createFactura(FacturaDTO detalles)    {
        return facturalogic.createFactura(detalles);
    }
    
        
    @GET
    public List<FacturaDTO> getFacturas()
    {
        return facturalogic.getFacturas();
    }
    
    @GET
    public FacturaDTO getFactura(Long id){
        return facturalogic.getFactura(id);
    }
    
    @DELETE
    public FacturaDTO deleteFactura(Long id){
        return facturalogic.deleteFactura(id);
    }
            
    @PUT
    public void updateFactura(FacturaDTO detalles){
        facturalogic.updateFactura(detalles);
    }
    
}

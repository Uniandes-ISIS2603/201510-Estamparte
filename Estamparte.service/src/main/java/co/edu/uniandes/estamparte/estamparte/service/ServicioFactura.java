/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.estamparte.estamparte.service;

import co.edu.uniandes.estamparte.factura.logic.api.IFacturaLogic;
import co.edu.uniandes.estamparte.factura.logic.dto.FacturaDTO;
import javax.ejb.Stateless;
import javax.ws.rs.Produces;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("/factura")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ServicioFactura 
{
    @Inject
    protected IFacturaLogic facturalogic;
    
    @GET
    @Path("/{id}")
    public FacturaDTO getFactura(@PathParam("id")long id){
        return facturalogic.getFactura(id);
    }
    
    @DELETE
    @Path("/{id}")
    public FacturaDTO deleteFactura(@PathParam("id")long id){
        return facturalogic.deleteFactura(id);
    }
               
}

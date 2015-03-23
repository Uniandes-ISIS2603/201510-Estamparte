/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.estamparte.estamparte.service;

import co.edu.uniandes.estamparte.formaPago.logic.dto.FormaPagoDTO;
import co.edu.uniandes.estamparte.formaPago.logic.api.IFormaPagoLogic;
import co.edu.uniandes.estamparte.formaPago.logic.dto.FormaPagoPageDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author estudiante
 */
@Path("/formaPago")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ServicioFormaPago {

    @Inject
    protected IFormaPagoLogic formaPago;
    
    @POST
    public FormaPagoDTO crearFormaPago (FormaPagoDTO formaPago){
        
    }
        
    @GET
    public FormaPagoPageDTO darFormasPago(@QueryParam("pagina")Integer pagina, @QueryParam("datosMaximos")Integer datosMaximos){
        
    }
    
    @PUT
    public void actualizarFormaPago(FormaPagoDTO formaPago){
        
    }
    
    @GET
    public List<FormaPagoDTO> darFormasPago(){
        
    }
    
    @DELETE
    public void eliminarFormaPago(@PathParam("id")Long id){
        
    }
    
    @DELETE
    public void eliminarFormasPago(){
        
    }
}

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
    protected IFormaPagoLogic formaPagoLogic;
    
    /*
    @POST
    public FormaPagoDTO crearFormaPago (FormaPagoDTO formaPago){
        return formaPagoLogic.crearFormaPago(formaPago);
    }
    */
        
    @GET
    public FormaPagoPageDTO darFormasPago(@QueryParam("pagina")Integer pagina, @QueryParam("datosMaximos")Integer datosMaximos){
        return formaPagoLogic.darFormasPago(pagina, datosMaximos);
    }
    
    @PUT
    @Path("{FORMAPAGO_ID}")
    public void actualizarFormaPago(@PathParam("FORMAPAGO_ID")Long id, FormaPagoDTO formaPago){
        formaPagoLogic.actualizarFormaPago(formaPago);
    }
    
    
    @DELETE
    @Path("{FORMAPAGO_ID}")
    public void eliminarFormaPago(@PathParam("FORMAPAGO_ID")Long id){
        formaPagoLogic.eliminarFormaPago(id);
    }
    
    @DELETE
    public void eliminarFormasPago(){
        formaPagoLogic.eliminarFormasPago();
    }
}

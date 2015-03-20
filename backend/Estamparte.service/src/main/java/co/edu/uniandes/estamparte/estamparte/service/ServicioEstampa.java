/*
 * Servicios REST de la estampa
 */
package co.edu.uniandes.estamparte.estamparte.service;

import co.edu.uniandes.estamparte.estampa.logic.api.IEstampaLogic;
import co.edu.uniandes.estamparte.estampa.logic.dto.EstampaDTO;
import co.edu.uniandes.estamparte.estampa.logic.dto.EstampaPageDTO;
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

@Path("/estampas")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ServicioEstampa {
    
    @Inject
    protected IEstampaLogic servicioLogicaEstampa;
    
    @POST
    public EstampaDTO crearEstampa(EstampaDTO estampa){
        return servicioLogicaEstampa.crearEstampa(estampa);
    }
    
    @DELETE
    @Path("{id}")
    public EstampaDTO eliminarEstampa(@PathParam("id")Long id){
        return servicioLogicaEstampa.eliminarEstampa(id);
    }
    
    @GET
    public EstampaPageDTO darEstampas(@QueryParam("pagina") Integer pagina, @QueryParam("datosMaximos") Integer datosMaximos){
        return servicioLogicaEstampa.obtenerEstampas(pagina, datosMaximos);
    }
    
    @GET
    @Path("{id}")
    public EstampaDTO darEstampa(@PathParam("id")Long id){
        return servicioLogicaEstampa.darEstampa(id);
    }
    
    @PUT
    public EstampaDTO actualizarEstampa(@PathParam("id")Long id, EstampaDTO estampa){
        return servicioLogicaEstampa.actualizarEstampa(estampa);
    }
    
}

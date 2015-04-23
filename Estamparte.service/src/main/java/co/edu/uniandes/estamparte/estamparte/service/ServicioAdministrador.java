/*
 * Servicios REST del artista
 */
package co.edu.uniandes.estamparte.estamparte.service;

import co.edu.uniandes.estamparte.administrador.logic.api.IAdministradorLogic;
import co.edu.uniandes.estamparte.administrador.logic.dto.AdministradorDTO;
import co.edu.uniandes.estamparte.artista.logic.api.IArtistaLogic;
import co.edu.uniandes.estamparte.artista.logic.dto.ArtistaDTO;
import co.edu.uniandes.estamparte.artista.logic.dto.ArtistaPageDTO;
import co.edu.uniandes.estamparte.estampa.logic.api.IEstampaLogic;
import co.edu.uniandes.estamparte.estampa.logic.dto.EstampaDTO;
import co.edu.uniandes.estamparte.estampa.logic.dto.EstampaPageDTO;
import java.util.ArrayList;
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
import org.apache.catalina.logger.SystemOutLogger;

@Path("/administrador")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ServicioAdministrador {
    
    @Inject
    protected IAdministradorLogic servicioLogicaAdmin;
    
    @Inject
    protected IEstampaLogic servicioLogicaEstampa;
    
    @POST
    public AdministradorDTO crearAdmin(AdministradorDTO admin){
        return servicioLogicaAdmin.crearAdministrador(admin);
    }
    
    
    @GET
    @Path("{id}")
    public AdministradorDTO darAdmin(@PathParam("id")Long id){
        return servicioLogicaAdmin.getAdministrador(id);
    }
    
    @GET
    public List<AdministradorDTO> darAdministradores(){
        return servicioLogicaAdmin.obtenerAdministradores();
    }
    
    @PUT
    @Path("{id}")
    public AdministradorDTO doActualizarAdministrador(@PathParam("id")Long id, AdministradorDTO admin) {
        return servicioLogicaAdmin.actualizarAdministrador(admin);
    }
    
    @DELETE
    public void eliminarAdministradores(){
        servicioLogicaAdmin.eliminarAdministradores();
    }
    
    @DELETE
    @Path("{id}")
    public AdministradorDTO eliminarAdmin(@PathParam("id")Long id){
        return servicioLogicaAdmin.eliminarAdministrador(id);
    }
    

    
}

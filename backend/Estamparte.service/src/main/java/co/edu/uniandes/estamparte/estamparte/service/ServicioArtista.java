/*
 * Servicios REST del artista
 */
package co.edu.uniandes.estamparte.estamparte.service;

import co.edu.uniandes.estamparte.artista.logic.api.IArtistaLogic;
import co.edu.uniandes.estamparte.artista.logic.dto.ArtistaDTO;
import co.edu.uniandes.estamparte.artista.logic.dto.ArtistaPageDTO;
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

@Path("/artistas")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ServicioArtista {
    
    @Inject
    protected IArtistaLogic servicioLogicaArtista;
    
    @POST
    public ArtistaDTO crearArtista(ArtistaDTO artista){
        return servicioLogicaArtista.crearArtista(artista);
    }
    
    @GET
    public ArtistaPageDTO darArtistas(@QueryParam("pagina")Integer pagina, @QueryParam("datosMaximos")Integer datosMaximos){
        return servicioLogicaArtista.obtenerArtistas(pagina, datosMaximos);
    }
    
    @GET
    @Path("{id}")
    public ArtistaDTO darArtista(@PathParam("id")Long id){
        return servicioLogicaArtista.darArtista(id);
    }
    
    @PUT
    @Path("{id}")
    public ArtistaDTO doActualizarArtista(@PathParam("id")Long id, ArtistaDTO artista) {
        return servicioLogicaArtista.actualizarArtista(artista);
    }
    
    @DELETE
    public void eliminarArtistas(){
        servicioLogicaArtista.eliminarArtistas();
    }
    
    @DELETE
    @Path("{id}")
    public ArtistaDTO eliminarArtista(@PathParam("id")Long id){
        return servicioLogicaArtista.eliminarArtista(id);
    }
    
    @POST
    @Path("{id}/estampas")
    public EstampaDTO crearEstampaDeArtista(@PathParam("id")Long id,EstampaDTO estampa){
        return servicioLogicaArtista.crearEstampaDeArtista(id, estampa);
    }
    
    @DELETE
    @Path("{id}/estampas/{id2}")
    public EstampaDTO eliminarEstampaDeArtista(@PathParam("id")Long idArtista, @PathParam("id2")Long idEstampa){
        return servicioLogicaArtista.eliminarEstampaDeArtista(idArtista, idEstampa);
    }
    
    @GET
    @Path("{id}/estampas")
    public EstampaPageDTO obtenerEstampasDeArtista(@PathParam("id")Long id, @QueryParam("pagina")Integer pagina, @QueryParam("datosMaximos")Integer datosMaximos){
        return servicioLogicaArtista.obtenerEstampasDeArtista(id, pagina, datosMaximos);
    }
    
    @PUT
    @Path("{id}/estampas/{id2}")
    public EstampaDTO actualizarEstampaDeArtista(@PathParam("id")Long idArtista,@PathParam("id2")Long idEstampa, EstampaDTO estampa){
        return servicioLogicaArtista.actualizarEstampaDeArtista(idArtista, estampa);
    }

    
}

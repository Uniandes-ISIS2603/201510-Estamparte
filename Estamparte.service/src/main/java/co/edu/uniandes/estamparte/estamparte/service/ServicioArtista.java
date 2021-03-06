/*
 * Servicios REST del artista
 */
package co.edu.uniandes.estamparte.estamparte.service;

import co.edu.uniandes.estamparte.artista.logic.api.IArtistaLogic;
import co.edu.uniandes.estamparte.artista.logic.dto.ArtistaDTO;
import co.edu.uniandes.estamparte.artista.logic.dto.ArtistaPageDTO;
import co.edu.uniandes.estamparte.estampa.logic.api.IEstampaLogic;
import co.edu.uniandes.estamparte.estampa.logic.dto.EstampaDTO;
import co.edu.uniandes.estamparte.estampa.logic.dto.EstampaPageDTO;
import co.edu.uniandes.estamparte.estampaImgPersistence.logic.api.IImgPersistenceLogic;
import co.edu.uniandes.estamparte.estampaImgPersistence.logic.dto.ImgDTO;
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
    
    @Inject
    protected IEstampaLogic servicioLogicaEstampa;
    
    @Inject IImgPersistenceLogic servicioLogicaImg;
    
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
    public ArtistaDTO actualizarArtista(@PathParam("id")Long id, ArtistaDTO artista) {
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
    @Path("/{id}/estampas")
    public EstampaDTO crearEstampaDeArtista(@PathParam("id")Long id,EstampaDTO estampa){
        return servicioLogicaArtista.crearEstampaDeArtista(id, estampa,servicioLogicaEstampa);
    }
    
  
    @DELETE
    @Path("{id}/estampas/{id2}")
    public EstampaDTO eliminarEstampaDeArtista(@PathParam("id")Long idArtista, @PathParam("id2")Long idEstampa){
        return servicioLogicaArtista.eliminarEstampaDeArtista(idArtista, idEstampa, servicioLogicaEstampa);
    }
    
    @GET
    @Path("{id}/estampas")
    public EstampaPageDTO obtenerEstampasDeArtista(@PathParam("id")Long id, @QueryParam("pagina")Integer pagina, @QueryParam("datosMaximos")Integer datosMaximos){
        return servicioLogicaArtista.obtenerEstampasDeArtista(id, pagina, datosMaximos, servicioLogicaEstampa);
    }
    
    @PUT
    @Path("{id}/estampas/{id2}")
    public EstampaDTO actualizarEstampaDeArtista(@PathParam("id")Long idArtista,@PathParam("id2")Long idEstampa, EstampaDTO estampa){
        return servicioLogicaArtista.actualizarEstampaDeArtista(idArtista, estampa, servicioLogicaEstampa);
    }
    
    //Serializacion de imagen de estampa
    @POST
    @Path("/{id}/estampas/img")
    public String createImagen(@PathParam("id")Long idArtista, ImgDTO img){
        return servicioLogicaImg.createEstampaImagen(img);
    }
    
    @PUT
    @Path("{id}/estampas/{id2}/img")
    public String updateImagen(@PathParam("id")Long idArtista, @PathParam("id2")Long idEstampa, ImgDTO img){
        return servicioLogicaImg.updateImagen(img);
    }
    
    @DELETE
    @Path("{id}/estampas/{id2}/img")
    public void deleteImagen(@PathParam("id")Long idArtista, @PathParam("id2")Long idEstampa, String urlImg){
        servicioLogicaImg.deleteImagen(urlImg);
    }
   

    
}

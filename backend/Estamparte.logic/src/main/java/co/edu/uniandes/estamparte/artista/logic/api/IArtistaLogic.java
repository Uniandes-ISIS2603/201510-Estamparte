/*
 * Funcionalidades de la estampa
 */
package co.edu.uniandes.estamparte.artista.logic.api;

import co.edu.uniandes.estamparte.artista.logic.dto.ArtistaDTO;
import co.edu.uniandes.estamparte.artista.logic.dto.ArtistaPageDTO;
import co.edu.uniandes.estamparte.estampa.logic.api.IEstampaLogic;
import co.edu.uniandes.estamparte.estampa.logic.dto.EstampaDTO;
import co.edu.uniandes.estamparte.estampa.logic.dto.EstampaPageDTO;
import java.util.List;

public interface IArtistaLogic {
    
    //Crea un nuevo artista
    public ArtistaDTO crearArtista(ArtistaDTO artista);
    
    //Obtiene todos los artistas registrador
    public List<ArtistaDTO> obtenerArtistas();
    
    //Obtiene todos los artistas de acuerdo a paginacion
    public ArtistaPageDTO obtenerArtistas(Integer pagina, Integer datosMaximos);
    
    //Obtiene un artista con un id determinado
    public ArtistaDTO darArtista(Long id);
    
    //Actualiza un artista
    public ArtistaDTO actualizarArtista(ArtistaDTO artista);
    
    //Elimina todos los artistas
    public void eliminarArtistas();
    
    //Elimina un artista con el id dado
    public ArtistaDTO eliminarArtista(Long id);
    
    //Funcionalidades para estampas de un artista
    
    //Crea una nueva estampa de un artista
    public EstampaDTO crearEstampaDeArtista(Long idArtista, EstampaDTO estampa,IEstampaLogic servicioLogicaEstampa);
    
    
    //Elimina una estampa de un artista
    public EstampaDTO eliminarEstampaDeArtista(Long idArtista, Long idEstampa, IEstampaLogic servicioLogicaEstampa);
    
    //Obtiene las estampas de un artista dado
    public EstampaPageDTO obtenerEstampasDeArtista(Long idArtista, Integer pagina, Integer datosMaximos, IEstampaLogic servicioLogicaEstampa);
    
    //Actualiza la estampa de un artista dado
    public EstampaDTO actualizarEstampaDeArtista(Long idArtista, EstampaDTO estampa, IEstampaLogic servicioLogicaEstampa);
    
    
}

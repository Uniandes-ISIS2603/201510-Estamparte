/*
 * Funcionalidades de la estampa
 */
package co.edu.uniandes.estamparte.artista.logic.api;

import co.edu.uniandes.estamparte.artista.logic.dto.ArtistaDTO;
import co.edu.uniandes.estamparte.artista.logic.dto.ArtistaPageDTO;
import co.edu.uniandes.estamparte.estampa.logic.dto.EstampaDTO;
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
    
    
}

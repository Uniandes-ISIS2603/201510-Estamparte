/*
 * Funcionalidades de la estampa
 */
package co.edu.uniandes.estamparte.artista.logic.api;

import co.edu.uniandes.estamparte.artista.logic.dto.ArtistaDTO;
import co.edu.uniandes.estamparte.artista.logic.dto.ArtistaPageDTO;
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
    
    //Elimina un artista con l
}

/*
 * Funcionalidades de la estampa
 */
package co.edu.uniandes.estamparte.estampa.logic.api;

import co.edu.uniandes.estamparte.estampa.logic.dto.EstampaDTO;
import java.util.List;


public interface IEstampaLogic {
    
    //Crea una nueva estampa
    public EstampaDTO crearEstampa(EstampaDTO estampa);
    
    //Elimina una estampa con el id dado
    public EstampaDTO eliminarEstampa(Long id);
    
    //Obtiene las estampas guardadas
    public List<EstampaDTO> obtenerEstampas();
    
    //Obtiene las estampas guardadas de acuerdo a paginacion
    public List<EstampaDTO> obtenerEstampas(Integer pagina, Integer datosMaximos);
    
    //Obtiene las estampas de un artista con un id dado
    public List<EstampaDTO> obtenerEstampasDeArtista(Long id);
    
    //Actualiza la informacion de una estampa
    public EstampaDTO actualizarEstampa(EstampaDTO estampa);
    
   
}

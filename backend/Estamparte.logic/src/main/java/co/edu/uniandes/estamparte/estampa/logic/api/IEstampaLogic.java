/*
 * Funcionalidades de la estampa
 */
package co.edu.uniandes.estamparte.estampa.logic.api;

import co.edu.uniandes.estamparte.estampa.logic.dto.EstampaDTO;
import co.edu.uniandes.estamparte.estampa.logic.dto.EstampaPageDTO;
import java.util.List;


public interface IEstampaLogic {
    
    //Crea una nueva estampa
    public EstampaDTO crearEstampa(EstampaDTO estampa);
    
    //Elimina una estampa con el id dado
    public EstampaDTO eliminarEstampa(Long id);
    
    //Obtiene las estampas guardadas
    public List<EstampaDTO> obtenerEstampas();
    
    //Obtiene las estampas guardadas de acuerdo a paginacion
    public EstampaPageDTO obtenerEstampas(Integer pagina, Integer datosMaximos);
    
    //Obtiene una estampa con un id dado
    public EstampaDTO darEstampa(Long id);
    
    //Actualiza la informacion de una estampa
    public EstampaDTO actualizarEstampa(EstampaDTO estampa);
    
    
   
}

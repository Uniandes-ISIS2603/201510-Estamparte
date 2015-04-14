/*
 * Funcionalidades de la estampa
 */
package co.edu.uniandes.estamparte.administrador.logic.api;

import co.edu.uniandes.estamparte.administrador.logic.dto.AdministradorDTO;
import co.edu.uniandes.estamparte.administrador.logic.dto.AdministradorPageDTO;
import co.edu.uniandes.estamparte.artista.logic.api.*;
import co.edu.uniandes.estamparte.artista.logic.dto.ArtistaDTO;
import co.edu.uniandes.estamparte.artista.logic.dto.ArtistaPageDTO;
import co.edu.uniandes.estamparte.estampa.logic.api.IEstampaLogic;
import co.edu.uniandes.estamparte.estampa.logic.dto.EstampaDTO;
import co.edu.uniandes.estamparte.estampa.logic.dto.EstampaPageDTO;
import java.util.List;

public interface IAdministradorLogic {
    
    //Crea un nuevo Administrador
    public AdministradorDTO crearAdministrador(AdministradorDTO artista);
    
    //Obtiene todos los Administrador registrador
    public List<AdministradorDTO> obtenerAdministrador();
    
    //Obtiene todos los Administrador de acuerdo a paginacion
    public AdministradorPageDTO obtenerAdministrador(Integer pagina, Integer datosMaximos);
    
    //Obtiene un Administrador con un id determinado
    public AdministradorDTO darAdministrador(Long id);
    
    //Actualiza un Administrador
    public AdministradorDTO actualizarAdministrador(AdministradorDTO artista);
    
    //Elimina todos los Administrador
    public void eliminarAdministrador();
    
    //Elimina un Administrador con el id dado
    public AdministradorDTO eliminarAdministrador(Long id);
    
    //Funcionalidades para estampas de un artista  
    
    
}

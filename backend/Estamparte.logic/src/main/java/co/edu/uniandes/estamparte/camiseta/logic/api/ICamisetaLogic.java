/*
 * Funcionalidades de la estampa
 */
package co.edu.uniandes.estamparte.camiseta.logic.api;

import co.edu.uniandes.estamparte.estampa.logic.api.*;
import co.edu.uniandes.estamparte.camiseta.logic.dto.CamisetaDTO;
import co.edu.uniandes.estamparte.camiseta.logic.dto.CamisetaPageDTO;
import co.edu.uniandes.estamparte.estampa.logic.dto.EstampaDTO;
import java.util.List;


public interface ICamisetaLogic {
    
     public CamisetaDTO crearCamiseta(CamisetaDTO detail);

    public List<CamisetaDTO> darCamisetas();
    
    public CamisetaPageDTO darCamisetas(Integer page, Integer maxRecords);

    public CamisetaPageDTO obtenerCamisetasDeCarrito(String idCarrito, Integer pagina, Integer datosMaximos);
    
    public CamisetaDTO actualizarCamiseta(CamisetaDTO camiseta);
    
    public CamisetaDTO darCamiseta(String id);

    public void eliminarCamiseta(String id);
    
    public boolean agregarEstampa(String idCamiseta, EstampaDTO estampa);
    
    public boolean eliminarEstampa(String idCamiseta,long id);
}

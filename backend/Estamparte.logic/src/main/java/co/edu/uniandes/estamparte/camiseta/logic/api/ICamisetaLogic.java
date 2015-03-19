/*
 * Funcionalidades de la estampa
 */
package co.edu.uniandes.estamparte.camiseta.logic.api;

import co.edu.uniandes.estamparte.estampa.logic.api.*;
import co.edu.uniandes.estamparte.camiseta.logic.dto.CamisetaDTO;
import co.edu.uniandes.estamparte.camiseta.logic.dto.CamisetaPageDTO;
import java.util.List;


public interface ICamisetaLogic {
    
     public CamisetaDTO crearCamiseta(CamisetaDTO detail);

    public List<CamisetaDTO> darCamisetas();

    public CamisetaPageDTO darCamisetas(Integer page, Integer maxRecords);

    public CamisetaDTO darCamiseta(String id);

    public void eliminarCamiseta(String id);
    
}

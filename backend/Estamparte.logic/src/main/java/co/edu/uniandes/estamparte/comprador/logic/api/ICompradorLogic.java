/*
 * Funcionalidades de la estampa
 */
package co.edu.uniandes.estamparte.comprador.logic.api;

import co.edu.uniandes.estamparte.carrito.logic.api.*;
import co.edu.uniandes.estamparte.artista.logic.api.*;
import co.edu.uniandes.estamparte.camiseta.logic.api.*;
import co.edu.uniandes.estamparte.estampa.logic.api.*;
import co.edu.uniandes.estamparte.comprador.logic.dto.CompradorDTO;
import co.edu.uniandes.estamparte.comprador.logic.dto.CompradorPageDTO;


import java.util.ArrayList;



public interface ICompradorLogic {
      public CompradorDTO createComprador(CompradorDTO detalles);
    
    public CompradorPageDTO getComprador(Integer numPagina, Integer maxRecords);
    
    public ArrayList<CompradorDTO> getComprador();
    
    public CompradorDTO getComprador(Long id);
    
    public CompradorDTO deleteComprador(Long id);
    
    public void updateComprador(CompradorDTO detalles);
    
}

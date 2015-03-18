/*
 * DTO de la estampa
 */
package co.edu.uniandes.estamparte.carrito.logic.dto;

import co.edu.uniandes.estamparte.artista.logic.dto.*;
import co.edu.uniandes.estamparte.camiseta.logic.dto.*;
import co.edu.uniandes.estamparte.estampa.logic.dto.*;
import java.util.ArrayList;
import java.util.List;

public class CarritoDTO {
    
    private ArrayList<CamisetaDTO> camisetas;
    
    public ArrayList<CamisetaDTO> getCamisetas()
    {
        return camisetas;
    }
    
}

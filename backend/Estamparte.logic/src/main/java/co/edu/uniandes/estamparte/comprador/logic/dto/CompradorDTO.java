/*
 * DTO de la estampa
 */
package co.edu.uniandes.estamparte.comprador.logic.dto;

import co.edu.uniandes.estamparte.carrito.logic.dto.*;
import co.edu.uniandes.estamparte.artista.logic.dto.*;
import co.edu.uniandes.estamparte.camiseta.logic.dto.*;
import co.edu.uniandes.estamparte.estampa.logic.dto.*;


public class CompradorDTO 
{
    private String nombre;
    private String id;
    private CarritoDTO carrito;
    
    public String getNombre()
    {
        return nombre;
    }
    
    public String getId()
    {
        return id;
    }
    
    public CarritoDTO getCarrito()
    {
        return carrito;
    }
    
}

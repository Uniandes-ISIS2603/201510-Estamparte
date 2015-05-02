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
import co.edu.uniandes.estamparte.formaPago.logic.dto.FormaPagoDTO;


import java.util.*;



public interface ICompradorLogic {
    
    public CompradorDTO createComprador(CompradorDTO detalles);
        
    public CompradorPageDTO getCompradores(Integer pagina, Integer datosMaximos);
    
    public CompradorDTO getComprador(long id);
    
    public CompradorDTO deleteComprador(long id);
    
    public void updateComprador(CompradorDTO detalles);
    
    public FormaPagoDTO crearFormaPagoComprador(long idComprador, FormaPagoDTO formaPago);
    
    public List<FormaPagoDTO> darFormasPagoComprador(long idComprador);
    
    public FormaPagoDTO actualizarFormaPagoComprador(long idComprador, FormaPagoDTO formaPago);
    
    public void eliminarFormaPagoComprador(long idComprador, long idFormaPago);

    
}

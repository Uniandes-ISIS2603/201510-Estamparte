/*
 * Funcionalidades de la estampa
 */
package co.edu.uniandes.estamparte.factura.logic.api;

import co.edu.uniandes.estamparte.estampa.logic.api.*;

import co.edu.uniandes.estamparte.factura.logic.dto.FacturaDTO;
import co.edu.uniandes.estamparte.factura.logic.dto.FacturaPageDTO;
import java.util.List;
import java.util.ArrayList;



public interface IFacturaLogic {
    
    //Servicios por comprador
    
    //Crear una factura asociada a un comprador
    public FacturaDTO createFacturaComprador(long idComprador, FacturaDTO factura);
    
    //Elimina la factura de un comprador
    public FacturaDTO deleteFacturaComprador(long idComprador, long idFactura);
    
    //Obtiene todas las factura de un comprador
    public FacturaPageDTO getFacturasComprador(long idComprador, Integer pagina, Integer datosMaximos);
    
    //Actualiza la factura de un comprador
    public FacturaDTO updateFacturaComprador(long idComprador, FacturaDTO factura);
    
    //Servicios de un administrador
    
    //Obtiene las facturas del sistems
    public FacturaPageDTO getFacturas(Integer pagina, Integer datosMaximos);
    
    //Obtiene una factura por un id
    public FacturaDTO getFactura(long idFactura);
    
    //Elimina una factura
    public FacturaDTO deleteFactura(long idFactura);
    
    //Elimina todas las facturas del sistema
    public void deleteFacturas();
}


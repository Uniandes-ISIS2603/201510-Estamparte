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
    
    public FacturaDTO createFactura(FacturaDTO detalles);
    
    public FacturaPageDTO getFacturas(Integer numPagina, Integer maxRecords);
    
    public ArrayList<FacturaDTO> getFacturas();
    
    public FacturaDTO getFactura(Long id);
    
    public FacturaDTO deleteFactura(Long id);
    
    public void updateFactura(FacturaDTO detalles);
}


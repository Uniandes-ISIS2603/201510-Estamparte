/*
 * Funcionalidades de la estampa
 */
package co.edu.uniandes.estamparte.fromaPago.logic.api;

import co.edu.uniandes.estamparte.factura.logic.api.*;
import co.edu.uniandes.estamparte.estampa.logic.api.*;
import co.edu.uniandes.estamparte.fromaPago.logic.dto.FormaPagoDTO;
import co.edu.uniandes.estamparte.fromaPago.logic.dto.FormaPagoPageDTO;
import java.util.ArrayList;




public interface IFormaPagoLogic {
    public FormaPagoDTO createFormaPago(FormaPagoDTO detalles);
    
    public FormaPagoPageDTO getFormaPago(Integer numPagina, Integer maxRecords);
    
    public ArrayList<FormaPagoDTO> getFormasPago();
    
    public FormaPagoDTO getFormaPago(Long id);
    
    public FormaPagoDTO deleteFormaPago(Long id);
    
    public void updateFormaPago(FormaPagoDTO detalles);
    
}

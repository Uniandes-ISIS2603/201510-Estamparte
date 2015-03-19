/*
 * Funcionalidades de la estampa
 */
package co.edu.uniandes.estamparte.formaPago.logic.api;

import co.edu.uniandes.estamparte.formaPago.logic.converter.FormaPagoConverter;
import co.edu.uniandes.estamparte.formaPago.logic.dto.FormaPagoDTO;
import java.util.List;

public interface IFormaPagoLogic {
   
    public FormaPagoDTO crearFormaPago (FormaPagoDTO formaPago);
        
    public List<FormaPagoDTO> darFormasPago();
    
    public void actualizarFormaPago(FormaPagoDTO formaPago);
    
    public void eliminarFormaPago(String nombre);
    
}

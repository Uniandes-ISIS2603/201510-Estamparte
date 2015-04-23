/*
 * Funcionalidades de la estampa
 */
package co.edu.uniandes.estamparte.formaPago.logic.api;

import co.edu.uniandes.estamparte.formaPago.logic.converter.FormaPagoConverter;
import co.edu.uniandes.estamparte.formaPago.logic.dto.FormaPagoDTO;
import co.edu.uniandes.estamparte.formaPago.logic.dto.FormaPagoPageDTO;
import java.util.List;

public interface IFormaPagoLogic {
   
    public FormaPagoDTO crearFormaPago (FormaPagoDTO formaPago);
        
    public FormaPagoPageDTO darFormasPago(Integer pagina, Integer datosMaximos);
    
    public void actualizarFormaPago(FormaPagoDTO formaPago);
    
    public List<FormaPagoDTO> darFormasPago();
    
    public void eliminarFormaPago(Long numeroTarjeta);
    
    public void eliminarFormasPago();
    
}

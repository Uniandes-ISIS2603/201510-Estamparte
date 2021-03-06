/*
 * Funcionalidades de la estampa
 */
package co.edu.uniandes.estamparte.formaPago.logic.api;

import co.edu.uniandes.estamparte.formaPago.logic.dto.FormaPagoDTO;
import co.edu.uniandes.estamparte.formaPago.logic.dto.FormaPagoPageDTO;
import java.util.List;

public interface IFormaPagoLogic {
   
    public FormaPagoDTO crearFormaPago (FormaPagoDTO formaPago);
        
    public FormaPagoPageDTO darFormasPago(Integer pagina, Integer datosMaximos);
    
    public FormaPagoDTO actualizarFormaPago(FormaPagoDTO formaPago);
    
    public FormaPagoPageDTO darFormasPagoComprador(long idComprador, Integer pagina, Integer datosMaximos);
    
    public void eliminarFormaPago(Long numeroTarjeta);
    
    public void eliminarFormasPago();
    
    public void eliminarFormasPagoComprado(long idComprador);
    
}

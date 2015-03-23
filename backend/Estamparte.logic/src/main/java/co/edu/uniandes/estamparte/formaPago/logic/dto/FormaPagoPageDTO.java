/*
 * DTO's de varias estampas
 */
package co.edu.uniandes.estamparte.formaPago.logic.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FormaPagoPageDTO {

    private Long cantidad;
    
    private List<FormaPagoDTO> formasPago;

    public Long darNumeroFormasPago() {
        return cantidad;
    }
    
    public void asignarCantidad(Long nuevaCantidad){
        cantidad = nuevaCantidad;
    }

    public List<FormaPagoDTO> darFormasPago() {
        return formasPago;
    }

    public void asignarFormasPago(List<FormaPagoDTO> formasPago) {
        this.formasPago = formasPago;
    }
}

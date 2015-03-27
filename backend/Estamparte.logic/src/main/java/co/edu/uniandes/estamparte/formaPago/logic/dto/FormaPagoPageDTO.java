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

    public Long getNumeroFormasPago() {
        return cantidad;
    }
    
    public void setCantidad(Long nuevaCantidad){
        cantidad = nuevaCantidad;
    }

    public List<FormaPagoDTO> getFormasPago() {
        return formasPago;
    }

    public void setFormasPago(List<FormaPagoDTO> formasPago) {
        this.formasPago = formasPago;
    }
}

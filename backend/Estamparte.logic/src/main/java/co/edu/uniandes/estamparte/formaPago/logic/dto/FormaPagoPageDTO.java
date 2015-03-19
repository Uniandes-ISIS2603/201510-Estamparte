/*
 * DTO's de varias estampas
 */
package co.edu.uniandes.estamparte.formaPago.logic.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FormaPagoPageDTO {

    private List<FormaPagoDTO> formasPago;

    public int darNumeroFormasPago() {
        return formasPago.size();
    }

    public List<FormaPagoDTO> darFormasPago() {
        return formasPago;
    }

    public void asignarFormasPago(List<FormaPagoDTO> formasPago) {
        this.formasPago = formasPago;
    }
}

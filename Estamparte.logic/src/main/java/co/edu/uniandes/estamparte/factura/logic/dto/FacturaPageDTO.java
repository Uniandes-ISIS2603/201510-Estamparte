/*
 * DTO's de varias estampas
 */
package co.edu.uniandes.estamparte.factura.logic.dto;

import co.edu.uniandes.estamparte.estampa.logic.dto.*;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FacturaPageDTO {
    private Long totalRecords;

    private List<FacturaDTO> records;

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long pTotalRecords) {
        totalRecords = pTotalRecords;
    }

    public List<FacturaDTO> getRecords() {
        return records;
    }

    public void setRecords(List<FacturaDTO> pRecords) {
        records = pRecords;
    }
    
}

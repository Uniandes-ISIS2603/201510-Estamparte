/*
 * DTO's de varias estampas
 */
package co.edu.uniandes.estamparte.factura.logic.dto;

import co.edu.uniandes.estamparte.estampa.logic.dto.*;
import java.util.ArrayList;
import java.util.List;


public class FacturaPageDTO {
    private Long totalRecords;

    private ArrayList<FacturaDTO> records;

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long pTotalRecords) {
        totalRecords = pTotalRecords;
    }

    public ArrayList<FacturaDTO> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<FacturaDTO> pRecords) {
        records = pRecords;
    }
    
}

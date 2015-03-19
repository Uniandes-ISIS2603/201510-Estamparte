/*
 * DTO's de varias estampas
 */
package co.edu.uniandes.estamparte.fromaPago.logic.dto;

import co.edu.uniandes.estamparte.factura.logic.dto.*;
import co.edu.uniandes.estamparte.estampa.logic.dto.*;
import java.util.ArrayList;


public class FormaPagoPageDTO {
      
    private Long totalRecords;

    private ArrayList<FormaPagoDTO> records;

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long pTotalRecords) {
        totalRecords = pTotalRecords;
    }

    public ArrayList<FormaPagoDTO> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<FormaPagoDTO> pRecords) {
        records = pRecords;
    }
    
}

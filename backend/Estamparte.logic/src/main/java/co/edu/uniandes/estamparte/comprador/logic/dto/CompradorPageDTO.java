/*
 * DTO's de varias estampas
 */
package co.edu.uniandes.estamparte.comprador.logic.dto;

import co.edu.uniandes.estamparte.carrito.logic.dto.*;
import co.edu.uniandes.estamparte.artista.logic.dto.*;
import co.edu.uniandes.estamparte.camiseta.logic.dto.*;
import co.edu.uniandes.estamparte.estampa.logic.dto.*;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CompradorPageDTO {
        private Long totalRecords;

    private ArrayList<CompradorDTO> records;

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long pTotalRecords) {
        totalRecords = pTotalRecords;
    }

    public ArrayList<CompradorDTO> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<CompradorDTO> pRecords) {
        records = pRecords;
    }
    
    
}

/*
 * DTO's de varias estampas
 */
package co.edu.uniandes.estamparte.camiseta.logic.dto;

import co.edu.uniandes.estamparte.estampa.logic.dto.*;
import java.util.List;

public class CamisetaPageDTO {
    
    private long total;
    
    private List<CamisetaDTO> camisetas;
    
    
    public Long darTotal() {
        return total;
    }

    public void asignarTotal(Long total) {
        this.total = total;
    }

    public List<CamisetaDTO> darCamisetas() {
        return camisetas;
    }

    public void asignarCamisetas(List<CamisetaDTO> camisetas) {
        this.camisetas = camisetas;
    }
    
}

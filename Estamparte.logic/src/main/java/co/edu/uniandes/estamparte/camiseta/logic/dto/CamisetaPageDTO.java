/*
 * DTO's de varias estampas
 */
package co.edu.uniandes.estamparte.camiseta.logic.dto;

import co.edu.uniandes.estamparte.estampa.logic.dto.*;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CamisetaPageDTO {
    
    private long total;
    
    private List<CamisetaDTO> camisetas;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<CamisetaDTO> getCamisetas() {
        return camisetas;
    }

    public void setCamisetas(List<CamisetaDTO> camisetas) {
        this.camisetas = camisetas;
    }
       
}

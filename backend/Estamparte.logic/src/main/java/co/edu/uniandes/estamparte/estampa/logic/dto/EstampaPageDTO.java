/*
 * DTO's de varias estampas
 */
package co.edu.uniandes.estamparte.estampa.logic.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EstampaPageDTO {
    
    //Atributos
    
    //Numero total de estampas en la pagina
    private Long totalEstampas;
    
    //Lista de estampas en la pagina
    private List<EstampaDTO> estampas;
    
    //Metodos analizadores

    public Long getTotalEstampas() {
        return totalEstampas;
    }

    public void setTotalEstampas(Long totalEstampas) {
        this.totalEstampas = totalEstampas;
    }

    public List<EstampaDTO> getEstampas() {
        return estampas;
    }

    public void setEstampas(List<EstampaDTO> estampas) {
        this.estampas = estampas;
    }
    
   
    
}

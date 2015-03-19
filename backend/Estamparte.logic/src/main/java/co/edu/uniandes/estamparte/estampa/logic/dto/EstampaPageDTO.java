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
    
    //Retorna el numero de estampas
    public Long darTotalEstampas(){
        return totalEstampas;
    }
    
    //Retorna la lista de estampas
    public List<EstampaDTO> darEstampas(){
        return estampas;
    }
    
    //Metodos modificadores
    
    //Asigna el numero total de estampas por la pagina
    public void cambiarTotalEstampas(Long nTotalEstampas){
        this.totalEstampas = nTotalEstampas;
    }
    
    //Asigna la lista de estampas en la pagina
    public void cambiarEstampas(List<EstampaDTO> nEstampas){
        this.estampas = nEstampas;
    } 
    
}

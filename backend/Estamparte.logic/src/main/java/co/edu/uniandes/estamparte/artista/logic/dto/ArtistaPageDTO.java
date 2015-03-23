/*
 * DTO's de varias estampas
 */
package co.edu.uniandes.estamparte.artista.logic.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

//Tiene el registro actual y los registros de artista
@XmlRootElement
public class ArtistaPageDTO {
    
    //Atributos
    
    //Numero total de artistas en la pagina
    private Long totalArtistas;
    
    //Lista de artistas en la pagina
    private List<ArtistaDTO> artistas;
    
    //Metodos analizadores
    
    //Retorna el numero total de artistas
    public Long darTotalArtistas(){
        return totalArtistas;
    }
    
    //Retorna la lista de artistas
    public List<ArtistaDTO> darArtistas(){
        return artistas;
    }
    
    //Metodos modificadores
    
    //Asigna el numero total de artistas por la pagina
    public void cambiarTotalArtistas(Long nTotalArtistas){
        this.totalArtistas = nTotalArtistas;
    }
    
    //Asigna la lista de artistas en la pagina
    public void cambiarArtistas(List<ArtistaDTO> nArtistas){
        this.artistas = nArtistas;
    } 
    
}

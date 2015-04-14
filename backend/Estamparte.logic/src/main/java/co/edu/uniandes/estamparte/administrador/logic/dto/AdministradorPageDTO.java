/*
 * DTO's de varias estampas
 */
package co.edu.uniandes.estamparte.administrador.logic.dto;

import co.edu.uniandes.estamparte.artista.logic.dto.*;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

//Tiene el registro actual y los registros de artista
@XmlRootElement
public class AdministradorPageDTO {
    
    //Atributos
    
    //Numero total de artistas en la pagina
    private Long totalArtistas;
    
    //Lista de artistas en la pagina
    private List<ArtistaDTO> artistas;
    
    //Metodos analizadores

    public Long getTotalArtistas() {
        return totalArtistas;
    }

    public void setTotalArtistas(Long totalArtistas) {
        this.totalArtistas = totalArtistas;
    }

    public List<ArtistaDTO> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<ArtistaDTO> artistas) {
        this.artistas = artistas;
    }
    
   
}

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
    
    private Long totalAdministrador;
    
    private List<AdministradorDTO> administradores;
    
    //Metodos analizadores

    public Long getTotalAdministradores() {
        return totalAdministrador;
    }

    public void setTotalAdministradores(Long pTotal) {
        totalAdministrador = pTotal;
    }

    public List<AdministradorDTO> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(List<AdministradorDTO> pAdministradores) {
        administradores = pAdministradores;
    }
    
   
}

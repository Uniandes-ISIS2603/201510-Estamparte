/*
 * DTO's de varias estampas
 */
package co.edu.uniandes.estamparte.comprador.logic.dto;

import co.edu.uniandes.estamparte.carrito.logic.dto.*;
import co.edu.uniandes.estamparte.artista.logic.dto.*;
import co.edu.uniandes.estamparte.camiseta.logic.dto.*;
import co.edu.uniandes.estamparte.estampa.logic.dto.*;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CompradorPageDTO {
    
    private long totalCompradores;
    
    private List<CompradorDTO> compradores;

    public long getTotalCompradores() {
        return totalCompradores;
    }

    public void setTotalCompradores(long totalCompradores) {
        this.totalCompradores = totalCompradores;
    }

    public List<CompradorDTO> getCompradores() {
        return compradores;
    }

    public void setCompradores(List<CompradorDTO> compradores) {
        this.compradores = compradores;
    }
}

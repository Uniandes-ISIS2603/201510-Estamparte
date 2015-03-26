/*
 * DTO de la estampa
 */
package co.edu.uniandes.estamparte.camiseta.logic.dto;

import co.edu.uniandes.estamparte.carrito.logic.dto.CarritoDTO;
import co.edu.uniandes.estamparte.estampa.logic.dto.*;
import java.util.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CamisetaDTO {

    private String id;
    
    private List<EstampaDTO> estampas;
    
    private String talla;
    
    private String color;
    
    private String estilo;
    
    private String nombre;
    
    private double costo;
    
    private CarritoDTO carroDuenio;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<EstampaDTO> getEstampas() {
        return estampas;
    }

    public void setEstampas(List<EstampaDTO> estampas) {
        this.estampas = estampas;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    public void setCarroDuenio(CarritoDTO carro){
        carroDuenio = carro;
    }
    
    public CarritoDTO getCarroDuenio(){
        return carroDuenio;
    }
    
    
    public boolean agregarEstampa(EstampaDTO estampa)
    {
        if(estampas == null)
            estampas = new ArrayList();
        return estampas.add(estampa);
    }
    
    public boolean eliminarEstampa(long id)
    {
        for(EstampaDTO es: estampas)
            if(es.getId() == id)
                return estampas.remove(es);
        return false;
    }
}

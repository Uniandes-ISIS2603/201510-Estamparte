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
    
    public String darId() {
        return id;
    }

    public void asignarId(String id) {
        this.id = id;
    }

    public List<EstampaDTO> darEstampas() {
        return estampas;
    }

    public void asignarEstampas(List<EstampaDTO> estampas) {
        this.estampas = estampas;
    }

    public String darTalla() {
        return talla;
    }

    public void asignarTalla(String talla) {
        this.talla = talla;
    }

    public String darColor() {
        return color;
    }

    public void asignarColor(String color) {
        this.color = color;
    }

    public String darEstilo() {
        return estilo;
    }

    public void asignarEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String darNombre() {
        return nombre;
    }

    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }

    public double darCosto() {
        return costo;
    }

    public void asignarCosto(double costo) {
        this.costo = costo;
    }
    
    public void asignarCarroDuenio(CarritoDTO carro){
        carroDuenio = carro;
    }
    
    public CarritoDTO darCarroDuenio(){
        return carroDuenio;
    }
    
}

/*
 * DTO de la estampa
 */
package co.edu.uniandes.estamparte.camiseta.logic.dto;

import co.edu.uniandes.estamparte.estampa.logic.dto.*;
import java.util.*;


public class CamisetaDTO {

    public String id;
    
    public List<EstampaDTO> estampas;
    
    public String talla;
    
    public String color;
    
    public String estilo;
    
    public String nombre;
    
    public double costo;
    
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
    

    
}

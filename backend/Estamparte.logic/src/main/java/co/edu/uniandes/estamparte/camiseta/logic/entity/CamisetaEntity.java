/*
 * Entidad de estampa
 */
package co.edu.uniandes.estamparte.camiseta.logic.entity;

import co.edu.uniandes.estamparte.estampa.logic.entity.EstampaEntity;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class CamisetaEntity {
    
    @Id
    @GeneratedValue(generator = "Camiseta")
    public String id;
    
    public List<EstampaEntity> estampas;
    
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

    @ManyToMany(mappedBy="camisetas")
    @JoinTable(name="camiseta_estampa")
    public List<EstampaEntity> darEstampas() {
        return estampas;
    }

    public void asignarEstampas(List<EstampaEntity> estampas) {
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

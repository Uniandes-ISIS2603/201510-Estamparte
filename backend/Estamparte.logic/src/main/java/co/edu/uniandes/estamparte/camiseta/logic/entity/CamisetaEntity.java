/*
 * Entidad de estampa
 */
package co.edu.uniandes.estamparte.camiseta.logic.entity;

import co.edu.uniandes.estamparte.carrito.logic.entity.CarritoEntity;
import co.edu.uniandes.estamparte.estampa.logic.entity.EstampaEntity;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class CamisetaEntity {
    
    @Id
    @GeneratedValue(generator = "Camiseta")
    private String id;
    
    @ManyToMany(mappedBy="camisetas")
    @JoinTable(name="camiseta_estampa")
    private List<EstampaEntity> estampas;
    
    private String talla;
    
    private String color;
    
    private String estilo;
    
    private String nombre;
    
    private double costo;
    
    @ManyToOne
    @JoinColumn(name="CARRITO_ID")
    private CarritoEntity carroDuenio;
    
    public String darId() {
        return id;
    }

    public void asignarId(String id) {
        this.id = id;
    }

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

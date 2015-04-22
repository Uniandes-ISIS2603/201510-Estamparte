/*
 * Entidad de estampa
 */
package co.edu.uniandes.estamparte.camiseta.logic.entity;

import co.edu.uniandes.estamparte.carrito.logic.entity.CarritoEntity;
import co.edu.uniandes.estamparte.estampa.logic.entity.EstampaEntity;
import java.util.*;
import javax.persistence.Column;
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
    @Column(name="CAMISETA_ID")
    private long id;
    
    @ManyToMany
    @JoinTable(
    name="CAMISETA_ESTAMPA",
    joinColumns={@JoinColumn(name="CAMISETA_ID", referencedColumnName="CAMISETA_ID")},
    inverseJoinColumns={@JoinColumn(name="ESTAMPA_ID", referencedColumnName="ESTAMPA_ID")})
    private List<EstampaEntity> estampas;
    
    private String talla;
    
    private String color;
    
    private String estilo;
    
    private String nombre;
    
    private double costo;
    

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<EstampaEntity> getEstampas() {
        return estampas;
    }

    public void setEstampas(List<EstampaEntity> estampas) {
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
    

    
    
    public boolean agregarEstampa(EstampaEntity estampa)
    {
        if(estampas == null)
            estampas = new ArrayList();
        return estampas.add(estampa);
    }
    
    public boolean eliminarEstampa(long id)
    {
        for(EstampaEntity es: estampas)
            if(es.getId() == id)
                return estampas.remove(es);
        return false;
    }
}

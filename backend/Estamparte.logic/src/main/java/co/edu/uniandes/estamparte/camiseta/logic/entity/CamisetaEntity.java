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
    private String id;
    
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
    
    public void asignarCarroDuenio(CarritoEntity carro){
        carroDuenio = carro;
    }
    
    public CarritoEntity darCarroDuenio(){
        return carroDuenio;
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

/*
 * DTO de la estampa
 */
package co.edu.uniandes.estamparte.camiseta.logic.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CamisetaDTO {

    private long id;
    
    private long[] estampas;
    
    private String talla;
    
    private String color;
    
    private String estilo;
    
    private String nombre;
    
    private double costo;
    
    private int cantidad;
    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long[] getEstampas() {
        return estampas;
    }

    public void setEstampas(long[] estampas) {
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

    public int getCantidad(){
       return cantidad;
    }
    
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    
    
}

/*
 * Entidad de estampa
 */
package co.edu.uniandes.estamparte.estampa.logic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EstampaEntity {
    
    //Id de la estampa, es autogenerado por la base de datos
    @Id
    @GeneratedValue
    private Long id;
    
    //Nombre de la estampa
    private String nombre;
    
    //Id de la imagen de estampa
    private Long imagen;
    
    //Descripcion de la estampa
    private String descripcion;
    
    //Rating de likes de la estampa
    private Integer siGusta;
    
    //Rating de dislikes de la estampa
    private Integer noGusta;
    
    //Tema de la estampa
    private String tema;
    
    //Altura de la estampa en (cm)
    private Double altura;
    
    //Ancho de la estampa en (cm)
    private Double ancho;
    
    //Precio de la estampa
    private Double precio;
    
    //Metodos analizadores de la entidad
    
    //Retorna el id autogenerado de la estampa
    public Long darId(){
        return id;
    }
    
    //Retorna el nombre de la estampa
    public String darNombre(){
        return nombre;
    }
    
    //Retorna el id de la imagen de la estampa
    public Long darImagen(){
        return imagen;
    }
    
    //Retorna la descripcion de la estampa
    public String darDescripcion(){
        return descripcion;
    }
    
    //Retorna el numero de likes de la estampa
    public Integer darSiGusta(){
        return siGusta;
    }
    
    //Retorna el numero de dislikes de la estampa
    public Integer darNoGusta(){
        return noGusta;
    }
    
    //Retorna el tema de la estampa
    public String darTema(){
        return tema;
    }
    
    //Retorna la altura de la estampa
    public Double darAltura(){
        return altura;
    }
    
    //Retorna el ancho de la estampa
    public Double darAncho(){
        return ancho;
    }
    
    //Retorna el precio de la estampa
    public Double darPrecio(){
        return precio;
    }
    
    //Metodos modificadores
    
    //Asigna el id
    public void cambiarId(Long nId){
        this.id = nId;
    }
    
    //Asigna el nombre
    public void cambiarNombre(String nNombre){
        this.nombre = nNombre;
    }
    
    //Asigna el id de la imagen
    public void cambiarImagen(Long nIdImagen){
        this.imagen = nIdImagen;
    }
    
    //Asigna la descripcion
    public void cambiarDescripcion(String nDescripcion){
        this.descripcion = nDescripcion;
    }
    
    //Asigna el numero de likes
    public void cambiarSiGusta(Integer nSiGusta){
        this.siGusta = nSiGusta;
    }
    
    //Asigna el numero de dislikes
    public void cambiarNoGusta(Integer nNoGusta){
        this.noGusta = nNoGusta;
    }
    
    //Asigna el tema de la estampa
    public void cambiarTema(String nTema){
        this.tema = nTema;
    }
    
    //Asigna la altura de la estampa
    public void cambiarAltura(Double nAltura){
        this.altura = nAltura;
    }
    
    //Asigna el ancho de la estampa
    public void cambiarAncho(Double nAncho){
        this.ancho = nAncho;
    }
    
    //Asigna el precio de la estampa
    public void cambiarPrecio(Double nPrecio){
        this.precio = nPrecio;
    }
    
        
    
}

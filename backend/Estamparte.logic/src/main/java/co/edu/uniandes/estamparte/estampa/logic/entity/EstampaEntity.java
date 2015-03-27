/*
 * Entidad de estampa
 */
package co.edu.uniandes.estamparte.estampa.logic.entity;

import co.edu.uniandes.estamparte.artista.logic.entity.ArtistaEntity;
import co.edu.uniandes.estamparte.camiseta.logic.entity.CamisetaEntity;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class EstampaEntity {
    
    //Id de la estampa, es autogenerado por la base de datos
    @Id
    @GeneratedValue
    @Column(name="ESTAMPA_ID")
    private Long id;
    
    //Artista duenho de la estampa
    @ManyToOne
    @JoinColumn(name="ARTISTA_ID")
    private ArtistaEntity duenho;
    
    //Camiseta a la que pertenece
    @ManyToMany(mappedBy="estampas")
    private List<CamisetaEntity> camisetas;
    
    //Nombre de la estampa
    private String nombre;
    
    //Url de la imagen de la estampa en el servidor
    private String imagen;
    
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
    public Long getId(){
        return id;
    }
    
    //Retorna el artista duenho de la estampa
    public ArtistaEntity getDuenho(){
        return duenho;
    }
    
    //Retorna el nombre de la estampa
    public String getNombre(){
        return nombre;
    }
    
    //Retorna la url de la imagen de la estampa
    public String getImagen(){
        return imagen;
    }
    
    //Retorna la descripcion de la estampa
    public String getDescripcion(){
        return descripcion;
    }
    
    //Retorna el numero de likes de la estampa
    public Integer getSiGusta(){
        return siGusta;
    }
    
    //Retorna el numero de dislikes de la estampa
    public Integer getNoGusta(){
        return noGusta;
    }
    
    //Retorna el tema de la estampa
    public String getTema(){
        return tema;
    }
    
    //Retorna la altura de la estampa
    public Double getAltura(){
        return altura;
    }
    
    //Retorna el ancho de la estampa
    public Double getAncho(){
        return ancho;
    }
    
    //Retorna el precio de la estampa
    public Double getPrecio(){
        return precio;
    }
    
    //Retorna las camisetas asociadas
    public List<CamisetaEntity> getCamisetas(){
        return camisetas;
    }
    
    //Metodos modificadores
    
    //Asigna el id
    public void setId(Long nId){
        this.id = nId;
    }
    
    //Asigna el duenho de la estampa
    public void setDuenho(ArtistaEntity nDuenho){
        this.duenho=nDuenho;
    }
    
    //Asigna el nombre
    public void setNombre(String nNombre){
        this.nombre = nNombre;
    }
    
    //Asigna la url de la imagen
    public void setImagen(String nIdImagen){
        this.imagen = nIdImagen;
    }
    
    //Asigna la descripcion
    public void setDescripcion(String nDescripcion){
        this.descripcion = nDescripcion;
    }
    
    //Asigna el numero de likes
    public void setSiGusta(Integer nSiGusta){
        this.siGusta = nSiGusta;
    }
    
    //Asigna el numero de dislikes
    public void setNoGusta(Integer nNoGusta){
        this.noGusta = nNoGusta;
    }
    
    //Asigna el tema de la estampa
    public void setTema(String nTema){
        this.tema = nTema;
    }
    
    //Asigna la altura de la estampa
    public void setAltura(Double nAltura){
        this.altura = nAltura;
    }
    
    //Asigna el ancho de la estampa
    public void setAncho(Double nAncho){
        this.ancho = nAncho;
    }
    
    //Asigna el precio de la estampa
    public void setPrecio(Double nPrecio){
        this.precio = nPrecio;
    }
    
    //Asigna las camisetas asociadas a la estampa
    public void setCamisetas(List<CamisetaEntity> nCamisetas){
        this.camisetas = nCamisetas;
    }
    
        
    
}

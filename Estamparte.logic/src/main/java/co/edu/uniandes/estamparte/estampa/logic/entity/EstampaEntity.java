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
    @ManyToMany
    @JoinColumn(name="CAMISETA_ID")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArtistaEntity getDuenho() {
        return duenho;
    }

    public void setDuenho(ArtistaEntity duenho) {
        this.duenho = duenho;
    }

    public List<CamisetaEntity> getCamisetas() {
        return camisetas;
    }

    public void setCamisetas(List<CamisetaEntity> camisetas) {
        this.camisetas = camisetas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getSiGusta() {
        return siGusta;
    }

    public void setSiGusta(Integer siGusta) {
        this.siGusta = siGusta;
    }

    public Integer getNoGusta() {
        return noGusta;
    }

    public void setNoGusta(Integer noGusta) {
        this.noGusta = noGusta;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getAncho() {
        return ancho;
    }

    public void setAncho(Double ancho) {
        this.ancho = ancho;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    
    
        
    
}

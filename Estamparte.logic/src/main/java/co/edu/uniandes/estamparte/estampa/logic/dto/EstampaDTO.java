/*
 * DTO de la estampa
 */
package co.edu.uniandes.estamparte.estampa.logic.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EstampaDTO {
    
    //Id de la estampa
    private Long id;
    
    //Id del artista duenho de la estampa
    private Long idArtista;
    
    //Nombre de usuario del artista duenho de la estampa
    private String usuarioArtista;
    
    //Nombre de la estampa
    private String nombre;
    
    //Url la imagen de estampa
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
    
    //Construcor vacio
    public EstampaDTO(){}
    
    //Metodos analizadores de la entidad

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(Long idArtista) {
        this.idArtista = idArtista;
    }

    public String getUsuarioArtista() {
        return usuarioArtista;
    }

    public void setUsuarioArtista(String usuarioArtista) {
        this.usuarioArtista = usuarioArtista;
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

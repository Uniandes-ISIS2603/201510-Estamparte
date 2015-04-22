/*
 * DTO de la estampa
 */
package co.edu.uniandes.estamparte.artista.logic.dto;

//Tiene los mismos atributos que el DTO y los mismos getters and setters para cada uno de ellos

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ArtistaDTO {
    
    //Id del artista
    private Long id;
    
    //usuario del artista
    private String usuario;
    
    //Contrasenha del artista
    private String contrasenha;
    
    //Nombre del artista
    private String nombre;
    
    //Cedula del artista
    private String cedula;
    
    //Correo del artista
    private String correo;
    
    //Url de imagen de perfil 
    private String imagenPerfil;
    
    //Descripcion del artista
    private String descripcion;
    
    //constructor vacio
    public ArtistaDTO(){}
    
    //Metodos analizadores

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(String imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}

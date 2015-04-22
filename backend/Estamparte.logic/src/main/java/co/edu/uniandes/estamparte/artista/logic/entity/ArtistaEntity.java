/*
 * Entidad de estampa
 */
package co.edu.uniandes.estamparte.artista.logic.entity;

import co.edu.uniandes.estamparte.estampa.logic.entity.*;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//Se declara como una entidad
@Entity
public class ArtistaEntity {
    
    //Id del artista
    @Id
    @GeneratedValue(generator = "Artista")
    @Column(name="ARTISTA_ID")
    private Long id;
    
    //Usuario del artista
    private String usuario;
    
    //contraseña del artista
    private String contrasenha;
    
    //Nombre del artista
    private String nombre;
    
    //Cedula del artista
    private String cedula;
    
    //Correo electronico del artista
    private String correo;
    
    //Url de la imagen de perfil del artista
    private String imagenPerfil;
    
    //Descripcion de artista
    private String descripcion;
    
    //Estampas del artista
    @OneToMany(mappedBy="duenho")
    private List<EstampaEntity> estampas;
   
    //Constructor vacio
    public ArtistaEntity(){}
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

    public List<EstampaEntity> getEstampas() {
        return estampas;
    }

    public void setEstampas(List<EstampaEntity> estampas) {
        this.estampas = estampas;
    }
    
    
    
    
    
}

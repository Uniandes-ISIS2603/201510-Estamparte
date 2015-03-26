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
    
    //Metodos analizadores
    
    //Retorna el id del artista
    public Long getId(){
        return id;
    }
    
    //Retorna el usuario del artista
    public String getUsuario(){
        return usuario;
    }
    
    //Retorna la contrasenha del usuario
    public String getContrasenha(){
        return contrasenha;
    }
    
    //Retorna el nombre del artista
    public String getNombre(){
        return nombre;
    }
    
    //Retorna la cedula del artista
    public String getCedula(){
        return cedula;
    }
    
    //Retorna el correo electronico del artista
    public String getCorreo(){
        return correo;
    }
    
    //Retorna la url de la imagen de perfil del artista
    public String getImagenPerfil(){
        return imagenPerfil;
    }
    
    //Retorna la descripcion del artista
    public String getDescripcion(){
        return descripcion;
    }
    
    //Retorna le conjunto de estampas del artista
    public List<EstampaEntity> getEstampas(){
        return estampas;
    }
    
    //Metodos modificadores
    
    //Cambia el id del artista
    public void setId(Long id){
        this.id = id;
    }
    
    //Cambia el nombre de usuario del artista
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    //Cambia la contrasenha del artista
    public void setContrasenha(String contrasenha){
        this.contrasenha = contrasenha;
    }
    
    //Cambia el nombre del artista
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    //Cambia la cedula del artista
    public void setCedula(String cedula){
        this.cedula = cedula;
    }
    
    //Cambia el correo electronico del artista
    public void setCorreo(String correo){
        this.correo = correo;
    }
    
    //Cambia la url de la imagen de perfil del artista
    public void setImagenPerfil(String imagen){
        this.imagenPerfil = imagen;
    }
    
    //Cambia la descripcion del artista
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    //Cambia el conjunto de estampas del artista
    public void setEstampas(List<EstampaEntity> estampas){
        this.estampas = estampas;
    }
    
    
    
    
}

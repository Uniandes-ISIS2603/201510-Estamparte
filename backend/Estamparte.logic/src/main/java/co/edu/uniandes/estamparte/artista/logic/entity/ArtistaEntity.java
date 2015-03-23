/*
 * Entidad de estampa
 */
package co.edu.uniandes.estamparte.artista.logic.entity;

import co.edu.uniandes.estamparte.camiseta.logic.entity.*;
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
    public Long darId(){
        return id;
    }
    
    //Retorna el usuario del artista
    public String darUsuario(){
        return usuario;
    }
    
    //Retorna la contrasenha del usuario
    public String darContrasenha(){
        return contrasenha;
    }
    
    //Retorna el nombre del artista
    public String darNombre(){
        return nombre;
    }
    
    //Retorna la cedula del artista
    public String darCedula(){
        return cedula;
    }
    
    //Retorna el correo electronico del artista
    public String darCorreo(){
        return correo;
    }
    
    //Retorna la url de la imagen de perfil del artista
    public String darImagenPerfil(){
        return imagenPerfil;
    }
    
    //Retorna la descripcion del artista
    public String darDescripcion(){
        return descripcion;
    }
    
    //Retorna le conjunto de estampas del artista
    public List<EstampaEntity> darEstampas(){
        return estampas;
    }
    
    //Metodos modificadores
    
    //Cambia el id del artista
    public void cambiarId(Long nId){
        this.id = nId;
    }
    
    //Cambia el nombre de usuario del artista
    public void cambiarUsuario(String nUsuario){
        this.usuario = nUsuario;
    }
    
    //Cambia la contrasenha del artista
    public void cambiarContrasenha(String nContrasenha){
        this.contrasenha = nContrasenha;
    }
    
    //Cambia el nombre del artista
    public void cambiarNombre(String nNombre){
        this.nombre = nNombre;
    }
    
    //Cambia la cedula del artista
    public void cambiarCedula(String nCedula){
        this.cedula = nCedula;
    }
    
    //Cambia el correo electronico del artista
    public void cambiarCorreo(String nCorreo){
        this.correo = nCorreo;
    }
    
    //Cambia la url de la imagen de perfil del artista
    public void cambiarImagenPerfil(String nImagen){
        this.imagenPerfil = nImagen;
    }
    
    //Cambia la descripcion del artista
    public void cambiarDescripcion(String nDescripcion){
        this.descripcion = nDescripcion;
    }
    
    //Cambia el conjunto de estampas del artista
    public void cambiarEstampas(List<EstampaEntity> nEstampas){
        this.estampas = nEstampas;
    }
    
    
    
    
}

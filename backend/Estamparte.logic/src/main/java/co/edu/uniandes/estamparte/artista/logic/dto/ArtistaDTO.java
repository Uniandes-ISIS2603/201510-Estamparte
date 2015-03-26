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
    
}

/*
 * DTO de la estampa
 */
package co.edu.uniandes.estamparte.administrador.logic.dto;

//Tiene los mismos atributos que el DTO y los mismos getters and setters para cada uno de ellos

import co.edu.uniandes.estamparte.artista.logic.dto.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AdministradorDTO {
    
    private long id;
    private String usuario;
    private String contrasena;
    private String nombre;
    private int cedula;
    private String correo;
    
    //constructor vacio
    public AdministradorDTO(){}
    
    //Metodos analizadores

    public long getId()
    {
        return id;
    }
    public void setId(long pId)
    {
        id = pId;
    }
    
    public String getUsuario()
    {
        return usuario;
    }
    public void setUsuario(String pusuario)
    {
        usuario = pusuario;
    }
    
    public String getContrasena()
    {
        return contrasena;
    }
    public void setContrasena(String pContrasena)
    {
        contrasena = pContrasena;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    public void setNombre(String pNombre)
    {
        nombre = pNombre;
    }
    
    public int getCedula()
    {
        return cedula;
    }
    public void setCedula(int pCedula)
    {
        cedula = pCedula;
    }
    
    public String getCorreo()
    {
        return correo;
    }
    public void setCorreo(String pCorreo)
    {
        correo = pCorreo;
    }
    
}

/*
 * Entidad de estampa
 */
package co.edu.uniandes.estamparte.administrador.logic.entity;

import co.edu.uniandes.estamparte.artista.logic.entity.*;
import co.edu.uniandes.estamparte.estampa.logic.entity.*;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//Se declara como una entidad
@Entity
public class AdministradorEntity {
    
    //Id del artista
    @Id
    @GeneratedValue(generator = "Administrador")
    @Column(name="ADMINISTRADOR_ID")
    private long id;
    
    private String usuario;
    private String contrasena;
    private String nombre;
    private int cedula;
    private String correo;
    
       
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

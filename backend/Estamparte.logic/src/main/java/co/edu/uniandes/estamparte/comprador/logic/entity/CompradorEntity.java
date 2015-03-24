/*
 * Entidad de estampa
 */
package co.edu.uniandes.estamparte.comprador.logic.entity;

import co.edu.uniandes.estamparte.carrito.logic.entity.*;
import co.edu.uniandes.estamparte.artista.logic.entity.*;
import co.edu.uniandes.estamparte.camiseta.logic.entity.*;
import co.edu.uniandes.estamparte.carrito.logic.dto.CarritoDTO;
import co.edu.uniandes.estamparte.estampa.logic.entity.*;
import co.edu.uniandes.estamparte.formaPago.logic.entity.FormaPagoEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CompradorEntity {
    private String nombre;
    private String usuario;
    private String clave;
    private String direccion;
    private int telefono;
    
    @Id
    @GeneratedValue(generator="Comprador")
    @Column(name="COMPRADOR_ID")
    private String id;
    
    @OneToOne
    @JoinColumn(name="CARRITO_ID")
    private CarritoDTO carrito;
    
    @OneToMany(mappedBy="idComprador")
    private List<FormaPagoEntity> formasPago;
    
    
    public String getDireccion()
    {
        return direccion;
    }
    public void setDireccion(String pDireccion)
    {
        direccion = pDireccion;
    }
    
    public int getTelefono()
    {
        return telefono;
    }
    
    public void setTelefono(int pTelefono)
    {
        telefono = pTelefono;
    }
    
    public String getClave()
    {
        return clave;
    }
    
    public void setClave(String pClave)
    {
        clave =   pClave;      
    }
    
    public String getUsuario()
    {
        return usuario;
    }
    
    public void setUsuario(String pUsuario)
    {
        usuario =   pUsuario;      
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public void setNombre(String pNom)
    {
        nombre = pNom;
    }
    public String getId()
    {
        return id;
    }
    
    public void setId(String pId)
    {
        id = pId;
    }
    
    public CarritoDTO getCarrito()
    {
        return carrito;
    }
    
    public void setCarrito(CarritoDTO pCarrito)
    {
        carrito = pCarrito;
    }
    
    public void agregarFormaPago(FormaPagoEntity formaPago){
        formasPago.add(formaPago);
    }
    
    public void eliminarFormasPago(){
        formasPago = new ArrayList<FormaPagoEntity>();
    }
    
    public void eliminarFormaPago(FormaPagoEntity formaPago){
        formasPago.remove(formaPago);
    }
    
    public List<FormaPagoEntity> darFormasPago(){
        return formasPago;
    }
    
    public void asignarFormasPago(List<FormaPagoEntity> nuevasFormasPago){
        formasPago = nuevasFormasPago;
    }
}

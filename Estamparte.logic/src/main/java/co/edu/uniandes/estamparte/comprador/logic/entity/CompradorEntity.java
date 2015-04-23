/*
 * Entidad de estampa
 */
package co.edu.uniandes.estamparte.comprador.logic.entity;

import co.edu.uniandes.estamparte.carrito.logic.entity.*;
import co.edu.uniandes.estamparte.artista.logic.entity.*;
import co.edu.uniandes.estamparte.camiseta.logic.entity.*;
import co.edu.uniandes.estamparte.carrito.logic.dto.CarritoDTO;
import co.edu.uniandes.estamparte.estampa.logic.entity.*;
import co.edu.uniandes.estamparte.factura.logic.entity.FacturaEntity;
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
    private String direccion;
    private int telefono;
    private String usuario;
    private String clave;
    private String correo;
    private int cedula;
    
    @Id
    @GeneratedValue(generator="Comprador")
    @Column(name="COMPRADOR_ID")
    private long id;
    
    @OneToOne
    @JoinColumn(name="CARRITO_ID")
    private CarritoEntity carrito;
    
    @OneToMany(mappedBy="comprador")
    private List<FormaPagoEntity> formasPago;
    
    @OneToMany(mappedBy="comprador")
    private List<FacturaEntity> facturas;
    
    
    public List<FacturaEntity> getFacturas()
    {
        return facturas;
    }
    public void setFacturas(List<FacturaEntity> pList)
    {
        facturas = pList;
    }
    
    public String getCorreo()
    {
        return correo;
    }
    public void setCorreo(String pCorreo)
    {
        correo = pCorreo;
    }
    public int getCedula()
    {
        return cedula;
    }
    
    public void setCedula(int pCedula)
    {
        cedula = pCedula;
    }    
    public String getUsuario()
    {
        return usuario;
    }
    public void setUsuario(String pUsuario)
    {
        usuario = pUsuario;
    }
    public String getClave()
    {
        return clave;
    }
    public void setClave(String pClave)
    {
        clave = pClave;
    }
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
    
    
    public String getNombre()
    {
        return nombre;
    }
    
    public void setNombre(String pNom)
    {
        nombre = pNom;
    }
    public long getId()
    {
        return id;
    }
    
    public void setId(long pId)
    {
        id = pId;
    }
    
    public CarritoEntity getCarrito()
    {
        return carrito;
    }
    
    public void setCarrito(CarritoEntity pCarrito)
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
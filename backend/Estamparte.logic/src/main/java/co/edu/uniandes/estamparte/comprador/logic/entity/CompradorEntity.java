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
import javax.persistence.OneToOne;

@Entity
public class CompradorEntity {
    private String nombre;
    
    @Id
    @GeneratedValue(generator="Comprador")
    @Column(name="COMPRADOR_ID")
    private String id;
    
    @OneToOne
    @JoinColumn(name="CARRITO_ID")
    private CarritoDTO carrito;
    
    private List<FormaPagoEntity> formasPago;
    
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

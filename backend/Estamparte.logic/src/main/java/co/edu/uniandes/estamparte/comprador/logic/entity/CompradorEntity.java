/*
 * Entidad de estampa
 */
package co.edu.uniandes.estamparte.comprador.logic.entity;

import co.edu.uniandes.estamparte.carrito.logic.entity.*;
import co.edu.uniandes.estamparte.artista.logic.entity.*;
import co.edu.uniandes.estamparte.camiseta.logic.entity.*;
import co.edu.uniandes.estamparte.carrito.logic.dto.CarritoDTO;
import co.edu.uniandes.estamparte.estampa.logic.entity.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CompradorEntity {
    private String nombre;
    
    @Id
    @GeneratedValue(generator="Comprador")
    @Column(name="COMPRADOR_ID")
    private String id;
    
    
    private CarritoDTO carrito;
    
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
}

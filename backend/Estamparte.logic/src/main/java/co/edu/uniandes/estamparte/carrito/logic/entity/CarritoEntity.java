/*
 * Entidad de estampa
 */
package co.edu.uniandes.estamparte.carrito.logic.entity;

import co.edu.uniandes.estamparte.camiseta.logic.entity.CamisetaEntity;
import co.edu.uniandes.estamparte.comprador.logic.entity.CompradorEntity;
import co.edu.uniandes.estamparte.factura.logic.entity.FacturaEntity;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CarritoEntity {
    
    @Id
    @GeneratedValue(generator="Carrito")
    @Column(name="CARRITO_ID")
    private long idCarrito;   
    
    
    @OneToMany
    private List<CamisetaEntity> camisetas;
    
 
    
    public long getIdCarrito(){
        return idCarrito;
    }
    
    public void setIdCarrito(long nIdCarrito){
        idCarrito = nIdCarrito;
    }
    
  
    
    public int getNumeroCamisetas(){
        return camisetas.size();
    }
    
    public List<CamisetaEntity> getCamisetas(){
        return camisetas;
    }
    
    public void setCamisetas(List<CamisetaEntity> camisetas){
        this.camisetas = camisetas;
    }
    
    public void agregarCamiseta (CamisetaEntity camiseta){
        camisetas.add(camiseta);
    }
    
    public void eliminarCamiseta(CamisetaEntity camiseta){
        camisetas.remove(camiseta);
    }
    
    public void eliminarListaDeCamisetas(List<CamisetaEntity> aEliminar){
        camisetas.removeAll(aEliminar);
    }
    
    
}

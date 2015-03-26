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
    private String idCarrito;   
    
    @OneToOne(mappedBy="carrito")
    private CompradorEntity comprador;
    
    @OneToMany(mappedBy="carroDuenio")
    private List<CamisetaEntity> camisetas;
    
    @OneToOne
    @JoinColumn(name="FACTURA_ID")
    private FacturaEntity factura;
    
    public String darIdCarrito(){
        return idCarrito;
    }
    
    public void asignarIdCarrito(String nIdCarrito){
        idCarrito = nIdCarrito;
    }
    
    public CompradorEntity darComprador(){
        return comprador;
    }
    
    public void asignarComprador(CompradorEntity nComprador){
        comprador = nComprador;
    }
    
    public int darNumeroCamisetas(){
        return camisetas.size();
    }
    
    public List<CamisetaEntity> darCamisetas(){
        return camisetas;
    }
    
    public void asignarCamisetas(List<CamisetaEntity> camisetas){
        this.camisetas.addAll(camisetas);
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
    
    public void asignarFactura(FacturaEntity nFactura){
        factura = nFactura;
    }
    
    public FacturaEntity darFactura(){
        return factura;
    }
}

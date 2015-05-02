/*
 * Entidad de estampa
 */
package co.edu.uniandes.estamparte.comprador.logic.entity;

import co.edu.uniandes.estamparte.carrito.logic.entity.*;
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
    
    

    
    public void agregarFormaPago(FormaPagoEntity formaPago){
        formasPago.add(formaPago);
    }
    
    public void eliminarFormasPago(){
        setFormasPago(new ArrayList<FormaPagoEntity>());
    }
    
    public void eliminarFormaPago(FormaPagoEntity formaPago){
        formasPago.remove(formaPago);
    }
    
    public void actualizarFormaPago(FormaPagoEntity formaPago){
        boolean end =false;
        for(int i=0; i<formasPago.size() && !end; i++){
            if(formasPago.get(i).getId() == formaPago.getId()){
                formasPago.set(i, formaPago);
                end=true;
            }
                
        }
    }
       

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CarritoEntity getCarrito() {
        return carrito;
    }

    public void setCarrito(CarritoEntity carrito) {
        this.carrito = carrito;
    }

    public List<FormaPagoEntity> getFormasPago() {
        return formasPago;
    }

    public void setFormasPago(List<FormaPagoEntity> formasPago) {
        this.formasPago = formasPago;
    }

    public List<FacturaEntity> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<FacturaEntity> facturas) {
        this.facturas = facturas;
    }
    
    
}

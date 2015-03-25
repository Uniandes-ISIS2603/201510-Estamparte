/*
 * DTO de la estampa
 */
package co.edu.uniandes.estamparte.comprador.logic.dto;

import co.edu.uniandes.estamparte.carrito.logic.dto.*;
import co.edu.uniandes.estamparte.artista.logic.dto.*;
import co.edu.uniandes.estamparte.camiseta.logic.dto.*;
import co.edu.uniandes.estamparte.estampa.logic.dto.*;
import co.edu.uniandes.estamparte.factura.logic.dto.FacturaDTO;
import co.edu.uniandes.estamparte.formaPago.logic.dto.FormaPagoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CompradorDTO 
{
    private String nombre;
    private String id;
    private CarritoDTO carrito;
    private List<FormaPagoDTO> formasPago;
    private String direccion;
    private int telefono;
    private String usuario;
    private String clave;
    private String correo;
    private int cedula;
    private List<FacturaDTO> facturas;
    
    
    public List<FacturaDTO> getFacturas()
    {
        return facturas;
    }
    public void setFacturas(List<FacturaDTO> pList)
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
    
    public void agregarFormaPago(FormaPagoDTO formaPago){
        formasPago.add(formaPago);
    }
    
    public void eliminarFormasPago(){
        formasPago = new ArrayList<FormaPagoDTO>();
    }
    
    public void eliminarFormaPago(FormaPagoDTO formaPago){
        formasPago.remove(formaPago);
    }
    
    public List<FormaPagoDTO> darFormasPago(){
        return formasPago;
    }
    
    public void asignarFormasPago(List<FormaPagoDTO> nuevasFormasPago){
        formasPago = nuevasFormasPago;
    }
}

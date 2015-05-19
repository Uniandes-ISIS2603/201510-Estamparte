/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.estamparte.estamparte.service;

import co.edu.uniandes.estamparte.carrito.logic.api.ICarritoLogic;
import co.edu.uniandes.estamparte.comprador.logic.api.ICompradorLogic;
import co.edu.uniandes.estamparte.comprador.logic.dto.CompradorDTO;
import co.edu.uniandes.estamparte.comprador.logic.dto.CompradorPageDTO;
import co.edu.uniandes.estamparte.factura.logic.api.IFacturaLogic;
import co.edu.uniandes.estamparte.factura.logic.dto.FacturaDTO;
import co.edu.uniandes.estamparte.factura.logic.dto.FacturaPageDTO;
import co.edu.uniandes.estamparte.formaPago.logic.dto.FormaPagoDTO;
import co.edu.uniandes.estamparte.formaPago.logic.dto.FormaPagoPageDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author estudiante
 */
@Path("/comprador")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ServicioComprador {
    @Inject
    protected ICompradorLogic compradorlogic;
    
    @Inject
    protected IFacturaLogic facturaLogic;
    
    @POST
    public CompradorDTO createComprador(CompradorDTO detalles)
    {
        
        return compradorlogic.createComprador(detalles);
    }
     
    @GET
    public CompradorPageDTO getCompradores(@QueryParam("pagina")Integer pagina, @QueryParam("datosMaximos")Integer datosMaximos){
        return compradorlogic.getCompradores(pagina, datosMaximos);
    }
    
    @GET
    @Path("{id}")
    public CompradorDTO getComprador(@PathParam("id")long id){
        return compradorlogic.getComprador(id);
    }
    
    @DELETE
    @Path("{id}")
    public CompradorDTO deleteComprador(@PathParam("id")long id){
        return compradorlogic.deleteComprador(id);
    }
    
    @PUT
    @Path("{id}")
    public void updateComprador(@PathParam("id")long id,CompradorDTO detalles){
        compradorlogic.updateComprador(id,detalles);
    }
    
    @POST
    @Path("{id}/formaPago")
    public FormaPagoDTO crearFormaPagoComprador(@PathParam("id")long idComprador, FormaPagoDTO formaPago){
        return compradorlogic.crearFormaPagoComprador(idComprador, formaPago);
    }
    
    @GET
    @Path("{id}/formaPago")
    public FormaPagoPageDTO darFormasPagoComprador(@PathParam("id")long idComprador,@QueryParam("pagina")Integer pagina, @QueryParam("datosMaximos")Integer datosMaximos){
        return compradorlogic.darFormasPagoComprador(idComprador, pagina, datosMaximos);
    }
    
    @PUT
    @Path("{id}/formaPago/{id2}")
    public FormaPagoDTO actualizarFormaPagoComprador(@PathParam("id")long idComprador, @PathParam("id2")long idFormaPago, FormaPagoDTO formaPago){
        return compradorlogic.actualizarFormaPagoComprador(idComprador, formaPago);
    }
    
    @DELETE
    @Path("{id}/formaPago/{id2}")
    public void eliminarFormaPagoComprador(@PathParam("id")long idComprador, @PathParam("id2")long idFormaPago){
        compradorlogic.eliminarFormaPagoComprador(idComprador, idFormaPago);
    }
    
    //Servicios de manejo de facturas
    
    @POST
    @Path("{id}/factura")
    public FacturaDTO crearFacturaComprador(@PathParam("id")long idComprador, FacturaDTO factura){
        return facturaLogic.createFacturaComprador(idComprador, factura);
    }
    
    @DELETE
    @Path("{id}/factura/{id2}")
    public FacturaDTO deleteFacturaComprador(@PathParam("id")long idComprador, @PathParam("id2")long idFactura){
        return facturaLogic.deleteFacturaComprador(idComprador, idFactura);
    }
    
    @GET
    @Path("{id}/factura")
    public FacturaPageDTO getFacturasComprador(@PathParam("id")long idComprador, @QueryParam("pagina")Integer pagina, @QueryParam("datosMaximos")Integer datosMaximos){
        return facturaLogic.getFacturasComprador(idComprador, pagina, datosMaximos);
    }
    
    @PUT
    @Path("{id}/factura/{id2}")
    public FacturaDTO updateFacturaComprador(@PathParam("id")long idComprador, @PathParam("id2")long idFactura, FacturaDTO factura){
        return facturaLogic.updateFacturaComprador(idComprador, factura);
    }
    
}

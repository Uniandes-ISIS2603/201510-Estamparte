/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.estamparte.estamparte.service;

import co.edu.uniandes.estamparte.camiseta.logic.dto.CamisetaDTO;
import co.edu.uniandes.estamparte.camiseta.logic.dto.CamisetaPageDTO;
import co.edu.uniandes.estamparte.carrito.logic.dto.CarritoDTO;
import co.edu.uniandes.estamparte.carrito.logic.api.ICarritoLogic;
import co.edu.uniandes.estamparte.carrito.logic.dto.CarritoPageDTO;
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
@Path("/carrito")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ServicioCarrito {

    @Inject
    private ICarritoLogic carritoLogic;
    
    @POST
    public CarritoDTO crearCarrito (CarritoDTO carrito){
        return carritoLogic.crearCarrito(carrito);
    }
    
    
    @GET
    public CarritoPageDTO darCarritos(@QueryParam("pagina")Integer pagina, @QueryParam("datosMaximos")Integer datosMaximos){
        return carritoLogic.darCarritos(pagina, datosMaximos);
    }
    
    @POST
    @Path("{CARRITO_ID}/camisetas")
    public CamisetaDTO agregarCamisetaACarrito (@PathParam("CARRITO_ID") long idCarrito, CamisetaDTO camiseta){
        return carritoLogic.agregarCamisetaACarrito(idCarrito, camiseta);
    }
    
    @GET
    @Path("{CARRITO_ID}/camisetas")
    public CamisetaPageDTO darCamisetasCarrito(@PathParam("CARRITO_ID") long idCarrito){
        return carritoLogic.obtenerCamisetasDeCarrito(idCarrito);
        
    }
    
    @PUT
    @Path("{CARRITO_ID}/camisetas/{CAMISETA_ID}")
    public CamisetaDTO actualizarCamisetaCarrito(@PathParam("CARRITO_ID") long idCarrito, @PathParam("CAMISETA_ID") long idCamiseta, CamisetaDTO camiseta){
        return carritoLogic.actualizarCamisetaCarrito(idCarrito, camiseta);
    }
    
    @DELETE
    @Path("{CARRITO_ID}/camisetas/{CAMISETA_ID}")
    public void eliminarCamisetaCarrito(@PathParam("CARRITO_ID") long idCarrito, @PathParam("CAMISETA_ID") long idCamiseta){
        carritoLogic.eliminarCamisetaCarrito(idCarrito, idCamiseta);
    }
        
    @DELETE
    @Path("{CARRITO_ID}")
    public void eliminarCarrito(@PathParam("CARRITO_ID") long id){
        carritoLogic.eliminarCarrito(id);
    }
    
}

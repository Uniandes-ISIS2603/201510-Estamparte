/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.estamparte.estamparte.service;

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
    public CarritoDTO crearCarrito (CarritoDTO formaPago){
        return carritoLogic.crearCarrito(formaPago);
    }
    
    @GET
    public CarritoPageDTO darCarritos(@QueryParam("pagina")Integer pagina, @QueryParam("datosMaximos")Integer datosMaximos){
        return carritoLogic.darCarritos(pagina, datosMaximos);
    }
    
    @GET
    public List<CarritoDTO> darCarritos(){
        return carritoLogic.darCarritos();
    }
    
    @PUT
    public void actualizarCarrito(CarritoDTO formaPago){
        carritoLogic.actualizarCarrito(formaPago);
    }
    
    @DELETE
    public void eliminarCarrito(String nombre){
        carritoLogic.eliminarCarrito(nombre);
    }
    
}

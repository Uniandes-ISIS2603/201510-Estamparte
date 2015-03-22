/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.estamparte.estamparte.service;

import co.edu.uniandes.estamparte.carrito.logic.dto.CarritoDTO;
import co.edu.uniandes.estamparte.carrito.logic.api.ICarritoLogic;
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
    private ICarritoLogic carrito;
    
    @POST
    public CarritoDTO crearCarrito (CarritoDTO formaPago){
        return carrito.crearCarrito(formaPago);
    }
    
    @GET
    public List<CarritoDTO> darCarritos(){
        return carrito.darCarritos();
    }
    
    @PUT
    public void actualizarCarrito(CarritoDTO formaPago){
        carrito.actualizarCarrito(formaPago);
    }
    
    @DELETE
    public void eliminarCarrito(String nombre){
        carrito.eliminarCarrito(nombre);
    }
    
}

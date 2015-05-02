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
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
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
    protected ICarritoLogic carritoLogic;
    
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
    @Path("/{id}")
    public CompradorDTO getComprador(Long id){
        return compradorlogic.getComprador(id);
    }
    
    @DELETE
    public CompradorDTO deleteComprador(Long id){
        return compradorlogic.deleteComprador(id);
    }
    
    @PUT
    public void updateComprador(CompradorDTO detalles){
        compradorlogic.updateComprador(detalles);
    }
    
}

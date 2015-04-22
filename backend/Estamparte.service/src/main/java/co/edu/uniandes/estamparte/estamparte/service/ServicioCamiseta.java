/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.estamparte.estamparte.service;

import co.edu.uniandes.estamparte.camiseta.logic.api.ICamisetaLogic;
import co.edu.uniandes.estamparte.camiseta.logic.dto.CamisetaDTO;
import co.edu.uniandes.estamparte.camiseta.logic.dto.CamisetaPageDTO;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/camisetas")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

/**
 *
 * @author estudiante
 */
public class ServicioCamiseta 
{
      @Inject
    protected ICamisetaLogic countryLogic;

    @POST
    public CamisetaDTO createCamiseta(CamisetaDTO camiseta) {
        return countryLogic.crearCamiseta(camiseta);
    }

    @DELETE
    @Path("{id}")
    public void deleteCamiseta(@PathParam("id") long id) {
        countryLogic.eliminarCamiseta(id);
    }

    @GET
    public CamisetaPageDTO darCamisetas(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords) {
        return countryLogic.darCamisetas(page, maxRecords);
    }

    @GET
    @Path("{id}")
    public CamisetaDTO darCamiseta(@PathParam("id") long id) {
        return countryLogic.darCamiseta(id);
    }
}

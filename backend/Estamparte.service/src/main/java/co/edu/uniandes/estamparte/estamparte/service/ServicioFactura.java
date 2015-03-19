/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.estamparte.estamparte.service;

import co.edu.uniandes.estamparte.factura.logic.api.IFacturaLogic;
import co.edu.uniandes.estamparte.factura.logic.dto.FacturaDTO;
import co.edu.uniandes.estamparte.factura.logic.dto.FacturaPageDTO;
import java.util.ArrayList;


public class ServicioFactura 
{
    @Inject
    protected IFacturaLogic facturalogic;
    
    @POST
    public FacturaDTO createFactura(FacturaDTO detalles)    {
        return facturalogic.createFactura(detalles);
    }
    
    @GET
    public FacturaPageDTO getFacturas(Integer numPagina, Integer maxRecords){
        return facturalogic.getFacturas(numPagina, maxRecords);
    }
    
    @GET
    public ArrayList<FacturaDTO> getFacturas()
    {
        return facturalogic.getFacturas();
    }
    
    @GET
    public FacturaDTO getFactura(Long id){
        return facturalogic.getFactura(id);
    }
    
    @DELETE
    public FacturaDTO deleteFactura(Long id){
        return facturalogic.deleteFactura(id);
    }
            
    @PUT
    public void updateFactura(FacturaDTO detalles){
        facturalogic.updateFactura(detalles);
    }
    
}

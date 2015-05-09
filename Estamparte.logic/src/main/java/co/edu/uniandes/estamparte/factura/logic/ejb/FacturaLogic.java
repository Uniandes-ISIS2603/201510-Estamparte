/*
 * Manejo de la BD de las estampas
 */
package co.edu.uniandes.estamparte.factura.logic.ejb;

import co.edu.uniandes.estamparte.estampa.logic.ejb.*;
import co.edu.uniandes.estamparte.factura.logic.api.IFacturaLogic;
import co.edu.uniandes.estamparte.factura.logic.dto.FacturaDTO;
import co.edu.uniandes.estamparte.factura.logic.dto.FacturaPageDTO;
import co.edu.uniandes.estamparte.factura.logic.entity.FacturaEntity;
import co.edu.uniandes.estamparte.factura.logic.converter.FacturaConverter;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class FacturaLogic implements IFacturaLogic{

    @PersistenceContext(unitName = "EstampartePU")
    protected EntityManager entityManager;

    public FacturaDTO createFacturaComprador(long idComprador, FacturaDTO factura) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public FacturaDTO deleteFacturaComprador(long idComprador, long idFactura) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public FacturaPageDTO getFacturasComprador(long idComprador, Integer pagina, Integer datosMaximos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public FacturaDTO updateFacturaComprador(long idComprador, FacturaDTO factura) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public FacturaPageDTO getFacturas(Integer pagina, Integer datosMaximos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public FacturaDTO getFactura(long idFactura) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public FacturaDTO deleteFactura(long idFactura) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteFacturas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

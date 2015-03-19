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

import java.util.ArrayList;
import javax.persistence.EntityManager;


public class FacturaLogic implements IFacturaLogic{


    protected EntityManager entityManager;
    
    @Override
    public FacturaDTO createFactura(FacturaDTO detalles) {
        FacturaEntity entity = FacturaConverter.persistenceDTO2Entity(detalles);
        entityManager.persist(entity);
        return FacturaConverter.entity2PersistenceDTO(entity);
    }

    @Override
    public FacturaPageDTO getFacturas(Integer numPagina, Integer maxRecords) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<FacturaDTO> getFacturas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FacturaDTO getFactura(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FacturaDTO deleteFactura(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateFactura(FacturaDTO detalles) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

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
import javax.persistence.Query;

public class FacturaLogic implements IFacturaLogic{


    protected EntityManager entityManager;
    
    @Override
    public FacturaDTO createFactura(FacturaDTO detalles) {
        FacturaEntity entity = FacturaConverter.persistenceDTO2Entity(detalles);
        entityManager.persist(entity);
        return FacturaConverter.entity2PersistenceDTO(entity);
    }

    @Override
    public List<FacturaDTO> getFacturas() {
        
        Query q = entityManager.createQuery("select u from FacturaEntity u");
        return FacturaConverter.entity2PersistenceDTOList(q.getResultList());
    }

    @Override
    public FacturaDTO getFactura(Long id) {
        return FacturaConverter.entity2PersistenceDTO(entityManager.find(FacturaEntity.class, id));
    }

    @Override
    public FacturaDTO deleteFactura(Long id) {
        FacturaEntity entity = entityManager.find(FacturaEntity.class, id);
        entityManager.remove(entity);    
        return FacturaConverter.entity2PersistenceDTO(entity);
    }

    @Override
    public void updateFactura(FacturaDTO detalles) {
        FacturaEntity entity = entityManager.merge(FacturaConverter.persistenceDTO2Entity(detalles));
        FacturaConverter.entity2PersistenceDTO(entity);
    }
    
}

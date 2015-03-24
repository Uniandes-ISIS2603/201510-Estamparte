/*
 * Manejo de la BD de las estampas
 */
package co.edu.uniandes.estamparte.comprador.logic.ejb;

import co.edu.uniandes.estamparte.carrito.logic.ejb.*;
import co.edu.uniandes.estamparte.artista.logic.ejb.*;
import co.edu.uniandes.estamparte.camiseta.logic.ejb.*;
import co.edu.uniandes.estamparte.comprador.logic.api.ICompradorLogic;
import co.edu.uniandes.estamparte.comprador.logic.converter.CompradorConverter;
import co.edu.uniandes.estamparte.comprador.logic.dto.CompradorDTO;
import co.edu.uniandes.estamparte.comprador.logic.dto.CompradorPageDTO;
import co.edu.uniandes.estamparte.comprador.logic.entity.CompradorEntity;
import co.edu.uniandes.estamparte.estampa.logic.ejb.*;
import co.edu.uniandes.estamparte.factura.logic.converter.FacturaConverter;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class CompradorLogic implements ICompradorLogic{

        protected EntityManager entityManager;

    @Override
    public CompradorDTO createComprador(CompradorDTO detalles) {
        CompradorEntity entity = CompradorConverter.persistenceDTO2Entity(detalles);
        entityManager.persist(entity);
        return CompradorConverter.entity2PersistenceDTO(entity);    }

    

    @Override
    public List<CompradorDTO> getCompradores() {
     Query q = entityManager.createQuery("select u from FacturaEntity u");
        return CompradorConverter.convertirDeListaEntidadesAListaDTO(q.getResultList());
    }

    @Override
    public CompradorDTO getComprador(Long id) {
        return CompradorConverter.entity2PersistenceDTO(entityManager.find(CompradorEntity.class, id));
    }

    @Override
    public CompradorDTO deleteComprador(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateComprador(CompradorDTO detalles) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

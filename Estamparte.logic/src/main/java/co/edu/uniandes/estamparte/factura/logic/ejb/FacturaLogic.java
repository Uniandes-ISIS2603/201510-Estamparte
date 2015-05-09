/*
 * Manejo de la BD de las estampas
 */
package co.edu.uniandes.estamparte.factura.logic.ejb;

import co.edu.uniandes.estamparte.comprador.logic.entity.CompradorEntity;
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
    
    @Override
    public FacturaDTO createFacturaComprador(long idComprador, FacturaDTO factura) {
        CompradorEntity comprador = entityManager.find(CompradorEntity.class, idComprador);
        if(comprador!=null){
            FacturaEntity facturaE = FacturaConverter.persistenceDTO2Entity(factura);
            entityManager.persist(facturaE);
            return FacturaConverter.entity2PersistenceDTO(facturaE);
        }
        else
            return null;
    }

    @Override
    public FacturaDTO deleteFacturaComprador(long idComprador, long idFactura) {
        CompradorEntity comprador = entityManager.find(CompradorEntity.class, idComprador);
        if(comprador!=null){
            FacturaEntity factura = entityManager.find(FacturaEntity.class, idFactura); 
            entityManager.remove(factura);
            return FacturaConverter.entity2PersistenceDTO(factura);
        }
        else
            return null;
    }

    @Override
    public FacturaPageDTO getFacturasComprador(long idComprador, Integer pagina, Integer datosMaximos) {
        Query cuenta = entityManager.createQuery("select count(u) from FacturaEntity u where u.comprador.id = '"+idComprador+"'");
        Long cuentaReg = 0L;
        cuentaReg = Long.parseLong(cuenta.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from FacturaEntity u where u.comprador.id =  '"+idComprador+"'");
        if(pagina != null && datosMaximos != null){
            q.setFirstResult((pagina-1)*datosMaximos);
            q.setMaxResults(datosMaximos);
        }
        FacturaPageDTO respuesta = new FacturaPageDTO();
        respuesta.setTotalRecords(cuentaReg);
        respuesta.setRecords(FacturaConverter.entity2PersistenceDTOList(q.getResultList()));
        return respuesta;
    }

    @Override
    public FacturaDTO updateFacturaComprador(long idComprador, FacturaDTO factura) {
        CompradorEntity comprador = entityManager.find(CompradorEntity.class, idComprador);
        if(comprador != null){
            FacturaEntity facturaE = entityManager.merge(FacturaConverter.persistenceDTO2Entity(factura));
            return FacturaConverter.entity2PersistenceDTO(facturaE);
        }
        else
            return null;
    }

    @Override
    public FacturaPageDTO getFacturas(Integer pagina, Integer datosMaximos) {
        Query cuenta = entityManager.createQuery("select count(u) from FacturaEntity u");
        Long cuentaReg = 0L;
        cuentaReg = Long.parseLong(cuenta.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from FacturaEntity u ");
        if(pagina != null && datosMaximos != null){
            q.setFirstResult((pagina-1)*datosMaximos);
            q.setMaxResults(datosMaximos);
        }
        FacturaPageDTO respuesta = new FacturaPageDTO();
        respuesta.setTotalRecords(cuentaReg);
        respuesta.setRecords(FacturaConverter.entity2PersistenceDTOList(q.getResultList()));
        return respuesta;
    }

    @Override
    public FacturaDTO getFactura(long idFactura) {
       FacturaEntity factura = entityManager.find(FacturaEntity.class, idFactura);
       return FacturaConverter.entity2PersistenceDTO(factura);
    }

    @Override
    public FacturaDTO deleteFactura(long idFactura) {
        FacturaEntity factura = entityManager.find(FacturaEntity.class, idFactura); 
        entityManager.remove(factura);
        return FacturaConverter.entity2PersistenceDTO(factura);
    }

    @Override
    public void deleteFacturas() {
        Query q = entityManager.createQuery("delete from FacturaEntity u");
        q.executeUpdate();
    }
    
    
}

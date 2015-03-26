/*
 * Manejo de la BD de las estampas
 */
package co.edu.uniandes.estamparte.camiseta.logic.ejb;

import co.edu.uniandes.estamparte.camiseta.logic.api.*;
import co.edu.uniandes.estamparte.camiseta.logic.converter.CamisetaConverter;
import co.edu.uniandes.estamparte.camiseta.logic.dto.CamisetaDTO;
import co.edu.uniandes.estamparte.camiseta.logic.dto.CamisetaPageDTO;
import co.edu.uniandes.estamparte.camiseta.logic.entity.CamisetaEntity;
import co.edu.uniandes.estamparte.camiseta.logic.dto.CamisetaDTO;
import co.edu.uniandes.estamparte.carrito.logic.entity.CarritoEntity;
import co.edu.uniandes.estamparte.estampa.logic.converter.EstampaConverter;
import co.edu.uniandes.estamparte.estampa.logic.dto.EstampaDTO;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


public class CamisetaLogic implements ICamisetaLogic  {

    @PersistenceContext(unitName = "EstampartePU")
    protected EntityManager entityManager;
    
    @Override
    public CamisetaDTO crearCamiseta(CamisetaDTO detail) {
     
        CamisetaEntity entity = CamisetaConverter.persistenceDTO2Entity(detail);
        entityManager.persist(entity);
        return CamisetaConverter.entity2PersistenceDTO(entity);
    }

    @Override
    public List<CamisetaDTO> darCamisetas() {
        Query q = entityManager.createQuery("select u from CamisetaEntity u");
        return CamisetaConverter.entity2PersistenceDTOList(q.getResultList());
    }

    @Override
    public CamisetaPageDTO darCamisetas(Integer page, Integer maxRecords) {
         Query count = entityManager.createQuery("select count(u) from CamisetaEntity u");
        Long regCount = 0L;
        regCount = Long.parseLong(count.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from CamisetaEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        CamisetaPageDTO response = new CamisetaPageDTO();
        response.asignarTotal(regCount);
        response.asignarCamisetas(CamisetaConverter.entity2PersistenceDTOList(q.getResultList()));
        return response;
    }

    @Override
    public CamisetaDTO darCamiseta(String id) {
         return CamisetaConverter.entity2PersistenceDTO(entityManager.find(CamisetaEntity.class, id));
    }

    @Override
    public void eliminarCamiseta(String id) {
        CamisetaEntity entity = entityManager.find(CamisetaEntity.class, id);
        entityManager.remove(entity);
    }
    
    public CamisetaDTO actualizarCamiseta(CamisetaDTO camiseta){
        CamisetaEntity entidad = entityManager.merge(CamisetaConverter.persistenceDTO2Entity(camiseta));
        return CamisetaConverter.entity2PersistenceDTO(entidad);
    }
    
    public CamisetaPageDTO obtenerCamisetasDeCarrito(String idCarrito, Integer pagina, Integer datosMaximos) {
        Query cuenta = entityManager.createQuery("select count(u) from CamisetaEntity u where u.carroDuenio = '" + idCarrito + "'");
        Long cuentaReg = Long.parseLong(cuenta.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from CamisetaEntity u where u.carroDuenio = '"+idCarrito+"'");
        if(pagina != null && datosMaximos != null){
            q.setFirstResult((pagina-1)*datosMaximos);
            q.setMaxResults(datosMaximos);
        }
       CamisetaPageDTO respuesta = new CamisetaPageDTO();
        respuesta.asignarTotal(cuentaReg);
        respuesta.asignarCamisetas(CamisetaConverter.entity2PersistenceDTOList(q.getResultList()));
        return respuesta;
    }

    @Override
    public boolean agregarEstampa(String idCamiseta, EstampaDTO estampa) {
        CamisetaEntity entidad = entityManager.find(CamisetaEntity.class, idCamiseta);
        if(entidad != null)
        {
            return entidad.agregarEstampa(EstampaConverter.convertirDeDTOAEntidad(estampa));
        }
        return false;
    }

    @Override
    public boolean eliminarEstampa(String idCamiseta, long id) {
         CamisetaEntity entidad = entityManager.find(CamisetaEntity.class, idCamiseta);
        if(entidad != null)
            return entidad.eliminarEstampa(id);
        return false;
    }
    
}

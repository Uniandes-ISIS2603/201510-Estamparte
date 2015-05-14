/*
 * Manejo de la BD de las estampas
 */
package co.edu.uniandes.estamparte.comprador.logic.ejb;

import co.edu.uniandes.estamparte.carrito.logic.api.ICarritoLogic;
import co.edu.uniandes.estamparte.comprador.logic.api.ICompradorLogic;
import co.edu.uniandes.estamparte.comprador.logic.converter.CompradorConverter;
import co.edu.uniandes.estamparte.comprador.logic.dto.CompradorDTO;
import co.edu.uniandes.estamparte.comprador.logic.dto.CompradorPageDTO;
import co.edu.uniandes.estamparte.comprador.logic.entity.CompradorEntity;
import co.edu.uniandes.estamparte.formaPago.logic.api.IFormaPagoLogic;
import co.edu.uniandes.estamparte.formaPago.logic.converter.FormaPagoConverter;
import co.edu.uniandes.estamparte.formaPago.logic.dto.FormaPagoDTO;
import co.edu.uniandes.estamparte.formaPago.logic.entity.FormaPagoEntity;
import java.util.*;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


public class CompradorLogic implements ICompradorLogic{
    
    @PersistenceContext(unitName = "EstampartePU")
    protected EntityManager entityManager;
    
    @Inject
    IFormaPagoLogic formaPagoLogic;
    
    @Inject
    ICarritoLogic carritoLogic;
             

    @Override
    public CompradorDTO createComprador(CompradorDTO detalles) {
        CompradorEntity entity = CompradorConverter.persistenceDTO2Entity(detalles);
        entityManager.persist(entity);
        return CompradorConverter.entity2PersistenceDTO(entity);
    }

    @Override
    public CompradorPageDTO getCompradores(Integer pagina, Integer datosMaximos) {
        Query cuenta = entityManager.createQuery("select count(u) from CompradorEntity u");
        Long cuentaReg = 0L;
        cuentaReg = Long.parseLong(cuenta.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from CompradorEntity u");
        if(pagina !=null && datosMaximos!=null){
            q.setFirstResult((pagina-1)*datosMaximos);
            q.setMaxResults(datosMaximos);
        }
        CompradorPageDTO respuesta = new CompradorPageDTO();
        respuesta.setTotalCompradores(cuentaReg);
        respuesta.setCompradores(CompradorConverter.convertirDeListaEntidadesAListaDTO(q.getResultList()));
        return respuesta;
    }

    @Override
    public CompradorDTO getComprador(long id) {
        return CompradorConverter.entity2PersistenceDTO(entityManager.find(CompradorEntity.class, id));
    }

    @Override
    public CompradorDTO deleteComprador(long id) {
        CompradorEntity entity = entityManager.find(CompradorEntity.class, id);
        if(entity!=null){
        
        formaPagoLogic.eliminarFormasPagoComprado(id);
        carritoLogic.eliminarCarrito(entity.getCarrito().getIdCarrito());
        
        entityManager.remove(entity);    
        return CompradorConverter.entity2PersistenceDTO(entity);
        }
        else
            return null;
    }

    @Override
    public void updateComprador(long id, CompradorDTO detalles) {
        CompradorEntity entity = entityManager.find(CompradorEntity.class, id);
        if(entity!=null){
        entityManager.merge(CompradorConverter.persistenceDTO2Entity(detalles));
        }
        else{
            entityManager.persist(CompradorConverter.persistenceDTO2Entity(detalles));
        }
    }

    public FormaPagoDTO crearFormaPagoComprador(long idComprador, FormaPagoDTO formaPago) {
        CompradorEntity comprador = entityManager.find(CompradorEntity.class, idComprador);
        FormaPagoDTO respuesta = null;
        if(comprador!=null){
           respuesta = formaPagoLogic.crearFormaPago(formaPago);
        }
        return respuesta;
    }

    public List<FormaPagoDTO> darFormasPagoComprador(long idComprador) {
        return formaPagoLogic.darFormasPagoComprador(idComprador);
    }
    
    @Override
    public FormaPagoDTO actualizarFormaPagoComprador(long idComprador, FormaPagoDTO formaPago) {
        CompradorEntity comprador = entityManager.find(CompradorEntity.class, idComprador);
        FormaPagoDTO respuesta = null;
        if(comprador!=null){
            respuesta = formaPagoLogic.actualizarFormaPago(formaPago);
        }
        return respuesta;
    }

    public void eliminarFormaPagoComprador(long idComprador, long idFormaPago) {
       CompradorEntity comprador = entityManager.find(CompradorEntity.class, idComprador);
       if(comprador !=null){
           formaPagoLogic.eliminarFormaPago(idFormaPago);
       }
    }


    
}

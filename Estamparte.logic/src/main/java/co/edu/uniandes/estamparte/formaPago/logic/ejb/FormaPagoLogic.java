/*
 * Manejo de la BD de las estampas
 */
package co.edu.uniandes.estamparte.formaPago.logic.ejb;

import co.edu.uniandes.estamparte.formaPago.logic.api.IFormaPagoLogic;
import co.edu.uniandes.estamparte.formaPago.logic.converter.FormaPagoConverter;
import co.edu.uniandes.estamparte.formaPago.logic.dto.FormaPagoDTO;
import co.edu.uniandes.estamparte.formaPago.logic.dto.FormaPagoPageDTO;
import co.edu.uniandes.estamparte.formaPago.logic.entity.FormaPagoEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class FormaPagoLogic implements IFormaPagoLogic{
    
    @PersistenceContext(unitName = "EstampartePU")
    protected EntityManager em;
    
    @Override 
    public FormaPagoDTO crearFormaPago (FormaPagoDTO formaPago){
        FormaPagoEntity entity = FormaPagoConverter.convertirDeDTOAEntidad(formaPago);
        em.persist(entity);
        return FormaPagoConverter.convertirDeEntidadADTO(entity);
    }
    
    @Override
    public FormaPagoPageDTO darFormasPago(Integer pagina, Integer datosMaximos){
        Query cantidad = em.createQuery("select count(formaPago) from FormaPagoEntity formaPago");
        Long cuentaReg = Long.parseLong(cantidad.getSingleResult().toString());
        Query consulta = em.createQuery("select formaPago from FormaPagoEntity formaPago");
        if(pagina !=null && datosMaximos!=null){
            consulta.setFirstResult((pagina-1)*datosMaximos);
            consulta.setMaxResults(datosMaximos);
        }
        FormaPagoPageDTO respuesta = new FormaPagoPageDTO();
        respuesta.setCantidad(cuentaReg);
        respuesta.setFormasPago(FormaPagoConverter.convertirDeListaEntidadesAListaDTO(consulta.getResultList()));
        return respuesta;
    }
    
    @Override
    public FormaPagoDTO actualizarFormaPago(FormaPagoDTO formaPago){
        FormaPagoEntity entity = em.merge(FormaPagoConverter.convertirDeDTOAEntidad(formaPago));
        return FormaPagoConverter.convertirDeEntidadADTO(entity);
    }
    
    @Override
    public void eliminarFormaPago(Long numeroTarjeta){
        FormaPagoEntity entity = em.find(FormaPagoEntity.class, numeroTarjeta);
        em.remove(entity);
    }
    
    @Override
    public void eliminarFormasPago() {
        Query consulta = em.createQuery("delete from FormaPagoEntity formasPago");
        consulta.executeUpdate();
    }
    
    @Override
    public FormaPagoPageDTO darFormasPagoComprador(long idComprador, Integer pagina, Integer datosMaximos) {
        Query cantidad = em.createQuery("select count(formaPago) from FormaPagoEntity formaPago where formaPago.comprador.id = '"+idComprador+"'");
        Long cuentaReg = Long.parseLong(cantidad.getSingleResult().toString());
        Query consulta = em.createQuery("select formaPago from FormaPagoEntity formaPago where formaPago.comprador.id = '"+idComprador+"'");
        if(pagina !=null && datosMaximos!=null){
            consulta.setFirstResult((pagina-1)*datosMaximos);
            consulta.setMaxResults(datosMaximos);
        }
        FormaPagoPageDTO respuesta = new FormaPagoPageDTO();
        respuesta.setCantidad(cuentaReg);
        respuesta.setFormasPago(FormaPagoConverter.convertirDeListaEntidadesAListaDTO(consulta.getResultList()));
        return respuesta;

    }
    
    @Override
    public void eliminarFormasPagoComprado(long idComprador){
        em.createQuery("DELETE FROM FormaPagoEntity u WHERE u.comprador.id = '"+idComprador+"'").executeUpdate();
    }
}

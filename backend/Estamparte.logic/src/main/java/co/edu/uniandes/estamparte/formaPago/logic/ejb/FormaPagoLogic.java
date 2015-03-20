/*
 * Manejo de la BD de las estampas
 */
package co.edu.uniandes.estamparte.formaPago.logic.ejb;

import co.edu.uniandes.estamparte.formaPago.logic.api.IFormaPagoLogic;
import co.edu.uniandes.estamparte.formaPago.logic.converter.FormaPagoConverter;
import co.edu.uniandes.estamparte.formaPago.logic.dto.FormaPagoDTO;
import co.edu.uniandes.estamparte.formaPago.logic.entity.FormaPagoEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class FormaPagoLogic implements IFormaPagoLogic{
    
    @PersistenceContext(unitName = "EstampartePU")
    protected EntityManager em;
    
    public FormaPagoDTO crearFormaPago (FormaPagoDTO formaPago){
        FormaPagoEntity entity = FormaPagoConverter.convertirDeDTOAEntidad(formaPago);
        em.persist(entity);
        return FormaPagoConverter.convertirDeEntidadADTO(entity);
    }
    
    public List<FormaPagoDTO> darFormasPago(){
        Query consulta = em.createQuery("Select formasPago From FormaPagoEntity formasPago");
        return FormaPagoConverter.convertirDeListaEntidadesAListaDTO(consulta.getResultList());
    }
    
    public void actualizarFormaPago(FormaPagoDTO formaPago){
        FormaPagoEntity entity = em.merge(FormaPagoConverter.convertirDeDTOAEntidad(formaPago));
        FormaPagoConverter.convertirDeEntidadADTO(entity);
    }
    
    public void eliminarFormaPago(String nombre){
        FormaPagoEntity entity = em.find(FormaPagoEntity.class, nombre);
        em.remove(entity);
    }
}

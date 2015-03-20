/*
 * Manejo de la BD de las estampas
 */
package co.edu.uniandes.estamparte.carrito.logic.ejb;

import co.edu.uniandes.estamparte.carrito.logic.api.ICarritoLogic;
import co.edu.uniandes.estamparte.carrito.logic.converter.CarritoConverter;
import co.edu.uniandes.estamparte.carrito.logic.dto.CarritoDTO;
import co.edu.uniandes.estamparte.carrito.logic.entity.CarritoEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class CarritoLogic implements ICarritoLogic {
   
    @PersistenceContext(unitName = "EstampartePU")
    protected EntityManager em;
    
    public CarritoDTO crearCarrito (CarritoDTO formaPago){
        CarritoEntity entity = CarritoConverter.convertirDeDTOAEntidad(formaPago);
        em.persist(entity);
        return CarritoConverter.convertirDeEntidadADTO(entity);
    }
    
    public List<CarritoDTO> darFormasPago(){
        Query consulta = em.createQuery("Select carritos From CarritoEntity carritos");
        return CarritoConverter.convertirDeListaEntidadesAListaDTO(consulta.getResultList());
    }
    
    public void actualizarCarrito(CarritoDTO formaPago){
        CarritoEntity entity = em.merge(CarritoConverter.convertirDeDTOAEntidad(formaPago));
        CarritoConverter.convertirDeEntidadADTO(entity);
    }
    
    public void eliminarCarrito(String nombre){
        CarritoEntity entity = em.find(CarritoEntity.class, nombre);
        em.remove(entity);
    }
    
}

/*
 * Manejo de la BD de las estampas
 */
package co.edu.uniandes.estamparte.carrito.logic.ejb;

import co.edu.uniandes.estamparte.camiseta.logic.converter.CamisetaConverter;
import co.edu.uniandes.estamparte.camiseta.logic.dto.CamisetaDTO;
import co.edu.uniandes.estamparte.camiseta.logic.dto.CamisetaPageDTO;
import co.edu.uniandes.estamparte.camiseta.logic.ejb.CamisetaLogic;
import co.edu.uniandes.estamparte.camiseta.logic.entity.CamisetaEntity;
import co.edu.uniandes.estamparte.carrito.logic.api.ICarritoLogic;
import co.edu.uniandes.estamparte.carrito.logic.converter.CarritoConverter;
import co.edu.uniandes.estamparte.carrito.logic.dto.CarritoDTO;
import co.edu.uniandes.estamparte.carrito.logic.dto.CarritoPageDTO;
import co.edu.uniandes.estamparte.carrito.logic.entity.CarritoEntity;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class CarritoLogic implements ICarritoLogic {
   
    @PersistenceContext(unitName = "EstampartePU")
    protected EntityManager em;
    
    @Inject
    private CamisetaLogic camisetaLogic;
    
    public CarritoDTO crearCarrito (CarritoDTO carrito){
        CarritoEntity entity = CarritoConverter.convertirDeDTOAEntidad(carrito);
        em.persist(entity);
        return CarritoConverter.convertirDeEntidadADTO(entity);
    }
    
    public CarritoPageDTO darCarritos(Integer pagina, Integer datosMaximos){
        Query cantidad = em.createQuery("select count(carritos) from CarritoEntity carritos");
        Long cuentaReg = Long.parseLong(cantidad.getSingleResult().toString());
        Query consulta = em.createQuery("select carritos from CarritoEntity carritos");
        if(pagina !=null && datosMaximos!=null){
            consulta.setFirstResult((pagina-1)*datosMaximos);
            consulta.setMaxResults(datosMaximos);
        }
        CarritoPageDTO respuesta = new CarritoPageDTO();
        respuesta.setCantidad(cuentaReg);
        respuesta.setCarritos(CarritoConverter.convertirDeListaEntidadesAListaDTO(consulta.getResultList()));
        return respuesta;
    }
    
    public List<CarritoDTO> darCarritos(){
        Query consulta = em.createQuery("Select carritos From CarritoEntity carritos");
        return CarritoConverter.convertirDeListaEntidadesAListaDTO(consulta.getResultList());
    }
    
    public void actualizarCarrito(CarritoDTO formaPago){
        CarritoEntity entity = em.merge(CarritoConverter.convertirDeDTOAEntidad(formaPago));
        CarritoConverter.convertirDeEntidadADTO(entity);
    }
    
    public void eliminarCarrito(long id){
        CarritoEntity entity = em.find(CarritoEntity.class, id);
        em.remove(entity);
    }
    
    public CamisetaPageDTO darCamisetasCarrito(long idCarrito, Integer pagina, Integer datosMaximos) {
        CarritoEntity entidad = em.find(CarritoEntity.class, idCarrito);
        CamisetaPageDTO respuesta = null;
        if(entidad != null){
            respuesta = camisetaLogic.obtenerCamisetasDeCarrito(idCarrito, pagina, datosMaximos);
        }
        return respuesta;
    }
    
    public CamisetaDTO agregarCamisetaACarrito(long idCarrito, CamisetaDTO camiseta) {
        CarritoEntity entidad = em.find(CarritoEntity.class, idCarrito);
        CamisetaEntity camisetaBD = em.find(CamisetaEntity.class, camiseta.getId());
        CamisetaDTO respuesta = null;
        if(entidad != null){
            if(camisetaBD == null)
                respuesta = camisetaLogic.crearCamiseta(camiseta);
            else
                respuesta = CamisetaConverter.entity2PersistenceDTO(camisetaBD);
            
            entidad.agregarCamiseta(CamisetaConverter.persistenceDTO2Entity(respuesta));
            em.merge(entidad);
        }
        return respuesta;
    }
    
    public void eliminarCamisetaCarrito(long idCarrito, long idCamiseta) {
        CarritoEntity entidad = em.find(CarritoEntity.class, idCarrito);
        if(entidad != null){
            entidad.eliminarCamiseta(em.find(CamisetaEntity.class, idCamiseta));
            em.merge(entidad);
            
        }
    }
    
    public CamisetaDTO actualizarCamisetaCarrito(long idCarrito, CamisetaDTO camiseta) {
        CarritoEntity entidad = em.find(CarritoEntity.class, idCarrito);
        CamisetaDTO respuesta = null;
        if(entidad != null){
            entidad.actualizarCamiseta(CamisetaConverter.persistenceDTO2Entity(camiseta));
            em.merge(entidad);
            respuesta = camisetaLogic.actualizarCamiseta(camiseta);
        }
        return respuesta;
    }
    
    public CamisetaPageDTO obtenerCamisetasDeCarrito(long idCarrito){
        CarritoEntity carrito = em.find(CarritoEntity.class, idCarrito);
        CamisetaPageDTO respuesta = new CamisetaPageDTO();
        respuesta.setTotal(carrito.getCamisetas().size());
        respuesta.setCamisetas(CamisetaConverter.entity2PersistenceDTOList(carrito.getCamisetas()));
        return respuesta;
    }
}

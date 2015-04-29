/*
 * Manejo de la BD de las estampas
 */
package co.edu.uniandes.estamparte.estampa.logic.ejb;

import co.edu.uniandes.estamparte.artista.logic.entity.ArtistaEntity;
import co.edu.uniandes.estamparte.estampa.logic.api.IEstampaLogic;
import co.edu.uniandes.estamparte.estampa.logic.converter.EstampaConverter;
import co.edu.uniandes.estamparte.estampa.logic.dto.EstampaDTO;
import co.edu.uniandes.estamparte.estampa.logic.dto.EstampaPageDTO;
import co.edu.uniandes.estamparte.estampa.logic.entity.EstampaEntity;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Default
@Stateless
@LocalBean
public class EstampaLogic implements IEstampaLogic {
    
    @PersistenceContext(unitName="EstampartePU")
    protected EntityManager manejador;
    
    @Override
    public EstampaDTO crearEstampa(EstampaDTO estampa) {
        EstampaEntity entidad = EstampaConverter.convertirDeDTOAEntidad(estampa);
        manejador.persist(entidad);
        return EstampaConverter.convertirDeEntidadADTO(entidad);
    }

    @Override
    public EstampaDTO eliminarEstampa(Long id) {
        EstampaEntity entidad = manejador.find(EstampaEntity.class, id);
        manejador.remove(entidad);
        return EstampaConverter.convertirDeEntidadADTO(entidad);
    }

    @Override
    public List<EstampaDTO> obtenerEstampas() {
        Query query = manejador.createQuery("select u from EstampaEntity u");
        return EstampaConverter.convertirDeListaEntidadesAListaDTO(query.getResultList());
    }

    @Override
    public EstampaPageDTO obtenerEstampas(Integer pagina, Integer datosMaximos) {
        Query cuenta = manejador.createQuery("select count(u) from EstampaEntity u");
        Long cuentaReg = 0L;
        cuentaReg = Long.parseLong(cuenta.getSingleResult().toString());
        Query q = manejador.createQuery("select u from EstampaEntity u");
        if(pagina != null && datosMaximos != null){
            q.setFirstResult((pagina-1)*datosMaximos);
            q.setMaxResults(datosMaximos);
        }
        EstampaPageDTO respuesta = new EstampaPageDTO();
        respuesta.setTotalEstampas(cuentaReg);
        respuesta.setEstampas(EstampaConverter.convertirDeListaEntidadesAListaDTO(q.getResultList()));
        return respuesta;
    }

    @Override
    public EstampaDTO actualizarEstampa(EstampaDTO estampa) {
        EstampaEntity entidad = manejador.merge(EstampaConverter.convertirDeDTOAEntidad(estampa));
        return EstampaConverter.convertirDeEntidadADTO(entidad);
    }

    @Override
    public EstampaDTO darEstampa(Long id) {
        EstampaEntity entidad = manejador.find(EstampaEntity.class, id);
        return EstampaConverter.convertirDeEntidadADTO(entidad);
    }

    @Override
    public void eliminarEstampas() {
        Query q = manejador.createQuery("delete from EstampaEntity u");
        q.executeUpdate();
    }

    @Override
    public EstampaPageDTO obtenerEstampasDeArtista(Long idArtista, Integer pagina, Integer datosMaximos) {

        Query cuenta = manejador.createQuery("select count(u) from EstampaEntity u where u.duenho.id = '"+idArtista+"'");
        Long cuentaReg = 0L;
        cuentaReg = Long.parseLong(cuenta.getSingleResult().toString());
        Query q = manejador.createQuery("select u from EstampaEntity u where u.duenho.id =  '"+idArtista+"'");
        if(pagina != null && datosMaximos != null){
            q.setFirstResult((pagina-1)*datosMaximos);
            q.setMaxResults(datosMaximos);
        }
        EstampaPageDTO respuesta = new EstampaPageDTO();
        respuesta.setTotalEstampas(cuentaReg);
        respuesta.setEstampas(EstampaConverter.convertirDeListaEntidadesAListaDTO(q.getResultList()));
        return respuesta;
    }
    
}

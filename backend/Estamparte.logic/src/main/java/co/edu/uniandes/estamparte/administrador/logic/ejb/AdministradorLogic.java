/*
 * Manejo de la BD de los artistas
 */
package co.edu.uniandes.estamparte.administrador.logic.ejb;

import co.edu.uniandes.estamparte.artista.logic.ejb.*;
import co.edu.uniandes.estamparte.artista.logic.api.IArtistaLogic;
import co.edu.uniandes.estamparte.artista.logic.converter.ArtistaConverter;
import co.edu.uniandes.estamparte.artista.logic.dto.ArtistaDTO;
import co.edu.uniandes.estamparte.artista.logic.dto.ArtistaPageDTO;
import co.edu.uniandes.estamparte.artista.logic.entity.ArtistaEntity;
import co.edu.uniandes.estamparte.estampa.logic.api.IEstampaLogic;
import co.edu.uniandes.estamparte.estampa.logic.dto.EstampaDTO;
import co.edu.uniandes.estamparte.estampa.logic.dto.EstampaPageDTO;
import co.edu.uniandes.estamparte.estampa.logic.ejb.EstampaLogic;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;


//Esta clase es la que tiene conexión con la base de datos, por lo que todos los objetos que debe
//retornar son de tipo DTO, que es el objeto de transferencia de la información

//Para convertir objetos de java a objetos DTO se usa el converter 
@Default
@Stateless
@LocalBean
public class AdministradorLogic implements IArtistaLogic{
    
    //Es una interfaz, maneja las operaciones de persistencia en los objetos
    @PersistenceContext(unitName = "EstampartePU")
    protected EntityManager em;
    

    @Override
    public ArtistaDTO crearArtista(ArtistaDTO artista) {
        ArtistaEntity entidad = ArtistaConverter.convertirDeDTOAEntidad(artista);
        em.persist(entidad);
        return ArtistaConverter.convertirDeEntidadADTO(entidad);
    }

    @Override
    public List<ArtistaDTO> obtenerArtistas() {
        Query q = em.createQuery("select u from ArtistaEntity u");
        return ArtistaConverter.convertirDeListaEntidadesAListaDTO(q.getResultList());
    }

    @Override
    public ArtistaPageDTO obtenerArtistas(Integer pagina, Integer datosMaximos) {
        Query cuenta = em.createQuery("select count(u) from ArtistaEntity u");
        Long cuentaReg = 0L;
        cuentaReg = Long.parseLong(cuenta.getSingleResult().toString());
        Query q = em.createQuery("select u from ArtistaEntity u");
        if(pagina !=null && datosMaximos!=null){
            q.setFirstResult((pagina-1)*datosMaximos);
            q.setMaxResults(datosMaximos);
        }
        ArtistaPageDTO respuesta = new ArtistaPageDTO();
        respuesta.setTotalArtistas(cuentaReg);
        respuesta.setArtistas(ArtistaConverter.convertirDeListaEntidadesAListaDTO(q.getResultList()));
        return respuesta;
    }

    @Override
    public ArtistaDTO darArtista(Long id) {
        ArtistaEntity entidad = em.find(ArtistaEntity.class, id);
        return ArtistaConverter.convertirDeEntidadADTO(entidad);
    }

    @Override
    public ArtistaDTO actualizarArtista(ArtistaDTO artista) {
        ArtistaEntity entidad = em.merge(ArtistaConverter.convertirDeDTOAEntidad(artista));
        return ArtistaConverter.convertirDeEntidadADTO(entidad);
    }

    @Override
    public void eliminarArtistas() {
        Query q = em.createQuery("delete from ArtistaEntity u");
        q.executeUpdate();
    }

    @Override
    public ArtistaDTO eliminarArtista(Long id) {
        ArtistaEntity entidad = em.find(ArtistaEntity.class, id);
        em.remove(entidad);
        return ArtistaConverter.convertirDeEntidadADTO(entidad);
    }

    @Override
    public EstampaDTO crearEstampaDeArtista(Long idArtista, EstampaDTO estampa, IEstampaLogic servicioLogicaEstampa) {
        ArtistaEntity entidad = em.find(ArtistaEntity.class, idArtista);
        EstampaDTO respuesta = null;
        if(entidad != null){
            respuesta = servicioLogicaEstampa.crearEstampa(estampa);
        }
        return respuesta;
    }


    @Override
    public EstampaDTO eliminarEstampaDeArtista(Long idArtista, Long idEstampa, IEstampaLogic servicioLogicaEstampa) {
        ArtistaEntity entidad = em.find(ArtistaEntity.class, idArtista);
        EstampaDTO respuesta = null;
        if(entidad != null){
            respuesta = servicioLogicaEstampa.eliminarEstampa(idEstampa);
        }
        return respuesta;
    }

    @Override
    public EstampaPageDTO obtenerEstampasDeArtista(Long idArtista, Integer pagina, Integer datosMaximos, IEstampaLogic servicioLogicaEstampa) {
        ArtistaEntity entidad = em.find(ArtistaEntity.class, idArtista);
        EstampaPageDTO respuesta = null;
        if(entidad != null){
            respuesta = servicioLogicaEstampa.obtenerEstampasDeArtista(idArtista, pagina, datosMaximos);
        }
        return respuesta;
    }

    @Override
    public EstampaDTO actualizarEstampaDeArtista(Long idArtista, EstampaDTO estampa, IEstampaLogic servicioLogicaEstampa) {
        ArtistaEntity entidad = em.find(ArtistaEntity.class, idArtista);
        EstampaDTO respuesta = null;
        if(entidad != null){
            respuesta = servicioLogicaEstampa.actualizarEstampa(estampa);
        }
        return respuesta;
    }

}

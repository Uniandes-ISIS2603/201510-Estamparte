/*
 * Manejo de la BD de los artistas
 */
package co.edu.uniandes.estamparte.administrador.logic.ejb;

import co.edu.uniandes.estamparte.administrador.logic.api.IAdministradorLogic;
import co.edu.uniandes.estamparte.administrador.logic.converter.AdministradorConverter;
import co.edu.uniandes.estamparte.administrador.logic.dto.AdministradorDTO;
import co.edu.uniandes.estamparte.administrador.logic.dto.AdministradorPageDTO;
import co.edu.uniandes.estamparte.administrador.logic.entity.AdministradorEntity;
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
public class AdministradorLogic implements IAdministradorLogic{
    
    //Es una interfaz, maneja las operaciones de persistencia en los objetos
    @PersistenceContext(unitName = "EstampartePU")
    protected EntityManager em;

    public AdministradorDTO crearAdministrador(AdministradorDTO admin) {
        AdministradorEntity entidad = AdministradorConverter.convertirDeDTOAEntidad(admin);
        em.persist(entidad);
        return AdministradorConverter.convertirDeEntidadADTO(entidad);
    }
    
    
    public List<AdministradorDTO> obtenerAdministradores() {
        Query q = em.createQuery("select u from AdministradorEntity u");
        return AdministradorConverter.convertirDeListaEntidadesAListaDTO(q.getResultList());
    }

    public AdministradorPageDTO obtenerAdministradores(Integer pagina, Integer datosMaximos) {
        Query cuenta = em.createQuery("select count(u) from AdministradorEntity u");
        Long cuentaReg = 0L;
        cuentaReg = Long.parseLong(cuenta.getSingleResult().toString());
        Query q = em.createQuery("select u from AdministradorEntity u");
        if(pagina !=null && datosMaximos!=null){
            q.setFirstResult((pagina-1)*datosMaximos);
            q.setMaxResults(datosMaximos);
        }
        AdministradorPageDTO respuesta = new AdministradorPageDTO();
        respuesta.setTotalAdministradores(cuentaReg);
        respuesta.setAdministradores(AdministradorConverter.convertirDeListaEntidadesAListaDTO(q.getResultList()));
        return respuesta;
    }

    public AdministradorDTO getAdministrador(Long id) {
        AdministradorEntity entidad = em.find(AdministradorEntity.class, id);
        return AdministradorConverter.convertirDeEntidadADTO(entidad);
    }

    public AdministradorDTO actualizarAdministrador(AdministradorDTO admin) {
        AdministradorEntity entidad = em.merge(AdministradorConverter.convertirDeDTOAEntidad(admin));
        return AdministradorConverter.convertirDeEntidadADTO(entidad);
    }

    public void eliminarAdministradores() {
        Query q = em.createQuery("delete from AdministradorEntity u");
        q.executeUpdate();
    }

    public AdministradorDTO eliminarAdministrador(Long id) {
        AdministradorEntity entidad = em.find(AdministradorEntity.class, id);
        em.remove(entidad);
        return AdministradorConverter.convertirDeEntidadADTO(entidad);
    }
    

    
}

/*
 * Conversor de datos de estampas
 */
package co.edu.uniandes.estamparte.estampa.logic.converter;

//Convierte los objetos de clases de java a DTO (objeto que transfiere archivos a persistencia)

import co.edu.uniandes.estamparte.artista.logic.entity.ArtistaEntity;
import co.edu.uniandes.estamparte.camiseta.logic.entity.CamisetaEntity;
import co.edu.uniandes.estamparte.estampa.logic.dto.EstampaDTO;
import co.edu.uniandes.estamparte.estampa.logic.entity.EstampaEntity;
import java.util.ArrayList;
import java.util.List;

public class EstampaConverter {
    public static EstampaDTO convertirDeEntidadADTO (EstampaEntity entidad) {
        if (entidad != null) {
            EstampaDTO dto = new EstampaDTO();
            //Al objeto DTO se le asignan los atributos del objeto entity
            dto.setId(entidad.getId());
            dto.setIdArtista(entidad.getDuenho().getId());
            dto.setUsuarioArtista(entidad.getDuenho().getUsuario());
            dto.setNombre(entidad.getNombre());
            dto.setImagen(entidad.getImagen());
            dto.setDescripcion(entidad.getDescripcion());
            dto.setSiGusta(entidad.getSiGusta());
            dto.setNoGusta(entidad.getNoGusta());
            dto.setTema(entidad.getTema());
            dto.setAltura(entidad.getAltura());
            dto.setAncho(entidad.getAncho());
            dto.setPrecio(entidad.getPrecio());
            return dto;
        } else {
            return null;
        }
    }

    public static EstampaEntity convertirDeDTOAEntidad (EstampaDTO dto) {
        if (dto != null) {
            EstampaEntity entidad = new EstampaEntity();
            ArtistaEntity artistaDuenho = new ArtistaEntity();
            artistaDuenho.setId(dto.getIdArtista());
            artistaDuenho.setUsuario(dto.getUsuarioArtista());
            List<CamisetaEntity> camisetas = new ArrayList();
            //Al objeto entity se le asignan los atributos del objeto dto
            entidad.setId(dto.getId());
            entidad.setDuenho(artistaDuenho);
            entidad.setNombre(dto.getNombre());
            entidad.setImagen(dto.getImagen());
            entidad.setDescripcion(dto.getDescripcion());
            entidad.setSiGusta(dto.getSiGusta());
            entidad.setNoGusta(dto.getNoGusta());
            entidad.setTema(dto.getTema());
            entidad.setAltura(dto.getAltura());
            entidad.setAncho(dto.getAncho());
            entidad.setPrecio(dto.getPrecio());
            entidad.setCamisetas(camisetas);
            return entidad;
        } else {
            return null;
        }
    }

    public static List<EstampaDTO> convertirDeListaEntidadesAListaDTO (List<EstampaEntity> listaEntities) {
        List<EstampaDTO> listaDTO = new ArrayList();
        for (EstampaEntity entidad : listaEntities) {
            listaDTO.add(convertirDeEntidadADTO(entidad));
        }
        return listaDTO;
    }

    public static List<EstampaEntity> convertirDeListaDTOAListaEntidades (List<EstampaDTO> listaDTO) {
        List<EstampaEntity> listaEntities = new ArrayList();
        for (EstampaDTO dto : listaDTO) {
            listaEntities.add(convertirDeDTOAEntidad(dto));
        }
        return listaEntities;
    }
     
}


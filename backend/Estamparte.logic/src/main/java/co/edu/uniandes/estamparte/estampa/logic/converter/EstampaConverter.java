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
            dto.cambiarId(entidad.darId());
            dto.cambiarIdArtista(entidad.darDuenho().getId());
            dto.cambiarUsuarioArtista(entidad.darDuenho().getUsuario());
            dto.cambiarNombre(entidad.darNombre());
            dto.cambiarImagen(entidad.darImagen());
            dto.cambiarDescripcion(entidad.darDescripcion());
            dto.cambiarSiGusta(entidad.darSiGusta());
            dto.cambiarNoGusta(entidad.darNoGusta());
            dto.cambiarTema(entidad.darTema());
            dto.cambiarAltura(entidad.darAltura());
            dto.cambiarAncho(entidad.darAncho());
            dto.cambiarPrecio(entidad.darPrecio());
            return dto;
        } else {
            return null;
        }
    }

    public static EstampaEntity convertirDeDTOAEntidad (EstampaDTO dto) {
        if (dto != null) {
            EstampaEntity entidad = new EstampaEntity();
            ArtistaEntity artistaDuenho = new ArtistaEntity();
            artistaDuenho.setId(dto.darIdArtista());
            artistaDuenho.setUsuario(dto.darUsuarioArtista());
            List<CamisetaEntity> camisetas = new ArrayList();
            //Al objeto entity se le asignan los atributos del objeto dto
            entidad.cambiarId(dto.darId());
            entidad.cambiarDuenho(artistaDuenho);
            entidad.cambiarNombre(dto.darNombre());
            entidad.cambiarImagen(dto.darImagen());
            entidad.cambiarDescripcion(dto.darDescripcion());
            entidad.cambiarSiGusta(dto.darSiGusta());
            entidad.cambiarNoGusta(dto.darNoGusta());
            entidad.cambiarTema(dto.darTema());
            entidad.cambiarAltura(dto.darAltura());
            entidad.cambiarAncho(dto.darAncho());
            entidad.cambiarPrecio(dto.darPrecio());
            entidad.cambiarCamisetas(camisetas);
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


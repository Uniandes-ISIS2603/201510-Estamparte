/*
 * Conversor de datos de estampas
 */
package co.edu.uniandes.estamparte.artista.logic.converter;

//Convierte los objetos de clases de java a DTO (objeto que transfiere archivos a persistencia)

import co.edu.uniandes.estamparte.artista.logic.dto.ArtistaDTO;
import co.edu.uniandes.estamparte.artista.logic.entity.ArtistaEntity;
import co.edu.uniandes.estamparte.estampa.logic.entity.EstampaEntity;
import java.util.ArrayList;
import java.util.List;

public class ArtistaConverter {
    
    public static ArtistaDTO convertirDeEntidadADTO (ArtistaEntity entidad) {
        if (entidad != null) {
            ArtistaDTO dto = new ArtistaDTO();
            dto.setId(entidad.getId());
            dto.setUsuario(entidad.getUsuario());
            dto.setContrasenha(entidad.getContrasenha());
            dto.setNombre(entidad.getNombre());
            dto.setCedula(entidad.getCedula());
            dto.setCorreo(entidad.getCorreo());
            dto.setImagenPerfil(entidad.getImagenPerfil());
            dto.setDescripcion(entidad.getDescripcion());
            return dto;
        } else {
            return null;
        }
    }

    public static ArtistaEntity convertirDeDTOAEntidad (ArtistaDTO dto) {
        if (dto != null) {
            ArtistaEntity entidad = new ArtistaEntity();
            List<EstampaEntity> estampas = new ArrayList();
            //Al objeto entity se le asignan los atributos del objeto dto
            entidad.setId(dto.getId());
            entidad.setUsuario(dto.getUsuario());
            entidad.setContrasenha(dto.getContrasenha());
            entidad.setNombre(dto.getNombre());
            entidad.setCedula(dto.getCedula());
            entidad.setCorreo(dto.getCorreo());
            entidad.setImagenPerfil(dto.getImagenPerfil());
            entidad.setDescripcion(dto.getDescripcion());
            entidad.setEstampas(estampas);
            return entidad;
        } else {
            return null;
        }
    }

    public static List<ArtistaDTO> convertirDeListaEntidadesAListaDTO (List<ArtistaEntity> listaEntities) {
        List<ArtistaDTO> listaDTO = new ArrayList<ArtistaDTO>();
        for (ArtistaEntity entity : listaEntities) {
            listaDTO.add(convertirDeEntidadADTO(entity));
        }
        return listaDTO;
    }

    public static List<ArtistaEntity> convertirDeListaDTOAListaEntidades (ArrayList<ArtistaDTO> listaDTO) {
        List<ArtistaEntity> listaEntities = new ArrayList<ArtistaEntity>();
        for (ArtistaDTO dto : listaDTO) {
            listaEntities.add(convertirDeDTOAEntidad(dto));
        }
        return listaEntities;
    }
    
}

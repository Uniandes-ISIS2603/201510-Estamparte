/*
 * Conversor de datos de estampas
 */
package co.edu.uniandes.estamparte.artista.logic.converter;

//Convierte los objetos de clases de java a DTO (objeto que transfiere archivos a persistencia)

import co.edu.uniandes.estamparte.artista.logic.dto.ArtistaDTO;
import co.edu.uniandes.estamparte.artista.logic.entity.ArtistaEntity;
import java.util.ArrayList;
import java.util.List;

public class ArtistaConverter {
    
    public static ArtistaDTO convertirDeEntidadADTO (ArtistaEntity entity) {
        if (entity != null) {
            ArtistaDTO dto = new ArtistaDTO();
            //Al objeto DTO se le asignan los atributos del objeto entity
            return dto;
        } else {
            return null;
        }
    }

    public static ArtistaEntity convertirDeDTOAEntidad (ArtistaDTO dto) {
        if (dto != null) {
            ArtistaEntity entity = new ArtistaEntity();
            //Al objeto entity se le asignan los atributos del objeto dto
            return entity;
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

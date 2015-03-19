/*
 * Conversor de datos de estampas
 */
package co.edu.uniandes.estamparte.comprador.logic.converter;

//Convierte los objetos de clases de java a DTO (objeto que transfiere archivos a persistencia)

import co.edu.uniandes.estamparte.comprador.logic.dto.CompradorDTO;
import co.edu.uniandes.estamparte.comprador.logic.entity.CompradorEntity;
import java.util.ArrayList;
import java.util.List;

public class CompradorConverter {
    public static CompradorDTO convertirDeEntidadADTO (CompradorEntity entity) {
        if (entity != null) {
            CompradorDTO dto = new CompradorDTO();
            //Al objeto DTO se le asignan los atributos del objeto entity
            return dto;
        } else {
            return null;
        }
    }

    public static CompradorEntity convertirDeDTOAEntidad (CompradorDTO dto) {
        if (dto != null) {
            CompradorEntity entity = new CompradorEntity();
            //Al objeto entity se le asignan los atributos del objeto dto
            return entity;
        } else {
            return null;
        }
    }

    public static List<CompradorDTO> convertirDeListaEntidadesAListaDTO (List<CompradorEntity> listaEntities) {
        List<CompradorDTO> listaDTO = new ArrayList<CompradorDTO>();
        for (CompradorEntity entity : listaEntities) {
            listaDTO.add(convertirDeEntidadADTO(entity));
        }
        return listaDTO;
    }

    public static List<CompradorEntity> convertirDeListaDTOAListaEntidades (ArrayList<CompradorDTO> listaDTO) {
        List<CompradorEntity> listaEntities = new ArrayList<CompradorEntity>();
        for (CompradorDTO dto : listaDTO) {
            listaEntities.add(convertirDeDTOAEntidad(dto));
        }
        return listaEntities;
    }
     
}


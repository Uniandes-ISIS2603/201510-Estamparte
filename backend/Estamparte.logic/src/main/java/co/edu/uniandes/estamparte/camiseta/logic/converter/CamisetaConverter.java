/*
 * Conversor de datos de estampas
 */
package co.edu.uniandes.estamparte.camiseta.logic.converter;

//Convierte los objetos de clases de java a DTO (objeto que transfiere archivos a persistencia)

import co.edu.uniandes.estamparte.camiseta.logic.dto.CamisetaDTO;
import co.edu.uniandes.estamparte.camiseta.logic.entity.CamisetaEntity;
import java.util.ArrayList;
import java.util.List;

public class CamisetaConverter {
    public static CamisetaDTO convertirDeEntidadADTO (CamisetaEntity entity) {
        if (entity != null) {
            CamisetaDTO dto = new CamisetaDTO();
            //Al objeto DTO se le asignan los atributos del objeto entity
            return dto;
        } else {
            return null;
        }
    }

    public static CamisetaEntity convertirDeDTOAEntidad (CamisetaDTO dto) {
        if (dto != null) {
            CamisetaEntity entity = new CamisetaEntity();
            //Al objeto entity se le asignan los atributos del objeto dto
            return entity;
        } else {
            return null;
        }
    }

    public static List<CamisetaDTO> convertirDeListaEntidadesAListaDTO (List<CamisetaEntity> listaEntities) {
        List<CamisetaDTO> listaDTO = new ArrayList<CamisetaDTO>();
        for (CamisetaEntity entity : listaEntities) {
            listaDTO.add(convertirDeEntidadADTO(entity));
        }
        return listaDTO;
    }

    public static List<CamisetaEntity> convertirDeListaDTOAListaEntidades (ArrayList<CamisetaDTO> listaDTO) {
        List<CamisetaEntity> listaEntities = new ArrayList<CamisetaEntity>();
        for (CamisetaDTO dto : listaDTO) {
            listaEntities.add(convertirDeDTOAEntidad(dto));
        }
        return listaEntities;
    }
     
}

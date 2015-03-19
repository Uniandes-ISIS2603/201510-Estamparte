/*
 * Conversor de datos de estampas
 */
package co.edu.uniandes.estamparte.estampa.logic.converter;

//Convierte los objetos de clases de java a DTO (objeto que transfiere archivos a persistencia)

import co.edu.uniandes.estamparte.estampa.logic.dto.EstampaDTO;
import co.edu.uniandes.estamparte.estampa.logic.entity.EstampaEntity;
import java.util.ArrayList;
import java.util.List;

public class EstampaConverter {
    public static EstampaDTO convertirDeEntidadADTO (EstampaEntity entity) {
        if (entity != null) {
            EstampaDTO dto = new EstampaDTO();
            //Al objeto DTO se le asignan los atributos del objeto entity
            return dto;
        } else {
            return null;
        }
    }

    public static EstampaEntity convertirDeDTOAEntidad (EstampaDTO dto) {
        if (dto != null) {
            EstampaEntity entity = new EstampaEntity();
            //Al objeto entity se le asignan los atributos del objeto dto
            return entity;
        } else {
            return null;
        }
    }

    public static List<EstampaDTO> convertirDeListaEntidadesAListaDTO (List<EstampaEntity> listaEntities) {
        List<EstampaDTO> listaDTO = new ArrayList<EstampaDTO>();
        for (EstampaEntity entity : listaEntities) {
            listaDTO.add(convertirDeEntidadADTO(entity));
        }
        return listaDTO;
    }

    public static List<EstampaEntity> convertirDeListaDTOAListaEntidades (List<EstampaDTO> listaDTO) {
        List<EstampaEntity> listaEntities = new ArrayList<EstampaEntity>();
        for (EstampaDTO dto : listaDTO) {
            listaEntities.add(convertirDeDTOAEntidad(dto));
        }
        return listaEntities;
    }
     
}


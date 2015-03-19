/*
 * Conversor de datos de estampas
 */
package co.edu.uniandes.estamparte.formaPago.logic.converter;

//Convierte los objetos de clases de java a DTO (objeto que transfiere archivos a persistencia)

import co.edu.uniandes.estamparte.formaPago.logic.dto.FormaPagoDTO;
import co.edu.uniandes.estamparte.formaPago.logic.entity.FormaPagoEntity;
import java.util.ArrayList;
import java.util.List;

public class FormaPagoConverter {
    public static FormaPagoDTO convertirDeEntidadADTO (FormaPagoEntity entity) {
        if (entity != null) {
            FormaPagoDTO dto = new FormaPagoDTO();
            //Al objeto DTO se le asignan los atributos del objeto entity
            return dto;
        } else {
            return null;
        }
    }

    public static FormaPagoEntity convertirDeDTOAEntidad (FormaPagoDTO dto) {
        if (dto != null) {
            FormaPagoEntity entity = new FormaPagoEntity();
            //Al objeto entity se le asignan los atributos del objeto dto
            return entity;
        } else {
            return null;
        }
    }

    public static List<FormaPagoDTO> convertirDeListaEntidadesAListaDTO (List<FormaPagoEntity> listaEntities) {
        List<FormaPagoDTO> listaDTO = new ArrayList<FormaPagoDTO>();
        for (FormaPagoEntity entity : listaEntities) {
            listaDTO.add(convertirDeEntidadADTO(entity));
        }
        return listaDTO;
    }

    public static List<FormaPagoEntity> convertirDeListaDTOAListaEntidades (ArrayList<FormaPagoDTO> listaDTO) {
        List<FormaPagoEntity> listaEntities = new ArrayList<FormaPagoEntity>();
        for (FormaPagoDTO dto : listaDTO) {
            listaEntities.add(convertirDeDTOAEntidad(dto));
        }
        return listaEntities;
    }
     
}


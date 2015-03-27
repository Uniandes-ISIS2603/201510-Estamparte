/*
 * Conversor de datos de estampas
 */
package co.edu.uniandes.estamparte.formaPago.logic.converter;

//Convierte los objetos de clases de java a DTO (objeto que transfiere archivos a persistencia)

import co.edu.uniandes.estamparte.comprador.logic.converter.CompradorConverter;
import co.edu.uniandes.estamparte.formaPago.logic.dto.FormaPagoDTO;
import co.edu.uniandes.estamparte.formaPago.logic.entity.FormaPagoEntity;
import java.util.ArrayList;
import java.util.List;

public class FormaPagoConverter {
    public static FormaPagoDTO convertirDeEntidadADTO (FormaPagoEntity entity) {
        if (entity != null) {
            FormaPagoDTO dto = new FormaPagoDTO();
            //Al objeto DTO se le asignan los atributos del objeto entity
            dto.setCodSeguridad(entity.getCodSeguridad());
            dto.setDireccion(entity.getDireccion());
            dto.setFechaVencimiento(entity.getFechaVencimiento());
            dto.setComprador(CompradorConverter.entity2PersistenceDTO(entity.getComprador()));
            dto.setNombre(entity.getNombre());
            dto.setNumTarjeta(entity.getNumTarjeta());
            return dto;
        } else {
            return null;
        }
    }

    public static FormaPagoEntity convertirDeDTOAEntidad (FormaPagoDTO dto) {
        if (dto != null) {
            FormaPagoEntity entity = new FormaPagoEntity();
            //Al objeto entity se le asignan los atributos del objeto dto
            entity.setCodSeguridad(dto.getCodSeguridad());
            entity.setDireccion(dto.getDireccion());
            entity.setFechaVencimiento(dto.getFechaVencimiento());
            entity.setComprador(CompradorConverter.persistenceDTO2Entity(dto.getComprador()));
            entity.setNombre(dto.getNombre());
            entity.setNumTarjeta(dto.getNumTarjeta());
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

    public static List<FormaPagoEntity> convertirDeListaDTOAListaEntidades (List<FormaPagoDTO> listaDTO) {
        List<FormaPagoEntity> listaEntities = new ArrayList<FormaPagoEntity>();
        for (FormaPagoDTO dto : listaDTO) {
            listaEntities.add(convertirDeDTOAEntidad(dto));
        }
        return listaEntities;
    }
}


/*
 * Conversor de datos de estampas
 */
package co.edu.uniandes.estamparte.fromaPago.logic.converter;

import co.edu.uniandes.estamparte.fromaPago.logic.dto.FormaPagoDTO;
import co.edu.uniandes.estamparte.fromaPago.logic.entity.FormaPagoEntity;
import java.util.ArrayList;



public class FormaPagoConverter {
    
     public static FormaPagoDTO entity2PersistenceDTO(FormaPagoEntity entity) {
        if (entity != null) {
            FormaPagoDTO dto = new FormaPagoDTO();
            dto.setTipo(entity.getTipo());
            dto.setNumeroTarjeta(entity.getNumeroTarjeta());
            dto.setFechaVencimiento(entity.getFechaVencimiento());
            dto.setCodigoSeguridad(entity.getCodigoSeguridad());
            dto.setDireccionCorrespondencia(entity.getDireccionCorrespondencia());
            
            return dto;
        } else {
            return null;
        }
    }

    public static FormaPagoEntity persistenceDTO2Entity(FormaPagoDTO dto) {
        if (dto != null) {
            FormaPagoEntity entity = new FormaPagoEntity();
            entity.setTipo(dto.getTipo());
            entity.setNumeroTarjeta(dto.getNumeroTarjeta());
            entity.setFechaVencimiento(dto.getFechaVencimiento());
            entity.setCodigoSeguridad(dto.getCodigoSeguridad());
            entity.setDireccionCorrespondencia(dto.getDireccionCorrespondencia());

            return entity;
        } else {
            return null;
        }
    }
    
    public static ArrayList<FormaPagoDTO> entity2PersistenceDTOList(ArrayList<FormaPagoEntity> entities) {
        ArrayList<FormaPagoDTO> dtos = new ArrayList<FormaPagoDTO>();
        for (FormaPagoEntity entity : entities) {
            dtos.add(entity2PersistenceDTO(entity));
        }
        return dtos;
    }
    
     public static ArrayList<FormaPagoEntity> persistenceDTO2EntityList(ArrayList<FormaPagoDTO> dtos) {
        ArrayList<FormaPagoEntity> entities = new ArrayList<FormaPagoEntity>();
        for (FormaPagoDTO dto : dtos) {
            entities.add(persistenceDTO2Entity(dto));
        }
        return entities;
    }
}

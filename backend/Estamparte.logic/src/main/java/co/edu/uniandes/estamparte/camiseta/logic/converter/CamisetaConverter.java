/*
 * Conversor de datos de estampas
 */
package co.edu.uniandes.estamparte.camiseta.logic.converter;


//Convierte los objetos de clases de java a DTO (objeto que transfiere archivos a persistencia)

import co.edu.uniandes.estamparte.camiseta.logic.dto.CamisetaDTO;

import co.edu.uniandes.estamparte.camiseta.logic.entity.CamisetaEntity;
import co.edu.uniandes.estamparte.estampa.logic.converter.EstampaConverter;
import java.util.ArrayList;
import java.util.List;

public class CamisetaConverter {

    
        public static CamisetaDTO entity2PersistenceDTO(CamisetaEntity entity) {
        if (entity != null) {
            CamisetaDTO dto = new CamisetaDTO();
            dto.asignarId(entity.darId());
            dto.asignarNombre(entity.darNombre());
            dto.asignarColor(entity.darColor());
            dto.asignarCosto(entity.darCosto());
            dto.asignarEstampas(EstampaConverter.convertirDeListaEntidadesAListaDTO(entity.darEstampas()));
            dto.asignarEstilo(entity.darEstilo());
            dto.asignarTalla(entity.darTalla());

            return dto;
        } else {
            return null;
        }
    }


    public static CamisetaEntity persistenceDTO2Entity(CamisetaDTO dto) {
        if (dto != null) {
            CamisetaEntity entity = new CamisetaEntity();
            entity.asignarId(dto.darId());
            entity.asignarNombre(dto.darNombre());
            entity.asignarColor(dto.darColor());
            entity.asignarCosto(dto.darCosto());
            entity.asignarEstampas(EstampaConverter.convertirDeListaDTOAListaEntidades(dto.darEstampas()));
            entity.asignarEstilo(dto.darEstilo());
            entity.asignarTalla(dto.darTalla());

            return entity;
        } else {
            return null;
        }
    }


    public static List<CamisetaDTO> entity2PersistenceDTOList(List<CamisetaEntity> entities) {
        List<CamisetaDTO> dtos = new ArrayList<CamisetaDTO>();
        for (CamisetaEntity entity : entities) {
            dtos.add(entity2PersistenceDTO(entity));
        }
        return dtos;
    }

    public static List<CamisetaEntity> persistenceDTO2EntityList(List<CamisetaDTO> dtos) {
        List<CamisetaEntity> entities = new ArrayList<CamisetaEntity>();
        for (CamisetaDTO dto : dtos) {
            entities.add(persistenceDTO2Entity(dto));
        }
        return entities;
    }
    
}

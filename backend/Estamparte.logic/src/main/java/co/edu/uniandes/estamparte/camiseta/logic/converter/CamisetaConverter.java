/*
 * Conversor de datos de estampas
 */
package co.edu.uniandes.estamparte.camiseta.logic.converter;


//Convierte los objetos de clases de java a DTO (objeto que transfiere archivos a persistencia)

import co.edu.uniandes.estamparte.camiseta.logic.dto.CamisetaDTO;

import co.edu.uniandes.estamparte.camiseta.logic.entity.CamisetaEntity;
import co.edu.uniandes.estamparte.carrito.logic.converter.CarritoConverter;
import co.edu.uniandes.estamparte.estampa.logic.converter.EstampaConverter;
import java.util.ArrayList;
import java.util.List;

public class CamisetaConverter{

    
        public static CamisetaDTO entity2PersistenceDTO(CamisetaEntity entity) {
        if (entity != null) {
            CamisetaDTO dto = new CamisetaDTO();
            dto.setId(entity.getId());
            dto.setNombre(entity.getNombre());
            dto.setColor(entity.getColor());
            dto.setCosto(entity.getCosto());
            dto.setEstampas(EstampaConverter.convertirDeListaEntidadesAListaDTO(entity.getEstampas()));
            dto.setEstilo(entity.getEstilo());
            dto.setTalla(entity.getTalla());
            dto.setCarroDuenio(CarritoConverter.convertirDeEntidadADTO(entity.getCarroDuenio()));
            return dto;
        } else {
            return null;
        }
    }


    public static CamisetaEntity persistenceDTO2Entity(CamisetaDTO dto) {
        if (dto != null) {
            CamisetaEntity entity = new CamisetaEntity();
            entity.setId(dto.getId());
            entity.setNombre(dto.getNombre());
            entity.setColor(dto.getColor());
            entity.setCosto(dto.getCosto());
            entity.setEstampas(EstampaConverter.convertirDeListaDTOAListaEntidades(dto.getEstampas()));
            entity.setEstilo(dto.getEstilo());
            entity.setTalla(dto.getTalla());
            entity.setCarroDuenio(CarritoConverter.convertirDeDTOAEntidad(dto.getCarroDuenio()));
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

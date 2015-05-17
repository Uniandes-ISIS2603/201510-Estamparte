/*
 * Conversor de datos de estampas
 */
package co.edu.uniandes.estamparte.camiseta.logic.converter;


//Convierte los objetos de clases de java a DTO (objeto que transfiere archivos a persistencia)

import co.edu.uniandes.estamparte.camiseta.logic.dto.CamisetaDTO;
import co.edu.uniandes.estamparte.camiseta.logic.entity.CamisetaEntity;
import co.edu.uniandes.estamparte.carrito.logic.converter.CarritoConverter;
import co.edu.uniandes.estamparte.carrito.logic.dto.CarritoDTO;
import co.edu.uniandes.estamparte.estampa.logic.converter.EstampaConverter;
import co.edu.uniandes.estamparte.estampa.logic.dto.EstampaDTO;
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
            List<EstampaDTO> estampas = EstampaConverter.convertirDeListaEntidadesAListaDTO(entity.getEstampas());
            long[] arrEst = new long[estampas.size()];
            for (int i = 0; i < estampas.size(); i++) 
                arrEst[i]= estampas.get(i).getId();
           
            dto.setEstampas(arrEst);
            dto.setEstilo(entity.getEstilo());
            dto.setTalla(entity.getTalla());
            dto.setCantidad(entity.getCantidad());
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
            List<EstampaDTO> estampas = new ArrayList<EstampaDTO>();
            long[] ids= dto.getEstampas();
            if(ids!=null){
            for(long id: ids)
            {
                EstampaDTO ed = new EstampaDTO();
                ed.setId(id);
                estampas.add(ed);
            }
            }
            entity.setEstampas(EstampaConverter.convertirDeListaDTOAListaEntidades(estampas));
            entity.setEstilo(dto.getEstilo());
            entity.setTalla(dto.getTalla());
            entity.setCantidad(dto.getCantidad());
 

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

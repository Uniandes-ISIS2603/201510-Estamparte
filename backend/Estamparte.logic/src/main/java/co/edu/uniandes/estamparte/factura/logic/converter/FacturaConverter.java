/*
 * Conversor de datos de estampas
 */
package co.edu.uniandes.estamparte.factura.logic.converter;

import co.edu.uniandes.estamparte.estampa.logic.converter.*;
import co.edu.uniandes.estamparte.factura.logic.dto.FacturaDTO;
import co.edu.uniandes.estamparte.factura.logic.entity.FacturaEntity;
import java.util.ArrayList;
import java.util.List;

public class FacturaConverter 
{
    
    public static FacturaDTO entity2PersistenceDTO(FacturaEntity entity) {
        if (entity != null) {
            FacturaDTO dto = new FacturaDTO();
            dto.setComprador(entity.getComprador());
            dto.setFormaPago(entity.getFormaPago());
            dto.setFechaCompra(entity.getFechaCompra());
            dto.setIdFactura(entity.getIdFactura());
            dto.setArticulos(entity.getArticulos());
            
            return dto;
        } else {
            return null;
        }
    }

    public static FacturaEntity persistenceDTO2Entity(FacturaDTO dto) {
        if (dto != null) {
            FacturaEntity entity = new FacturaEntity();
            entity.setComprador(dto.getComprador());
            entity.setFormaPago(dto.getFormaPago());
            entity.setFechaCompra(dto.getFechaCompra());
            entity.setIdFactura(dto.getIdFactura());
            entity.setArticulos(dto.getArticulos());

            return entity;
        } else {
            return null;
        }
    }
    
    public static ArrayList<FacturaDTO> entity2PersistenceDTOList(ArrayList<FacturaEntity> entities) {
        ArrayList<FacturaDTO> dtos = new ArrayList<FacturaDTO>();
        for (FacturaEntity entity : entities) {
            dtos.add(entity2PersistenceDTO(entity));
        }
        return dtos;
    }
    
     public static List<FacturaEntity> persistenceDTO2EntityList(List<FacturaDTO> dtos) {
        ArrayList<FacturaEntity> entities = new ArrayList<FacturaEntity>();
        for (FacturaDTO dto : dtos) {
            entities.add(persistenceDTO2Entity(dto));
        }
        return entities;
    }
    
}

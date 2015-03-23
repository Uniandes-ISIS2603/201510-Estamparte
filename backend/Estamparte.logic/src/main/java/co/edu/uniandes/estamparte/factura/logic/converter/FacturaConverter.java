/*
 * Conversor de datos de estampas
 */
package co.edu.uniandes.estamparte.factura.logic.converter;

import co.edu.uniandes.estamparte.estampa.logic.converter.*;
import co.edu.uniandes.estamparte.factura.logic.dto.FacturaDTO;
import co.edu.uniandes.estamparte.factura.logic.entity.FacturaEntity;
import co.edu.uniandes.estamparte.camiseta.logic.converter.CamisetaConverter;
import co.edu.uniandes.estamparte.carrito.logic.converter.CarritoConverter;
import co.edu.uniandes.estamparte.formaPago.logic.converter.FormaPagoConverter;
import co.edu.uniandes.estamparte.comprador.logic.converter.CompradorConverter;



import java.util.ArrayList;
import java.util.List;

public class FacturaConverter 
{
    
    public static FacturaDTO entity2PersistenceDTO(FacturaEntity entity) {
        if (entity != null) {
            FacturaDTO dto = new FacturaDTO();
            dto.setComprador(CompradorConverter.entity2PersistenceDTO(entity.getComprador()));
            dto.setFormaPago(FormaPagoConverter.convertirDeEntidadADTO(entity.getFormaPago()));
            dto.setFechaCompra(entity.getFechaCompra());
            dto.setIdFactura(entity.getIdFactura());
            dto.setCarrito(CarritoConverter.convertirDeEntidadADTO(entity.getCarrito()));
            
            return dto;
        } else {
            return null;
        }
    }

    public static FacturaEntity persistenceDTO2Entity(FacturaDTO dto) {
        if (dto != null) {
            FacturaEntity entity = new FacturaEntity();
            entity.setComprador(CompradorConverter.persistenceDTO2Entity(dto.getComprador()));
            entity.setFormaPago(FormaPagoConverter.convertirDeDTOAEntidad(dto.getFormaPago()));
            entity.setFechaCompra(dto.getFechaCompra());
            entity.setIdFactura(dto.getIdFactura());
            entity.setCarrito(CarritoConverter.convertirDeDTOAEntidad(dto.getCarrito()));

            return entity;
        } else {
            return null;
        }
    }
    
    public static List<FacturaDTO> entity2PersistenceDTOList(List<FacturaEntity> entities) {
        List<FacturaDTO> dtos = new ArrayList<FacturaDTO>();
        for (FacturaEntity entity : entities) {
            dtos.add(entity2PersistenceDTO(entity));
        }
        return dtos;
    }
    
     public static List<FacturaEntity> persistenceDTO2EntityList(List<FacturaDTO> dtos) {
        List<FacturaEntity> entities = new ArrayList<FacturaEntity>();
        for (FacturaDTO dto : dtos) {
            entities.add(persistenceDTO2Entity(dto));
        }
        return entities;
    }
    
}

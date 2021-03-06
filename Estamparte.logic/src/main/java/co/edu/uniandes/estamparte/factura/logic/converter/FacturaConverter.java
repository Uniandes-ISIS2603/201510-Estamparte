/*
 * Conversor de datos de estampas
 */
package co.edu.uniandes.estamparte.factura.logic.converter;

import co.edu.uniandes.estamparte.factura.logic.dto.FacturaDTO;
import co.edu.uniandes.estamparte.factura.logic.entity.FacturaEntity;
import co.edu.uniandes.estamparte.carrito.logic.entity.CarritoEntity;
import co.edu.uniandes.estamparte.comprador.logic.entity.CompradorEntity;
import co.edu.uniandes.estamparte.formaPago.logic.entity.FormaPagoEntity;



import java.util.ArrayList;
import java.util.List;

public class FacturaConverter 
{
    
    public static FacturaDTO entity2PersistenceDTO(FacturaEntity entity) {
        if (entity != null) {
            FacturaDTO dto = new FacturaDTO();
            dto.setIdComprador(entity.getComprador().getId());
            dto.setIdFormaPago(entity.getFormaPago().getNumeroTarjeta());
            dto.setFechaCompra(entity.getFechaCompra());
            dto.setId(entity.getIdFactura());
            dto.setIdCarrito(entity.getCarrito().getIdCarrito());
            dto.setMonto(entity.getMonto());
            return dto;
        } else {
            return null;
        }
    }

    public static FacturaEntity persistenceDTO2Entity(FacturaDTO dto) {
        if (dto != null) {
            FacturaEntity entity = new FacturaEntity();
            
            CompradorEntity comp = new CompradorEntity();
            comp.setId(dto.getIdComprador());
            entity.setComprador(comp);
            
            FormaPagoEntity form = new FormaPagoEntity();
            form.setId(dto.getIdFormaPago());
            entity.setFormaPago(form);
            
            entity.setFechaCompra(dto.getFechaCompra());
            
            entity.setIdFactura(dto.getId());
            
            CarritoEntity carr = new CarritoEntity();
            carr.setIdCarrito(dto.getIdCarrito());
            entity.setCarrito(carr);
            
            entity.setMonto(dto.getMonto());

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

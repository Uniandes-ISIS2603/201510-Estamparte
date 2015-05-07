/*
 * Conversor de datos de estampas
 */
package co.edu.uniandes.estamparte.comprador.logic.converter;

//Convierte los objetos de clases de java a DTO (objeto que transfiere archivos a persistencia)

import co.edu.uniandes.estamparte.carrito.logic.converter.CarritoConverter;
import co.edu.uniandes.estamparte.carrito.logic.entity.CarritoEntity;
import co.edu.uniandes.estamparte.comprador.logic.dto.CompradorDTO;
import co.edu.uniandes.estamparte.comprador.logic.entity.CompradorEntity;
import co.edu.uniandes.estamparte.factura.logic.entity.FacturaEntity;
import co.edu.uniandes.estamparte.formaPago.logic.converter.FormaPagoConverter;
import co.edu.uniandes.estamparte.formaPago.logic.entity.FormaPagoEntity;
import java.util.ArrayList;
import java.util.List;


public class CompradorConverter {
   public static CompradorDTO entity2PersistenceDTO(CompradorEntity entity) {
        if (entity != null) {
            CompradorDTO dto = new CompradorDTO();
            dto.setNombre(entity.getNombre());
            dto.setId(entity.getId());
            dto.setIdCarrito(entity.getCarrito().getIdCarrito());
            dto.setDireccion(entity.getDireccion());
            dto.setTelefono(entity.getTelefono());
            dto.setUsuario(entity.getUsuario());
            dto.setClave(entity.getClave());
            dto.setCorreo(entity.getCorreo());
            dto.setCedula(entity.getCedula());
            return dto;
        } else {
            return null;
        }
    }

    public static CompradorEntity persistenceDTO2Entity(CompradorDTO dto) {
        if (dto != null) {
            CompradorEntity entity = new CompradorEntity();
            CarritoEntity carrito = new CarritoEntity();
            
            carrito.setIdCarrito(dto.getIdCarrito());
            
            entity.setNombre(dto.getNombre());
            entity.setDireccion(dto.getDireccion());
            entity.setTelefono(dto.getTelefono());
            entity.setUsuario(dto.getUsuario());
            entity.setClave(dto.getClave());
            entity.setCorreo(dto.getCorreo());
            entity.setCedula(dto.getCedula());
            entity.setId(dto.getId());
            entity.setCarrito(carrito);
            entity.setFormasPago(new ArrayList<FormaPagoEntity>());
            entity.setFacturas(new ArrayList<FacturaEntity>());
            return entity;
        } else {
            return null;
        }
    }

    public static List<CompradorDTO> convertirDeListaEntidadesAListaDTO (List<CompradorEntity> listaEntities) {
        List<CompradorDTO> listaDTO = new ArrayList<CompradorDTO>();
        for (CompradorEntity entity : listaEntities) {
            listaDTO.add(entity2PersistenceDTO(entity));
        }
        return listaDTO;
    }

    public static List<CompradorEntity> convertirDeListaDTOAListaEntidades (List<CompradorDTO> listaDTO) {
        List<CompradorEntity> listaEntities = new ArrayList<CompradorEntity>();
        for (CompradorDTO dto : listaDTO) {
            listaEntities.add(persistenceDTO2Entity(dto));
        }
        return listaEntities;
    }
     
}


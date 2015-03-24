/*
 * Conversor de datos de estampas
 */
package co.edu.uniandes.estamparte.comprador.logic.converter;

//Convierte los objetos de clases de java a DTO (objeto que transfiere archivos a persistencia)

import co.edu.uniandes.estamparte.carrito.logic.converter.CarritoConverter;
import co.edu.uniandes.estamparte.comprador.logic.dto.CompradorDTO;
import co.edu.uniandes.estamparte.comprador.logic.entity.CompradorEntity;
import co.edu.uniandes.estamparte.factura.logic.converter.FacturaConverter;
import co.edu.uniandes.estamparte.formaPago.logic.converter.FormaPagoConverter;
import java.util.*;
import java.util.List;

public class CompradorConverter {
   public static CompradorDTO entity2PersistenceDTO(CompradorEntity entity) {
        if (entity != null) {
            CompradorDTO dto = new CompradorDTO();
            dto.setDireccion(entity.getDireccion());
            dto.setTelefono(entity.getTelefono());
            dto.setUsuario(entity.getUsuario());
            dto.setClave(entity.getClave());
            dto.setNombre(entity.getNombre());
            dto.setId(entity.getId());
            dto.setCorreo(entity.getCorreo());
            dto.setCedula(entity.getCedula());
            dto.setCarrito(CarritoConverter.convertirDeEntidadADTO(entity.getCarrito()));
            dto.setFacturas(FacturaConverter.entity2PersistenceDTOList(entity.getFacturas()));
            dto.asignarFormasPago(FormaPagoConverter.convertirDeListaEntidadesAListaDTO(entity.darFormasPago()));
            return dto;
        } else {
            return null;
        }
    }

    public static CompradorEntity persistenceDTO2Entity(CompradorDTO dto) {
        if (dto != null) {
            CompradorEntity entity = new CompradorEntity();
            entity.setDireccion(dto.getDireccion());
            entity.setTelefono(dto.getTelefono());
            entity.setUsuario(dto.getUsuario());
            entity.setClave(dto.getClave());
            entity.setNombre(dto.getNombre());
            entity.setId(dto.getId());
            entity.setCorreo(dto.getCorreo());
            entity.setCedula(dto.getCedula());
            entity.setCarrito(CarritoConverter.convertirDeDTOAEntidad(dto.getCarrito()));
            entity.setFacturas(FacturaConverter.persistenceDTO2EntityList(dto.getFacturas()));
            entity.asignarFormasPago(FormaPagoConverter.convertirDeListaDTOAListaEntidades(dto.darFormasPago()));
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


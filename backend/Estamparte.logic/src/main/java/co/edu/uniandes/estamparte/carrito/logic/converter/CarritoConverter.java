/*
 * Conversor de datos de estampas
 */
package co.edu.uniandes.estamparte.carrito.logic.converter;
//Convierte los objetos de clases de java a DTO (objeto que transfiere archivos a persistencia)

import co.edu.uniandes.estamparte.camiseta.logic.converter.CamisetaConverter;
import co.edu.uniandes.estamparte.carrito.logic.dto.CarritoDTO;
import co.edu.uniandes.estamparte.carrito.logic.entity.CarritoEntity;
import co.edu.uniandes.estamparte.factura.logic.converter.FacturaConverter;
import java.util.ArrayList;
import java.util.List;

public class CarritoConverter {
    public static CarritoDTO convertirDeEntidadADTO (CarritoEntity entity) {
        if (entity != null) {
            CarritoDTO dto = new CarritoDTO();
            //Al objeto DTO se le asignan los atributos del objeto entity
            dto.asignarIdCarrito(entity.darIdCarrito());
            dto.asignarCamisetas(CamisetaConverter.entity2PersistenceDTOList(entity.darCamisetas()));
            dto.asignarIdCarrito(entity.darIdComprador());
            dto.asignarFactura(FacturaConverter.entity2PersistenceDTO(entity.darFactura()));
            return dto;
        } else {
            return null;
        }
    }

    public static CarritoEntity convertirDeDTOAEntidad (CarritoDTO dto) {
        if (dto != null) {
            CarritoEntity entity = new CarritoEntity();
            //Al objeto entity se le asignan los atributos del objeto dto
            entity.asignarCamisetas(CamisetaConverter.persistenceDTO2EntityList(dto.darCamisetas()));
            entity.asignarIdCarrito(dto.darIdCarrito());
            entity.asignarIdComprador(dto.darIdComprador());
            entity.asignarFactura(FacturaConverter.persistenceDTO2Entity(dto.darFactura()));
            return entity;
        } else {
            return null;
        }
    }

    public static List<CarritoDTO> convertirDeListaEntidadesAListaDTO (List<CarritoEntity> listaEntities) {
        List<CarritoDTO> listaDTO = new ArrayList<CarritoDTO>();
        for (CarritoEntity entity : listaEntities) {
            listaDTO.add(convertirDeEntidadADTO(entity));
        }
        return listaDTO;
    }

    public static List<CarritoEntity> convertirDeListaDTOAListaEntidades (ArrayList<CarritoDTO> listaDTO) {
        List<CarritoEntity> listaEntities = new ArrayList<CarritoEntity>();
        for (CarritoDTO dto : listaDTO) {
            listaEntities.add(convertirDeDTOAEntidad(dto));
        }
        return listaEntities;
    }
     
}


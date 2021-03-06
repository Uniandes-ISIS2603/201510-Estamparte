/*
 * Conversor de datos de estampas
 */
package co.edu.uniandes.estamparte.carrito.logic.converter;
//Convierte los objetos de clases de java a DTO (objeto que transfiere archivos a persistencia)

import co.edu.uniandes.estamparte.camiseta.logic.converter.CamisetaConverter;
import co.edu.uniandes.estamparte.camiseta.logic.entity.CamisetaEntity;
import co.edu.uniandes.estamparte.carrito.logic.dto.CarritoDTO;
import co.edu.uniandes.estamparte.carrito.logic.entity.CarritoEntity;
import co.edu.uniandes.estamparte.comprador.logic.converter.CompradorConverter;
import co.edu.uniandes.estamparte.comprador.logic.entity.CompradorEntity;
import co.edu.uniandes.estamparte.factura.logic.converter.FacturaConverter;
import co.edu.uniandes.estamparte.factura.logic.entity.FacturaEntity;
import java.util.ArrayList;
import java.util.List;

public class CarritoConverter {
    public static CarritoDTO convertirDeEntidadADTO (CarritoEntity entity) {
        if (entity != null) {
            CarritoDTO dto = new CarritoDTO();
            //Al objeto DTO se le asignan los atributos del objeto entity
            dto.setIdCarrito(entity.getIdCarrito());
            return dto;
        } else {
            return null;
        }
    }

    public static CarritoEntity convertirDeDTOAEntidad (CarritoDTO dto) {
        if (dto != null) {
            CarritoEntity entity = new CarritoEntity();
            //Al objeto entity se le asignan los atributos del objeto dto
            List<CamisetaEntity> camisetas = new ArrayList<CamisetaEntity>();
            entity.setCamisetas(camisetas);
            entity.setIdCarrito(dto.getIdCarrito());

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


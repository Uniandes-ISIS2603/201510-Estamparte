/*
 * Conversor de datos de estampas
 */
package co.edu.uniandes.estamparte.formaPago.logic.converter;

//Convierte los objetos de clases de java a DTO (objeto que transfiere archivos a persistencia)

import co.edu.uniandes.estamparte.comprador.logic.converter.CompradorConverter;
import co.edu.uniandes.estamparte.comprador.logic.entity.CompradorEntity;
import co.edu.uniandes.estamparte.formaPago.logic.dto.FormaPagoDTO;
import co.edu.uniandes.estamparte.formaPago.logic.entity.FormaPagoEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FormaPagoConverter {
    public static FormaPagoDTO convertirDeEntidadADTO (FormaPagoEntity entity) {
        if (entity != null) {
            FormaPagoDTO dto = new FormaPagoDTO();
            //Al objeto DTO se le asignan los atributos del objeto entity
            dto.setId(entity.getId());
            dto.setNombre(entity.getNombre());
            dto.setTipo(entity.getTipo());
            dto.setNumeroTarjeta(entity.getNumeroTarjeta());
            dto.setFechaVencimiento(new SimpleDateFormat("dd/MM/yyyy").format(entity.getFechaVencimiento()));
            dto.setCodigoSeguridad(entity.getCodigoSeguridad());
            dto.setDireccionCorrespondencia(entity.getDireccionCorrespondencia());
            dto.setIdComprador(entity.getComprador().getId());
            return dto;
        } else {
            return null;
        }
    }

    public static FormaPagoEntity convertirDeDTOAEntidad (FormaPagoDTO dto) {
        try{
            if (dto != null) {
                FormaPagoEntity entity = new FormaPagoEntity();
                CompradorEntity comprador = new CompradorEntity();
                comprador.setId(dto.getIdComprador());
                //Al objeto entity se le asignan los atributos del objeto dto
                entity.setId(dto.getId());
                entity.setNombre(dto.getNombre());
                entity.setTipo(dto.getTipo());
                entity.setNumeroTarjeta(dto.getNumeroTarjeta());
                entity.setFechaVencimiento(new SimpleDateFormat("dd/MM/yyyy").parse(dto.getFechaVencimiento()));
                entity.setCodigoSeguridad(dto.getCodigoSeguridad());
                entity.setDireccionCorrespondencia(dto.getDireccionCorrespondencia());
                entity.setComprador(comprador);
                return entity;
            } else {
                return null;
            }
        }
        catch(ParseException e){
            System.out.println("Error en conversion de fecha: "+e.getMessage());
            return null;
        }
    }
    
        public static List<FormaPagoDTO> convertirDeListaEntidadesAListaDTO (List<FormaPagoEntity> listaEntities) {
        List<FormaPagoDTO> listaDTO = new ArrayList<FormaPagoDTO>();
        for (FormaPagoEntity entity : listaEntities) {
            listaDTO.add(convertirDeEntidadADTO(entity));
        }
        return listaDTO;
    }

    public static List<FormaPagoEntity> convertirDeListaDTOAListaEntidades (List<FormaPagoDTO> listaDTO) {
        List<FormaPagoEntity> listaEntities = new ArrayList<FormaPagoEntity>();
        for (FormaPagoDTO dto : listaDTO) {
            listaEntities.add(convertirDeDTOAEntidad(dto));
        }
        return listaEntities;
    }
}


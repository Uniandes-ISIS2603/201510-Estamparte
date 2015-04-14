/*
 * Conversor de datos de estampas
 */
package co.edu.uniandes.estamparte.administrador.logic.converter;

//Convierte los objetos de clases de java a DTO (objeto que transfiere archivos a persistencia)

import co.edu.uniandes.estamparte.administrador.logic.dto.AdministradorDTO;
import co.edu.uniandes.estamparte.administrador.logic.entity.AdministradorEntity;
import co.edu.uniandes.estamparte.artista.logic.converter.*;
import co.edu.uniandes.estamparte.artista.logic.dto.ArtistaDTO;
import co.edu.uniandes.estamparte.artista.logic.entity.ArtistaEntity;
import co.edu.uniandes.estamparte.estampa.logic.entity.EstampaEntity;
import java.util.ArrayList;
import java.util.List;

public class AdministradorConverter {
    
    public static AdministradorDTO convertirDeEntidadADTO (AdministradorEntity entidad) {
        if (entidad != null) {
            AdministradorDTO dto = new AdministradorDTO();
            dto.setId(entidad.getId());
            dto.setUsuario(entidad.getUsuario());
            dto.setContrasena(entidad.getContrasena());
            dto.setNombre(entidad.getNombre());
            dto.setCedula(entidad.getCedula());
            dto.setCorreo(entidad.getCorreo());
            return dto;
        } else {
            return null;
        }
    }

    public static AdministradorEntity convertirDeDTOAEntidad (AdministradorDTO dto) {
        if (dto != null) {
            AdministradorEntity entidad = new AdministradorEntity();
            //Al objeto entity se le asignan los atributos del objeto dto
            entidad.setId(dto.getId());
            entidad.setUsuario(dto.getUsuario());
            entidad.setContrasena(dto.getContrasena());
            entidad.setNombre(dto.getNombre());
            entidad.setCedula(dto.getCedula());
            entidad.setCorreo(dto.getCorreo());
            return entidad;
        } else {
            return null;
        }
    }

    public static List<AdministradorDTO> convertirDeListaEntidadesAListaDTO (List<AdministradorEntity> listaEntities) {
        List<AdministradorDTO> listaDTO = new ArrayList<AdministradorDTO>();
        for (AdministradorEntity entity : listaEntities) {
            listaDTO.add(convertirDeEntidadADTO(entity));
        }
        return listaDTO;
    }

    public static List<AdministradorEntity> convertirDeListaDTOAListaEntidades (ArrayList<AdministradorDTO> listaDTO) {
        List<AdministradorEntity> listaEntities = new ArrayList<AdministradorEntity>();
        for (AdministradorDTO dto : listaDTO) {
            listaEntities.add(convertirDeDTOAEntidad(dto));
        }
        return listaEntities;
    }
    
}

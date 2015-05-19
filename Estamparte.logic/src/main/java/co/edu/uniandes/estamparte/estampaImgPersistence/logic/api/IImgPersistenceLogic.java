/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.estamparte.estampaImgPersistence.logic.api;

import co.edu.uniandes.estamparte.estampaImgPersistence.logic.dto.ImgDTO;

/**
 *
 * @author JsMarti
 */
public interface IImgPersistenceLogic {
    
    //Guarda una nueva imagen en el servidor y retorna su ruta
    public String createEstampaImagen(ImgDTO img);
    
    //Actualiza una imagen en el servidor dada su direccion
    public String updateImagen(ImgDTO img);
    
    //Elimina una imagen en el servidor dada su direccion
    public void deleteImagen(String url);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.estamparte.estampaImgPersistence.logic.dto;

/**
 * DTO de una imagen
 * @author JsMarti
 */
public class ImgDTO {
    
    private String nombre;
    
    private String data;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
}

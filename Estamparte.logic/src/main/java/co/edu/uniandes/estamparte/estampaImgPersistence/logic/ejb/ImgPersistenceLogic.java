/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.estamparte.estampaImgPersistence.logic.ejb;

import co.edu.uniandes.estamparte.estampaImgPersistence.logic.api.IImgPersistenceLogic;
import co.edu.uniandes.estamparte.estampaImgPersistence.logic.dto.ImgDTO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import org.ow2.util.base64.Base64;



/**
 *
 * @author JsMarti
 */
public class ImgPersistenceLogic implements IImgPersistenceLogic {

    @Override
    public String createEstampaImagen(ImgDTO img) {
        String respuesta = "";
        File data = new File("./data");
        if(!data.exists())
            data.mkdir();
        try{
            //En donde debe estar la carpeta data??
            File file  = new File("./data/"+img.getNombre()+".png");
            if(file.exists())
                respuesta = "Ya existe una imagen con este nombre";
            else{
                
                byte[] decodedData = Base64.decode(img.getData().toCharArray());
                
                BufferedImage buffDecoded = ImageIO.read(new ByteArrayInputStream(decodedData));
                ImageIO.write(buffDecoded, "png", file);
                
                //Aqui se debe retornar la url a la imagen
                //Temporal:
                respuesta = "http://localhost:8080/Estamparte.service/webresources/data/"+img.getNombre()+".png";
            }
 
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            respuesta = "Error en la serializacion";
        }
        return respuesta;
    }

    @Override
    public String updateImagen(ImgDTO img) {
        String respuesta = "";
        try{
            //En donde debe estar la carpeta data??
            File file  = new File("./data/"+img.getNombre()+".png");
            byte[] decodedData = Base64.decode(img.getData().toCharArray());
            BufferedImage buffDecoded = ImageIO.read(new ByteArrayInputStream(decodedData));
            ImageIO.write(buffDecoded, "png", file);

            //Aqui se debe retornar la url a la imagen
            //Temporal:
            respuesta = "http://localhost:8080/Estamparte.service/webresources/data/"+img.getNombre()+".png";
            
 
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            respuesta = "Error en la serializacion";
        }
        return respuesta;
    }

    @Override
    public void deleteImagen(String url) {
        String[] params = url.split("/");
        File file = new File("./"+params[5]+"/"+params[6]);
        if(file.exists())
            file.delete();
    }
    
}

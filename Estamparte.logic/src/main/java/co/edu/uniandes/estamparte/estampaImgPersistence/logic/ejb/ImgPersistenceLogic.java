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
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import javax.imageio.ImageIO;

/**
 *
 * @author JsMarti
 */
public class ImgPersistenceLogic implements IImgPersistenceLogic {

    @Override
    public String createEstampaImagen(ImgDTO img) {
        String respuesta = "";
        try{
            //En donde debe estar la carpeta data??
            File file  = new File("./data/"+img.getNombre()+".png");
            if(file.exists())
                respuesta = "Ya existe una imagen con este nombre";
            else{
                byte[] decodedData = Base64.getDecoder().decode(img.getData());
                BufferedImage buffDecoded = ImageIO.read(new ByteArrayInputStream(decodedData));
                ImageIO.write(buffDecoded, "png", file);
                //
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteImagen(String url) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

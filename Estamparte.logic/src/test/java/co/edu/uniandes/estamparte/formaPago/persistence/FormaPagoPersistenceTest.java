package co.edu.uniandes.estamparte.formaPago.persistence;

import co.edu.uniandes.estamparte.administrador.logic.api.IAdministradorLogic;
import co.edu.uniandes.estamparte.administrador.logic.converter.AdministradorConverter;
import co.edu.uniandes.estamparte.administrador.logic.dto.AdministradorDTO;
import co.edu.uniandes.estamparte.administrador.logic.ejb.AdministradorLogic;
import co.edu.uniandes.estamparte.administrador.logic.entity.AdministradorEntity;
import co.edu.uniandes.estamparte.administrador.persistence.*;
import co.edu.uniandes.estamparte.formaPago.logic.api.IFormaPagoLogic;
import co.edu.uniandes.estamparte.formaPago.logic.converter.FormaPagoConverter;
import co.edu.uniandes.estamparte.formaPago.logic.dto.FormaPagoDTO;
import co.edu.uniandes.estamparte.formaPago.logic.ejb.FormaPagoLogic;
import co.edu.uniandes.estamparte.formaPago.logic.entity.FormaPagoEntity;
import java.io.File;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.runner.RunWith;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author estudiante
 */
@RunWith(Arquillian.class)
public class FormaPagoPersistenceTest {
    
     public static final String DEPLOY = "Prueba";
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                //Añade el paquete en el que se encuentra la clase 'SportPersistance.java'
                .addPackage(IFormaPagoLogic.class.getPackage())
                .addPackage(FormaPagoLogic.class.getPackage())
                //Añade el paquete en el que se encuentra la clase 'SportEntity.java'
                .addPackage(FormaPagoEntity.class.getPackage())
                .addPackage(FormaPagoDTO.class.getPackage())
                .addPackage(FormaPagoConverter.class.getPackage())
                //Finalmente se añaden los archivos persistance.xml y beans.xml para la Unidad de peristencia y CDI del paquete mínimo
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(new File ("src/main/resources/META-INF/beans.xml"));
    }
}

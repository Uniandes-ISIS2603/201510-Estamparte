package co.edu.uniandes.estamparte.administrador.persistence;

import co.edu.uniandes.estamparte.administrador.logic.api.IAdministradorLogic;
import co.edu.uniandes.estamparte.administrador.logic.converter.AdministradorConverter;
import co.edu.uniandes.estamparte.administrador.logic.dto.AdministradorDTO;
import co.edu.uniandes.estamparte.administrador.logic.ejb.AdministradorLogic;
import co.edu.uniandes.estamparte.administrador.logic.entity.AdministradorEntity;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;



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
public class AdministradorPersistenceTest {
    
    public static final String DEPLOY = "Prueba";
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                //Añade el paquete en el que se encuentra la clase 'SportPersistance.java'
                .addPackage(IAdministradorLogic.class.getPackage())
                .addPackage(AdministradorLogic.class.getPackage())
                //Añade el paquete en el que se encuentra la clase 'SportEntity.java'
                .addPackage(AdministradorEntity.class.getPackage())
                .addPackage(AdministradorDTO.class.getPackage())
                .addPackage(AdministradorConverter.class.getPackage())
                //Finalmente se añaden los archivos persistance.xml y beans.xml para la Unidad de peristencia y CDI del paquete mínimo
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(new File ("src/main/resources/META-INF/beans.xml"));
    }
     @Inject
     private IAdministradorLogic adminPersistence;
     @PersistenceContext
     private EntityManager em;
     @Inject
     UserTransaction utx;
    
      @Before
    public void configTest() {
        System.out.println("em: " + em);
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    private void clearData() {
        em.createQuery("delete from AdministradorEntity").executeUpdate();
    }

    private List<AdministradorEntity> data = new ArrayList<AdministradorEntity>();

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
            AdministradorEntity entity = factory.manufacturePojo(AdministradorEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
     @Test
    public void createAdminTest() {
        // se instancia el generador de datos Podam
        PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
        AdministradorDTO dto = factory.manufacturePojo(AdministradorDTO.class);
        AdministradorDTO result = adminPersistence.crearAdministrador(dto);
        Assert.assertNotNull(result);
        AdministradorEntity entity = em.find(AdministradorEntity.class, result.getId());
 
        Assert.assertEquals(dto.getId(), entity.getId());
        Assert.assertEquals(dto.getUsuario(), entity.getUsuario());
        Assert.assertEquals(dto.getContrasena(), entity.getContrasena());
        Assert.assertEquals(dto.getNombre(), entity.getNombre());
        Assert.assertEquals(dto.getCedula(), entity.getCedula());
        Assert.assertEquals(dto.getCorreo(), entity.getCorreo());
    }
}

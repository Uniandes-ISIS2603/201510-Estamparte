package co.edu.uniandes.estamparte.artista.persistence;

<<<<<<< HEAD

=======
>>>>>>> origin/master
import co.edu.uniandes.estamparte.artista.logic.api.IArtistaLogic;
import co.edu.uniandes.estamparte.artista.logic.converter.ArtistaConverter;
import co.edu.uniandes.estamparte.artista.logic.dto.ArtistaDTO;
import co.edu.uniandes.estamparte.artista.logic.dto.ArtistaPageDTO;
import co.edu.uniandes.estamparte.artista.logic.ejb.ArtistaLogic;
import co.edu.uniandes.estamparte.artista.logic.entity.ArtistaEntity;
import co.edu.uniandes.estamparte.estampa.logic.api.IEstampaLogic;
import co.edu.uniandes.estamparte.estampa.logic.converter.EstampaConverter;
import co.edu.uniandes.estamparte.estampa.logic.dto.EstampaDTO;
import co.edu.uniandes.estamparte.estampa.logic.ejb.EstampaLogic;
import co.edu.uniandes.estamparte.estampa.logic.entity.EstampaEntity;
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
public class ArtistaPersistenceTest {
    /**
    public static final String DEPLOY = "Prueba";
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                //Aï¿½ade el paquete en el que se encuentra la clase 'SportPersistance.java'
                .addPackage(IArtistaLogic.class.getPackage())
                .addPackage(ArtistaLogic.class.getPackage())
                //Aï¿½ade el paquete en el que se encuentra la clase 'SportEntity.java'
                .addPackage(ArtistaEntity.class.getPackage())
                .addPackage(ArtistaDTO.class.getPackage())
                                .addPackage(ArtistaPageDTO.class.getPackage())

                .addPackage(ArtistaConverter.class.getPackage())
<<<<<<< HEAD
                 .addPackage(IEstampaLogic.class.getPackage())
                .addPackage(EstampaLogic.class.getPackage())
                //Añade el paquete en el que se encuentra la clase 'SportEntity.java'
                .addPackage(EstampaEntity.class.getPackage())
                .addPackage(EstampaDTO.class.getPackage())
                .addPackage(EstampaConverter.class.getPackage())
                //Finalmente se añaden los archivos persistance.xml y beans.xml para la Unidad de peristencia y CDI del paquete mínimo
=======
                //Finalmente se aï¿½aden los archivos persistance.xml y beans.xml para la Unidad de peristencia y CDI del paquete mï¿½nimo
>>>>>>> origin/master
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(new File ("src/main/resources/META-INF/beans.xml"));
    }
    
     @Inject
     private IArtistaLogic artistaPersistence;
     @PersistenceContext
     private EntityManager em;
     @Inject
     UserTransaction utx;
     
      @Before
    public void configTest() {
        System.out.println("em: " + em);
        try {
            utx.begin();
            //clearData();
            //insertData();
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
        em.createQuery("delete from ArtistaEntity").executeUpdate();
    }

    private List<ArtistaEntity> data = new ArrayList<ArtistaEntity>();

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
            ArtistaEntity entity = factory.manufacturePojo(ArtistaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    
    @Test
    public void asd()
    {
        
        junit.framework.Assert.assertTrue(true);
    }
   */
    
}

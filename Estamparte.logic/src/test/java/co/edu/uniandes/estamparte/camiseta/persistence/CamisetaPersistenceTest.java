package co.edu.uniandes.estamparte.camiseta.persistence;

import co.edu.uniandes.estamparte.administrador.logic.api.IAdministradorLogic;
import co.edu.uniandes.estamparte.administrador.logic.converter.AdministradorConverter;
import co.edu.uniandes.estamparte.administrador.logic.dto.AdministradorDTO;
import co.edu.uniandes.estamparte.administrador.logic.ejb.AdministradorLogic;
import co.edu.uniandes.estamparte.administrador.logic.entity.AdministradorEntity;
import co.edu.uniandes.estamparte.administrador.persistence.*;
import co.edu.uniandes.estamparte.artista.logic.api.IArtistaLogic;
import co.edu.uniandes.estamparte.artista.logic.converter.ArtistaConverter;
import co.edu.uniandes.estamparte.artista.logic.dto.ArtistaDTO;
import co.edu.uniandes.estamparte.artista.logic.dto.ArtistaPageDTO;
import co.edu.uniandes.estamparte.artista.logic.ejb.ArtistaLogic;
import co.edu.uniandes.estamparte.artista.logic.entity.ArtistaEntity;
import co.edu.uniandes.estamparte.camiseta.logic.api.ICamisetaLogic;
import co.edu.uniandes.estamparte.camiseta.logic.converter.CamisetaConverter;
import co.edu.uniandes.estamparte.camiseta.logic.dto.CamisetaDTO;
import co.edu.uniandes.estamparte.camiseta.logic.ejb.CamisetaLogic;
import co.edu.uniandes.estamparte.camiseta.logic.entity.CamisetaEntity;
import co.edu.uniandes.estamparte.carrito.logic.api.ICarritoLogic;
import co.edu.uniandes.estamparte.carrito.logic.converter.CarritoConverter;
import co.edu.uniandes.estamparte.carrito.logic.dto.CarritoDTO;
import co.edu.uniandes.estamparte.carrito.logic.ejb.CarritoLogic;
import co.edu.uniandes.estamparte.carrito.logic.entity.CarritoEntity;
import co.edu.uniandes.estamparte.comprador.logic.api.ICompradorLogic;
import co.edu.uniandes.estamparte.comprador.logic.converter.CompradorConverter;
import co.edu.uniandes.estamparte.comprador.logic.dto.CompradorDTO;
import co.edu.uniandes.estamparte.comprador.logic.ejb.CompradorLogic;
import co.edu.uniandes.estamparte.comprador.logic.entity.CompradorEntity;
import co.edu.uniandes.estamparte.estampa.logic.api.IEstampaLogic;
import co.edu.uniandes.estamparte.estampa.logic.converter.EstampaConverter;
import co.edu.uniandes.estamparte.estampa.logic.dto.EstampaDTO;
import co.edu.uniandes.estamparte.estampa.logic.ejb.EstampaLogic;
import co.edu.uniandes.estamparte.estampa.logic.entity.EstampaEntity;
import co.edu.uniandes.estamparte.factura.logic.api.IFacturaLogic;
import co.edu.uniandes.estamparte.factura.logic.converter.FacturaConverter;
import co.edu.uniandes.estamparte.factura.logic.dto.FacturaDTO;
import co.edu.uniandes.estamparte.factura.logic.ejb.FacturaLogic;
import co.edu.uniandes.estamparte.factura.logic.entity.FacturaEntity;
import co.edu.uniandes.estamparte.formaPago.logic.api.IFormaPagoLogic;
import co.edu.uniandes.estamparte.formaPago.logic.converter.FormaPagoConverter;
import co.edu.uniandes.estamparte.formaPago.logic.dto.FormaPagoDTO;
import co.edu.uniandes.estamparte.formaPago.logic.ejb.FormaPagoLogic;
import co.edu.uniandes.estamparte.formaPago.logic.entity.FormaPagoEntity;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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
public class CamisetaPersistenceTest {
    
    public static final String DEPLOY = "Prueba";
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                //A�ade el paquete en el que se encuentra la clase 'SportPersistance.java'
                .addPackage(ICompradorLogic.class.getPackage())
                .addPackage(CompradorLogic.class.getPackage())
                //A�ade el paquete en el que se encuentra la clase 'SportEntity.java'
                .addPackage(CompradorEntity.class.getPackage())
                .addPackage(CompradorDTO.class.getPackage())
                .addPackage(CompradorConverter.class.getPackage())
                .addPackage(IFacturaLogic.class.getPackage())
                .addPackage(FacturaLogic.class.getPackage())
                //A�ade el paquete en el que se encuentra la clase 'SportEntity.java'
                .addPackage(FacturaEntity.class.getPackage())
                .addPackage(FacturaDTO.class.getPackage())
                .addPackage(FacturaConverter.class.getPackage())
                .addPackage(IFormaPagoLogic.class.getPackage())
                .addPackage(FormaPagoLogic.class.getPackage())
                //A�ade el paquete en el que se encuentra la clase 'SportEntity.java'
                .addPackage(FormaPagoEntity.class.getPackage())
                .addPackage(FormaPagoDTO.class.getPackage())
                .addPackage(FormaPagoConverter.class.getPackage())
                .addPackage(IEstampaLogic.class.getPackage())
                .addPackage(EstampaLogic.class.getPackage())
                //A�ade el paquete en el que se encuentra la clase 'SportEntity.java'
                .addPackage(EstampaEntity.class.getPackage())
                .addPackage(EstampaDTO.class.getPackage())
                .addPackage(EstampaConverter.class.getPackage())
                .addPackage(ICarritoLogic.class.getPackage())
                .addPackage(CarritoLogic.class.getPackage())
                //A�ade el paquete en el que se encuentra la clase 'SportEntity.java'
                .addPackage(CarritoEntity.class.getPackage())
                .addPackage(CarritoDTO.class.getPackage())
                .addPackage(CarritoConverter.class.getPackage())
                .addPackage(ICamisetaLogic.class.getPackage())
                .addPackage(CamisetaLogic.class.getPackage())
                //A�ade el paquete en el que se encuentra la clase 'SportEntity.java'
                .addPackage(CamisetaEntity.class.getPackage())
                .addPackage(CamisetaDTO.class.getPackage())
                .addPackage(CamisetaConverter.class.getPackage())
                .addPackage(IArtistaLogic.class.getPackage())
                .addPackage(ArtistaLogic.class.getPackage())
                //A�ade el paquete en el que se encuentra la clase 'SportEntity.java'
                .addPackage(ArtistaEntity.class.getPackage())
                .addPackage(ArtistaDTO.class.getPackage())
                                .addPackage(ArtistaPageDTO.class.getPackage())

                .addPackage(ArtistaConverter.class.getPackage())
                //Finalmente se a�aden los archivos persistance.xml y beans.xml para la Unidad de peristencia y CDI del paquete m�nimo
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(new File ("src/main/resources/META-INF/beans.xml"));
    }
    
     @Inject
     private IArtistaLogic artistaPersistence;
    @Inject
     private IEstampaLogic estampaPersistence;
    @Inject
     private ICamisetaLogic camisetaPersistence;
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
        em.createQuery("delete from CamisetaEntity").executeUpdate();
    }

    private List<CamisetaEntity> data = new ArrayList<CamisetaEntity>();

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            CamisetaEntity entity = new CamisetaEntity();
            entity.setTalla("123" + i);
            entity.setColor("sad"+ i);
            entity.setEstilo("12"+ i);
            entity.setNombre("asd"+ i);
            entity.setCosto((double)i);
            entity.setEstampas(new ArrayList());
            em.persist(entity);
            data.add(entity);
        }
    }
    
    
    @Test
    @Transactional
    public void createCamisetaTest() {
        // se instancia el generador de datos Podam
        ArtistaDTO entity = new ArtistaDTO();
            entity.setCedula("123" );
            entity.setUsuario("sad");
            entity.setContrasenha("12");
            entity.setNombre("asd");
            entity.setCorreo("asd");
            entity.setDescripcion("sds");
            entity.setImagenPerfil("sd");
            ArtistaDTO res = artistaPersistence.crearArtista(entity);
        
        EstampaDTO dto = new EstampaDTO();
        dto.setIdArtista(res.getId());
        dto.setAltura(1.00);
        dto.setAncho(1.00);
        dto.setDescripcion("asd");
        dto.setSiGusta(1);
        dto.setNoGusta(2);
        dto.setNombre("asd");
       EstampaDTO respp = estampaPersistence.crearEstampa(dto);
        EstampaDTO resp = estampaPersistence.darEstampa(respp.getId());
        CamisetaDTO dtoo = new CamisetaDTO();
       
        dtoo.setTalla("123" );
        dtoo.setColor("sad");
        dtoo.setEstilo("12");
        dtoo.setNombre("asd");
        dtoo.setCosto(1);
        long[] estampas = new long[1];
        estampas[0] = resp.getId();
        dtoo.setEstampas(estampas);
        CamisetaDTO result = camisetaPersistence.crearCamiseta(dtoo);
        Assert.assertNotNull(result);
        
        CamisetaEntity entityy = em.find(CamisetaEntity.class, result.getId());
 
        Assert.assertEquals(dtoo.getTalla(), entityy.getTalla());
        Assert.assertEquals(dtoo.getColor(), entityy.getColor());
        Assert.assertEquals(dtoo.getNombre(), entityy.getNombre());
        Assert.assertEquals(dtoo.getEstilo(), entityy.getEstilo());
        Assert.assertEquals(dtoo.getCosto(), entityy.getCosto());
    }
        
    
    
    @Test
    public void getCamisetaTest(){
        CamisetaEntity entity = data.get(0);
        Assert.assertNotNull(entity);
        
        CamisetaDTO dto = camisetaPersistence.darCamiseta(entity.getId());
        Assert.assertEquals(dto.getTalla(), entity.getTalla());
        Assert.assertEquals(dto.getColor(), entity.getColor());
        Assert.assertEquals(dto.getNombre(), entity.getNombre());
        Assert.assertEquals(dto.getEstilo(), entity.getEstilo());
    }
    
    @Test
    @Transactional
    public void deleteCamisetaTest(){
        CamisetaEntity result = data.get(0);
        Assert.assertNotNull(result);
        camisetaPersistence.eliminarCamiseta(result.getId());
        
        
        CamisetaEntity entity = em.find(CamisetaEntity.class, result.getId());
        Assert.assertNull(entity);
        
    }
    
    @Test
    public void updateCamisetaTest(){
        CamisetaDTO result = CamisetaConverter.entity2PersistenceDTO(data.get(1));
        Assert.assertNotNull(result);
        result.setTalla("123");
        
        
        CamisetaDTO ress = camisetaPersistence.actualizarCamiseta(result);
        CamisetaEntity entity = em.find(CamisetaEntity.class, result.getId());

        Assert.assertEquals(entity.getTalla(), ress.getTalla());
    } 
}

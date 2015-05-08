package co.edu.uniandes.estamparte.formaPago.persistence;

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
import java.util.Date;
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
public class FormaPagoPersistenceTest {
    
     public static final String DEPLOY = "Prueba";
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                //Añade el paquete en el que se encuentra la clase 'SportPersistance.java'
                .addPackage(ICompradorLogic.class.getPackage())
                .addPackage(CompradorLogic.class.getPackage())
                //Añade el paquete en el que se encuentra la clase 'SportEntity.java'
                .addPackage(CompradorEntity.class.getPackage())
                .addPackage(CompradorDTO.class.getPackage())
                .addPackage(CompradorConverter.class.getPackage())
                .addPackage(IFacturaLogic.class.getPackage())
                .addPackage(FacturaLogic.class.getPackage())
                //Añade el paquete en el que se encuentra la clase 'SportEntity.java'
                .addPackage(FacturaEntity.class.getPackage())
                .addPackage(FacturaDTO.class.getPackage())
                .addPackage(FacturaConverter.class.getPackage())
                .addPackage(IFormaPagoLogic.class.getPackage())
                .addPackage(FormaPagoLogic.class.getPackage())
                //Añade el paquete en el que se encuentra la clase 'SportEntity.java'
                .addPackage(FormaPagoEntity.class.getPackage())
                .addPackage(FormaPagoDTO.class.getPackage())
                .addPackage(FormaPagoConverter.class.getPackage())
                .addPackage(IEstampaLogic.class.getPackage())
                .addPackage(EstampaLogic.class.getPackage())
                //Añade el paquete en el que se encuentra la clase 'SportEntity.java'
                .addPackage(EstampaEntity.class.getPackage())
                .addPackage(EstampaDTO.class.getPackage())
                .addPackage(EstampaConverter.class.getPackage())
                .addPackage(ICarritoLogic.class.getPackage())
                .addPackage(CarritoLogic.class.getPackage())
                //Añade el paquete en el que se encuentra la clase 'SportEntity.java'
                .addPackage(CarritoEntity.class.getPackage())
                .addPackage(CarritoDTO.class.getPackage())
                .addPackage(CarritoConverter.class.getPackage())
                .addPackage(ICamisetaLogic.class.getPackage())
                .addPackage(CamisetaLogic.class.getPackage())
                //Añade el paquete en el que se encuentra la clase 'SportEntity.java'
                .addPackage(CamisetaEntity.class.getPackage())
                .addPackage(CamisetaDTO.class.getPackage())
                .addPackage(CamisetaConverter.class.getPackage())
                .addPackage(IArtistaLogic.class.getPackage())
                .addPackage(ArtistaLogic.class.getPackage())
                //Aï¿½ade el paquete en el que se encuentra la clase 'SportEntity.java'
                .addPackage(ArtistaEntity.class.getPackage())
                .addPackage(ArtistaDTO.class.getPackage())
                                .addPackage(ArtistaPageDTO.class.getPackage())

                .addPackage(ArtistaConverter.class.getPackage())
                //Finalmente se añaden los archivos persistance.xml y beans.xml para la Unidad de peristencia y CDI del paquete mínimo
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(new File ("src/main/resources/META-INF/beans.xml"));
    }
    @Inject
     private ICarritoLogic carritoPersistence;
    @Inject
     private ICompradorLogic compradorPersistence;
    @Inject
     private IFormaPagoLogic formaPagoPersistence;
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
        em.createQuery("delete from FormaPagoEntity").executeUpdate();
    }

    private List<FormaPagoEntity> data = new ArrayList<FormaPagoEntity>();

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            CarritoDTO dtoo = new CarritoDTO();        
            CarritoDTO resultC = carritoPersistence.crearCarrito(dtoo);
            
            CompradorDTO dto = new CompradorDTO();
            dto.setIdCarrito(resultC.getIdCarrito());
            dto.setCedula(1);
            dto.setClave("asd" + i);
            dto.setCorreo("asd" );
            dto.setDireccion("asd");
            dto.setNombre("asd");
            dto.setTelefono(1);
            dto.setUsuario("asd");   
            CompradorDTO result = compradorPersistence.createComprador(dto);
            
            FormaPagoEntity entity = new FormaPagoEntity();
            entity.setCodigoSeguridad(i);
            entity.setDireccionCorrespondencia("asd" +i);
            entity.setNombre("asd" + i);
            entity.setTipo("asd"+i);
            entity.setNumeroTarjeta(i);
            entity.setFechaVencimiento(new Date());
            entity.setComprador(CompradorConverter.persistenceDTO2Entity(result));
            em.persist(entity);
            data.add(entity);
        }
    }
    
    
    @Test
    public void createFormaPagoTest() {
        // se instancia el generador de datos Podam
            CarritoDTO dtoo = new CarritoDTO();        
            CarritoDTO resultC = carritoPersistence.crearCarrito(dtoo);
            
            CompradorDTO dtoC = new CompradorDTO();
            dtoC.setIdCarrito(resultC.getIdCarrito());
            dtoC.setCedula(1);
            dtoC.setClave("asd" );
            dtoC.setCorreo("asd" );
            dtoC.setDireccion("asd");
            dtoC.setNombre("asd");
            dtoC.setTelefono(1);
            dtoC.setUsuario("asd");   
            CompradorDTO result = compradorPersistence.createComprador(dtoC);
            
            FormaPagoDTO dto = new FormaPagoDTO();
            dto.setCodigoSeguridad(1);
            dto.setDireccionCorrespondencia("asd" );
            dto.setNombre("asd" );
            dto.setTipo("asd");
            dto.setNumeroTarjeta(1);
            dto.setIdComprador(result.getId());
            FormaPagoDTO dto2 = formaPagoPersistence.crearFormaPago(dto);
            
            FormaPagoEntity entity = em.find(FormaPagoEntity.class, dto2.getId());
            Assert.assertEquals(dto2.getId(), entity.getId());
            Assert.assertEquals(dto2.getNombre(), entity.getNombre());
            Assert.assertEquals(dto2.getNumeroTarjeta(), entity.getNumeroTarjeta());          
    }
    
    @Test
    public void getFormaPagoCompradorTest(){

        FormaPagoEntity entity = data.get(0);
        Assert.assertNotNull(entity);
        
        List<FormaPagoDTO> result = formaPagoPersistence.darFormasPagoComprador(entity.getComprador().getId());
        Assert.assertEquals(entity.getId(),result.get(0).getId() );
        Assert.assertEquals(entity.getNombre(),result.get(0).getNombre() );
        Assert.assertEquals(entity.getCodigoSeguridad(),result.get(0).getCodigoSeguridad() );
        Assert.assertEquals(entity.getTipo(),result.get(0).getTipo() );


    }
    
    @Test
    public void deleteFormaPagoTest(){
        FormaPagoEntity entity = data.get(0);
        Assert.assertNotNull(entity);
        
        formaPagoPersistence.eliminarFormaPago(entity.getId());
        
        
        FormaPagoEntity result = em.find(FormaPagoEntity.class, entity.getId());
        Assert.assertNull(result);
        
    }
    
    @Test
    public void updateFormaPagoTest(){

        FormaPagoEntity entity = data.get(1);
        Assert.assertNotNull(entity);
        entity.setCodigoSeguridad(12345);
        
        FormaPagoDTO result = formaPagoPersistence.actualizarFormaPago(FormaPagoConverter.convertirDeEntidadADTO(entity));
        FormaPagoEntity result2 = em.find(FormaPagoEntity.class, entity.getId());
        
        Assert.assertEquals(entity.getCodigoSeguridad(), result.getCodigoSeguridad());

        Assert.assertEquals(entity.getCodigoSeguridad(), result2.getCodigoSeguridad());
    }
    
}

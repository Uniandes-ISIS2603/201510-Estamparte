/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author SamuelSalazar
 */
@RunWith(Arquillian.class)
public class EstamparteTest {
    
    public EstamparteTest() {
    }
    
    // Es la instancia inicial del web driver que controlará el navegador firefox
        private static WebDriver driver;
        // url en el cual se aloja la página web (en este caso localhost:8080)
        private static String baseUrl;
        // variable que indica si varios alert consecutivos (alert javascript) se tomarán
        private static boolean acceptNextAlert = true;
        
        private static StringBuffer verificationErrors = new StringBuffer();
        
    @BeforeClass
    public static void setUp() {
         driver = new FirefoxDriver();
        // se define el url base del proyecto web
            baseUrl = "http://localhost:8080";
        /* Indica cuanto se espera para la respuesta de cualquier comando realizado hacia el navegador*/
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    @AfterClass
    public static void tearDown() {
                    // Se cierra el navegador.
            driver.quit();
           // Se verifica que se haya cerrado efectivamente el navegador.
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
    }

    @Before
    public void setUpUrl() {
        driver.get(baseUrl + "/Estamparte.service");
    }
    
    @Test
    public void testAgregarFormaDePago() throws Exception
    {
        boolean success = false;
        driver.findElement(By.id("opciones")).click();
        Thread.sleep(3000);
        
        driver.findElement(By.id("agregarFormaPago")).click();
        Thread.sleep(3000);
      
        
        driver.findElement(By.id("tipo")).clear();
        driver.findElement(By.id("numero")).clear();
        driver.findElement(By.id("fecha")).clear();
        
        driver.findElement(By.id("tipo")).sendKeys("Credito");
        driver.findElement(By.id("numero")).sendKeys("123456789");
        driver.findElement(By.id("fecha")).sendKeys("24/12/2020");
        
        driver.findElement(By.id("aceptar")).click();
        Thread.sleep(3000);
        
        driver.findElement(By.id("opciones")).click();
        Thread.sleep(3000);
        
        driver.findElement(By.id("verFormasPago")).click();
        Thread.sleep(3000);
        
        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@id,'Table')]/tbody/tr"));
        for (WebElement webElement : rows) {
            List<WebElement> elems = webElement.findElements(By.xpath("td"));
            if (elems.get(0).getText().equals("Credito") && elems.get(1).getText().equals("123456789")) {
                success = true;
            }
        }
        
        assertTrue(success);
        Thread.sleep(2000);
    }
    
    @Test
    public void testRegistrarArtista() throws Exception
    {
        boolean success = false;
        driver.findElement(By.id("botonRegistrarse")).click();
        Thread.sleep(1000);
        
        driver.findElement(By.id("registrarseUsuario")).clear();
        driver.findElement(By.id("registrarseUsuario")).sendKeys("Meili");
        Thread.sleep(1000);
        
        driver.findElement(By.id("registrarseClave")).clear();
        driver.findElement(By.id("registrarseClave")).sendKeys("Meili");
        Thread.sleep(1000);
        
        driver.findElement(By.id("registrarseNombre")).clear();
        driver.findElement(By.id("registrarseNombre")).sendKeys("Meili");
        Thread.sleep(1000);
        
        driver.findElement(By.id("registrarseCedula")).clear();
        driver.findElement(By.id("registrarseCedula")).sendKeys("1020793576");
        Thread.sleep(1000);
        
        driver.findElement(By.id("registrarseCorreo")).clear();
        driver.findElement(By.id("registrarseCorreo")).sendKeys("m.vanegas10@uniandes.edu.co");
        Thread.sleep(1000);
        
        driver.findElement(By.id("registrarseDireccion")).clear();
        driver.findElement(By.id("registrarseDireccion")).sendKeys("Calle 1");
        Thread.sleep(1000);
        
        driver.findElement(By.id("registrarseTelefono")).clear();
        driver.findElement(By.id("registrarseTelefono")).sendKeys("3191919");
        Thread.sleep(1000);
        
        driver.findElement(By.id("registrarseFoto")).clear();
        driver.findElement(By.id("registrarseFoto")).sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\Faro.jpg");
        Thread.sleep(1000);
        
        driver.findElement(By.id("registrarseDescripcion")).clear();
        driver.findElement(By.id("registrarseDescripcion")).sendKeys("Artista");
        Thread.sleep(1000);
        
        success = true;
        
        assertTrue(success);

    }
    
    
}

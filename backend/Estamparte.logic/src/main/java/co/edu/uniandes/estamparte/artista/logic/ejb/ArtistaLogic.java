/*
 * Manejo de la BD de las estampas
 */
package co.edu.uniandes.estamparte.artista.logic.ejb;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;


//Esta clase es la que tiene conexión con la base de datos, por lo que todos los objetos que debe
//retornar son de tipo DTO, que es el objeto de transferencia de la información

//Para convertir objetos de java a objetos DTO se usa el converter 

public class ArtistaLogic {
    
    //Es una interfaz, maneja las operaciones de persistencia en los objetos
    @PersistenceContext(unitName = "SportClassPU")
    //Es a través del Entity Manager que se crean consultas, se insertan datos, se actualizan datos, etc
    protected EntityManager em;
    
    
    
}

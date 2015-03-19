/*
 * Entidad de estampa
 */
package co.edu.uniandes.estamparte.artista.logic.entity;

import co.edu.uniandes.estamparte.camiseta.logic.entity.*;
import co.edu.uniandes.estamparte.estampa.logic.entity.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//Se declara como una entidad
@Entity

public class ArtistaEntity {
    
    @Id
    @GeneratedValue(generator = "Artista")
    private String id;
    
    
}

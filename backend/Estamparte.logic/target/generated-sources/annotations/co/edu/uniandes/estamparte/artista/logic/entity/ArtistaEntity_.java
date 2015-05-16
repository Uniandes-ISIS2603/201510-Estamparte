package co.edu.uniandes.estamparte.artista.logic.entity;

import co.edu.uniandes.estamparte.estampa.logic.entity.EstampaEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-03-26T11:03:37")
@StaticMetamodel(ArtistaEntity.class)
public class ArtistaEntity_ { 

    public static volatile SingularAttribute<ArtistaEntity, Long> id;
    public static volatile SingularAttribute<ArtistaEntity, String> nombre;
    public static volatile SingularAttribute<ArtistaEntity, String> contrasenha;
    public static volatile SingularAttribute<ArtistaEntity, String> usuario;
    public static volatile SingularAttribute<ArtistaEntity, String> descripcion;
    public static volatile ListAttribute<ArtistaEntity, EstampaEntity> estampas;
    public static volatile SingularAttribute<ArtistaEntity, String> cedula;
    public static volatile SingularAttribute<ArtistaEntity, String> correo;
    public static volatile SingularAttribute<ArtistaEntity, String> imagenPerfil;

}
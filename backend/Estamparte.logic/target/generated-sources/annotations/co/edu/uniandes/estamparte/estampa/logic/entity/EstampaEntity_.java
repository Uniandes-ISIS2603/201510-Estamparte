package co.edu.uniandes.estamparte.estampa.logic.entity;

import co.edu.uniandes.estamparte.artista.logic.entity.ArtistaEntity;
import co.edu.uniandes.estamparte.camiseta.logic.entity.CamisetaEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-03-26T11:03:36")
@StaticMetamodel(EstampaEntity.class)
public class EstampaEntity_ { 

    public static volatile SingularAttribute<EstampaEntity, Long> id;
    public static volatile SingularAttribute<EstampaEntity, String> nombre;
    public static volatile ListAttribute<EstampaEntity, CamisetaEntity> camisetas;
    public static volatile SingularAttribute<EstampaEntity, String> imagen;
    public static volatile SingularAttribute<EstampaEntity, Double> precio;
    public static volatile SingularAttribute<EstampaEntity, ArtistaEntity> duenho;
    public static volatile SingularAttribute<EstampaEntity, String> descripcion;
    public static volatile SingularAttribute<EstampaEntity, Integer> noGusta;
    public static volatile SingularAttribute<EstampaEntity, String> tema;
    public static volatile SingularAttribute<EstampaEntity, Double> ancho;
    public static volatile SingularAttribute<EstampaEntity, Integer> siGusta;
    public static volatile SingularAttribute<EstampaEntity, Double> altura;

}
package co.edu.uniandes.estamparte.camiseta.logic.entity;

import co.edu.uniandes.estamparte.carrito.logic.entity.CarritoEntity;
import co.edu.uniandes.estamparte.estampa.logic.entity.EstampaEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-03-26T11:03:37")
@StaticMetamodel(CamisetaEntity.class)
public class CamisetaEntity_ { 

    public static volatile SingularAttribute<CamisetaEntity, String> id;
    public static volatile SingularAttribute<CamisetaEntity, String> nombre;
    public static volatile SingularAttribute<CamisetaEntity, CarritoEntity> carroDuenio;
    public static volatile SingularAttribute<CamisetaEntity, String> color;
    public static volatile SingularAttribute<CamisetaEntity, String> estilo;
    public static volatile SingularAttribute<CamisetaEntity, String> talla;
    public static volatile SingularAttribute<CamisetaEntity, Double> costo;
    public static volatile ListAttribute<CamisetaEntity, EstampaEntity> estampas;

}
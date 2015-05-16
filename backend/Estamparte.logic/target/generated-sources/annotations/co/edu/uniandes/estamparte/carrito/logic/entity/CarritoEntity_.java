package co.edu.uniandes.estamparte.carrito.logic.entity;

import co.edu.uniandes.estamparte.camiseta.logic.entity.CamisetaEntity;
import co.edu.uniandes.estamparte.comprador.logic.entity.CompradorEntity;
import co.edu.uniandes.estamparte.factura.logic.entity.FacturaEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-03-26T11:03:37")
@StaticMetamodel(CarritoEntity.class)
public class CarritoEntity_ { 

    public static volatile ListAttribute<CarritoEntity, CamisetaEntity> camisetas;
    public static volatile SingularAttribute<CarritoEntity, FacturaEntity> factura;
    public static volatile SingularAttribute<CarritoEntity, CompradorEntity> comprador;
    public static volatile SingularAttribute<CarritoEntity, String> idCarrito;

}
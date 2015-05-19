package co.edu.uniandes.estamparte.factura.logic.entity;

import co.edu.uniandes.estamparte.carrito.logic.entity.CarritoEntity;
import co.edu.uniandes.estamparte.comprador.logic.entity.CompradorEntity;
import co.edu.uniandes.estamparte.formaPago.logic.entity.FormaPagoEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-03-26T11:03:37")
@StaticMetamodel(FacturaEntity.class)
public class FacturaEntity_ { 

    public static volatile SingularAttribute<FacturaEntity, Long> id;
    public static volatile SingularAttribute<FacturaEntity, FormaPagoEntity> formaPago;
    public static volatile SingularAttribute<FacturaEntity, CompradorEntity> comprador;
    public static volatile SingularAttribute<FacturaEntity, String> fechaCompra;
    public static volatile SingularAttribute<FacturaEntity, CarritoEntity> carrito;

}
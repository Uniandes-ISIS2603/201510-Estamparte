package co.edu.uniandes.estamparte.comprador.logic.entity;

import co.edu.uniandes.estamparte.carrito.logic.entity.CarritoEntity;
import co.edu.uniandes.estamparte.factura.logic.entity.FacturaEntity;
import co.edu.uniandes.estamparte.formaPago.logic.entity.FormaPagoEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-03-26T11:03:37")
@StaticMetamodel(CompradorEntity.class)
public class CompradorEntity_ { 

    public static volatile SingularAttribute<CompradorEntity, String> nombre;
    public static volatile SingularAttribute<CompradorEntity, String> id;
    public static volatile SingularAttribute<CompradorEntity, String> direccion;
    public static volatile SingularAttribute<CompradorEntity, String> usuario;
    public static volatile ListAttribute<CompradorEntity, FormaPagoEntity> formasPago;
    public static volatile SingularAttribute<CompradorEntity, Integer> telefono;
    public static volatile ListAttribute<CompradorEntity, FacturaEntity> facturas;
    public static volatile SingularAttribute<CompradorEntity, CarritoEntity> carrito;
    public static volatile SingularAttribute<CompradorEntity, String> clave;
    public static volatile SingularAttribute<CompradorEntity, String> correo;
    public static volatile SingularAttribute<CompradorEntity, Integer> cedula;

}
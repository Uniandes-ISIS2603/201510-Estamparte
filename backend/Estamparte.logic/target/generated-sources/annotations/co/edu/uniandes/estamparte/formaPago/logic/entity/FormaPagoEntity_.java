package co.edu.uniandes.estamparte.formaPago.logic.entity;

import co.edu.uniandes.estamparte.comprador.logic.entity.CompradorEntity;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-03-26T11:03:37")
@StaticMetamodel(FormaPagoEntity.class)
public class FormaPagoEntity_ { 

    public static volatile SingularAttribute<FormaPagoEntity, String> nombre;
    public static volatile SingularAttribute<FormaPagoEntity, String> direccionCorrespondencia;
    public static volatile SingularAttribute<FormaPagoEntity, Long> numeroTarjeta;
    public static volatile SingularAttribute<FormaPagoEntity, Date> fechaVencimiento;
    public static volatile SingularAttribute<FormaPagoEntity, Integer> codigoSeguridad;
    public static volatile SingularAttribute<FormaPagoEntity, CompradorEntity> comprador;

}
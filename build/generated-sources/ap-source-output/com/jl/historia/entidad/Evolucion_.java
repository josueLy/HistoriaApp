package com.jl.historia.entidad;

import com.jl.historia.entidad.Historia;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-19T10:10:41")
@StaticMetamodel(Evolucion.class)
public class Evolucion_ { 

    public static volatile SingularAttribute<Evolucion, String> descripcion;
    public static volatile SingularAttribute<Evolucion, Date> fecha;
    public static volatile SingularAttribute<Evolucion, Historia> historia;
    public static volatile SingularAttribute<Evolucion, Short> estado;
    public static volatile SingularAttribute<Evolucion, Integer> id;

}
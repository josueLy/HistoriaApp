package com.jl.historia.entidad;

import com.jl.historia.entidad.Historia;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-19T23:46:12")
@StaticMetamodel(Receta.class)
public class Receta_ { 

    public static volatile SingularAttribute<Receta, Date> fecha;
    public static volatile SingularAttribute<Receta, Historia> historia;
    public static volatile SingularAttribute<Receta, Short> estado;
    public static volatile SingularAttribute<Receta, String> medicinas;
    public static volatile SingularAttribute<Receta, Integer> id;

}
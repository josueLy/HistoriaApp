package com.jl.historia.entidad;

import com.jl.historia.entidad.Evolucion;
import com.jl.historia.entidad.Paciente;
import com.jl.historia.entidad.Receta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-11T20:10:28")
@StaticMetamodel(Historia.class)
public class Historia_ { 

    public static volatile SingularAttribute<Historia, String> codigoHistoria;
    public static volatile SingularAttribute<Historia, String> motivo;
    public static volatile SingularAttribute<Historia, Short> estado;
    public static volatile ListAttribute<Historia, Receta> recetas;
    public static volatile SingularAttribute<Historia, String> diagnostico;
    public static volatile SingularAttribute<Historia, String> enfermedadActual;
    public static volatile SingularAttribute<Historia, Integer> id;
    public static volatile SingularAttribute<Historia, Paciente> pacienteId;
    public static volatile ListAttribute<Historia, Evolucion> evoluciones;

}
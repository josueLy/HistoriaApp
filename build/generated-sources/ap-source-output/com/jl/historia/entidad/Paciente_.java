package com.jl.historia.entidad;

import com.jl.historia.entidad.Historia;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-11T20:10:28")
@StaticMetamodel(Paciente.class)
public class Paciente_ { 

    public static volatile SingularAttribute<Paciente, Short> estado;
    public static volatile SingularAttribute<Paciente, String> estaoCivil;
    public static volatile CollectionAttribute<Paciente, Historia> historiaCollection;
    public static volatile SingularAttribute<Paciente, Integer> id;
    public static volatile SingularAttribute<Paciente, String> sexo;
    public static volatile SingularAttribute<Paciente, String> nombre;
    public static volatile SingularAttribute<Paciente, Integer> edad;
    public static volatile SingularAttribute<Paciente, String> dni;

}
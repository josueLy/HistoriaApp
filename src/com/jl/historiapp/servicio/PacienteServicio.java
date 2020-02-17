//
package com.jl.historiapp.servicio;

import com.jl.historia.entidad.Paciente;
import com.jl.historiapp.dao.PacienteDao;
import java.util.List;

/**
 *
 * @author famleto
 */
public class PacienteServicio {
    PacienteDao pacientedao = new PacienteDao();
    
    public Paciente guardarPaciente(Paciente paciente){
        return pacientedao.guardarPaciente(paciente);
    }
    
    public List<Paciente> listarPacientes(){
        return pacientedao.listarPacientes();
    }
    
    public Paciente mostrarDatospaciente(int idPaciente){
        return pacientedao.mostrarDatosPaciente(idPaciente);
    }
    
    public List<Paciente> buscarPacientePorNombre(String codigoHistoria){
       return pacientedao.buscarPacientePorNombre(codigoHistoria);
    }
}

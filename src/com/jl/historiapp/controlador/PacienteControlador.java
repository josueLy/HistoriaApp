/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jl.historiapp.controlador;

import com.jl.historia.entidad.Paciente;
import com.jl.historiapp.servicio.PacienteServicio;
import java.util.List;

/**
 *
 * @author famleto
 */
public class PacienteControlador {
    PacienteServicio pacienteServicio = new PacienteServicio();
    
    public Paciente guardarPaciente(Paciente paciente){
       return pacienteServicio.guardarPaciente(paciente);
    }
    
    public List<Paciente> listarPacientes(){
       return pacienteServicio.listarPacientes();
    }
    
    public Paciente mostrarDatosPaciente(int idPaciente){
        return pacienteServicio.mostrarDatospaciente(idPaciente);
    }
    
    public List<Paciente> buscarPacientePorNombre(String codigoHistoria){
       return pacienteServicio.buscarPacientePorNombre(codigoHistoria);
    }
    
}

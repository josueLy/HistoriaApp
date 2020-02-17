/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jl.historiapp.controlador;

import com.jl.historia.entidad.Historia;
import com.jl.historia.entidad.Paciente;
import com.jl.historiapp.servicio.HistoriaServicio;
import java.util.List;

/**
 *
 * @author famleto
 */
public class HistoriaControlador {
    HistoriaServicio historiaServicio = new HistoriaServicio();
    
    public Historia guardarHistoria(Historia historia){
       return historiaServicio.guardarHistoria(historia);
    }
    
    public Historia mostrarHistoria(int idHistoria){
       return historiaServicio.mostrarHistoria(idHistoria);
    }
    
    public Historia mostrarDatosHistoriaPorPaciente(Paciente paciente){
        return historiaServicio.mostrarDatosHistoria(paciente);
    }
    
    public List<Historia> listarHistorias(){
        return historiaServicio.listarHistorias();
    }
    
    public List<Historia> buscarHistoriaPorCodigo(String codigoHistoria){
        return historiaServicio.buscarHistoriaPorCodigo(codigoHistoria);
    }
    
    public void eliminarHistoria(Historia historia){
        historiaServicio.eliminarHistoria(historia);
    }
}

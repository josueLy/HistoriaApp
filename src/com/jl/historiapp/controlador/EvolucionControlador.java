/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jl.historiapp.controlador;

import com.jl.historia.entidad.Evolucion;
import com.jl.historia.entidad.Historia;
import com.jl.historiapp.servicio.EvolucionServicio;
import java.util.Date;
import java.util.List;

/**
 *
 * @author famleto
 */
public class EvolucionControlador {
   EvolucionServicio evolucionServicio =new EvolucionServicio();
   
   public void guardarEvolucion(Evolucion evolucion){
       evolucionServicio.guardarEvolucion(evolucion);
   }
   
   public Evolucion obtenerEvolucionPorId(int idEvolucion){
       return evolucionServicio.obtenerEvolucionPorId(idEvolucion);
    }
   
   public Evolucion mostrarUltimaEvolucion(Historia historia){
       return evolucionServicio.mostrarUltimaEvolucion(historia);
   }
   
   public List<Evolucion> listarEvoluciones(Historia historia){
       return evolucionServicio.listarEvoluciones(historia);
   }
   
    public List<Evolucion> buscarRecetaPorFecha(Date fechaDesde, Date fechaHasta, Historia historia){
        return evolucionServicio.buscarRecetaPorFecha(fechaDesde, fechaHasta, historia);
    }
} 

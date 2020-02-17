/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jl.historiapp.controlador;

import com.jl.historia.entidad.Historia;
import com.jl.historia.entidad.Receta;
import com.jl.historiapp.servicio.RecetaServicio;
import java.util.Date;
import java.util.List;

/**
 *
 * @author famleto
 */
public class RecetaControlador {
    RecetaServicio recetaServicio = new RecetaServicio();
    
    public void guaradarReceta(Receta receta){
        recetaServicio.guardarReceta(receta);
    }
    public Receta mostrarUltimaReceta(Historia historia){
       return recetaServicio.mostrarUltimaReceta(historia);
   }
    
    public List<Receta> listarRecetas(Historia historia){
      return recetaServicio.listarRecetas(historia);
    }
    
    public Receta mostrarRecetaPorId(int idReceta){
      return recetaServicio.obtenerRecetaPorId(idReceta);
    }
    
    public List<Receta> buscarRecetaPorFecha(Date fechaDesde, Date fechaHasta,Historia historia){
      return recetaServicio.buscarRecetaPorFecha(fechaDesde, fechaHasta,historia);
    }
    
    
}

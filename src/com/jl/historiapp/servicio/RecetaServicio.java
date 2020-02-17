/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jl.historiapp.servicio;

import com.jl.historia.entidad.Historia;
import com.jl.historia.entidad.Receta;
import com.jl.historiapp.dao.RecetaDao;
import java.util.Date;
import java.util.List;

/**
 *
 * @author famleto
 */
public class RecetaServicio {
    RecetaDao recetaDao = new RecetaDao();
   public void guardarReceta(Receta receta){
       recetaDao.guardarReceta(receta);
   }
   
   public Receta mostrarUltimaReceta(Historia historia){
       return recetaDao.mostrarUltimaReceta(historia);
   }
   public Receta obtenerRecetaPorId(int idReceta){
       return recetaDao.obtenerRecetaPorId(idReceta);
   }
   public List<Receta> listarRecetas(Historia historia){
       return recetaDao.listarRecetas(historia);
   }
   
   public List<Receta> buscarRecetaPorFecha(Date fechaDesde, Date fechaHasta,Historia historia){
       return recetaDao.buscarRecetaPorFecha(fechaDesde, fechaHasta,historia);
   }
}

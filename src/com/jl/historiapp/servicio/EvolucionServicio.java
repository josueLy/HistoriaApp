/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jl.historiapp.servicio;

import com.jl.historia.entidad.Evolucion;
import com.jl.historia.entidad.Historia;
import com.jl.historiapp.dao.EvolucionDao;
import java.util.Date;
import java.util.List;

/**
 *
 * @author famleto
 */
public class EvolucionServicio {
    EvolucionDao evolucionDao = new EvolucionDao();
    
    public void guardarEvolucion(Evolucion evolucion){
        evolucionDao.guardarEvolucion(evolucion);
    }
    
    public Evolucion obtenerEvolucionPorId(int idEvolucion){
       return evolucionDao.obtenerEvolucionPorId(idEvolucion);
    }
    
    public Evolucion mostrarUltimaEvolucion(Historia historia){
       return evolucionDao.mostrarUltimaEvolucion(historia);
    }
    
    public List<Evolucion> listarEvoluciones(Historia historia){
        return evolucionDao.listarEvoluciones(historia);
    }
    
    public List<Evolucion> buscarRecetaPorFecha(Date fechaDesde, Date fechaHasta, Historia historia){
        return evolucionDao.buscarRecetaPorFecha(fechaDesde, fechaHasta,historia);
    }
}

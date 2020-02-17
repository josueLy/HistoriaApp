
package com.jl.historiapp.servicio;

import com.jl.historia.entidad.Historia;
import com.jl.historia.entidad.Paciente;
import com.jl.historiapp.dao.HistoriaDao;
import java.util.List;

/**
 *
 * @author famleto
 */
public class HistoriaServicio {
    HistoriaDao historiaDao = new HistoriaDao();
    
    public Historia guardarHistoria(Historia historia){
        return historiaDao.guardarHistoria(historia);
    }
    
    public Historia mostrarHistoria(int idHistoria){
        return historiaDao.mostrarHistoria(idHistoria);
    }
    
    public Historia mostrarDatosHistoria(Paciente paciente){
        return historiaDao.mostrarDatosHistoria(paciente);
    }
    
    public List<Historia> listarHistorias(){
        return historiaDao.listarHistoria();
    }
    
    public List<Historia> buscarHistoriaPorCodigo(String codigoHistoria){
        return historiaDao.buscarHistoriaPorCodigo(codigoHistoria);
    }
    
    public void eliminarHistoria(Historia historia){
         historiaDao.eliminarHistoria(historia);
    }
    
    
}

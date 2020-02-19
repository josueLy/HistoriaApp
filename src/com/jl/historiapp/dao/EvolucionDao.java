/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jl.historiapp.dao;

import com.jl.historia.entidad.Evolucion;
import com.jl.historia.entidad.Historia;
import com.jl.historia.entidad.Receta;
import com.jl.historiapp.utilitarios.ExcepcionGeneral;
import com.jl.historiapp.utilitarios.Mensaje;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author famleto
 */
public class EvolucionDao {

    EntityManagerFactory entidadFabrica = Persistence.createEntityManagerFactory("HistoriaAppPU");
    EntityManager gestorEntidad = entidadFabrica.createEntityManager();

    public void guardarEvolucion(Evolucion evolucion) {
        EntityTransaction entidadTransaccion = gestorEntidad.getTransaction();
        entidadTransaccion.begin();

        try {
            evolucion.setEstado(Short.valueOf("1"));
            evolucion.setFecha(new Date());
            gestorEntidad.persist(evolucion);
            gestorEntidad.flush();
            entidadTransaccion.commit();

        } catch (Exception excepcion) {
            System.out.println(excepcion.getMessage());
        }
    }

    public Evolucion obtenerEvolucionPorId(int idEvolucion) {
        Evolucion evolucion = new Evolucion();
        try {
            Query query = gestorEntidad.createQuery(
                    "SELECT e FROM Evolucion e where e.estado=1 and e.id= :id", Evolucion.class);
            query.setParameter("id", idEvolucion);
            evolucion = (Evolucion) query.getSingleResult();
            if(evolucion==null)
                throw new ExcepcionGeneral(Mensaje.EVOLUCION_NO_EXISTE);
        } catch (Exception excepcion) {
            System.out.println(excepcion.getMessage());
        }
        return evolucion;
    }
     

    public Evolucion mostrarUltimaEvolucion(Historia historia) {
        Evolucion evolucion = new Evolucion();
        try {
            Query query = gestorEntidad.createQuery(
                    "SELECT MAX(e.id) FROM Evolucion e where e.estado=1 and e.historia= :historia", Evolucion.class);
            query.setParameter("historia", historia);
            Integer id = (Integer) query.getSingleResult();
            query = gestorEntidad.createQuery("SELECT e FROM Evolucion e where e.id= :id");
            query.setParameter("id", id);
            evolucion = (Evolucion) query.getSingleResult();
//            if()
        } catch (Exception excepcion) {
            System.out.println(excepcion.getMessage());
        }
        return evolucion;
    }

    public List<Evolucion> listarEvoluciones(Historia historia) {
        List<Evolucion> evoluciones = new ArrayList<Evolucion>();
        try {
            Query query = gestorEntidad.createQuery(
                    "SELECT e FROM Evolucion e where e.estado=1 and e.historia= :historia ", Evolucion.class);
            query.setParameter("historia", historia);
            evoluciones = query.getResultList();
        } catch (Exception excepcion) {
            System.out.println(excepcion.getMessage());
        }
        return evoluciones;
    }
    
    public List<Evolucion> buscarRecetaPorFecha(Date fechaDesde, Date fechaHasta,Historia historia){
        List<Evolucion> evoluciones= new ArrayList<>();
        try{
            String consultaSql= "SELECT e FROM Evolucion e "
                    + "where e.fecha BETWEEN :startDate and :endDate  and e.historia = :historia";
            Query query = gestorEntidad.createQuery(consultaSql);
            query.setParameter("startDate", fechaDesde);
            query.setParameter("endDate", fechaHasta);
            query.setParameter("historia", historia);
           evoluciones = query.getResultList();
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return evoluciones;  
    }
}

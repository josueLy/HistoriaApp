/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jl.historiapp.dao;

import com.jl.historia.entidad.Historia;
import com.jl.historia.entidad.Receta;
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
public class RecetaDao {

    EntityManagerFactory entidadFabrica = Persistence.createEntityManagerFactory("HistoriaAppPU");
    EntityManager gestorEntidad = entidadFabrica.createEntityManager();

    public void guardarReceta(Receta receta) {
        EntityTransaction entidadTransaccion = gestorEntidad.getTransaction();
        entidadTransaccion.begin();

        try {
            receta.setEstado(Short.valueOf("1"));
            receta.setFecha(new Date());
            gestorEntidad.persist(receta);
            gestorEntidad.flush();
            entidadTransaccion.commit();

        } catch (Exception excepcion) {
            System.out.println(excepcion.getMessage());
        }
    }

    public Receta mostrarUltimaReceta(Historia idHistoria) {
        Receta receta = new Receta();
        try {
             Query query = gestorEntidad.createQuery(
                    "SELECT MAX(e.id) FROM Receta e where e.estado=1 and e.historia= :historia");
            query.setParameter("historia", idHistoria);
            Integer id=(Integer)query.getSingleResult();
            query = gestorEntidad.createQuery("SELECT e FROM Receta e where e.id= :id");
            query.setParameter("id", id);
            receta= (Receta) query.getSingleResult();
        } catch (Exception excepcion) {
            System.out.println(excepcion.getMessage());
        }
        return receta;

    }
    
    public Receta obtenerRecetaPorId(int idReceta){
        Receta receta = new Receta();
        try {
            Query query = gestorEntidad.createQuery(
                    "SELECT r FROM Receta r where r.estado=1 and r.id= :id", Receta.class);
            query.setParameter("id", idReceta);
            receta = (Receta) query.getSingleResult();
        } catch (Exception excepcion) {
            System.out.println(excepcion.getMessage());
        }
        return receta;
    }
    
    public List<Receta> listarRecetas(Historia historia){
         List<Receta> recetas = new ArrayList<Receta>();
        try {
            Query query = gestorEntidad.createQuery(
                    "SELECT r FROM Receta r where r.estado=1 and r.historia = :historia ",Receta.class);
            query.setParameter("historia",historia);
            recetas= query.getResultList();
        } catch (Exception excepcion) {
            System.out.println(excepcion.getMessage());
        }
        return recetas;
    }
    
    public List<Receta> buscarRecetaPorFecha(Date fechaDesde, Date fechaHasta,Historia historia){
        List<Receta> recetas= new ArrayList<>();
        try{
            String consultaSql= "SELECT r FROM Receta r "
                    + "where r.fecha BETWEEN :startDate and :endDate and r.historia= :historia ";
            Query query = gestorEntidad.createQuery(consultaSql);
            query.setParameter("startDate", fechaDesde);
            query.setParameter("endDate", fechaHasta);
            query.setParameter("historia",historia);
            
           recetas = query.getResultList();
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return recetas;  
    }
    

}

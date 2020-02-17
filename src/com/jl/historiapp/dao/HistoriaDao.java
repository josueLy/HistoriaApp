/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jl.historiapp.dao;

import com.jl.historia.entidad.Historia;
import com.jl.historia.entidad.Paciente;
import java.text.SimpleDateFormat;
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
public class HistoriaDao {

    EntityManagerFactory entidadFabrica = Persistence.createEntityManagerFactory("HistoriaAppPU");
    EntityManager gestorEntidad = entidadFabrica.createEntityManager();

    public Historia guardarHistoria(Historia historia) {
        EntityTransaction entidadTransaccion = gestorEntidad.getTransaction();
        entidadTransaccion.begin();

        try {
            String dni= historia.getPacienteId().getDni();
            String digitos=dni.substring(5);
            
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String fecha=formato.format(new Date());
            String [] date = fecha.split("/");
            String dia= date[0];
            String anio=date[2];
            String mes= date[1];
            
            String codigoHistoria=dia+mes+anio+digitos;
            historia.setCodigoHistoria(codigoHistoria);
            historia.setEstado(Short.valueOf("1"));
            gestorEntidad.persist(historia);
            gestorEntidad.flush();
            entidadTransaccion.commit();

        } catch (Exception excepcion) {
            System.out.println(excepcion.getMessage());
        }
        return historia;
    }
    
    public Historia mostrarHistoria(int idHistoria){
          Historia historia = new Historia();
        try{
            Query query = gestorEntidad.createQuery(
                    "SELECT h FROM Historia h where h.estado=1 and h.Id= : Id");
            query.setParameter("Id", idHistoria);
            historia=(Historia)query.getSingleResult();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return historia;
    }
    
    public Historia mostrarDatosHistoria(Paciente paciente){
          Historia historia = new Historia();
        try {
            Query query = gestorEntidad.createQuery(
                    "SELECT h FROM Historia h where h.estado=1 and h.pacienteId= :pacienteId");
            query.setParameter("pacienteId", paciente);
            historia=(Historia)query.getSingleResult();
            
        } catch (Exception excepcion) {
            System.out.println(excepcion.getMessage());
        }
        return historia;
    }
    
    public List<Historia> listarHistoria(){
    
        List<Historia> historias = new ArrayList<Historia>();
        try {
            Query query = gestorEntidad.createQuery(
                    "SELECT h FROM Historia h where h.estado=1 ",Historia.class);
            historias= query.getResultList();
        } catch (Exception excepcion) {
            System.out.println(excepcion.getMessage());
        }
        return historias;
    }
    
    public List<Historia> buscarHistoriaPorCodigo(String codigoHistoria){
        List<Historia> historias = new ArrayList<Historia>();
        try{
            Query query= gestorEntidad.createQuery("SELECT h from Historia h where h.codigoHistoria LIKE :codigo  and h.estado=1 ");
            query.setParameter("codigo", "%"+codigoHistoria+"%");
            historias= query.getResultList();
        }catch(Exception excepcion){
            System.out.println(excepcion.getMessage());
        }
        return historias;
    }
    
    public void eliminarHistoria(Historia historia){
    EntityTransaction entidadTransaccion = gestorEntidad.getTransaction();
        entidadTransaccion.begin();

        try {
            historia.setEstado(Short.valueOf("0"));
            gestorEntidad.persist(historia);
            gestorEntidad.flush();
            entidadTransaccion.commit();

        } catch (Exception excepcion) {
            System.out.println(excepcion.getMessage());
        }
    
    }
}

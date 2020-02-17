/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jl.historiapp.dao;

import com.jl.historia.entidad.Paciente;
import java.util.ArrayList;
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
public class PacienteDao {

    EntityManagerFactory entidadFabrica = Persistence.createEntityManagerFactory("HistoriaAppPU");
    EntityManager gestorEntidad = entidadFabrica.createEntityManager();

    public Paciente guardarPaciente(Paciente paciente) {
        EntityTransaction entidadTransaccion = gestorEntidad.getTransaction();
        entidadTransaccion.begin();

        try {
            paciente.setEstado(Short.valueOf("1"));
            gestorEntidad.persist(paciente);
            gestorEntidad.flush();
            entidadTransaccion.commit();

        } catch (Exception excepcion) {
            System.out.println(excepcion.getMessage());
        }
        return paciente;
    }

    public List<Paciente> listarPacientes() {
        List<Paciente> pacientes = new ArrayList<Paciente>();
        try {
            Query query = gestorEntidad.createQuery(
                    "SELECT p FROM Paciente p where p.estado=1 ",Paciente.class);
            pacientes= query.getResultList();
        } catch (Exception excepcion) {
            System.out.println(excepcion.getMessage());
        }
        return pacientes;
    }
    
    public Paciente mostrarDatosPaciente(int idPaciente){
        Paciente paciente = new Paciente();
        try {
            Query query = gestorEntidad.createQuery(
                    "SELECT p FROM Paciente p where p.estado=1 and p.id= :id",Paciente.class);
            query.setParameter("id", idPaciente);
            paciente=(Paciente)query.getSingleResult();
        } catch (Exception excepcion) {
            System.out.println(excepcion.getMessage());
        }
        return paciente;
    }
    
    public List<Paciente> buscarPacientePorNombre(String codigoHistoria){
        List<Paciente> historias = new ArrayList<Paciente>();
        try{
            Query query= gestorEntidad.createQuery("SELECT p from Paciente p where p.nombre LIKE :codigo  and p.estado=1 ");
            query.setParameter("codigo", "%"+codigoHistoria+"%");
            historias= query.getResultList();
        }catch(Exception excepcion){
            System.out.println(excepcion.getMessage());
        }
        return historias;
    }

}

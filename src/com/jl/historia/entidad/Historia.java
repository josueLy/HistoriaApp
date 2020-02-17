/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jl.historia.entidad;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author famleto
 */
@Entity
@Table(name = "Historia", catalog = "historiasdb", schema = "")
public class Historia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "codigoHistoria")
    private String codigoHistoria;
    @Basic(optional = false)
    @Column(name = "motivo")
    private String motivo;
    @Basic(optional = false)
    @Column(name = "enfermedad_actual")
    private String enfermedadActual;
    @Basic(optional = false)
    @Column(name = "diagnostico")
    private String diagnostico;
    @Basic(optional = false)
    @Column(name = "estado")
    private short estado;
    
    @JoinColumn(name = "pacienteId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Paciente pacienteId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "historia")
    private List<Receta> recetas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "historia")
    private List<Evolucion> evoluciones;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoHistoria() {
        return codigoHistoria;
    }

    public void setCodigoHistoria(String codigoHistoria) {
        this.codigoHistoria = codigoHistoria;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEnfermedadActual() {
        return enfermedadActual;
    }

    public void setEnfermedadActual(String enfermedadActual) {
        this.enfermedadActual = enfermedadActual;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    public Paciente getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Paciente pacienteId) {
        this.pacienteId = pacienteId;
    }

    public List<Receta> getReceta() {
        return recetas;
    }

    public void setReceta(List<Receta> recetas) {
        this.recetas = recetas;
    }

    @XmlTransient
    public List<Evolucion> getEvolucionCollection() {
        return evoluciones;
    }

    public void setEvolucionCollection(List<Evolucion> evoluciones) {
        this.evoluciones = evoluciones;
    }

   
}

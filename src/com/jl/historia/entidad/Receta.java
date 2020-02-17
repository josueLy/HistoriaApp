/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jl.historia.entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author famleto
 */
@Entity
@Table(name = "Receta", catalog = "historiasdb", schema = "")

public class Receta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Medicinas", nullable = false, length = 600)
    private String medicinas;
    @Basic(optional = false)
    @Column(name = "Fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "Estado", nullable = false)
    private short estado;
    @JoinColumn(name="HistoriaId", referencedColumnName="Id")
    @ManyToOne(optional=false)
    private Historia historia;

   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedicinas() {
        return medicinas;
    }

    public void setMedicinas(String medicinas) {
        this.medicinas = medicinas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    /**
     * @return the historias
     */
    public Historia getHistoria() {
        return historia;
    }

    /**
     * @param historias the historias to set
     */
    public void setHistorias(Historia historia) {
        this.historia = historia;
    }
    
}

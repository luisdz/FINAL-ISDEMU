/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Walter
 */

@Entity
@Table(name="TB_UBICACION_PERSONA"
    ,schema="dbo"
 )
public class TbUbicacionPersona {
    
     private int idUbicacionPersona;
     private TbcUbicacion tbcUbicacion;
     private TbcPersona tbcPersona;
     private String jefatura;
     private String encargadoAfijo;
    
     @Id 
    @GeneratedValue
    @Column(name="ID_UBICACION_PERSONA", unique=true, nullable=false)
    public int getIdUbicacionPersona() {
        return this.idUbicacionPersona;
    }
    public void setIdUbicacionPersona(int idUbicacionPersona) {
        this.idUbicacionPersona = idUbicacionPersona;
    }
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ID_UBICACION", nullable=false)
    public TbcUbicacion getTbcUbicacion() {
        return this.tbcUbicacion;
    }
    
    public void setTbcUbicacion(TbcUbicacion tbcUbicacion) {
        this.tbcUbicacion = tbcUbicacion;
    }
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ID_PERSONA", nullable=false)
    public TbcPersona getTbcPersona() {
        return this.tbcPersona;
    }
    
    public void setTbcPersona(TbcPersona tbcPersona) {
        this.tbcPersona = tbcPersona;
    }
    
    @Column(name="JEFATURA", length=100)
    public String getJefatura() {
        return this.jefatura;
    }
    
    public void setJefatura(String jefatura) {
        this.jefatura = jefatura;
    }

    
    @Column(name="ENCARGADO_AFIJO", length=100)
    public String getEncargadoAfijo() {
        return this.encargadoAfijo;
    }
    
    public void setEncargadoAfijo(String encargadoAfijo) {
        this.encargadoAfijo = encargadoAfijo;
    }
}

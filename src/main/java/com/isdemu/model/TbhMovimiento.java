/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jose Eduardo
 */
@Entity
@Table(name="TBH_MOVIMIENTO"
    ,schema="dbo"
   
)
public class TbhMovimiento {
    
     private int idMovimientoh;
     private String codigoInventario;
     private String personaAnterior;
     private String personaActual;     
     private String descripcionEquipo;
     private Date fechaMovimiento;
      private Integer idMovimiento;
    
     
     
     @Id 

    @GeneratedValue
    @Column(name="ID_MOVIMIENTOH", unique=true, nullable=false)
    public int getIdMovimientoh() {
        return this.idMovimientoh;
    }
    
    public void setIdMovimientoh(int idMovimientoh) {
        this.idMovimientoh = idMovimientoh;
    }
    @Column(name="DESCRIPCION_EQUIPO", nullable=true, length=1024)
    public String getDescripcionEquipo() {
        return descripcionEquipo;
    }

    public void setDescripcionEquipo(String descripcionEquipo) {
        this.descripcionEquipo = descripcionEquipo;
    }
     

    
    @Column(name="CODIGO_INVENTARIO", nullable=false, length=1024)
    public String getCodigoInventario() {
        return this.codigoInventario;
    }
    
    public void setCodigoInventario(String codigoInventario) {
        this.codigoInventario = codigoInventario;
    }

    
    @Column(name="PERSONA_ANTERIOR", nullable=false, length=1024)
    public String getPersonaAnterior() {
        return this.personaAnterior;
    }
    
    public void setPersonaAnterior(String personaAnterior) {
        this.personaAnterior = personaAnterior;
    }

    
    @Column(name="PERSONA_ACTUAL", nullable=false, length=1024)
    public String getPersonaActual() {
        return this.personaActual;
    }
    
    public void setPersonaActual(String personaActual) {
        this.personaActual = personaActual;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHA_MOVIMIENTO", nullable=false, length=10)
    public Date getFechaMovimiento() {
        return this.fechaMovimiento;
    }
    
    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

        @Column(name="ID_MOVIMIENTO")
    public Integer getIdMovimiento() {
        return this.idMovimiento;
    }
    
    public void setIdMovimiento(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }
}

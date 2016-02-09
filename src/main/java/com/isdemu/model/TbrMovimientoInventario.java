/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Jose Eduardo
 */

@Entity
@Table(name="TBR_MOVIMIENTO_INVENTARIO"
    ,schema="dbo"
   
)
public class TbrMovimientoInventario {
    private int idMovimientoInventario;
     private TbMovimiento tbMovimiento;
     private TbInventario tbInventario;
     private Integer idPersonaNueva;
     private Integer idPersonaAnterior;
     private Integer idUbicacionNueva;
     private Integer idUbicacionAnterior;
     
      
 @Id 
@GeneratedValue
    
    @Column(name="ID_MOVIMIENTO_INVENTARIO", unique=true, nullable=false)
    public int getIdMovimientoInventario() {
        return this.idMovimientoInventario;
    }
    
    public void setIdMovimientoInventario(int idMovimientoInventario) {
        this.idMovimientoInventario = idMovimientoInventario;
    }
    
    @Column(name="ID_UBICACION_NUEVA")
    public Integer getIdUbicacionNueva() {
        return idUbicacionNueva;
    }
    
    public void setIdUbicacionNueva(Integer idUbicacionNueva) {
        this.idUbicacionNueva = idUbicacionNueva;
    }
    @Column(name="ID_UBICACION_ANTERIOR")
    public Integer getIdUbicacionAnterior() {
        return idUbicacionAnterior;
    }

    public void setIdUbicacionAnterior(Integer idUbicacionAnterior) {
        this.idUbicacionAnterior = idUbicacionAnterior;
    }
     

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ID_MOVIMIENTO")
    public TbMovimiento getTbMovimiento() {
        return this.tbMovimiento;
    }
    
    public void setTbMovimiento(TbMovimiento tbMovimiento) {
        this.tbMovimiento = tbMovimiento;
    }

   @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ID_INVENTARIO") 
   // @Column(name="ID_INVENTARIO")
    public TbInventario getTbInventario() {
        return this.tbInventario;
    }
    
    public void setTbInventario(TbInventario tbInventario) {
        this.tbInventario = tbInventario;
    }

     @Column(name="ID_PERSONA_NUEVA")
    public Integer getIdPersonaNueva() {
        return this.idPersonaNueva;
    }
    
    public void setIdPersonaNueva(Integer idPersonaNueva) {
        this.idPersonaNueva = idPersonaNueva;
    }

    
    @Column(name="ID_PERSONA_ANTERIOR")
    public Integer getIdPersonaAnterior() {
        return this.idPersonaAnterior;
    }
    
    public void setIdPersonaAnterior(Integer idPersonaAnterior) {
        this.idPersonaAnterior = idPersonaAnterior;
    }


}



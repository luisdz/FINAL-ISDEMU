/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.model;

import java.io.Serializable;
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
 * @author Jose Eduardo
 */
@Entity
@Table(name = "TB_INVENTARIO", schema = "dbo")
public class TbInventario implements Serializable {
    
     private int idInventario;
     private TbcClaseActivo tbcClaseActivo;
     private TbcEstadoInventario tbcEstadoInventario;
     private TbcPersona tbcPersona;
     private TbcProveedor tbcProveedor;
     private TbcUbicacion tbcUbicacion;
     private Integer idPersonaAsignado;
     private Integer idLocalizacion;
     private String descripcionEquipo;
     private String codigoInventario;
     private String marca;
     private String modelo;
     private String serie;
     private Date fechaAdquisicion;
     private BigDecimal valor;
     private String NFactura;
     private String financiamiento;
     private String observacion;
     private BigDecimal valorLibro;
     private Date fechaGarantia;
     private Integer userInsert;
     private Date fechaInsert;
     private Integer userUpdate;
     private Date fechaUpdate;

    
      @Id 
 @GeneratedValue
    
    @Column(name="ID_INVENTARIO", unique=true, nullable=false)
    public int getIdInventario() {
        return this.idInventario;
    }
    
    
    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ID_CLASE_ACTIVO", nullable=false)
    public TbcClaseActivo getTbcClaseActivo() {
        return this.tbcClaseActivo;
    }
    
    public void setTbcClaseActivo(TbcClaseActivo tbcClaseActivo) {
        this.tbcClaseActivo = tbcClaseActivo;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ID_ESTADO")
    public TbcEstadoInventario getTbcEstadoInventario() {
        return this.tbcEstadoInventario;
    }
    
    public void setTbcEstadoInventario(TbcEstadoInventario tbcEstadoInventario) {
        this.tbcEstadoInventario = tbcEstadoInventario;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ID_PERSONA", nullable=false)
    public TbcPersona getTbcPersona() {
        return this.tbcPersona;
    }
    
    public void setTbcPersona(TbcPersona tbcPersona) {
        this.tbcPersona = tbcPersona;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ID_PROVEEDOR")
    public TbcProveedor getTbcProveedor() {
        return this.tbcProveedor;
    }
    
    public void setTbcProveedor(TbcProveedor tbcProveedor) {
        this.tbcProveedor = tbcProveedor;
    }

    
    @Column(name="ID_PERSONA_ASIGNADO")
    public Integer getIdPersonaAsignado() {
        return this.idPersonaAsignado;
    }
    
    public void setIdPersonaAsignado(Integer idPersonaAsignado) {
        this.idPersonaAsignado = idPersonaAsignado;
    }

    @Column(name="ID_LOCALIZACION")  
    public Integer getIdLocalizacion() {
        return idLocalizacion;
    }

    public void setIdLocalizacion(Integer idLocalizacion) {
        this.idLocalizacion = idLocalizacion;
    }
    
    @Column(name="DESCRIPCION_EQUIPO", length=1024)
    public String getDescripcionEquipo() {
        return this.descripcionEquipo;
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

    
    @Column(name="MARCA", length=1024)
    public String getMarca() {
        return this.marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }

    
    @Column(name="MODELO", length=1024)
    public String getModelo() {
        return this.modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    
    @Column(name="SERIE", length=1024)
    public String getSerie() {
        return this.serie;
    }
    
    public void setSerie(String serie) {
        this.serie = serie;
    }

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name="FECHA_ADQUISICION", length=10)
    public Date getFechaAdquisicion() {
        return this.fechaAdquisicion;
    }
    
    public void setFechaAdquisicion(Date fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    
    @Column(name="VALOR", scale=4)
    public BigDecimal getValor() {
        return this.valor;
    }
    
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    
    @Column(name="N_FACTURA", length=1024)
    public String getNFactura() {
        return this.NFactura;
    }
    
    public void setNFactura(String NFactura) {
        this.NFactura = NFactura;
    }

    
    @Column(name="FINANCIAMIENTO", length=1024)
    public String getFinanciamiento() {
        return this.financiamiento;
    }
    
    public void setFinanciamiento(String financiamiento) {
        this.financiamiento = financiamiento;
    }

    
    @Column(name="OBSERVACION", length=1024)
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    
    @Column(name="VALOR_LIBRO", scale=4)
    public BigDecimal getValorLibro() {
        return this.valorLibro;
    }
    
    public void setValorLibro(BigDecimal valorLibro) {
        this.valorLibro = valorLibro;
    }

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name="FECHA_GARANTIA", length=10)
    public Date getFechaGarantia() {
        return this.fechaGarantia;
    }
    
    public void setFechaGarantia(Date fechaGarantia) {
        this.fechaGarantia = fechaGarantia;
    }

    
    @Column(name="USER_INSERT")
    public Integer getUserInsert() {
        return this.userInsert;
    }
    
    public void setUserInsert(Integer userInsert) {
        this.userInsert = userInsert;
    }

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name="FECHA_INSERT", length=10)
    public Date getFechaInsert() {
        return this.fechaInsert;
    }
    
    public void setFechaInsert(Date fechaInsert) {
        this.fechaInsert = fechaInsert;
    }

    
    @Column(name="USER_UPDATE")
    public Integer getUserUpdate() {
        return this.userUpdate;
    }
    
    public void setUserUpdate(Integer userUpdate) {
        this.userUpdate = userUpdate;
    }

    @Temporal(TemporalType.DATE)
     @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name="FECHA_UPDATE", length=10)
    public Date getFechaUpdate() {
        return this.fechaUpdate;
    }
    
    public void setFechaUpdate(Date fechaUpdate) {
        this.fechaUpdate = fechaUpdate;
    }
    
 
@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ID_UBICACION", nullable=true)
    public TbcUbicacion getTbcUbicacion() {
        return tbcUbicacion;
    }

    public void setTbcUbicacion(TbcUbicacion tbcUbicacion) {
        this.tbcUbicacion = tbcUbicacion;
    }

}



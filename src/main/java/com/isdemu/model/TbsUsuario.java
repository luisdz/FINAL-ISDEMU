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
@Table(name="TBS_USUARIO"
    ,schema="dbo"
 )
public class TbsUsuario {

    @Id 
    @GeneratedValue
    
    @Column(name="ID_USUARIO", unique=true, nullable=false)
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Column(name="NOMBRES", length=1024)
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    @Column(name="APELLIDOS", length=1024)
    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    @Column(name="USUARIO", length=1024)
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Column(name="CLAVE", length=1024)
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Column(name="ESTADO")
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ROL", nullable=false)
    public TbsRol getTbsRol() {
        return tbsRol;
    }

    public void setTbsRol(TbsRol tbsRol) {
        this.tbsRol = tbsRol;
    }
    
    private int idUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String usuario;
    private String clave;
    private int estado;    
    private TbsRol tbsRol;
    
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.springboot.domain;

import java.util.Date;

/**
 *
 * @author Java-LM
 */
public class Categoria {
    
    private Long id;
    private String nombre;
    private String descripcion;
    private Date fechaCreacion;
    private Long idUsuarioCreacion;
    private Date fechaUltimaActualizacion;
    private Long idUsuarioUltimaActualizacion;

    public Categoria() {
    }

    public Categoria(Long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Long getIdUsuarioCreacion() {
        return idUsuarioCreacion;
    }

    public void setIdUsuarioCreacion(Long idUsuarioCreacion) {
        this.idUsuarioCreacion = idUsuarioCreacion;
    }

    public Date getFechaUltimaActualizacion() {
        return fechaUltimaActualizacion;
    }

    public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }

    public Long getIdUsuarioUltimaActualizacion() {
        return idUsuarioUltimaActualizacion;
    }

    public void setIdUsuarioUltimaActualizacion(Long idUsuarioUltimaActualizacion) {
        this.idUsuarioUltimaActualizacion = idUsuarioUltimaActualizacion;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Julián Parra
 * @author Germán García
 */
@Table
@Entity
@NamedQueries({
    @NamedQuery(name = "consulta", query = "SELECT e FROM Estudiante e JOIN e.listaClase c WHERE c.id_clase = :id_clase")
})
public class Estudiante implements Serializable{
    /**
     * Varialbe id_estudiante
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_estudiante;
    /**
     * Varialbe nombre
     */
    @Column
    private String nombre;
    /**
     * Varialbe cedula
     */
    @Column
    private long cedula;
    /**
     * Varialbe List<Clase> listaClase
     */
    @ManyToMany(mappedBy = "listaEstudiante")
    private List<Clase> listaClase;
    
    public Estudiante(){
    
    }

    public Estudiante(String nombre, long cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    
    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public List<Clase> getListaClase() {
        return listaClase;
    }

    public void setListaClase(List<Clase> listaClase) {
        this.listaClase = listaClase;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author DaveHell
 */
@Entity
@Table
public class Clase implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_clase;
    
    @Column
    private String nombreclase;
    
    @Column
    private int duracion;
    
    
    @JoinTable(name = "estudiante_clase", 
            joinColumns = @JoinColumn(name = "id_clase", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_estudiante", nullable = false)
            )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Estudiante> listaEstudiante;
    
    public Clase(){
    }

    public Clase(String nombreclase, int duracion) {
        this.nombreclase = nombreclase;
        this.duracion = duracion;
    }

    public int getId_clase() {
        return id_clase;
    }

    public void setId_clase(int id_clase) {
        this.id_clase = id_clase;
    }

    public String getNombreclase() {
        return nombreclase;
    }

    public void setNombreclase(String nombreclase) {
        this.nombreclase = nombreclase;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public List<Estudiante> getListaEstudiante() {
        return listaEstudiante;
    }

    public void setListaEstudiante(List<Estudiante> listaEstudiante) {
        this.listaEstudiante = listaEstudiante;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author DaveHell
 */
@Table
@Entity
@NamedQueries({
    @NamedQuery(name = "consultaV", query = "SELECT e.nombre, e.cedula, c.nombreclase FROM Estudiante e JOIN e.listaClase c WHERE c.id_clase = :id_clase")
})
public class Vista implements Serializable{
    
    @Column
    @Id
    private String estudiante;
    @Column
    private int cedula;
    @Column
    private String clase;

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }
    
    public Vista(){
    }

    public Vista(String estudiante, int cedula, String clase) {
        this.estudiante = estudiante;
        this.cedula = cedula;
        this.clase = clase;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }
    
    
    
}

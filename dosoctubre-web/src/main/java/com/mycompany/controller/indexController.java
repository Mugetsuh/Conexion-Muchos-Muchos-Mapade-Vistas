/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.entity.Clase;
import com.mycompany.entity.Estudiante;
import com.mycompany.entity.Vista;
import com.mycompany.interfaces.IClaseFacade;
import com.mycompany.interfaces.IVistaFacade;
import com.mycompany.interfaces.IEstudianteFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author DaveHell
 */
@Named(value = "indexController")
@RequestScoped
public class indexController implements Serializable{
    
    @EJB
    private IEstudianteFacade estudianteFacade;
    
    @EJB
    private IClaseFacade claseFacade;
    
    @EJB
    private IVistaFacade vistaFecade;
    
    private String nombreEstudiante;
    private Long claveEstudiante;
    private String nombreClase;
    private int duracionClase;
    private List<Estudiante> listaEst;
    private List<Clase> listaClas;
    private int estSeleccionado;
    private int clasSeleccionado;

    public int getClasSeleccionado() {
        return clasSeleccionado;
    }

    public void setClasSeleccionado(int clasSeleccionado) {
        this.clasSeleccionado = clasSeleccionado;
    }
    
    

    public int getEstSeleccionado() {
        return estSeleccionado;
    }

    public void setEstSeleccionado(int estSeleccionado) {
        this.estSeleccionado = estSeleccionado;
    }
    
    
    
    public List<Clase> getListaClas() {
        return listaClas;
    }

    public void setListaClas(List<Clase> listaClas) {
        this.listaClas = listaClas;
    }
   

    public List<Estudiante> getListaEst() {
        return listaEst;
    }

    public void setListaEst(List<Estudiante> listaEst) {
        this.listaEst = listaEst;
    }
    
    

    public indexController(String nombreEstudiante, Long claveEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
        this.claveEstudiante = claveEstudiante;
        
    }

    public indexController(String nombreClase, int duracionClase) {
        this.nombreClase = nombreClase;
        this.duracionClase = duracionClase;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public Long getClaveEstudiante() {
        return claveEstudiante;
    }

    public void setClaveEstudiante(Long claveEstudiante) {
        this.claveEstudiante = claveEstudiante;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    public int getDuracionClase() {
        return duracionClase;
    }

    public void setDuracionClase(int duracionClase) {
        this.duracionClase = duracionClase;
    }

    public IEstudianteFacade getEstudianteFacade() {
        return estudianteFacade;
    }

    public void setEstudianteFacade(IEstudianteFacade estudianteFacade) {
        this.estudianteFacade = estudianteFacade;
    }

    public IClaseFacade getClaseFacade() {
        return claseFacade;
    }

    public void setClaseFacade(IClaseFacade claseFacade) {
        this.claseFacade = claseFacade;
    }
    
    
    
    /**
     * Creates a new instance of indexController
     */
    public indexController() {
        vistaLsta = new ArrayList<>();
    }
    
    public void crearEstudiante(){
        Estudiante estudiante = new Estudiante(getNombreEstudiante(), getClaveEstudiante());
        System.out.println("datos" + getNombreEstudiante());
        estudianteFacade.create(estudiante);
        
        
    }
    
    @PostConstruct
    public void verestudiantes(){
        listaEst = estudianteFacade.findAll();
        listaClas = claseFacade.findAll();
        
    }
    
    public void crearClase(){
        Clase clase = new Clase(getNombreClase(), getDuracionClase());
        claseFacade.create(clase);
    }
    
    public void crearEstudianteClase(){
        Estudiante estudiante = new Estudiante("Julian", 101123123);
        Clase clase = new Clase("Español", 4);
        
        List<Estudiante> listaEstudiante = new ArrayList<>();
        List<Clase> listaClase = new ArrayList<>();
        
        listaEstudiante.add(estudiante);
        listaClase.add(clase);
        
        estudiante.setListaClase(listaClase);
        clase.setListaEstudiante(listaEstudiante);
        
        claseFacade.create(clase);
    }
    
    public void crearEstudianteClaseExistente(){
        Clase clase = claseFacade.find(clasSeleccionado);
        Estudiante estudiante = estudianteFacade.find(estSeleccionado);
        clase.getListaEstudiante().add(estudiante);
        estudiante.getListaClase().add(clase);
        claseFacade.edit(clase);
        
    }
    
    public void filtroEstudiantes(ValueChangeEvent event) {
        if (event.getNewValue() != "0") {
            listaEst = estudianteFacade.descartar((int) event.getNewValue());
            verVista((int) event.getNewValue());
        } else {
            //obtenerEstudiantes();
            //listaPorMaterias.clear();
        }
    }
    
    public void verVista(int id_clase){
        vistaLsta = vistaFecade.obtenerEstudiantesConStore(id_clase);
        
    }
    
    private List<Vista> vistaLsta;

    public List<Vista> getVistaLsta() {
        return vistaLsta;
    }

    public void setVistaLsta(List<Vista> vistaLsta) {
        this.vistaLsta = vistaLsta;
    }
    
    
    
    
    
}

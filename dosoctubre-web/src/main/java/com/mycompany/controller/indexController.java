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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

/**
 * @author Julián Parra
 * @author Germán García
 */
@Named(value = "indexController")
@RequestScoped
public class indexController implements Serializable{
    /**
     * Varialbe del ejb estudiante fecade
     */
    @EJB
    private IEstudianteFacade estudianteFacade;
    /**
     * Varialbe del ejb clase fecade
     */
    @EJB
    private IClaseFacade claseFacade;
    /**
     * Varialbe del ejb vista fecade
     */
    @EJB
    private IVistaFacade vistaFecade;
    /**
     * Variable nombreEstudiante
     */
    private String nombreEstudiante;
    /**
     * Variable claveEstudiante
     */
    private Long claveEstudiante;
    /**
     * Variable nombreClase
     */
    private String nombreClase;
    /**
     * Variable nombreEstudiante
     */
    private int duracionClase;
    /**
     * Variable List<Estudiante> listaEst
     */
    private List<Estudiante> listaEst;
    /**
     * Variable List<Clase> listaClas
     */
    private List<Clase> listaClas;
    /**
     * Variable estSeleccionado
     */
    private int estSeleccionado;
    /**
     * Variable clasSeleccionado
     */
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
    
    
    /**
     * Metodo Constructor
     * @param nombreEstudiante
     * @param claveEstudiante
     */
    public indexController(String nombreEstudiante, Long claveEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
        this.claveEstudiante = claveEstudiante;
        
    }
    /**
     * Metodo Constructor
     * @param nombreClase
     * @param duracionClase
     */
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
    /**
     * Metodo para crear Estudiantes
     */
    public void crearEstudiante(){
        Estudiante estudiante = new Estudiante(getNombreEstudiante(), getClaveEstudiante());
        System.out.println("datos" + getNombreEstudiante());
        estudianteFacade.create(estudiante);
        FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado", 
            "Estudiante " + nombreEstudiante + "Agregado con Exito!"));
        this.nombreEstudiante = null;
        this.claveEstudiante = null;
    }
    /**
     * Metodo postcontruct para ver la lista de estudiantes
     */
    @PostConstruct
    public void verestudiantes(){
        listaEst = estudianteFacade.findAll();
        listaClas = claseFacade.findAll();
        
    }
    /**
     * Metodo para crear clase
     */
    public void crearClase(){
        Clase clase = new Clase(getNombreClase(), getDuracionClase());
        claseFacade.create(clase);
        FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregada", 
            "Clase " + nombreClase + "Agregado con Exito!"));
        
        this.nombreClase = null;
        this.duracionClase = 0;    
    }
    /**
     * Metodo para crear estudiante clase por consola
     */
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
    /**
     * Metodo para crear estudiante seleccionado
     */
    public void crearEstudianteClaseExistente(){
        Clase clase = claseFacade.find(clasSeleccionado);
        Estudiante estudiante = estudianteFacade.find(estSeleccionado);
        clase.getListaEstudiante().add(estudiante);
        estudiante.getListaClase().add(clase);
        claseFacade.edit(clase);
        
        FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregada", 
            "Clase Estudiante" + nombreClase + nombreEstudiante + "Agregado con Exito!"));
        
    }
    /**
     * Metodo para filtrar estudiantes
     * @param event
     */
    public void filtroEstudiantes(ValueChangeEvent event) {
        if (event.getNewValue() != "0") {
            listaEst = estudianteFacade.descartar((int) event.getNewValue());
            verVista((int) event.getNewValue());
        }
    }
    /**
     * Metodo para ver la lista de la vista del mapeo
     * @param id_clase
     */
    public void verVista(int id_clase){
        vistaLsta = vistaFecade.obtenerEstudiantesConStore(id_clase);
        
    }
    /**
     * Variable List<Vista> vistaLsta;
     */
    private List<Vista> vistaLsta;

    public List<Vista> getVistaLsta() {
        return vistaLsta;
    }

    public void setVistaLsta(List<Vista> vistaLsta) {
        this.vistaLsta = vistaLsta;
    }
    
    
    
    
    
}

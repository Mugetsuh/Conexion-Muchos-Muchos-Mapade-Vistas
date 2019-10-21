/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.interfaces.IClaseFacade;
import com.mycompany.entity.Clase;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Julián Parra
 * @author Germán García
 */
@Stateless
public class ClaseFacade extends AbstractFacade<Clase> implements IClaseFacade {

    @PersistenceContext(unitName = "Estclase_UN")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClaseFacade() {
        super(Clase.class);
    }

    /**
     * Metodo para agregar la union de clase a estudiante
     * @param id_clase
     * @param id_estudiante
     */
    @Override
    public void edit(int id_clase, int id_estudiante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

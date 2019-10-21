/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.interfaces.IVistaFacade;
import com.mycompany.entity.Vista;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * @author Julián Parra
 * @author Germán García
 */
@Stateless
public class VistaFacade extends AbstractFacade<Vista> implements IVistaFacade {

    @PersistenceContext(unitName = "Estclase_UN")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VistaFacade() {
        super(Vista.class);
    }

    /**
     * Metodo para obtener estudiantes por consulta a la vista
     * @param id
     * @return 
     */
    @Override
    public List<Vista> obtenerEstudiantesConStore(Integer id) {
        TypedQuery<Vista> consulta = em.createNamedQuery("consultaV", Vista.class);
        consulta.setParameter("id_clase", id);
        List<Vista> listaEnt = (List<Vista>) consulta.getResultList();
        List<Vista> listaGeneral = new ArrayList();
        Iterator itr = listaEnt.iterator();
        while (itr.hasNext()) {
            Object[] obj = (Object[]) itr.next();
            Vista inf = new Vista(String.valueOf(obj[0]), Integer.parseInt(String.valueOf(obj[1])), String.valueOf(obj[2]));
            listaGeneral.add(inf);
        }
        return listaGeneral;
    }

}

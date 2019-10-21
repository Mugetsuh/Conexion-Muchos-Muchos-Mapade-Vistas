/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.interfaces.IEstudianteFacade;
import com.mycompany.entity.Estudiante;
import java.util.ArrayList;
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
public class EstudianteFacade extends AbstractFacade<Estudiante> implements IEstudianteFacade {

    @PersistenceContext(unitName = "Estclase_UN")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudianteFacade() {
        super(Estudiante.class);
    }

    /**
     * Metodo para filtrar estudiantes 
     * @param id_clase
     * @return 
     */
    @Override
    public List<Estudiante> descartar(int id_clase) {
        List<Estudiante> listaCompleta = findAll();
        TypedQuery<Estudiante> consulta = em.createNamedQuery("consulta", Estudiante.class);
        consulta.setParameter("id_clase", id_clase);
        List<Estudiante> listaPorMaterias = consulta.getResultList();
        List<Estudiante> lisTemporal = new ArrayList();
        if (listaCompleta.size() > listaPorMaterias.size()) {
            for (Estudiante general : listaCompleta) {
                if (!listaPorMaterias.contains(general)) {
                    lisTemporal.add(general);
                }
            }
        } else {
            for (Estudiante xMaterias : listaPorMaterias) {
                if (!listaCompleta.contains(xMaterias)) {
                    lisTemporal.add(xMaterias);
                }
            }
        }
        return lisTemporal;
    }
}

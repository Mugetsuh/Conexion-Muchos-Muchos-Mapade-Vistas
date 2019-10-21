/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.entity.Estudiante;
import java.util.List;
import javax.ejb.Local;

/**
 * @author Julián Parra
 * @author Germán García
 */
@Local
public interface IEstudianteFacade {

    void create(Estudiante estudiante);

    void edit(Estudiante estudiante);

    void remove(Estudiante estudiante);

    Estudiante find(Object id);

    List<Estudiante> findAll();

    List<Estudiante> findRange(int[] range);

    int count();
    
    List<Estudiante> descartar(int id_clase);
    
}

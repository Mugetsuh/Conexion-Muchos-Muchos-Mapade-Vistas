/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.entity.Clase;
import java.util.List;
import javax.ejb.Local;

/**
 * @author Julián Parra
 * @author Germán García
 */
@Local
public interface IClaseFacade {

    void create(Clase clase);

    void edit(Clase clase);

    void remove(Clase clase);

    Clase find(Object id);

    List<Clase> findAll();

    List<Clase> findRange(int[] range);

    int count();

    public void edit(int id_clase, int id_estudiante);

    
    
}

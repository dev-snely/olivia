/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.occupation;

import com.model.entities.Etudiant;
import com.model.entities.Occupation;
import java.util.Date;
import java.util.List;

/**
 *
 * @author gabri
 */
public interface OccupationDao {
    List<Occupation> findAll();

    Occupation findById(int id);

   List<Occupation> findByDateDebut(String date);
   List<Occupation> findByDateFin(String date);
    boolean create(Occupation ocup,Etudiant etu);

    boolean delete(int id);

    boolean update(Occupation ocup);
}

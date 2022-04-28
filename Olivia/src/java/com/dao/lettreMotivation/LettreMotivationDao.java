/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.lettreMotivation;

import com.model.entities.Etudiant;
import com.model.entities.LettreMotivation;
import java.util.List;

/**
 *
 * @author gabri
 */
public interface LettreMotivationDao {
    List<LettreMotivation> findAll();

    LettreMotivation findById(int id);

   
    boolean create(LettreMotivation lettre,Etudiant etu);

    boolean delete(int id);

    boolean update(LettreMotivation lettre);
}

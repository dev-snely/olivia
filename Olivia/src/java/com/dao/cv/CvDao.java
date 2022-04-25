/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.cv;

import com.model.entities.CV;
import com.model.entities.Etudiant;
import java.util.List;

/**
 *
 * @author gabri
 */
public interface CvDao {
    
    List<CV> findAll();

    CV findById(int id);

    boolean create(CV cv,Etudiant etu);

    boolean delete(int id);

    boolean update(CV cv);
  
}

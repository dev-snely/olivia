/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.postulation;

import com.model.entities.Etudiant;
import com.model.entities.Offre;
import com.model.entities.Postulation;
import java.util.List;

/**
 *
 * @author gabri
 */
public interface PostulationDao {

    List<Postulation> findAll();

    Postulation findByIdEtudiantEtOffre(Offre offre, Etudiant etudiant);

    boolean create(Postulation post,Offre offre, Etudiant etudiant);

    boolean delete(Offre offre, Etudiant etudiant);

    boolean update(Postulation post,Offre offre, Etudiant etudiant);
    
}

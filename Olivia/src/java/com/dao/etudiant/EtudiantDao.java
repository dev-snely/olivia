/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.etudiant;

import com.model.entities.CV;
import com.model.entities.Etudiant;
import com.model.entities.LettreMotivation;
import com.model.entities.Occupation;
import java.util.List;

/**
 *
 * @author gabri
 */
public interface EtudiantDao {
    List<Etudiant> findAll();

    Etudiant findById(int id);

    List<Etudiant> findByNom(String nom);
    List<Etudiant> findByPrenom(String prenom);
    List<Etudiant> findByNumeroDA(int DA);
    boolean create(Etudiant etu);

    boolean delete(int id);

    boolean update(Etudiant etu);
     boolean updateCv(Etudiant etu,CV cv);
boolean updateLettre(Etudiant etu,LettreMotivation lettre);
boolean updateOccupation(Etudiant etu,Occupation occup);

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.etudiant;

import com.model.entities.Etudiant;
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
}

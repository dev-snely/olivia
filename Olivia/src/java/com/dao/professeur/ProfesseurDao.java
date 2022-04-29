/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.professeur;

import com.model.entities.Professeur;
import java.util.List;

/**
 *
 * @author gabri
 */
public interface ProfesseurDao {

    List<Professeur> findAll();
Professeur findByIdCompte(int id);
    Professeur findById(int id);

    List<Professeur> findByNom(String nom);

    List<Professeur> findByPrenom(String prenom);

    List<Professeur> findByNumeroDA(int DA);

    boolean create(Professeur etu);

    boolean delete(int id);

    boolean update(Professeur etu);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.compte;

import com.model.entities.Compte;
import java.util.List;

/**
 *
 * @author gabri
 */
public interface CompteDao {
    List<Compte> findAll();

    Compte findById(int id);

    List<Compte> findByCourriel(String email);
    List<Compte> findByPassword(String password);
    List<Compte> findByTypeCompte(String type);
    boolean create(Compte admin);

    boolean delete(int id);

    boolean update(Compte admin);
    Compte isExiste(String email, String motDePasse);
}

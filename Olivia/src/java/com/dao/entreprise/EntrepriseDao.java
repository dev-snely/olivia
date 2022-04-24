/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.entreprise;

import com.model.entities.Entreprise;
import java.util.List;

/**
 *
 * @author gabri
 */
public interface EntrepriseDao {
    
    List<Entreprise> findAll();

    Entreprise findById(int id);

    boolean create(Entreprise entre);

    boolean delete(int id);

    boolean update(Entreprise entre);
}

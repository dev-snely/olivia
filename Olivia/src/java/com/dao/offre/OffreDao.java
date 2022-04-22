/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.offre;

import com.model.entities.Entreprise;
import com.model.entities.Offre;
import java.util.List;

/**
 *
 * @author gabri
 */
public interface OffreDao {

    List<Offre> findAll();

    Offre findById(int id);



    boolean create(Offre ocup,Entreprise ent);

    boolean delete(int id);

    boolean update(Offre ocup);
}

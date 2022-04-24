/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.occupation;

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

   Occupation findByDateDebut(Date date);
   Occupation findByDateFin(Date date);
    boolean create(Occupation ocup);

    boolean delete(int id);

    boolean update(Occupation ocup);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.postulation;

import com.model.entities.Postulation;
import java.util.List;

/**
 *
 * @author gabri
 */
public interface PostulationDao {

    List<Postulation> findAll();

    Postulation findById(int id);

    boolean create(Postulation post);

    boolean delete(int id);

    boolean update(Postulation post);
}

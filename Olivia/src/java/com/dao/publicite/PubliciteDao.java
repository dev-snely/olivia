/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.publicite;

import com.model.entities.Entreprise;
import com.model.entities.Publicite;
import java.util.List;

/**
 *
 * @author gabri
 */
public interface PubliciteDao {

    List<Publicite> findAll();

    Publicite findById(int id);

    boolean create(Publicite etu, Entreprise ent);

    boolean delete(int id);

    boolean update(Publicite etu);
}

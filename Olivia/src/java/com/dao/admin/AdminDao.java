/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.admin;

import com.model.entities.Admin;

import java.util.List;

/**
 *
 * @author gabri
 */
public interface AdminDao {

     List<Admin> findAll();
    Admin findByIdCompte(int id);
    Admin findById(int id);

    List<Admin> findByNom(String nom);
    List<Admin> findByPrenom(String prenom);

    
    boolean create(Admin admin);

    boolean delete(int idAdmin);

    boolean update(Admin admin);


}

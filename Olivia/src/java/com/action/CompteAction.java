/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.dao.compte.CompteDaoImpl;
import com.model.entities.Compte;

/**
 *
 * @author LysAd
 */
public class CompteAction {
    public static Compte findByCourriel(String courriel){
        CompteDaoImpl dao = new CompteDaoImpl();
        Compte unCompte = dao.findByCourriel(courriel);
        return unCompte;
    }
}

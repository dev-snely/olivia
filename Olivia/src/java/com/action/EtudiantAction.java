/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.action;

import com.dao.etudiant.EtudiantDao;
import com.dao.etudiant.EtudiantDaoImpl;
import com.model.entities.Etudiant;
import java.util.List;

/**
 *
 * @author Mahmo
 */
public class EtudiantAction {
    public static List<Etudiant> findAllEtudiant(){
        EtudiantDao dao = new EtudiantDaoImpl();
        List<Etudiant> listeEtu = dao.findAll();
        return listeEtu;
    }
    
}

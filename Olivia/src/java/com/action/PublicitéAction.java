/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.action;

import com.dao.publicite.PubliciteDaoImp;
import com.model.entities.Publicite;
import java.util.List;

/**
 *
 * @author Mahmo
 */
public class PublicitéAction {
    
    public static List<Publicite> listeDesPubs(){
        PubliciteDaoImp pubDao = new PubliciteDaoImp();
        List<Publicite> lesPubs = pubDao.findAll();
        return lesPubs;
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.config;

/**
 *
 * @author gabri
 */
public interface ConfigBD {
     
	public final static String URL = "jdbc:mysql://127.0.0.1:3308/InStage?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        
        public final static String USER ="root";
       
        public final static String PASSWORD ="root";
         
        public final static String DRIVER="com.mysql.cj.jdbc.Driver";
}

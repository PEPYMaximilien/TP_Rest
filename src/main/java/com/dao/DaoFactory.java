package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {
    private static String url;
    private static String username;
    private static String password;
        

    @Bean
    public static Connection getConnection() {
    	Connection connexion = null;
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if (connexion == null) {
            	connexion = DriverManager.getConnection("jdbc:mysql://localhost:3308/connecth2", "root", "");
            }
        } catch (ClassNotFoundException e) {
        	// TODO Auto-generated catch block
			e.printStackTrace();
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connexion;
        
    }

    // Récupération du Dao
    public VilleDAO getVilleDAO() {
        return new VilleDAOImpl(this);
    }

}

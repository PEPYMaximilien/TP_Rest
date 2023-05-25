package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO{
	@Autowired
	private DaoFactory daoFactory;
	
	VilleDAOImpl(DaoFactory daoFactory){
		this.daoFactory = daoFactory;
	}
	
	@Override
	public List<Ville> findAllVilles(){
		List<Ville> villes = new ArrayList<Ville>();
		  Connection connexion = null;
		  Statement statement = null;
		  ResultSet resultat = null;
		  try {
		    connexion = daoFactory.getConnection();
		    statement = connexion.createStatement();
		    resultat = statement.executeQuery("SELECT * FROM ville_france");
		    while (resultat.next()) {
		      String codeCommuneINSEE = resultat.getString("Code_commune_INSEE");
		      String nomCommune = resultat.getString("Nom_commune");
		      String codePostal = resultat.getString("Code_postal");
		      String libellAcheminement = resultat.getString("Libelle_acheminement");
		      String latitude = resultat.getString("Latitude");
		      String longitude = resultat.getString("Longitude");
		      
		      Ville ville = new Ville();
		      ville.setCodeCommuneINSEE(codeCommuneINSEE);
		      ville.setNomCommune(nomCommune);
		      ville.setCodePostal(codePostal);
		      ville.setLibelleAcheminement(libellAcheminement);
		      ville.setLatitude(latitude);
		      ville.setLongitude(longitude);
		      
		      villes.add(ville);
		    }
		    resultat.close();
		    statement.close();
		    connexion.close();
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
		  return villes;

	}

	@Override
    public Ville afficherVille(String nomVille) {
        Ville ville = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;
        Connection connexion = null;

        try {
        	connexion = daoFactory.getConnection();
            String sql = "SELECT Nom_commune, Code_postal, Latitude, Longitude FROM ville_france WHERE Nom_commune = ?";
            statement = connexion.prepareStatement(sql);
            statement.setString(1, nomVille);
            resultat = statement.executeQuery();
            if (resultat.next()) {
                ville = new Ville();
                ville.setNomCommune(nomVille);
                ville.setCodePostal(resultat.getString("Code_postal"));
                ville.setLatitude(resultat.getString("Latitude"));
                ville.setLongitude(resultat.getString("Longitude"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return ville;
    }
	

	
	@Override
    public Ville addVille(Ville ville) throws SQLException {
		Connection connexion = daoFactory.getConnection();
		
        try (Statement statement = connexion.createStatement();
                PreparedStatement request = connexion
                        .prepareStatement("INSERT INTO ville_france (Code_commune_INSEE, Nom_commune, Code_postal, Libelle_acheminement, Ligne_5, Latitude, Longitude) VALUES (?,?,?,?,?,?,?);")) {
            request.setString(1, ville.getCodeCommuneINSEE());
            request.setString(2, ville.getNomCommune());
            request.setString(3, ville.getCodePostal());
            request.setString(4, ville.getLibelleAcheminement());
            request.setString(5, ville.getLigne());
            request.setString(6, ville.getLatitude());
            request.setString(7, ville.getLongitude());

            request.executeUpdate();

            return ville;
        }
        
        
    }
	
	@Override
	public void deleteVille(Ville ville) {
		Connection connexion = daoFactory.getConnection();
		
        try (Statement statement = connexion.createStatement();
                PreparedStatement request = connexion
                        .prepareStatement("DELETE FROM ville_france WHERE `Code_commune_INSEE` = ? AND `Nom_commune` = ? AND `Code_postal` = ? AND `Libelle_acheminement` = ? AND `Ligne_5` = ? AND `Latitude``Longitude` = ?")) {
            request.setString(1, ville.getCodeCommuneINSEE());
            request.setString(2, ville.getNomCommune());
            request.setString(3, ville.getCodePostal());
            request.setString(4, ville.getLibelleAcheminement());
            request.setString(5, ville.getLigne());
            request.setString(6, ville.getLatitude());
            request.setString(7, ville.getLongitude());

            request.executeUpdate();
            
            statement.close();
		    connexion.close();
        } catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void putVille(Ville ville) {
		Connection connexion = daoFactory.getConnection();
		
        try (Statement statement = connexion.createStatement();
                PreparedStatement request = connexion
                        .prepareStatement("UPDATE `ville_france` SET `Code_commune_INSEE`= ? , "
                        		+ "`Nom_commune`= ? ,`Code_postal`= ? ,`Libelle_acheminement`= ? ,"
                        		+ "`Ligne_5`= ? ,`Latitude`= ? ,`Longitude`= ? WHERE `Code_commune_INSEE`= ? ")) {
            request.setString(1, ville.getCodeCommuneINSEE());
            request.setString(2, ville.getNomCommune());
            request.setString(3, ville.getCodePostal());
            request.setString(4, ville.getLibelleAcheminement());
            request.setString(5, ville.getLigne());
            request.setString(6, ville.getLatitude());
            request.setString(7, ville.getLongitude());
            request.setString(8, ville.getCodeCommuneINSEE());

            request.executeUpdate();
            
            statement.close();
		    connexion.close();
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

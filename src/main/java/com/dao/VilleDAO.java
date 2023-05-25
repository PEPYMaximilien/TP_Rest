package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.Ville;

public interface VilleDAO {
	public List<Ville> findAllVilles()throws DaoException;
	public Ville afficherVille(String nom) throws DaoException;
	public Ville addVille(Ville ville)throws SQLException;
	void deleteVille(Ville ville);
	void putVille(Ville ville);
	
}

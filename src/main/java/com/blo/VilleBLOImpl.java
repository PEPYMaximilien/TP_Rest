package com.blo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DaoException;
import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {

    @Autowired
    private VilleDAO villeDAO;

    public List<Ville> getInfoVilles() {
        List<Ville> listVille = new ArrayList<Ville>();

        try {
			listVille = villeDAO.findAllVilles();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return listVille;
    }
    
    public void addVille(Ville v) {
    	try {
			villeDAO.addVille(v);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void deleteVille(Ville v) {
    	villeDAO.deleteVille(v);
    }
    
    public void putVille(Ville ville) {
    	villeDAO.putVille(ville);
    }

	@Override
	public Ville afficherVille(String nom) throws DaoException {
		return villeDAO.afficherVille(nom);
	}

}
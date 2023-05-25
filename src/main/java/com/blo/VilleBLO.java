package com.blo;

import java.util.List;

import com.dao.DaoException;
import com.dto.Ville;

public interface VilleBLO {

    public List<Ville> getInfoVilles();
    
    public Ville afficherVille(String nom) throws DaoException;
    
    public void addVille(Ville v);
    
    public void deleteVille(Ville v);
    
    public void putVille(Ville ville);

}
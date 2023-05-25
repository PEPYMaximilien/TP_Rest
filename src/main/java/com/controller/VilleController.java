package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dao.DaoException;
import com.dto.Ville;

@RestController
public class VilleController {
	
	@Autowired
	VilleBLO villeBLOService;
	
	@RequestMapping(value="/ville", method=RequestMethod.GET)
    public List<Ville> getVilles() {
        return villeBLOService.getInfoVilles();
    }

    @GetMapping("/{nom}")
    public Ville getVille(@PathVariable String nom) throws DaoException {
        return villeBLOService.afficherVille(nom);
    }
	
	@RequestMapping(value="/ville", method=RequestMethod.POST)
	public void post(@RequestBody Ville ville) {
		villeBLOService.addVille(ville);
	}
	
	@RequestMapping(value="/ville", method=RequestMethod.DELETE)
	public void delete(@RequestBody Ville ville) {
		villeBLOService.deleteVille(ville);
	}
	
	@RequestMapping(value="/ville", method=RequestMethod.PUT)
	public void put(@RequestBody Ville ville) {
		villeBLOService.putVille(ville);
	}
	
}

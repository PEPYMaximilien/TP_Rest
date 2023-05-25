package com.dto;

public class Ville {
    private String codePostal;
	private String ligne;
    private String nomCommune;
    private String libelleAcheminement;
    private String codeCommuneINSEE;
    private String latitude;
    private String longitude;
    
    public Ville() {
        this(null, null, null, null, null, null, null);
    }

    public Ville(String codeCommune, String nom, String codePostal, String libelle, String ligne, String latitude, String longitude) {
        this.codeCommuneINSEE = codeCommune;
        this.nomCommune = nom;
        this.codePostal = codePostal;
        this.libelleAcheminement = libelle;
        this.ligne = ligne;
        this.latitude = latitude;
        this.longitude = longitude;
    }

	
    public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getLigne() {
		return ligne;
	}
	public void setLigne(String ligne) {
		this.ligne = ligne;
	}
	public String getNomCommune() {
		return nomCommune;
	}
	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}
	public String getLibelleAcheminement() {
		return libelleAcheminement;
	}
	public void setLibelleAcheminement(String libelleAcheminement) {
		this.libelleAcheminement = libelleAcheminement;
	}
	public String getCodeCommuneINSEE() {
		return codeCommuneINSEE;
	}
	public void setCodeCommuneINSEE(String codeCommuneINSEE) {
		this.codeCommuneINSEE = codeCommuneINSEE;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}
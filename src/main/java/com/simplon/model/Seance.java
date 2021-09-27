package com.simplon.model;

public class Seance {

	private int IdSportifEntraineur;
	private String jour;
	private int horaire;
	private int duree;
	private String libelle;
	public Seance(int idSportifEntraineur, String jour, int horaire, int duree, String libelle) {
		super();
		IdSportifEntraineur = idSportifEntraineur;
		this.jour = jour;
		this.horaire = horaire;
		this.duree = duree;
		this.libelle = libelle;
	}
	public int getIdSportifEntraineur() {
		return IdSportifEntraineur;
	}
	public void setIdSportifEntraineur(int idSportifEntraineur) {
		IdSportifEntraineur = idSportifEntraineur;
	}
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	public int getHoraire() {
		return horaire;
	}
	public void setHoraire(int horaire) {
		this.horaire = horaire;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@Override
	public String toString() {
		return "Seance [IdSportifEntraineur=" + IdSportifEntraineur + ", jour=" + jour + ", horaire=" + horaire
				+ ", duree=" + duree + ", libelle=" + libelle + "]";
	}
	
	
	
}

package com.simplon.gym.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sportifs {

	@JsonProperty("_id")
	private String id;

	private String idSportif;
	private String nom;
	private String prenom;
	private String sexe;
	private String age;
	private Sports sports;

	public Sportifs() {
	}

	public Sportifs(String idSportif, String nom, String prenom, String sexe, String age, Sports sports) {
		super();
		this.idSportif = idSportif;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.age = age;
		this.sports = sports;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdSportif() {
		return idSportif;
	}

	public void setIdSportif(String object) {
		this.idSportif = object;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Sports getSports() {
		return sports;
	}

	public void setSports(Sports sports) {
		this.sports = sports;
	}

	@Override
	public String toString() {
		return "Sportif [_id=" + id + ", idSportif=" + idSportif + ", nom=" + nom + ", prenom=" + prenom + ", sexe="
				+ sexe + ", age=" + age + ", sports=" + sports + "]";
	}

	public static class Builder {
		private String id;
		private String idSportif;
		private String nom;
		private String prenom;
		private String sexe;
		private String age;
		private Sports sports;

		public Builder id(String id) {
			this.id = id;
			return this;
		}

		public Builder idSportif(String idSportif) {
			this.idSportif = idSportif;
			return this;
		}

		public Builder nom(String nom) {
			this.nom = nom;
			return this;
		}

		public Builder prenom(String prenom) {
			this.prenom = prenom;
			return this;
		}

		public Builder sexe(String sexe) {
			this.sexe = sexe;
			return this;
		}

		public Builder age(String age) {
			this.age = age;
			return this;
		}

		public Builder sports(Sports sports) {
			this.sports = sports;
			return this;
		}

		public Sportifs build() {
			Sportifs sportifs = new Sportifs();
			sportifs.id = id;
			sportifs.idSportif = idSportif;
			sportifs.nom = nom;
			sportifs.prenom = prenom;
			sportifs.sexe = sexe;
			sportifs.age = age;
			sportifs.sports = sports;
			return sportifs;
		}
	}
}

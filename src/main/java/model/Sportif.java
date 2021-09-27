package model;

public class Sportif {
	private String _id;
	private String idSportif;
	private String nom;
	private String prenom;
	private String sexe;
	private String age;
	private Sports sports;
	
	public Sportif() {}
	
	public Sportif(String idSportif, String nom, String prenom, String sexe, String age, Sports sports) {
		super();
		this.idSportif = idSportif;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.age = age;
		this.sports = sports;
	}

	
	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getIdSportif() {
		return idSportif;
	}
	
	public void setIdSportif(String idSportif) {
		this.idSportif = idSportif;
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
		return "Sportif [_id=" + _id + ", idSportif=" + idSportif + ", nom=" + nom + ", prenom=" + prenom + ", sexe="
				+ sexe + ", age=" + age + ", sports=" + sports + "]";
	}
	
	
	
}



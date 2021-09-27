package model;

import java.util.List;

public class Sports {
	private List<String> jouer;
	private List<String> arbitrer;
	private List<String> entainer;
	
	
	public Sports() {}
	
	public Sports(List<String> jouer, List<String> arbitrer, List<String> entainer) {
		super();
		this.jouer = jouer;
		this.arbitrer = arbitrer;
		this.entainer = entainer;
	}


	public List<String> getJouer() {
		return jouer;
	}

	public void setJouer(List<String> jouer) {
		this.jouer = jouer;
	}

	public List<String> getArbitrer() {
		return arbitrer;
	}

	public void setArbitrer(List<String> arbitrer) {
		this.arbitrer = arbitrer;
	}

	public List<String> getEntainer() {
		return entainer;
	}

	public void setEntainer(List<String> entainer) {
		this.entainer = entainer;
	}

	@Override
	public String toString() {
		return "Sports [jouer=" + jouer + ", arbitrer=" + arbitrer + ", entainer=" + entainer + "]";
	}
	
	
	

}

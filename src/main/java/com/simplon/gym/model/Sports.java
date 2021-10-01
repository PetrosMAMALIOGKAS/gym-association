package com.simplon.gym.model;

import java.util.List;

public class Sports {
	private List<String> jouer;
	private List<String> arbitrer;
	private List<String> entrainer;

	public Sports() {
	}

	public Sports(List<String> jouer, List<String> arbitrer, List<String> entrainer) {
		super();
		this.jouer = jouer;
		this.arbitrer = arbitrer;
		this.entrainer = entrainer;
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

	public List<String> getEntrainer() {
		return entrainer;
	}

	public void setEntrainer(List<String> entrainer) {
		this.entrainer = entrainer;
	}

	@Override
	public String toString() {
		return "Sports [jouer=" + jouer + ", arbitrer=" + arbitrer + ", entainer=" + entrainer + "]";
	}

	public static class Builder {
		private List<String> jouer;
		private List<String> arbitrer;
		private List<String> entrainer;

		public Builder jouer(List<String> jouer) {
			this.jouer = jouer;
			return this;
		}

		public Builder arbitrer(List<String> arbitrer) {
			this.arbitrer = arbitrer;
			return this;
		}

		public Builder entrainer(List<String> entrainer) {
			this.entrainer = entrainer;
			return this;
		}

		public Sports build() {
			Sports sports = new Sports();
			sports.jouer = jouer;
			sports.arbitrer = arbitrer;
			sports.entrainer = entrainer;
			return sports;
		}
	}
}
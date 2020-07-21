package com.collabera.jump.worldappDAO;

public class Country {
	
	private int countryId;
	private String countryName;
	private int population;
	private int cityId;
	
	public Country () {
	}

	public Country(int countryId, String countryName, int population, int cityId) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.population = population;
		this.cityId = cityId;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
}

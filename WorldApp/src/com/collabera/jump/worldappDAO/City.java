package com.collabera.jump.worldappDAO;

public class City {
	private int cityId;
	private String name;
	private boolean isCapital;

	public City () {
	}

	public City(int cityId, String name, boolean isCapital) {
		super();
		this.cityId = cityId;
		this.name = name;
		this.isCapital = isCapital;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCapital() {
		return isCapital;
	}

	public void setCapital(boolean isCapital) {
		this.isCapital = isCapital;
	}
}

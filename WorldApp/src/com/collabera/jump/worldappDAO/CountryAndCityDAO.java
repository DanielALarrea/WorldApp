package com.collabera.jump.worldappDAO;

import java.util.List;

public interface CountryAndCityDAO {
	public List<CountryCityJoin> getCityIdJoin(int cityId);
	public List<CountryCityJoin> getIsCapitalJoin(int isCapital);
}

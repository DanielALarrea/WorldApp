package com.collabera.jump.worldappDAO;

import java.util.List;

public interface CityDAO {
	   public City getCity(int id);
	   public List<City> getAllCities();
	   public boolean updateCity(City city);
	   public void deleteCity(City city);
}

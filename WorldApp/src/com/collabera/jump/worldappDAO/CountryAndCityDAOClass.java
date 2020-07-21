package com.collabera.jump.worldappDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryAndCityDAOClass implements CountryAndCityDAO {

	//list is working as a database
	List<CountryCityJoin> joinList;

	public CountryAndCityDAOClass(){
		joinList = new ArrayList<CountryCityJoin>();
	}

	//retrieve list of Countries from the database
	@Override
	public List <CountryCityJoin> getCityIdJoin(int cityId) {
		System.out.println("Getting country and city by cityId...");
		Connection con = ConnectionFactory.getConnection();
		try {
			Statement stmt = con.createStatement();
			String query = "select * from country "
					+ "inner join city "
					+ "on country.cityid = city.cityid "
					+ "where city.cityid=" 
					+ cityId;
			ResultSet rs = stmt.executeQuery(query);
			List<CountryCityJoin> joinList = new ArrayList<CountryCityJoin>();
			List<Country> countryList = new ArrayList<Country>();
			List<City> cityList = new ArrayList<City>();

			while(rs.next())
			{
				Country co = new Country();
				City ci = new City();
				CountryCityJoin cociJ = new CountryCityJoin();
				co.setCountryId(rs.getInt("countryid"));
				co.setCountryName(rs.getString("countryname"));
				co.setPopulation(rs.getInt("population"));
				co.setCityId(rs.getInt("cityid"));
				ci.setCityId(rs.getInt("cityid"));
				ci.setName(rs.getString("name"));
				ci.setCapital(rs.getBoolean("iscapital"));
				cociJ.setCountry(co);
				cociJ.setCity(ci);
				joinList.add(cociJ);
			}
			stmt.close();
			rs.close();
			return joinList;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List <CountryCityJoin> getIsCapitalJoin(int isCapital) {
		System.out.println("Getting country and city based on capital status...");
		Connection con = ConnectionFactory.getConnection();
		try {
			Statement stmt = con.createStatement();
			String query = "select * from country "
					+ "inner join city "
					+ "on country.cityid = city.cityid "
					+ "where city.iscapital = "
					+ isCapital;
			ResultSet rs = stmt.executeQuery(query);
			List<CountryCityJoin> joinList = new ArrayList<CountryCityJoin>();

			while(rs.next())
			{
				Country co = new Country();
				City ci = new City();
				CountryCityJoin cociJ = new CountryCityJoin();
				co.setCountryId(rs.getInt("countryid"));
				co.setCountryName(rs.getString("countryname"));
				co.setPopulation(rs.getInt("population"));
				co.setCityId(rs.getInt("cityid"));
				ci.setCityId(rs.getInt("cityid"));
				ci.setName(rs.getString("name"));
				ci.setCapital(rs.getBoolean("iscapital"));
				cociJ.setCountry(co);
				cociJ.setCity(ci);
				joinList.add(cociJ);
			}
			stmt.close();
			rs.close();
			return joinList;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}

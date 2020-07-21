package com.collabera.jump.worldappDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryDAOClass implements CountryDAO{

	//list is working as a database
	List<Country> countryList;

	public CountryDAOClass(){
		countryList = new ArrayList<Country>();
	}

	//retrieve list of Countries from the database
	@Override
	public List <Country> getAllCountries() {
		System.out.println("Looking for countries...");
		Connection con = ConnectionFactory.getConnection();
		System.out.println("connected to database...");
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM country");
			List<Country> countryList = new ArrayList<Country>();

			while(rs.next())
			{
				
				Country co = new Country();
				co.setCountryId(rs.getInt("countryid"));
				co.setCountryName(rs.getString("countryname"));
				co.setPopulation(rs.getInt("population"));
				co.setCityId(rs.getInt("cityid"));
				countryList.add(co);
			}
			stmt.close();
			rs.close();
			return countryList;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Country getCountry(int id) {
		Connection con = ConnectionFactory.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM country WHERE countryid=" + id);
			if(rs.next())
			{
				Country co = new Country();
				co.setCountryId(rs.getInt("countryid"));
				co.setCountryName(rs.getString("countryname"));
				co.setPopulation(rs.getInt("population"));
				co.setCityId(rs.getInt("cityid"));
				return co;
			}
			stmt.close();
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}


	@Override
	public boolean updateCountry(Country co) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE country SET countryname=?, population=? WHERE id=?");
			ps.setString(2, co.getCountryName());
			ps.setInt(3, co.getPopulation());
			ps.setInt(4, co.getCityId());
			ps.setInt(1, co.getCountryId());

			int i = ps.executeUpdate();

			if(i == 1) {
				return true;
			}
			ps.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	@Override
	public void deleteCountry(Country co) {
	}
}

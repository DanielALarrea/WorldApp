package com.collabera.jump.worldappDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CityDAOClass implements CityDAO{

	 //list is working as a database
	   List<City> cityList;

	   public CityDAOClass(){
		   cityList = new ArrayList<City>();
	   }
		 //retrieve list of Cities from the database
	   @Override
	     public List <City> getAllCities() {
			   Connection con = ConnectionFactory.getConnection();
			    try {
			        Statement stmt = con.createStatement();
			        ResultSet rs = stmt.executeQuery("SELECT * FROM city");
			        List<City> cityList = new ArrayList<City>();

			        while(rs.next())
			        {
			        	City ci = new City();
			        	ci.setCityId(rs.getInt("cityid"));
			        	ci.setName(rs.getString("name"));
			        	ci.setCapital(rs.getBoolean("iscapital"));
			        	cityList.add(ci);
			        }
			        stmt.close();
			        rs.close();
			        return cityList;
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    }
			    return null;
			}
	   

	   @Override
	   public City getCity(int id) {
		    Connection con = ConnectionFactory.getConnection();
		        try {
		            Statement stmt = con.createStatement();
		            ResultSet rs = stmt.executeQuery("SELECT * FROM city WHERE cityid=" + id);
		            if(rs.next())
		            {
		            	City ci = new City();
		            	ci.setCityId(rs.getInt("cityid"));
			        	ci.setName(rs.getString("name"));
			        	ci.setCapital(rs.getBoolean("iscapital"));
			        	return ci;
		            }
		            stmt.close();
		            rs.close();
		        } catch (SQLException ex) {
	            ex.printStackTrace();
		        }
		    return null;
		}

	   
	   @Override
	   public boolean updateCity(City ci) {
		   Connection connection = ConnectionFactory.getConnection();
		   try {
			   PreparedStatement ps = connection.prepareStatement("UPDATE city SET name=?, iscapital=? WHERE id=?");
			   ps.setString(2, ci.getName());
			   ps.setBoolean(3, ci.isCapital());
			   ps.setInt(1, ci.getCityId());

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
	   public void deleteCity(City ci) {
	   }
}

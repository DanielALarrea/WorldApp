package com.collabera.jump.worldappDAO;

import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
//	public static final String URL = "jdbc:mysql://localhost:3306/worldapp";
//	public static final String USER = "root";
//	public static final String PASS = "root";

	public static Connection getConnection()
	{
		try {
			Properties prop = new Properties();
			//String configName = "WorldApp/resources/worldapp.config";
			//D:\GitHub Repos\WorldApp\WebContent\WEB-INF
			/*
			 * TODO
			 * Figure out less hardcoded path to config file
			 */
			String configName = "D:/GitHub Repos/WorldApp/WebContent/WEB-INF/worldapp.config";
			FileInputStream fis = new FileInputStream(configName);
			prop.load(fis);
			fis.close();
			final String URL = prop.getProperty("URL");
			final String USER = prop.getProperty("USER");
			final String PASS = prop.getProperty("PASSWORD");
			DriverManager.registerDriver(new Driver());
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException ex) {
			throw new RuntimeException("Error connecting to the database", ex);
		} catch (FileNotFoundException fex) {
			throw new RuntimeException("Error locating the config file", fex);
		} catch (IOException ioex) {
			throw new RuntimeException("Error reading config file", ioex);
		}
	}
}
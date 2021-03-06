package com.collabera.jump.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.collabera.jump.worldappDAO.City;
import com.collabera.jump.worldappDAO.CityDAO;
import com.collabera.jump.worldappDAO.CityDAOClass;
import com.collabera.jump.worldappDAO.Country;
import com.collabera.jump.worldappDAO.CountryAndCityDAO;
import com.collabera.jump.worldappDAO.CountryAndCityDAOClass;
import com.collabera.jump.worldappDAO.CountryCityJoin;
import com.collabera.jump.worldappDAO.CountryDAO;
import com.collabera.jump.worldappDAO.CountryDAOClass;

/**
 * Servlet implementation class WorldMainServe
 */
@WebServlet("/WorldMainServe")
public class WorldMainServe extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public WorldMainServe() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		CountryDAO coDAO = new CountryDAOClass();
		CityDAO ciDAO = new CityDAOClass();
		
		out.println("<html><body>");
		out.println("<center><table>"
				+ "<th><a href=WorldMainServe>Main</a></th>"
				+ "<th><a href=CityIDServe>City ID</a></th>"
				+ "<th><a href=CapitalServe>Capital</a></th>"
				+ "</table></center>");
		
		out.println("<h2>Country Data</h2>");
		out.println("<table border=1><tr><th>Country ID</th><th>Country Name</th><th>Population</th><th>City ID</th></tr>");
		for (Country co : coDAO.getAllCountries()) {
			out.println("<tr><td>"+ co.getCountryId()
			+ "</td><td>" + co.getCountryName()
			+ "</td><td>"+ co.getPopulation() + " million"
			+ "</td><td>" + co.getCityId() + "</td></tr>");
		}
		out.println("</table>");
		
		out.println("<h2>City Data</h2>");
		out.println("<table border=1><tr><th>City ID</th><th>City Name</th><th>Capital?</th></tr>");
		for (City ci : ciDAO.getAllCities()) {
			out.println("<tr><td>"+ ci.getCityId()
			+"</td><td>" + ci.getName()
			+ "</td><td>"+ ci.isCapital() + "</td></tr>");
		}
		out.println("</table>");

		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

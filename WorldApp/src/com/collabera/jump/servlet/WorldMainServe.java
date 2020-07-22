package com.collabera.jump.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.collabera.jump.worldappDAO.Country;
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
		PrintWriter out=response.getWriter();
		CountryDAO coDAO = new CountryDAOClass();
		out.println("<html><body>");
		
		out.println("<table border=1><tr><th>Country ID</th><th>Country Name</th><th>Population</th><th>City ID</th></tr>");
		
		for (Country co : coDAO.getAllCountries()) {
			out.println("<tr><td>"+ co.getCountryId()
			+ "</td><td>" + co.getCountryName()
			+ "</td><td>"+ co.getPopulation() + " million"
			+ "</td><td>" + co.getCityId() + "</td></tr>");
		}
		
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

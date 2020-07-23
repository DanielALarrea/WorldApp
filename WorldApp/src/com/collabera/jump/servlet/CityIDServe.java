package com.collabera.jump.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.collabera.jump.worldappDAO.CountryAndCityDAO;
import com.collabera.jump.worldappDAO.CountryAndCityDAOClass;
import com.collabera.jump.worldappDAO.CountryCityJoin;

/**
 * Servlet implementation class CityIDServe
 */
@WebServlet("/CityIDServe")
public class CityIDServe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityIDServe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		CountryAndCityDAO cociDAO = new CountryAndCityDAOClass();
		
		out.println("<html><body>");
		out.println("<center><table>"
				+ "<th><a href=WorldMainServe>Main</a></th>"
				+ "<th><a href=CityIDServe>City ID</a></th>"
				+ "<th><a href=CapitalServe>Capital</a></th>"
				+ "</table></center>");
		
		out.println("<form name=cityidform action=CityIDServe method=GET>");
			out.println("City ID: <input type=number name=cityid>");
			out.println("<input type=submit value=Submit");
		out.println("</form>");
		
		int cityID = -1;
		if(request.getParameter("cityid") != null) {
			cityID = Integer.valueOf(request.getParameter("cityid"));
			out.println("<h2>Country and City Data for City " + cityID + "</h2>");
			out.println("<table border=1><tr><th>Country ID</th><th>Country Name</th><th>Population</th><th>City ID</th><th>City Name</th><th>Capital?</th></tr>");
			for (CountryCityJoin cociJ : cociDAO.getCityIdJoin(cityID)) {
				out.println("<tr><td>"+ cociJ.getCountry().getCountryId()
						+ "</td><td>" + cociJ.getCountry().getCountryName()
						+ "</td><td>" + cociJ.getCountry().getPopulation() + " million"
						+ "</td><td>" + cociJ.getCountry().getCityId()
						+ "</td><td>" + cociJ.getCity().getName()
						+ "</td><td>" + cociJ.getCity().isCapital() + "</td></tr>");
			}
			out.println("</table>");
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

package com.collabera.jump.worldappDAO;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		
		// Initialize objects used in menu
		Scanner scan = new Scanner(System.in);
		String input = "";
		CountryAndCityDAO cociDAO = new CountryAndCityDAOClass();
		CountryDAO coDAO = new CountryDAOClass();
		CityDAO ciDAO = new CityDAOClass();
		
		while(true) {
			// Display menu
			System.out.println("Enter a number to display certain data: ");
			System.out.println("1: All Country and City Data");
			System.out.println("2: Combined Data with a specific City ID");
			System.out.println("3: Combined Data if a City is the Capital or Not");
			System.out.println("0: Exit Menu");
			
			// Receive input from menu
			input = scan.next();

			// Determine what to do based on input
			switch (input) {
			// Display all Country and City details
			case "1":
				for (Country co : coDAO.getAllCountries()) {
					System.out.println("Country ID: "+ co.getCountryId()
					+", Country Name: " + co.getCountryName()
					+ ", Population: "+ co.getPopulation() + " million"
					+ ", City ID: " + co.getCityId());
				}
				System.out.println("--------------------------");
				for (City ci : ciDAO.getAllCities()) {
					System.out.println("City ID: "+ ci.getCityId()
					+", Name: " + ci.getName()
					+ ", Is Capital: "+ ci.isCapital());
				}
				System.out.println("--------------------------");
				break;
			// Display Country and City details of a specific City ID
			case "2": 
				System.out.println("Please enter a City ID: ");
				int cityId = scan.nextInt();
				System.out.println("Result from both tables when City ID is " + cityId);
				for (CountryCityJoin cociJ : cociDAO.getCityIdJoin(cityId)) {
					System.out.println("Country ID: "+ cociJ.getCountry().getCountryId()
							+ ", Country Name: " + cociJ.getCountry().getCountryName()
							+ ", Population: "+ cociJ.getCountry().getPopulation() + " million"
							+ ", City ID: " + cociJ.getCountry().getCityId()
							+ ", Name: " + cociJ.getCity().getName()
							+ ", Is Capital: " + cociJ.getCity().isCapital());
				}
				System.out.println("--------------------------");
				break;
			// Display Country and City details of all cities that are Capital or not
			case "3": 
				System.out.println("Do you want cities that are Capital (Y/N): ");
				String isCapLetter = scan.next().toUpperCase();
				int isCapVal = 1;
				switch (isCapLetter) {
				case "Y": 
					isCapVal=1;
					break;
				case "N": 
					isCapVal=0;
					break;
				default: 
					System.out.println("Invalid input, defaulting to Y");
					break;
				}
				System.out.println("Result from both tables when Is Capital is " + isCapLetter);
				for (CountryCityJoin cociJ : cociDAO.getIsCapitalJoin(isCapVal)) {
					System.out.println("Country ID: "+ cociJ.getCountry().getCountryId()
							+ ", Country Name: " + cociJ.getCountry().getCountryName()
							+ ", Population: "+ cociJ.getCountry().getPopulation()
							+ ", City ID: " + cociJ.getCountry().getCityId()
							+ ", Name: " + cociJ.getCity().getName()
							+ ", Is Capital: " + cociJ.getCity().isCapital());
				}
				System.out.println("--------------------------");
				break;
			// Exit the menu
			case "0":
				System.out.println("Exiting...");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input, please enter a valid input");
				System.out.println("--------------------------");
			}
		}
	}
}
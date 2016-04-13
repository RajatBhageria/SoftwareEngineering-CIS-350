package edu.upenn.cis350.hwk5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FlightFinder {

	private List<Flight> directFlights = new ArrayList<Flight>();
	
	private List<Flight[]> indirectFlights = new ArrayList<Flight[]>();
	
	private static int numSearches = 0;
	
	public List<Flight> getDirectFlights() { 
		return directFlights; 
	}
	
	public List<Flight[]> getIndirectFlights() { 
		return indirectFlights; 
	}
	
	public static int getNumSearches() {
		return numSearches;
	}
	
	/**
	 * Look through the (hard-coded) list of flights and return the number
	 * of flights from the home airport to the destination, according to the specification. 
	 */
	public int findFlights(boolean directOnly, String home, String dest, int timeLimit)
	{
		/*
		 * You are not being asked to implement this!
		 * You need to write black-box tests against the specification
		 */
		
		return Integer.MIN_VALUE;
		
	}
		

}

package edu.upenn.cis350.hwk5;

public class AllFlights {
	
	// all of the flights
	private static final Flight[] flights = new Flight[30];
	
	/*
	 * Use this in your test cases to get the flights.
	 */
	public static Flight[] getAllFlights(){
		return flights;
	}
	
	
	/*
	 * You can assume that these are the only flights that you need to consider.
	 */
	static {
	
		flights[0] = new Flight("PHL", "BOS", 95, 185);
		flights[1] = new Flight("BOS", "PHL", 95, 205);
		flights[2] = new Flight("PHL", "IAD", 60, 185);
		flights[3] = new Flight("IAD", "PHL", 60, 185);
		flights[4] = new Flight("PHL", "ORD", 100, 270);
		flights[5] = new Flight("ORD", "PHL", 100, 285);
		flights[6] = new Flight("PHL", "ATL", 120, 325);
		flights[7] = new Flight("ATL", "PHL", 120, 400);
		flights[8] = new Flight("PHL", "DFW", 175, 205);
		flights[9] = new Flight("DFW", "PHL", 175, 200);
		flights[10] = new Flight("DFW", "SFO", 150, 280);
		flights[11] = new Flight("SFO", "DFW", 150, 220);
		flights[12] = new Flight("DET", "SFO", 180, 305);
		flights[13] = new Flight("SFO", "DET", 180, 305);
		flights[14] = new Flight("ORD", "SFO", 190, 180);
		flights[15] = new Flight("SFO", "ORD", 190, 200);
		flights[16] = new Flight("ORD", "SEA", 225, 300);
		flights[17] = new Flight("SEA", "ORD", 225, 300);
		flights[18] = new Flight("ATL", "BOS", 140, 220);
		flights[19] = new Flight("BOS", "ATL", 140, 240);
		flights[20] = new Flight("JFK", "LHR", 400, 605);
		flights[21] = new Flight("LHR", "JFK", 400, 605);
		flights[22] = new Flight("PHL", "JFK", 70, 105);
		flights[23] = new Flight("JFK", "PHL", 70, 110);
		flights[24] = new Flight("BOS", "LHR", 345, 550);
		flights[25] = new Flight("LHR", "BOS", 345, 580);
		flights[26] = new Flight("ATL", "CDG", 580, 440);
		flights[27] = new Flight("CDG", "ATL", 580, 440);
		flights[28] = new Flight("PHL", "CDG", 605, 535);
		flights[29] = new Flight("CDG", "PHL", 605, 525);
		
	}

}

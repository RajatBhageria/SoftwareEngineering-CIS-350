package edu.upenn.cis350.hwk5;

public class Flight {
	
	// starting point for the flight
	private String start;
	// end point for the flight
	private String end;
	// travel time for the flight
	private int time;
	// price of the flight
	private int price;

	
	public Flight(String start, String end, int time, int price) {
		this.start = start;
		this.end = end;
		this.time = time;
		this.price = price;
	}
	
	public String getStart() { 
		return start; 
	}
	public String getEnd() { 
		return end; 
	}
	public int getTime() { 
		return time; 
	}
	public int getCost() { 
		return price; 
	}
	
	public String toString() {
		return start + "-" + end + ": " + time + " mins; $" + price;
	}
	
	



}

package model;

import java.util.ArrayList;
import java.util.List;

public class Airport {
	
	private List<Flight> flights = new ArrayList<Flight>();
	private String[] airlines = new String[] {"Avianca","Copa Airlines", "EasyFly", "LATAM", "Satena",
			"VivaColombia", "Wingo" }; 
	private String[] cities = new String[] {"Atlanta","Barranquilla", "Bogota", "Cali", "Cartagena",
			"Medellin", "New York", "Paris", "Madrid", "Berlin", "Amsterdam" }; 

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	} 
	
	public void addFlights(Flight flight) {
		flights.add(flight);
	} 
	
	public String timeRandom() {
		
		String time="";
			
		int hourRandom = (int)(Math.random()*12+1);
		int minutesRandom = (int)(Math.random()*60+1);
		String n="";
		
		if(minutesRandom<10) {
			n="0";
		}
		
		time = ""+hourRandom+":"+n+minutesRandom;
		
		return time;
	}
	
	public String airlineRandom() {
		
		int airlineNumber = (int)(Math.random()*7-1);
		String airline = airlines[airlineNumber];
		
		return airline;
		
	}
	
	public String flightRandom(String airline) {
		int flightNumber = (int)(Math.random()*1000);
		airline = airline.toUpperCase();
		String flight=""+airline.charAt(0)+airline.charAt(1)+" "+flightNumber;
		
		return flight;
	}
	
	public String toRandom() {
		int cityNumber = (int)(Math.random()*12-1);
		String city = cities[cityNumber];
		
		return city;
	}
	
	public String terminalRandom() {
		int terminalNumber = (int)(Math.random()*5-1);
		terminalNumber++;
		
		String terminal=""+terminalNumber;
		
		return terminal;
	}
	
	public String gateRandom() {
		int gateNumber=(int)(Math.random()*30-1);
		gateNumber++;
		
		String gate=""+gateNumber;
		
		return gate;
	}
	
	public String remarksRandom() {
		int remarksNumber = (int)(Math.random()*2);
		String remarks="";
		if(remarksNumber==0) {
			remarks = "Go to Gate";
		}else if(remarksNumber==1) {
			remarks="";
		}else {
			remarks="Delayed";
		}
		
		return remarks;
	}
	
}

package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Airport {
	
	private List<Flight> flights = new ArrayList<Flight>();
	
	public final static String[] AIRLINES = new String[] {"Avianca","Copa Airlines", "EasyFly", "LATAM", "Satena",
			"VivaColombia", "Wingo" }; 
	public final static String[] CITIES = new String[] {"Atlanta","Barranquilla", "Bogota", "Cali", "Cartagena",
			"Medellin", "New York", "Paris", "Madrid", "Berlin", "Amsterdam" }; 

	public Airport() {}
	
	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(ArrayList<Flight> flights) {
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
		String m="";
		String amPm="";
		int hourTime = (int)(Math.random()*2);
		
		if(hourTime == 0) {
			amPm = " AM";
		}else {
			amPm = " PM";
		}
		
		if(minutesRandom<10) {
			n="0";
		}
		
		if(hourRandom<10) {
			m="0";
		}
		
		time = m+hourRandom+":"+n+minutesRandom+amPm;
		
		return time;
	}
	
	public String airlineRandom() {
		
		int airlineNumber = (int)(Math.random()*7-1);
		String airline = AIRLINES[airlineNumber];
		
		return airline;
		
	}
	
	public String flightRandom(String airline) {
		int flightNumber = (int)(Math.random()*1000);
		airline = airline.toUpperCase();
		
		String n="";
		if (flightNumber<10) {
			n="00";
		}else if(flightNumber<100) {
			n="0";
		}
		String flight=""+airline.charAt(0)+airline.charAt(1)+" "+n+flightNumber;
		
		return flight;
	}
	
	public String toRandom() {
		int cityNumber = (int)(Math.random()*12-1);
		String city = CITIES[cityNumber];
		
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
	
	public ArrayList<Flight> orderByTimeLH(ArrayList<Flight> flights) {
		Collections.sort(flights, new TimeComparator());
		return flights;
	}
	
	public ArrayList<Flight> orderByTimeHL(ArrayList<Flight> flights) {
		Flight temp;
	    for(int I = 0; I< flights.size()-1; I++) {
	        for(int J = 0; J < flights.size()-I-1; J++) {
	            if(flights.get(J).compareTo(flights.get(J+1))<0) {
	                temp = flights.get(J);
	                flights.set(J, flights.get(J+1));
	                flights.set(J+1, temp);
	            }
	        }
	    }
		
		return flights;
	}
	
	public ArrayList<Flight> orderByAirlineAZ(ArrayList<Flight> flights) {
		
		int minimum; 
		Flight temp;

        for(int I = 0; I < flights.size()-1 ; I++)  {
             minimum = I ;
            for(int J = I+1; J < flights.size() ; J++ ) {
                if(flights.get(J).getAirline().compareTo(flights.get(minimum).getAirline())<0)  {
                minimum = J ;
                }
             }
            temp = flights.get(minimum);
            flights.set(minimum, flights.get(I));
            flights.set(I, temp);
        }
		
		return flights;
		
	}
	
	public ArrayList<Flight> orderByAirlineZA(ArrayList<Flight> flights) {
		
		int minimum; 
		Flight temp;

        for(int I = 0; I < flights.size()-1 ; I++)  {
             minimum = I ;
            for(int J = I+1; J < flights.size() ; J++ ) {
                if(flights.get(J).getAirline().compareTo(flights.get(minimum).getAirline())>0)  {
                minimum = J ;
                }
             }
            temp = flights.get(minimum);
            flights.set(minimum, flights.get(I));
            flights.set(I, temp);
        }
		
		return flights;
		
	}
	
public ArrayList<Flight> orderByFlight(ArrayList<Flight> flights) {
		
	for( int I = 0 ;I < flights.size() ; I++ ) {

	      Flight temp = flights.get(I);    
	      int J = I;

	          while(  J > 0  && temp < A[ J -1]) {
	                A[ J ] = A[ J-1];   
	                J= J - 1;

	           }
	           A[ J ] = temp;       
	     }  
		
		return flights;
		
	}
	
}

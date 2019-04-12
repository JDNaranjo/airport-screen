package model;

import java.util.ArrayList;
import java.util.Collections;

public class Airport {
	
	private ArrayList<Flight> flights = new ArrayList<Flight>();
	
	public final static String[] AIRLINES = new String[] {"Avianca","Copa Airlines", "EasyFly", "LATAM", "Satena",
			"VivaColombia", "Wingo" }; 
	public final static String[] CITIES = new String[] {"Atlanta","Barranquilla", "Bogota", "Cali", "Cartagena",
			"Medellin", "New York", "Paris", "Madrid", "Berlin", "Amsterdam" }; 

	public Airport() {}
	
	public ArrayList<Flight> getFlights() {
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
		int remarksNumber = (int)(Math.random()*3);
		String remarks="";
		if(remarksNumber==0) {
			remarks = "Go to Gate";
		}else if(remarksNumber==1) {
			remarks="Wait on room";
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
		
		Collections.sort(flights, new AirlineComparator());
		
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
	
	public ArrayList<Flight> orderByFlightAZ(ArrayList<Flight> flights) {
		
		for( int I = 0 ;I < flights.size() ; I++ ) {
	
		     Flight temp = flights.get(I);    
		     int J = I;
	         while(  J > 0  && temp.getFlight().compareTo(flights.get(J-1).getFlight()) < 0) {
	        	 flights.set(J, flights.get(J-1));   
		         J= J - 1;
	
		         }
		     flights.set(J, temp);       
		}  
			
		return flights;
		
	}
	
public ArrayList<Flight> orderByFlightZA(ArrayList<Flight> flights) {
		
		for( int I = 0 ;I < flights.size() ; I++ ) {
	
		     Flight temp = flights.get(I);    
		     int J = I;
	         while(  J > 0  && temp.getFlight().compareTo(flights.get(J-1).getFlight()) > 0) {
	        	 flights.set(J, flights.get(J-1));   
		         J= J - 1;
	
		         }
		     flights.set(J, temp);       
		}  
			
		return flights;
		
	}

public ArrayList<Flight> orderByCityAZ(ArrayList<Flight> flights) {
	
	Collections.sort(flights, new CityComparator());
		
	return flights;
	
}

public ArrayList<Flight> orderByCityZA(ArrayList<Flight> flights) {
	
	for( int I = 0 ;I < flights.size() ; I++ ) {
		
	     Flight temp = flights.get(I);    
	     int J = I;
        while(  J > 0  && temp.getArriveCity().compareTo(flights.get(J-1).getArriveCity()) > 0) {
       	 flights.set(J, flights.get(J-1));   
	         J= J - 1;

	         }
	     flights.set(J, temp);       
	}  
		
	return flights;
	
}

public ArrayList<Flight> orderByTerminalLH(ArrayList<Flight> flights) {
	
	for( int I = 0 ;I < flights.size() ; I++ ) {
		
	     Flight temp = flights.get(I);    
	     int J = I;
        while(  J > 0  && temp.getTerminal().compareTo(flights.get(J-1).getTerminal()) < 0) {
       	 flights.set(J, flights.get(J-1));   
	         J= J - 1;

	         }
	     flights.set(J, temp);       
	}  
		
	return flights;
	
}

public ArrayList<Flight> orderByTerminalHL(ArrayList<Flight> flights) {
	
	for( int I = 0 ;I < flights.size() ; I++ ) {
		
	     Flight temp = flights.get(I);    
	     int J = I;
        while(  J > 0  && temp.getTerminal().compareTo(flights.get(J-1).getTerminal()) > 0) {
       	 flights.set(J, flights.get(J-1));   
	         J= J - 1;

	         }
	     flights.set(J, temp);       
	}  
		
	return flights;
	
}

public ArrayList<Flight> orderByGateLH(ArrayList<Flight> flights) {
	
	for( int I = 0 ;I < flights.size() ; I++ ) {
		
	     Flight temp = flights.get(I);    
	     int J = I;
        while(  J > 0  && temp.getGate().compareTo(flights.get(J-1).getGate()) < 0) {
       	 flights.set(J, flights.get(J-1));   
	         J= J - 1;

	         }
	     flights.set(J, temp);       
	}  
		
	return flights;
	
}

public ArrayList<Flight> orderByGateHL(ArrayList<Flight> flights) {
	
	for( int I = 0 ;I < flights.size() ; I++ ) {
		
	     Flight temp = flights.get(I);    
	     int J = I;
        while(  J > 0  && temp.getGate().compareTo(flights.get(J-1).getGate()) > 0) {
       	 flights.set(J, flights.get(J-1));   
	         J= J - 1;

	         }
	     flights.set(J, temp);       
	}  
		
	return flights;
	
}

public ArrayList<Flight> orderByRemarks(ArrayList<Flight> flights) {
	
	for( int I = 0 ;I < flights.size() ; I++ ) {
		
	     Flight temp = flights.get(I);    
	     int J = I;
        while(  J > 0  && temp.getRemarks().compareTo(flights.get(J-1).getRemarks()) > 0) {
       	 flights.set(J, flights.get(J-1));   
	         J= J - 1;

	         }
	     flights.set(J, temp);       
	}  
		
	return flights;
	
}

public int binarySearchByTime(String time) {
		int low=0;
		int high = flights.size()-1;
		int r=-1;
		while(low<=high) {
			int mid=(low+high)/2;
			if(flights.get(mid).getTime().compareTo(time)<0) {
				low = mid+1;
			}else if(flights.get(mid).getTime().compareTo(time)>0) {
				high = mid-1;
			}else if(flights.get(mid).getTime().compareTo(time)==0){
				r=mid;
				return r;
			}
		}
		
		return -1;
	}

public int binarySearchByAirline(String airline) {
	int low=0;
	int high = flights.size()-1;
	int r=-1;
	while(low<=high) {
		int mid=(low+high)/2;
		if(flights.get(mid).getAirline().compareTo(airline)<0) {
			low = mid+1;
		}else if(flights.get(mid).getAirline().compareTo(airline)>0) {
			high = mid-1;
		}else if(flights.get(mid).getAirline().compareTo(airline)==0){
			r=mid;
			return r;
		}
	}
	
	return -1;
}

public int binarySearchByFlight(String flight) {
	int low=0;
	int high = flights.size()-1;
	int r=-1;
	while(low<=high) {
		int mid=(low+high)/2;
		if(flights.get(mid).getFlight().compareTo(flight)<0) {
			low = mid+1;
		}else if(flights.get(mid).getFlight().compareTo(flight)>0) {
			high = mid-1;
		}else if(flights.get(mid).getFlight().compareTo(flight)==0){
			r=mid;
			return r;
		}
	}
	
	return -1;
}

public int binarySearchByCity(String city) {
	int low=0;
	int high = flights.size()-1;
	int r=-1;
	while(low<=high) {
		int mid=(low+high)/2;
		if(flights.get(mid).getArriveCity().compareTo(city)<0) {
			low = mid+1;
		}else if(flights.get(mid).getArriveCity().compareTo(city)>0) {
			high = mid-1;
		}else if(flights.get(mid).getArriveCity().compareTo(city)==0){
			r=mid;
			return r;
		}
	}
	
	return -1;
}

public int binarySearchByTerminal(String terminal) {
	int low=0;
	int high = flights.size()-1;
	int r=-1;
	while(low<=high) {
		int mid=(low+high)/2;
		if(flights.get(mid).getTerminal().compareTo(terminal)<0) {
			low = mid+1;
		}else if(flights.get(mid).getTerminal().compareTo(terminal)>0) {
			high = mid-1;
		}else if(flights.get(mid).getTerminal().compareTo(terminal)==0){
			r=mid;
			return r;
		}
	}
	
	return -1;
}

public int binarySearchByGate(String gate) {
	int low=0;
	
	int high = flights.size()-1;
	int r=-1;
	while(low<=high) {
		int mid=(low+high)/2;
		if(flights.get(mid).getGate().compareTo(gate)<0) {
			low = mid+1;
		}else if(flights.get(mid).getGate().compareTo(gate)>0) {
			high = mid-1;
		}else if(flights.get(mid).getGate().compareTo(gate)==0){
			r=mid;
			return r;
		}
	}
	
	return -1;
}
	
}

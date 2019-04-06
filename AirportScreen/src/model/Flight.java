package model;

public class Flight {
	
	private String time;
	private String airline;
	private String flight;
	private String arriveCity;
	private String terminal;
	private String gate;
	private String remarks;
	
	
	
	public Flight(String time, String airline, String flight, String arriveCity, String terminal, String gate,
			String remarks) {
		this.time = time;
		this.airline = airline;
		this.flight = flight;
		this.arriveCity = arriveCity;
		this.terminal = terminal;
		this.gate = gate;
		this.remarks = remarks;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getFlight() {
		return flight;
	}
	public void setFlight(String flight) {
		this.flight = flight;
	}
	public String getArriveCity() {
		return arriveCity;
	}
	public void setArriveCity(String arriveCity) {
		this.arriveCity = arriveCity;
	}
	public String getTerminal() {
		return terminal;
	}
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
	public String getGate() {
		return gate;
	}
	public void setGate(String gate) {
		this.gate = gate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	
}

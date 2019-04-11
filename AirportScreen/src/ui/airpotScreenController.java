package ui;

import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Airport;
import model.Flight;
import model.TimeComparator;
import thread.TimeThread;

public class airpotScreenController {

    @FXML
    private Label timeLabel;

    @FXML
    private Button generateFlights;

    @FXML
    private TextField textFieldFlights;

    @FXML
    private TableView<Flight> tableView;
    
    @FXML
    private TableColumn<Flight, String> timeColumn;

    @FXML
    private TableColumn<Flight, String> airlineColumn;

    @FXML
    private TableColumn<Flight, String> flightColumn;

    @FXML
    private TableColumn<Flight, String> toColumn;

    @FXML
    private TableColumn<Flight, String> terminalColumn;

    @FXML
    private TableColumn<Flight, String> gateColumn;

    @FXML
    private TableColumn<Flight, String> remarksColumn;
    
    private Airport airport;
    
    ObservableList<Flight> data = FXCollections.observableArrayList();

    @FXML
    void initialize() throws InterruptedException {
    	airport = new Airport();
    	TimeThread tt = new TimeThread(this);
    	tt.start();
    }
    
    @FXML
    void generateFlights(ActionEvent event) {
    	
    	data.clear();
    	
    	for (int i = 0; i < Integer.parseInt(textFieldFlights.getText()); i++) {
			
	    	String time = airport.timeRandom();
	    	String airline = airport.airlineRandom();
	    	String flightNumber = airport.flightRandom(airline);
	    	String cityTo = airport.toRandom();
	    	String terminal = airport.terminalRandom();
	    	String gate = airport.gateRandom();
	    	String remarks = airport.remarksRandom();
	    	
	    	Flight newFlight = new Flight(time, airline, flightNumber, cityTo, terminal, gate, remarks);
	    	data.add(newFlight);
	    	airport.addFlights(newFlight);
	    	System.out.println(""+time+" - "+airline+" - "+flightNumber+" - "+cityTo+" - "+terminal+" - "
	    			+gate+" - "+remarks+" - ");
    	}
    	Collections.sort(data, new TimeComparator());
    	tableView.setItems(data);
    	
    }
    
    public void setTime(String n) {
    	timeLabel.setText(n);
    }
}


import javax.swing.*;

import vehicles.Vehicle;

import java.util.*;
import java.awt.event.*;

public class UserFrame {
	JFrame frame;
	ArrayList<Date> dates = new ArrayList<Date>();
	CongestionTaxCalculator calculator = new CongestionTaxCalculator();
	
	public UserFrame() {
		frame = new JFrame();
		
		// Month selection
		SpinnerModel monthModel = new SpinnerNumberModel(1, 1, 12, 1); // Month 1-12
		JSpinner monthSpinner = new JSpinner(monthModel);
		
		monthSpinner.setBounds(100, 1, 100, 30);
		frame.add(monthSpinner);
		
		JLabel monthLable = new JLabel("Select month:");
		monthLable.setBounds(1,1, 100,30);
		frame.add(monthLable);
		
		
		// Day of month selection
		SpinnerModel dayModel = new SpinnerNumberModel(1, 1, 31, 1); // Day 1-31
		JSpinner daySpinner = new JSpinner(dayModel);
		
		daySpinner.setBounds(100, 40, 100, 30);
		frame.add(daySpinner);
		
		JLabel dayLable = new JLabel("Select day:");
		dayLable.setBounds(1,40, 100,30);
		frame.add(dayLable);
		
		JLabel dayWarningLable = new JLabel("");
		dayWarningLable.setBounds(200,40, 300,30);
		frame.add(dayWarningLable);
		
		
		// Hour of day selection
		SpinnerModel hourModel = new SpinnerNumberModel(0, 0, 23, 1); // hour 0-23
		JSpinner hourSpinner = new JSpinner(hourModel);
				
		hourSpinner.setBounds(100, 80, 100, 30);
		frame.add(hourSpinner);
				
		JLabel hourLable = new JLabel("Select hour:");
		hourLable.setBounds(1,80, 100,30);
		frame.add(hourLable);
		
		
		// Hour of minute selection
		SpinnerModel minuteModel = new SpinnerNumberModel(0, 0, 23, 1); // hour 0-23
		JSpinner minuteSpinner = new JSpinner(minuteModel);
						
		minuteSpinner.setBounds(100, 120, 100, 30);
		frame.add(minuteSpinner);
						
		JLabel minuteLable = new JLabel("Select minute:");
		minuteLable.setBounds(1,120, 100,30);
		frame.add(minuteLable);
		
		// Hour of second selection
		SpinnerModel secondModel = new SpinnerNumberModel(0, 0, 59, 1); // hour 0-59
		JSpinner secondSpinner = new JSpinner(secondModel);

		secondSpinner.setBounds(100, 160, 100, 30);
		frame.add(secondSpinner);
								
		JLabel secondLable = new JLabel("Select second:");
		secondLable.setBounds(1,160, 100,30);
		frame.add(secondLable);
		
		// Show number of crossings
	    JLabel crossingLable = new JLabel("");
		crossingLable.setBounds(155,240, 200,30);
		frame.add(crossingLable);
		
		// Select vehicle type
		String[] vehicles = VehicleTypeHandler.getVehicleTypeNames();
		JComboBox vehicleBox = new JComboBox(vehicles);
		vehicleBox.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		dates = new ArrayList<Date>();
	    		crossingLable.setText("");
	    	}
	    });
		vehicleBox.setBounds(100, 200,100,30);    
	    frame.add(vehicleBox);  
		
	    JLabel vehicleLable = new JLabel("Select vehicle:");
	    vehicleLable.setBounds(1,200, 100,30);
		frame.add(vehicleLable);
		
		// Button to add time
		JButton attCrossingButton =new JButton("Add crossing time");
		attCrossingButton.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    		int month = (int) monthSpinner.getModel().getValue();
			    		int day = (int) daySpinner.getModel().getValue();
			    		int hours = (int) hourSpinner.getModel().getValue();
			    		int minutes = (int) minuteSpinner.getModel().getValue();
			    		int seconds = (int) secondSpinner.getModel().getValue();
				
			    		if(month==2 && day>28 || month==4 && day>30 || month==6 && day>30 || month==9 && day>30 || month==11 && day>30) {
			    			dayWarningLable.setText("Too high day-number: " + day);
			    		} else {
			    			Date date = new Date();
			    			date.setYear(2013); // assumed to be in 2013
			    			date.setMonth(month-1);
			    			date.setHours(hours);
			    			date.setMinutes(minutes);
			    			date.setSeconds(seconds);
			    			
			    			dates.add(date);
			    			
			    			crossingLable.setText("Number of crossings: " + dates.size());
			    		}
			    }
		});  
		attCrossingButton.setBounds(1,240, 150,30);
		frame.add(attCrossingButton);
		
		
		
		// Submit button and output
	    JLabel outPutLable = new JLabel("");
	    outPutLable.setBounds(1,320, 400,30);
	    frame.add(outPutLable);
				
		JButton submitButton =new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(dates.size() < 1) {
	    			crossingLable.setText("Add a crossing time");
	    		}
	    		else {
	    			Date[] dateArray = getDateArray(dates);
	    			String vehicleTypeString = vehicleBox.getSelectedItem().toString();
		    		Vehicle vehicle = VehicleTypeHandler.getVehicleOfType(vehicleTypeString);
		    		
		    		int fee = calculator.getTax(vehicle, dateArray);

		    		outPutLable.setText("Fee: " + fee);
	    		}
	    		
	    	}
        }); 
		
		submitButton.setBounds(1,280, 150,30);
		frame.add(submitButton);
		
		// Frame layout
		frame.setSize(500,500);
		frame.setLayout(null);  
		frame.setVisible(true);
		
	}
	
	private Date[] getDateArray(ArrayList<Date> dates) {
		int length = dates.size();
		Date[] datesArray = new Date[length];
		for(int i=0; i<length; i++) {
			datesArray[i] = dates.get(i);
		}
		return datesArray;
	}
	
}

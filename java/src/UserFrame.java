
import javax.swing.*;


import java.util.*;

public class UserFrame {
	JFrame frame;
	
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
		
		
		
		
		
		
		// Frame layout
		frame.setSize(500,500);
		frame.setLayout(null);  
		frame.setVisible(true);
		
	}
}

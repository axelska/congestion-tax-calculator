import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vehicles.Car;
import vehicles.EmergencyVehicle;
import vehicles.Tractor;

import java.util.Date;

class CongestionTaxCalculatorTest {
	CongestionTaxCalculator congestionTaxCalculator = new CongestionTaxCalculator();
	
	@BeforeEach
	void setUp() throws Exception {
		new CongestionTaxCalculator();
	}

	@Test
	void test() {
		Car car = new Car();
		Tractor tractor = new Tractor();
		EmergencyVehicle emergencyVehicle = new EmergencyVehicle();
		
		// Check the fees at different time points
		Date date1 = new Date();
		date1.setYear(2013);
		date1.setMonth(3);
		date1.setHours(6);
		date1.setMinutes(5);
		date1.setSeconds(3);
		Date[] dates1 = {date1};
				
		assertEquals(8, congestionTaxCalculator.getTax(car, dates1));
				
		Date date2 = new Date();
		date2.setYear(2013);
		date2.setMonth(3);
		date2.setHours(6);
		date2.setMinutes(35);
		date2.setSeconds(3);
		Date[] dates2 = {date2};
				
		assertEquals(13, congestionTaxCalculator.getTax(car, dates2));
				
		Date date3 = new Date();
		date3.setYear(2013);
		date3.setMonth(3);
		date3.setHours(7);
		date3.setMinutes(25);
		date3.setSeconds(3);
		Date[] dates3 = {date3};
				
		assertEquals(18, congestionTaxCalculator.getTax(car, dates3));
				
		Date date4 = new Date();
		date4.setYear(2013);
		date4.setMonth(3);
		date4.setHours(8);
		date4.setMinutes(25);
		date4.setSeconds(3);
		Date[] dates4 = {date4};
				
		assertEquals(13, congestionTaxCalculator.getTax(car, dates4));
				
		Date date5 = new Date();
		date5.setYear(2013);
		date5.setMonth(3);
		date5.setHours(9);
		date5.setMinutes(25);
		date5.setSeconds(3);
		Date[] dates5 = {date5};
				
		assertEquals(8, congestionTaxCalculator.getTax(car, dates5));
				
		Date date6 = new Date();
		date6.setYear(2013);
		date6.setMonth(3);
		date6.setHours(15);
		date6.setMinutes(15);
		date6.setSeconds(3);
		Date[] dates6 = {date6};
				
		assertEquals(13, congestionTaxCalculator.getTax(car, dates6));
				
		Date date7 = new Date();
		date7.setYear(2013);
		date7.setMonth(3);
		date7.setHours(15);
		date7.setMinutes(40);
		date7.setSeconds(3);
		Date[] dates7 = {date7};
				
		assertEquals(18, congestionTaxCalculator.getTax(car, dates7));
				
		Date date8 = new Date();
		date8.setYear(2013);
		date8.setMonth(3);
		date8.setHours(17);
		date8.setMinutes(20);
		date8.setSeconds(3);
		Date[] dates8 = {date8};
				
		assertEquals(13, congestionTaxCalculator.getTax(car, dates8));
				
		Date date9 = new Date();
		date9.setYear(2013);
		date9.setMonth(3);
		date9.setHours(18);
		date9.setMinutes(15);
		date9.setSeconds(3);
		Date[] dates9 = {date9};
				
		assertEquals(8, congestionTaxCalculator.getTax(car, dates9));
				
		Date date10 = new Date();
		date10.setYear(2013);
		date10.setMonth(3);
		date10.setHours(20);
		date10.setMinutes(15);
		date10.setSeconds(3);
		Date[] dates10 = {date10};
				
		assertEquals(0, congestionTaxCalculator.getTax(car, dates10));
		
		// Two examples of toll free vehicle shall have no fee
		Date[] datesAll = {date1, date2, date3, date4, date5, date6, date7, date8, date9, date10};
		assertEquals(0, congestionTaxCalculator.getTax(tractor, datesAll));
		assertEquals(0, congestionTaxCalculator.getTax(emergencyVehicle, datesAll));
		
		// Only taxed once per hour
		Date[] dates11 = {date5, date5};
		
		assertEquals(8, congestionTaxCalculator.getTax(car, dates11));
		
		Date[] dates12 = {date5, date5, date7, date7};
		assertEquals(26, congestionTaxCalculator.getTax(car, dates12));
		// only handles it correctly once
	}

}

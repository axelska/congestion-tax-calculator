
import java.util.*;

import vehicles.Car;
import vehicles.DiplomatVehicle;
import vehicles.EmergencyVehicle;
import vehicles.ForeignVehicle;
import vehicles.MilitaryVehicle;
import vehicles.Motorbike;
import vehicles.Tractor;
import vehicles.Vehicle;

public class VehicleTypeHandler {
	private static Vehicle[] vehicles = {new Motorbike(),
			new Tractor(),
			new EmergencyVehicle(),
			new DiplomatVehicle(),
			new ForeignVehicle(),
			new MilitaryVehicle(),
			new Car()};
	
	public static String[] getVehicleTypeNames() {
		int length = vehicles.length;
		String[] vehicleNames = new String[length];
		
		for(int i = 0; i< length; i++) {
			vehicleNames[i] = vehicles[i].getVehicleType();
		}
		
		return vehicleNames;
	}
	
	public static Vehicle getVehicleOfType(String vehicleType) {
		Vehicle outVehicle = new Car();
		
		for(Vehicle vehicle : vehicles) {
			if(vehicle.getVehicleType().equals(vehicleType)) {
				outVehicle = vehicle;
			}
		}
		return outVehicle;
	}
}

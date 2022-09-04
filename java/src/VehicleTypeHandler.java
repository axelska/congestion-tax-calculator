
import java.util.*;

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
}

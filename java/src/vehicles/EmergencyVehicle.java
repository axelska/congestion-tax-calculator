package vehicles;
public class EmergencyVehicle implements Vehicle {

	@Override
	public String getVehicleType() {
		return "Emergency";
	}
	
	@Override
	public boolean isTollFree() {
		return true;
	}
}

package vehicles;
public class MilitaryVehicle implements Vehicle {

	@Override
	public String getVehicleType() {
		return "Military";
	}
	
	@Override
	public boolean isTollFree() {
		return true;
	}
}

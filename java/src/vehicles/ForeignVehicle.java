package vehicles;
public class ForeignVehicle implements Vehicle {
	@Override
	public String getVehicleType() {
		return "Foreign";
	}
	
	@Override
	public boolean isTollFree() {
		return true;
	}
}

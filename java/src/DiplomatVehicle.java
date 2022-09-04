
public class DiplomatVehicle implements Vehicle {

	@Override
	public String getVehicleType() {
		return "Diplomat";
	}
	
	@Override
	public boolean isTollFree() {
		return true;
	}
}

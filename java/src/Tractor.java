
public class Tractor implements Vehicle {

	@Override
	public String getVehicleType() {
		return "Tractor";
	}
	
	@Override
	public boolean isTollFree() {
		return true;
	}
}

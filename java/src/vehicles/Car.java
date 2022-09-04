package vehicles;


import java.util.*;
import java.text.*;

public class Car implements Vehicle {
	@Override
    public String getVehicleType() {
        return "Car";
    }
	
	@Override
	public boolean isTollFree() {
		return false;
	}
}

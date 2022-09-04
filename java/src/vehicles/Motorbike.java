package vehicles;


import java.util.*;
import java.text.*;

public class Motorbike implements Vehicle {
    @Override
    public String getVehicleType() {
        return "Motorbike";
    }
    
    @Override
	public boolean isTollFree() {
		return true;
	}
}

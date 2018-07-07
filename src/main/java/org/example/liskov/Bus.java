package org.example.liskov;

public class Bus extends Vehicle {

	@Override
	public int getSpeed() {
		System.out.println("Bus: getSpeed");
		return 0;
	}

	@Override
	public int getCubicCapacity() {
		System.out.println("Bus: getCubicCapacity");
		return 0;
	}
	
	public String getEmergencyExitLoc() {
		System.out.println("Bus: getCubicgetEmergencyExitLocCapacity");
		return "Emergency Exit";
	}

}

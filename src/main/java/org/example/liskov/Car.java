package org.example.liskov;

public class Car extends Vehicle {

	@Override
	public int getSpeed() {
		System.out.println("Car: getSpeed");
		return 0;
	}

	@Override
	public int getCubicCapacity() {
		System.out.println("Car: getCubicCapacity");
		return 0;
	}
	
	public boolean isHatchBack() {
		System.out.println("Car: isHatchBack");
		return true;
	}
}

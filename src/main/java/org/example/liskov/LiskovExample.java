package org.example.liskov;

import org.example.onlineagendaapp.io.OnlineAgendaIO;
import org.example.onlineagendaapp.io.impl.FileOnlineAgendaIO;

public class LiskovExample {

	public static void main(String[] args) {
		Vehicle vehicle = new Car();
		useVehicle(vehicle);

		vehicle = new Bus();
		useVehicle(vehicle);

		vehicle = new Vehicle();
		useVehicle(vehicle);
		
		Car car = new Car();
		useVehicle(car);
		
		CopyMain copyMain = new CopyMain();
		OnlineAgendaIO writer = new FileOnlineAgendaIO();
		copyMain.setWriter(writer);
		
		copyMain.print();
		

	}

	public static void useVehicle(Vehicle vehicle) {
		vehicle.getSpeed();
		if(vehicle instanceof Car) {
			((Car) vehicle).isHatchBack();
		}
		if(vehicle instanceof Bus) {
			((Bus) vehicle).getEmergencyExitLoc();
		}
	}
	
	public static class CopyMain {
		private OnlineAgendaIO reader;
		private OnlineAgendaIO writer;
		
		public void print() {
			writer.getOnlineAgenda();
		}

		public OnlineAgendaIO getReader() {
			return reader;
		}

		public void setReader(OnlineAgendaIO reader) {
			this.reader = reader;
		}

		public OnlineAgendaIO getWriter() {
			return writer;
		}

		public void setWriter(OnlineAgendaIO writer) {
			this.writer = writer;
		}
		
	}

}

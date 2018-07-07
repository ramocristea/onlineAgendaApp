package org.example.onlineagendaapp.service;

import java.time.LocalDateTime;

import org.example.onlineagendaapp.OnlineAgendaController;
import org.example.onlineagendaapp.model.Priority;
import org.example.onlineagendaapp.model.Task;

public class OnlineAgendaService {
	
	public static void addTaskToAgenda(LocalDateTime completionDate, String description, Priority priority) {
		int id = OnlineAgendaController.getNextRandomId();
		OnlineAgendaController.idList.add(id);
		Task tomorrowTask = new Task(id, completionDate, priority, description);
		OnlineAgendaController.onlineAgenda.getTasks().add(tomorrowTask);
	}

}

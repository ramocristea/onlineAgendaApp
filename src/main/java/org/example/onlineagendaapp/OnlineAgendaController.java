package org.example.onlineagendaapp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.commons.collections4.CollectionUtils;
import org.example.onlineagendaapp.comparator.TaskComparator;
import org.example.onlineagendaapp.model.OnlineAgenda;
import org.example.onlineagendaapp.model.Priority;
import org.example.onlineagendaapp.model.Task;
import org.example.onlineagendaapp.service.OnlineAgendaService;

/**
 * Test your Online Agenda
 *
 * TODO extract CRUD operations
 *
 */
public class OnlineAgendaController {

	public static OnlineAgenda onlineAgenda;
	public static List<Integer> idList = new ArrayList<>();
	private static OnlineAgendaService onlineAgendaService = new OnlineAgendaService();

	public static void main(String[] args) {
		initializeAgenda();
		printAllTasksInTheAgenda();

		System.out.println("-----------------------------");

		onlineAgendaService.addTaskToAgenda(LocalDateTime.of(2018, 7, 5, 17, 50), "New task for today", Priority.IMPORTANT);
		onlineAgendaService.addTaskToAgenda(LocalDateTime.of(2018, 7, 5, 19, 50), "New task for today 2", Priority.IMPORTANT);
		printAllTasksInTheAgenda();

		System.out.println("-----------------------------");

		// deleteTaskFromAgenda(idList.get(0));
		printAllTasksInTheAgenda();

		System.out.println("-----------------------------");

		printAllTasksForToday();
	}

	private static void initializeAgenda() {
		onlineAgenda = new OnlineAgenda();
		int id;

		LocalDateTime today = LocalDateTime.now();

		id = getNextRandomId();
		idList.add(id);
		Task yesterdayTask = new Task(id, today.minusDays(1), Priority.URGENT, "Yesterday's Task");
		onlineAgenda.getTasks().add(yesterdayTask);

		id = getNextRandomId();
		idList.add(id);
		Task todayTask = new Task(id, today, Priority.TRIVIAL, "Today's Task");
		onlineAgenda.getTasks().add(todayTask);

		id = getNextRandomId();
		idList.add(id);
		Task tomorrowTask = new Task(id, today.plusDays(1), Priority.IMPORTANT, "Tomorrow's Task");
		onlineAgenda.getTasks().add(tomorrowTask);
	}

	private static void deleteTaskFromAgenda(int id) {
		Iterator<Task> iterator = onlineAgenda.getTasks().iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getId() == id) {
				iterator.remove();
				return;
			}
		}
	}

	private static void updateTaskPriority(int id, Priority newPriority) {
		for (Task task : onlineAgenda.getTasks()) {
			if (task.getId() == id) {
				task.setPriority(newPriority);
				return;
			}
		}
	}

	public static int getNextRandomId() {
		Random random = new Random();
		return random.nextInt(10000);
	}

	private static List<Task> getTasksByPriorityAndDate(List<Task> tasks, Priority priority, LocalDate date) {
		List<Task> tasksByPriorityAndDate = new ArrayList<>();
		
		for(Task task : tasks) {
			if(task.getPriority() == priority && date.equals(task.getTargetCompletionDate().toLocalDate())) {
				tasksByPriorityAndDate.add(task);
			}
		}
		
		return tasksByPriorityAndDate;
	}

	private static void printAllTasksForToday() {
		List<Task> urgentTasksForToday = getTasksByPriorityAndDate(onlineAgenda.getTasks(), Priority.URGENT, LocalDate.now());
		List<Task> importantTasksForToday = getTasksByPriorityAndDate(onlineAgenda.getTasks(), Priority.IMPORTANT, LocalDate.now());
		List<Task> trivialTasksForToday = getTasksByPriorityAndDate(onlineAgenda.getTasks(), Priority.TRIVIAL, LocalDate.now());

		Collections.sort(urgentTasksForToday, new TaskComparator());
		Collections.sort(importantTasksForToday, new TaskComparator());
		Collections.sort(trivialTasksForToday, new TaskComparator());
		
		printTasksFromList(urgentTasksForToday, Priority.URGENT, LocalDate.now());
		System.out.println("-----------------------------");
		printTasksFromList(importantTasksForToday, Priority.IMPORTANT, LocalDate.now());
		System.out.println("-----------------------------");
		printTasksFromList(trivialTasksForToday, Priority.TRIVIAL, LocalDate.now());
	}
	
	/**
	 * Prints all tasks from a list. It uses priority and date to construct the appropriate message
	 * 
	 * @param tasks
	 * @param priority requires
	 * @param date required
	 */
	private static void printTasksFromList(List<Task> tasks, Priority priority, LocalDate date) {
		System.out.println(priority.name() + " tasks for " + date.toString());
		
		if(CollectionUtils.isEmpty(tasks)) {
			System.out.println("You have no " + priority.name() + " tasks for " + date.toString());
			return;
		} 
		
		for(Task task : tasks) {
			System.out.println(task.toString());
		}
	}
	
	private static void printAllTasksInTheAgenda() {
		for (Task task : onlineAgenda.getTasks()) {
			System.out.println(task);
		}
	}

}

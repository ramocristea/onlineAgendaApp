package org.example.javaconventions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.commons.collections4.CollectionUtils;
import org.example.onlineagendaapp.model.OnlineAgenda;
import org.example.onlineagendaapp.model.Priority;
import org.example.onlineagendaapp.model.Task;

public class JavaConventionsExample {
	private static OnlineAgenda onlineAgenda;
	private static List<Integer> ids = new ArrayList<>();

	public static void main(String[] args) {
		createAgenda();
		printAllTasksInTheAgenda();

		System.out.println("-----------------------------");

		addTaskToAgenda(LocalDateTime.of(2018, 7, 5, 17, 50), "New task for today", Priority.IMPORTANT);
		addTaskToAgenda(LocalDateTime.of(2018, 7, 5, 19, 50), "New task for today 2", Priority.IMPORTANT);
		printAllTasksInTheAgenda();

		System.out.println("-----------------------------");

		tasksfortoday();
	}

	private static void createAgenda() {
		onlineAgenda = new OnlineAgenda();
		int id;

		LocalDateTime today = LocalDateTime.now();

		Task yesterdayTask = new Task();
		id = getNextRandomId();
		ids.add(id);
		yesterdayTask.setId(id);
		yesterdayTask.setTargetCompletionDate(today.minusDays(1));
		yesterdayTask.setPriority(Priority.URGENT);
		yesterdayTask.setDescription("Yesterday's Task");
		onlineAgenda.getTasks().add(yesterdayTask);

		Task todayTask = new Task();
		id = getNextRandomId();
		ids.add(id);
		todayTask.setId(id);
		todayTask.setTargetCompletionDate(today);
		todayTask.setPriority(Priority.TRIVIAL);
		todayTask.setDescription("Today's Task");
		onlineAgenda.getTasks().add(todayTask);

		Task tomorrowTask = new Task();
		id = getNextRandomId();
		ids.add(id);
		tomorrowTask.setId(id);
		tomorrowTask.setTargetCompletionDate(today.plusDays(1));
		tomorrowTask.setPriority(Priority.IMPORTANT);
		tomorrowTask.setDescription("Tomorrow's Task");
		onlineAgenda.getTasks().add(tomorrowTask);
	}

	private static void printAllTasksInTheAgenda() {
		for (Task task : onlineAgenda.getTasks()) {
			System.out.println(task);
		}
	}

	private static void addTaskToAgenda(LocalDateTime targetCompletionDate, String description, Priority priority) {
		Task tomorrowTask = new Task();
		int id = getNextRandomId();
		ids.add(id);
		tomorrowTask.setId(id);
		tomorrowTask.setTargetCompletionDate(targetCompletionDate);
		tomorrowTask.setPriority(priority);
		tomorrowTask.setDescription(description);
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

	private static int getNextRandomId() {
		Random random = new Random();
		return random.nextInt(100);
	}

	private static void tasksfortoday() {
		List<Task> urgentTasks = new ArrayList<>();
		List<Task> importantTasks = new ArrayList<>();
		List<Task> trivialTasks = new ArrayList<>();

		for (Task task : onlineAgenda.getTasks()) {
			if (LocalDate.now().isEqual(task.getTargetCompletionDate().toLocalDate())) {
				switch (task.getPriority()) {
				case URGENT:
					urgentTasks.add(task);
					break;
				case IMPORTANT:
					importantTasks.add(task);
					break;
				case TRIVIAL:
					trivialTasks.add(task);
					break;
				}
			}
		}

		Collections.sort(urgentTasks, new Comparator<Task>() {
			@Override
			public int compare(Task task1, Task task2) {
				if (task1.getTargetCompletionDate() == null && task2.getTargetCompletionDate() != null) {
					return -1;
				}
				return task1.getTargetCompletionDate().compareTo(task2.getTargetCompletionDate());
			}
		});

		System.out.println("URGENT tasks for today:");
		if (CollectionUtils.isEmpty(urgentTasks)) {
			System.out.println("You have no URGENT tasks");
		} else {
			for (Task task : urgentTasks) {
				System.out.println(task.toString());
			}
		}

		System.out.println("-----------------------------");

		System.out.println("IMPORTANT tasks for today:");
		if (CollectionUtils.isEmpty(importantTasks)) {
			System.out.println("You have no IMPORTANT tasks");
		} else {
			for (Task task : importantTasks) {
				System.out.println(task.toString());
			}
		}
		
		System.out.println("-----------------------------");
		
		System.out.println("TRIVIAL tasks for today:");
		if (CollectionUtils.isEmpty(trivialTasks)) {
			System.out.println("You have no TRIVIAL tasks");
		} else {
			for (Task task : trivialTasks) {
				System.out.println(task.toString());
			}
		}
	}

}

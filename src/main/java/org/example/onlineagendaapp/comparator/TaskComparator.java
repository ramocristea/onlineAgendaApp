package org.example.onlineagendaapp.comparator;

import java.util.Comparator;

import org.example.onlineagendaapp.model.Task;

public class TaskComparator implements Comparator<Task> {

	@Override
	public int compare(Task o1, Task o2) {
		if (o1.getTargetCompletionDate() == null && o2.getTargetCompletionDate() != null) {
			return -1;
		}
		return o1.getTargetCompletionDate().compareTo(o2.getTargetCompletionDate());
	}
}

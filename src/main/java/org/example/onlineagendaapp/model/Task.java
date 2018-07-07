package org.example.onlineagendaapp.model;

import java.time.LocalDateTime;

public class Task {

	private int id;
	private LocalDateTime targetCompletionDate;
	private Priority priority;
	private String description;
	private boolean done = false;
	
	public Task() {
	}
	
	public Task(LocalDateTime targetCompletionDate, Priority priority, String description) {
		this.targetCompletionDate = targetCompletionDate;
		this.priority = priority;
		this.description = description;
	}
	
	public Task(int id, LocalDateTime targetCompletionDate, Priority priority, String description) {
		this.id = id;
		this.targetCompletionDate = targetCompletionDate;
		this.priority = priority;
		this.description = description;
	}

	public LocalDateTime getTargetCompletionDate() {
		return targetCompletionDate;
	}

	public void setTargetCompletionDate(LocalDateTime targetCompletionDate) {
		this.targetCompletionDate = targetCompletionDate;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((targetCompletionDate == null) ? 0 : targetCompletionDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (targetCompletionDate == null) {
			if (other.targetCompletionDate != null)
				return false;
		} else if (!targetCompletionDate.equals(other.targetCompletionDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", targetCompletionDate=" + targetCompletionDate + ", priority=" + priority
				+ ", description=" + description + "]";
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

}

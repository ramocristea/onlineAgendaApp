# Digital agenda

Create an application that simulates a digital agenda. It allows you to create and add tasks, which contain the target date to complete and a description. You can prioritize the tasks in 3 different priorities: URGENT, IMPORTANT, TRIVIAL. You can set a time when you want to be notified about the unfinished tasks of the current day.

* allow user to add, update priority or delete tasks in the agenda (Eg: allow user to change priority of a task, allow user to mark a task as DONE)
* display all the unfinished tasks for the current day, grouped by priority and ordered by time. If there are no tasks for a certain priority, print an appropriate message
* display all the unfinished tasks for a certain day, grouped by priority and ordered by time
* display all the unfinished tasks for a certain day, based on priority and ordered by time (Eg: all URGENT tasks for 7.07.2018)
* when the user marks a task as DONE, the task should no longer appear in the unfinished task list
* let the user set a time when he wants to receive notifications about the day's unfinished tasks
* notify the user about the day's unfinished tasks at the hour he has previously set. If no hour is set, return a message to reflect this
* add the ability to mark a task to be automatically upgraded to a higher priority if it's not done until the initial target date

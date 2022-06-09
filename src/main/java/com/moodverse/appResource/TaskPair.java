package com.moodverse.appResource;

/*
 a class for tasks, to know if the task is done (true), or not (false) and the message of said task (string)
*/

public class TaskPair {
    private int taskPairId;
    private int toDoListId;
    private boolean done;
    private String task;

    public TaskPair(int taskPairId, int toDoListId, String task, boolean done) {
        this.taskPairId = taskPairId;
        this.task = task;
        this.toDoListId = toDoListId;
        this.done = done;
    }

    public int getToDoListId() {
        return toDoListId;
    }

    public void setToDoListId(int toDoListId) {
        this.toDoListId = toDoListId;
    }

    public int getTaskPairId() {
        return taskPairId;
    }

    public void setTaskPairId(int taskPairId) {
        this.taskPairId = taskPairId;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "done=" + done +
                ", task='" + task + '\'' +
                '}';
    }
}

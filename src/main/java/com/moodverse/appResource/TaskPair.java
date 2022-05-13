package com.moodverse.appResource;

/*
 a class for tasks, to know if the task is done (true), or not (false) and the message of said task (string)
*/

public class TaskPair {
    private boolean done;
    private String task;

    public TaskPair(String task) {
        this.done = false;
        this.task = task;
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

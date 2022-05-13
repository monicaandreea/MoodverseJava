package com.moodverse.appResource;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoList {
    String title;
    List<TaskPair> tasks;
    int progress;

    public ToDoList(String title) {
        this.title = title;
        List<TaskPair> default_task = new ArrayList<>();
        default_task.add(new TaskPair("Default task 1."));
        default_task.add(new TaskPair("Default task 2."));
        default_task.add(new TaskPair("Default task 3."));
        this.tasks = default_task;
        this.progress = 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<TaskPair> getTasks() {
        return tasks;
    }

    public int getProgress() {
        return progress;
    }

    public void calculateProgress() {
        for(TaskPair task : this.tasks)
            if (task.isDone()) this.progress += 1;
    }

    public void toggleDone(int index){
        TaskPair task = this.tasks.get(index);
        if(task.isDone()){
            task.setDone(false);
            this.progress -=1;
        }
        else{
            task.setDone(true);
            this.progress +=1;
        }
    }

    public void changeTask(int index){
        Scanner read = new Scanner(System.in);
        TaskPair task = this.tasks.get(index);
        String new_text = read.nextLine();

        task.setTask(new_text);
    }

    public void addTask(String text){
        TaskPair task = new TaskPair(text);
        this.tasks.add(task);
    }

    public void removeTask(int index){
        this.tasks.remove(index);
    }

    @Override
    public String toString() {
        return "ToDoList{" +
                "title='" + title + '\'' +
                ", tasks=" + tasks +
                ", progress=" + progress + "/" + tasks.size() +
                '}';
    }
}

package com.mokamoka.features.Task;

import java.util.ArrayList;

/**
 * Task
 */
public class Task {

    private static ArrayList<Task> tasks = new ArrayList<>();

    private String name;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void save() {
        tasks.add(this);
    }

    public static int count() {
        return tasks.size();
    }
}
package com.mokamoka.main;

import java.util.Scanner;

import com.mokamoka.features.Task.Task;

/**
 * MokamokaApp
 */
public class MokamokaApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean inserting = true;

        while (inserting) {
            System.out.print("Insert task name = ");

            Task task = new Task(scanner.nextLine());
            task.save();

            System.out.print("Insert again (y/n) = ");

            String again = scanner.nextLine();

            inserting = again.toLowerCase().equals("y");
        }

        System.out.println(Task.count());
    }
    
}
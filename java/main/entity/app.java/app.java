package com.example.todo;

import com.example.todo.service.TaskService;
import com.example.todo.entity.Task;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        TaskService service = new TaskService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- To-Do List ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String desc = scanner.nextLine();
                    service.addTask(desc);
                    break;
                case 2:
                    for (Task task : service.listTasks()) {
                        System.out.println(task);
                    }
                    break;
                case 3:
                    System.out.print("Enter task ID to mark completed: ");
                    int idComplete = scanner.nextInt();
                    service.markTaskCompleted(idComplete);
                    break;
                case 4:
                    System.out.print("Enter task ID to delete: ");
                    int idDelete = scanner.nextInt();
                    service.deleteTask(idDelete);
                    break;
                case 5:
                    System.out.println("Good
package com.mokamoka.core.menu;

import java.util.Scanner;

/**
 * MenuConsole
 */
public final class MenuConsole {

    public MenuConsole() {}

    private static void displayList() {
        System.out.println("What do you want to do?");

        String[] menus = {"Add Expense"};
        
        for (int i = 0; i < menus.length; i ++) {
            System.out.printf("%d. %s%n", i + 1, menus[i]);
        }
    }

    private static int selectMenu() {
        Scanner scanner = new Scanner(System.in);

        int selectedNumber;

        do {
            System.out.print("Select menu (by number) = ");
            
            while (!) {
                
            }
        } while (selectedNumber < 1);

        return selectedNumber;
    }

    public static void displayAndSelect() {
        MenuConsole.displayList();
        MenuConsole.selectMenu();
    }
}
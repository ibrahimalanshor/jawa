import java.util.Scanner;

class Main {

    static String menus[] = {"List all tasks", "Add tasks", "Exit"};
    static int selectedMenuNumber;

    public static void displayMenus() {
        for (int i = 0; i < menus.length; i++) {
            System.out.printf("%d. %s%n", i + 1, menus[i]);
        }
    }

    public static void switchMenu() {
        switch (selectedMenuNumber) {
            case 1:
                if (Task.count() < 1) {
                    System.out.println("No Task Available");

                    break;
                }

                for (Task task : Task.getAll()) {
                    System.out.println(task.id + ". " + task.name);
                }

                break;

            case 2:
                Scanner scanner = new Scanner(System.in);

                System.out.print("Task name = ");

                String name = scanner.nextLine();

                Task task = new Task(name);

                task.save();
                break;
        
            default:
                break;
        }
    }

    public static void selectMenu() throws InvalidMenuNumberException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Select menu (by number) = ");
        
        try {
            selectedMenuNumber = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new InvalidMenuNumberException(e);
        } 

        if (selectedMenuNumber < 1 || selectedMenuNumber > menus.length) {
            throw new InvalidMenuNumberException();
        }

        switchMenu();
    }

    public static void main(String args[]) {
        do {
            displayMenus();
        
            try {
                selectMenu();
            } catch (InvalidMenuNumberException e) {
                System.out.println(e.getMessage());

                break;
            }
        } while (selectedMenuNumber != 3);
    }

}
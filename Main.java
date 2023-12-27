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
                System.out.println("Displaying All Task");
                break;

            case 2:
                System.out.println("New Task");
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
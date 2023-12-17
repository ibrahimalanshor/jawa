import java.util.Scanner;

class Main {

    static String menus[] = {"List all tasks", "Add tasks", "Exit"};

    public static void displayMenus() {
        for (int i = 0; i < menus.length; i++) {
            System.out.printf("%d. %s%n", i + 1, menus[i]);
        }
    }

    public static int selectMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Select menu (by number) = ");
        
        int selectedMenuNumber = Integer.parseInt(scanner.nextLine());

        if (selectedMenuNumber < 1 || selectedMenuNumber > menus.length) {
            throw new NumberFormatException("Invalud menu number (%d)%n");
        }

        return selectedMenuNumber;
    }

    public static void main(String args[]) {
        int selectedMenuNumber;        
        
        do {
            displayMenus();
        
            try {
                selectedMenuNumber = selectMenu();
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());

                break;
            }
        } while (selectedMenuNumber != 3);
    }

}
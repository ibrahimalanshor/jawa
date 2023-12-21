import java.util.Scanner;

class Main {

    static String menus[] = {"List all tasks", "Add tasks", "Exit"};

    public static void displayMenus() {
        for (int i = 0; i < menus.length; i++) {
            System.out.printf("%d. %s%n", i + 1, menus[i]);
        }
    }

    public static int selectMenu() throws InvalidMenuNumberException {
        Scanner scanner = new Scanner(System.in);
        int selectedMenuNumber;

        System.out.print("Select menu (by number) = ");
        
        try {
            selectedMenuNumber = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new InvalidMenuNumberException(e);
        } 

        if (selectedMenuNumber < 1 || selectedMenuNumber > menus.length) {
            throw new InvalidMenuNumberException();
        }

        return selectedMenuNumber;
    }

    public static void main(String args[]) {
        int selectedMenuNumber;        
        
        do {
            displayMenus();
        
            try {
                selectedMenuNumber = selectMenu();
            } catch (InvalidMenuNumberException e) {
                System.out.println(e.getMessage());

                break;
            }
        } while (selectedMenuNumber != 3);
    }

}
class Main {

    public static void displayMenus() {
        String menus[] = {"List all todos", "Add todos"};

        for (int i = 0; i < menus.length; i++) {
            System.out.printf("%d. %s%n", i + 1, menus[i]);
        }
    }

    public static void main(String args[]) {
        displayMenus();
    }

}
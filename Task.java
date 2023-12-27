public class Task {
    private static Task[] tasks = {};

    public static Task[] getAll() {
        return tasks;
    }

    public static int count() {
        return tasks.length;
    }
}

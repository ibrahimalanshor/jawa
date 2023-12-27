import java.util.ArrayList;

public class Task {
    public String name;
    private static ArrayList<Task> tasks = new ArrayList<>();

    public Task(String name) {
        this.name = name;
    }

    public static ArrayList<Task> getAll() {
        return tasks;
    }

    public static int count() {
        return tasks.size();
    }

    public void save() {
        tasks.add(this);
    }
}

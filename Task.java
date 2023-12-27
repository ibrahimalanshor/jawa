import java.util.ArrayList;

public class Task {
    public int id;
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

    public static int getLatestId() {
        if (count() < 1) {
            return 0;
        }

        return tasks.get(count() - 1).id;
    }

    public void save() {
        this.id = getLatestId() + 1;

        tasks.add(this);
    }
}

import java.util.Date;

public class Task {
    private String date;
    private String task;
    private boolean isCompleted;
    private String id;

    public Task(String date, String task, boolean isCompleted, String id) {
        this.date = date;
        this.task = task;
        this.isCompleted = isCompleted;
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public String getTask() {
        return task;
    }

    public String getIsComplited() {
        if (isCompleted)
            return "completed";
        else
            return "not completed";
    }

    public String getId() {
        return id;
    }

    public void setDate(Date date) {
        this.date = date.toString();
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void changeComleteness() {
        isCompleted = !isCompleted;
    }

    public String toString() {
        return date + " " + task;
    }

    public void setId(String id) {
        this.id = id;
    }
}
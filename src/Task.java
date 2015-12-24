import java.util.Date;

/**
 * Created by Макс on 24.12.2015.
 */
public class Task {
    private Date date;
    private String task;
    private boolean isCompleted;

    public Task(Date date, String task, boolean isCompleted) {
        this.date = date;
        this.task = task;
        this.isCompleted = isCompleted;
    }

    public Date getDate() {
        return date;
    }

    public String getTask() {
        return task;
    }

    public boolean getIsComplited() {
        return isCompleted;
    }

    public void setDate(Date date) {
        this.date = date;
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
}

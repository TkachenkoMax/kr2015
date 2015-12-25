import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;

public class TaskTableModel extends Observable {
  /*  private List<Task> tasks = new ArrayList<Task>();
    private String[] taskNames = new String[0];

    public void add(Date date, String task, boolean isCompleted) {
        tasks.add(new Task(date, task, isCompleted));
        setChanged();
        notifyObservers();
    }

    public void add(Task task) {
        tasks.add(task);
        setChanged();
        notifyObservers();
    }

    public Task getAt(int index) {
        return tasks.get(index);
    }

    public int getSize() {
        return tasks.size();
    }

    public boolean delete(String tourName, String date) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getPropTourName().equals(tourName) && tours.get(i).getPropDate().equals(date)) {
                tours.remove(i);
                this.tourNames = this.getAllTourName();
                this.setChanged();
                this.notifyObservers();
                return true;
            }
        }
        return false;
    }

    public void clear() {
        this.tasks.clear();
        this.setChanged();
        this.notifyObservers();
    }*/
}
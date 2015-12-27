import java.io.FileNotFoundException;
import java.util.*;

public class TaskTableModel extends Observable {
    private List<Task> tasks = new LinkedList<Task>();
    private List<Task> comletedTasks = new LinkedList<Task>();
    private List<Task> notComletedTasks = new LinkedList<Task>();
    private String[] taskNames = new String[0];
    private int id;
    private WorkWithFiles wwf = new WorkWithFiles();

    public TaskTableModel() {
        tasks = wwf.readTasks();
        id = tasks.size();
        creatingArrays();
        setChanged();
        notifyObservers();
    }

    public void rewriteAllFiles() throws FileNotFoundException {
        for (int i = 0; i < tasks.size(); i++) {
            wwf.rewriteTask(tasks.get(i));
        }
    }

    public void creatingArrays() {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getIsComplited().equals("completed")) {
                comletedTasks.add(tasks.get(i));
            } else {
                notComletedTasks.add(tasks.get(i));
            }
        }
    }

    public void add(String date, String task, boolean isCompleted) throws FileNotFoundException {
        id++;
        String idString = new Integer(id).toString();
        tasks.add(new Task(date, task, isCompleted, idString));
        wwf.rewriteTask(new Task(date, task, isCompleted, idString));
        setChanged();
        notifyObservers();
    }

    public void add(Task task) {
        tasks.add(task);
        setChanged();
        notifyObservers();
    }

    public int getSize() {
        return tasks.size();
    }

    public String getId(int index) {
        return tasks.get(index).getId();
    }

    public String getDate(int index) {
        return tasks.get(index).getDate();
    }

    public String getTask(int index) {
        return tasks.get(index).getTask();
    }

    public String getComleteness(int index) {
        return tasks.get(index).getIsComplited();
    }

    public String[] getAllTasksId() {
        String[] names = new String[tasks.size()];
        for (int i = 0; i < tasks.size(); i++) {
            names[i] = tasks.get(i).getId();
        }
        return names;
    }

    public boolean delete(int pos) throws FileNotFoundException {
        tasks.get(pos).changeComleteness();
        this.taskNames = this.getAllTasksId();
        rewriteAllFiles();
        this.setChanged();
        this.notifyObservers();
        return true;
    }

    public void changeAllId() {
        for (int i = 0; i < tasks.size(); i++) {
            tasks.get(i).setId(new Integer(i + 1).toString());
        }
    }

    public void deleteCompleted() throws FileNotFoundException {
        id = 0;
        comletedTasks.clear();
        notComletedTasks.clear();
        creatingArrays();
        clear();
        comletedTasks.clear();
        wwf.deleteAllFiles();
        for (int i = 0; i < notComletedTasks.size(); i++) {
            tasks.add(notComletedTasks.get(i));
            changeAllId();
            wwf.rewriteTask(notComletedTasks.get(i));
            id++;
        }
        setChanged();
        notifyObservers();
    }

    public void clear() {
        this.tasks.clear();
        this.setChanged();
        this.notifyObservers();
    }
}
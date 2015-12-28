import java.io.FileNotFoundException;
import java.util.*;

public class TaskTableModel extends Observable {
    private List<Task> tasks = new LinkedList<Task>();
    private List<Task> tasksClone = new LinkedList<Task>();
    private List<Task> completedTasks = new LinkedList<Task>();
    private List<Task> notCompletedTasks = new LinkedList<Task>();
    private String[] taskNames = new String[0];
    private int id;
    private WorkWithFiles wwf = new WorkWithFiles();

    public TaskTableModel() {
        tasks = wwf.readTasks();
        for (int i = 0; i < tasks.size(); i++) {
            tasksClone.add(tasks.get(i));
        }
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
                completedTasks.add(tasks.get(i));
            } else {
                notCompletedTasks.add(tasks.get(i));
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

    public String getCompleteness(int index) {
        return tasks.get(index).getIsComplited();
    }

    public String[] getAllTasksId() {
        String[] names = new String[tasks.size()];
        for (int i = 0; i < tasks.size(); i++) {
            names[i] = tasks.get(i).getId();
        }
        return names;
    }

    public void delete(int pos) throws FileNotFoundException {
        tasks.get(pos).changeCompleteness();
        creatingArrays();
        //tasksClone.get(pos).changeCompleteness();
        this.taskNames = this.getAllTasksId();
        rewriteAllFiles();
        this.setChanged();
        this.notifyObservers();
    }

    public void changeAllId() {
        for (int i = 0; i < tasks.size(); i++) {
            tasks.get(i).setId(new Integer(i + 1).toString());
        }
    }

    public void deleteCompleted() throws FileNotFoundException {
        id = 0;
        completedTasks.clear();
        notCompletedTasks.clear();
        creatingArrays();
        clear();
        tasksClone.clear();
        completedTasks.clear();
        wwf.deleteAllFiles();
        for (int i = 0; i < notCompletedTasks.size(); i++) {
            tasks.add(notCompletedTasks.get(i));
            tasksClone.add(notCompletedTasks.get(i));
            changeAllId();
            wwf.rewriteTask(notCompletedTasks.get(i));
            id++;
        }
        setChanged();
        notifyObservers();
    }

    public void refresh(int count) {
        if (count == 0) {
            tasks.clear();
        }
        if (count == 1) {
            tasks.clear();
            for (int i = 0; i < completedTasks.size(); i++) {
                tasks.add(completedTasks.get(i));
            }
        }
        if (count == 2) {
            tasks.clear();
            for (int i = 0; i < notCompletedTasks.size(); i++) {
                tasks.add(notCompletedTasks.get(i));
            }
        }
        if (count == 3) {
            tasks.clear();
            for (int i = 0; i < tasksClone.size(); i++) {
                tasks.add(tasksClone.get(i));
            }
        }
        this.setChanged();
        this.notifyObservers();
    }

    public void clear() {
        this.tasks.clear();
        this.setChanged();
        this.notifyObservers();
    }
}
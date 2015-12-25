import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WorkWithFiles {

    private static final String TASKS_FOLDER = "tasks";
    private File[] files;
    private Map<String, String> tasksNameDate = new HashMap<String, String>();

    public WorkWithFiles() {
        File myFolder = new File(WorkWithFiles.TASKS_FOLDER);
        this.files = myFolder.listFiles();
        String name = "";
        for (int i = 0; i < files.length; i++) {
            name = this.files[i].getName().substring(0, 9);
            this.tasksNameDate.put(name, "None");
        }
    }

    public Task getTaskById(String id) {
        Scanner sc = null;
        try {
            FileReader fr = new FileReader(TASKS_FOLDER + "\\task_" + id + ".txt");
            sc = new Scanner(fr);
        } catch (FileNotFoundException e) {
            return null;
        }
        if (isAvaivable(id)) {
            String line = "";
            line = sc.nextLine();
            String taskId = line;
            line = sc.nextLine();
            String date = line;
            line = sc.nextLine();
            String task = line;
            line = sc.nextLine();
            String isCompleted = line;
            boolean tf=false;
            if (isCompleted.equals("completed")) {
                tf = true;
            }
            if (isCompleted.equals("not completed")) {
                tf = false;
            }
            sc.close();
            tasksNameDate.put(id, date);
            return new Task(date, task, tf, id);
        }
        return null;
    }

    public boolean isAvaivable(String id) {
        String[] names = getAllNames();
        String taskId = "";
        for (int i = 0; i < getAllNames().length; i++) {
            taskId = names[i].substring(5);
            if (taskId.equals(id)) return true;
        }
        return false;
    }

    public String[] getAllNames() {
        String[] names = new String[tasksNameDate.size()];
        names = tasksNameDate.keySet().toArray(names);
        return names;
    }

    public void addTour(Task task) throws FileNotFoundException {
        rewriteTour(task);
    }

    public String getNameOfFile(String id) {
        return TASKS_FOLDER + "\\task_" + id + ".txt";
    }

    public void rewriteTour(Task tour) throws FileNotFoundException {
        File file = new File(getNameOfFile(tour.getId()));
        PrintWriter pw = new PrintWriter(file);
        String line = "";
        pw.write(tour.getId());
        pw.println();
        pw.write(tour.getDate());
        pw.println();
        pw.write(tour.getTask());
        pw.println();
        pw.write(tour.getIsComplited());
        pw.println();
        pw.close();
        tasksNameDate.put(tour.getId(), tour.getDate());
    }

    public static void main(String[] args) throws FileNotFoundException {
        WorkWithFiles workWithFiles = new WorkWithFiles();
        Date date = new Date();
        String ddate = date.toString();

        Task task = new Task(ddate, "Сделать курсач по ООП", false, "1");
        Task task1 = new Task(ddate, "Сделать курсач по алгоритмам", false, "2");
        Task task2 = new Task(ddate, "Закрыть теор. вер", false, "3");
        workWithFiles.addTour(task);
        workWithFiles.addTour(task1);
        workWithFiles.addTour(task2);

        Task task3 = new Task();
        task3 = workWithFiles.getTaskById("1");
        task3.toString();
    }
}

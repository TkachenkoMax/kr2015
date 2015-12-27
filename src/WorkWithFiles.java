import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

public class WorkWithFiles {

    private static final String TASKS_FOLDER = "tasks";

    public String getNameOfFile(String id) {
        return TASKS_FOLDER + "\\task_" + id + ".txt";
    }

    public void rewriteTask(Task task) throws FileNotFoundException {
        File file = new File(getNameOfFile(task.getId()));
        PrintWriter pw = new PrintWriter(file);
        pw.write(task.getId());
        pw.println();
        pw.write(task.getDate());
        pw.println();
        pw.write(task.getTask());
        pw.println();
        pw.write(task.getIsComplited());
        pw.println();
        pw.close();
    }

    public List<Task> readTasks() {
        LinkedList<Task> taskList = new LinkedList<Task>();
        File dir = new File(TASKS_FOLDER);
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            Scanner sc = null;
            try {
                FileReader fr = new FileReader(TASKS_FOLDER + "\\" + files[i].getName());
                sc = new Scanner(fr);
            } catch (FileNotFoundException e) {
                return null;
            }
            String line = "";
            line = sc.nextLine();
            String id = line;
            line = sc.nextLine();
            String date = line;
            line = sc.nextLine();
            String task = line;
            line = sc.nextLine();
            String isCompleted = line;
            sc.close();
            boolean tf = false;
            if (isCompleted.equals("completed")) {
                tf = true;
            }
            if (isCompleted.equals("not completed")) {
                tf = false;
            }
            taskList.add(new Task(date, task, tf, id));
        }
        return taskList;
    }

    public void deleteAllFiles() throws FileNotFoundException {
        File dir = new File(TASKS_FOLDER);
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            new File(TASKS_FOLDER + "\\" + files[i].getName()).delete();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        WorkWithFiles wwf = new WorkWithFiles();
        wwf.deleteAllFiles();
    }
}
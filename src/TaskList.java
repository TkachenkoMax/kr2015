import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

public class TaskList extends JPanel {
    private JLabel taskListLabel;
    private JTextField newTaskTextField;
    private JButton addButton;
    private JButton deleteButton;
    private JButton deleteCompletedButton;
    private TaskTableView taskTableView;
    private TaskTableModel taskTableModel;

    public TaskList() {
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        this.setBackground(Color.BLACK);

        taskListLabel = new JLabel("Task List");
        taskListLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        taskListLabel.setForeground(Color.WHITE);

        newTaskTextField = new JTextField();

        addButton = new JButton("Add task");

        deleteButton = new JButton("Change completeness");

        deleteCompletedButton = new JButton("Delete completed tasks");

        deleteButton.setBackground(Color.BLACK);
        deleteButton.setForeground(Color.ORANGE);
        deleteCompletedButton.setBackground(Color.BLACK);
        deleteCompletedButton.setForeground(Color.RED);
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.GREEN);

        taskTableModel = new TaskTableModel();
        taskTableView = new TaskTableView(taskTableModel);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (newTaskTextField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "No text in the field! Write something...");
                } else {
                    Date date = new Date();
                    String dateString = date.toString();
                    String task = newTaskTextField.getText();
                    try {
                        taskTableModel.add(dateString, task, false);
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                    newTaskTextField.setText("");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int pos = taskTableView.getSelectedRow();
                if (pos > -1) {
                    try {
                        taskTableModel.delete(pos);
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        deleteCompletedButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    taskTableModel.deleteCompleted();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });

        this.add(taskListLabel, new GridBagConstraints(0, 0, GridBagConstraints.REMAINDER, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(taskTableView, new GridBagConstraints(0, 1, GridBagConstraints.REMAINDER, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(deleteButton, new GridBagConstraints(0, 2, GridBagConstraints.REMAINDER, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(deleteCompletedButton, new GridBagConstraints(0, 3, GridBagConstraints.REMAINDER, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(newTaskTextField, new GridBagConstraints(0, 4, 2, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(addButton, new GridBagConstraints(3, 4, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
    }
}
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;

public class TaskList extends JPanel {
    private JLabel taskListLabel;
    private JList taskList;
    private JTextField newTaskTextField;
    private JButton addButton;
    private JButton deleteButton;

    public TaskList() {
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        this.setBackground(Color.BLACK);

        final DefaultListModel listModel = new DefaultListModel();

        taskListLabel = new JLabel("Task List");
        taskListLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        taskListLabel.setForeground(Color.WHITE);

        taskList = new JList(listModel);

        newTaskTextField = new JTextField();

        addButton = new JButton("Add task");


        deleteButton = new JButton("Task completed");

        deleteButton.setBackground(Color.BLACK);
        deleteButton.setForeground(Color.RED);
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.GREEN);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (newTaskTextField.getText().equals("")){
                    JOptionPane.showMessageDialog(MainForm.mainFrame, "No text in the field! Write something...");
                }
                String element = newTaskTextField.getText();
                listModel.addElement(element);
                int index = listModel.size() - 1;
                taskList.setSelectedIndex(index);
                taskList.ensureIndexIsVisible(index);
                newTaskTextField.setText("");
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listModel.remove(taskList.getSelectedIndex());
            }
        });

        taskList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (taskList.getSelectedIndex() >= 0) {
                    deleteButton.setEnabled(true);
                } else {
                    deleteButton.setEnabled(false);
                }
            }
        });

        //gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,fill,insets,ipadx,ipady
        this.add(taskListLabel, new GridBagConstraints(0, 0, GridBagConstraints.REMAINDER, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(taskList, new GridBagConstraints(0, 1, GridBagConstraints.REMAINDER, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(deleteButton, new GridBagConstraints(0, 2, GridBagConstraints.REMAINDER, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(newTaskTextField, new GridBagConstraints(0, 3, 2, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(addButton, new GridBagConstraints(3, 3, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
    }
}

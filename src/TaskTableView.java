import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class TaskTableView extends JPanel {
    private TaskTableModel model;
    private JTable table = new JTable();

    public TaskTableView() {
        this(null);
    }

    public TaskTableView(TaskTableModel model) {
        this.setModel(model);
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        this.setBackground(Color.BLACK);
        this.setBorder(new LineBorder(Color.WHITE, 1));

        JScrollPane scroll = new JScrollPane(this.table);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        this.add(scroll, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));

    }

    public void setModel(TaskTableModel model) {
        if (model == null) {
            this.table.setModel(new DefaultTableModel());
            return;
        }
        this.model = model;
        this.table.setModel(new ModelForTable(model));
    }

    public TaskTableModel getModel() {
        return model;
    }

    public void addSelectionListener(ListSelectionListener listener) {
        ListSelectionModel model = this.table.getSelectionModel();
        model.addListSelectionListener(listener);
    }

    public int getSelectedRow() {
        return this.table.getSelectedRow();
    }

    public JTable getTable() {
        return table;
    }

    private class ModelForTable extends AbstractTableModel implements Observer {
        private TaskTableModel tab_model;

        @Override
        public int getColumnCount() {
            return 4;
        }

        public Class getColumnClass(int c) {
            return String.class;
        }

        @Override
        public String getColumnName(int col) {
            switch (col) {
                case 0:
                    return "ID";
                case 1:
                    return "Date";
                case 2:
                    return "Task";
                case 3:
                    return "Status";
            }
            return "";
        }

        public ModelForTable(TaskTableModel m) {
            assert (m != null);
            this.tab_model = m;
            this.tab_model.addObserver(this);
        }

        @Override
        public int getRowCount() {
            return this.tab_model.getSize();
        }

        @Override
        public Object getValueAt(int row, int col) {
            String[] tasksNames = this.tab_model.getAllTasksId();
            switch (col) {
                case 0:
                    return tab_model.getId(row);
                case 1:
                    return tab_model.getDate(row);
                case 2:
                    return tab_model.getTask(row);
                case 3:
                    return tab_model.getComleteness(row);
            }
            assert (false);
            return null;
        }

        @Override
        public void update(Observable arg0, Object arg1) {
            this.fireTableDataChanged();
        }
    }
}
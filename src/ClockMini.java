import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class ClockMini extends JPanel {
    private JTextField timeField;
    private JTextField dateField;


    public ClockMini() {
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        this.setBackground(Color.BLACK);

        timeField = new JTextField();

        timeField.setEditable(false);
        timeField.setForeground(Color.RED);
        timeField.setBackground(Color.BLACK);
        timeField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        timeField.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        timeField.setBorder(new LineBorder(Color.BLACK, 1));

        dateField = new JTextField();

        dateField.setEditable(false);
        dateField.setForeground(Color.BLUE);
        dateField.setBackground(Color.BLACK);
        dateField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        dateField.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        dateField.setBorder(new LineBorder(Color.BLACK, 1));

        this.add(dateField, new GridBagConstraints(0, 0, GridBagConstraints.REMAINDER, 1, 1, 0.1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(timeField, new GridBagConstraints(0, 1, GridBagConstraints.REMAINDER, 1, 1, 0.1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));

        Timer t = new Timer(1000, new Listener());
        t.start();
    }

    class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Calendar currentTime = Calendar.getInstance();
            int hour = currentTime.get(Calendar.HOUR_OF_DAY);
            int min = currentTime.get(Calendar.MINUTE);
            int sec = currentTime.get(Calendar.SECOND);

            int year = currentTime.get(Calendar.YEAR);
            int month = currentTime.get(Calendar.MONTH);
            int day = currentTime.get(Calendar.DAY_OF_MONTH);

            dateField.setText("Today: " + day + "." + month + "." + year);
            timeField.setText("Current time: " + hour + ":" + min + ":" + sec);
        }
    }
}

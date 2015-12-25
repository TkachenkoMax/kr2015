import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch extends JPanel {
    private int hour = 0;
    private int min = 0;
    private int sec = 0;
    private JLabel hourLabel;
    private JLabel minLabel;
    private JLabel secLabel;
    private JLabel hourLabelInfo;
    private JLabel minLabelInfo;
    private JLabel secLabelInfo;
    private JButton startButton;
    private JButton stopButton;
    private JButton resetButton;

    public Stopwatch() {
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        this.setBackground(Color.BLACK);

        Font buttonsFont = new Font("Times New Roman", Font.PLAIN, 30);
        Font labelFont = new Font("Times New Roman", Font.PLAIN, 48);

        hourLabel = new JLabel(Integer.toString(hour));
        minLabel = new JLabel(Integer.toString(min));
        secLabel = new JLabel(Integer.toString(sec));
        hourLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        minLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        secLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        hourLabelInfo = new JLabel("Min");
        minLabelInfo = new JLabel("Sec");
        secLabelInfo = new JLabel("Msec");
        hourLabelInfo.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        minLabelInfo.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        secLabelInfo.setHorizontalAlignment(SwingConstants.HORIZONTAL);

        hourLabel.setFont(labelFont);
        minLabel.setFont(labelFont);
        secLabel.setFont(labelFont);

        hourLabel.setForeground(Color.RED);
        minLabel.setForeground(Color.RED);
        secLabel.setForeground(Color.RED);
        hourLabelInfo.setForeground(Color.BLUE);
        minLabelInfo.setForeground(Color.BLUE);
        secLabelInfo.setForeground(Color.BLUE);
        hourLabel.setBorder(new LineBorder(Color.WHITE, 2));
        minLabel.setBorder(new LineBorder(Color.WHITE, 2));
        secLabel.setBorder(new LineBorder(Color.WHITE, 2));

        startButton = new JButton("START");
        stopButton = new JButton("STOP");
        resetButton = new JButton("RESET");
        startButton.setFont(buttonsFont);
        stopButton.setFont(buttonsFont);
        resetButton.setFont(buttonsFont);
        startButton.setBackground(new Color(0x40402F));
        stopButton.setBackground(new Color(0x40402F));
        resetButton.setBackground(new Color(0x40402F));
        startButton.setForeground(new Color(0xFF6504));
        stopButton.setForeground(new Color(0xFF6504));
        resetButton.setForeground(new Color(0xFF6504));

        this.add(hourLabelInfo, new GridBagConstraints(0, 0, 2, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(minLabelInfo, new GridBagConstraints(2, 0, 2, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(secLabelInfo, new GridBagConstraints(4, 0, 2, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(hourLabel, new GridBagConstraints(0, 1, 2, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(minLabel, new GridBagConstraints(2, 1, 2, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(secLabel, new GridBagConstraints(4, 1, 2, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(startButton, new GridBagConstraints(0, 2, 6, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(stopButton, new GridBagConstraints(0, 3, 6, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(resetButton, new GridBagConstraints(0, 4, 6, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));

        final Timer t = new Timer(100, new Listener());

        startButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.start();
            }
        });

        stopButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.stop();
            }
        });

        resetButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.stop();
                hour = 0;
                min = 0;
                sec = 0;
                hourLabel.setText(Integer.toString(hour));
                minLabel.setText(Integer.toString(min));
                secLabel.setText(Integer.toString(sec));
            }
        });
    }

    public int getHour() {
        return hour;
    }

    public int getMin() {
        return min;
    }

    public int getSec() {
        return sec;
    }

    public void setHour(int hour) {
        this.hour = hour;
        hourLabel.setText(Integer.toString(hour));
    }

    public void setMin(int min) {
        this.min = min;
        minLabel.setText(Integer.toString(min));
    }

    public void setSec(int sec) {
        this.sec = sec;
        secLabel.setText(Integer.toString(sec));
    }

    class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int hour = getHour();
            int min = getMin();
            int sec = getSec();

            sec++;

            if (sec == 10) {
                sec = 0;
                min++;
            }

            if (min == 60) {
                min = 0;
                hour++;
            }
            setHour(hour);
            setMin(min);
            setSec(sec);
        }
    }
} 

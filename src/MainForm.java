import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainForm extends JFrame {
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JTabbedPane jTabbedPane;
    private NotePad notePad;
    private TaskList taskList;
    private Calc calc;
    private ClockMini clockMini;
    private Stopwatch stopwatch;
    private MyTimer myTimer;
    public static MainForm window;

    public MainForm() {
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeigth = screenSize.height;

        mainFrame.setBounds(screenWidth / 4, screenHeigth / 4, screenWidth / 2, screenHeigth / 2);
        mainFrame.setTitle("kr2015");

        mainPanel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        mainPanel.setLayout(layout);

        mainPanel.setBackground(Color.BLACK);

        jTabbedPane = new JTabbedPane();

        notePad = new NotePad();
        taskList = new TaskList();
        calc = new Calc();
        clockMini = new ClockMini();
        stopwatch = new Stopwatch();
        myTimer = new MyTimer();

        JPanel timerAndStopwatch = new JPanel();
        timerAndStopwatch.setLayout(layout);
        timerAndStopwatch.setBackground(Color.BLACK);

        JLabel stopwatchLabel = new JLabel("Stopwatch");
        stopwatchLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        stopwatchLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        stopwatchLabel.setBackground(Color.BLACK);
        stopwatchLabel.setForeground(Color.WHITE);

        JLabel timerLabel = new JLabel("Timer");
        timerLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        timerLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        timerLabel.setBackground(Color.BLACK);
        timerLabel.setForeground(Color.WHITE);

        timerAndStopwatch.add(stopwatchLabel, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        timerAndStopwatch.add(stopwatch, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        timerAndStopwatch.add(timerLabel, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        timerAndStopwatch.add(myTimer, new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));

        jTabbedPane.addTab("Timer and Stopwatch", timerAndStopwatch);
        jTabbedPane.addTab("Calc", calc);
        jTabbedPane.addTab("Notepad", notePad);
        jTabbedPane.addTab("Task list", taskList);

        final ClockPanel clockPanel = new ClockPanel(new Clock(16, 27));
        clockPanel.setBackground(Color.BLACK);

        //gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,fill,insets,ipadx,ipady
        mainPanel.add(clockPanel, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        mainPanel.add(clockMini, new GridBagConstraints(0, 1, 1, 1, 1, 0.1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        mainPanel.add(jTabbedPane, new GridBagConstraints(1, 0, 1, 2, 0.4, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));

        JOptionPane.showMessageDialog(mainFrame, "Помните, любой баг - ЭТО ФИЧА!");

        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);

        mainFrame.pack();
        mainFrame.setResizable(false);

        Timer timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                clockPanel.repaint();
            }

        });
        timer.start();
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    window = new MainForm();
                    window.mainFrame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
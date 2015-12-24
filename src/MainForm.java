import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainForm extends JFrame {
    public static JFrame mainFrame;
    private JPanel mainPanel;
    private JTabbedPane jTabbedPane;
    private NotePad notePad;
    private TaskList taskList;
    public static MainForm window;

    public MainForm() {
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

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

        //jTabbedPane.addTab("World Clock", new JPanel());
        //jTabbedPane.addTab("Calc", new JPanel());
        jTabbedPane.addTab("Notepad", notePad);
        //jTabbedPane.addTab("Calendar", new JPanel());
        jTabbedPane.addTab("Task list", taskList);
        //jTabbedPane.addTab("Contacts", new JPanel());

        final ClockPanel clockPanel = new ClockPanel(new Clock(16, 27));
        clockPanel.setBackground(Color.BLACK);

        //gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,fill,insets,ipadx,ipady
        mainPanel.add(clockPanel, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        mainPanel.add(jTabbedPane, new GridBagConstraints(1, 0, 1, 1, 0.4, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));

        mainFrame.add(mainPanel);

        Timer timer = new Timer(500, new ActionListener() {

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

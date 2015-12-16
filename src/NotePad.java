import javax.swing.*;
import java.awt.*;

public class NotePad extends JPanel{
    JMenuBar menuBar;
    JLabel nameOfFile;
    JScrollPane textScrollPane;
    JTextArea textArea;
    JButton textPlus;
    JButton textMinus;

    public NotePad(){
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        this.setBackground(Color.BLACK);

        menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");

        JMenu newMenu = new JMenu("New");
        fileMenu.add(newMenu);
        JMenu openMenu = new JMenu("Open");
        fileMenu.add(openMenu);
        JMenu saveMenu = new JMenu("Save");
        fileMenu.add(saveMenu);

        menuBar.add(fileMenu);

        nameOfFile = new JLabel("New text file");
        nameOfFile.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        nameOfFile.setForeground(Color.WHITE);

        textArea = new JTextArea();
        textArea.setEditable(true);
        textArea.setBackground(Color.WHITE);

        textScrollPane = new JScrollPane(textArea);
        textScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        this.add(menuBar, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(nameOfFile, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(textScrollPane, new GridBagConstraints(0, 1, 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
    }
}

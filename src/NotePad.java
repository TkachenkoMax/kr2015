import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class NotePad extends JPanel {
    private JMenuBar menuBar;
    private JLabel nameOfFile;
    private JScrollPane textScrollPane;
    private JTextArea textArea;
    private JButton textPlus;
    private JButton textMinus;
    private JFileChooser fileChooser;
    private FileInputStream fileInputStream;
    private File file;

    public NotePad() {
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        this.setBackground(Color.BLACK);

        menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");

        JMenuItem newMenu = new JMenuItem("New");
        fileMenu.add(newMenu);
        JMenuItem openMenu = new JMenuItem("Open");
        fileMenu.add(openMenu);
        JMenuItem saveMenu = new JMenuItem("Save");
        fileMenu.add(saveMenu);

        menuBar.add(fileMenu);

        nameOfFile = new JLabel("New text file");
        nameOfFile.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        nameOfFile.setForeground(Color.WHITE);

        textArea = new JTextArea();
        textArea.setEditable(true);
        textArea.setBackground(Color.WHITE);
        textArea.setLineWrap(true);

        textScrollPane = new JScrollPane(textArea);
        textScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        textPlus = new JButton("+");
        textMinus = new JButton("-");

        openMenu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReadFile();
            }
        });

        //gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,fill,insets,ipadx,ipady
        this.add(menuBar, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(nameOfFile, new GridBagConstraints(1, 0, 3, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(textScrollPane, new GridBagConstraints(0, 1, GridBagConstraints.REMAINDER, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(textPlus, new GridBagConstraints(0, 2, 2, 1, 0.5, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(textMinus, new GridBagConstraints(2, 2, GridBagConstraints.REMAINDER, 1, 0.5, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
    }

    public void ReadFile() {
        fileChooser = new JFileChooser();
        int ret = fileChooser.showDialog(null, "Open file");
        if (ret == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            nameOfFile.setText(file.getName());
            long lengthFile = file.length();
            byte[] filesBytes = new byte[(int) lengthFile];
            try {
                fileInputStream = new FileInputStream(file);
                fileInputStream.read(filesBytes);
                fileInputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            textArea.setText(new String(filesBytes, StandardCharsets.UTF_8));
        }
    }
}

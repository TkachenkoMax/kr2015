import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.*;

public class NotePad extends JPanel {
    private JMenuBar menuBar;
    private JLabel nameOfFile;
    private JScrollPane textScrollPane;
    private JTextArea textArea;
    private JFileChooser fileChooser;
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    private JTextField sizeOfFont;
    private JComboBox styleOfFont;
    private JComboBox typeOfFont;
    private JLabel sizeLabel;
    private JLabel styleLabel;
    private JLabel typeLabel;
    private JButton changeButton;
    private File file;

    public NotePad() {
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        this.setBackground(Color.BLACK);

        menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        menuBar.setBackground(Color.BLACK);
        fileMenu.setForeground(Color.WHITE);

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
        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        textScrollPane = new JScrollPane(textArea);
        textScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        openMenu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ReadFile();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        newMenu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newFile();
            }
        });

        saveMenu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFile(textArea.getText().getBytes());
            }
        });

        String[] masStyles = {"Times New Roman", "Arial", "Calibri", "Tahoma"};
        String masTypes[] = {"Normal", "Bold", "Italics"};

        styleOfFont = new JComboBox(masStyles);
        typeOfFont = new JComboBox(masTypes);

        sizeLabel = new JLabel("Size");
        typeLabel = new JLabel("Type");
        styleLabel = new JLabel("Style");

        sizeLabel.setBackground(Color.BLACK);
        sizeLabel.setForeground(Color.WHITE);
        typeLabel.setBackground(Color.BLACK);
        typeLabel.setForeground(Color.WHITE);
        styleLabel.setBackground(Color.BLACK);
        styleLabel.setForeground(Color.WHITE);
        sizeLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        typeLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        styleLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);

        changeButton = new JButton("Apply changes");
        changeButton.setBackground(Color.BLACK);
        changeButton.setForeground(Color.RED);

        sizeOfFont = new JTextField("20");

        changeButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((Integer.parseInt(sizeOfFont.getText()) < 8) || (Integer.parseInt(sizeOfFont.getText()) > 48) || (sizeOfFont.getText().equals(""))) {
                    JOptionPane.showMessageDialog(null, "Enter the size of the font in a range 8-48");
                } else {
                    ChangeFont();
                }
            }
        });

        this.add(menuBar, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(nameOfFile, new GridBagConstraints(1, 0, 3, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(textScrollPane, new GridBagConstraints(0, 1, GridBagConstraints.REMAINDER, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(styleLabel, new GridBagConstraints(0, 2, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(typeLabel, new GridBagConstraints(1, 2, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(sizeLabel, new GridBagConstraints(2, 2, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(styleOfFont, new GridBagConstraints(0, 3, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(typeOfFont, new GridBagConstraints(1, 3, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(sizeOfFont, new GridBagConstraints(2, 3, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(changeButton, new GridBagConstraints(3, 3, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
    }


    public void newFile() {
        String name = JOptionPane.showInputDialog(null, "Enter the name of a note");
        File file = new File("notes/" + name + ".txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        nameOfFile.setText(name);
    }

    public void saveFile(byte[] data) {
        try {
            File file = new File("notes/" + nameOfFile.getText() + ".txt");
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(data);
            fileOutputStream.close();
            JOptionPane.showMessageDialog(null, "Note '" + nameOfFile.getText() + "' successfully saved!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ReadFile() throws IOException {
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

    public void ChangeFont() {
        Object object = styleOfFont.getItemAt(styleOfFont.getSelectedIndex());
        String style = object.toString();
        object = typeOfFont.getItemAt(typeOfFont.getSelectedIndex());
        String type = object.toString();
        int size = Integer.parseInt(sizeOfFont.getText());
        if (type.equals("Normal")) {
            Font font = new Font(style, Font.PLAIN, size);
            textArea.setFont(font);
        }
        if (type.equals("Bold")) {
            Font font = new Font(style, Font.BOLD, size);
            textArea.setFont(font);
        }
        if (type.equals("Italics")) {
            Font font = new Font(style, Font.ITALIC, size);
            textArea.setFont(font);
        }
    }
}
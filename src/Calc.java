import javafx.beans.property.adapter.JavaBeanBooleanProperty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Calc extends JPanel {
    private JLabel calcLabel;
    private JTextField solution;
    private JButton resetButton;
    private JButton backButton;
    private JButton seven;
    private JButton eight;
    private JButton nine;
    private JButton division;
    private JButton four;
    private JButton five;
    private JButton six;
    private JButton multiplication;
    private JButton one;
    private JButton two;
    private JButton three;
    private JButton subtracting;
    private JButton zero;
    private JButton resultButton;
    private JButton adding;
    private double result;
    private int prevStep;
    private boolean tf;

    public Calc() {
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        this.setBackground(Color.BLACK);

        Font buttonsFont = new Font("Times New Roman", Font.PLAIN, 48);
        Font textFieldFont = new Font("Times New Roman", Font.PLAIN, 20);

        calcLabel = new JLabel("Calculator");
        calcLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        calcLabel.setForeground(Color.WHITE);

        solution = new JTextField();
        solution.setEditable(false);
        solution.setFont(textFieldFont);

        resetButton = new JButton("Reset");
        backButton = new JButton("<");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");
        division = new JButton("/");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        multiplication = new JButton("*");
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        subtracting = new JButton("-");
        zero = new JButton("0");
        resultButton = new JButton("=");
        adding = new JButton("+");

        adding.setFont(buttonsFont);
        one.setFont(buttonsFont);
        two.setFont(buttonsFont);
        three.setFont(buttonsFont);
        four.setFont(buttonsFont);
        five.setFont(buttonsFont);
        six.setFont(buttonsFont);
        seven.setFont(buttonsFont);
        eight.setFont(buttonsFont);
        nine.setFont(buttonsFont);
        zero.setFont(buttonsFont);
        multiplication.setFont(buttonsFont);
        resetButton.setFont(buttonsFont);
        backButton.setFont(buttonsFont);
        subtracting.setFont(buttonsFont);
        division.setFont(buttonsFont);
        resultButton.setFont(buttonsFont);

        one.setBackground(Color.BLACK);
        one.setForeground(Color.BLUE);
        two.setBackground(Color.BLACK);
        two.setForeground(Color.BLUE);
        three.setBackground(Color.BLACK);
        three.setForeground(Color.BLUE);
        four.setBackground(Color.BLACK);
        four.setForeground(Color.BLUE);
        five.setBackground(Color.BLACK);
        five.setForeground(Color.BLUE);
        six.setBackground(Color.BLACK);
        six.setForeground(Color.BLUE);
        seven.setBackground(Color.BLACK);
        seven.setForeground(Color.BLUE);
        eight.setBackground(Color.BLACK);
        eight.setForeground(Color.BLUE);
        nine.setBackground(Color.BLACK);
        nine.setForeground(Color.BLUE);
        resetButton.setBackground(Color.BLACK);
        resetButton.setForeground(Color.RED);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.RED);
        multiplication.setBackground(Color.BLACK);
        multiplication.setForeground(Color.RED);
        adding.setBackground(Color.BLACK);
        adding.setForeground(Color.RED);
        division.setBackground(Color.BLACK);
        division.setForeground(Color.RED);
        subtracting.setBackground(Color.BLACK);
        subtracting.setForeground(Color.RED);
        resultButton.setBackground(Color.BLACK);
        resultButton.setForeground(Color.RED);
        zero.setBackground(Color.BLACK);
        zero.setForeground(Color.BLUE);

        one.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (prevStep == 5) {
                    result = 0;
                    solution.setText("1");
                    prevStep = 0;
                } else {
                    String prev = solution.getText();
                    prev += "1";
                    solution.setText(prev);
                }
            }
        });

        two.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (prevStep == 5) {
                    result = 0;
                    solution.setText("2");
                    prevStep = 0;
                } else {
                    String prev = solution.getText();
                    prev += "2";
                    solution.setText(prev);
                }
            }
        });

        three.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (prevStep == 5) {
                    result = 0;
                    solution.setText("3");
                    prevStep = 0;
                } else {
                    String prev = solution.getText();
                    prev += "3";
                    solution.setText(prev);
                }
            }
        });

        four.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (prevStep == 5) {
                    result = 0;
                    solution.setText("4");
                    prevStep = 0;
                } else {
                    String prev = solution.getText();
                    prev += "4";
                    solution.setText(prev);
                }
            }
        });

        five.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (prevStep == 5) {
                    result = 0;
                    solution.setText("5");
                    prevStep = 0;
                } else {
                    String prev = solution.getText();
                    prev += "5";
                    solution.setText(prev);
                }
            }
        });

        six.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (prevStep == 5) {
                    result = 0;
                    solution.setText("6");
                    prevStep = 0;
                } else {
                    String prev = solution.getText();
                    prev += "6";
                    solution.setText(prev);
                }
            }
        });

        seven.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (prevStep == 5) {
                    result = 0;
                    solution.setText("7");
                    prevStep = 0;
                } else {
                    String prev = solution.getText();
                    prev += "7";
                    solution.setText(prev);
                }
            }
        });

        eight.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (prevStep == 5) {
                    result = 0;
                    solution.setText("8");
                    prevStep = 0;
                } else {
                    String prev = solution.getText();
                    prev += "8";
                    solution.setText(prev);
                }
            }
        });

        nine.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (prevStep == 5) {
                    result = 0;
                    solution.setText("9");
                    prevStep = 0;
                } else {
                    String prev = solution.getText();
                    prev += "9";
                    solution.setText(prev);
                }
            }
        });

        zero.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (prevStep == 5) {
                    result = 0;
                    solution.setText("0");
                    prevStep = 0;
                } else {
                    if ((prevStep == 4)&&(solution.getText().equals(""))) {
                        JOptionPane.showMessageDialog(null, "Эй ты, сучий пес, я тебя на ноль умножу!");
                    } else {
                        String prev = solution.getText();
                        prev += "0";
                        solution.setText(prev);
                    }
                }
            }
        });

        backButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prev = solution.getText();
                if (prev.length() != 0)
                    prev = prev.substring(0, prev.length() - 1);
                solution.setText(prev);
                if (prevStep == 5) {
                    if (prev.equals("")) {
                        result = 0;
                        prevStep = 0;
                        tf = false;
                    } else {
                        result = Integer.valueOf(solution.getText()).intValue();
                    }
                }
            }
        });

        resetButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solution.setText("");
                result = 0;
                prevStep = 0;
                tf = false;
            }
        });

        adding.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (solution.getText().equals("")) {
                } else {
                    if (prevStep == 0) {
                        result += Integer.valueOf(solution.getText()).intValue();
                    } else if (prevStep == 1) {
                        result += Integer.valueOf(solution.getText()).intValue();
                    } else if (prevStep == 2) {
                        result -= Integer.valueOf(solution.getText()).intValue();
                    } else if (prevStep == 3) {
                        result *= Integer.valueOf(solution.getText()).intValue();
                    } else if (prevStep == 4) {
                        result /= Integer.valueOf(solution.getText()).intValue();
                    }
                    solution.setText("");
                    prevStep = 1;
                    tf = true;
                }
            }
        });

        subtracting.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (solution.getText().equals("")) {
                } else {
                    if (prevStep == 0) {
                       result += Integer.valueOf(solution.getText()).intValue();
                    } else if (prevStep == 1) {
                        result += Integer.valueOf(solution.getText()).intValue();
                    } else if (prevStep == 2) {
                        result -= Integer.valueOf(solution.getText()).intValue();
                    } else if (prevStep == 3) {
                        result *= Integer.valueOf(solution.getText()).intValue();
                    } else if (prevStep == 4) {
                        result /= Integer.valueOf(solution.getText()).intValue();
                    }
                    solution.setText("");
                    prevStep = 2;
                    tf = true;
                }
            }
        });

        multiplication.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (solution.getText().equals("")) {
                } else {
                    if (prevStep == 0) {
                        result += Integer.valueOf(solution.getText()).intValue();
                    } else if (prevStep == 1) {
                        result += Integer.valueOf(solution.getText()).intValue();
                    } else if (prevStep == 2) {
                        result -= Integer.valueOf(solution.getText()).intValue();
                    } else if (prevStep == 3) {
                        result *= Integer.valueOf(solution.getText()).intValue();
                    } else if (prevStep == 4) {
                        result /= Integer.valueOf(solution.getText()).intValue();
                    }
                    solution.setText("");
                    prevStep = 3;
                    tf = true;
                }
            }
        });

        division.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (solution.getText().equals("")) {
                } else {
                    if (prevStep == 0) {
                        result += Integer.valueOf(solution.getText()).intValue();
                    } else if (prevStep == 1) {
                        result += Integer.valueOf(solution.getText()).intValue();
                    } else if (prevStep == 2) {
                        result -= Integer.valueOf(solution.getText()).intValue();
                    } else if (prevStep == 3) {
                        result *= Integer.valueOf(solution.getText()).intValue();
                    } else if (prevStep == 4) {
                        result /= Integer.valueOf(solution.getText()).intValue();
                    }
                    solution.setText("");
                    prevStep = 4;
                    tf = true;
                }
            }
        });

        resultButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((solution.getText().equals("")) || (tf == false)) {
                } else {
                    if (prevStep == 1) {
                        result += Integer.valueOf(solution.getText()).intValue();
                    } else if (prevStep == 2) {
                        result -= Integer.valueOf(solution.getText()).intValue();
                    } else if (prevStep == 3) {
                        result *= Integer.valueOf(solution.getText()).intValue();
                    } else if (prevStep == 4) {
                        result /= Integer.valueOf(solution.getText()).intValue();
                    }
                    solution.setText(Double.toString(result));
                    prevStep = 5;
                }
            }
        });

        this.add(calcLabel, new GridBagConstraints(0, 0, GridBagConstraints.REMAINDER, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(solution, new GridBagConstraints(0, 1, 5, 1, 1, 0.4, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(resetButton, new GridBagConstraints(0, 2, 3, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(backButton, new GridBagConstraints(4, 2, GridBagConstraints.REMAINDER, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(seven, new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(eight, new GridBagConstraints(1, 3, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(nine, new GridBagConstraints(2, 3, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(division, new GridBagConstraints(3, 3, GridBagConstraints.REMAINDER, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(four, new GridBagConstraints(0, 4, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(five, new GridBagConstraints(1, 4, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(six, new GridBagConstraints(2, 4, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(multiplication, new GridBagConstraints(3, 4, GridBagConstraints.REMAINDER, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(one, new GridBagConstraints(0, 5, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(two, new GridBagConstraints(1, 5, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(three, new GridBagConstraints(2, 5, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(subtracting, new GridBagConstraints(3, 5, GridBagConstraints.REMAINDER, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(resultButton, new GridBagConstraints(0, 6, 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(zero, new GridBagConstraints(2, 6, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        this.add(adding, new GridBagConstraints(3, 6, GridBagConstraints.REMAINDER, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
    }
}

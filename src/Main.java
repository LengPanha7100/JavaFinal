import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    private JTextField firstNumberField, secondNumberField, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton, percentButton, clearButton;

    public Main() {
        setTitle("Calculator");
        setLayout(new GridLayout(6, 2, 10, 10));

        add(new JLabel("First Number:"));
        firstNumberField = new JTextField();
        add(firstNumberField);

        add(new JLabel("Second Number:"));
        secondNumberField = new JTextField();
        add(secondNumberField);

        add(new JLabel("Result:"));
        resultField = new JTextField();
        resultField.setEditable(false);
        add(resultField);

        addButton = new JButton("+");
        addButton.addActionListener(this);
        add(addButton);

        subtractButton = new JButton("-");
        subtractButton.addActionListener(this);
        add(subtractButton);

        multiplyButton = new JButton("*");
        multiplyButton.addActionListener(this);
        add(multiplyButton);

        divideButton = new JButton("/");
        divideButton.addActionListener(this);
        add(divideButton);

        percentButton = new JButton("%");
        percentButton.addActionListener(this);
        add(percentButton);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        add(clearButton);

        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(firstNumberField.getText());
            double num2 = Double.parseDouble(secondNumberField.getText());
            double result = 0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subtractButton) {
                result = num1 - num2;
            } else if (e.getSource() == multiplyButton) {
                result = num1 * num2;
            } else if (e.getSource() == divideButton) {
                result = num1 / num2;
            } else if (e.getSource() == percentButton) {
                result = num1 * (num2 / 100);
            } else if (e.getSource() == clearButton) {
                firstNumberField.setText("");
                secondNumberField.setText("");
                resultField.setText("");
                return;
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}

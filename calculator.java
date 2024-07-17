import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField display;
    private StringBuilder input;

    public Calculator() {
        input = new StringBuilder();
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        setLayout(new BorderLayout());
        add(display, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("C")) {
            input.setLength(0);
            display.setText("");
        } else if (command.equals("=")) {
            try {
                String result = String.valueOf(eval(input.toString()));
                display.setText(result);
                input.setLength(0);
                input.append(result);
            } catch (Exception ex) {
                display.setText("Error");
                input.setLength(0);
            }
        } else {
            input.append(command);
            display.setText(input.toString());
        }
    }

    private double eval(String expression) {
        String[] tokens = expression.split("(?<=[-+*/])|(?=[-+*/])");
        double result = Double.parseDouble(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            double nextValue = Double.parseDouble(tokens[i + 1]);

            switch (operator) {
                case "+":
                    result += nextValue;
                    break;
                case "-":
                    result -= nextValue;
                    break;
                case "*":
                    result *= nextValue;
                    break;
                case "/":
                    result /= nextValue;
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculator::new);
    }
}

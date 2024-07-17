import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerInfoApp extends JFrame implements ActionListener {
    private JTextField nameField, emailField, phoneField;
    private JButton submitButton;
    private JTextArea displayArea;

    public CustomerInfoApp() {
        setTitle("Customer Information");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);

        inputPanel.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        inputPanel.add(phoneField);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        inputPanel.add(submitButton);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();

            displayArea.append("Customer Information:\n");
            displayArea.append("Name: " + name + "\n");
            displayArea.append("Email: " + email + "\n");
            displayArea.append("Phone: " + phone + "\n\n");

            nameField.setText("");
            emailField.setText("");
            phoneField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CustomerInfoApp::new);
    }
}

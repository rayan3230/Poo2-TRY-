package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class page extends JFrame {

    private final CardLayout cardLayout = new CardLayout();
    private final JPanel container = new JPanel(cardLayout);
    private JPanel loginPanel, registerPanel;

    public page() {
        setTitle("Authentication System");
        setSize(1100, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);

        createLoginPanel();
        createRegisterPanel();

        container.add(loginPanel, "login");
        container.add(registerPanel, "register");

        add(container);
        cardLayout.show(container, "login");
    }

    private void createLoginPanel() {
        loginPanel = new JPanel(null); // Use null layout for absolute positioning

        // Specify the path to the background image
        JLabel background = new JLabel(new ImageIcon("Poo2-TRY-\\Wassim\\bookingTICKET\\images\\image.jpg"));
        background.setBounds(0, 0, 1100, 800);
        loginPanel.add(background);

        JPanel card = new JPanel(null);
        card.setBackground(new Color(0, 0, 0, 150));
        card.setBounds(300, 150, 400, 500);
        loginPanel.add(card);

        JLabel titleLabel = new JLabel("Login", SwingConstants.CENTER);
        titleLabel.setBounds(150, 20, 100, 30);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        card.add(titleLabel);

        ImageIcon logo = new ImageIcon("Poo2-TRY-\\Wassim\\bookingTICKET\\images\\logo.png");
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setBounds(20, 10, 200, 100);

        // Email components
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 80, 100, 30);
        emailLabel.setForeground(Color.WHITE);
        card.add(emailLabel);

        PlaceholderTextField emailField = new PlaceholderTextField("Enter your email");
        emailField.setBounds(50, 110, 300, 30);
        card.add(emailField);

        // Password components
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 160, 100, 30);
        passwordLabel.setForeground(Color.WHITE);
        card.add(passwordLabel);

        PlaceholderPasswordField passwordField = new PlaceholderPasswordField("Enter your password");
        passwordField.setBounds(50, 190, 300, 30);
        card.add(passwordField);

        // Role components
        JLabel roleLabel = new JLabel("Role:");
        roleLabel.setBounds(50, 240, 100, 30);
        roleLabel.setForeground(Color.WHITE);
        card.add(roleLabel);

        JComboBox<String> roleCombo = new JComboBox<>(new String[]{"Admin", "Client"});
        roleCombo.setBounds(50, 270, 300, 30);
        card.add(roleCombo);

        RoundedButton loginBtn = new RoundedButton( 3);
        loginBtn.setBounds(50, 320, 300, 50);
        loginBtn.setBackground(Color.RED);
        loginBtn.setForeground(Color.WHITE);
        addHoverEffect(loginBtn);
        card.add(loginBtn);

        JButton registerLink = new JButton("<html><u>Don't have an account? Register here</u></html>");
        registerLink.setBounds(130, 450, 300, 30);
        registerLink.setBackground(new Color(0, 0, 0, 0));
        registerLink.setBorder(null);
        registerLink.setFocusable(false);
        registerLink.setBorderPainted(false);
        registerLink.setFocusPainted(false);    // Remove focus effect  
        registerLink.setContentAreaFilled(false); // Remove default background  
        registerLink.setOpaque(false);           // Ensure custom colors work  
        registerLink.setForeground(Color.WHITE);
        registerLink.setFont(new Font("Arial", Font.BOLD, 12));
        card.add(registerLink);

        loginBtn.addActionListener(_ -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String role = (String) roleCombo.getSelectedItem();
            boolean isAdmin = role.equals("Admin");

            // Authentication logic here
            boolean loginSuccessful = DB.loginUser(email, password, isAdmin);
            if (loginSuccessful) {
                JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                // Navigate to the user interface
                new userinterface().setVisible(true);
                this.dispose(); // Close the login window
            } else {
                JOptionPane.showMessageDialog(this, "Invalid email, password, or role.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        registerLink.addActionListener(_ -> cardLayout.show(container, "register"));

        // Add the background label last to ensure it is at the bottom
        loginPanel.add(logoLabel);
        loginPanel.add(background);
        JButton exitButton = new JButton("X");
        exitButton.setFocusable(false);
        exitButton.setBounds(1050, 5, 40, 35);
        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(new Font("Arial", Font.BOLD, 8));
        exitButton.addActionListener(_ -> System.exit(0));
        loginPanel.add(exitButton);
    }

    private void createRegisterPanel() {
        registerPanel = new JPanel(null); // Use null layout for absolute positioning

        // Specify the path to the background image
        JLabel background = new JLabel(new ImageIcon("Poo2-TRY-\\\\Wassim\\\\bookingTICKET\\\\images\\\\image.jpg"));
        background.setBounds(0, 0, 1100, 800);
        registerPanel.add(background);

        JPanel card = new JPanel(null);
        card.setBackground(new Color(0, 0, 0, 150));
        card.setBounds(300, 150, 400, 550);
        registerPanel.add(card);

        JLabel titleLabel = new JLabel("Register", SwingConstants.CENTER);
        titleLabel.setBounds(150, 20, 100, 30);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        card.add(titleLabel);

        ImageIcon logo = new ImageIcon("Poo2-TRY-\\Wassim\\bookingTICKET\\images\\logo.png");
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setBounds(20, 10, 200, 100);

        // Name components
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 80, 100, 30);
        nameLabel.setForeground(Color.WHITE);
        card.add(nameLabel);

        PlaceholderTextField nameField = new PlaceholderTextField("Enter your name");
        nameField.setBounds(50, 110, 300, 30);
        card.add(nameField);

        // Email components
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 160, 100, 30);
        emailLabel.setForeground(Color.WHITE);
        card.add(emailLabel);

        PlaceholderTextField emailField = new PlaceholderTextField("Enter your email");
        emailField.setBounds(50, 190, 300, 30);
        card.add(emailField);

        // Password components
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 240, 100, 30);
        passwordLabel.setForeground(Color.WHITE);
        card.add(passwordLabel);

        PlaceholderPasswordField passwordField = new PlaceholderPasswordField("Enter your password");
        passwordField.setBounds(50, 270, 300, 30);
        card.add(passwordField);

        // Confirm Password components
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setBounds(50, 320, 150, 30);
        confirmPasswordLabel.setForeground(Color.WHITE);
        card.add(confirmPasswordLabel);

        PlaceholderPasswordField confirmPasswordField = new PlaceholderPasswordField("Confirm your password");
        confirmPasswordField.setBounds(50, 350, 300, 30);
        card.add(confirmPasswordField);

        // Role components
        JLabel roleLabel = new JLabel("Role:");
        roleLabel.setBounds(50, 400, 100, 30);
        roleLabel.setForeground(Color.WHITE);
        card.add(roleLabel);

        JComboBox<String> roleCombo = new JComboBox<>(new String[]{"Admin", "Client"});
        roleCombo.setBounds(50, 430, 300, 30);
        card.add(roleCombo);

        RoundedButton registerBtn = new RoundedButton( 3);
        registerBtn.setBounds(50, 480, 300, 50);
        registerBtn.setBackground(Color.RED);
        registerBtn.setForeground(Color.WHITE);
        addHoverEffect(registerBtn);
        card.add(registerBtn);

        JButton loginLink = new JButton("<html><u>Already have an account? Login here</u></html>");
        loginLink.setBounds(130, 550, 300, 30);
        loginLink.setBackground(new Color(0, 0, 0, 0));
        loginLink.setBorder(null);
        loginLink.setFocusable(false);
        loginLink.setBorderPainted(false);
        loginLink.setFocusPainted(false);    // Remove focus effect  
        loginLink.setContentAreaFilled(false); // Remove default background  
        loginLink.setOpaque(false);           // Ensure custom colors work  
        loginLink.setForeground(Color.WHITE);
        loginLink.setFont(new Font("Arial", Font.BOLD, 12));
        card.add(loginLink);

        registerBtn.addActionListener(_ -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());
            String role = (String) roleCombo.getSelectedItem();
            boolean isAdmin = role.equals("Admin");

            // Registration logic here
            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            DB.registerUser(name, email, password, isAdmin);
            JOptionPane.showMessageDialog(this, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            cardLayout.show(container, "login");
        });

        loginLink.addActionListener(_ -> cardLayout.show(container, "login"));

        // Add the background label last to ensure it is at the bottom
        registerPanel.add(logoLabel);
        registerPanel.add(background);
        JButton exitButton = new JButton("X");
        exitButton.setFocusable(false);
        exitButton.setBounds(1050, 5, 40, 35);
        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(new Font("Arial", Font.BOLD, 8));
        exitButton.addActionListener(e -> System.exit(0));
        registerPanel.add(exitButton);
    }

    private void addHoverEffect(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.WHITE);
                button.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.RED);
                button.setForeground(Color.WHITE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new page().setVisible(true); // Correct class name
        });
    }
}
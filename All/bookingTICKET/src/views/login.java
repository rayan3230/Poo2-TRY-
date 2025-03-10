package views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class login extends JFrame {

    CardLayout cardLayout;
    JPanel cardPanel;

    JPanel loginPanel, signUpPanel;
    Color bgcolor = new Color(0x121213);
    Color secondarycolor = new Color(0x151517);

    public login() {
        setTitle("Login / Sign-Up");
        setSize(1200, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        createLoginPanel();
        createSignUpPanel();

        cardPanel.add(loginPanel, "login");
        cardPanel.add(signUpPanel, "signup");

        add(cardPanel);

        cardLayout.show(cardPanel, "login");
    }

    private void createLoginPanel() {
        loginPanel = new JPanel();
        loginPanel.setLayout(null); 
        loginPanel.setBackground(bgcolor);
        
        RoundedPanel cardPanel = new RoundedPanel(5);
        cardPanel.setLayout(null);
        cardPanel.setForeground(Color.WHITE);
        cardPanel.setBackground(secondarycolor);
        cardPanel.setBounds(144, 119, 911, 512);
        cardPanel.setOpaque(false);
        cardPanel.setRoundedBorder(Color.white, 1);

        RoundedPanel imagPanel = new RoundedPanel(5);
        imagPanel.setLayout(null);
        imagPanel.setBounds(16, 16, 355, 456);
        imagPanel.setBackgroundImage("javatry\\Poo2-TRY-\\All\\bookingTICKET\\images\\image.png");
        imagPanel.setRoundedBorder(Color.white, 1);
        imagPanel.setOpaque(false);
        cardPanel.add(imagPanel);

        JLabel titleLabel = new JLabel("Welcome Back! Login");
        titleLabel.setBounds(435, 45, 375, 48);
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(new Font("Poppins", Font.BOLD, 32));
        cardPanel.add(titleLabel); 
        
        JLabel UserLabel = new JLabel("Username");
        UserLabel.setBounds(435, 144, 100, 18);
        UserLabel.setForeground(Color.white);
        UserLabel.setFont(new Font("Roboto", Font.BOLD, 15));
        cardPanel.add(UserLabel);

        JTextField UserField = new JTextField();
        UserField.setBounds(435, 168, 390, 39);
        UserField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.white, 1),
            new EmptyBorder(5, 10, 5, 10) 
        ));
        UserField.setForeground(Color.white);
        UserField.setBackground(secondarycolor);
        UserField.setCaretColor(Color.white);
        UserField.setText("Enter your username");
        UserField.setForeground(Color.GRAY);
        UserField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (UserField.getText().equals("Enter your username")) {
                    UserField.setText("");
                    UserField.setForeground(Color.WHITE);
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (UserField.getText().isEmpty()) {
                    UserField.setText("Enter your username");
                    UserField.setForeground(Color.GRAY);
                }
            }
        });
        cardPanel.add(UserField);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(435, 227, 41, 18);
        emailLabel.setForeground(Color.white);
        emailLabel.setFont(new Font("Roboto", Font.BOLD, 15));
        cardPanel.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(435, 251, 390, 39);
        emailField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.white, 1),
            new EmptyBorder(5, 10, 5, 10) // Add padding inside the text field
        ));
        emailField.setForeground(Color.white);
        emailField.setBackground(secondarycolor);
        emailField.setCaretColor(Color.white);
        emailField.setText("Enter your email");
        emailField.setForeground(Color.GRAY);
        emailField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (emailField.getText().equals("Enter your email")) {
                    emailField.setText("");
                    emailField.setForeground(Color.WHITE);
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (emailField.getText().isEmpty()) {
                    emailField.setText("Enter your email");
                    emailField.setForeground(Color.GRAY);
                }
            }
        });
        cardPanel.add(emailField);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(435, 310, 100, 18);
        passwordLabel.setForeground(Color.white);
        passwordLabel.setFont(new Font("Roboto", Font.BOLD, 15));
        cardPanel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(435, 334, 390, 40);
        passwordField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.white, 1),
            new EmptyBorder(5, 10, 5, 10) // Add padding inside the text field
        ));
        passwordField.setForeground(Color.white);
        passwordField.setBackground(secondarycolor);
        passwordField.setCaretColor(Color.white);
        passwordField.setForeground(Color.GRAY);
        passwordField.setText("Enter your Password");
        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (passwordField.getText().equals("Enter your Password")) {
                    passwordField.setText("");
                    passwordField.setForeground(Color.WHITE);
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (passwordField.getText().isEmpty()) {
                    passwordField.setText("Enter your Password");
                    passwordField.setForeground(Color.GRAY);
                }
            }
        });
        cardPanel.add(passwordField);

        RoundedButton loginButton = new RoundedButton("Login",3);
        loginButton.setBounds(513, 407, 220, 39);
        loginButton.setBackground(bgcolor);
        loginButton.setForeground(Color.white);
        loginButton.setFont(new Font("Roboto", Font.BOLD, 16));
        loginButton.setOpaque(false);
        loginButton.setRoundedBorder(Color.WHITE, 1);
        loginiButton.addActionListener(event -> {
            String username = UserField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            
        cardPanel.add(loginButton);

        JButton goToSignUpButton = new JButton("Don't have an account? Sign up");
        goToSignUpButton.setBounds(435, 104, 200, 20);
        goToSignUpButton.setForeground(Color.white);
        goToSignUpButton.setFont(new Font("Roboto", Font.PLAIN, 12));
        goToSignUpButton.setBorderPainted(false);
        goToSignUpButton.setContentAreaFilled(false);
        goToSignUpButton.setFocusPainted(false);
        cardPanel.add(goToSignUpButton);

        goToSignUpButton.addActionListener(event -> cardLayout.show(this.cardPanel, "signup"));
        loginPanel.add(cardPanel);
    }

    private void createSignUpPanel() {
        signUpPanel = new JPanel();
        signUpPanel.setLayout(null);

        JLabel titleLabel = new JLabel("Sign Up");
        titleLabel.setBounds(160, 20, 100, 30);
        signUpPanel.add(titleLabel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 60, 100, 30);
        signUpPanel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 60, 180, 30);
        nameField.setCaretColor(Color.black);
        nameField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.black, 1),
            new EmptyBorder(5, 10, 5, 10) // Add padding inside the text field
        ));
        signUpPanel.add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 100, 100, 30);
        signUpPanel.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(150, 100, 180, 30);
        emailField.setCaretColor(Color.black);
        emailField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.black, 1),
            new EmptyBorder(5, 10, 5, 10) // Add padding inside the text field
        ));
        signUpPanel.add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 140, 100, 30);
        signUpPanel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 140, 180, 30);
        passwordField.setCaretColor(Color.black);
        passwordField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.black, 1),
            new EmptyBorder(5, 10, 5, 10) // Add padding inside the text field
        ));
        signUpPanel.add(passwordField);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setBounds(20, 180, 120, 30);
        signUpPanel.add(confirmPasswordLabel);

        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(150, 180, 180, 30);
        confirmPasswordField.setCaretColor(Color.black);
        confirmPasswordField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.black, 1),
            new EmptyBorder(5, 10, 5, 10) // Add padding inside the text field
        ));
        signUpPanel.add(confirmPasswordField);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(150, 230, 100, 30);
        signUpPanel.add(registerButton);

        JButton goToLoginButton = new JButton("Login");
        goToLoginButton.setBounds(150, 270, 100, 30);
        signUpPanel.add(goToLoginButton);

        goToLoginButton.addActionListener(event -> cardLayout.show(cardPanel, "login"));
    }

    // ---------- Main Method ----------
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            login frame = new login();
            frame.setVisible(true);
        });
    }
}
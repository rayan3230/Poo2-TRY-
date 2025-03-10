package views;

import Model.Client;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import controller.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.Timer;

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

        cardLayout.show(cardPanel, "signup");
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

        JPanel movingimage = new JPanel();
        movingimage.setLayout(null);
        movingimage.setBackground(null);
        movingimage.setBounds(126, 493, 135, 5);
        cardPanel.add(movingimage);


        RoundedPanel rect1 = new RoundedPanel(3);
        rect1.setBounds(0, 0, 35, 4);
        rect1.setOpaque(true);
        movingimage.add(rect1);

        RoundedPanel rect2 = new RoundedPanel(3);
        rect2.setBounds(45, 0, 35, 4);
        rect2.setOpaque(true);
        movingimage.add(rect2);

        RoundedPanel rect3 = new RoundedPanel(3);
        rect3.setBounds(95, 0, 35, 4);
        rect3.setOpaque(true);
        rect3.setVisible(true);
        rect3.setFocusable(false);
        rect3.setBorder(null);
        movingimage.add(rect3);

        RoundedPanel imagPanel = new RoundedPanel(5);
        imagPanel.setLayout(null);
        imagPanel.setBounds(16, 16, 355, 456);
        //imagPanel.setBackgroundImage("Poo2-TRY-\\\\All\\bookingTICKET\\images\\image1.png"); // Use double backslashes
        imagPanel.setRoundedBorder(Color.white, 1);
        imagPanel.setOpaque(false);
        cardPanel.add(imagPanel);

        String[] imagePaths = {
            "Poo2-TRY-\\\\All\\bookingTICKET\\images\\image1.png",
            "Poo2-TRY-\\\\All\\bookingTICKET\\images\\image2.png",
            "Poo2-TRY-\\\\All\\bookingTICKET\\images\\image3.png",
            "Poo2-TRY-\\\\All\\bookingTICKET\\images\\image4.png",
        };

        // Timer to change images
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int currentIndex = 0;

            @Override
            public void run() {
                imagPanel.setBackgroundImage(imagePaths[currentIndex]);
                currentIndex = (currentIndex + 1) % imagePaths.length;
                if(currentIndex == 0){
                    rect1.setBackground(Color.white);
                    rect2.setBackground(Color.GRAY);
                    rect3.setBackground(Color.GRAY);
                }else if(currentIndex == 1){
                    rect1.setBackground(Color.GRAY);
                    rect2.setBackground(Color.white);
                    rect3.setBackground(Color.GRAY);
                    
            }else if(currentIndex == 2){
                    rect1.setBackground(Color.GRAY);
                    rect2.setBackground(Color.GRAY);
                    rect3.setBackground(Color.white);
                }
            }
        }, 0, 2300);

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
        loginButton.addActionListener(event -> {
            String username = UserField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            // Call the login method from the controller
            // controller.login(username, email, password);
        });
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
        signUpPanel.setBackground(bgcolor);

        RoundedPanel cardPanel = new RoundedPanel(5);
        cardPanel.setLayout(null);
        cardPanel.setForeground(Color.WHITE);
        cardPanel.setBackground(secondarycolor);
        cardPanel.setBounds(144, 119, 911, 512);
        cardPanel.setOpaque(false);
        cardPanel.setRoundedBorder(Color.white, 1);

        JPanel movingimage = new JPanel();
        movingimage.setLayout(null);
        movingimage.setBackground(null);
        movingimage.setBounds(126, 493, 135, 5);
        cardPanel.add(movingimage);


        RoundedPanel rect1 = new RoundedPanel(3);
        rect1.setBounds(0, 0, 35, 4);
        rect1.setOpaque(true);
        movingimage.add(rect1);

        RoundedPanel rect2 = new RoundedPanel(3);
        rect2.setBounds(45, 0, 35, 4);
        rect2.setOpaque(true);
        movingimage.add(rect2);

        RoundedPanel rect3 = new RoundedPanel(3);
        rect3.setBounds(95, 0, 35, 4);
        rect3.setOpaque(true);
        rect3.setVisible(true);
        rect3.setFocusable(false);
        rect3.setBorder(null);
        movingimage.add(rect3);

        RoundedPanel imagPanel = new RoundedPanel(5);
        imagPanel.setLayout(null);
        imagPanel.setBounds(16, 16, 355, 456);
        //imagPanel.setBackgroundImage("Poo2-TRY-\\\\All\\bookingTICKET\\images\\image.png");
        imagPanel.setRoundedBorder(Color.white, 1);
        imagPanel.setOpaque(false);
        cardPanel.add(imagPanel);

         String[] imagePaths = {
            "Poo2-TRY-\\\\All\\bookingTICKET\\images\\image1.png",
            "Poo2-TRY-\\\\All\\bookingTICKET\\images\\image2.png",
            "Poo2-TRY-\\\\All\\bookingTICKET\\images\\image3.png",
            "Poo2-TRY-\\\\All\\bookingTICKET\\images\\image4.png",
        };

        // Timer to change images
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int currentIndex = 0;

            @Override
            public void run() {
                imagPanel.setBackgroundImage(imagePaths[currentIndex]);
                currentIndex = (currentIndex + 1) % imagePaths.length;
                if(currentIndex == 0){
                    rect1.setBackground(Color.white);
                    rect2.setBackground(Color.GRAY);
                    rect3.setBackground(Color.GRAY);
                }else if(currentIndex == 1){
                    rect1.setBackground(Color.GRAY);
                    rect2.setBackground(Color.white);
                    rect3.setBackground(Color.GRAY);
                    
            }else if(currentIndex == 2){
                    rect1.setBackground(Color.GRAY);
                    rect2.setBackground(Color.GRAY);
                    rect3.setBackground(Color.white);
                }
            }
        }, 0, 2300);

        JLabel titleLabel = new JLabel("Create an Account");
        titleLabel.setBounds(435, 45, 375, 48);
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(new Font("Poppins", Font.BOLD, 32));
        cardPanel.add(titleLabel); 

        JLabel UserLabel = new JLabel("Name");
        UserLabel.setBounds(435, 144, 100, 18);
        UserLabel.setForeground(Color.white);
        UserLabel.setFont(new Font("Roboto", Font.BOLD, 15));
        cardPanel.add(UserLabel);

        JTextField UserField = new JTextField();
        UserField.setBounds(435, 168, 180, 39);
        UserField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.white, 1),
            new EmptyBorder(5, 10, 5, 10) 
        ));
        UserField.setForeground(Color.white);
        UserField.setBackground(secondarycolor);
        UserField.setCaretColor(Color.white);
        UserField.setText("Enter your Name");
        UserField.setForeground(Color.GRAY);
        UserField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (UserField.getText().equals("Enter your Name")) {
                    UserField.setText("");
                    UserField.setForeground(Color.WHITE);
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (UserField.getText().isEmpty()) {
                    UserField.setText("Enter your Name");
                    UserField.setForeground(Color.GRAY);
                }
            }
        });
        cardPanel.add(UserField);


        JLabel LastNameLabel = new JLabel("Last name");
        LastNameLabel.setBounds(645, 144, 100, 18);
        LastNameLabel.setForeground(Color.white);
        LastNameLabel.setFont(new Font("Roboto", Font.BOLD, 15));
        cardPanel.add(LastNameLabel);

        JTextField LastNameField = new JTextField();
        LastNameField.setBounds(645, 168, 180, 39);
        LastNameField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.white, 1),
            new EmptyBorder(5, 10, 5, 10) 
        ));
        LastNameField.setForeground(Color.white);
        LastNameField.setBackground(secondarycolor);
        LastNameField.setCaretColor(Color.white);
        LastNameField.setText("Enter your Last name");
        LastNameField.setForeground(Color.GRAY);
        LastNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (LastNameField.getText().equals("Enter your Last name")) {
                    LastNameField.setText("");
                    LastNameField.setForeground(Color.WHITE);
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (LastNameField.getText().isEmpty()) {
                    LastNameField.setText("Enter your Last name");
                    LastNameField.setForeground(Color.GRAY);
                }
            }
        });
        cardPanel.add(LastNameField);



        JLabel AgeLabel = new JLabel("Age");
        AgeLabel.setBounds(645, 215, 100, 18);
        AgeLabel.setForeground(Color.white);
        AgeLabel.setFont(new Font("Roboto", Font.BOLD, 15));
        cardPanel.add(AgeLabel);

        JTextField AgeField = new JTextField();
        AgeField.setBounds(645, 239, 180, 39);
        AgeField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.white, 1),
            new EmptyBorder(5, 10, 5, 10) 
        ));
        AgeField.setForeground(Color.white);
        AgeField.setBackground(secondarycolor);
        AgeField.setCaretColor(Color.white);
        AgeField.setText("Enter your Age");
        AgeField.setForeground(Color.GRAY);
        AgeField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (AgeField.getText().equals("Enter your Age")) {
                    AgeField.setText("");
                    AgeField.setForeground(Color.WHITE);
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (AgeField.getText().isEmpty()) {
                    AgeField.setText("Enter your Age");
                    AgeField.setForeground(Color.GRAY);
                }
            }
        });
        cardPanel.add(AgeField);


        JLabel usernameLabel = new JLabel("User name");
        usernameLabel.setBounds(435, 215, 100, 18);
        usernameLabel.setForeground(Color.white);
        usernameLabel.setFont(new Font("Roboto", Font.BOLD, 15));
        cardPanel.add(usernameLabel);

        JTextField username = new JTextField();
        username.setBounds(435, 239, 180, 39);
        username.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.white, 1),
            new EmptyBorder(5, 10, 5, 10) 
        ));
        username.setForeground(Color.white);
        username.setBackground(secondarycolor);
        username.setCaretColor(Color.white);
        username.setText("Enter your username");
        username.setForeground(Color.GRAY);
        username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (username.getText().equals("Enter your username")) {
                    username.setText("");
                    username.setForeground(Color.WHITE);
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (username.getText().isEmpty()) {
                    username.setText("Enter your username");
                    username.setForeground(Color.GRAY);
                }
            }
        });
        cardPanel.add(username);


        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(435, 289, 41, 18);
        emailLabel.setForeground(Color.white);
        emailLabel.setFont(new Font("Roboto", Font.BOLD, 15));
        cardPanel.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(435, 317, 390, 39);
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
        passwordLabel.setBounds(435, 363, 100, 18);
        passwordLabel.setForeground(Color.white);
        passwordLabel.setFont(new Font("Roboto", Font.BOLD, 15));
        cardPanel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(435, 387, 390, 40);
        passwordField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.white, 1),
            new EmptyBorder(5, 10, 5, 10) 
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

        
        RoundedButton signinbutton = new RoundedButton("Sign in",3);
        signinbutton.setBounds(513, 455, 220, 39);
        signinbutton.setBackground(bgcolor);
        signinbutton.setForeground(Color.white);
        signinbutton.setFont(new Font("Roboto", Font.BOLD, 16));
        signinbutton.setOpaque(false);
        signinbutton.setRoundedBorder(Color.WHITE, 1);
        signinbutton.addActionListener(event -> {
            String lname = LastNameField.getText();
            String user_name = username.getText();
            String name = UserField.getText();
            String age = AgeField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            ClientManager.addClient(user_name,lname,name, email, password, Integer.parseInt(age), 0);
            emailField.setText("");
            passwordField.setText("");
            UserField.setText("");
            username.setText("");
            LastNameField.setText("");
            AgeField.setText("");
        });
        cardPanel.add(signinbutton);

        JButton goToLoginButton = new JButton("Already have an account? Login");
        goToLoginButton.setBounds(395, 95, 250, 30);
        goToLoginButton.setForeground(Color.white);
        goToLoginButton.setFont(new Font("Roboto", Font.PLAIN, 12));
        goToLoginButton.setBorderPainted(false);
        goToLoginButton.setContentAreaFilled(false);
        goToLoginButton.setFocusPainted(false);
        cardPanel.add(goToLoginButton);

        goToLoginButton.addActionListener(event -> cardLayout.show(this.cardPanel, "login"));

        signUpPanel.add(cardPanel);
    }

    // ---------- Main Method ----------
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            login frame = new login();
            frame.setVisible(true);
        });
    }
}
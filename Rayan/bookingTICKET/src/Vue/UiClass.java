package Vue;

import Controller.GestionAccounts;
import Controller.GestionMovie;
import Moodle.*;
import Moodle.Movie.genre;
import Moodle.Movie.statusFilm;
import java.awt.*;
import java.io.File;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
public class UiClass extends JFrame {
    public boolean userHasTyped; 
    public LocalTime localTime;
    public String pathfilm ;
    public GestionMovie movies = new GestionMovie();
    public JPanel mainPanel;
    public JPanel ContentAdminPanel;
    public CardLayout cardLayout;
    public GestionAccounts Accounts;  
    public Accounts currentuser ;
    public Accounts currentadmin;  

    

    // Panels
    public JPanel welcomePanel ;
    public JPanel loginPanel ;
    public JPanel registerPanel ;
    public JPanel forgotPasswordPanel;
    public JPanel homeUserPanel;
    public JPanel homeAdminPanel ;
    public JPanel UserInterface;
    
    public UiClass(){
        // Initialize Accounts in the constructor
        Accounts = new GestionAccounts();
        
        setUndecorated(true); 
        setTitle("POO_Movies");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon AppLogo = new ImageIcon("Rayan\\bookingTICKET\\img\\Logo.png");
        this.setIconImage(AppLogo.getImage());
        setBounds(100, 100, 1200, 750);
        setLocationRelativeTo(null);
        setResizable(false);

        

        //  CardLayout khir
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        welcomePanel = createWelcomePanel();
        loginPanel = createLoginPanel();
        registerPanel = createRegisterPanel();
        forgotPasswordPanel = createForgotPasswordPanel();
        homeUserPanel = createHomeUserPanel(currentuser);
        homeAdminPanel = createHomeAdminPanel(currentadmin);
        UserInterface = createInterfaceUserPanel();

        mainPanel.add(welcomePanel, "welcome");
        mainPanel.add(loginPanel, "login");
        mainPanel.add(registerPanel, "register");
        mainPanel.add(forgotPasswordPanel, "forgotPassword");
        mainPanel.add(homeUserPanel, "homeUser");
        mainPanel.add(homeAdminPanel, "homeAdmin");
        mainPanel.add(UserInterface, "interfaceUser");

        setContentPane(mainPanel);
        cardLayout.show(mainPanel, "interfaceUser");
        
   
    }

    // public void refreshUserPanel() {
    //     JPanel homeUserPanel = createHomeUserPanel(currentuser);
    //     mainPanel.add(homeUserPanel, "homeUser");
    //     cardLayout.show(mainPanel, "homeUser");
    // }

    
    public JPanel createWelcomePanel() {
        JPanel welcomepanel = new JPanel() {
            ImageIcon bgIcon = new ImageIcon("Rayan/bookingTICKET/img/BackGround 4.png");

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                // Draw the background image with reduced opacity
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
                g2d.drawImage(bgIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
                // Darken the background with a black overlay
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
                g2d.setColor(Color.black);
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.dispose();
            }
        };
        welcomepanel.setLayout(null);
        welcomepanel.setBounds(0, 0, 1200, 750);

        
        JLabel LogoName = new JLabel("POOMovie");
        LogoName.setBounds(70, 24, 192, 52);
        LogoName.setFont(new Font("Holtwood One SC", Font.PLAIN, 32));
        LogoName.setForeground(Color.red);
        welcomepanel.add(LogoName);



        ImageIcon iconMovie = new ImageIcon("Poo2-TRY-/Rayan/bookingTICKET/img/movie.png");
        JLabel imageLabel = new JLabel(iconMovie);
        imageLabel.setBounds(10, 20, 64, 64);
        welcomepanel.add(imageLabel);



     
        JLabel WelcomingMessage1 = new JLabel("Films et séries en ");
        WelcomingMessage1.setBounds(460, 222, 580, 120);
        WelcomingMessage1.setFont(new Font("Inter", Font.BOLD, 35));
        WelcomingMessage1.setForeground(Color.white);
        welcomepanel.add(WelcomingMessage1);

        JLabel WelcomingMessage2 = new JLabel("illimité, et bien plus");
        WelcomingMessage2.setBounds(446, 270, 580, 120);
        WelcomingMessage2.setFont(new Font("Holtwood One SC", Font.BOLD, 35));
        WelcomingMessage2.setForeground(Color.white);
        welcomepanel.add(WelcomingMessage2);

        JLabel WelcomingMessage3 = new JLabel("Notre projet poo de vente de ticket et booking pour des film en salle de cinema");
        WelcomingMessage3.setBounds(310, 330, 1160, 120);
        WelcomingMessage3.setFont(new Font("Inter", Font.BOLD, 17));
        WelcomingMessage3.setForeground(Color.white);
        welcomepanel.add(WelcomingMessage3);

        

        RoundedButton LoginButton = new RoundedButton("Login",7);
        LoginButton.setBounds(1100, 10, 75, 30);
        LoginButton.setForeground(Color.white);
        LoginButton.setBackground(new Color(255, 0, 0));
        LoginButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
        LoginButton.setFocusPainted(false);
        LoginButton.setBorderPainted(false);
        LoginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LoginButton.setBackground(Color.gray);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LoginButton.setBackground(new Color(255, 0, 0));
            }
        });
        LoginButton.addActionListener(e -> {
            cardLayout.show(mainPanel, "login");
        });
        welcomepanel.add(LoginButton);

        
    
        RoundedButton RegisterButton = new RoundedButton("Register", 7);
        RegisterButton.setBounds(940, 10, 150, 30);
        RegisterButton.setForeground(Color.white);
        RegisterButton.setBackground(Color.gray);
        RegisterButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        RegisterButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
        RegisterButton.setFocusPainted(false);
        RegisterButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RegisterButton.setBackground(new Color(200, 0, 0));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RegisterButton.setBackground(Color.gray);
            }
        });
        RegisterButton.setBorder(BorderFactory.createEmptyBorder());
        RegisterButton.addActionListener(e -> {
            cardLayout.show(mainPanel, "register");
        });
        welcomepanel.add(RegisterButton);

        
        JPanel InputPanel = new JPanel();
        InputPanel.setBounds(300, 440, 500, 50);
        InputPanel.setBackground(Color.gray);
        InputPanel.setLayout(null);
        welcomepanel.add(InputPanel);

        JTextField TextField = new JTextField();
        TextField.setBounds(0, 0, 500, 50);
        TextField.setOpaque(false);
        TextField.setFont(new Font("Arial", Font.BOLD, 17));
        TextField.setBackground(Color.gray);
        TextField.setForeground(Color.WHITE);
        TextField.setCaretColor(Color.WHITE);
        TextField.setBorder(BorderFactory.createEmptyBorder());
        InputPanel.add(TextField);

        
        RoundedButton Button = new RoundedButton("Press " , 7);
        Button.setBounds(820, 440, 130, 50);
        Button.setForeground(Color.white);
        Button.setBackground(Color.red);
        Button.setFont(new Font("Arial", Font.BOLD, 24));
        Button.setFocusPainted(false);
        Button.setBorderPainted(false);
        Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.exit(0);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Button.setBackground(Color.black);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Button.setBackground(Color.red);
            }   
        });
        welcomepanel.add(Button);

        return welcomepanel;
    }

  
    public JPanel createLoginPanel(){
        JPanel loginPanel = new JPanel() {
            ImageIcon bgIcon = new ImageIcon("Rayan/bookingTICKET/img/BackGround 4.png");
 
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                // Draw the background with opacity
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
                g2d.drawImage(bgIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
                // Overlay a black layer
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
                g2d.setColor(Color.black);
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.dispose();
            }
        };
        loginPanel.setLayout(null);
        loginPanel.setBounds(0, 0, 1200, 750);


        JLabel LogoName = new JLabel("POOMovie");
        LogoName.setBounds(70, 24, 192, 52);
        LogoName.setFont(new Font("Holtwood One SC", Font.PLAIN, 32));
        LogoName.setForeground(Color.red);
        loginPanel.add(LogoName);



        ImageIcon iconMovie = new ImageIcon("Poo2-TRY-/Rayan/bookingTICKET/img/movie.png");
        JLabel imageLabel = new JLabel(iconMovie);
        imageLabel.setBounds(10, 20, 64, 64);
        loginPanel.add(imageLabel);

        JPanel RectangleLogin = new JPanel(){

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f)); // Opacity value between 0.0f - 1.0f
                g2d.setColor(new Color(0, 0, 0)); // Black color
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.dispose();
            }
        };
        RectangleLogin.setBounds(400, 100, 440, 620);
        RectangleLogin.setLayout(null);
        RectangleLogin.setOpaque(false); 
        loginPanel.add(RectangleLogin);

     

        JLabel SigninLabel = new JLabel("Sign In");
        SigninLabel.setBounds(50, 40, 200, 50);
        SigninLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
        SigninLabel.setForeground(Color.white);
        RectangleLogin.add(SigninLabel);

        JTextField EmailField = new JTextField("   Email or phone number"); 
        EmailField.setBounds(50, 120, 340, 40);
        EmailField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        EmailField.setForeground(Color.gray); 
        EmailField.setCaretColor(Color.white);
        //EmailField.setBackground(new Color(80, 77, 74, 230));
        EmailField.setBackground(new Color(80, 77, 74));
        EmailField.setOpaque(true);
        EmailField.setBorder(null);

        EmailField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (EmailField.getText().equals("   Email or phone number")) {
                    EmailField.setText("");
                    EmailField.setForeground(Color.WHITE);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (EmailField.getText().isEmpty() || EmailField.getText().trim().isEmpty()) {
                    EmailField.setText("   Email or phone number");
                    EmailField.setForeground(Color.gray);
                }
            }
        });

        RectangleLogin.add(EmailField);

        JPasswordField PasswordField = new JPasswordField("Password");
        PasswordField.setBounds(50, 200, 340, 40);
        PasswordField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        PasswordField.setForeground(Color.gray);
        PasswordField.setCaretColor(Color.white);
        //PasswordField.setBackground(new Color(80, 77, 74, 230));
        PasswordField.setBackground(new Color(80, 77, 74));
        PasswordField.setOpaque(true);
        PasswordField.setBorder(null);
        PasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (PasswordField.getText().equals("Password")) {
                    PasswordField.setText("");
                    PasswordField.setForeground(Color.WHITE);
                }
            }
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (PasswordField.getText().isEmpty() || PasswordField.getPassword().length == 0) {
                    PasswordField.setText("Password");
                    PasswordField.setForeground(Color.gray);
                }
            }
        });
        RectangleLogin.add(PasswordField);

        //JButton SignInButton = new JButton("Sign In");
        RoundedButton SignInButton = new RoundedButton("Sign In", 13);
        SignInButton.setBounds(50, 270, 340, 40);
        SignInButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        SignInButton.setFocusPainted(false);
        SignInButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        SignInButton.setBackground(Color.red);
        SignInButton.setForeground(Color.white);
        SignInButton.setBorder(BorderFactory.createEmptyBorder());
        SignInButton.addActionListener(e -> {
            
            String txtEmail = EmailField.getText();
            String txtPassword = String.valueOf(PasswordField.getPassword());
            
            if (EmailField.getText().equals("   Email or phone number") || 
                String.valueOf(PasswordField.getPassword()).equals("Password")) {
                JOptionPane.showMessageDialog(null, "Please fill out all fields", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }else{
                HandleLogin(txtEmail, txtPassword  );
            }


        });
        RectangleLogin.add(SignInButton);

        JLabel Or = new JLabel("OR");
        Or.setBounds(106 + 100, 320, 30, 40); // :- )
        Or.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Or.setForeground(Color.white);
        RectangleLogin.add(Or);

        JButton btnforgetpassword = new JButton("Forgot password ?");
        btnforgetpassword.setBounds(125, 370, 200, 30);
        btnforgetpassword.setFont(new Font("Segoe UI", Font.BOLD, 17));
        btnforgetpassword.setForeground(Color.white);
        btnforgetpassword.setContentAreaFilled(false);
        btnforgetpassword.setBorderPainted(false);
        btnforgetpassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnforgetpassword.addActionListener(e -> {
            cardLayout.show(mainPanel, "forgotPassword");
        });
        RectangleLogin.add(btnforgetpassword);


        JLabel SignupLabel = new JLabel("New to POOMovie? ");
        SignupLabel.setBounds(40, 450, 300, 50);
        SignupLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        SignupLabel.setForeground(Color.white);
        RectangleLogin.add(SignupLabel);

        JButton SignupButton = new JButton("Sign Up Now...");
        SignupButton.setBounds(140, 461, 200, 30);
        SignupButton.setFont(new Font("Segoe UI", Font.BOLD, 17));
        SignupButton.setForeground(Color.white);
        SignupButton.setContentAreaFilled(false);
        SignupButton.setBorderPainted(false);
        SignupButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        SignupButton.addActionListener(e -> {
            cardLayout.show(mainPanel, "register");
        });
      
        RectangleLogin.add(SignupButton);

        RoundedButton returnbtnWelcomePanel = new RoundedButton("Return" , 13);
        returnbtnWelcomePanel.setBounds(50, 530, 340, 40);
        returnbtnWelcomePanel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        returnbtnWelcomePanel.setFocusPainted(false);
        returnbtnWelcomePanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        returnbtnWelcomePanel.setBackground(Color.red);
        returnbtnWelcomePanel.setForeground(Color.white);
        returnbtnWelcomePanel.setBorder(BorderFactory.createEmptyBorder());
        returnbtnWelcomePanel.addActionListener(e ->{
            cardLayout.show(mainPanel, "welcome");
        });
        RectangleLogin.add(returnbtnWelcomePanel);



        return loginPanel;
    }


    public JPanel createRegisterPanel(){

        JPanel registerPanel = new JPanel() {
            ImageIcon bgIcon = new ImageIcon("Rayan/bookingTICKET/img/BackGround 4.png");
 
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                // Draw the background with opacity
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
                g2d.drawImage(bgIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
                // Overlay a black layer
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
                g2d.setColor(Color.black);
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.dispose();
            }
        };
        registerPanel.setLayout(null);
        registerPanel.setBounds(0, 0, 1200, 750);


        JLabel LogoName = new JLabel("POOMovie");
        LogoName.setBounds(70, 24, 192, 52);
        LogoName.setFont(new Font("Holtwood One SC", Font.PLAIN, 32));
        LogoName.setForeground(Color.red);
        registerPanel.add(LogoName);



        ImageIcon iconMovie = new ImageIcon("Poo2-TRY-/Rayan/bookingTICKET/img/movie.png");
        JLabel imageLabel = new JLabel(iconMovie);
        imageLabel.setBounds(10, 20, 64, 64);
        registerPanel.add(imageLabel);

        JPanel RectangleRegister = new JPanel(){

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f)); // Opacity value between 0.0f - 1.0f
                g2d.setColor(new Color(0, 0, 0)); // Black color
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.dispose();
            }
        };
        RectangleRegister.setBounds(400, 100, 440, 620);
        RectangleRegister.setLayout(null);
        RectangleRegister.setOpaque(false); 
        registerPanel.add(RectangleRegister);
        /*
        public String username;
        public String password;
        public String email;
        public double cardNumber;
        public int CCVnbr;
         */

        JLabel Registerlbl = new JLabel("Sign Up");
        Registerlbl.setBounds(50, 30, 200, 50);
        Registerlbl.setFont(new Font("Segoe UI", Font.BOLD, 24));
        Registerlbl.setForeground(Color.white);
        RectangleRegister.add(Registerlbl);






        JTextField UserNameField = new JTextField("    Username"); 
        UserNameField.setBounds(50, 120, 340, 40);
        UserNameField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        UserNameField.setForeground(Color.gray); 
        UserNameField.setCaretColor(Color.white);
        //EmailField.setBackground(new Color(80, 77, 74, 230));
        UserNameField.setBackground(new Color(80, 77, 74));
        UserNameField.setOpaque(true);
        UserNameField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
        UserNameField.setBorder(null);
        UserNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (UserNameField.getText().equals("    Username")) {
                    UserNameField.setText("");
                    UserNameField.setForeground(Color.WHITE);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (UserNameField.getText().isEmpty() || UserNameField.getText().trim().isEmpty()) {
                    UserNameField.setText("    Username");
                    UserNameField.setForeground(Color.gray);
                }
            }
        });
        RectangleRegister.add(UserNameField);

        JPasswordField PasswordsField = new JPasswordField("    Password");
        PasswordsField.setBounds(50, 190, 340, 40);
        PasswordsField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        PasswordsField.setForeground(Color.gray);
        PasswordsField.setCaretColor(Color.white);
        PasswordsField.setBackground(new Color(80, 77, 74));
        PasswordsField.setOpaque(true);
        //PasswordsField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
        PasswordsField.setBorder(null);
        PasswordsField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (PasswordsField.getText().equals("    Password")) {
                    PasswordsField.setText("");
                    PasswordsField.setForeground(Color.WHITE);
                }
            }
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (PasswordsField.getText().isEmpty() || PasswordsField.getPassword().length == 0) {
                    PasswordsField.setText("    Password");
                    PasswordsField.setForeground(Color.gray);
                }
            }
        });
        RectangleRegister.add(PasswordsField);


               
        JTextField EmailField = new JTextField("   email@example.com");
        EmailField.setBounds(50, 260, 340, 40);
        EmailField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        EmailField.setForeground(Color.gray);
        EmailField.setCaretColor(Color.white);
        EmailField.setBackground(new Color(80, 77, 74));
        EmailField.setOpaque(true);
        EmailField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
        EmailField.setBorder(null);
        EmailField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (EmailField.getText().equals("   email@example.com")) {
                    EmailField.setText("");
                    EmailField.setForeground(Color.white);
                }
            }
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (EmailField.getText().isEmpty() || EmailField.getText().trim().isEmpty()) {
                    EmailField.setText("   email@example.com");
                    EmailField.setForeground(Color.gray);
                }
            }
        });
        RectangleRegister.add(EmailField);

   
        JTextField CardNmbrField = new JTextField("   Card Number");
        CardNmbrField.setBounds(50, 330, 340, 40);
        CardNmbrField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        CardNmbrField.setForeground(Color.gray);
        CardNmbrField.setCaretColor(Color.white);
        CardNmbrField.setBackground(new Color(80, 77, 74));
        CardNmbrField.setOpaque(true);
        CardNmbrField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
        CardNmbrField.setBorder(null);
        CardNmbrField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (CardNmbrField.getText().equals("   Card Number")) {
                    CardNmbrField.setText("");
                    CardNmbrField.setForeground(Color.white);
                }
            }
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (CardNmbrField.getText().isEmpty() || CardNmbrField.getText().trim().isEmpty()) {
                    CardNmbrField.setText("   Card Number");
                    CardNmbrField.setForeground(Color.gray);
                }
            }
        });
        RectangleRegister.add(CardNmbrField);


        
        JTextField CCVNmbrField = new JTextField("   CCV Number");
        CCVNmbrField.setBounds(50, 400, 340, 40);
        CCVNmbrField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        CCVNmbrField.setForeground(Color.gray);
        CCVNmbrField.setCaretColor(Color.white);
        CCVNmbrField.setBackground(new Color(80, 77, 74));
        CCVNmbrField.setOpaque(true);
        CCVNmbrField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
        CCVNmbrField.setBorder(null);
        CCVNmbrField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (CCVNmbrField.getText().equals("   CCV Number")) {
                    CCVNmbrField.setText("");
                    CCVNmbrField.setForeground(Color.white);
                }
            }
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (CCVNmbrField.getText().isEmpty() || CCVNmbrField.getText().trim().isEmpty()) {
                    CCVNmbrField.setText("   CCV Number");
                    CCVNmbrField.setForeground(Color.gray);
                }
            }
        });
        RectangleRegister.add(CCVNmbrField);


        RoundedButton ConfirmSignUpButton = new RoundedButton("Confirm",10);
        ConfirmSignUpButton.setBounds(250, 490, 180, 50);
        ConfirmSignUpButton.setForeground(Color.white);
        ConfirmSignUpButton.setFocusPainted(false);
        ConfirmSignUpButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        ConfirmSignUpButton.setBackground(Color.red);
        ConfirmSignUpButton.setBorder(null);
        RectangleRegister.add(ConfirmSignUpButton);
        ConfirmSignUpButton.addActionListener(e -> {

            String username = UserNameField.getText().trim();
            String password = new String(PasswordsField.getPassword());
            String email = EmailField.getText().trim();
            String cardNumber = CardNmbrField.getText().trim();
            String ccvNumber = CCVNmbrField.getText().trim();

                if (username.equals("    Username") || password.equals("    Password") || 
                email.equals("   email@example.com") || cardNumber.equals("   Card Number") || 
                ccvNumber.equals("   CCV Number")) {
                JOptionPane.showMessageDialog(registerPanel, "Please fill in all fields", "Registration Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
                if (username.isEmpty() || password.isEmpty() || email.isEmpty() || 
                cardNumber.isEmpty() || ccvNumber.isEmpty()) {
                JOptionPane.showMessageDialog(registerPanel,  "All fields are required", "Registration Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

           if(HandleSignIn(UserNameField, PasswordsField, EmailField, CardNmbrField, CCVNmbrField)){
                 cardLayout.show(mainPanel, "login");
           }else{
            JOptionPane.showMessageDialog(registerPanel, "Registration failed, please try again", "Registration Error", JOptionPane.ERROR_MESSAGE);
 
           }

        });



        RoundedButton ReturnBtn = new RoundedButton("Return",10);
        ReturnBtn.setBounds(20, 490, 180, 50);
        ReturnBtn.setForeground(Color.white);
        ReturnBtn.setFocusPainted(false);
        ReturnBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        ReturnBtn.setBackground(Color.red);
        ReturnBtn.setBorder(null);
        ReturnBtn.addActionListener(e -> {
            cardLayout.show(mainPanel, "welcome");
        });
        RectangleRegister.add(ReturnBtn);
        

        return registerPanel;
    }



    public JPanel createForgotPasswordPanel() {
        JPanel forgotPanel = new JPanel() {
            ImageIcon bgIcon = new ImageIcon("Rayan/bookingTICKET/img/BackGround 4.png");
     
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
                g2d.drawImage(bgIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
                g2d.setColor(Color.black);
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.dispose();
            }
        };
        forgotPanel.setLayout(null);
        forgotPanel.setBounds(0, 0, 1200, 750);
    
        // Logo
        JLabel LogoName = new JLabel("POOMovie");
        LogoName.setBounds(20, 0, 192, 52);
        LogoName.setFont(new Font("Holtwood One SC", Font.PLAIN, 32));
        LogoName.setForeground(Color.red);
        forgotPanel.add(LogoName);
    
        // Center Rectangle Panel
        JPanel rectangleForgot = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
                g2d.setColor(new Color(0, 0, 0));
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.dispose();
            }
        };
        rectangleForgot.setBounds(400, 100, 440, 620);
        rectangleForgot.setLayout(null);
        rectangleForgot.setOpaque(false);
        forgotPanel.add(rectangleForgot);
    
        // Title
        JLabel titleLabel = new JLabel("Password Recovery");
        titleLabel.setBounds(50, 40, 300, 50);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
        titleLabel.setForeground(Color.white);
        rectangleForgot.add(titleLabel);
    
        // Username field
        JTextField usernameField = new JTextField("Enter your username");
        usernameField.setBounds(50, 120, 340, 40);
        usernameField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        usernameField.setForeground(Color.gray);
        usernameField.setBackground(new Color(80, 77, 74));
        usernameField.setCaretColor(Color.white);
        usernameField.setOpaque(true);
        usernameField.setBorder(null);
        TextfieldBehave(usernameField, "Enter your username");
        rectangleForgot.add(usernameField);
    
        // Security Question
        JLabel questionLabel = new JLabel("Security Question: What is 15 + 7 ?");
        questionLabel.setBounds(50, 190, 340, 30);
        questionLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        questionLabel.setForeground(Color.white);
        rectangleForgot.add(questionLabel);
    
        // Answer field
        JTextField answerField = new JTextField("Enter your answer");
        answerField.setBounds(50, 230, 340, 40);
        answerField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        answerField.setForeground(Color.gray);
        answerField.setBackground(new Color(80, 77, 74));
        answerField.setCaretColor(Color.white);
        answerField.setOpaque(true);
        answerField.setBorder(null);
        TextfieldBehave(answerField, "Enter your answer");
        rectangleForgot.add(answerField);
    
        // Submit Button
        RoundedButton submitButton = new RoundedButton("Submit", 10);
        submitButton.setBounds(50, 300, 340, 40);
        submitButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        submitButton.setBackground(Color.red);
        submitButton.setForeground(Color.white);
        submitButton.setFocusPainted(false);
        submitButton.addActionListener(e -> {
            if (answerField.getText().equals("22")) {
                // Show password in a dialog
                JOptionPane.showMessageDialog(forgotPanel, 
                    "Your password is: YourStoredPassword", 
                    "Password Recovery", 
                    JOptionPane.INFORMATION_MESSAGE);
                cardLayout.show(mainPanel, "login");
            } else {
                JOptionPane.showMessageDialog(forgotPanel, 
                    "Incorrect answer. Please try again.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        });
        rectangleForgot.add(submitButton);
    
        // Return Button
        RoundedButton returnButton = new RoundedButton("Return to Login", 10);
        returnButton.setBounds(50, 360, 340, 40);
        returnButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        returnButton.setBackground(Color.gray);
        returnButton.setForeground(Color.white);
        returnButton.setFocusPainted(false);
        returnButton.addActionListener(e -> cardLayout.show(mainPanel, "login"));
        rectangleForgot.add(returnButton);
    
        return forgotPanel;
    }
    

    public JPanel createHomeUserPanel(Accounts UserAccount) {
        JPanel homePanel = new JPanel();
        homePanel.setLayout(null);
        homePanel.setBounds(0, 0, 1200, 750);
        homePanel.setBackground(Color.green);


        //--------------Background panel(main)
        JPanel MainUserPanel = new JPanel();
        MainUserPanel.setBounds(300, 0, 1200, 750);
        MainUserPanel.setBackground(new Color(18, 18, 18));
        MainUserPanel.setLayout(null);
        homePanel.add(MainUserPanel);
        MainUserPanel.setVisible(true);
    
        // Only add welcome label if UserAccount is not null
        // if (UserAccount != null) {
        //     JLabel usernamelbl = new JLabel("Welcome, " + UserAccount.username + "!");
        //     usernamelbl.setBounds(50, 120, 300, 50);
        //     usernamelbl.setFont(new Font("Segoe UI", Font.BOLD, 25));
        //     usernamelbl.setForeground(Color.red);
        //     homePanel.add(usernamelbl);
        // } else {
        //     JLabel usernamelbl = new JLabel("Welcome, nkmk!");
        //     usernamelbl.setBounds(50, 120, 300, 50);
        //     usernamelbl.setFont(new Font("Segoe UI", Font.BOLD, 25));
        //     usernamelbl.setForeground(Color.red);
        //     homePanel.add(usernamelbl);
        // }


        //--------------Left black panel
        JPanel LeftBlackPanel = new JPanel();
        LeftBlackPanel.setBounds(0, 0, 300, 750);
        LeftBlackPanel.setBackground(new Color(24, 24, 24));
        LeftBlackPanel.setLayout(null);
        homePanel.add(LeftBlackPanel);

        JLabel LogoName = new JLabel("CINEMACITY");
        LogoName.setBounds(17, -124, 300, 300);
        LogoName.setForeground(Color.RED);
        LogoName.setFont(new Font("Segoe UI", Font.BOLD, 25));
        LeftBlackPanel.add(LogoName);

        JPanel BalancePanel = new JPanel();
        BalancePanel.setBounds(20, 70, 260, 120);
        BalancePanel.setLayout(null);
        BalancePanel.setBackground(new Color(30, 30, 30));
        LeftBlackPanel.add(BalancePanel);

        JLabel BalanceLabel = new JLabel(" Balance");
        BalanceLabel.setBounds(10, 10, 100, 30);
        BalanceLabel.setForeground(Color.white);
        BalanceLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        BalancePanel.add(BalanceLabel);

        JLabel BalanceValue = new JLabel("$56,00 " );
        BalanceValue.setFont(new Font("Arial", Font.BOLD, 24));
        BalanceValue.setForeground(Color.RED);//new Color(183, 255, 0)
        BalanceValue.setBounds(10, 55, 100, 30);
        BalancePanel.add(BalanceValue);

        RoundedButton Dipostebalance = new RoundedButton("",10);
        Dipostebalance.setBounds(190, 30, 50, 50);
        Dipostebalance.setBackground(Color.RED);//new Color(183, 255, 0)
        Dipostebalance.addActionListener(e -> {
            JOptionPane.showMessageDialog(homePanel, "Deposit functionality is not available yet.");
        });
        BalancePanel.add(Dipostebalance);



//-----------------------Left side buttons-----------------------
        JButton FavoriteButton = new JButton("Favorite");
        FavoriteButton.setBounds(20, 250, 210, 40);
        FavoriteButton.setBackground(new Color(30, 30, 30));
        FavoriteButton.setForeground(Color.WHITE);
        FavoriteButton.setHorizontalAlignment(SwingConstants.LEFT);
        FavoriteButton.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
        LeftBlackPanel.add(FavoriteButton);

        
        JButton BonusesButton = new JButton("Bonuses");
        BonusesButton.setBounds(20, 350, 210, 40);
        BonusesButton.setBackground(new Color(30, 30, 30));
        BonusesButton.setForeground(Color.WHITE);
        BonusesButton.setHorizontalAlignment(SwingConstants.LEFT);
        BonusesButton.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
        LeftBlackPanel.add(BonusesButton);

        JButton BookedButton = new JButton("Booked");
        BookedButton.setBounds(20, 450, 210, 40);
        BookedButton.setBackground(new Color(30, 30, 30));
        BookedButton.setForeground(Color.WHITE);
        BookedButton.setHorizontalAlignment(SwingConstants.LEFT);
        BookedButton.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
        LeftBlackPanel.add(BookedButton);
        
        JButton LogoutButton = new JButton("Log out...");
        LogoutButton.setBounds(20, 550, 210, 40);
        LogoutButton.setBackground(new Color(30, 30, 30));
        LogoutButton.setForeground(Color.WHITE);
        LogoutButton.setHorizontalAlignment(SwingConstants.LEFT);
        LogoutButton.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
        LogoutButton.addActionListener(e->{
            JOptionPane.showMessageDialog(homePanel, "You are logged out.");
            cardLayout.show(mainPanel, "login");
        });
        LeftBlackPanel.add(LogoutButton);


        //----------Main Panels things----------

        JPanel SearchPanel = new JPanel();
        SearchPanel.setBounds(30, 20, 600, 40);
        SearchPanel.setLayout(null);
        SearchPanel.setBackground(new Color(30, 30, 30));
        MainUserPanel.add(SearchPanel);

        JTextField searchField = new JTextField("Type to Search...");
        searchField.setBounds(10, 5, 380, 30);
        searchField.setBackground(new Color(30, 30, 30));
        searchField.setForeground(Color.GRAY);
        searchField.setBorder(null);

        searchField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (searchField.getText().equals("Type to Search...")) {
                    searchField.setText("");
                    searchField.setForeground(Color.WHITE);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (searchField.getText().isEmpty() || searchField.getText().trim().isEmpty()) {
                    searchField.setText("Type to Search...");
                    searchField.setForeground(Color.gray);
                }
            }

        });
        SearchPanel.add(searchField);

    //----------Slide Panel--------------------------------
    
        JPanel slidePanel = new JPanel(){
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon icon = new ImageIcon("Rayan/bookingTICKET/img/Avatar.jpg"); // sahel sahel ndirlha hal (jsp kifah njib l path)
            Image img = icon.getImage();
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }
        };
        slidePanel.setBounds(30, 78, 840, 350);
        slidePanel.setLayout(null);
        slidePanel.setBackground(new Color(30, 30, 30));
        MainUserPanel.add(slidePanel);


        JPanel filmsGridPanel = new JPanel();
        filmsGridPanel.setLayout(new GridLayout(0, 4, 10, 10));  // Unlimited rows, 4 columns
        filmsGridPanel.setBackground(new Color(18, 18, 18));

        
        JScrollPane scrollPane = new JScrollPane(filmsGridPanel); // create scroll ghir l hada l panel
        scrollPane.setBounds(30, 450, 840, 280);
        scrollPane.setBorder(null);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getViewport().setBackground(new Color(18, 18, 18));
        
        
        filmsGridPanel.addMouseWheelListener(e -> {
            JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();//had scroll pa rapport l y
            int notches = e.getWheelRotation();
            int currentValue = verticalScrollBar.getValue();
            int scrollAmount = 30; // Adjust scroll speed
            verticalScrollBar.setValue(currentValue + (notches * scrollAmount));
        });

        
        for (int i = 0; i < movies.Movies.size(); i++) {
            final int index = i;
            JPanel filmPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    ImageIcon icon = new ImageIcon(movies.Movies.get(index).imagePath);
                    Image img = icon.getImage();
                    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
                }
            };
           
            filmPanel.setLayout(null);
            filmPanel.setPreferredSize(new Dimension(200, 230));
            filmPanel.setBackground(new Color(24, 24, 24));
            filmPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            // Hayla hadi :-) 
            filmPanel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    filmPanel.setBorder(BorderFactory.createLineBorder(Color.red, 1));//ta3 ki t intiracti m3a l panel
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    filmPanel.setBorder(null);
                }
                public void mouseClicked(java.awt.event.MouseEvent evt) {

                    JOptionPane.showMessageDialog(null, "Opening film details...");
                }
            });
            
            filmsGridPanel.add(filmPanel);
        }

        MainUserPanel.add(scrollPane);


        JLabel nowShowingLabel = new JLabel("Our Movies");
        nowShowingLabel.setBounds(30, 430, 200, 20);
        nowShowingLabel.setForeground(Color.WHITE);
        nowShowingLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        MainUserPanel.add(nowShowingLabel);

        //MainUserPanel.setVisible(false);




        




    
        return homePanel;
    }

    public JPanel createHomeAdminPanel(Accounts AdminAccounts){


        JPanel homeAdminPanel = new JPanel();
        homeAdminPanel.setLayout(null);
        homeAdminPanel.setBounds(0, 0, 1200, 750);
        homeAdminPanel.setBackground(Color.BLUE);



        JPanel MoviesPanel = new JPanel();
        MoviesPanel.setBackground(new Color(80,77,74));
        MoviesPanel.setBounds(150, 0, 1050, 750);
        MoviesPanel.setLayout(null);
        

        JPanel UserPanel = new JPanel();
        UserPanel.setBackground(new Color(80,77,74));
        UserPanel.setBounds(150, 0, 1050, 750);
        UserPanel.setLayout(null);
       


        JPanel HallPanel = new JPanel();

        JPanel LeftPanel = new JPanel();
        LeftPanel.setBounds(0,0, 150, 750);
        LeftPanel.setBackground(Color.gray);
        LeftPanel.setLayout(null);

        homeAdminPanel.add(LeftPanel);


        CardLayout AdmincardLayout;
        AdmincardLayout = new CardLayout();
        ContentAdminPanel = new JPanel(AdmincardLayout);
        ContentAdminPanel.setBounds(150, 0, 1050, 750);
        homeAdminPanel.add(ContentAdminPanel);

        ContentAdminPanel.add(MoviesPanel, "MoviePanel");
        ContentAdminPanel.add(UserPanel, "UserPanel");
        ContentAdminPanel.add(HallPanel, "HallPanel");


        setContentPane(homeAdminPanel);
        AdmincardLayout.show(ContentAdminPanel, "MoviesPanel");


        

        
        ImageIcon image1 = resizedIcon("Rayan\\bookingTICKET\\img\\FilmIcon.png",50,50);
        JButton ButtonMovie = new JButton(image1);
        ButtonMovie.setBounds(40, 200, 70, 70);
        ButtonMovie.setContentAreaFilled(false);
        ButtonMovie.setFocusPainted(false);
        ButtonMovie.setBorderPainted(false);
        ButtonMovie.setForeground(Color.WHITE);
        ButtonMovie.addActionListener(e->{
            MoviesPanel.setVisible(true);
        });
        LeftPanel.add(ButtonMovie);

        ImageIcon image2 = resizedIcon("Rayan\\bookingTICKET\\img\\UserIcon.png",50,50);
        JButton ButtonUser = new JButton(image2);
        ButtonUser.setBounds(40, 300, 70, 70);
        ButtonUser.setContentAreaFilled(false);
        ButtonUser.setFocusPainted(false);
        ButtonUser.setBorderPainted(false);
        ButtonUser.setForeground(Color.WHITE);
        ButtonUser.addActionListener(e->{
            AdmincardLayout.show(ContentAdminPanel, "MoviesPanel");
        });
        LeftPanel.add(ButtonUser);

        ImageIcon image3 = resizedIcon("Rayan\\bookingTICKET\\img\\HallIcon.png", 50 ,50);
        JButton ButtonHall = new JButton(image3);
        ButtonHall.setBounds(40, 400, 70, 70);
        ButtonHall.setContentAreaFilled(false);
        ButtonHall.setFocusPainted(false);
        ButtonHall.setBorderPainted(false);
        ButtonHall.setForeground(Color.WHITE);
        ButtonHall.addActionListener(e->{
            AdmincardLayout.show(ContentAdminPanel, "HallPanel");
        });
        LeftPanel.add(ButtonHall);

        ImageIcon image4 = resizedIcon("Rayan\\bookingTICKET\\img\\LogoutIcon.png",50,50);
        JButton ButtonLogout = new JButton(image4);
        ButtonLogout.setBounds(40, 500, 70, 70);
        ButtonLogout.setContentAreaFilled(false);
        ButtonLogout.setFocusPainted(false);
        ButtonLogout.setBorderPainted(false);
        ButtonLogout.setForeground(Color.WHITE);
        ButtonLogout.addActionListener(e->{
            cardLayout.show(mainPanel, "welcome");
        });
        LeftPanel.add(ButtonLogout);

        // Film Image Selection
        RoundedButton selectFilmImageButton = new RoundedButton("Select Film Image" , 10);
        selectFilmImageButton.setBounds(40, 600, 70, 40);
        selectFilmImageButton.setForeground(Color.red);
        selectFilmImageButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif");
            fileChooser.setFileFilter(filter);
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String pathfilm= selectedFile.getAbsolutePath();
                System.out.println(pathfilm);;
            }
        });
        LeftPanel.add(selectFilmImageButton);


        
        // RoundedButton AddMovie = new RoundedButton("", 10);
        // AddMovie.setBounds(320 , 10 , 100 , 100 );
        // AddMovie.setText("Mhbol");
        // AddMovie.setFocusPainted(false);
        // AddMovie.setBackground(Color.YELLOW);
        // AddMovie.addActionListener(e->{
        // int i = 0;
        // // if(i % 2 == 0) {
        // //     AddMoviePanel.setVisible(false);
        // //     i++;
        // // }else{
        // //     AddMoviePanel.setVisible(true);
        // //     i++;
        // // }
                
        // });
        // MoviesPanel.add(AddMovie);

        JPanel AddMoviePanel = new JPanel();
        AddMoviePanel.setLayout(null);
        AddMoviePanel.setBounds(0 ,0 , 1050 ,750);
        AddMoviePanel.setBackground(Color.green);
        MoviesPanel.add(AddMoviePanel);



        JPanel MoviePicture = new JPanel();
        MoviePicture.setBounds(100,55,300,400);
        MoviePicture.setBackground(Color.LIGHT_GRAY);
        MoviePicture.setLayout(null);
        AddMoviePanel.add(MoviePicture);




        JPanel InfoFilm = new JPanel();
        InfoFilm.setLayout(null);
        InfoFilm.setBounds(550 ,55 , 400 ,600);
        InfoFilm.setBackground(Color.gray);
        AddMoviePanel.add(InfoFilm);

        JPanel InfoFilm2 = new JPanel();
        InfoFilm2.setLayout(null);
        InfoFilm2.setBounds(550, 55, 400, 600); // Set bounds for InfoFilm2
        InfoFilm2.setBackground(Color.gray); // Set background color
        AddMoviePanel.add(InfoFilm2); // Add InfoFilm2 to AddMoviePanel
        InfoFilm2.setVisible(false); // Initially hide InfoFilm2

        JLabel AddMovieLabel = new JLabel("Adding New Movie");
        AddMovieLabel.setBounds(20, 30 , 200 , 40);
        AddMovieLabel.setBackground(Color.white);
        AddMovieLabel.setForeground(Color.white);
        AddMovieLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        InfoFilm.add(AddMovieLabel);

        JTextField MovieName = new JTextField();
        MovieName.setBounds( 30, 80 , 200 , 40);
        MovieName.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        MovieName.setForeground(Color.gray);
        MovieName.setBackground(new Color(80, 77, 74));
        MovieName.setCaretColor(Color.white);
        MovieName.setOpaque(true);
        MovieName.setBorder(null);
        TextfieldBehave(MovieName, "   Movie Name");
        InfoFilm.add(MovieName);

        JTextArea description = new JTextArea();
        description.setBounds(30, 130, 300, 250);
        description.setFont(new Font("Segoe UI", Font.PLAIN, 18)); 
        description.setForeground(Color.GRAY); 
        description.setBackground(new Color(80, 77, 74)); 
        description.setCaretColor(Color.WHITE); // Changing cursor color
        description.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        description.setLineWrap(true); 
        description.setWrapStyleWord(true); 
        description.setBorder(null);
        TextAreaBehave(description, "   Movie description");
        InfoFilm.add(description);

        userHasTyped = false; // User has not started typing
        
        JTextField duree = new JTextField();
        duree.setBounds( 30, 390 , 200 , 40);
        duree.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        duree.setForeground(Color.gray);
        duree.setBackground(new Color(80, 77, 74));
        duree.setCaretColor(Color.white);
        duree.setOpaque(true);
        duree.setBorder(null);
        TextfieldBehave(duree, "   Film duration");
        duree.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                userHasTyped = true; // User has started typing
                validateInput(duree, "\\d+");
            }
        
            @Override
            public void removeUpdate(DocumentEvent e) {
                userHasTyped = true; // User has started typing
                validateInput(duree, "\\d+");
            }
        
            @Override
            public void changedUpdate(DocumentEvent e) {
                userHasTyped = true; // User has started typing
                validateInput(duree, "\\d+");
            }
        });
        InfoFilm.add(duree);

        JTextField rating = new JTextField();
        rating.setBounds( 30, 440 , 200 , 40);
        rating.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        rating.setForeground(Color.gray);
        rating.setBackground(new Color(80, 77, 74));
        rating.setCaretColor(Color.white);
        rating.setOpaque(true);
        rating.setBorder(null);
        TextfieldBehave(rating, "   Film Rating");
        rating.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateInput(rating ,"\\d*\\.?\\d+");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateInput(rating ,"\\d*\\.?\\d+");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateInput(rating ,"\\d*\\.?\\d+");
            }
        });
        InfoFilm.add(rating);

        


        JButton SecondPage = new JButton(">");
        SecondPage.setBounds(20, 500 , 50 , 50 );
        SecondPage.setBackground(Color.white);
        SecondPage.setFocusPainted(false);
        SecondPage.setBorderPainted(false);
        SecondPage.setText(">");
        SecondPage.setFocusPainted(false);
        SecondPage.addActionListener(e -> {
            InfoFilm.setVisible(false); // Hide InfoFilm
            InfoFilm2.setVisible(true); // Show InfoFilm2
        });
        InfoFilm.add(SecondPage);

        JButton FirstPage = new JButton(">");
        FirstPage.setBounds(20, 500 , 50 , 50 );
        FirstPage.setBackground(Color.white);
        FirstPage.setFocusPainted(false);
        FirstPage.setBorderPainted(false);
        FirstPage.setText("<");
        FirstPage.setFocusPainted(false);
        FirstPage.addActionListener(e -> {
            InfoFilm.setVisible(true);
            InfoFilm2.setVisible(false);
        });
        InfoFilm2.add(FirstPage);

        Movie.genre[] genres = Movie.genre.values(); 
        JComboBox<genre> genreComboBox = new JComboBox<>(genres);
        genreComboBox.setBounds(20, 40, 150, 30); 
        genreComboBox.setForeground(Color.black);
        genreComboBox.setFocusable(false);
        genreComboBox.setBackground(Color.white);
        genreComboBox.setFont(new Font("Arial", Font.PLAIN, 16));

        RoundedButton showGenre = new RoundedButton("Show Selected Genre" , 7);
        showGenre.setBounds(190, 40, 30, 30);
        showGenre.setFont(new Font("Arial", Font.PLAIN, 16));
        
        showGenre.addActionListener(e->{
            Movie.genre selectedGenre = (Movie.genre) genreComboBox.getSelectedItem();
            System.out.println(selectedGenre);
        });
        // Add components to the main panel
        InfoFilm2.add(new JLabel("Choose a Genre: "));
        InfoFilm2.add(genreComboBox);
        InfoFilm2.add(showGenre);



        Movie.statusFilm[] status = statusFilm.values(); 
        JComboBox<statusFilm> StatusComboBox2 = new JComboBox<>(status);
        StatusComboBox2.setBounds(20, 90, 150, 30); 
        StatusComboBox2.setForeground(Color.black);
        StatusComboBox2.setFocusable(true);
        StatusComboBox2.setBackground(Color.white);
        StatusComboBox2.setFont(new Font("Arial", Font.PLAIN, 16));

        RoundedButton showStatusButton = new RoundedButton("Show Selected Status" , 7);
        showStatusButton.setBounds(190, 90, 30, 30);
        showStatusButton.setFont(new Font("Arial", Font.PLAIN, 14));
        showStatusButton.addActionListener(e-> {
            Movie.statusFilm selectedstatusFilm = (Movie.statusFilm) StatusComboBox2.getSelectedItem();
            System.out.println(selectedstatusFilm);
        });
        InfoFilm2.add(showStatusButton);
        InfoFilm2.add(StatusComboBox2);

        JLabel regularSeatLbl = new JLabel();
        regularSeatLbl.setBounds(30, 140, 150, 30);
        regularSeatLbl.setText("Regular Seats: ");
        regularSeatLbl.setForeground(Color.white);
        regularSeatLbl.setFocusable(false);
        regularSeatLbl.setFont(new Font("Arial", Font.BOLD, 16));
        InfoFilm2.add(regularSeatLbl);

        JTextField regularSeatPricefield = new JTextField();
        regularSeatPricefield.setBounds(190, 140, 150, 30);
        regularSeatPricefield.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        regularSeatPricefield.setForeground(Color.gray);
        regularSeatPricefield.setBackground(new Color(80, 77, 74));
        regularSeatPricefield.setCaretColor(Color.white);
        regularSeatPricefield.setOpaque(true);
        regularSeatPricefield.setBorder(null);
        TextfieldBehave(regularSeatPricefield, "0da");
        regularSeatPricefield.setFont(new Font("Arial", Font.PLAIN, 16));
        regularSeatPricefield.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateInput(regularSeatPricefield ,"\\d*\\.?\\d+");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateInput(regularSeatPricefield ,"\\d*\\.?\\d+");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateInput(regularSeatPricefield ,"\\d*\\.?\\d+");
            }
        });
        InfoFilm2.add(regularSeatPricefield);

        JLabel vipSeatPricelbl = new JLabel();
        vipSeatPricelbl.setBounds(30, 200, 150, 30);
        vipSeatPricelbl.setText("VIP Seats: ");
        vipSeatPricelbl.setForeground(Color.white);
        vipSeatPricelbl.setFocusable(false);
        vipSeatPricelbl.setFont(new Font("Arial", Font.BOLD, 16));
        InfoFilm2.add(vipSeatPricelbl);

        JTextField vipSeatPricefield = new JTextField();
        vipSeatPricefield.setBounds(190, 200, 150, 30);
        vipSeatPricefield.setForeground(Color.black);
        vipSeatPricefield.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        vipSeatPricefield.setForeground(Color.gray);
        vipSeatPricefield.setBackground(new Color(80, 77, 74));
        vipSeatPricefield.setCaretColor(Color.white);
        vipSeatPricefield.setOpaque(true);
        vipSeatPricefield.setBorder(null);
        TextfieldBehave(vipSeatPricefield, "0da");
        vipSeatPricefield.setFont(new Font("Arial", Font.PLAIN, 16));
        vipSeatPricefield.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateInput(vipSeatPricefield ,"\\d*\\.?\\d+");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateInput(vipSeatPricefield ,"\\d*\\.?\\d+");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateInput(vipSeatPricefield ,"\\d*\\.?\\d+");
            }
        });
        InfoFilm2.add(vipSeatPricefield);

        
        JDialog timeDialog = new JDialog(this, "Select Time", true);
        timeDialog.setLayout(new BorderLayout());
        timeDialog.setSize(300, 200);
        timeDialog.setLocationRelativeTo(this);

        
        JPanel timePanel = new JPanel(new FlowLayout());
        SpinnerDateModel timeModel = new SpinnerDateModel();
        JSpinner timeSpinner = new JSpinner(timeModel);
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "yyyy/MM/dd HH:mm");
        timeSpinner.setEditor(timeEditor);
        timePanel.add(new JLabel("Select Time: "));
        timePanel.add(timeSpinner);

        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        timeDialog.add(timePanel, BorderLayout.CENTER);
        timeDialog.add(buttonPanel, BorderLayout.SOUTH);

      
        JLabel selectedTimeLabel = new JLabel("Selected Time: None");
        selectedTimeLabel.setBounds(20, 260, 300, 30);
        selectedTimeLabel.setForeground(Color.black);
        selectedTimeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        InfoFilm2.add(selectedTimeLabel);

      

        
        okButton.addActionListener(e -> {
            Date selectedTime = (Date) timeSpinner.getValue();
            localTime = selectedTime.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalTime();
            String formattedTime = selectedTime.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime()
                .format(java.time.format.DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
            selectedTimeLabel.setText("Selected Time: " + formattedTime);
            timeDialog.dispose();
        });


        cancelButton.addActionListener(e -> {
            selectedTimeLabel.setText("Selected Time: None");
            timeDialog.dispose();
        });

       
        RoundedButton showTimeBtn = new RoundedButton("Show Time" , 7);
        showTimeBtn.setBounds(20, 300, 100, 30);
        showTimeBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        showTimeBtn.addActionListener(e -> {
            timeDialog.setVisible(true); 
        });
        InfoFilm2.add(showTimeBtn);

        JLabel FilmPicture = new JLabel();
        FilmPicture.setBounds(0, 0, 400, 400);
        FilmPicture.setForeground(Color.white);
        FilmPicture.setBackground(Color.green);
        MoviePicture.add(FilmPicture);

        RoundedButton FilmSelectpath = new RoundedButton("Select Film Image", 10);
        FilmSelectpath.setBounds(40, 400, 70, 40);
        FilmSelectpath.setForeground(Color.red);
        FilmSelectpath.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif");
            fileChooser.setFileFilter(filter);
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                pathfilm = selectedFile.getAbsolutePath(); 

                pathfilm = pathfilm.replace("\\", "\\\\");
                System.out.println(pathfilm);

                // Update the FilmPicture label with the selected image
                //ImageIcon MoviePic = resizedIcon(pathfilm , 400 , 300);
                ImageIcon icon = new ImageIcon(pathfilm);
                Image image = icon.getImage().getScaledInstance(FilmPicture.getHeight(), FilmPicture.getWidth(), Image.SCALE_SMOOTH);
                ImageIcon MoviePic = new ImageIcon(image);
                FilmPicture.setIcon(MoviePic); 
                

            }

        });
        InfoFilm2.add(FilmSelectpath);

        RoundedButton validateButton = new RoundedButton("Validate Fields", 10);
        validateButton.setBounds(20, 450, 150, 40);
        validateButton.setFont(new Font("Arial", Font.PLAIN, 16));
        validateButton.addActionListener(e -> {
            boolean isValid = false;
            if (MovieName.getText().trim().isEmpty() || MovieName.getText().equals("   Movie Name") || 
                    description.getText().trim().isEmpty() || description.getText().equals("     Movie description")||
                        duree.getText().trim().isEmpty() || duree.getText().equals("   Film duration") ||
                            rating.getText().trim().isEmpty() || rating.getText().equals("   Film Rating") ||
                                genreComboBox.getSelectedItem() == null || StatusComboBox2.getSelectedItem() == null|| 
                                    regularSeatPricefield.getText().trim().isEmpty() || regularSeatPricefield.getText().equals("0da")|| 
                                        vipSeatPricefield.getText().trim().isEmpty() || vipSeatPricefield.getText().equals("0da")||selectedTimeLabel.getText().equals("Selected Time: None")||
                                             FilmPicture.getIcon() == null) {
                isValid = false;
                JOptionPane.showMessageDialog(this, "Please fill all the fields ", "Error", JOptionPane.ERROR_MESSAGE);
                
            }else if(!duree.getText().trim().matches("\\d+")||!rating.getText().trim().matches("\\d+")||!regularSeatPricefield.getText().trim().matches("\\d+") ||!vipSeatPricefield.getText().trim().matches("\\d+")){
                    isValid = false;
                JOptionPane.showMessageDialog(this, "Please enter a valid input", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    isValid = true;
                }
            
            if(isValid == true) {
                String MovieTitletxt = MovieName.getText();
                if(!movies.CheckifMovieExist(MovieTitletxt)){
                    JOptionPane.showMessageDialog(this, "Mhboll Ana , 3andek l film", "Success", JOptionPane.INFORMATION_MESSAGE);
                String Descriptiontxt = description.getText();
                int DureeMovie = Integer.parseInt(duree.getText().trim());
                String RatingMovie = rating.getText();
                genre genreMovie = (genre) genreComboBox.getSelectedItem();
                statusFilm statusMovie = (statusFilm) StatusComboBox2.getSelectedItem();
                double regularSeatPrice = Double.parseDouble(regularSeatPricefield.getText().trim());
                double vipSeatPrice = Double.parseDouble(vipSeatPricefield.getText().trim());
                movies.addMovie(MovieTitletxt, Descriptiontxt, DureeMovie, genreMovie, RatingMovie, regularSeatPrice, vipSeatPrice, pathfilm, statusMovie, localTime);
                movies.DisplayMovies();
                //refreshUserPanel();

                }else{
                    JOptionPane.showMessageDialog(this, "A film with the same name already exists", "Error", JOptionPane.ERROR_MESSAGE);

                    JOptionPane.showMessageDialog(this, "The arraylist contain " + movies.Movies.size(), "Error", JOptionPane.ERROR_MESSAGE);
                }

            }


        });
        InfoFilm2.add(validateButton);

    
       
        

               

              






        
        


    



                
                




        

        

    

        return homeAdminPanel;
    }
    public JPanel createInterfaceUserPanel(){
        RoundedPanel panel = new RoundedPanel(10);
        panel.setLayout(null);
        panel.setBounds(0, 0, 1200, 750);
        panel.setBackground(new Color(20 ,20 ,20));

        int SCROLL_SPEED = 50;
        JPanel ContentPanel = new JPanel();
        ContentPanel.setLayout(null);
        ContentPanel.setPreferredSize(new Dimension(1050, 1200));
        ContentPanel.setBackground(new Color(20 ,20 ,20));

        
        JScrollPane scrollPane = new JScrollPane(ContentPanel);
        scrollPane.setBounds(200, 0, 1050, 750);
        scrollPane.setBorder(null);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getViewport().setBackground(new Color(30, 30, 30));
        panel.add(scrollPane);

        ContentPanel.addMouseWheelListener(e -> {
            if (scrollPane != null) {
                JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
                int currentValue = verticalScrollBar.getValue();
                int scrollAmount = e.getWheelRotation() * SCROLL_SPEED;
                verticalScrollBar.setValue(currentValue + scrollAmount);
            }
        });

        RoundedPanel SearchBar = new RoundedPanel(30);
        SearchBar.setLayout(null);
        SearchBar.setBounds(150, 20, 640, 40);
        SearchBar.setOpaque(false);
        SearchBar.setBackground(Color.darkGray);
        ContentPanel.add(SearchBar);

        JTextField SearchText = new JTextField("  Search");
        SearchText.setBounds(10, 5, 380, 30);
        SearchText.setBackground(Color.darkGray);
        SearchText.setForeground(Color.WHITE);
        SearchText.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        SearchText.setBorder(null);
        SearchText.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (SearchText.getText().equals("  Search")) {
                    SwingUtilities.invokeLater(() -> {
                        SearchText.setText("");
                        SearchText.setForeground(Color.WHITE);
                    });
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (SearchText.getText().isEmpty()) {
                    SwingUtilities.invokeLater(() -> {
                        SearchText.setText("  Search");
                        SearchText.setForeground(Color.WHITE);
                    });
                }
            }
        });
        SearchBar.add(SearchText);

        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.HORIZONTAL);
        separator.setForeground(Color.gray);
        separator.setBounds(55, 70, 850, 1); // x, y, width, height
        ContentPanel.add(separator);

        RoundedButton TypeButton = new RoundedButton("All >" , 40);
        TypeButton.setBounds(80, 20, 60, 40);
        TypeButton.setOpaque(false);
        TypeButton.setBackground(Color.darkGray);
        TypeButton.setForeground(Color.WHITE);
        TypeButton.setContentAreaFilled(false);
        TypeButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        TypeButton.addActionListener(e->{
            JOptionPane.showMessageDialog(panel, "Type");
        });
        ContentPanel.add(TypeButton);

        RoundedPanel UserPanel = new RoundedPanel(20);
        UserPanel.setLayout(null);
        UserPanel.setBounds(820, 10, 80, 50);
        UserPanel.setBackground(Color.darkGray);
        ContentPanel.add(UserPanel);

        JLabel UserLabel = new JLabel("User");
        UserLabel.setBounds(40, 3, 30, 30);
        UserLabel.setForeground(Color.WHITE);
        UserLabel.setFont(new Font("Segoe UI", Font.BOLD, 10));
        UserPanel.add(UserLabel);

        RoundedPanel UserPHOTO = new RoundedPanel(80);
        UserPHOTO.setLayout(null);
        UserPHOTO.setBackgroundImage("Rayan\\bookingTICKET\\img\\UserIcon1.png");
        UserPHOTO.setBounds(5, 10, 30, 30);
        UserPHOTO.setBackground(Color.red);
        UserPanel.add(UserPHOTO);


        

        

        RoundedPanel LeftPanel = new RoundedPanel(20);
        LeftPanel.setLayout(null);
        LeftPanel.setBounds(30, 40, 160, 630);
        LeftPanel.setBackground(new Color(35,35,35));
        panel.add(LeftPanel);

        JLabel LogoName = new JLabel("INEMATIC");
        LogoName.setBounds(25, 6, 120, 50);
        LogoName.setForeground(Color.WHITE);
        LogoName.setFont(new Font("Segoe UI", Font.BOLD, 16));
        LeftPanel.add(LogoName);
        JLabel CLogored = new JLabel("C");
        CLogored.setBounds(15, 6, 120, 50);
        CLogored.setForeground(Color.red);
        CLogored.setFont(new Font("Segoe UI", Font.BOLD, 16));
        LeftPanel.add(CLogored);

        RoundedButton HomeButton = new RoundedButton("  Home", 20);
        HomeButton.setBounds(0, 100, 150, 40);
        HomeButton.setForeground(Color.WHITE);
        HomeButton.setBackground(new Color(0, 0, 0, 0));
        HomeButton.setContentAreaFilled(false);
        HomeButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        HomeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HomeButton.setBackground(Color.gray);
                HomeButton.setBackground(new Color(0, 0, 0, 50));

            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HomeButton.setBackground(new Color(0, 0, 0, 0));
                
            }
        });
        JLabel IconButton1 = new JLabel(resizedIcon("Rayan\\bookingTICKET\\img\\Homeicon.png", 30, 30));
        IconButton1.setBounds(20, 104, 30, 30);
        LeftPanel.add(IconButton1);
        HomeButton.addActionListener(e->{
            JOptionPane.showMessageDialog(panel, "Home");
        });
        LeftPanel.add(HomeButton);



        JSeparator separator2 = new JSeparator();
        separator2.setOrientation(SwingConstants.HORIZONTAL);
        separator2.setForeground(Color.gray);
        separator2.setBounds(22, 280, 120, 1); // x, y, width, height
        LeftPanel.add(separator2);




        RoundedPanel SlidePanelMovie = new RoundedPanel(20 ,true);
        SlidePanelMovie.setLayout(null);
        SlidePanelMovie.setGradient(400,new Color(0, 0, 0, 0),new Color(0, 0, 0, 230));
        SlidePanelMovie.setBackgroundImage("Rayan/bookingTICKET/img/IntoTheSpiderVerse.jpg");
        SlidePanelMovie.setBounds(64, 90, 800, 270);
        SlidePanelMovie.setBackground(Color.darkGray);
        ContentPanel.add(SlidePanelMovie);

        RoundedButton Gotodetails = new RoundedButton("More About :", 40);
        Gotodetails.setBounds(180, 200, 130, 40);
        Gotodetails.setBackground(Color.BLACK);
        Gotodetails.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        Gotodetails.setForeground(Color.gray);
        Gotodetails.setBorderPainted(false);
        Gotodetails.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Gotodetails.addActionListener(e->{
            JOptionPane.showMessageDialog(panel, "Details");
        });
        SlidePanelMovie.add(Gotodetails);

        RoundedButton BookNow = new RoundedButton("Book Now ", 40);
        BookNow.setBounds(40, 200, 130, 37);
        BookNow.setBackground(Color.white);
        BookNow.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        BookNow.setForeground(Color.black);
        BookNow.setBorderPainted(false);
        BookNow.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        BookNow.addActionListener(e->{
            JOptionPane.showMessageDialog(panel, "Details");
        });
        SlidePanelMovie.add(BookNow);




        JLabel MsgLabel = new JLabel("You Might Like") ;
        MsgLabel.setBounds(64, 370, 200, 30);
        MsgLabel.setForeground(Color.WHITE);
        MsgLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        ContentPanel.add(MsgLabel);

        File moviesFolder = new File("Rayan/bookingTICKET/img/Films/");
        File[] imageFiles = moviesFolder.listFiles((dir, name) -> 
            name.toLowerCase().endsWith(".jpg") || 
            name.toLowerCase().endsWith(".png") || 
            name.toLowerCase().endsWith(".jpeg"));

        
        int NbrsFilm = imageFiles != null ? imageFiles.length : 0;
        int columns = 3; 
        int rowneeded = (int) Math.ceil((double)NbrsFilm / columns);
        int heightneeded = rowneeded * 320; 
        int neededit = heightneeded + 500;
        
        JPanel filmsGridPanel = new JPanel();
       
        filmsGridPanel.setLayout(new GridLayout(0, columns, 60, 80)); 
        filmsGridPanel.setBackground(new Color(20, 20, 20));
        filmsGridPanel.setBounds(64, 420, 800, heightneeded);
        
        
        if (imageFiles != null) {
         for (File imageFile : imageFiles) {
            RoundedPanel filmPanel = new RoundedPanel(20, true);
            String pathfilm = imageFile.getPath();
            filmPanel.setBackgroundImage(pathfilm);
            filmPanel.setLayout(null);
            filmPanel.setGradient(300,new Color(0, 0, 0, 0),new Color(0, 0, 0, 230));
            filmPanel.setPreferredSize(new Dimension(250, 350));
            filmPanel.setBackground(new Color(24, 24, 24));
            filmPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            filmPanel.setBorder(null);
            
            
            String movieTitle = imageFile.getName().replaceFirst("[.][^.]+$", "");
            JLabel titleLabel = new JLabel(movieTitle);
            titleLabel.setBounds(20, filmPanel.getPreferredSize().height +30, 230, 30);
            titleLabel.setForeground(Color.WHITE);
            titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
            filmPanel.add(titleLabel);

            
            filmsGridPanel.add(filmPanel);
        }
    }
        
        ContentPanel.setPreferredSize(new Dimension(1050, neededit));
        ContentPanel.add(filmsGridPanel);







        



        











        return panel;
    }

   

    public void HandleLogin(String email, String password ){
        if (Accounts.isAdmin(email, password)) {
            JOptionPane.showMessageDialog(null, "Welcome Admin!", "Success", JOptionPane.INFORMATION_MESSAGE);
            currentadmin = Accounts.getAccountadmin(email, password);
            cardLayout.show(mainPanel, "homeAdmin");
            return;
        }
        if(Accounts.CheckAccountIfCreated(email, password)){

            JOptionPane.showMessageDialog(null, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            currentuser = Accounts.getAccountuser(email, password);
            cardLayout.show(mainPanel, "homeUser");
            return;

        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    public Boolean HandleSignIn(JTextField username, JPasswordField password, JTextField email, JTextField cardNumber, JTextField ccvnbr) {
        try {
         
            if (!Accounts.CheckAccountIfCreated(username.getText(), new String(password.getPassword()))) {
           
                String cardNumberText = cardNumber.getText().replaceAll("[^0-9.]", "");
                String ccvnbrText = ccvnbr.getText().replaceAll("[^0-9]", "");
    
                if (cardNumberText.isEmpty() || ccvnbrText.isEmpty()) {
                    throw new NumberFormatException("Card number or CCV cannot be empty");
                }
    
                double cardNum = Double.parseDouble(cardNumberText);
                int CCVnbr = Integer.parseInt(ccvnbrText);
    
                if (!email.getText().contains("@gmail.com")) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid email address", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }

                Accounts.AddAccount(username.getText(), new String(password.getPassword()), email.getText(), cardNum, CCVnbr);
    
                JOptionPane.showMessageDialog(null, "Account created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Account already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid card number or CCV format.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void TextfieldBehave(JTextField textField, String placeholder) {
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY);

        textField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (textField.getText().equals(placeholder)) {
                    SwingUtilities.invokeLater(() -> {
                        textField.setText("");
                        textField.setForeground(Color.WHITE);
                    });
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (textField.getText().isEmpty()) {
                    SwingUtilities.invokeLater(() -> {
                        textField.setText(placeholder);
                        textField.setForeground(Color.GRAY);
                    });
                }
            }
        });
    }
    
       public void TextAreaBehave(JTextArea textField, String placeholder) {
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY);

        textField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (textField.getText().equals(placeholder)) {
                    SwingUtilities.invokeLater(() -> {
                        textField.setText("");
                        textField.setForeground(Color.WHITE);
                    });
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (textField.getText().isEmpty()) {
                    SwingUtilities.invokeLater(() -> {
                        textField.setText(placeholder);
                        textField.setForeground(Color.GRAY);
                    });
                }
            }
        });
    }

    public ImageIcon resizedIcon(String path , int height , int width){

        ImageIcon icon = new ImageIcon(path);
        Image image = icon.getImage().getScaledInstance(height, width, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(image);
        

        return  resizedIcon;
    }
  
    public void validateInput(JTextField textField, String regex) {
        String input = textField.getText().trim();
    
        // Skip validation if the text field contains placeholder text
        if (input.equals("   Movie Name") || input.equals("   Film duration") || 
            input.equals("   Film Rating") || input.equals("0da")) {
            textField.setBorder(BorderFactory.createLineBorder(new Color(80, 77, 74))); // Reset border color
            return;
        }
    
        // Validate the input
        if (input.matches(regex)) {
            textField.setBorder(BorderFactory.createLineBorder(Color.GREEN)); // Valid input
        } else {
            textField.setBorder(BorderFactory.createLineBorder(Color.RED)); // Invalid input
         //   JOptionPane.showMessageDialog(this, "Please enter a valid input", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    public static void main(String[] args) {
        try {
            UiClass frame = new UiClass();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    

}

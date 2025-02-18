package Vue;

import Controller.GestionAccounts;
import Moodle.Accounts;
import java.awt.*;
import javax.swing.*;
public class UiClass extends JFrame {
    public JPanel mainPanel;
    public CardLayout cardLayout;
    public GestionAccounts Accounts;  
    public Accounts currentuser ;
    public Accounts currentadmin;  
    
    public UiClass(){
        // Initialize Accounts in the constructor
        Accounts = new GestionAccounts();
        
        setUndecorated(true); 
        setTitle("POO_Movies");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon AppLogo = new ImageIcon("Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Logo.png");
        this.setIconImage(AppLogo.getImage());
        setBounds(100, 100, 1200, 750);
        setLocationRelativeTo(null);
        setResizable(false);

        //  CardLayout khir
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        JPanel welcomePanel = createWelcomePanel();
        JPanel loginPanel = createLoginPanel();
        JPanel registerPanel = createRegisterPanel();
        JPanel forgotPasswordPanel = createForgotPasswordPanel();
        JPanel homeUserPanel = createHomeUserPanel(currentuser);
        JPanel homeAdminPanel = createHomeAdminPanel(currentadmin);

        mainPanel.add(welcomePanel, "welcome");
        mainPanel.add(loginPanel, "login");
        mainPanel.add(registerPanel, "register");
        mainPanel.add(forgotPasswordPanel, "forgotPassword");
        mainPanel.add(homeUserPanel, "homeUser");
        mainPanel.add(homeAdminPanel, "homeAdmin");

        setContentPane(mainPanel);
        cardLayout.show(mainPanel, "homeUser");
        
   
    }

    
    public JPanel createWelcomePanel() {
        JPanel welcomepanel = new JPanel() {
            ImageIcon bgIcon = new ImageIcon("Poo2-TRY-/Rayan/bookingTICKET/img/BackGround 4.png");

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
            ImageIcon bgIcon = new ImageIcon("Poo2-TRY-/Rayan/bookingTICKET/img/BackGround 4.png");
 
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
            ImageIcon bgIcon = new ImageIcon("Poo2-TRY-/Rayan/bookingTICKET/img/BackGround 4.png");
 
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
            ImageIcon bgIcon = new ImageIcon("Poo2-TRY-/Rayan/bookingTICKET/img/BackGround 4.png");
     
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
        addPlaceholderBehavior(usernameField, "Enter your username");
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
        addPlaceholderBehavior(answerField, "Enter your answer");
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

//--------------Background panel(main)
        JPanel BackgroundPanel = new JPanel();
        BackgroundPanel.setBounds(0, 0, 1200, 750);
        BackgroundPanel.setBackground(new Color(18, 18, 18));
        BackgroundPanel.setLayout(null);
        homePanel.add(BackgroundPanel);

        //--------------Left black panel
        JPanel LeftBlackPanel = new JPanel();
        LeftBlackPanel.setBounds(0, 0, 300, 750);
        LeftBlackPanel.setBackground(new Color(24, 24, 24));
        LeftBlackPanel.setLayout(null);
        BackgroundPanel.add(LeftBlackPanel);

        JLabel LogoName = new JLabel("CINEMACITY");
        LogoName.setBounds(17, -124, 300, 300);
        LogoName.setForeground(new Color(183, 255, 0));
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
        BalanceValue.setForeground(new Color(183, 255, 0));
        BalanceValue.setBounds(10, 55, 100, 30);
        BalancePanel.add(BalanceValue);

        RoundedButton Dipostebalance = new RoundedButton("",10);
        Dipostebalance.setBounds(190, 30, 50, 50);
        Dipostebalance.setBackground(new Color(183, 255, 0));
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
        LeftBlackPanel.add(LogoutButton);


        //----------Main Panels things----------

        JPanel SearchPanel = new JPanel();
        SearchPanel.setBounds(330, 20, 600, 40);
        SearchPanel.setLayout(null);
        SearchPanel.setBackground(new Color(30, 30, 30));
        BackgroundPanel.add(SearchPanel);

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
    
        JPanel slidePanel = new JPanel();
        slidePanel.setBounds(330, 78, 840, 350);
        slidePanel.setLayout(null);
        slidePanel.setBackground(new Color(30, 30, 30));
        BackgroundPanel.add(slidePanel);

        JLabel Img = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon icon = new ImageIcon("Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Avatar.jpg");
            Image img = icon.getImage();
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        Img.setBounds(0, 0, 840, 350);
        slidePanel.add(Img);

        // Films Grid Section
        JPanel filmsGridPanel = new JPanel();
        filmsGridPanel.setLayout(new GridLayout(0, 4, 10, 10));  // Unlimited rows, 4 columns
        filmsGridPanel.setBackground(new Color(18, 18, 18));

        
        JScrollPane scrollPane = new JScrollPane(filmsGridPanel); // create scroll ghir l hada l panel
        scrollPane.setBounds(330, 450, 840, 280);
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

        // Add more film panels (e.g., 12 instead of 8)
        for (int i = 0; i < 20; i++) {
            final int index = i;
            JPanel filmPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    ImageIcon icon = new ImageIcon("Poo2-TRY-/Rayan/bookingTICKET/img/film" + (index + 1) + ".jpg");
                    Image img = icon.getImage();
                    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
                }
            };
            filmPanel.setLayout(null);
            filmPanel.setPreferredSize(new Dimension(200, 130));
            filmPanel.setBackground(new Color(24, 24, 24));
            filmPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            // Add mouse listener for hover effect
            filmPanel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    filmPanel.setBorder(BorderFactory.createLineBorder(new Color(183, 255, 0), 2));//ta3 ki t intiracti m3a l panel
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    filmPanel.setBorder(null);
                }
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    // TODO: Add action when film is clicked
                    JOptionPane.showMessageDialog(null, "Opening film details...");
                }
            });
            
            filmsGridPanel.add(filmPanel);
        }

        BackgroundPanel.add(scrollPane);

        // Add title above the grid
        JLabel nowShowingLabel = new JLabel("Now Showing");
        nowShowingLabel.setBounds(330, 430, 200, 20);
        nowShowingLabel.setForeground(Color.WHITE);
        nowShowingLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        BackgroundPanel.add(nowShowingLabel);

        




        




    
        return homePanel;
    }

    public JPanel createHomeAdminPanel(Accounts AdminAccounts){
        JPanel homeAdminPanel = new JPanel();
        homeAdminPanel.setLayout(null);
        homeAdminPanel.setBounds(0, 0, 1200, 750);
        homeAdminPanel.setBackground(Color.BLUE);
        JLabel welcomeLabel = new JLabel("Welcome, Admin!");
        welcomeLabel.setBounds(50, 50, 300, 50);
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
        welcomeLabel.setForeground(Color.red);
        homeAdminPanel.add(welcomeLabel);

        return homeAdminPanel;
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



    public void addPlaceholderBehavior(JTextField textField, String placeholder) {
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY);

        textField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.WHITE);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.GRAY);
                }
            }
        });
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

package GuiManagement;

import MainClasses.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CinemaApp extends JFrame implements ActionListener  {

    //main panel -----------------------------------------------------
    public JPanel MainPanel;

    //Action manager--------------------------------------------------
    public static int Counter = 0;
    //cinema manager---------------------------------------------------
    public Cinema CinemaManager;

    //log in elements : 
    public JPanel LogInPanel;
    public JPanel LogInElements;

    //sign in elements : 
    public JPanel SignInPanel;
    public JPanel SignInElements;

    //Finish signing in panel ------------------------------------------------
    public JPanel RegisterPanel;
    public JPanel RegisterElements;

    //forgot password panels---------------------------------------------
    public JPanel ForgotPasswordPanel;
    public JPanel ForgotPasswordElements;


    //decorative Panels ------------------------------------------------
    public JPanel SignInBackgroundPanel, LogInBackgroundJPanel, RegisterBackgroundJPanel, ForgotPasswordBackground;
    public TransparentPanel BlurPanel, BlurPanel2;

    //layout manager -----------------------------------------------------
    public CardLayout MainCardLayout;

    public CinemaApp(){

        // Initialize components
        this.setTitle("MovieBooking App");
        ImageIcon AppLogo = new ImageIcon("Poo2-TRY-\\Fahd\\bookingTICKET\\Images\\Logo.png");
        this.setIconImage(AppLogo.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 750);
        this.setLocationRelativeTo(null);
        this.setVisible(false);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(new java.awt.Color(0xD2D2D2));

        MainCardLayout = new CardLayout();

        MainPanel = new JPanel(MainCardLayout);


        //openning panel --------------------------------------------------
        SignInPanel = new JPanel();
        SignInPanel.setBounds(0, 0, 1200, 750);
        SignInPanel.setLayout(null);
        SignInPanel.setOpaque(false);

        SignInBackgroundPanel = CreatBackGround1Panel();
        SignInElements = CreatSignInElementsPanel();

        SignInPanel.add(SignInBackgroundPanel);
        SignInPanel.add(SignInElements);

        
        JPanel RedPanel = new JPanel();
        RedPanel.setBounds(0, 710, 1200, 60);
        RedPanel.setBackground(new java.awt.Color(0x550000));

        SignInPanel.add(RedPanel);

        JPanel BluePanel = new JPanel();
        BluePanel.setBounds(0, 725, 1200, 60);
        BluePanel.setBackground(new java.awt.Color(0x000044));

        SignInPanel.add(BluePanel);

        SignInPanel.setComponentZOrder(SignInElements, 2);
        SignInPanel.setComponentZOrder(SignInBackgroundPanel, 3);
        SignInPanel.setComponentZOrder(BluePanel, 0);
        SignInPanel.setComponentZOrder(RedPanel, 1);



        //sign in panel ---------------------------------------------------
        RegisterPanel = new JPanel();
        RegisterPanel.setBounds(0, 0, 1200, 750);
        RegisterPanel.setLayout(null);
        RegisterPanel.setOpaque(false);

        RegisterBackgroundJPanel = CreatBackGround2Panel();
        RegisterElements = CreatRegisterElements();

        RegisterPanel.add(RegisterBackgroundJPanel);
        RegisterPanel.add(RegisterElements);

        RegisterPanel.setComponentZOrder(RegisterElements, 0);
        RegisterPanel.setComponentZOrder(RegisterBackgroundJPanel, 1);



        //log in panel ----------------------------------------------------
        LogInPanel = new JPanel();
        LogInPanel.setBounds(0, 0, 1200, 750);
        LogInPanel.setLayout(null);
        LogInPanel.setOpaque(false);

        LogInBackgroundJPanel = CreatBackGround1Panel();
        LogInElements = CreatLogInElementsPanel();

        LogInPanel.add(LogInBackgroundJPanel);
        LogInPanel.add(LogInElements);

        LogInPanel.setComponentZOrder(LogInElements, 0);
        LogInPanel.setComponentZOrder(LogInBackgroundJPanel, 1);


        //forgot password panel --------------------------------------------
        ForgotPasswordPanel = new JPanel();
        ForgotPasswordPanel.setBounds(0, 0, 1200, 750);
        ForgotPasswordPanel.setLayout(null);
        ForgotPasswordPanel.setOpaque(false);

        ForgotPasswordBackground = CreatBackGround3Panel();
        ForgotPasswordElements = createForgotPasswordPanel();

        ForgotPasswordPanel.add(ForgotPasswordBackground);
        ForgotPasswordPanel.add(ForgotPasswordElements);

        ForgotPasswordPanel.setComponentZOrder(ForgotPasswordElements, 0);
        ForgotPasswordPanel.setComponentZOrder(ForgotPasswordBackground, 1);


        //main panel management-----------------------------------------------
        MainPanel.add(SignInPanel, "open");
        MainPanel.add(RegisterPanel, "register");
        MainPanel.add(LogInPanel, "log in");
        MainPanel.add(ForgotPasswordPanel, "forgot Password");

        setContentPane(MainPanel);
        MainCardLayout.show(MainPanel, "open");

        // Revalidate and repaint to ensure the SettingsPanel is displayed
        this.revalidate();
        this.repaint();
    }

    public JPanel CreatBackGround1Panel(){

        JPanel BackgroundPanel = new JPanel();
        BackgroundPanel.setBounds(0, 0, 1200, 750);

        //the background image :
        Image BackgroundImage = new ImageIcon("Poo2-TRY-\\Fahd\\bookingTICKET\\Images\\BackGround.jpg").getImage();
        JLabel Background = new JLabel();
        Background.setBounds(-15, -15, BackgroundPanel.getWidth(), BackgroundPanel.getHeight());
        Background.setIcon(new ImageIcon(BackgroundImage));
        BackgroundPanel.setLayout(null);
        

        //Blur panel--------------------------------------------------
        BlurPanel = new TransparentPanel(0.85f);
        BlurPanel.setBounds(0, 0, 1200, 750);
        BlurPanel.setLayout(null);
        BlurPanel.setBackground(new java.awt.Color(0x000000));

        BlurPanel.setVisible(true);

        JPanel RedPanel = new JPanel();
        RedPanel.setBounds(0, 710, 1200, 60);
        RedPanel.setBackground(new java.awt.Color(0x550000));

        BackgroundPanel.add(RedPanel);

        JPanel BluePanel = new JPanel();
        BluePanel.setBounds(0, 725, 1200, 60);
        BluePanel.setBackground(new java.awt.Color(0x000044));

        BackgroundPanel.add(BluePanel);

        BackgroundPanel.add(Background);
        BackgroundPanel.add(BlurPanel);

        BackgroundPanel.setComponentZOrder(Background, 2);
        BackgroundPanel.setComponentZOrder(BlurPanel, 0);
        BackgroundPanel.setComponentZOrder(BluePanel, 0);
        BackgroundPanel.setComponentZOrder(RedPanel, 1);


        return BackgroundPanel;
    }

    public JPanel CreatBackGround2Panel(){

        JPanel BackgroundPanel = new JPanel();
        BackgroundPanel.setBounds(0, 0, 1200, 750);

        //the background image :
        Image BackgroundImage = new ImageIcon("Poo2-TRY-/Rayan/bookingTICKET/img/BackGround 4.png").getImage();
        JLabel Background = new JLabel();
        Background.setBounds(-15, -15, BackgroundPanel.getWidth(), BackgroundPanel.getHeight());
        Background.setIcon(new ImageIcon(BackgroundImage));
        BackgroundPanel.setLayout(null);

        //Blur panel--------------------------------------------------
        BlurPanel2 = new TransparentPanel(0.85f);
        BlurPanel2.setBounds(0, 0, 1200, 750);
        BlurPanel2.setLayout(null);
        BlurPanel2.setBackground(new java.awt.Color(0x888888));

        BlurPanel2.setVisible(true);

        JPanel RedPanel = new JPanel();
        RedPanel.setBounds(0, 710, 1200, 60);
        RedPanel.setBackground(new java.awt.Color(0x550000));

        BackgroundPanel.add(RedPanel);

        JPanel BluePanel = new JPanel();
        BluePanel.setBounds(0, 725, 1200, 60);
        BluePanel.setBackground(new java.awt.Color(0x000044));

        BackgroundPanel.add(BluePanel);

        BackgroundPanel.add(Background);
        BackgroundPanel.add(BlurPanel2);

        BackgroundPanel.setComponentZOrder(Background, 2);
        BackgroundPanel.setComponentZOrder(BlurPanel2, 0);
        BackgroundPanel.setComponentZOrder(BluePanel, 0);
        BackgroundPanel.setComponentZOrder(RedPanel, 1);

        return BackgroundPanel;
    }

    public JPanel CreatBackGround3Panel(){
        JPanel BackgroundPanel = new JPanel();
        BackgroundPanel.setBounds(0, 0, 1200, 750);

        //the background image :
        Image BackgroundImage = new ImageIcon("Poo2-TRY-/Rayan/bookingTICKET/img/BackGround 4.png").getImage();
        JLabel Background = new JLabel();
        Background.setBounds(-15, -15, BackgroundPanel.getWidth(), BackgroundPanel.getHeight());
        Background.setIcon(new ImageIcon(BackgroundImage));
        BackgroundPanel.setLayout(null);

        //Blur panel--------------------------------------------------
        BlurPanel2 = new TransparentPanel(0.85f);
        BlurPanel2.setBounds(0, 0, 1200, 750);
        BlurPanel2.setLayout(null);
        BlurPanel2.setBackground(new java.awt.Color(0x000000));

        BlurPanel2.setVisible(true);

        JPanel RedPanel = new JPanel();
        RedPanel.setBounds(0, 710, 1200, 60);
        RedPanel.setBackground(new java.awt.Color(0x550000));

        BackgroundPanel.add(RedPanel);

        JPanel BluePanel = new JPanel();
        BluePanel.setBounds(0, 725, 1200, 60);
        BluePanel.setBackground(new java.awt.Color(0x000044));

        BackgroundPanel.add(BluePanel);

        BackgroundPanel.add(Background);
        BackgroundPanel.add(BlurPanel2);

        BackgroundPanel.setComponentZOrder(Background, 2);
        BackgroundPanel.setComponentZOrder(BlurPanel2, 0);
        BackgroundPanel.setComponentZOrder(BluePanel, 0);
        BackgroundPanel.setComponentZOrder(RedPanel, 1);

        return BackgroundPanel;
    }

    public JPanel CreatSignInElementsPanel(){
        // sign in elements panel ------------------------------------
        SignInElements = new JPanel();
        SignInElements.setBounds(0, 0, 1200, 750);
        SignInElements.setLayout(null);
        SignInElements.setOpaque(false);

        JLabel LogoName = new JLabel("POOMovie");
        LogoName.setBounds(70, 24, 192, 52);
        LogoName.setFont(new Font("Inter", Font.BOLD, 35));
        LogoName.setForeground(Color.red);

        SignInElements.add(LogoName);

        ImageIcon iconMovie = new ImageIcon("Poo2-TRY-/Rayan/bookingTICKET/img/movie.png");
        JLabel imageLabel = new JLabel(iconMovie);
        imageLabel.setBounds(10, 20, 64, 64);

        SignInElements.add(imageLabel);

        JLabel WelcomText1 = new JLabel("Unlimited films in theaters,");//and more to come
        WelcomText1.setBounds(332, 222, 575, 115);
        WelcomText1.setFont(new Font("Inter", Font.BOLD, 40));
        WelcomText1.setForeground(Color.white);

        JLabel WelcomText2 = new JLabel("and more to come");
        WelcomText2.setBounds(400, 270, 575, 115);
        WelcomText2.setFont(new Font("Inter", Font.BOLD, 40));
        WelcomText2.setForeground(Color.white);

        SignInElements.add(WelcomText1);
        SignInElements.add(WelcomText2);

        JLabel DescriptionText = new JLabel("Experience the magic of PooMovie, where unlimited films await you.");
        DescriptionText.setBounds(340, 310, 1160, 115);
        DescriptionText.setFont(new Font("Inter", Font.BOLD, 15));
        DescriptionText.setForeground(Color.white);

        SignInElements.add(DescriptionText);

        // Sign in and Log in buttons ------------------------------------

        JButton LogIn = new JButton("log In");
        LogIn.setBounds(1090, 25, 75, 30);
        LogIn.setBackground(Color.RED);
        LogIn.setForeground(Color.white);
        LogIn.setFont(new Font("Inter", Font.BOLD, 15));
        LogIn.setFocusable(false);
        LogIn.setUI(new RoundButtonUI(new Color(0x000000)));

        LogIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LogIn.setBackground(new Color(0x550000));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LogIn.setBackground(new Color(255, 0, 0));
            }
        });


        LogIn.addActionListener(e->{
            MainCardLayout.show(MainPanel, "log in");
        });

        SignInElements.add(LogIn);

        JButton SignIn = new JButton("Sign in");
        SignIn.setBounds(790, 430, 130, 45);
        SignIn.setBackground(Color.RED);
        SignIn.setForeground(Color.white);
        SignIn.setFont(new Font("Inter", Font.BOLD, 15));
        SignIn.setFocusable(false);
        SignIn.setUI(new RoundButtonUI(new Color(0x000000)));

        SignIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SignIn.setBackground(new Color(0x550000));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SignIn.setBackground(new Color(255, 0, 0));
            }
        });

        SignIn.addActionListener(e -> {
            MainCardLayout.show(MainPanel, "register");
        });

        SignInElements.add(SignIn);

        JTextField AdressInput = new JTextField();
        AdressInput.setBounds(285, 430, 500, 45);
        AdressInput.setFont(new Font("Arial", Font.BOLD, 20));
        AdressInput.setBackground(new java.awt.Color(0x222222));
        AdressInput.setForeground(Color.WHITE);
        AdressInput.setCaretColor(Color.WHITE);

        SignInElements.add(AdressInput);

        JButton ChangeTheme = new JButton("Change theme");
        ChangeTheme.setBounds(950, 25, 130, 30);
        ChangeTheme.setBackground(Color.WHITE);
        ChangeTheme.setFont(new Font("Inter", Font.BOLD, 12));
        ChangeTheme.setFocusable(false);
        ChangeTheme.setUI(new RoundButtonUI(new Color(0x000000)));

        ChangeTheme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ChangeTheme.setBackground(new Color(0x999999));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ChangeTheme.setBackground(Color.WHITE);
            }
        });

        ChangeTheme.addActionListener(e-> {
            if(Counter%2 == 0){
                BlurPanel.setBackground(new java.awt.Color(0xFFFFFF));
                ChangeTheme.setBackground(new java.awt.Color(0x000000));
                ChangeTheme.setForeground(Color.WHITE);
                WelcomText1.setForeground(new java.awt.Color(0x000000));
                WelcomText2.setForeground(new java.awt.Color(0x000000));
                DescriptionText.setForeground(new java.awt.Color(0x000000));
                AdressInput.setBackground(new java.awt.Color(0xBBBBBB));
                AdressInput.setForeground(Color.BLACK);

                // Revalidate and repaint to ensure the SettingsPanel is displayed
                this.revalidate();
                this.repaint();

                Counter++;
                
            }
            BlurPanel.setBackground(new java.awt.Color(0x000000));
            ChangeTheme.setBackground(new java.awt.Color(0xFFFFFF));
            ChangeTheme.setForeground(Color.BLACK);
            WelcomText1.setForeground(new java.awt.Color(0xFFFFFF));
            WelcomText2.setForeground(new java.awt.Color(0xFFFFFF));
            DescriptionText.setForeground(new java.awt.Color(0xFFFFFF));
            AdressInput.setBackground(new java.awt.Color(0x222222));
            AdressInput.setForeground(Color.WHITE);


            // Revalidate and repaint to ensure the SettingsPanel is displayed
            this.revalidate();
            this.repaint();

            Counter++;
        });

        SignInElements.add(ChangeTheme);

        return SignInElements;
    }

    public JPanel CreatLogInElementsPanel(){
        JPanel loginPanel = new JPanel();
        loginPanel.setBounds(0, 0, 1200, 750);
        loginPanel.setLayout(null);
        loginPanel.setOpaque(false);

        JLabel LogoName = new JLabel("POOMovie");
        LogoName.setBounds(70, 24, 192, 52);
        LogoName.setFont(new Font("Inter", Font.BOLD, 35));
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
        JButton SignInButton = new JButton("log in");
        SignInButton.setBounds(50, 270, 340, 40);
        SignInButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        SignInButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        SignInButton.setBackground(Color.red);
        SignInButton.setForeground(Color.white);
        SignInButton.setBorder(BorderFactory.createEmptyBorder());
        SignInButton.setUI(new RoundButtonUI(new Color(0x000000)));
        RectangleLogin.add(SignInButton);

        JLabel Or = new JLabel("OR");
        Or.setBounds(106 + 100, 310, 30, 40); // :- )
        Or.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Or.setForeground(Color.white);
        RectangleLogin.add(Or);

        JButton btnforgetpassword = new JButton("Forgot password ?");
        btnforgetpassword.setBounds(25, 400, 200, 30);
        btnforgetpassword.setFont(new Font("Segoe UI", Font.BOLD, 17));
        btnforgetpassword.setForeground(Color.white);
        btnforgetpassword.setContentAreaFilled(false);
        btnforgetpassword.setBorderPainted(false);
        btnforgetpassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnforgetpassword.addActionListener(e -> {
            MainCardLayout.show(MainPanel, "forgot Password");
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
            MainCardLayout.show(MainPanel, "register");
        });
      
        RectangleLogin.add(SignupButton);

        JButton returnbtnWelcomePanel = new JButton("return");
        returnbtnWelcomePanel.setBounds(50, 350, 340, 40);
        returnbtnWelcomePanel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        returnbtnWelcomePanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        returnbtnWelcomePanel.setBackground(new java.awt.Color(0xAAAAAA));
        returnbtnWelcomePanel.setForeground(Color.white);
        returnbtnWelcomePanel.setBorder(BorderFactory.createEmptyBorder());
        returnbtnWelcomePanel.setUI(new RoundButtonUI(new Color(0x000000)));
        returnbtnWelcomePanel.addActionListener(e ->{
            MainCardLayout.show(MainPanel, "open");
        });
        RectangleLogin.add(returnbtnWelcomePanel);

        return loginPanel;
        
    }


    public JPanel CreatRegisterElements(){
        //Finish signing in panel ------------------------------------------------
        RegisterElements = new JPanel();
        RegisterElements.setBounds(0, 0, 1200, 750);
        RegisterElements.setLayout(null);
        RegisterElements.setOpaque(false);

        JLabel PooMovie2 = new JLabel("PooMovie");
        PooMovie2.setBounds(30, 35, 200, 50);
        PooMovie2.setFont(new Font("Inter", Font.BOLD, 35));
        PooMovie2.setForeground(new java.awt.Color(0xFF0000));

        RegisterElements.add(PooMovie2);

        //signUP panel -----------------------------------------------------------
        TransparentPanel SignUpPanel = new TransparentPanel(0.5f);
        SignUpPanel.setBounds(330, 130, 500, 800);
        SignUpPanel.setLayout(null);
        SignUpPanel.setBackground(Color.LIGHT_GRAY);
        


        RegisterElements.add(SignUpPanel);

        JPanel RedPanel = new JPanel();
        RedPanel.setBounds(0, 710, 1200, 60);
        RedPanel.setBackground(new java.awt.Color(0x550000));

        RegisterElements.add(RedPanel);

        JPanel BluePanel = new JPanel();
        BluePanel.setBounds(0, 725, 1200, 60);
        BluePanel.setBackground(new java.awt.Color(0x000044));

        RegisterElements.add(BluePanel);

        RegisterElements.setComponentZOrder(BluePanel, 0);
        RegisterElements.setComponentZOrder(RedPanel, 1);

        return RegisterElements;
    }

    
    public JPanel createForgotPasswordPanel() {
        JPanel forgotPanel = new JPanel();
        forgotPanel.setLayout(null);
        forgotPanel.setBounds(0, 0, 1200, 750);
        forgotPanel.setOpaque(false);
    
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
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(50, 300, 340, 40);
        submitButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        submitButton.setBackground(Color.red);
        submitButton.setForeground(Color.white);
        submitButton.setFocusPainted(false);
        submitButton.setUI(new RoundButtonUI(new Color(0x000000)));
        submitButton.addActionListener(e -> {
            if (answerField.getText().equals("22")) {
                // Show password in a dialog
                JOptionPane.showMessageDialog(forgotPanel, 
                    "Your password is: YourStoredPassword", 
                    "Password Recovery", 
                    JOptionPane.INFORMATION_MESSAGE);

                MainCardLayout.show(MainPanel, "login");
            } else {
                JOptionPane.showMessageDialog(forgotPanel, 
                    "Incorrect answer. Please try again.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        });
        rectangleForgot.add(submitButton);
    
        // Return Button
        JButton returnButton = new JButton("Return to log in");
        returnButton.setBounds(50, 360, 340, 40);
        returnButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        returnButton.setBackground(Color.gray);
        returnButton.setForeground(Color.white);
        returnButton.setFocusPainted(false);
        returnButton.setUI(new RoundButtonUI(new Color(0x000000)));
        returnButton.addActionListener(e -> MainCardLayout.show(MainPanel, "log in"));
        rectangleForgot.add(returnButton);
    
        return forgotPanel;
    }
    
    // Helper method for placeholder text behavior
    public void addPlaceholderBehavior(JTextField field, String placeholder) {
        field.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(Color.WHITE);
                }
            }
    
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (field.getText().isEmpty()) {
                    field.setText(placeholder);
                    field.setForeground(Color.gray);
                }
            }
        });
    }

    public static void main(String[] args) {
        try {
            CinemaApp Frame = new CinemaApp();
            Frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}

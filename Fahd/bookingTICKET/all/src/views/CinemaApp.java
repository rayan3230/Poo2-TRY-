package views;

import Model.*;
import controller.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CinemaApp extends JFrame implements ActionListener {
    // Manager elements ------------------------------------------------
    public static MovieManager movieManager;
    public static ClientManager clientManager;
    public static AdminManager adminManager;
    public static TheaterManager theaterManager;
    public static BookingManager bookingManager;
    public static BroadcastManager broadcastManager;

    // Main elements : ------------------------------------------------
    public static Movie CurrentMovie;
    public static Movie.MovieGenre ChosenGenre;

    // log in elements : ------------------------------------------------
    public JPanel WelcomePanel;
    public JPanel LogInPanel;
    public JPanel SignInPanel;
    public JPanel ForgotPasswordPanel;
    public JPanel ClientPanel;
    public JPanel AdminPanel;
    public JPanel MainPanel;

    // fonctionnalities elements ---------------------------------------
    public Timer timer, timer2;
    public int x = 1500;
    public int xVelocity = 30;
    public int Counter = 0;
    public JScrollPane scrollPane3, scrollPane4;

    // decorative Panels ------------------------------------------------
    public TransparentPanel BlurPanel, BlurPanel2, BlurPanel3;

    // layout manager -----------------------------------------------------
    public CardLayout MainCardLayout;

    public CinemaApp() {
        // Initialize managers
        movieManager = new MovieManager();
        clientManager = new ClientManager();
        adminManager = new AdminManager();
        theaterManager = new TheaterManager();
        bookingManager = new BookingManager();
        broadcastManager = new BroadcastManager();

        // Initialize components
        this.setTitle("MovieBooking App");
        ImageIcon AppLogo = new ImageIcon("Images\\Logo.png");
        this.setIconImage(AppLogo.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 750);
        this.setLocationRelativeTo(null);
        this.setVisible(false);
        this.setResizable(false);
        this.setLayout(null);

        MainCardLayout = new CardLayout();
        MainPanel = new JPanel(MainCardLayout);

        // openning panel --------------------------------------------------
        WelcomePanel = new JPanel();
        WelcomePanel.setBounds(0, 0, 1200, 750);
        WelcomePanel.setLayout(null);
        WelcomePanel.setOpaque(false);

        JPanel WelcomeBackgroundPanel = CreateBackGroundPanel();
        JPanel WelcomeElements = CreateWelcomePanel();

        WelcomePanel.add(WelcomeBackgroundPanel);
        WelcomePanel.add(WelcomeElements);

        WelcomePanel.setComponentZOrder(WelcomeElements, 0);
        WelcomePanel.setComponentZOrder(WelcomeBackgroundPanel, 1);

        // sign in panel ---------------------------------------------------
        SignInPanel = new JPanel();
        SignInPanel.setBounds(0, 0, 1200, 750);
        SignInPanel.setLayout(null);
        SignInPanel.setOpaque(false);

        JPanel SignInBackgroundJPanel = CreateBackGroundPanel();
        JPanel SignInElements = CreateSignInElementsPanel();

        SignInPanel.add(SignInBackgroundJPanel);
        SignInPanel.add(SignInElements);

        SignInPanel.setComponentZOrder(SignInElements, 0);
        SignInPanel.setComponentZOrder(SignInBackgroundJPanel, 1);

        // log in panel ----------------------------------------------------
        LogInPanel = new JPanel();
        LogInPanel.setBounds(0, 0, 1200, 750);
        LogInPanel.setLayout(null);
        LogInPanel.setOpaque(false);

        JPanel LogInBackgroundJPanel = CreateBackGroundPanel();
        JPanel LogInElements = CreateLogInElementsPanel();

        LogInPanel.add(LogInBackgroundJPanel);
        LogInPanel.add(LogInElements);

        LogInPanel.setComponentZOrder(LogInElements, 0);
        LogInPanel.setComponentZOrder(LogInBackgroundJPanel, 1);

        // forgot password panel --------------------------------------------
        ForgotPasswordPanel = new JPanel();
        ForgotPasswordPanel.setBounds(0, 0, 1200, 750);
        ForgotPasswordPanel.setLayout(null);
        ForgotPasswordPanel.setOpaque(false);

        JPanel ForgotPasswordBackground = CreateBackGroundPanel();
        JPanel ForgotPasswordElements = CreateForgotPasswordPanel();

        ForgotPasswordPanel.add(ForgotPasswordBackground);
        ForgotPasswordPanel.add(ForgotPasswordElements);

        ForgotPasswordPanel.setComponentZOrder(ForgotPasswordElements, 0);
        ForgotPasswordPanel.setComponentZOrder(ForgotPasswordBackground, 1);

        // Client / User Interface --------------------------------------------
        ClientPanel = new JPanel();
        ClientPanel.setBounds(0, 0, 1200, 750);
        ClientPanel.setLayout(null);
        ClientPanel.setOpaque(false);

        JPanel ClientElements = CreateClientInterface();

        ClientPanel.add(ClientElements);

        // admin interface -----------------------------------------------------
        AdminPanel = new JPanel();
        AdminPanel.setBounds(0, 0, 1200, 750);
        AdminPanel.setLayout(null);
        AdminPanel.setOpaque(false);

        JPanel AdminElements = CreateAdminInterface();

        AdminPanel.add(AdminElements);

        // Account Panel--------------------------------------------------------
        JPanel AccountPanel = CreateAccountPanel();

        // Account admin Panel--------------------------------------------------------
        JPanel AccountAdminPanel = CreateAccountAdminPanel();

        // add panels to the main panel ----------------------------------------
        MainPanel.add(WelcomePanel, "Welcome");
        MainPanel.add(LogInPanel, "LogIn");
        MainPanel.add(SignInPanel, "SignIn");
        MainPanel.add(ForgotPasswordPanel, "Forgot Password");
        MainPanel.add(ClientPanel, "Client");
        MainPanel.add(AdminPanel, "Admin");
        MainPanel.add(AccountPanel, "Account");
        MainPanel.add(AccountAdminPanel, "Account Admin");

        // add the main panel to the JFrame ----------------------------------
        setContentPane(MainPanel);
        MainCardLayout.show(MainPanel, "Client");

        // Revalidate and repaint to ensure the SettingsPanel is displayed
        this.revalidate();
        this.repaint();

    }

    // create components----------------------------------------------------------------
    public JPanel CreateBackGroundPanel() {

        JPanel BackgroundPanel = new JPanel();
        BackgroundPanel.setBounds(0, 0, 1200, 750);
        BackgroundPanel.setLayout(null);
        BackgroundPanel.setOpaque(false);

        // Blur panel--------------------------------------------------
        this.BlurPanel = new TransparentPanel(0.75f);
        BlurPanel.setBounds(0, 0, 1200, 750);
        BlurPanel.setLayout(null);
        BlurPanel.setBackground(new java.awt.Color(0x2D3142));

        BlurPanel.setVisible(true);

        // The background image:
        ImageIcon originalIcon = new ImageIcon(
                "Images\\MilesBackground.png");
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(BackgroundPanel.getWidth(), BackgroundPanel.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel Background = new JLabel(scaledIcon);
        Background.setBounds(0, 0, BackgroundPanel.getWidth(), BackgroundPanel.getHeight());

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

    public JPanel CreateWelcomePanel() {
        JPanel WelcomeElements = new JPanel();
        WelcomeElements.setBounds(0, 0, 1200, 750);
        WelcomeElements.setLayout(null);
        WelcomeElements.setOpaque(false);

        JLabel LogoName = new JLabel("POOMovie");
        LogoName.setBounds(70, 24, 192, 52);
        LogoName.setFont(new Font("Inter", Font.BOLD, 35));
        LogoName.setForeground(Color.red);

        WelcomeElements.add(LogoName);

        ImageIcon iconMovie = new ImageIcon("Poo2-TRY-/Rayan/bookingTICKET/img/movie.png");
        JLabel imageLabel = new JLabel(iconMovie);
        imageLabel.setBounds(10, 20, 64, 64);

        WelcomeElements.add(imageLabel);

        JLabel WelcomText1 = new JLabel("Unlimited films in theaters,");// and more to come
        WelcomText1.setBounds(332, 222, 575, 115);
        WelcomText1.setFont(new Font("Inter", Font.BOLD, 40));
        WelcomText1.setForeground(Color.white);

        JLabel WelcomText2 = new JLabel("and more to come");
        WelcomText2.setBounds(400, 270, 575, 115);
        WelcomText2.setFont(new Font("Inter", Font.BOLD, 40));
        WelcomText2.setForeground(Color.white);

        WelcomeElements.add(WelcomText1);
        WelcomeElements.add(WelcomText2);

        JLabel DescriptionText = new JLabel("Experience the magic of PooMovie, where unlimited films await you.");
        DescriptionText.setBounds(340, 310, 1160, 115);
        DescriptionText.setFont(new Font("Inter", Font.BOLD, 15));
        DescriptionText.setForeground(Color.white);

        WelcomeElements.add(DescriptionText);

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

        LogIn.addActionListener(e -> {
            MainCardLayout.show(MainPanel, "LogIn");
        });

        WelcomeElements.add(LogIn);

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
            MainCardLayout.show(MainPanel, "SignIn");
        });

        WelcomeElements.add(SignIn);

        JTextField AdressInput = new JTextField();
        AdressInput.setBounds(285, 430, 500, 45);
        AdressInput.setFont(new Font("Arial", Font.BOLD, 20));
        AdressInput.setBackground(new java.awt.Color(0xBBBBBB));
        AdressInput.setForeground(Color.BLACK);
        AdressInput.setCaretColor(Color.WHITE);
        TextfieldBehave(AdressInput, "Enter your email address");

        WelcomeElements.add(AdressInput);

        JButton ExitButton = new JButton("Exit");
        ExitButton.setBounds(950, 25, 130, 30);
        ExitButton.setBackground(Color.WHITE);
        ExitButton.setFont(new Font("Inter", Font.BOLD, 12));
        ExitButton.setFocusable(false);
        ExitButton.setUI(new RoundButtonUI(new Color(0x000000)));

        ExitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExitButton.setBackground(new Color(0x999999));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExitButton.setBackground(Color.WHITE);
            }
        });

        ExitButton.addActionListener(e -> {
            System.exit(0);
        });

        WelcomeElements.add(ExitButton);

        return WelcomeElements;
    }

    public JPanel CreateSignInElementsPanel() {
        JPanel SignInElements = new JPanel();
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

        // signUP panel -----------------------------------------------------------
        TransparentPanel SignUpPanel = new TransparentPanel(0.5f);
        SignUpPanel.setBounds(400, 100, 440, 620);
        SignUpPanel.setLayout(null);
        SignUpPanel.setBackground(Color.black);

        JLabel SigninLabel = new JLabel("Sign In");
        SigninLabel.setBounds(50, 40, 200, 50);
        SigninLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        SigninLabel.setForeground(Color.white);

        SignUpPanel.add(SigninLabel);

        JTextField UserNameField = new JTextField();
        UserNameField.setBounds(50, 120, 340, 40);
        UserNameField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        UserNameField.setForeground(Color.black);
        UserNameField.setCaretColor(Color.black);
        UserNameField.setBackground(new Color(0xBBBBBB));
        UserNameField.setOpaque(true);
        TextfieldBehave(UserNameField, "    Username");
        SignUpPanel.add(UserNameField);

        JPasswordField PasswordsField = new JPasswordField("    Password");
        PasswordsField.setBounds(50, 200, 340, 40);
        PasswordsField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        PasswordsField.setForeground(Color.black);
        PasswordsField.setCaretColor(Color.black);
        PasswordsField.setBackground(new Color(0xBBBBBB));
        PasswordsField.setOpaque(true);
        TextfieldBehave(PasswordsField, "    Password");
        SignUpPanel.add(PasswordsField);

        JTextField EmailField = new JTextField("   email@example.com");
        EmailField.setBounds(50, 280, 340, 40);
        EmailField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        EmailField.setForeground(Color.black);
        EmailField.setCaretColor(Color.black);
        EmailField.setBackground(new Color(0xBBBBBB));
        EmailField.setOpaque(true);

        TextfieldBehave(EmailField, "   email@example.com");
        SignUpPanel.add(EmailField);

        JTextField CardNmbrField = new JTextField("   Card Number");
        CardNmbrField.setBounds(50, 360, 340, 40);
        CardNmbrField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        CardNmbrField.setForeground(Color.black);
        CardNmbrField.setCaretColor(Color.black);
        CardNmbrField.setBackground(new Color(0xBBBBBB));
        CardNmbrField.setOpaque(true);
        TextfieldBehave(CardNmbrField, "   Card Number");
        SignUpPanel.add(CardNmbrField);

        JTextField CCVNmbrField = new JTextField("   CCV Number");
        CCVNmbrField.setBounds(50, 440, 340, 40);
        CCVNmbrField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        CCVNmbrField.setForeground(Color.black);
        CCVNmbrField.setCaretColor(Color.black);
        CCVNmbrField.setBackground(new Color(0xBBBBBB));
        CCVNmbrField.setOpaque(true);

        TextfieldBehave(CCVNmbrField, "   CCV Number");
        SignUpPanel.add(CCVNmbrField);

        JButton ConfirmSignUpButton = new JButton("sign up");
        ConfirmSignUpButton.setBounds(250, 520, 180, 50);
        ConfirmSignUpButton.setForeground(Color.white);
        ConfirmSignUpButton.setFocusPainted(false);
        ConfirmSignUpButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        ConfirmSignUpButton.setBackground(Color.red);
        ConfirmSignUpButton.setUI(new RoundButtonUI(new Color(0x000000)));

        ConfirmSignUpButton.addActionListener(e -> {
            HandleSignIn(UserNameField, PasswordsField,
                    EmailField, CardNmbrField, CCVNmbrField, CCVNmbrField);
        });

        SignUpPanel.add(ConfirmSignUpButton);

        JButton ReturnBtn = new JButton("return");
        ReturnBtn.setBounds(20, 520, 180, 50);
        ReturnBtn.setForeground(Color.white);
        ReturnBtn.setFocusPainted(false);
        ReturnBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        ReturnBtn.setBackground(Color.red);
        ReturnBtn.setUI(new RoundButtonUI(new Color(0x000000)));
        ReturnBtn.addActionListener(e -> {
            MainCardLayout.show(MainPanel, "Welcome");
        });
        SignUpPanel.add(ReturnBtn);

        SignInElements.add(SignUpPanel);

        return SignInElements;
    }

    public JPanel CreateLogInElementsPanel() {
        JPanel LogInElements = new JPanel();
        LogInElements.setBounds(0, 0, 1200, 750);
        LogInElements.setLayout(null);
        LogInElements.setOpaque(false);

        JLabel LogoName = new JLabel("POOMovie");
        LogoName.setBounds(70, 24, 192, 52);
        LogoName.setFont(new Font("Inter", Font.BOLD, 35));
        LogoName.setForeground(Color.red);
        LogInElements.add(LogoName);

        ImageIcon iconMovie = new ImageIcon("Poo2-TRY-/Rayan/bookingTICKET/img/movie.png");
        JLabel imageLabel = new JLabel(iconMovie);
        imageLabel.setBounds(10, 20, 64, 64);
        LogInElements.add(imageLabel);

        TransparentPanel RectangleLogin = new TransparentPanel(0.5f);
        RectangleLogin.setBounds(400, 100, 440, 620);
        RectangleLogin.setLayout(null);
        RectangleLogin.setBackground(Color.black);
        LogInElements.add(RectangleLogin);

        JLabel LogInLabel = new JLabel("Log In");
        LogInLabel.setBounds(50, 40, 200, 50);
        LogInLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        LogInLabel.setForeground(Color.white);
        RectangleLogin.add(LogInLabel);

        JTextField EmailField = new JTextField("   Email or username or phone number");
        EmailField.setBounds(50, 120, 340, 40);
        EmailField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        EmailField.setForeground(Color.black);
        EmailField.setCaretColor(Color.black);
        // EmailField.setBackground(new Color(80, 77, 74, 230));
        EmailField.setBackground(new Color(0xBBBBBB));
        EmailField.setOpaque(true);

        TextfieldBehave(EmailField, "   Email or username or phone number");

        RectangleLogin.add(EmailField);

        JPasswordField PasswordField = new JPasswordField(" Password");
        PasswordField.setBounds(50, 200, 340, 40);
        PasswordField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        PasswordField.setForeground(Color.black);
        PasswordField.setCaretColor(Color.black);
        // PasswordField.setBackground(new Color(80, 77, 74, 230));
        PasswordField.setBackground(new Color(0xBBBBBB));
        PasswordField.setOpaque(true);
        TextfieldBehave(PasswordField, " Password");
        RectangleLogin.add(PasswordField);

        JButton LogInButton = new JButton("log in");
        LogInButton.setBounds(50, 270, 340, 40);
        LogInButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        LogInButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        LogInButton.setBackground(Color.red);
        LogInButton.setForeground(Color.white);
        LogInButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        LogInButton.setBorder(BorderFactory.createEmptyBorder());
        LogInButton.setUI(new RoundButtonUI(new Color(0x000000)));

        LogInButton.addActionListener(e -> {
            HandleLogIn(EmailField.getText(), PasswordField.getText());
        });

        RectangleLogin.add(LogInButton);

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
            MainCardLayout.show(MainPanel, "Forgot Password");
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
            MainCardLayout.show(MainPanel, "SignIn");
        });

        RectangleLogin.add(SignupButton);

        JButton returnbtnWelcomePanel = new JButton("return");
        returnbtnWelcomePanel.setBounds(50, 350, 340, 40);
        returnbtnWelcomePanel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        returnbtnWelcomePanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        returnbtnWelcomePanel.setBackground(new java.awt.Color(0x777777));
        returnbtnWelcomePanel.setForeground(Color.white);
        returnbtnWelcomePanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        returnbtnWelcomePanel.setBorder(BorderFactory.createEmptyBorder());
        returnbtnWelcomePanel.setUI(new RoundButtonUI(new Color(0x000000)));
        returnbtnWelcomePanel.addActionListener(e -> {
            MainCardLayout.show(MainPanel, "Welcome");
        });
        RectangleLogin.add(returnbtnWelcomePanel);

        return LogInElements;
    }

    public JPanel CreateForgotPasswordPanel() {
        JPanel ForgotPasswordElements = new JPanel();
        ForgotPasswordElements.setLayout(null);
        ForgotPasswordElements.setBounds(0, 0, 1200, 750);
        ForgotPasswordElements.setOpaque(false);

        // Logo
        JLabel LogoName = new JLabel("POOMovie");
        LogoName.setBounds(70, 24, 192, 52);
        LogoName.setFont(new Font("Inter", Font.BOLD, 35));
        LogoName.setForeground(Color.red);

        ForgotPasswordElements.add(LogoName);

        ImageIcon iconMovie = new ImageIcon("Poo2-TRY-/Rayan/bookingTICKET/img/movie.png");
        JLabel imageLabel = new JLabel(iconMovie);
        imageLabel.setBounds(10, 20, 64, 64);

        ForgotPasswordElements.add(imageLabel);

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
        ForgotPasswordElements.add(rectangleForgot);

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
        usernameField.setForeground(Color.black);
        usernameField.setBackground(new Color(0xBBBBBB));
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
        answerField.setForeground(Color.black);
        answerField.setBackground(new Color(0xBBBBBB));
        answerField.setCaretColor(Color.white);
        answerField.setOpaque(true);
        answerField.setBorder(null);
        TextfieldBehave(answerField, "Enter your answer");
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
                JOptionPane.showMessageDialog(ForgotPasswordElements,
                        "Your password is: YourStoredPassword",
                        "Password Recovery",
                        JOptionPane.INFORMATION_MESSAGE);

                MainCardLayout.show(MainPanel, "LogIn");
            } else {
                JOptionPane.showMessageDialog(ForgotPasswordElements,
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
        returnButton.addActionListener(e -> MainCardLayout.show(MainPanel, "LogIn"));
        rectangleForgot.add(returnButton);

        return ForgotPasswordElements;
    }

    /*
     * public JPanel CreateClientInterface() {
     * 
     * CardLayout layout = new CardLayout();
     * 
     * JPanel HomePanel = new JPanel(layout);
     * HomePanel.setLayout(null);
     * HomePanel.setBounds(0, 0, 1200, 750);
     * HomePanel.setOpaque(true);
     * HomePanel.setBackground(new Color(0x121213));
     * 
     * //Left panel ----------------------------------------------------------------
     * RoundedPanel LeftPanel = new RoundedPanel(35);
     * LeftPanel.setBounds(30,30, 150, 650);
     * LeftPanel.setBackground(new Color(0x212121));
     * LeftPanel.setLayout(null);
     * 
     * HomePanel.add(LeftPanel);
     * 
     * JButton HomeButton = new JButton();
     * HomeButton.setBounds(20, 100, 30, 30);
     * 
     * ImageIcon originalIcon6 = new ImageIcon(
     * "Images\\home (1).png");
     * Image originalImage6 = originalIcon6.getImage();
     * Image scaledImage6 = originalImage6.getScaledInstance(20, 20,
     * Image.SCALE_SMOOTH);
     * ImageIcon scaledIcon6 = new ImageIcon(scaledImage6);
     * 
     * HomeButton.setIcon(scaledIcon6);
     * HomeButton.setBackground(new Color(0xCBCBCB));
     * HomeButton.setForeground(new Color(0x191D22));
     * HomeButton.setFont(new Font("Inter", Font.BOLD, 15));
     * HomeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
     * HomeButton.setUI(new RoundButtonUI(new Color(0x000000)));
     * 
     * TransparentPanel HoverHome = new TransparentPanel(0.5f);
     * HoverHome.setBounds(0, 105, 7, 20);
     * HoverHome.setVisible(false);
     * HoverHome.setBackground(new Color(0x878787));
     * 
     * LeftPanel.add(HoverHome);
     * 
     * JButton HomeButtontext = new JButton("Home");
     * HomeButtontext.setBounds(40, 100, 100, 30);
     * HomeButtontext.setContentAreaFilled(false);
     * HomeButtontext.setBorderPainted(false);
     * HomeButtontext.setForeground(new Color(0xFFFFFF));
     * HomeButtontext.setFont(new Font("Inter", Font.BOLD, 15));
     * HomeButtontext.setCursor(new Cursor(Cursor.HAND_CURSOR));
     * 
     * HomeButton.addMouseListener(new java.awt.event.MouseAdapter() {
     * public void mouseEntered(java.awt.event.MouseEvent evt) {
     * HomeButtontext.setForeground(new Color(0x878787));
     * HomeButton.setBackground(new Color(0x878787));
     * HoverHome.setVisible(true);
     * 
     * }
     * 
     * public void mouseExited(java.awt.event.MouseEvent evt) {
     * HomeButtontext.setForeground(new Color(0xFFFFFF));
     * HomeButton.setBackground(new Color(0xCBCBCB));
     * HoverHome.setVisible(false);
     * }
     * });
     * 
     * LeftPanel.add(HomeButton);
     * 
     * HomeButtontext.addMouseListener(new java.awt.event.MouseAdapter() {
     * public void mouseEntered(java.awt.event.MouseEvent evt) {
     * HomeButtontext.setForeground(new Color(0x878787));
     * HomeButton.setBackground(new Color(0x878787));
     * HoverHome.setVisible(true);
     * 
     * }
     * 
     * public void mouseExited(java.awt.event.MouseEvent evt) {
     * HomeButtontext.setForeground(new Color(0xFFFFFF));
     * HomeButton.setBackground(new Color(0xCBCBCB));
     * HoverHome.setVisible(false);
     * }
     * });
     * 
     * LeftPanel.add(HomeButtontext);
     * 
     * 
     * 
     * JButton AllButton = new JButton();
     * AllButton.setBounds(20, 150, 30, 30);
     * 
     * ImageIcon originalIcon = new ImageIcon(
     * "Images\\all.png");
     * Image originalImage = originalIcon.getImage();
     * Image scaledImage = originalImage.getScaledInstance(20, 20,
     * Image.SCALE_SMOOTH);
     * ImageIcon scaledIcon = new ImageIcon(scaledImage);
     * 
     * AllButton.setIcon(scaledIcon);
     * AllButton.setBackground(new Color(0xCBCBCB));
     * AllButton.setForeground(new Color(0x191D22));
     * AllButton.setFont(new Font("Inter", Font.BOLD, 15));
     * AllButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
     * AllButton.setUI(new RoundButtonUI(new Color(0x000000)));
     * AllButton.setContentAreaFilled(false); // Make the button background
     * transparent
     * AllButton.setBorderPainted(false); // Remove the button border
     * AllButton.setFocusPainted(false); // Remove the focus border
     * 
     * TransparentPanel HoverAll = new TransparentPanel(0.5f);
     * HoverAll.setBounds(0, 155, 7, 20);
     * HoverAll.setVisible(false);
     * HoverAll.setBackground(new Color(0x878787));
     * 
     * LeftPanel.add(HoverAll);
     * 
     * JButton AllMoviestext = new JButton("All movies");
     * AllMoviestext.setBounds(40, 150, 125, 30);
     * AllMoviestext.setContentAreaFilled(false);
     * AllMoviestext.setBorderPainted(false);
     * AllMoviestext.setForeground(new Color(0xFFFFFF));
     * AllMoviestext.setFont(new Font("Inter", Font.BOLD, 15));
     * AllMoviestext.setCursor(new Cursor(Cursor.HAND_CURSOR));
     * 
     * 
     * AllButton.addMouseListener(new java.awt.event.MouseAdapter() {
     * public void mouseEntered(java.awt.event.MouseEvent evt) {
     * AllMoviestext.setForeground(new Color(0x878787));
     * AllButton.setBackground(new Color(0x878787));
     * HoverAll.setVisible(true);
     * 
     * }
     * 
     * public void mouseExited(java.awt.event.MouseEvent evt) {
     * AllMoviestext.setForeground(new Color(0xFFFFFF));
     * AllButton.setBackground(new Color(0xCBCBCB));
     * HoverAll.setVisible(false);
     * }
     * });
     * 
     * LeftPanel.add(AllButton);
     * 
     * AllMoviestext.addMouseListener(new java.awt.event.MouseAdapter() {
     * public void mouseEntered(java.awt.event.MouseEvent evt) {
     * AllMoviestext.setForeground(new Color(0x878787));
     * AllButton.setBackground(new Color(0x878787));
     * HoverAll.setVisible(true);
     * 
     * }
     * 
     * public void mouseExited(java.awt.event.MouseEvent evt) {
     * AllMoviestext.setForeground(new Color(0xFFFFFF));
     * AllButton.setBackground(new Color(0xCBCBCB));
     * HoverAll.setVisible(false);
     * }
     * });
     * 
     * LeftPanel.add(AllMoviestext);
     * 
     * 
     * 
     * JButton FavoriesButton = new JButton();
     * FavoriesButton.setBounds(20, 280, 30, 30);
     * 
     * ImageIcon originalIcon2 = new ImageIcon(
     * "Images\\ticket.png");
     * Image originalImage2 = originalIcon2.getImage();
     * Image scaledImage2 = originalImage2.getScaledInstance(20, 20,
     * Image.SCALE_SMOOTH);
     * ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
     * 
     * FavoriesButton.setIcon(scaledIcon2);
     * FavoriesButton.setBackground(new Color(0xCBCBCB));
     * FavoriesButton.setForeground(new Color(0x191D22));
     * FavoriesButton.setFont(new Font("Inter", Font.BOLD, 15));
     * FavoriesButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
     * FavoriesButton.setUI(new RoundButtonUI(new Color(0x000000)));
     * 
     * TransparentPanel HoverTicket = new TransparentPanel(0.5f);
     * HoverTicket.setBounds(0, 285, 7, 20);
     * HoverTicket.setVisible(false);
     * HoverTicket.setBackground(new Color(0x878787));
     * 
     * LeftPanel.add(HoverTicket);
     * 
     * JButton FavoriesText = new JButton("favories");
     * FavoriesText.setBounds(40, 280, 125, 30);
     * FavoriesText.setContentAreaFilled(false);
     * FavoriesText.setBorderPainted(false);
     * FavoriesText.setForeground(new Color(0xFFFFFF));
     * FavoriesText.setFont(new Font("Inter", Font.BOLD, 15));
     * FavoriesText.setCursor(new Cursor(Cursor.HAND_CURSOR));
     * 
     * FavoriesButton.addMouseListener(new java.awt.event.MouseAdapter() {
     * public void mouseEntered(java.awt.event.MouseEvent evt) {
     * FavoriesButton.setBackground(new Color(0x878787));
     * FavoriesText.setForeground(new Color(0x878787));
     * HoverTicket.setVisible(true);
     * 
     * }
     * 
     * public void mouseExited(java.awt.event.MouseEvent evt) {
     * FavoriesButton.setBackground(new Color(0xCBCBCB));
     * FavoriesText.setForeground(new Color(0xCBCBCB));
     * HoverTicket.setVisible(false);
     * }
     * });
     * 
     * LeftPanel.add(FavoriesButton);
     * 
     * FavoriesText.addMouseListener(new java.awt.event.MouseAdapter() {
     * public void mouseEntered(java.awt.event.MouseEvent evt) {
     * FavoriesButton.setBackground(new Color(0x878787));
     * FavoriesText.setForeground(new Color(0x878787));
     * HoverTicket.setVisible(true);
     * 
     * }
     * 
     * public void mouseExited(java.awt.event.MouseEvent evt) {
     * FavoriesButton.setBackground(new Color(0xCBCBCB));
     * FavoriesText.setForeground(new Color(0xCBCBCB));
     * HoverTicket.setVisible(false);
     * }
     * });
     * 
     * LeftPanel.add(FavoriesText);
     * 
     * 
     * 
     * JButton BalanceButton = new JButton();
     * BalanceButton.setBounds(20, 330, 30, 30);
     * 
     * ImageIcon originalIcon3 = new ImageIcon(
     * "Images\\dollar.png");
     * Image originalImage3 = originalIcon3.getImage();
     * Image scaledImage3 = originalImage3.getScaledInstance(20, 20,
     * Image.SCALE_SMOOTH);
     * ImageIcon scaledIcon3 = new ImageIcon(scaledImage3);
     * 
     * BalanceButton.setIcon(scaledIcon3);
     * BalanceButton.setBackground(new Color(0xAD3000));
     * BalanceButton.setForeground(new Color(0x191D22));
     * BalanceButton.setFont(new Font("Inter", Font.BOLD, 14));
     * BalanceButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
     * BalanceButton.setUI(new RoundButtonUI(new Color(0x000000)));
     * 
     * TransparentPanel HoverBalance = new TransparentPanel(0.5f);
     * HoverBalance.setBounds(0, 335, 7, 20);
     * HoverBalance.setVisible(false);
     * HoverBalance.setBackground(new Color(0xFF0000));
     * 
     * LeftPanel.add(HoverBalance);
     * 
     * JButton BalanceText = new JButton("my balance");
     * BalanceText.setBounds(40, 330, 125, 30);
     * BalanceText.setContentAreaFilled(false);
     * BalanceText.setBorderPainted(false);
     * BalanceText.setForeground(new Color(0xAD3000));
     * BalanceText.setFont(new Font("Inter", Font.BOLD, 15));
     * BalanceText.setCursor(new Cursor(Cursor.HAND_CURSOR));
     * 
     * BalanceButton.addMouseListener(new java.awt.event.MouseAdapter() {
     * public void mouseEntered(java.awt.event.MouseEvent evt) {
     * BalanceButton.setBackground(new Color(0x550000));
     * BalanceText.setForeground(new Color(0x550000));
     * HoverBalance.setVisible(true);
     * 
     * }
     * 
     * public void mouseExited(java.awt.event.MouseEvent evt) {
     * BalanceButton.setBackground(new Color(0xAD3000));
     * BalanceText.setForeground(new Color(0xAD3000));
     * HoverBalance.setVisible(false);
     * }
     * });
     * 
     * LeftPanel.add(BalanceButton);
     * 
     * BalanceText.addMouseListener(new java.awt.event.MouseAdapter() {
     * public void mouseEntered(java.awt.event.MouseEvent evt) {
     * BalanceButton.setBackground(new Color(0x550000));
     * BalanceText.setForeground(new Color(0x550000));
     * HoverBalance.setVisible(true);
     * 
     * }
     * 
     * public void mouseExited(java.awt.event.MouseEvent evt) {
     * BalanceButton.setBackground(new Color(0xAD3000));
     * BalanceText.setForeground(new Color(0xAD3000));
     * HoverBalance.setVisible(false);
     * }
     * });
     * 
     * LeftPanel.add(BalanceText);
     * 
     * 
     * 
     * JButton FilterButton = new JButton();
     * FilterButton.setBounds(20, 430, 30, 30);
     * 
     * ImageIcon originalIcon4 = new ImageIcon(
     * "Images\\filter.png");
     * Image originalImage4 = originalIcon4.getImage();
     * Image scaledImage4 = originalImage4.getScaledInstance(20, 20,
     * Image.SCALE_SMOOTH);
     * ImageIcon scaledIcon4 = new ImageIcon(scaledImage4);
     * 
     * FilterButton.setIcon(scaledIcon4);
     * FilterButton.setBackground(new Color(0xA96E00));
     * FilterButton.setForeground(new Color(0x191D22));
     * FilterButton.setFont(new Font("Inter", Font.BOLD, 15));
     * FilterButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
     * FilterButton.setUI(new RoundButtonUI(new Color(0x000000)));
     * FilterButton.setVisible(false);
     * 
     * LeftPanel.add(FilterButton);
     * 
     * TransparentPanel HoverFilter = new TransparentPanel(0.5f);
     * HoverFilter.setBounds(0, 435, 7, 20);
     * HoverFilter.setVisible(false);
     * HoverFilter.setBackground(new Color(0xFFFF00));
     * 
     * LeftPanel.add(HoverFilter);
     * 
     * JButton FilterText = new JButton("filter");
     * FilterText.setBounds(40, 430, 125, 30);
     * FilterText.setContentAreaFilled(false);
     * FilterText.setBorderPainted(false);
     * FilterText.setForeground(new Color(0xA96E00));
     * FilterText.setFont(new Font("Inter", Font.BOLD, 15));
     * FilterText.setCursor(new Cursor(Cursor.HAND_CURSOR));
     * FilterText.setVisible(false);
     * 
     * FilterText.addMouseListener(new java.awt.event.MouseAdapter() {
     * public void mouseEntered(java.awt.event.MouseEvent evt) {
     * FilterButton.setBackground(new Color(0x652B00));
     * FilterText.setForeground(new Color(0x652B00));
     * HoverFilter.setVisible(true);
     * 
     * }
     * 
     * public void mouseExited(java.awt.event.MouseEvent evt) {
     * FilterButton.setBackground(new Color(0xA96E00));
     * FilterText.setForeground(new Color(0xA96E00));
     * HoverFilter.setVisible(false);
     * }
     * });
     * 
     * 
     * FilterButton.addMouseListener(new java.awt.event.MouseAdapter() {
     * public void mouseEntered(java.awt.event.MouseEvent evt) {
     * FilterButton.setBackground(new Color(0x652B00));
     * FilterText.setForeground(new Color(0x652B00));
     * HoverFilter.setVisible(true);
     * 
     * }
     * 
     * public void mouseExited(java.awt.event.MouseEvent evt) {
     * FilterButton.setBackground(new Color(0xA96E00));
     * FilterText.setForeground(new Color(0xA96E00));
     * HoverFilter.setVisible(false);
     * }
     * });
     * 
     * LeftPanel.add(FilterText);
     * 
     * 
     * 
     * JButton ChangeTheme = new JButton();
     * ChangeTheme.setBounds(20, 380, 30, 30);
     * ChangeTheme.setBackground(new Color(0xA96E00));
     * ChangeTheme.setForeground(new Color(0x191D22));
     * ChangeTheme.setFont(new Font("Inter", Font.BOLD, 15));
     * ChangeTheme.setCursor(new Cursor(Cursor.HAND_CURSOR));
     * ChangeTheme.setUI(new RoundButtonUI(new Color(0x000000)));
     * 
     * TransparentPanel HoverTheme = new TransparentPanel(0.5f);
     * HoverTheme.setBounds(0, 385, 7, 20);
     * HoverTheme.setVisible(false);
     * HoverTheme.setBackground(new Color(0xA96E00));
     * 
     * LeftPanel.add(HoverTheme);
     * 
     * JButton ChangeThemeText = new JButton("?");
     * ChangeThemeText.setBounds(40, 380, 125, 30);
     * ChangeThemeText.setContentAreaFilled(false);
     * ChangeThemeText.setBorderPainted(false);
     * ChangeThemeText.setForeground(new Color(0xA96E00));
     * ChangeThemeText.setFont(new Font("Inter", Font.BOLD, 15));
     * ChangeThemeText.setCursor(new Cursor(Cursor.HAND_CURSOR));
     * 
     * ChangeTheme.addMouseListener(new java.awt.event.MouseAdapter() {
     * public void mouseEntered(java.awt.event.MouseEvent evt) {
     * ChangeTheme.setBackground(new Color(0x652B00));
     * ChangeThemeText.setForeground(new Color(0x652B00));
     * HoverTheme.setVisible(true);
     * 
     * }
     * 
     * public void mouseExited(java.awt.event.MouseEvent evt) {
     * ChangeTheme.setBackground(new Color(0xA96E00));
     * ChangeThemeText.setForeground(new Color(0xA96E00));
     * HoverTheme.setVisible(false);
     * }
     * });
     * 
     * LeftPanel.add(ChangeTheme);
     * 
     * ChangeThemeText.addMouseListener(new java.awt.event.MouseAdapter() {
     * public void mouseEntered(java.awt.event.MouseEvent evt) {
     * ChangeTheme.setBackground(new Color(0x652B00));
     * ChangeThemeText.setForeground(new Color(0x652B00));
     * HoverTheme.setVisible(true);
     * 
     * }
     * 
     * public void mouseExited(java.awt.event.MouseEvent evt) {
     * ChangeTheme.setBackground(new Color(0xA96E00));
     * ChangeThemeText.setForeground(new Color(0xA96E00));
     * HoverTheme.setVisible(false);
     * }
     * });
     * 
     * LeftPanel.add(ChangeThemeText);
     * 
     * JPanel StraightLine = new JPanel();
     * StraightLine.setBounds(220, 80, 930, 5);
     * StraightLine.setBackground(new Color(0x313131));
     * 
     * HomePanel.add(StraightLine);
     * 
     * RoundedPanel SearchBar = new RoundedPanel(35);
     * SearchBar.setBounds(250, 30, 800, 30);
     * SearchBar.setBackground(new Color(0x212121));
     * SearchBar.setLayout(null);
     * 
     * HomePanel.add(SearchBar);
     * 
     * JTextField SearchField = new JTextField();
     * SearchField.setBounds(10, 2, 800, 25);
     * SearchField.setFont(new Font("Inter", Font.BOLD, 15));
     * SearchField.setForeground(Color.white);
     * SearchField.setCaretColor(Color.white);
     * SearchField.setOpaque(false);
     * SearchField.setBorder(null);
     * 
     * TextfieldBehave(SearchField, "Search for a movie");
     * 
     * SearchBar.add(SearchField);
     * 
     * JButton Filter = new JButton();
     * Filter.setBounds(200, 32, 30, 30);
     * Filter.setFocusPainted(false);
     * Filter.setBorder(null);
     * Filter.setBackground(new Color(0x212121));
     * Filter.setUI(new RoundButtonUI(Color.black));
     * Filter.addActionListener(e -> {
     * // Open movie filter dialog
     * });
     * HomePanel.add(Filter);
     * 
     * JButton History = new JButton();
     * History.setBounds(1070, 29, 30, 30);
     * History.setFocusPainted(false);
     * History.setBorder(null);
     * History.setBackground(new Color(0x212121));
     * History.setUI(new RoundButtonUI(Color.black));
     * History.addActionListener(e -> {
     * // Open movie History dialog
     * });
     * HomePanel.add(History);
     * 
     * JButton Account = new JButton();
     * Account.setBounds(1110, 29, 50, 30);
     * Account.setFocusPainted(false);
     * Account.setBorder(null);
     * Account.setBackground(new Color(0x515151));
     * Account.setUI(new RoundButtonUI(Color.black));
     * Account.addActionListener(e -> {
     * // Open movie Account dialog
     * MainCardLayout.show(MainPanel, "Account");
     * });
     * HomePanel.add(Account);
     * 
     * //content
     * panel---------------------------------------------------------------
     * JPanel ContentPanel = CreateContentPanel();
     * 
     * JScrollPane scrollPane = new JScrollPane(ContentPanel);
     * scrollPane.setBounds(227, 85, 919, 750);
     * scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.
     * VERTICAL_SCROLLBAR_NEVER);
     * scrollPane.setOpaque(false);
     * scrollPane.setBorder(null);
     * 
     * ContentPanel.addMouseWheelListener(e -> {
     * JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();// had
     * scroll par rapport l y
     * int notches = e.getWheelRotation();
     * int currentValue = verticalScrollBar.getValue();
     * int scrollAmount = 30; // Adjust scroll speed
     * verticalScrollBar.setValue(currentValue + (notches * scrollAmount));
     * });
     * 
     * HomePanel.add(scrollPane, "home");
     * scrollPane.setVisible(true);
     * 
     * //Movie panel---------------------------------------------------------------
     * JPanel MoviePanel = CreateMoviePanel();
     * 
     * JScrollPane scrollPane2 = new JScrollPane(MoviePanel);
     * scrollPane2.setBounds(179, 85, 1009, 750);
     * scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.
     * VERTICAL_SCROLLBAR_NEVER);
     * scrollPane2.setOpaque(false);
     * scrollPane2.setBorder(null);
     * 
     * MoviePanel.addMouseWheelListener(e -> {
     * JScrollBar verticalScrollBar = scrollPane2.getVerticalScrollBar();// had
     * scroll par rapport l y
     * int notches = e.getWheelRotation();
     * int currentValue = verticalScrollBar.getValue();
     * int scrollAmount = 30; // Adjust scroll speed
     * verticalScrollBar.setValue(currentValue + (notches * scrollAmount));
     * });
     * 
     * HomePanel.add(scrollPane2, "movies");
     * scrollPane2.setVisible(false);
     * 
     * //balance Panel
     * ----------------------------------------------------------------
     * 
     * 
     * 
     * //Ticket / history panel
     * ----------------------------------------------------------------
     * 
     * 
     * HomePanel.setComponentZOrder(scrollPane, 1);
     * HomePanel.setComponentZOrder(scrollPane2, 1);
     * HomePanel.setComponentZOrder(LeftPanel, 0);
     * HomePanel.setComponentZOrder(StraightLine, 0);
     * HomePanel.setComponentZOrder(SearchBar, 0);
     * HomePanel.setComponentZOrder(Filter, 0);
     * HomePanel.setComponentZOrder(History, 0);
     * HomePanel.setComponentZOrder(Account, 0);
     * 
     * 
     * 
     * return HomePanel;
     * }
     * 
     * public JPanel CreateContentPanel() {
     * JPanel ContentPanel = new JPanel();
     * ContentPanel.setLayout(null);
     * ContentPanel.setOpaque(true);
     * ContentPanel.setBackground(new Color(0x121213));
     * ContentPanel.setPreferredSize(new Dimension(1009, 2750));
     * 
     * // Most popular movie
     * RoundedPanel MostPopularPanel = new RoundedPanel(35);
     * MostPopularPanel.setBounds(0, 20, 940, 400);
     * MostPopularPanel.setBackground(new Color(0x212121));
     * MostPopularPanel.setLayout(null);
     * 
     * ImageIcon imageIcon = resizedIcon("Images\\spiderman_no_way_home.png", 940,
     * 400);
     * JLabel imageLabel = new JLabel(imageIcon);
     * imageLabel.setBounds(0, 0, 940, 400);
     * 
     * MostPopularPanel.add(imageLabel);
     * 
     * TransparentPanel backgroundPanel = new TransparentPanel(0.25f);
     * backgroundPanel.setBounds(0, 0, 940, 400);
     * backgroundPanel.setBackground(new Color(0x000000));
     * backgroundPanel.setLayout(null);
     * 
     * MostPopularPanel.add(backgroundPanel);
     * 
     * JLabel MostPopularLabel = new JLabel("Most Popular Movie");
     * MostPopularLabel.setBounds(25, 20, 200, 30);
     * MostPopularLabel.setFont(new Font("Inter", Font.BOLD, 20));
     * MostPopularLabel.setForeground(Color.white);
     * 
     * MostPopularPanel.add(MostPopularLabel);
     * 
     * JButton BookNow = new JButton("Book Now");
     * BookNow.setBounds(25, 350, 125, 30);
     * BookNow.setFont(new Font("Inter", Font.BOLD, 12));
     * BookNow.setForeground(Color.black);
     * BookNow.setBackground(Color.white);
     * BookNow.setFocusPainted(false);
     * BookNow.setUI(new RoundButtonUI(Color.black));
     * BookNow.addActionListener(e -> {
     * // Open Booking dialog
     * });
     * 
     * MostPopularPanel.add(BookNow);
     * 
     * JButton MoreInfo = new JButton("More Info :");
     * MoreInfo.setBounds(175, 350, 125, 30);
     * MoreInfo.setFont(new Font("Inter", Font.BOLD, 15));
     * MoreInfo.setForeground(Color.white);
     * MoreInfo.setBackground(Color.black);
     * MoreInfo.setFocusPainted(false);
     * MoreInfo.setUI(new RoundButtonUI(Color.black));
     * MoreInfo.addActionListener(e -> {
     * // Open Booking dialog
     * });
     * 
     * MostPopularPanel.add(MoreInfo);
     * 
     * MostPopularPanel.setComponentZOrder(imageLabel, 2);
     * MostPopularPanel.setComponentZOrder(backgroundPanel, 1);
     * MostPopularPanel.setComponentZOrder(MostPopularLabel, 0);
     * MostPopularPanel.setComponentZOrder(BookNow, 0);
     * MostPopularPanel.setComponentZOrder(MoreInfo, 0);
     * 
     * 
     * ContentPanel.add(MostPopularPanel);
     * 
     * // other popular movies
     * JLabel OtherPopularLabel = new JLabel("Other Popular Movies");
     * OtherPopularLabel.setBounds(0, 450, 600, 30);
     * OtherPopularLabel.setFont(new Font("Inter", Font.BOLD, 17));
     * OtherPopularLabel.setForeground(Color.white);
     * 
     * ContentPanel.add(OtherPopularLabel);
     * 
     * JPanel OtherPopularPanel = new JPanel();
     * OtherPopularPanel.setBounds(0, 500, 920, 300);
     * OtherPopularPanel.setBackground(new Color(0x121213));
     * OtherPopularPanel.setLayout(new GridLayout(1, 3, 100, 20));
     * OtherPopularPanel.setBorder(null);
     * OtherPopularPanel.setOpaque(false);
     * 
     * 
     * for (int i = 0; i < 3; i++) {
     * RoundedPanel moviePanel = new RoundedPanel(15);
     * moviePanel.setBounds(0, 0, 280, 360);
     * moviePanel.setLayout(null);
     * moviePanel.setBackground(new Color(0x212121));
     * 
     * // Hayla hadi :-)
     * moviePanel.addMouseListener(new java.awt.event.MouseAdapter() {
     * public void mouseEntered(java.awt.event.MouseEvent evt) {
     * moviePanel.setBorder(BorderFactory.createLineBorder(new Color(0xFF6700),
     * 3));// ta3 ki t intiracti m3a l panel
     * }
     * 
     * public void mouseExited(java.awt.event.MouseEvent evt) {
     * moviePanel.setBorder(null);
     * }
     * 
     * public void mouseClicked(java.awt.event.MouseEvent evt) {
     * 
     * JOptionPane.showMessageDialog(null, "Opening film details...");
     * }
     * });
     * 
     * OtherPopularPanel.add(moviePanel);
     * }
     * 
     * ContentPanel.add(OtherPopularPanel);
     * 
     * // best rated movie
     * RoundedPanel BestRatedPanel = new RoundedPanel(35);
     * BestRatedPanel.setBounds(0, 850, 940, 400);
     * BestRatedPanel.setBackground(new Color(0x212121));
     * BestRatedPanel.setLayout(null);
     * 
     * ImageIcon imageIcon2 = resizedIcon("Images\\Invincible-Title-Card.jpg", 1000,
     * 600);
     * JLabel imageLabel2 = new JLabel(imageIcon2);
     * imageLabel2.setBounds(0, 0, 940, 400);
     * 
     * BestRatedPanel.add(imageLabel2);
     * 
     * TransparentPanel backgroundPanel2 = new TransparentPanel(0.25f);
     * backgroundPanel2.setBounds(0, 0, 940, 400);
     * backgroundPanel2.setBackground(new Color(0x000000));
     * backgroundPanel2.setLayout(null);
     * 
     * BestRatedPanel.add(backgroundPanel2);
     * 
     * JLabel BestRatedLabel = new JLabel("Best rated Movie");
     * BestRatedLabel.setBounds(25, 20, 200, 30);
     * BestRatedLabel.setFont(new Font("Inter", Font.BOLD, 20));
     * BestRatedLabel.setForeground(Color.white);
     * 
     * BestRatedPanel.add(BestRatedLabel);
     * 
     * JButton BookNow2 = new JButton("Book Now");
     * BookNow2.setBounds(25, 350, 125, 30);
     * BookNow2.setFont(new Font("Inter", Font.BOLD, 12));
     * BookNow2.setForeground(Color.black);
     * BookNow2.setBackground(Color.white);
     * BookNow2.setFocusPainted(false);
     * BookNow2.setUI(new RoundButtonUI(Color.black));
     * BookNow2.addActionListener(e -> {
     * // Open Booking dialog
     * });
     * 
     * BestRatedPanel.add(BookNow2);
     * 
     * JButton MoreInfo2 = new JButton("More Info :");
     * MoreInfo2.setBounds(175, 350, 125, 30);
     * MoreInfo2.setFont(new Font("Inter", Font.BOLD, 15));
     * MoreInfo2.setForeground(Color.white);
     * MoreInfo2.setBackground(Color.black);
     * MoreInfo2.setFocusPainted(false);
     * MoreInfo2.setUI(new RoundButtonUI(Color.black));
     * MoreInfo2.addActionListener(e -> {
     * // Open Booking dialog
     * });
     * 
     * BestRatedPanel.add(MoreInfo2);
     * 
     * BestRatedPanel.setComponentZOrder(imageLabel2, 2);
     * BestRatedPanel.setComponentZOrder(backgroundPanel2, 1);
     * BestRatedPanel.setComponentZOrder(BestRatedLabel, 0);
     * BestRatedPanel.setComponentZOrder(BookNow2, 0);
     * BestRatedPanel.setComponentZOrder(MoreInfo2, 0);
     * 
     * 
     * ContentPanel.add(BestRatedPanel);
     * 
     * // movies you may like
     * JLabel YouMayLikeLabel = new JLabel("Movies You May Like");
     * YouMayLikeLabel.setBounds(0, 1300, 600, 30);
     * YouMayLikeLabel.setFont(new Font("Inter", Font.BOLD, 17));
     * YouMayLikeLabel.setForeground(Color.white);
     * 
     * ContentPanel.add(YouMayLikeLabel);
     * 
     * JPanel YouMayLikePanel = new JPanel();
     * YouMayLikePanel.setBounds(0, 1350, 920, 600);
     * YouMayLikePanel.setBackground(new Color(0x121213));
     * YouMayLikePanel.setLayout(new GridLayout(0, 4, 25, 25));
     * YouMayLikePanel.setBorder(null);
     * YouMayLikePanel.setOpaque(false);
     * 
     * for (int i = 0; i < 8; i++) {
     * RoundedPanel moviePanel = new RoundedPanel(15);
     * moviePanel.setBounds(0, 0, 200, 300);
     * moviePanel.setLayout(null);
     * moviePanel.setBackground(new Color(0x212121));
     * 
     * // Hayla hadi :-)
     * moviePanel.addMouseListener(new java.awt.event.MouseAdapter() {
     * public void mouseEntered(java.awt.event.MouseEvent evt) {
     * moviePanel.setBorder(BorderFactory.createLineBorder(new Color(0xFF6700), 3));
     * }
     * 
     * public void mouseExited(java.awt.event.MouseEvent evt) {
     * moviePanel.setBorder(null);
     * }
     * 
     * public void mouseClicked(java.awt.event.MouseEvent evt) {
     * JOptionPane.showMessageDialog(null, "Opening film details...");
     * }
     * });
     * 
     * YouMayLikePanel.add(moviePanel);
     * }
     * 
     * ContentPanel.add(YouMayLikePanel);
     * 
     * //Promotions
     * JLabel PromotionsLabel = new JLabel("Promotions");
     * PromotionsLabel.setBounds(0, 2000, 600, 30);
     * PromotionsLabel.setFont(new Font("Inter", Font.BOLD, 17));
     * PromotionsLabel.setForeground(Color.white);
     * 
     * ContentPanel.add(PromotionsLabel);
     * 
     * JPanel PromotionsPanel = new JPanel();
     * PromotionsPanel.setBounds(0, 2050, 920, 400);
     * PromotionsPanel.setBackground(new Color(0x121213));
     * PromotionsPanel.setLayout(new GridLayout(1, 2, 35, 25));
     * PromotionsPanel.setBorder(null);
     * PromotionsPanel.setOpaque(false);
     * 
     * for (int i = 0; i < 2; i++) {
     * RoundedPanel moviePanel = new RoundedPanel(15);
     * moviePanel.setBounds(0, 0, 200, 300);
     * moviePanel.setLayout(null);
     * moviePanel.setBackground(new Color(0x212121));
     * 
     * // Hayla hadi :-)
     * moviePanel.addMouseListener(new java.awt.event.MouseAdapter() {
     * public void mouseEntered(java.awt.event.MouseEvent evt) {
     * moviePanel.setBorder(BorderFactory.createLineBorder(new Color(0xFF6700), 3));
     * }
     * 
     * public void mouseExited(java.awt.event.MouseEvent evt) {
     * moviePanel.setBorder(null);
     * }
     * 
     * public void mouseClicked(java.awt.event.MouseEvent evt) {
     * JOptionPane.showMessageDialog(null, "Opening film details...");
     * }
     * });
     * 
     * PromotionsPanel.add(moviePanel);
     * }
     * 
     * ContentPanel.add(PromotionsPanel);
     * 
     * 
     * return ContentPanel;
     * }
     * 
     * public JPanel CreateMoviePanel(){
     * JPanel MoviePanel = new JPanel();
     * MoviePanel.setLayout(null);
     * MoviePanel.setOpaque(true);
     * MoviePanel.setBackground(new Color(0x121213));
     * MoviePanel.setPreferredSize(new Dimension(1009, 2250));
     * 
     * // All movies
     * JLabel AllMoviesLabel = new JLabel("Other Popular Movies");
     * AllMoviesLabel.setBounds(25, 20, 600, 30);
     * AllMoviesLabel.setFont(new Font("Inter", Font.BOLD, 17));
     * AllMoviesLabel.setForeground(Color.white);
     * 
     * MoviePanel.add(AllMoviesLabel);
     * 
     * JPanel AllMoviesPanel = new JPanel();
     * AllMoviesPanel.setBounds(25, 70, 950, MovieManager.movies.size() * 50 +
     * MovieManager.movies.size() * 25);
     * AllMoviesPanel.setBackground(new Color(0x121213));
     * AllMoviesPanel.setLayout(new GridLayout(0, 4, 40, 25));
     * 
     * for (int i = 0; i < MovieManager.movies.size(); i++) {
     * RoundedPanel moviePanel = new RoundedPanel(15);
     * moviePanel.setBounds(0, 0, 200, 300);
     * moviePanel.setLayout(null);
     * moviePanel.setBackground(new Color(0x212121));
     * 
     * // Hayla hadi :-)
     * moviePanel.addMouseListener(new java.awt.event.MouseAdapter() {
     * public void mouseEntered(java.awt.event.MouseEvent evt) {
     * moviePanel.setBorder(BorderFactory.createLineBorder(new Color(0xFF6700), 3));
     * }
     * 
     * public void mouseExited(java.awt.event.MouseEvent evt) {
     * moviePanel.setBorder(null);
     * }
     * 
     * public void mouseClicked(java.awt.event.MouseEvent evt) {
     * JOptionPane.showMessageDialog(null, "Opening film details...");
     * }
     * });
     * 
     * AllMoviesPanel.add(moviePanel);
     * }
     * 
     * MoviePanel.add(AllMoviesPanel);
     * 
     * return MoviePanel;
     * }
     */

    public JPanel CreateAdminInterface() {
        JPanel AdminElements = new JPanel();

        return AdminElements;
    }

    public JPanel CreateAccountPanel() {
        JPanel AccountPanel = new JPanel();
        AccountPanel.setOpaque(false);
        AccountPanel.setLayout(null);
        AccountPanel.setPreferredSize(new Dimension(1200, 3500));

        JPanel OptionPanel = new JPanel();
        OptionPanel.setBounds(0, 0, 350, 750);
        OptionPanel.setLayout(null);
        OptionPanel.setBackground(new Color(0x0A0D10));

        AccountPanel.add(OptionPanel);

        JLabel AccountTitle = new JLabel("Account");
        AccountTitle.setBounds(50, 100, 250, 50);
        AccountTitle.setFont(new Font("Segoe UI", Font.BOLD, 35));
        AccountTitle.setForeground(Color.white);

        OptionPanel.add(AccountTitle);

        JLabel AccountTitle2 = new JLabel("Management");
        AccountTitle2.setBounds(50, 150, 350, 50);
        AccountTitle2.setFont(new Font("Segoe UI", Font.BOLD, 35));
        AccountTitle2.setForeground(Color.white);

        OptionPanel.add(AccountTitle2);

        JButton IdSettings = new JButton("Account ID");
        IdSettings.setBounds(25, 275, 250, 30);
        IdSettings.setFont(new Font("Segoe UI", Font.BOLD, 17));
        IdSettings.setForeground(new Color(0xCBCBCB));
        IdSettings.setContentAreaFilled(false);
        IdSettings.setBorderPainted(false);
        IdSettings.setCursor(new Cursor(Cursor.HAND_CURSOR));
        IdSettings.addActionListener(e -> {

        });
        JButton IdButton = new JButton();
        IdButton.setBounds(50, 280, 25, 25);
        IdButton.setFont(new Font("Segoe UI", Font.BOLD, 17));
        IdButton.setBackground(new Color(0xCBCBCB));
        IdButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        IdButton.setUI(new RoundButtonUI(new Color(0x000000)));

        IdButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                IdSettings.setForeground(new Color(0xD42E00));
                IdButton.setBackground(new Color(0xD42E00));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                IdSettings.setForeground(new Color(0xCBCBCB));
                IdButton.setBackground(new Color(0xCBCBCB));
            }
        });

        IdSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                IdSettings.setForeground(new Color(0xD42E00));
                IdButton.setBackground(new Color(0xD42E00));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                IdSettings.setForeground(new Color(0xCBCBCB));
                IdButton.setBackground(new Color(0xCBCBCB));
            }
        });

        OptionPanel.add(IdSettings);
        OptionPanel.add(IdButton);

        JButton PersonalInfo = new JButton("Personnal information");
        PersonalInfo.setBounds(70, 320, 250, 30);
        PersonalInfo.setFont(new Font("Segoe UI", Font.BOLD, 17));
        PersonalInfo.setForeground(new Color(0xCBCBCB));
        PersonalInfo.setContentAreaFilled(false);
        PersonalInfo.setBorderPainted(false);
        PersonalInfo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        PersonalInfo.addActionListener(e -> {

        });
        JButton PersonalButton = new JButton();
        PersonalButton.setBounds(50, 325, 25, 25);
        PersonalButton.setFont(new Font("Segoe UI", Font.BOLD, 17));
        PersonalButton.setBackground(new Color(0xCBCBCB));
        PersonalButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        PersonalButton.setUI(new RoundButtonUI(new Color(0x000000)));

        PersonalButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PersonalInfo.setForeground(new Color(0xD42E00));
                PersonalButton.setBackground(new Color(0xD42E00));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                PersonalInfo.setForeground(new Color(0xCBCBCB));
                PersonalButton.setBackground(new Color(0xCBCBCB));
            }
        });

        PersonalInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PersonalInfo.setForeground(new Color(0xD42E00));
                PersonalButton.setBackground(new Color(0xD42E00));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                PersonalInfo.setForeground(new Color(0xCBCBCB));
                PersonalButton.setBackground(new Color(0xCBCBCB));
            }
        });

        OptionPanel.add(PersonalInfo);
        OptionPanel.add(PersonalButton);

        JButton PaymentInfo = new JButton("Payement information");
        PaymentInfo.setBounds(70, 365, 250, 30);
        PaymentInfo.setFont(new Font("Segoe UI", Font.BOLD, 17));
        PaymentInfo.setForeground(new Color(0xCBCBCB));
        PaymentInfo.setContentAreaFilled(false);
        PaymentInfo.setBorderPainted(false);
        PaymentInfo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        PaymentInfo.addActionListener(e -> {

        });
        JButton PayementButton = new JButton();
        PayementButton.setBounds(50, 370, 25, 25);
        PayementButton.setFont(new Font("Segoe UI", Font.BOLD, 17));
        PayementButton.setBackground(new Color(0xCBCBCB));
        PayementButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        PayementButton.setUI(new RoundButtonUI(new Color(0x000000)));

        PayementButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PaymentInfo.setForeground(new Color(0xD42E00));
                PayementButton.setBackground(new Color(0xD42E00));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                PaymentInfo.setForeground(new Color(0xCBCBCB));
                PayementButton.setBackground(new Color(0xCBCBCB));
            }
        });

        PaymentInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PaymentInfo.setForeground(new Color(0xD42E00));
                PayementButton.setBackground(new Color(0xD42E00));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                PaymentInfo.setForeground(new Color(0xCBCBCB));
                PayementButton.setBackground(new Color(0xCBCBCB));
            }
        });

        OptionPanel.add(PaymentInfo);
        OptionPanel.add(PayementButton);

        JButton SignInInfo = new JButton("Account sign in management");
        SignInInfo.setBounds(47, 410, 350, 30);
        SignInInfo.setFont(new Font("Segoe UI", Font.BOLD, 17));
        SignInInfo.setForeground(new Color(0xCBCBCB));
        SignInInfo.setContentAreaFilled(false);
        SignInInfo.setBorderPainted(false);
        SignInInfo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        SignInInfo.addActionListener(e -> {

        });
        JButton SignInButton = new JButton();
        SignInButton.setBounds(50, 415, 25, 25);
        SignInButton.setFont(new Font("Segoe UI", Font.BOLD, 17));
        SignInButton.setBackground(new Color(0xCBCBCB));
        SignInButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        SignInButton.setUI(new RoundButtonUI(new Color(0x000000)));

        SignInButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SignInInfo.setForeground(new Color(0xD42E00));
                SignInButton.setBackground(new Color(0xD42E00));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                SignInInfo.setForeground(new Color(0xCBCBCB));
                SignInButton.setBackground(new Color(0xCBCBCB));
            }
        });

        SignInInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SignInInfo.setForeground(new Color(0xD42E00));
                SignInButton.setBackground(new Color(0xD42E00));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                SignInInfo.setForeground(new Color(0xCBCBCB));
                SignInButton.setBackground(new Color(0xCBCBCB));
            }
        });

        OptionPanel.add(SignInInfo);
        OptionPanel.add(SignInButton);

        JButton Exit = new JButton("Exit");
        Exit.setBounds(-50, 650, 350, 30);
        Exit.setFont(new Font("Segoe UI", Font.BOLD, 17));
        Exit.setForeground(new Color(0xCBCBCB));
        Exit.setContentAreaFilled(false);
        Exit.setBorderPainted(false);
        Exit.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JButton ExitButton = new JButton();
        ExitButton.setBounds(50, 655, 25, 25);
        ExitButton.setFont(new Font("Segoe UI", Font.BOLD, 17));
        ExitButton.setBackground(new Color(0xCBCBCB));
        ExitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ExitButton.setUI(new RoundButtonUI(new Color(0x000000)));

        ExitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Exit.setForeground(new Color(0xD42E00));
                ExitButton.setBackground(new Color(0xD42E00));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                Exit.setForeground(new Color(0xCBCBCB));
                ExitButton.setBackground(new Color(0xCBCBCB));
            }
        });

        Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Exit.setForeground(new Color(0xD42E00));
                ExitButton.setBackground(new Color(0xD42E00));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                Exit.setForeground(new Color(0xCBCBCB));
                ExitButton.setBackground(new Color(0xCBCBCB));
            }
        });

        OptionPanel.add(Exit);
        OptionPanel.add(ExitButton);

        // elements panel --------------------------------------------------------
        JPanel ElementsPanel = new JPanel();
        ElementsPanel.setOpaque(false);
        ElementsPanel.setLayout(null);
        ElementsPanel.setPreferredSize(new Dimension(850, 1750));

        JScrollPane scrollPane = new JScrollPane(ElementsPanel);
        scrollPane.setBounds(349, -1, 855, 755);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setBackground(new Color(0x0A0D10));

        ElementsPanel.addMouseWheelListener(e -> {
            JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();// had scroll par rapport l y
            int notches = e.getWheelRotation();
            int currentValue = verticalScrollBar.getValue();
            int scrollAmount = 30; // Adjust scroll speed
            verticalScrollBar.setValue(currentValue + (notches * scrollAmount));
        });

        AccountPanel.add(scrollPane);

        // id panel-------------------------------------------------------------------
        JPanel IdPanel = new JPanel();
        IdPanel.setBounds(50, 75, 750, 250);
        IdPanel.setBackground(new Color(0x2B2B2B));
        IdPanel.setLayout(null);

        JLabel NameInfo = new JLabel("Your personnal name");
        NameInfo.setBounds(375, 25, 250, 30);
        NameInfo.setFont(new Font("Segoe UI", Font.BOLD, 17));
        NameInfo.setForeground(Color.white);

        IdPanel.add(NameInfo);

        JTextField NameField = new JTextField("  Name");
        NameField.setBounds(375, 65, 250, 30);
        NameField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        NameField.setForeground(Color.white);
        NameField.setCaretColor(Color.white);
        // NameField.setBackground(new Color(80, 77, 74, 230));
        NameField.setBackground(new Color(0x151515));
        NameField.setOpaque(true);

        TextfieldBehave(NameField, "  Name");

        IdPanel.add(NameField);

        JButton SaveId = new JButton("Save changes");
        SaveId.setBounds(575, 200, 150, 30);
        SaveId.setFont(new Font("Segoe UI", Font.BOLD, 15));
        SaveId.setBackground(new Color(0xCBCBCB));
        SaveId.setCursor(new Cursor(Cursor.HAND_CURSOR));
        SaveId.setUI(new RoundButtonUI(new Color(0x000000)));

        SaveId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SaveId.setBackground(new Color(0xD42E00));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                SaveId.setBackground(new Color(0xCBCBCB));
            }
        });

        IdPanel.add(SaveId);

        JPanel IdHolderPanel = new JPanel();
        IdHolderPanel.setBounds(0, 0, 325, 250);
        IdHolderPanel.setLayout(null);
        IdHolderPanel.setBackground(new Color(0x1C2837));

        JLabel IdText = new JLabel("Account ID");
        IdText.setBounds(50, 25, 200, 30);
        IdText.setForeground(Color.white);
        IdText.setFont(new Font("Segoe UI", Font.BOLD, 24));

        JLabel IdTextDescription = new JLabel("This Id information are used to log in ,but ");
        IdTextDescription.setBounds(50, 75, 250, 30);
        IdTextDescription.setForeground(Color.white);
        IdTextDescription.setFont(new Font("Segoe UI", Font.BOLD, 10));

        JLabel IdTextDescription2 = new JLabel("also to allow a better service provider");
        IdTextDescription2.setBounds(50, 95, 250, 30);
        IdTextDescription2.setForeground(Color.white);
        IdTextDescription2.setFont(new Font("Segoe UI", Font.BOLD, 10));

        IdHolderPanel.add(IdTextDescription2);
        IdHolderPanel.add(IdTextDescription);
        IdHolderPanel.add(IdText);

        IdPanel.add(IdHolderPanel);

        ElementsPanel.add(IdPanel);

        // personnal panel
        // ----------------------------------------------------------------
        JPanel PersoPanel = new JPanel();
        PersoPanel.setBounds(50, 365, 750, 500);
        PersoPanel.setBackground(new Color(0x2B2B2B));
        PersoPanel.setLayout(null);

        JLabel PersonnalInfo = new JLabel("Personnal informations ");
        PersonnalInfo.setBounds(375, 25, 250, 30);
        PersonnalInfo.setFont(new Font("Segoe UI", Font.BOLD, 17));
        PersonnalInfo.setForeground(Color.white);

        PersoPanel.add(PersonnalInfo);

        JTextField FirstNameField = new JTextField("  First name");
        FirstNameField.setBounds(375, 65, 250, 30);
        FirstNameField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        FirstNameField.setForeground(Color.white);
        FirstNameField.setCaretColor(Color.white);
        // FirstNameField.setBackground(new Color(80, 77, 74, 230));
        FirstNameField.setBackground(new Color(0x151515));
        FirstNameField.setOpaque(true);

        TextfieldBehave(FirstNameField, "  First name");

        PersoPanel.add(FirstNameField);

        JTextField LastNameField = new JTextField("  Last name");
        LastNameField.setBounds(375, 105, 250, 30);
        LastNameField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        LastNameField.setForeground(Color.white);
        LastNameField.setCaretColor(Color.white);
        // LastNameField.setBackground(new Color(80, 77, 74, 230));
        LastNameField.setBackground(new Color(0x151515));
        LastNameField.setOpaque(true);

        TextfieldBehave(LastNameField, "  Last name");

        PersoPanel.add(LastNameField);

        JTextField EmailField = new JTextField("  email@gmail.com");
        EmailField.setBounds(375, 145, 250, 30);
        EmailField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        EmailField.setForeground(Color.white);
        EmailField.setCaretColor(Color.white);
        // EmailField.setBackground(new Color(80, 77, 74, 230));
        EmailField.setBackground(new Color(0x151515));
        EmailField.setOpaque(true);

        TextfieldBehave(EmailField, "  emailemail@gmail.com");

        PersoPanel.add(EmailField);

        JTextField AgeField = new JTextField("  22");
        AgeField.setBounds(375, 185, 250, 30);
        AgeField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        AgeField.setForeground(Color.white);
        AgeField.setCaretColor(Color.white);
        // AgeField.setBackground(new Color(80, 77, 74, 230));
        AgeField.setBackground(new Color(0x151515));
        AgeField.setOpaque(true);

        TextfieldBehave(AgeField, "  22");

        PersoPanel.add(AgeField);

        JTextField PhoneNumberField = new JTextField(" 05XX XX XX XX");
        PhoneNumberField.setBounds(375, 225, 250, 30);
        PhoneNumberField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        PhoneNumberField.setForeground(Color.white);
        PhoneNumberField.setCaretColor(Color.white);
        // PhoneNumberField.setBackground(new Color(80, 77, 74, 230));
        PhoneNumberField.setBackground(new Color(0x151515));
        PhoneNumberField.setOpaque(true);

        TextfieldBehave(PhoneNumberField, " 05XX XX XX XX");

        PersoPanel.add(PhoneNumberField);

        JButton SavePersonnal = new JButton("Save changes");
        SavePersonnal.setBounds(575, 450, 150, 30);
        SavePersonnal.setFont(new Font("Segoe UI", Font.BOLD, 15));
        SavePersonnal.setBackground(new Color(0xCBCBCB));
        SavePersonnal.setCursor(new Cursor(Cursor.HAND_CURSOR));
        SavePersonnal.setUI(new RoundButtonUI(new Color(0x000000)));

        SavePersonnal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SavePersonnal.setBackground(new Color(0xD42E00));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                SavePersonnal.setBackground(new Color(0xCBCBCB));
            }
        });

        PersoPanel.add(SavePersonnal);

        JPanel PersoHolder = new JPanel();
        PersoHolder.setBounds(0, 0, 325, 500);
        PersoHolder.setLayout(null);
        PersoHolder.setBackground(new Color(0x1C2837));

        JLabel PersoText = new JLabel("Personnal informations");
        PersoText.setBounds(50, 25, 350, 30);
        PersoText.setForeground(Color.white);
        PersoText.setFont(new Font("Segoe UI", Font.BOLD, 24));

        JLabel PersoTextDescription = new JLabel("This informations are private and will ");
        PersoTextDescription.setBounds(50, 75, 250, 30);
        PersoTextDescription.setForeground(Color.white);
        PersoTextDescription.setFont(new Font("Segoe UI", Font.BOLD, 10));

        JLabel PersoTextDescription2 = new JLabel("not be shared with others");
        PersoTextDescription2.setBounds(50, 95, 250, 30);
        PersoTextDescription2.setForeground(Color.white);
        PersoTextDescription2.setFont(new Font("Segoe UI", Font.BOLD, 10));

        PersoHolder.add(PersoTextDescription2);
        PersoHolder.add(PersoTextDescription);
        PersoHolder.add(PersoText);

        PersoPanel.add(PersoHolder);

        ElementsPanel.add(PersoPanel);

        // payements panel---------------------------------------------------------
        JPanel PayPanel = new JPanel();
        PayPanel.setBounds(50, 905, 750, 200);
        PayPanel.setBackground(new Color(0x2B2B2B));
        PayPanel.setLayout(null);

        JLabel PayInfo = new JLabel("Payement informations ");
        PayInfo.setBounds(375, 25, 250, 30);
        PayInfo.setFont(new Font("Segoe UI", Font.BOLD, 17));
        PayInfo.setForeground(Color.white);

        PayPanel.add(PayInfo);

        JTextField CardNumber = new JTextField("  Card number");
        CardNumber.setBounds(375, 65, 250, 30);
        CardNumber.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        CardNumber.setForeground(Color.white);
        CardNumber.setCaretColor(Color.white);
        // CardNumber.setBackground(new Color(80, 77, 74, 230));
        CardNumber.setBackground(new Color(0x151515));
        CardNumber.setOpaque(true);

        TextfieldBehave(CardNumber, "  Card number");

        PayPanel.add(CardNumber);

        JTextField CcvNumber = new JTextField("  Ccv number");
        CcvNumber.setBounds(375, 105, 250, 30);
        CcvNumber.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        CcvNumber.setForeground(Color.white);
        CcvNumber.setCaretColor(Color.white);
        // CcvNumber.setBackground(new Color(80, 77, 74, 230));
        CcvNumber.setBackground(new Color(0x151515));
        CcvNumber.setOpaque(true);

        TextfieldBehave(CcvNumber, "  Ccv number");

        PayPanel.add(CcvNumber);

        JButton SavePayement = new JButton("Save changes");
        SavePayement.setBounds(575, 150, 150, 30);
        SavePayement.setFont(new Font("Segoe UI", Font.BOLD, 15));
        SavePayement.setBackground(new Color(0xCBCBCB));
        SavePayement.setCursor(new Cursor(Cursor.HAND_CURSOR));
        SavePayement.setUI(new RoundButtonUI(new Color(0x000000)));

        SavePayement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SavePayement.setBackground(new Color(0xD42E00));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                SavePayement.setBackground(new Color(0xCBCBCB));
            }
        });

        PayPanel.add(SavePayement);

        JPanel PayHolder = new JPanel();
        PayHolder.setBounds(0, 0, 325, 200);
        PayHolder.setLayout(null);
        PayHolder.setBackground(new Color(0x1C2837));

        JLabel PayText = new JLabel("Payment informations");
        PayText.setBounds(50, 25, 350, 30);
        PayText.setForeground(Color.white);
        PayText.setFont(new Font("Segoe UI", Font.BOLD, 24));

        JLabel PayTextDescription = new JLabel("your credit and payement information");
        PayTextDescription.setBounds(50, 75, 250, 30);
        PayTextDescription.setForeground(Color.white);
        PayTextDescription.setFont(new Font("Segoe UI", Font.BOLD, 10));

        PayHolder.add(PayTextDescription);
        PayHolder.add(PayText);

        PayPanel.add(PayHolder);

        ElementsPanel.add(PayPanel);

        // sign in infos panel ------------------------------------------------
        JPanel SignPanel = new JPanel();
        SignPanel.setBounds(50, 1145, 750, 400);
        SignPanel.setBackground(new Color(0x2B2B2B));
        SignPanel.setLayout(null);

        JLabel SignInfo = new JLabel("sign and log in informations");
        SignInfo.setBounds(375, 25, 250, 30);
        SignInfo.setFont(new Font("Segoe UI", Font.BOLD, 17));
        SignInfo.setForeground(Color.white);

        SignPanel.add(SignInfo);

        JTextField UsernameField = new JTextField("  username");
        UsernameField.setBounds(375, 65, 250, 30);
        UsernameField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        UsernameField.setForeground(Color.white);
        UsernameField.setCaretColor(Color.white);
        // UsernameField.setBackground(new Color(80, 77, 74, 230));
        UsernameField.setBackground(new Color(0x151515));
        UsernameField.setOpaque(true);

        TextfieldBehave(UsernameField, "  username");

        SignPanel.add(UsernameField);

        JLabel PasswordInfo = new JLabel("Password");
        PasswordInfo.setBounds(375, 145, 250, 30);
        PasswordInfo.setFont(new Font("Segoe UI", Font.BOLD, 17));
        PasswordInfo.setForeground(Color.white);

        SignPanel.add(PasswordInfo);

        JTextField CurrentPassword = new JTextField();
        CurrentPassword.setBounds(375, 185, 250, 30);
        CurrentPassword.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        CurrentPassword.setForeground(Color.white);
        CurrentPassword.setCaretColor(Color.white);
        // CurrentPassword.setBackground(new Color(80, 77, 74, 230));
        CurrentPassword.setBackground(new Color(0x151515));
        CurrentPassword.setOpaque(true);

        TextfieldBehave(CurrentPassword, "  Current password");

        SignPanel.add(CurrentPassword);

        JTextField NewPassword = new JTextField("  New password");
        NewPassword.setBounds(375, 225, 250, 30);
        NewPassword.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        NewPassword.setForeground(Color.white);
        NewPassword.setCaretColor(Color.white);
        // NewPassword.setBackground(new Color(80, 77, 74, 230));
        NewPassword.setBackground(new Color(0x151515));
        NewPassword.setOpaque(true);

        TextfieldBehave(NewPassword, "  New password");

        SignPanel.add(NewPassword);

        JTextField ConfirmPassword = new JTextField("  Confirm password");
        ConfirmPassword.setBounds(375, 265, 250, 30);
        ConfirmPassword.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        ConfirmPassword.setForeground(Color.white);
        ConfirmPassword.setCaretColor(Color.white);
        // ConfirmPassword.setBackground(new Color(80, 77, 74, 230));
        ConfirmPassword.setBackground(new Color(0x151515));
        ConfirmPassword.setOpaque(true);

        TextfieldBehave(ConfirmPassword, "  Confirm password");

        SignPanel.add(ConfirmPassword);

        JButton SaveSignIn = new JButton("Save changes");
        SaveSignIn.setBounds(575, 350, 150, 30);
        SaveSignIn.setFont(new Font("Segoe UI", Font.BOLD, 15));
        SaveSignIn.setBackground(new Color(0xCBCBCB));
        SaveSignIn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        SaveSignIn.setUI(new RoundButtonUI(new Color(0x000000)));

        SaveSignIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SaveSignIn.setBackground(new Color(0xD42E00));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                SaveSignIn.setBackground(new Color(0xCBCBCB));
            }
        });

        SignPanel.add(SaveSignIn);

        JPanel SignHolder = new JPanel();
        SignHolder.setBounds(0, 0, 325, 400);
        SignHolder.setLayout(null);
        SignHolder.setBackground(new Color(0x1C2837));

        JLabel SignText = new JLabel("Sign in Management");
        SignText.setBounds(50, 25, 350, 30);
        SignText.setForeground(Color.white);
        SignText.setFont(new Font("Segoe UI", Font.BOLD, 24));

        JLabel SignTextDescription = new JLabel("change your sign and log in infos ");
        SignTextDescription.setBounds(50, 75, 250, 30);
        SignTextDescription.setForeground(Color.white);
        SignTextDescription.setFont(new Font("Segoe UI", Font.BOLD, 10));

        SignHolder.add(SignTextDescription);
        SignHolder.add(SignText);

        SignPanel.add(SignHolder);

        ElementsPanel.add(SignPanel);

        Exit.addActionListener(e -> {
            MainCardLayout.show(MainPanel, "Client");
        });

        ExitButton.addActionListener(e -> {
            MainCardLayout.show(MainPanel, "Client");
        });

        return AccountPanel;
    }

    public JPanel CreateAccountAdminPanel() {
        JPanel AccountAdminPanel = new JPanel();

        return AccountAdminPanel;
    }

    /*
     * public JPanel CreateBuyPanel(Movie movie){
     * JPanel BuyPanel = new JPanel();
     * BuyPanel.setLayout(null);
     * BuyPanel.setBounds(0, 0, 1200, 750);
     * BuyPanel.setBackground(new Color(0x121213));
     * 
     * //Left panel ----------------------------------------------------------------
     * RoundedPanel LeftPanel = new RoundedPanel(35);
     * LeftPanel.setBounds(30,30, 150, 650);
     * LeftPanel.setBackground(new Color(0x212121));
     * LeftPanel.setLayout(null);
     * 
     * BuyPanel.add(LeftPanel);
     * 
     * JPanel StraightLine = new JPanel();
     * StraightLine.setBounds(220, 80, 930, 5);
     * StraightLine.setBackground(new Color(0x313131));
     * 
     * BuyPanel.add(StraightLine);
     * 
     * RoundedPanel SearchBar = new RoundedPanel(35);
     * SearchBar.setBounds(250, 30, 800, 30);
     * SearchBar.setBackground(new Color(0x212121));
     * SearchBar.setLayout(null);
     * 
     * BuyPanel.add(SearchBar);
     * 
     * JTextField SearchField = new JTextField();
     * SearchField.setBounds(10, 2, 800, 25);
     * SearchField.setFont(new Font("Inter", Font.BOLD, 15));
     * SearchField.setForeground(Color.white);
     * SearchField.setCaretColor(Color.white);
     * SearchField.setOpaque(false);
     * SearchField.setBorder(null);
     * 
     * TextfieldBehave(SearchField, "Search for a movie");
     * 
     * SearchBar.add(SearchField);
     * 
     * JButton Filter = new JButton();
     * Filter.setBounds(200, 32, 30, 30);
     * Filter.setFocusPainted(false);
     * Filter.setBorder(null);
     * Filter.setBackground(new Color(0x212121));
     * Filter.setUI(new RoundButtonUI(Color.black));
     * Filter.addActionListener(e -> {
     * // Open movie filter dialog
     * });
     * BuyPanel.add(Filter);
     * 
     * JButton History = new JButton();
     * History.setBounds(1070, 29, 30, 30);
     * History.setFocusPainted(false);
     * History.setBorder(null);
     * History.setBackground(new Color(0x212121));
     * History.setUI(new RoundButtonUI(Color.black));
     * History.addActionListener(e -> {
     * // Open movie History dialog
     * });
     * BuyPanel.add(History);
     * 
     * JButton Account = new JButton();
     * Account.setBounds(1110, 29, 50, 30);
     * Account.setFocusPainted(false);
     * Account.setBorder(null);
     * Account.setBackground(new Color(0x515151));
     * Account.setUI(new RoundButtonUI(Color.black));
     * Account.addActionListener(e -> {
     * // Open movie Account dialog
     * MainCardLayout.show(MainPanel, "Account");
     * });
     * BuyPanel.add(Account);
     * 
     * JPanel ContentPanel = new JPanel();
     * ContentPanel.setLayout(null);
     * ContentPanel.setOpaque(true);
     * ContentPanel.setBackground(new Color(0x121213));
     * ContentPanel.setPreferredSize(new Dimension(919, 1250));
     * 
     * JScrollPane scrollPane = new JScrollPane(ContentPanel);
     * scrollPane.setBounds(227, 85, 919, 750);
     * scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.
     * VERTICAL_SCROLLBAR_NEVER);
     * scrollPane.setOpaque(false);
     * scrollPane.setBorder(null);
     * 
     * ContentPanel.addMouseWheelListener(e -> {
     * JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();// had
     * scroll par rapport l y
     * int notches = e.getWheelRotation();
     * int currentValue = verticalScrollBar.getValue();
     * int scrollAmount = 30; // Adjust scroll speed
     * verticalScrollBar.setValue(currentValue + (notches * scrollAmount));
     * });
     * 
     * BuyPanel.add(scrollPane);
     * 
     * RoundedPanel FilmBanner = new RoundedPanel(35);
     * FilmBanner.setBounds(0, 20, 915, 300);
     * FilmBanner.setBackground(new Color(0x212121));
     * FilmBanner.setLayout(null);
     * 
     * ContentPanel.add(FilmBanner);
     * 
     * RoundedPanel InfoPanel = new RoundedPanel(35);
     * InfoPanel.setBounds(0, 550, 650, 275);
     * InfoPanel.setBackground(new Color(0x121213));
     * InfoPanel.setLayout(null);
     * InfoPanel.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));
     * 
     * ContentPanel.add(InfoPanel);
     * 
     * JLabel FilmTitle = new JLabel("Movie Title");
     * FilmTitle.setBounds(0, 335, 900, 50);
     * FilmTitle.setForeground(Color.white);
     * FilmTitle.setFont(new Font("Inter", Font.BOLD, 36));
     * 
     * ContentPanel.add(FilmTitle);
     * 
     * JLabel Description = new JLabel();
     * Description.setBounds(0, 350, 1000, 250);
     * Description.setForeground(Color.white);
     * Description.setFont(new Font("Inter", Font.PLAIN, 15));
     * 
     * ContentPanel.add(Description);
     * 
     * JLabel FilmRating = new JLabel("Rating: 8.5/10");
     * FilmRating.setBounds(35, 25, 600, 25);
     * FilmRating.setForeground(Color.white);
     * FilmRating.setFont(new Font("Inter", Font.BOLD, 16));
     * 
     * InfoPanel.add(FilmRating);
     * 
     * JLabel AgeRating = new JLabel("Age rating : PG16");
     * AgeRating.setBounds(400, 25, 600, 25);
     * AgeRating.setForeground(Color.white);
     * AgeRating.setFont(new Font("Inter", Font.BOLD, 16));
     * 
     * InfoPanel.add(AgeRating);
     * 
     * JLabel Duration = new JLabel("duration : 1h30");
     * Duration.setBounds(400, 75, 600, 25);
     * Duration.setForeground(Color.white);
     * Duration.setFont(new Font("Inter", Font.BOLD, 16));
     * 
     * InfoPanel.add(Duration);
     * 
     * JLabel FilmReleaseDate = new JLabel("Release Date: 12/05/2022");
     * FilmReleaseDate.setBounds(35, 75, 600, 25);
     * FilmReleaseDate.setForeground(Color.white);
     * FilmReleaseDate.setFont(new Font("Inter", Font.BOLD, 16));
     * 
     * InfoPanel.add(FilmReleaseDate);
     * 
     * JLabel FilmGenre = new JLabel("Genre: Drama, Comedy");
     * FilmGenre.setBounds(35, 125, 600, 25);
     * FilmGenre.setForeground(Color.white);
     * FilmGenre.setFont(new Font("Inter", Font.BOLD, 16));
     * 
     * InfoPanel.add(FilmGenre);
     * 
     * JLabel FilmDirector = new JLabel("Director: John Doe");
     * FilmDirector.setBounds(35, 175, 600, 25);
     * FilmDirector.setForeground(Color.white);
     * FilmDirector.setFont(new Font("Inter", Font.BOLD, 16));
     * 
     * InfoPanel.add(FilmDirector);
     * 
     * JLabel FilmCast = new JLabel("Cast: John Doe, Jane Doe");
     * FilmCast.setBounds(35, 225, 600, 25);
     * FilmCast.setForeground(Color.white);
     * FilmCast.setFont(new Font("Inter", Font.BOLD, 16));
     * 
     * InfoPanel.add(FilmCast);
     * 
     * JButton Buy = new JButton();
     * Buy.setBounds(0, 850, 175, 40);
     * Buy.setText("Buy Now");
     * Buy.setFont(new Font("Inter", Font.BOLD, 15));
     * Buy.setBackground(Color.white);
     * Buy.setForeground(Color.black);
     * Buy.setCursor(new Cursor(Cursor.HAND_CURSOR));
     * Buy.setUI(new RoundButtonUI(Color.white));
     * Buy.addActionListener(e -> {
     * // handle buy button click
     * });
     * 
     * ContentPanel.add(Buy);
     * 
     * JButton WhatchTrailler = new JButton();
     * WhatchTrailler.setBounds(200, 850, 250, 40);
     * WhatchTrailler.setText("Whatch Trailler Now");
     * WhatchTrailler.setFont(new Font("Inter", Font.BOLD, 15));
     * WhatchTrailler.setBackground(Color.black);
     * WhatchTrailler.setForeground(Color.white);
     * WhatchTrailler.setCursor(new Cursor(Cursor.HAND_CURSOR));
     * WhatchTrailler.setUI(new RoundButtonUI(Color.black));
     * WhatchTrailler.addActionListener(e -> {
     * // handle WhatchTrailler button click
     * });
     * 
     * ContentPanel.add(WhatchTrailler);
     * 
     * return BuyPanel;
     * }
     */

    public JPanel CreateClientInterface() {
        JPanel ClientPanel = new JPanel();
        ClientPanel.setBounds(0, 0, 1200, 750);
        ClientPanel.setBackground(new Color(0x121213));
        ClientPanel.setLayout(null);

        // -----------------content area--------------------------------------------------------
        JPanel ContentPanel = new JPanel();
        ContentPanel.setBounds(227, 89, 955, 750);
        ContentPanel.setLayout(new CardLayout());

        ClientPanel.add(ContentPanel);

        // Home panel---------------------------------------------------------------------------
        JPanel HomePanel = new JPanel();
        HomePanel.setLayout(null);
        HomePanel.setOpaque(true);
        HomePanel.setBackground(new Color(0x121213));
        HomePanel.setPreferredSize(new Dimension(1009, 1750));

        JScrollPane scrollPane = new JScrollPane(HomePanel);
        scrollPane.setBounds(0, 0, 955, 750);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setOpaque(false);
        scrollPane.setBorder(null);

        HomePanel.addMouseWheelListener(e -> {
            JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();// had scroll par rapport l y
            int notches = e.getWheelRotation();
            int currentValue = verticalScrollBar.getValue();
            int scrollAmount = 30; // Adjust scroll speed
            verticalScrollBar.setValue(currentValue + (notches * scrollAmount));
        });

        // ----------------------------------------------------------------

        // Most popular movie------------------------------------
        Movie MostPopularMovie = movieManager.GetBestRated();

        JPanel MostPopularPanel = new JPanel();
        MostPopularPanel.setBounds(25, 20, 900, 400);
        MostPopularPanel.setBackground(new Color(0x121213));
        MostPopularPanel.setLayout(null);

        HomePanel.add(MostPopularPanel);

        ImageIcon imageIcon = resizedIcon(MostPopularMovie.ImagePath2, 900, 400);
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, 0, 900, 400);

        MostPopularPanel.add(imageLabel);

        TransparentPanel backgroundPanel = new TransparentPanel(0.25f);
        backgroundPanel.setBounds(0, 0, 940, 400);
        backgroundPanel.setBackground(new Color(0x000000));
        backgroundPanel.setLayout(null);

        MostPopularPanel.add(backgroundPanel);

        RoundTransparentPanel PopularText = new RoundTransparentPanel(0.75f, 35);
        PopularText.setBounds(20, 20, 220, 40);
        PopularText.setBackground(new Color(0x000000));
        PopularText.setLayout(null);

        MostPopularPanel.add(PopularText);

        JLabel MostPopularLabel = new JLabel("Most Popular Movie");
        MostPopularLabel.setBounds(15, 5, 200, 30);
        MostPopularLabel.setFont(new Font("Inter", Font.BOLD, 20));
        MostPopularLabel.setForeground(Color.white);

        PopularText.add(MostPopularLabel);

        JButton BookNow = new JButton("Book Now");
        BookNow.setBounds(25, 350, 125, 30);
        BookNow.setFont(new Font("Inter", Font.BOLD, 12));
        BookNow.setForeground(Color.black);
        BookNow.setBackground(Color.white);
        BookNow.setFocusPainted(false);
        BookNow.setUI(new RoundButtonUI(Color.black));
        BookNow.addActionListener(e -> {
            // Open Booking dialog
        });

        MostPopularPanel.add(BookNow);

        JButton MoreInfo = new JButton("More Info :");
        MoreInfo.setBounds(175, 350, 125, 30);
        MoreInfo.setFont(new Font("Inter", Font.BOLD, 15));
        MoreInfo.setForeground(Color.white);
        MoreInfo.setBackground(Color.black);
        MoreInfo.setFocusPainted(false);
        MoreInfo.setUI(new RoundButtonUI(Color.black));
        MoreInfo.addActionListener(e -> {
            // Open Booking dialog
        });

        MostPopularPanel.add(MoreInfo);

        MostPopularPanel.setComponentZOrder(imageLabel, 2);
        MostPopularPanel.setComponentZOrder(backgroundPanel, 1);
        MostPopularPanel.setComponentZOrder(PopularText, 0);
        MostPopularPanel.setComponentZOrder(BookNow, 0);
        MostPopularPanel.setComponentZOrder(MoreInfo, 0);
        // --------------------------------------------------

        //suggestion grid ----------------------------------------

        JLabel YouMayLike = new JLabel("You might like");
        YouMayLike.setBounds(25, 500, 900, 40);
        YouMayLike.setFont(new Font("Inter", Font.BOLD, 32));
        YouMayLike.setForeground(Color.white);

        HomePanel.add(YouMayLike);

        JPanel SuggestionPanel = new JPanel();
        SuggestionPanel.setBounds(25, 550, 900, 300);
        SuggestionPanel.setBackground(new Color(0x121213));
        SuggestionPanel.setLayout(new GridLayout(1, 3, 100, 10));

        HomePanel.add(SuggestionPanel);

        for(int i = 0; i< 3; i++){
            RoundedPanel moviePanel = new RoundedPanel(35);
            moviePanel.setLayout(null);
            moviePanel.setBackground(new Color(0x212121));
            moviePanel.setPreferredSize(new Dimension(250, 300));

            // Hayla hadi :-)
            moviePanel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    moviePanel.setBorder (BorderFactory.createLineBorder (new Color(0xFF6700),
                    3, true));// ta3 ki t intiracti m3a l panel
                }
                
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    moviePanel.setBorder(null);
                }
                
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    JOptionPane.showMessageDialog(null, "Opening film details...");
                }
            });
            ImageIcon BannerIcon = resizedIcon(movieManager.movies.get(i).ImagePath, 250, 300);
            JLabel BannerLabel = new JLabel(BannerIcon);
            BannerLabel.setBounds(0, 0, 250, 300);

            moviePanel.add(BannerLabel);

            SuggestionPanel.add(moviePanel);
        }
        //---------------------------------------

        //promotions ---------------------------------------------------
        JLabel Promotions = new JLabel("Promotions");
        Promotions.setBounds(25, 900, 900, 40);
        Promotions.setFont(new Font("Inter", Font.BOLD, 32));
        Promotions.setForeground(Color.white);

        HomePanel.add(Promotions);

        JPanel PromotionPanel = new JPanel();
        PromotionPanel.setBounds(25, 950, 900, 500);
        PromotionPanel.setBackground(new Color(0x121213));
        PromotionPanel.setLayout(new GridLayout(1, 2, 25, 10));

        HomePanel.add(PromotionPanel);

        int[] PromotionNumbers;
        if(movieManager.PromosId == null){
            PromotionNumbers = movieManager.setRandomPromotion();
        }else{
            PromotionNumbers = movieManager.PromosId;
        }
        

        for(int i = 0; i< 2; i++){
            RoundedPanel moviePanel = new RoundedPanel(35);
            moviePanel.setLayout(null);
            moviePanel.setBackground(new Color(0x212121));

            RoundedPanel MovieBanner = new RoundedPanel(35);
            MovieBanner.setBounds(5, 5, 425, 250);
            MovieBanner.setBackground(new Color(0x414141));
            MovieBanner.setLayout(null);

            moviePanel.add(MovieBanner);

            // Hayla hadi :-)
            moviePanel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    moviePanel.setBorder (BorderFactory.createLineBorder (new Color(0xFF6700),
                    3, true));// ta3 ki t intiracti m3a l panel
                }
                
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    moviePanel.setBorder(null);
                }
                
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    JOptionPane.showMessageDialog(null, "Opening film details...");
                }
            });
            ImageIcon BannerIcon = resizedIcon(movieManager.movies.get(PromotionNumbers[i]).ImagePath2, 425, 250);
            JLabel BannerLabel = new JLabel(BannerIcon);
            BannerLabel.setBounds(0, 0, 425, 250);

            MovieBanner.add(BannerLabel);

            JLabel MovieTitle = new JLabel(movieManager.movies.get(PromotionNumbers[i]).Title);
            MovieTitle.setBounds(5, 260, 425, 40);
            MovieTitle.setFont(new Font("Inter", Font.BOLD, 20));
            MovieTitle.setForeground(Color.white);

            moviePanel.add(MovieTitle);

            JLabel MovieDuration = new JLabel("<html>" + movieManager.movies.get(PromotionNumbers[i]).Description + "</html>");
            MovieDuration.setBounds(5, 290, 425, 150);
            MovieDuration.setFont(new Font("Inter", Font.PLAIN, 14));
            MovieDuration.setForeground(Color.white);

            moviePanel.add(MovieDuration);

            //author 
            JLabel Author = new JLabel("By " + movieManager.movies.get(PromotionNumbers[i]).Director);
            Author.setBounds(5, 450, 425, 30);
            Author.setFont(new Font("Inter", Font.BOLD, 16));
            Author.setForeground(Color.white);

            moviePanel.add(Author);

            PromotionPanel.add(moviePanel);
        }
        //------------------------------------------------------------

        //large button 
        JButton MoreMovies = new JButton("More Movies");
        MoreMovies.setBounds(25, 1500, 900, 50);
        MoreMovies.setFont(new Font("Inter", Font.BOLD, 15));
        MoreMovies.setBackground(new Color(0x414141));
        MoreMovies.setForeground(Color.white);
        MoreMovies.setUI(new RoundButtonUI(new Color(0x000000)));
        MoreMovies.setCursor(new Cursor(Cursor.HAND_CURSOR));
        MoreMovies.addActionListener(e -> {
            // handle filter button click
        ((CardLayout) ContentPanel.getLayout()).show(ContentPanel, "all movies");
        });
        MoreMovies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MoreMovies.setBackground(new Color(0x616161));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                MoreMovies.setBackground(new Color(0x414141));
            }
        });
        HomePanel.add(MoreMovies);

        //all movies panel -------------------------------------------------------
        
        JPanel AllMoviePanel = new JPanel();
        AllMoviePanel.setLayout(null);
        AllMoviePanel.setOpaque(true);
        AllMoviePanel.setBackground(new Color(0x121213));
        AllMoviePanel.setPreferredSize(new Dimension(955, 20000));

        JScrollPane scrollPane2 = new JScrollPane(AllMoviePanel);
        scrollPane2.setBounds(0, 0, 955, 750);
        scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPane2.setOpaque(false);
        scrollPane2.setBorder(null);

        AllMoviePanel.addMouseWheelListener(e -> {
            JScrollBar verticalScrollBar = scrollPane2.getVerticalScrollBar();// had scroll par rapport l y
            int notches = e.getWheelRotation();
            int currentValue = verticalScrollBar.getValue();
            int scrollAmount = 30; // Adjust scroll speed
            verticalScrollBar.setValue(currentValue + (notches * scrollAmount));
        });

        JLabel AllMoviesText = new JLabel("Explore more movies");
        AllMoviesText.setBounds(25, 15, 425, 40);
        AllMoviesText.setFont(new Font("Inter", Font.BOLD, 32));
        AllMoviesText.setForeground(Color.white);

        AllMoviePanel.add(AllMoviesText);


        JPanel AllMovieList = new JPanel();
        AllMovieList.setOpaque(false);
        AllMovieList.setBounds(25, 70, 915, MovieManager.movies.size() * 250 + MovieManager.movies.size() * 25);
        AllMovieList.setLayout(new GridLayout(0, 2, 40, 20));

        AllMoviePanel.add(AllMovieList);

        for (int i = 0; i < MovieManager.movies.size(); i++) {
            if(ChosenGenre == null){
                RoundedPanel moviePanel = new RoundedPanel(35);
                moviePanel.setLayout(null);
                moviePanel.setBackground(new Color(0x212121));

                RoundedPanel MovieBanner = new RoundedPanel(35);
                MovieBanner.setBounds(5, 5, 425, 250);
                MovieBanner.setBackground(new Color(0x414141));
                MovieBanner.setLayout(null);

                moviePanel.add(MovieBanner);

                // Hayla hadi :-)
                moviePanel.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        moviePanel.setBorder (BorderFactory.createLineBorder (new Color(0xFF6700),
                        3, true));// ta3 ki t intiracti m3a l panel
                    }
                    
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        moviePanel.setBorder(null);
                    }
                    
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        JOptionPane.showMessageDialog(null, "Opening film details...");
                    }
                });
                ImageIcon BannerIcon = resizedIcon(movieManager.movies.get(i).ImagePath2, 425, 250);
                JLabel BannerLabel = new JLabel(BannerIcon);
                BannerLabel.setBounds(0, 0, 425, 250);

                MovieBanner.add(BannerLabel);

                JLabel MovieTitle = new JLabel(movieManager.movies.get(i).Title);
                MovieTitle.setBounds(5, 260, 425, 40);
                MovieTitle.setFont(new Font("Inter", Font.BOLD, 20));
                MovieTitle.setForeground(Color.white);

                moviePanel.add(MovieTitle);

                JLabel MovieDuration = new JLabel("<html>" + movieManager.movies.get(i).Description + "</html>");
                MovieDuration.setBounds(5, 290, 425, 150);
                MovieDuration.setFont(new Font("Inter", Font.PLAIN, 14));
                MovieDuration.setForeground(Color.white);

                moviePanel.add(MovieDuration);

                //author 
                JLabel Author = new JLabel("By " + movieManager.movies.get(i).Director);
                Author.setBounds(5, 450, 425, 30);
                Author.setFont(new Font("Inter", Font.BOLD, 16));
                Author.setForeground(Color.white);

                moviePanel.add(Author);

                AllMovieList.add(moviePanel);
            }else if(movieManager.movies.get(i).Genre == ChosenGenre){
                RoundedPanel moviePanel = new RoundedPanel(35);
                moviePanel.setLayout(null);
                moviePanel.setBackground(new Color(0x212121));

                RoundedPanel MovieBanner = new RoundedPanel(35);
                MovieBanner.setBounds(5, 5, 425, 250);
                MovieBanner.setBackground(new Color(0x414141));
                MovieBanner.setLayout(null);

                moviePanel.add(MovieBanner);

                // Hayla hadi :-)
                moviePanel.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        moviePanel.setBorder (BorderFactory.createLineBorder (new Color(0xFF6700),
                        3, true));// ta3 ki t intiracti m3a l panel
                    }
                    
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        moviePanel.setBorder(null);
                    }
                    
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        JOptionPane.showMessageDialog(null, "Opening film details...");
                    }
                });
                ImageIcon BannerIcon = resizedIcon(movieManager.movies.get(i).ImagePath2, 425, 250);
                JLabel BannerLabel = new JLabel(BannerIcon);
                BannerLabel.setBounds(0, 0, 425, 250);

                MovieBanner.add(BannerLabel);

                JLabel MovieTitle = new JLabel(movieManager.movies.get(i).Title);
                MovieTitle.setBounds(5, 260, 425, 40);
                MovieTitle.setFont(new Font("Inter", Font.BOLD, 20));
                MovieTitle.setForeground(Color.white);

                moviePanel.add(MovieTitle);

                JLabel MovieDuration = new JLabel("<html>" + movieManager.movies.get(i).Description + "</html>");
                MovieDuration.setBounds(5, 290, 425, 150);
                MovieDuration.setFont(new Font("Inter", Font.PLAIN, 14));
                MovieDuration.setForeground(Color.white);

                moviePanel.add(MovieDuration);

                //author 
                JLabel Author = new JLabel("By " + movieManager.movies.get(i).Director);
                Author.setBounds(5, 450, 425, 30);
                Author.setFont(new Font("Inter", Font.BOLD, 16));
                Author.setForeground(Color.white);

                moviePanel.add(Author);

                AllMovieList.add(moviePanel);
            }
        }

        //movie panel-----------------------------------
        JPanel BuyMoviePanel = CreateBuyMoviePanel(movieManager.movies.get(24));

        RoundedPanel BuySettings = new RoundedPanel(35);
        BuySettings.setBounds(x, 0, 300, 750);
        BuySettings.setLayout(null);
        BuySettings.setBackground(new Color(0x212121));

        ClientPanel.add(BuySettings);

        JPanel BlurPanel = new JPanel();
        BlurPanel.setBounds(0, 0, 1200, 750);
        BlurPanel.setBackground(Color.black);
        BlurPanel.setVisible(false);

        ClientPanel.add(BlurPanel);
    
        timer = new Timer(0, e->{
            if(x == 900){
                timer.stop();
            }
            x -= xVelocity;
            BuySettings.setBounds(x, 0, 325, 750);
        });

        ContentPanel.add(scrollPane, "home");
        ContentPanel.add(scrollPane2, "all movies");
        ContentPanel.add(BuyMoviePanel, "buy movie");
        ((CardLayout) ContentPanel.getLayout()).show(ContentPanel, "home");
        // -----------------------------------------------------------------------------------------------

        // ------------Left panel--------------------------------------------------------
        RoundedPanel LeftPanel = new RoundedPanel(35);
        LeftPanel.setBounds(25, 25, 200, 650);
        LeftPanel.setBackground(new Color(0x212121));
        LeftPanel.setLayout(null);

        ClientPanel.add(LeftPanel);
        // --------------------------------------------------------------------------------------------

        // ------------upper panel---------------------------------------------------------
        // filter button --------------
        RoundedButton FilterButton = new RoundedButton(35);
        FilterButton.setBounds(250, 25, 50, 40);
        FilterButton.setFont(new Font("Inter", Font.BOLD, 15));
        FilterButton.setBackground(new Color(0x212121));
        FilterButton.setForeground(Color.white);
        FilterButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        FilterButton.addActionListener(e -> {
            // handle filter button click
        });
        FilterButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FilterButton.setBackground(new Color(0x313131));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                FilterButton.setBackground(new Color(0x212121));
            }
        });

        ClientPanel.add(FilterButton);

        // History button -----------------
        RoundedButton HistoryButton = new RoundedButton(50);
        HistoryButton.setBounds(997, 25, 40, 40);
        HistoryButton.setFont(new Font("Inter", Font.BOLD, 15));
        HistoryButton.setBackground(new Color(0x212121));
        HistoryButton.setForeground(Color.white);
        HistoryButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        HistoryButton.addActionListener(e -> {
            // handle filter button click
        });
        HistoryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HistoryButton.setBackground(new Color(0x313131));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                HistoryButton.setBackground(new Color(0x212121));
            }
        });

        ClientPanel.add(HistoryButton);

        // account button --------------
        RoundedButton AccountButton = new RoundedButton(35);
        AccountButton.setText("user");
        AccountButton.setBounds(1081, 25, 90, 40);
        AccountButton.setFont(new Font("Inter", Font.BOLD, 15));
        AccountButton.setBackground(new Color(0x515151));
        AccountButton.setForeground(Color.white);
        AccountButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        AccountButton.addActionListener(e -> {
            // handle filter button click
        });
        AccountButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AccountButton.setBackground(new Color(0x616161));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                AccountButton.setBackground(new Color(0x515151));
            }
        });

        ClientPanel.add(AccountButton);

        // Search Bar---------------------
        RoundedPanel SearchBar = new RoundedPanel(35);
        SearchBar.setBounds(350, 25, 600, 40);
        SearchBar.setBackground(new Color(0x212121));
        SearchBar.setLayout(null);

        ClientPanel.add(SearchBar);

        JTextField SearchField = new JTextField();
        SearchField.setBounds(10, 2, 550, 35);
        SearchField.setFont(new Font("Inter", Font.BOLD, 15));
        SearchField.setForeground(Color.white);
        SearchField.setCaretColor(Color.white);
        SearchField.setOpaque(false);
        SearchField.setBorder(null);

        TextfieldBehave(SearchField, "Search for a movie");

        SearchBar.add(SearchField);

        // straight line ----------------
        JPanel StraightLine = new JPanel();
        StraightLine.setBounds(250, 85, 925, 5);
        StraightLine.setBackground(new Color(0x313131));

        ClientPanel.add(StraightLine);
        // --------------------------------------------------------------------------------------------

        ClientPanel.setComponentZOrder(LeftPanel, 2);
        ClientPanel.setComponentZOrder(StraightLine, 2);
        ClientPanel.setComponentZOrder(SearchBar, 2);
        ClientPanel.setComponentZOrder(FilterButton, 2);
        ClientPanel.setComponentZOrder(HistoryButton, 2);
        ClientPanel.setComponentZOrder(AccountButton, 2);
        ClientPanel.setComponentZOrder(ContentPanel, 3);
        ClientPanel.setComponentZOrder(BuySettings, 0);
        ClientPanel.setComponentZOrder(BlurPanel, 1);

        return ClientPanel;
    }

    public JPanel CreateBuyMoviePanel(Movie movie){
        // Home panel---------------------------------------------------------------------------
        JPanel MoviePanel = new JPanel();
        MoviePanel.setLayout(null);
        MoviePanel.setOpaque(true);
        MoviePanel.setBackground(new Color(0x121213));
        MoviePanel.setBounds(0, 0, 955, 750);

        //title----------------------------------------------------------
        JLabel MovieTitle = new JLabel("<html>" + movie.Title + "</html>");
        MovieTitle.setBounds(25, 325, 600, 50);
        MovieTitle.setForeground(Color.white);
        MovieTitle.setFont(new Font("Inter", Font.BOLD, 32));

        MoviePanel.add(MovieTitle);

        //Movie banner ---------------------------------------
        JPanel BannerPanel = new JPanel();
        BannerPanel.setBounds(75, 15, 800, 300);
        BannerPanel.setBackground(new Color(0x121213));
        BannerPanel.setLayout(null);

        MoviePanel.add(BannerPanel);

        ImageIcon imageIcon = resizedIcon(movie.ImagePath2, 800, 300);
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, 0, 800, 300);

        BannerPanel.add(imageLabel);

        //description -----------------------------------------
        JLabel DescriptionLabel = new JLabel("<html>" + movie.Description + "</html>");
        DescriptionLabel.setBounds(25, 350, 300, 200);
        DescriptionLabel.setForeground(Color.white);
        DescriptionLabel.setFont(new Font("Inter", Font.PLAIN, 15));

        MoviePanel.add(DescriptionLabel);

        //info box -----------------------------------------------------------------------------
        JPanel InfoBoxPanel = new JPanel();
        InfoBoxPanel.setBounds(350, 350, 500, 175);
        InfoBoxPanel.setBackground(new Color(0x121213));
        InfoBoxPanel.setLayout(null);
        InfoBoxPanel.setBorder(BorderFactory.createLineBorder(Color.white, 3, true));

        MoviePanel.add(InfoBoxPanel);

        JLabel InfoBoxLabel = new JLabel("<html>Genre :&nbsp;&nbsp;"+ movie.Genre + "<br>Release Date: &nbsp;&nbsp;" + movie.ReleaseDate + 
            "<br>Duration: &nbsp;&nbsp;" + movie.Duration + " hour(s)<br>Rating: &nbsp;&nbsp;"
            + movie.Rating +"/10"+ "Age rating :&nbsp;&nbsp;"+ movie.AgeRating + "<br>cast : &nbsp;&nbsp;" + movie.Cast + 
            "<br>Director : &nbsp;&nbsp;" + movie.Director + "</html>");
        InfoBoxLabel.setBounds(10, 0, 500, 175);
        InfoBoxLabel.setFont(new Font("Inter", Font.PLAIN, 18));
        InfoBoxLabel.setForeground(Color.white);

        InfoBoxPanel.add(InfoBoxLabel);

        //Buy button -------------------------------------------------------------------
        JButton BuyButton = new JButton("Buy Ticket");
        BuyButton.setBounds(25, 545, 150, 50);
        BuyButton.setFont(new Font("Inter", Font.BOLD, 18));
        BuyButton.setForeground(Color.black);
        BuyButton.setBackground(new Color(0xDDDDDD));
        BuyButton.setUI(new RoundButtonUI(new Color(0x000000)));
        BuyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        BuyButton.addActionListener(e -> {
            // handle buy button click
            
            if(x == 900){
                return;
            }else{
                timer.start();
            }
        });
        BuyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BuyButton.setBackground(new Color(0x717171));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                BuyButton.setBackground(new Color(0xDDDDDD));
            }
        });

        MoviePanel.add(BuyButton);

        //more info button ------------------------------------------------------------
        JButton TraillerButton = new JButton("What trailler");
        TraillerButton.setBounds(200, 545, 150, 50);
        TraillerButton.setFont(new Font("Inter", Font.BOLD, 18));
        TraillerButton.setForeground(Color.white);
        TraillerButton.setBackground(new Color(0x000000));
        TraillerButton.setUI(new RoundButtonUI(new Color(0x000000)));
        TraillerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        TraillerButton.addActionListener(e -> {
            // handle more info button click
        });
        TraillerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TraillerButton.setBackground(new Color(0x212121));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                TraillerButton.setBackground(new Color(0x000000));
            }
        });

        MoviePanel.add(TraillerButton);


        return MoviePanel;
    }
    
    // handle events-----------------------------------------------------------------
    public void HandleLogIn(String email, String password) {
        // handle log in
    }

    public void HandleSignIn(JTextField username, JPasswordField password, JTextField email, JTextField cardNumber,
            JTextField ccvnbr, JTextField PhoneNumber) {
        // handle SignIn
    }

    public ImageIcon resizedIcon(String path, int width, int height) { // hadi bch tbdl l img l size li rak habo w trj3
                                                                       // direct ImageIcon t7yo direct f label ou f
                                                                       // button

        ImageIcon icon = new ImageIcon(path);
        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(image);

        return resizedIcon;
    }

    public void validateInput(JTextField textField, String regex) { // hadi tcoloriyi l border ta3 textfield 3la hsab
                                                                    // type li rak hab l user ydkhlo f textfield

        String input = textField.getText().trim();
        if (input.equals("   Movie Name") || input.equals("   Film duration") ||
                input.equals("   Film Rating") || input.equals("0da")) {
            textField.setBorder(BorderFactory.createLineBorder(new Color(80, 77, 74)));
            return;
        }

        if (input.matches(regex)) {
            textField.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        } else {
            textField.setBorder(BorderFactory.createLineBorder(Color.RED));
            // JOptionPane.showMessageDialog(this, "Please enter a valid input", "Error",
            // JOptionPane.ERROR_MESSAGE);
        }
    }

    public void TextAreaBehave(JTextArea textField, String placeholder) {// hadi tktb dakhel l textarea ida makach focus
                                                                         // 3lih ida kayen tfasi klch ida tnha l focus w
                                                                         // user maktb walo t3awed tktb wch kan fiha
        textField.setText(placeholder);

        textField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (textField.getText().equals(placeholder)) {
                    SwingUtilities.invokeLater(() -> {
                        textField.setText("");
                    });
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (textField.getText().isEmpty()) {
                    SwingUtilities.invokeLater(() -> {
                        textField.setText(placeholder);
                    });
                }
            }
        });
    }

    public void TextfieldBehave(JTextField textField, String placeholder) {// kima TextAreaBehave nrk hadi 3la textfield
                                                                           // mais brk
        textField.setText(placeholder);

        textField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (textField.getText().equals(placeholder)) {
                    SwingUtilities.invokeLater(() -> {
                        textField.setText("");
                    });
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (textField.getText().isEmpty()) {
                    SwingUtilities.invokeLater(() -> {
                        textField.setText(placeholder);
                    });
                }
            }
        });
    }

    public static void main(String[] args) {
        try {
            CinemaApp Frame = new CinemaApp();
            Frame.setVisible(true);

            // Revalidate and repaint to ensure the SettingsPanel is displayed
            Frame.revalidate();
            Frame.repaint();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}

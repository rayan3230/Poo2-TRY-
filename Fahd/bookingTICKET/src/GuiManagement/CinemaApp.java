package GuiManagement;

import MainClasses.*;
import Personnel.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CinemaApp extends JFrame implements ActionListener {

    // main panel -----------------------------------------------------
    public JPanel MainPanel;

    // Action manager--------------------------------------------------
    public static int Counter = 0;

    // cinema manager---------------------------------------------------
    public Cinema CinemaManager;
    public Client ClientUser;
    public Admin AdminUser;

    // log in elements :
    public JPanel LogInPanel;
    public JPanel SignInPanel;
    public JPanel RegisterPanel;
    public JPanel ForgotPasswordPanel;
    public JPanel ClientPanel;
    public JPanel AdminPanel;

    //fonctionnalities elements ---------------------------------------
    public Timer timer, timer2, timer3, timer4;
    public JButton ChangeTheme;
    public int x = -300;
    public int xVelocity = 30;
    public int x2 = -300;
    public int x2Velocity = 30;

    // decorative Panels ------------------------------------------------
    public TransparentPanel BlurPanel, BlurPanel2, BlurPanel3;

    // layout manager -----------------------------------------------------
    public CardLayout MainCardLayout;

    public CinemaApp() {

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

        CinemaManager = new Cinema();

        // openning panel --------------------------------------------------
        SignInPanel = new JPanel();
        SignInPanel.setBounds(0, 0, 1200, 750);
        SignInPanel.setLayout(null);
        SignInPanel.setOpaque(false);

        JPanel SignInBackgroundPanel = CreateBackGround1Panel();
        JPanel SignInElements = CreateSignInElementsPanel();

        SignInPanel.add(SignInBackgroundPanel);
        SignInPanel.add(SignInElements);

        SignInPanel.setComponentZOrder(SignInElements, 0);
        SignInPanel.setComponentZOrder(SignInBackgroundPanel, 1);

        // sign in panel ---------------------------------------------------
        RegisterPanel = new JPanel();
        RegisterPanel.setBounds(0, 0, 1200, 750);
        RegisterPanel.setLayout(null);
        RegisterPanel.setOpaque(false);

        JPanel RegisterBackgroundJPanel = CreateBackGround1Panel();
        JPanel RegisterElements = CreateRegisterElements();

        RegisterPanel.add(RegisterBackgroundJPanel);
        RegisterPanel.add(RegisterElements);

        RegisterPanel.setComponentZOrder(RegisterElements, 0);
        RegisterPanel.setComponentZOrder(RegisterBackgroundJPanel, 1);

        // log in panel ----------------------------------------------------
        LogInPanel = new JPanel();
        LogInPanel.setBounds(0, 0, 1200, 750);
        LogInPanel.setLayout(null);
        LogInPanel.setOpaque(false);

        JPanel LogInBackgroundJPanel = CreateBackGround1Panel();
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

        JPanel ForgotPasswordBackground = CreateBackGround1Panel();
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

        // main panel management-----------------------------------------------
        MainPanel.add(SignInPanel, "open");
        MainPanel.add(RegisterPanel, "register");
        MainPanel.add(LogInPanel, "log in");
        MainPanel.add(ForgotPasswordPanel, "forgot Password");
        MainPanel.add(ClientPanel, "user");
        MainPanel.add(AdminPanel, "admin");

        setContentPane(MainPanel);
        MainCardLayout.show(MainPanel, "user");

        // Revalidate and repaint to ensure the SettingsPanel is displayed
        this.revalidate();
        this.repaint();
    }

    public JPanel CreateBackGround1Panel() {

        JPanel BackgroundPanel = new JPanel();
        BackgroundPanel.setBounds(0, 0, 1200, 750);
        BackgroundPanel.setLayout(null);
        BackgroundPanel.setOpaque(false);

        // Blur panel--------------------------------------------------
        this.BlurPanel = new TransparentPanel(0.5f);
        BlurPanel.setBounds(0, 0, 1200, 750);
        BlurPanel.setLayout(null);
        BlurPanel.setBackground(new java.awt.Color(0x2D3142));

        BlurPanel.setVisible(true);

        // The background image:
        ImageIcon originalIcon = new ImageIcon(
                "Poo2-TRY-\\Fahd\\bookingTICKET\\Images\\MilesBackground.png");
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

    public JPanel CreateBackGround2Panel() {

        JPanel BackgroundPanel = new JPanel();
        BackgroundPanel.setBounds(0, 0, 1200, 750);
        BackgroundPanel.setLayout(null);
        BackgroundPanel.setOpaque(false);

        // Blur panel--------------------------------------------------
        this.BlurPanel2 = new TransparentPanel(0.5f);
        BlurPanel2.setBounds(0, 0, 1200, 750);
        BlurPanel2.setLayout(null);
        BlurPanel2.setBackground(new java.awt.Color(0x000000));

        BlurPanel2.setVisible(true);

        // The background image:
        ImageIcon originalIcon = new ImageIcon(
                "Poo2-TRY-\\Fahd\\bookingTICKET\\Images\\MilesBackground2.png");
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
        BackgroundPanel.add(BlurPanel2);

        BackgroundPanel.setComponentZOrder(Background, 2);
        BackgroundPanel.setComponentZOrder(BlurPanel2, 0);
        BackgroundPanel.setComponentZOrder(BluePanel, 0);
        BackgroundPanel.setComponentZOrder(RedPanel, 1);

        return BackgroundPanel;
    }

    public JPanel CreateBackGround3Panel() {
        JPanel BackgroundPanel = new JPanel();
        BackgroundPanel.setBounds(0, 0, 1200, 750);
        BackgroundPanel.setLayout(null);
        BackgroundPanel.setOpaque(false);

        // Blur panel--------------------------------------------------
        this.BlurPanel3 = new TransparentPanel(0.4f);
        BlurPanel3.setBounds(0, 0, 1200, 750);
        BlurPanel3.setLayout(null);
        BlurPanel3.setBackground(new java.awt.Color(0x000000));

        BlurPanel3.setVisible(true);

        // The background image:
        ImageIcon originalIcon = new ImageIcon("Poo2-TRY-\\Fahd\\bookingTICKET\\Images\\IntoTheSpiderVerse.jpg");
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
        BackgroundPanel.add(BlurPanel3);

        BackgroundPanel.setComponentZOrder(Background, 2);
        BackgroundPanel.setComponentZOrder(BlurPanel3, 0);
        BackgroundPanel.setComponentZOrder(BluePanel, 0);
        BackgroundPanel.setComponentZOrder(RedPanel, 1);

        return BackgroundPanel;
    }

    public JPanel CreateSignInElementsPanel() {
        // sign in elements panel ------------------------------------
        JPanel SignInElements = new JPanel();
        SignInElements.setBounds(0, 0, 1200, 750);
        SignInElements.setLayout(null);
        SignInElements.setOpaque(false);

        JLabel LogoName = new JLabel("POOMovie");
        LogoName.setBounds(70, 24, 192, 52);
        LogoName.setFont(new Font("Inter", Font.BOLD, 35));
        LogoName.setForeground(new Color(0xFF6700));

        SignInElements.add(LogoName);

        ImageIcon iconMovie = new ImageIcon("Poo2-TRY-/Rayan/bookingTICKET/img/movie.png");
        JLabel imageLabel = new JLabel(iconMovie);
        imageLabel.setBounds(10, 20, 64, 64);

        SignInElements.add(imageLabel);

        JLabel WelcomText1 = new JLabel("Unlimited films in theaters,");// and more to come
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

        LogIn.addActionListener(e -> {
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

        ChangeTheme = new JButton("Change theme");
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

        ChangeTheme.addActionListener(e -> {

            if (Counter % 2 == 0) {

                ChangeTheme.setBackground(new java.awt.Color(0x000000));
                ChangeTheme.setForeground(Color.WHITE);
                WelcomText1.setForeground(new java.awt.Color(0x000000));
                WelcomText2.setForeground(new java.awt.Color(0x000000));
                DescriptionText.setForeground(new java.awt.Color(0x000000));
                AdressInput.setBackground(new java.awt.Color(0xBBBBBB));
                AdressInput.setForeground(Color.BLACK);
            } else {

                ChangeTheme.setBackground(new java.awt.Color(0xFFFFFF));
                ChangeTheme.setForeground(Color.BLACK);
                WelcomText1.setForeground(new java.awt.Color(0xFFFFFF));
                WelcomText2.setForeground(new java.awt.Color(0xFFFFFF));
                DescriptionText.setForeground(new java.awt.Color(0xFFFFFF));
                AdressInput.setBackground(new java.awt.Color(0x222222));
                AdressInput.setForeground(Color.WHITE);
            }
            this.actionPerformed(e);
        });

        SignInElements.add(ChangeTheme);

        return SignInElements;
    }

    public JPanel CreateLogInElementsPanel() {
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

        TransparentPanel RectangleLogin = new TransparentPanel(0.9f);
        RectangleLogin.setBounds(400, 100, 440, 620);
        RectangleLogin.setLayout(null);
        RectangleLogin.setBackground(Color.black);
        loginPanel.add(RectangleLogin);

        JLabel LogInLabel = new JLabel("Log In");
        LogInLabel.setBounds(50, 40, 200, 50);
        LogInLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        LogInLabel.setForeground(Color.white);
        RectangleLogin.add(LogInLabel);

        JTextField EmailField = new JTextField("   Email or username or phone number");
        EmailField.setBounds(50, 120, 340, 40);
        EmailField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        EmailField.setForeground(Color.white);
        EmailField.setCaretColor(Color.white);
        // EmailField.setBackground(new Color(80, 77, 74, 230));
        EmailField.setBackground(new Color(0x444444));
        EmailField.setOpaque(true);

        EmailField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (EmailField.getText().equals("   Email or username or phone number")) {
                    EmailField.setText("");
                    EmailField.setForeground(Color.white);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (EmailField.getText().isEmpty() || EmailField.getText().trim().isEmpty()) {
                    EmailField.setText("Type to Search...");
                    EmailField.setForeground(Color.white);
                }
            }

        });

        RectangleLogin.add(EmailField);

        JPasswordField PasswordField = new JPasswordField("Password");
        PasswordField.setBounds(50, 200, 340, 40);
        PasswordField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        PasswordField.setForeground(Color.white);
        PasswordField.setCaretColor(Color.white);
        // PasswordField.setBackground(new Color(80, 77, 74, 230));
        PasswordField.setBackground(new Color(0x444444));
        PasswordField.setOpaque(true);
        PasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (PasswordField.getText().equals("Password")) {
                    PasswordField.setText("");
                    PasswordField.setForeground(Color.white);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (PasswordField.getText().isEmpty() || PasswordField.getPassword().length == 0) {
                    PasswordField.setText("Password");
                    PasswordField.setForeground(Color.white);
                }
            }
        });
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
        returnbtnWelcomePanel.setBackground(new java.awt.Color(0x777777));
        returnbtnWelcomePanel.setForeground(Color.white);
        returnbtnWelcomePanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        returnbtnWelcomePanel.setBorder(BorderFactory.createEmptyBorder());
        returnbtnWelcomePanel.setUI(new RoundButtonUI(new Color(0x000000)));
        returnbtnWelcomePanel.addActionListener(e -> {
            MainCardLayout.show(MainPanel, "open");
        });
        RectangleLogin.add(returnbtnWelcomePanel);

        return loginPanel;

    }

    public JPanel CreateRegisterElements() {

        // Finish signing in panel ------------------------------------------------
        JPanel RegisterElements = new JPanel();
        RegisterElements.setBounds(0, 0, 1200, 750);
        RegisterElements.setLayout(null);
        RegisterElements.setOpaque(false);

        JLabel LogoName = new JLabel("POOMovie");
        LogoName.setBounds(70, 24, 192, 52);
        LogoName.setFont(new Font("Inter", Font.BOLD, 35));
        LogoName.setForeground(Color.red);

        RegisterElements.add(LogoName);

        ImageIcon iconMovie = new ImageIcon("Poo2-TRY-/Rayan/bookingTICKET/img/movie.png");
        JLabel imageLabel = new JLabel(iconMovie);
        imageLabel.setBounds(10, 20, 64, 64);

        RegisterElements.add(imageLabel);

        // signUP panel -----------------------------------------------------------
        TransparentPanel SignUpPanel = new TransparentPanel(0.9f);
        SignUpPanel.setBounds(400, 100, 440, 620);
        SignUpPanel.setLayout(null);
        SignUpPanel.setBackground(Color.black);

        JLabel SigninLabel = new JLabel("Sign In");
        SigninLabel.setBounds(50, 40, 200, 50);
        SigninLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        SigninLabel.setForeground(Color.white);

        SignUpPanel.add(SigninLabel);

        JTextField UserNameField = new JTextField("    Username");
        UserNameField.setBounds(50, 120, 340, 40);
        UserNameField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        UserNameField.setForeground(Color.gray);
        UserNameField.setCaretColor(Color.white);
        UserNameField.setBackground(new Color(0x444444));
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
        SignUpPanel.add(UserNameField);

        JPasswordField PasswordsField = new JPasswordField("    Password");
        PasswordsField.setBounds(50, 200, 340, 40);
        PasswordsField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        PasswordsField.setForeground(Color.gray);
        PasswordsField.setCaretColor(Color.white);
        PasswordsField.setBackground(new Color(0x444444));
        PasswordsField.setOpaque(true);
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
        SignUpPanel.add(PasswordsField);

        JTextField EmailField = new JTextField("   email@example.com");
        EmailField.setBounds(50, 280, 340, 40);
        EmailField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        EmailField.setForeground(Color.gray);
        EmailField.setCaretColor(Color.white);
        EmailField.setBackground(new Color(0x444444));
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
        SignUpPanel.add(EmailField);

        JTextField CardNmbrField = new JTextField("   Card Number");
        CardNmbrField.setBounds(50, 360, 340, 40);
        CardNmbrField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        CardNmbrField.setForeground(Color.gray);
        CardNmbrField.setCaretColor(Color.white);
        CardNmbrField.setBackground(new Color(0x444444));
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
        SignUpPanel.add(CardNmbrField);

        JTextField CCVNmbrField = new JTextField("   CCV Number");
        CCVNmbrField.setBounds(50, 440, 340, 40);
        CCVNmbrField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        CCVNmbrField.setForeground(Color.gray);
        CCVNmbrField.setCaretColor(Color.white);
        CCVNmbrField.setBackground(new Color(0x444444));
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
        SignUpPanel.add(CCVNmbrField);

        JButton ConfirmSignUpButton = new JButton("sign up");
        ConfirmSignUpButton.setBounds(250, 520, 180, 50);
        ConfirmSignUpButton.setForeground(Color.white);
        ConfirmSignUpButton.setFocusPainted(false);
        ConfirmSignUpButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        ConfirmSignUpButton.setBackground(Color.red);
        ConfirmSignUpButton.setBorder(null);
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
        ReturnBtn.setBorder(null);
        ReturnBtn.setUI(new RoundButtonUI(new Color(0x000000)));
        ReturnBtn.addActionListener(e -> {
            MainCardLayout.show(MainPanel, "open");
        });
        SignUpPanel.add(ReturnBtn);

        RegisterElements.add(SignUpPanel);

        return RegisterElements;
    }

    public JPanel CreateForgotPasswordPanel() {
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

    public void ChnageTheme() {
        if (Counter % 2 == 0) {
            Counter++;
            this.BlurPanel.setBackground(new java.awt.Color(0xFFFFFF));
            return;

        } else {
            Counter++;
            this.BlurPanel.setBackground(new java.awt.Color(0x000000));
            return;
        }
    }

    
    public boolean HandleLogIn(String email, String password ){
        if (CinemaManager.isAdmin(email, password)) {
            JOptionPane.showMessageDialog(null, "Welcome Admin!", "Success",
            JOptionPane.INFORMATION_MESSAGE);
            AdminUser = CinemaManager.getAdmin(email, password);
            MainCardLayout.show(MainPanel, "admin");
            return true;
        }
        
        if (CinemaManager.isClient(email, password)) {
            JOptionPane.showMessageDialog(null, "Welcome Admin!", "Success",
            JOptionPane.INFORMATION_MESSAGE);
            ClientUser = CinemaManager.getClient(email, password);
            MainCardLayout.show(MainPanel, "user");
            return true;

        }

        JOptionPane.showMessageDialog(null, "Invalid username or password!", "Error",
        JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
    public boolean HandleSignIn(JTextField username, JPasswordField password, JTextField email, JTextField cardNumber, 
        JTextField ccvnbr, JTextField PhoneNumber){
        try {
        
            if (!CinemaManager.isClient(username.getText(), new String(password.getPassword()))) {
           
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

                ClientUser = new Client(username.getText(), username.getText(), email.getText(), PhoneNumber.getText(), 
                    username.getText(), new String(password.getPassword()));

                ClientUser.cardNum = cardNum;
                ClientUser.CCVnbr = CCVnbr;

                CinemaManager.addClient(ClientUser);
    
                JOptionPane.showMessageDialog(null, "Account created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                
                MainCardLayout.show(MainPanel, "log in");
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
     

    public JPanel CreateClientInterface() {

        CardLayout layout = new CardLayout();


        JPanel HomePanel = new JPanel(layout);
        HomePanel.setLayout(null);
        HomePanel.setBounds(0, 0, 1200, 750);
        HomePanel.setOpaque(true);
        HomePanel.setBackground(new Color(0x0D1116));

        JPanel LeftPanel = new JPanel();
        LeftPanel.setBounds(0,0, 100, 750);
        LeftPanel.setBackground(new Color(0x191D22));
        LeftPanel.setLayout(null);

        HomePanel.add(LeftPanel);

        JButton HomeButton = new JButton();
        HomeButton.setBounds(30, 20, 40, 40);

        ImageIcon originalIcon6 = new ImageIcon(
                "Poo2-TRY-\\Fahd\\bookingTICKET\\Images\\home (1).png");
        Image originalImage6 = originalIcon6.getImage();
        Image scaledImage6 = originalImage6.getScaledInstance(20, 20,
                Image.SCALE_SMOOTH);
        ImageIcon scaledIcon6 = new ImageIcon(scaledImage6);

        HomeButton.setIcon(scaledIcon6);
        HomeButton.setBackground(new Color(0xCBCBCB));
        HomeButton.setForeground(new Color(0x191D22));
        HomeButton.setFont(new Font("Inter", Font.BOLD, 15));
        HomeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        HomeButton.setUI(new RoundButtonUI(new Color(0x000000)));
        HomeButton.addActionListener(e->{

        });

        TransparentPanel HoverHome = new TransparentPanel(0.5f);
        HoverHome.setBounds(0, 25, 7, 25);
        HoverHome.setVisible(false);
        HoverHome.setBackground(new Color(0x878787));

        LeftPanel.add(HoverHome);


        HomeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HomeButton.setBackground(new Color(0x878787));
                HoverHome.setVisible(true);

            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                HomeButton.setBackground(new Color(0xCBCBCB));
                HoverHome.setVisible(false);
            }
        });

        LeftPanel.add(HomeButton);
        


        JButton AllButton = new JButton();
        AllButton.setBounds(30, 210, 40, 40);

        ImageIcon originalIcon = new ImageIcon(
                "Poo2-TRY-\\Fahd\\bookingTICKET\\Images\\all.png");
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(20, 20,
                Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        AllButton.setIcon(scaledIcon);
        AllButton.setBackground(new Color(0xCBCBCB));
        AllButton.setForeground(new Color(0x191D22));
        AllButton.setFont(new Font("Inter", Font.BOLD, 15));
        AllButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        AllButton.setUI(new RoundButtonUI(new Color(0x000000)));
        AllButton.setContentAreaFilled(false); // Make the button background transparent
        AllButton.setBorderPainted(false); // Remove the button border
        AllButton.setFocusPainted(false); // Remove the focus border
        AllButton.addActionListener(e->{

        });

        TransparentPanel HoverAll = new TransparentPanel(0.5f);
        HoverAll.setBounds(0, 215, 7, 25);
        HoverAll.setVisible(false);
        HoverAll.setBackground(new Color(0x878787));

        LeftPanel.add(HoverAll);


        AllButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AllButton.setBackground(new Color(0x878787));
                HoverAll.setVisible(true);

            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                AllButton.setBackground(new Color(0xCBCBCB));
                HoverAll.setVisible(false);
            }
        });

        LeftPanel.add(AllButton);



        JButton MyTicketButton = new JButton();

        MyTicketButton.setBounds(30, 280, 40, 40);
        ImageIcon originalIcon2 = new ImageIcon(
                "Poo2-TRY-\\Fahd\\bookingTICKET\\Images\\ticket.png");
        Image originalImage2 = originalIcon2.getImage();
        Image scaledImage2 = originalImage2.getScaledInstance(20, 20,
                Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);

        MyTicketButton.setIcon(scaledIcon2);
        MyTicketButton.setBackground(new Color(0xCBCBCB));
        MyTicketButton.setForeground(new Color(0x191D22));
        MyTicketButton.setFont(new Font("Inter", Font.BOLD, 15));
        MyTicketButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        MyTicketButton.setUI(new RoundButtonUI(new Color(0x000000)));

        TransparentPanel HoverTicket = new TransparentPanel(0.5f);
        HoverTicket.setBounds(0, 285, 7, 25);
        HoverTicket.setVisible(false);
        HoverTicket.setBackground(new Color(0x878787));

        LeftPanel.add(HoverTicket);


        MyTicketButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MyTicketButton.setBackground(new Color(0x878787));
                HoverTicket.setVisible(true);

            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                MyTicketButton.setBackground(new Color(0xCBCBCB));
                HoverTicket.setVisible(false);
            }
        });

        LeftPanel.add(MyTicketButton);



        JButton BalanceButton = new JButton();
        BalanceButton.setBounds(30, 350, 40, 40);

        ImageIcon originalIcon3 = new ImageIcon(
            "Poo2-TRY-\\Fahd\\bookingTICKET\\Images\\dollar.png");
        Image originalImage3 = originalIcon3.getImage();
        Image scaledImage3 = originalImage3.getScaledInstance(20, 20,
                Image.SCALE_SMOOTH);
        ImageIcon scaledIcon3 = new ImageIcon(scaledImage3);

        BalanceButton.setIcon(scaledIcon3);
        BalanceButton.setBackground(new Color(0xAD3000));
        BalanceButton.setForeground(new Color(0x191D22));
        BalanceButton.setFont(new Font("Inter", Font.BOLD, 14));
        BalanceButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BalanceButton.setUI(new RoundButtonUI(new Color(0x000000)));

        TransparentPanel HoverBalance = new TransparentPanel(0.5f);
        HoverBalance.setBounds(0, 355, 7, 25);
        HoverBalance.setVisible(false);
        HoverBalance.setBackground(new Color(0xFF0000));

        LeftPanel.add(HoverBalance);


        BalanceButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BalanceButton.setBackground(new Color(0x550000));
                HoverBalance.setVisible(true);

            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                BalanceButton.setBackground(new Color(0xAD3000));
                HoverBalance.setVisible(false);
            }
        });

        LeftPanel.add(BalanceButton);



        JButton FilterButton = new JButton();
        FilterButton.setBounds(30, 490, 40, 40);

        ImageIcon originalIcon4 = new ImageIcon(
            "Poo2-TRY-\\Fahd\\bookingTICKET\\Images\\filter.png");
        Image originalImage4 = originalIcon4.getImage();
        Image scaledImage4 = originalImage4.getScaledInstance(20, 20,
                Image.SCALE_SMOOTH);
        ImageIcon scaledIcon4 = new ImageIcon(scaledImage4);

        FilterButton.setIcon(scaledIcon4);
        FilterButton.setBackground(new Color(0xA96E00));
        FilterButton.setForeground(new Color(0x191D22));
        FilterButton.setFont(new Font("Inter", Font.BOLD, 15));
        FilterButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        FilterButton.setUI(new RoundButtonUI(new Color(0x000000)));

        TransparentPanel HoverFilter = new TransparentPanel(0.5f);
        HoverFilter.setBounds(0, 495, 7, 25);
        HoverFilter.setVisible(false);
        HoverFilter.setBackground(new Color(0xFFFF00));

        LeftPanel.add(HoverFilter);


        FilterButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FilterButton.setBackground(new Color(0x652B00));
                HoverFilter.setVisible(true);

            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                FilterButton.setBackground(new Color(0xA96E00));
                HoverFilter.setVisible(false);
            }
        });

        LeftPanel.add(FilterButton);



        JButton ChangeTheme = new JButton();
        ChangeTheme.setBounds(30, 420, 40, 40);

        ImageIcon originalIcon5 = new ImageIcon(
            "Poo2-TRY-\\Fahd\\bookingTICKET\\Images\\themes.png");
        Image originalImage5 = originalIcon5.getImage();
        Image scaledImage5 = originalImage5.getScaledInstance(20, 20,
                Image.SCALE_SMOOTH);
        ImageIcon scaledIcon5 = new ImageIcon(scaledImage5);

        ChangeTheme.setIcon(scaledIcon5);
        ChangeTheme.setBackground(new Color(0xA96E00));
        ChangeTheme.setForeground(new Color(0x191D22));
        ChangeTheme.setFont(new Font("Inter", Font.BOLD, 15));
        ChangeTheme.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ChangeTheme.setUI(new RoundButtonUI(new Color(0x000000)));

        TransparentPanel HoverTheme = new TransparentPanel(0.5f);
        HoverTheme.setBounds(0, 425, 7, 25);
        HoverTheme.setVisible(false);
        HoverTheme.setBackground(new Color(0xFFFF00));

        LeftPanel.add(HoverTheme);


        ChangeTheme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ChangeTheme.setBackground(new Color(0x652B00));
                HoverTheme.setVisible(true);

            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                ChangeTheme.setBackground(new Color(0xA96E00));
                HoverTheme.setVisible(false);
            }
        });

        LeftPanel.add(ChangeTheme);


        TransparentPanel AccountPanel = new TransparentPanel(0.2f);
        AccountPanel.setBounds(1050, 15, 125, 50);
        AccountPanel.setBackground(Color.white);
        AccountPanel.setLayout(null);

        HomePanel.add(AccountPanel);


        JButton AccountButton = new JButton();
        AccountButton.setBounds(75, 5, 40, 40);

        ImageIcon originalIcon7 = new ImageIcon(
            "Poo2-TRY-\\Fahd\\bookingTICKET\\Images\\profile-user.png");
        Image originalImage7 = originalIcon7.getImage();
        Image scaledImage7 = originalImage7.getScaledInstance(20, 20,
                Image.SCALE_SMOOTH);
        ImageIcon scaledIcon7 = new ImageIcon(scaledImage7);

        AccountButton.setIcon(scaledIcon7);
        AccountButton.setBackground(new Color(0xCBCBCB));
        AccountButton.setForeground(new Color(0x191D22));
        AccountButton.setFont(new Font("Inter", Font.BOLD, 15));
        AccountButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        AccountButton.setUI(new RoundButtonUI(new Color(0x000000)));

        AccountPanel.add(AccountButton);



        JButton LogOutButton = new JButton();
        LogOutButton.setBounds(10, 5, 40, 40);

        ImageIcon originalIcon8 = new ImageIcon(
            "Poo2-TRY-\\Fahd\\bookingTICKET\\Images\\exit.png");
        Image originalImage8 = originalIcon8.getImage();
        Image scaledImage8 = originalImage8.getScaledInstance(20, 20,
                Image.SCALE_SMOOTH);
        ImageIcon scaledIcon8 = new ImageIcon(scaledImage8);

        LogOutButton.setIcon(scaledIcon8);
        LogOutButton.setBackground(new Color(0xAD2500));
        LogOutButton.setForeground(new Color(0x191D22));
        LogOutButton.setFont(new Font("Inter", Font.BOLD, 15));
        LogOutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        LogOutButton.setUI(new RoundButtonUI(new Color(0x000000)));

        AccountPanel.add(LogOutButton);



        //content panel---------------------------------------------------------------
        JPanel ContentPanel = CreateContentPanel();

        JScrollPane scrollPane = new JScrollPane(ContentPanel);
        scrollPane.setBounds(99, 0, 1125, 750);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setBackground(new Color(0x0D1116));

        ContentPanel.addMouseWheelListener(e -> {
            JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();// had scroll par rapport l y
            int notches = e.getWheelRotation();
            int currentValue = verticalScrollBar.getValue();
            int scrollAmount = 30; // Adjust scroll speed
            verticalScrollBar.setValue(currentValue + (notches * scrollAmount));
        });

        //movie panel----------------------------------------------------------------------
        JPanel moviePanel = CreateMoviePanel();

        JScrollPane scrollPane2 = new JScrollPane(moviePanel);
        scrollPane2.setBounds(99, 0, 1125, 750);
        scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane2.setOpaque(false);
        scrollPane2.getViewport().setBackground(new Color(0x0D1116));

        moviePanel.addMouseWheelListener(e -> {
            JScrollBar verticalScrollBar = scrollPane2.getVerticalScrollBar();// had scroll par rapport l y
            int notches = e.getWheelRotation();
            int currentValue = verticalScrollBar.getValue();
            int scrollAmount = 30; // Adjust scroll speed
            verticalScrollBar.setValue(currentValue + (notches * scrollAmount));
        });

        
        HomePanel.add(scrollPane, "home");
        scrollPane.setVisible(true);
        HomePanel.add(scrollPane2, "movies");
        scrollPane2.setVisible(false);

        if(scrollPane2.isVisible() == true){
            FilterButton.setVisible(true);
        }else{
            FilterButton.setVisible(false);
        }

        HomePanel.setComponentZOrder(scrollPane, 1);
        HomePanel.setComponentZOrder(scrollPane2, 1);
        HomePanel.setComponentZOrder(LeftPanel, 0);
        HomePanel.setComponentZOrder(AccountPanel, 0);


        return HomePanel;
    }

    public JPanel CreateContentPanel(){

        JPanel ContentPanel = new JPanel();
        //ContentPanel.setLayout(new ScrollPaneLayout());
        ContentPanel.setOpaque(false);
        ContentPanel.setLayout(null);
        ContentPanel.setPreferredSize(new Dimension(1125, 3500));

        JLabel Home = new JLabel("Home ");
        Home.setBounds(75, 10, 750, 30);
        Home.setFont(new Font("Segoe UI", Font.BOLD, 32));
        Home.setForeground(Color.white);

        ContentPanel.add(Home);

        JLabel PopularLabel = new JLabel("Most popular films right now");
        PopularLabel.setBounds(75, 75, 750, 30);
        PopularLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        PopularLabel.setForeground(Color.white);

        ContentPanel.add(PopularLabel);

        // Films Grid Section
        JPanel MostPopular = new JPanel();
        MostPopular.setLayout(new GridLayout(1, 3, 30, 20));  // Unlimited rows, 4 columns
        MostPopular.setBackground(new Color(0x0D1116));
        MostPopular.setBounds(75, 115, 750, 150);

        for (int i = 0; i <3; i++) { // hna lazem nhto les film f arrays list w nhsbo la longeur ta3hom

            JPanel FilmInfo = new JPanel();
            FilmInfo.setLayout(null);
            FilmInfo.setBackground(new Color(0x191D22));
            FilmInfo.setLayout(null);
            
            // Hayla hadi :-)
            FilmInfo.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    FilmInfo.setBorder(BorderFactory.createLineBorder(new Color(0xFF6700), 3));// ta3 ki t intiracti m3a l panel
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    FilmInfo.setBorder(null);
                }

                public void mouseClicked(java.awt.event.MouseEvent evt) {

                    JOptionPane.showMessageDialog(null, "Opening film details...");
                }
            });

            MostPopular.add(FilmInfo);
        }

        ContentPanel.add(MostPopular);
        
        JLabel BestRated = new JLabel("best rated films ");
        BestRated.setBounds(75, 350, 750, 30);
        BestRated.setFont(new Font("Segoe UI", Font.BOLD, 20));
        BestRated.setForeground(Color.white);

        ContentPanel.add(BestRated);

        JPanel BestRatedPanel = new JPanel();
        BestRatedPanel.setBounds(75, 390, 950, 500);
        BestRatedPanel.setLayout(null);
        BestRatedPanel.setBackground(new Color(0x191D22));

        BestRatedPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BestRatedPanel.setBorder(BorderFactory.createLineBorder(new Color(0xFF6700), 3));// ta3 ki t intiracti m3a l panel
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                BestRatedPanel.setBorder(null);
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {

                JOptionPane.showMessageDialog(null, "Opening film details...");
            }
        });

        ContentPanel.add(BestRatedPanel);

        JLabel ExploreMore = new JLabel("Explore more films ");
        ExploreMore.setBounds(75, 950, 750, 30);
        ExploreMore.setFont(new Font("Segoe UI", Font.BOLD, 20));
        ExploreMore.setForeground(Color.white);

        ContentPanel.add(ExploreMore);

        JPanel ExploreMorePanel = new JPanel();
        ExploreMorePanel.setLayout(new GridLayout(0, 4, 20, 20));  // Unlimited rows, 4 columns
        ExploreMorePanel.setBackground(new Color(0x0D1116));
        ExploreMorePanel.setBounds(75, 990, 950, 750);

        for (int i = 0; i <12; i++) { // hna lazem nhto les film f arrays list w nhsbo la longeur ta3hom

            JPanel FilmInfo = new JPanel();
            FilmInfo.setLayout(null);
            FilmInfo.setBackground(new Color(0x191D22));
            FilmInfo.setLayout(null);
            
            // Hayla hadi :-)
            FilmInfo.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    FilmInfo.setBorder(BorderFactory.createLineBorder(new Color(0xFF6700), 3));// ta3 ki t intiracti m3a l panel
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    FilmInfo.setBorder(null);
                }

                public void mouseClicked(java.awt.event.MouseEvent evt) {

                    JOptionPane.showMessageDialog(null, "Opening film details...");
                }
            });

            ExploreMorePanel.add(FilmInfo);
        }

        ContentPanel.add(ExploreMorePanel);

        JLabel Promos = new JLabel("Promos ");
        Promos.setBounds(75, 1900, 750, 30);
        Promos.setFont(new Font("Segoe UI", Font.BOLD, 22));
        Promos.setForeground(Color.white);

        ContentPanel.add(Promos);

        JPanel PromosPanel1 = new JPanel();
        PromosPanel1.setBounds(75, 1940, 460, 400);
        PromosPanel1.setLayout(null);
        PromosPanel1.setBackground(new Color(0x191D22));
        PromosPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PromosPanel1.setBorder(BorderFactory.createLineBorder(new Color(0xFF6700), 3));// ta3 ki t intiracti m3a l panel
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                PromosPanel1.setBorder(null);
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {

                JOptionPane.showMessageDialog(null, "Opening promotion details...");
            }
        });

        ContentPanel.add(PromosPanel1);

        JPanel PromosPanel2 = new JPanel();
        PromosPanel2.setBounds(555, 1940, 460, 400);
        PromosPanel2.setLayout(null);
        PromosPanel2.setBackground(new Color(0x191D22));
        PromosPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PromosPanel2.setBorder(BorderFactory.createLineBorder(new Color(0xFF6700), 3));// ta3 ki t intiracti m3a l panel
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                PromosPanel2.setBorder(null);
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {

                JOptionPane.showMessageDialog(null, "Opening promotion details...");
            }
        });

        ContentPanel.add(PromosPanel2);


        return ContentPanel;
    }
    
    public JPanel CreateAccountPanel(){

        JPanel AccountPanel = new JPanel();

        return AccountPanel;
    }

    public JPanel CreateMoviePanel(){

        JPanel MoviePanel = new JPanel();
        MoviePanel.setOpaque(false);
        MoviePanel.setLayout(null);
        MoviePanel.setPreferredSize(new Dimension(1125, 3500));

        JLabel ExploreMore = new JLabel("Explore more films ");
        ExploreMore.setBounds(75, 25, 750, 30);
        ExploreMore.setFont(new Font("Segoe UI", Font.BOLD, 20));
        ExploreMore.setForeground(Color.white);

        MoviePanel.add(ExploreMore);

        JPanel ExploreMorePanel = new JPanel();
        ExploreMorePanel.setLayout(new GridLayout(0, 4, 20, 20));  // Unlimited rows, 4 columns
        ExploreMorePanel.setBackground(new Color(0x0D1116));
        ExploreMorePanel.setBounds(75, 65, 950, 600);

        for (int i = 0; i <CinemaManager.movies.size(); i++) { // hna lazem nhto les film f arrays list w nhsbo la longeur ta3hom

            JPanel FilmInfo = new JPanel();
            FilmInfo.setLayout(null);
            FilmInfo.setBackground(new Color(0x191D22));
            FilmInfo.setLayout(null);
            
            // Hayla hadi :-)
            FilmInfo.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    FilmInfo.setBorder(BorderFactory.createLineBorder(new Color(0xFF6700), 3));// ta3 ki t intiracti m3a l panel
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    FilmInfo.setBorder(null);
                }

                public void mouseClicked(java.awt.event.MouseEvent evt) {

                    JOptionPane.showMessageDialog(null, "Opening film details...");
                }
            });

            ExploreMorePanel.add(FilmInfo);
        }

        MoviePanel.add(ExploreMorePanel);
        return MoviePanel;
    }

    public JPanel CreateAdminInterface() {
        
        JPanel AdminElements = new JPanel();
        AdminElements.setBounds(0, 0, 1200, 720);
        AdminElements.setLayout(null);
        AdminElements.setOpaque(true);
        AdminElements.setBackground(new Color(100, 100, 100));

        JLabel welcomeLabel = new JLabel("Welcome, Admin!");
        welcomeLabel.setBounds(50, 50, 300, 50);
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
        welcomeLabel.setForeground(Color.white);

        AdminElements.add(welcomeLabel);

        JPanel SettingsPanel = new JPanel();
        SettingsPanel.setBounds(-300, 0, 300, 750);
        SettingsPanel.setLayout(null);
        SettingsPanel.setOpaque(true);
        SettingsPanel.setBackground(new Color(0x270000));

        AdminElements.add(SettingsPanel);

        JButton AddFilm = new JButton("add film");
        AddFilm.setBounds(20, 75, 270, 40);
        AddFilm.setFont(new Font("Segoe UI", Font.BOLD, 18));
        AddFilm.setBackground(Color.gray);
        AddFilm.setForeground(Color.white);
        AddFilm.setUI(new RoundButtonUI(new Color(0x000000)));

        SettingsPanel.add(AddFilm);

        JButton BonusesButton = new JButton("Bonuses");
        BonusesButton.setBounds(20, 135, 270, 40);
        BonusesButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        BonusesButton.setBackground(Color.gray);
        BonusesButton.setForeground(Color.white);
        BonusesButton.setUI(new RoundButtonUI(new Color(0x000000)));

        SettingsPanel.add(BonusesButton);

        JButton BookedButton = new JButton("Booked");
        BookedButton.setBounds(20, 195, 270, 40);
        BookedButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        BookedButton.setBackground(Color.gray);
        BookedButton.setForeground(Color.white);
        BookedButton.setUI(new RoundButtonUI(new Color(0x000000)));

        SettingsPanel.add(BookedButton);

        JButton FilterButton = new JButton("aplly filter");
        FilterButton.setBounds(20, 255, 270, 40);
        FilterButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        FilterButton.setBackground(Color.gray);
        FilterButton.setForeground(Color.white);
        FilterButton.setUI(new RoundButtonUI(new Color(0x000000)));

        SettingsPanel.add(FilterButton);


        JButton ChangeAccButton = new JButton("Change accounts");
        ChangeAccButton.setBounds(20, 590, 270, 40);
        ChangeAccButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        ChangeAccButton.setBackground(Color.gray);
        ChangeAccButton.setForeground(Color.white);
        ChangeAccButton.setUI(new RoundButtonUI(new Color(0x000000)));

        ChangeAccButton.addActionListener(e -> {
            MainCardLayout.show(MainPanel, "log in");
        });

        SettingsPanel.add(ChangeAccButton);

        JButton LogoutButton = new JButton("Log out");
        LogoutButton.setBounds(20, 650, 270, 40);
        LogoutButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        LogoutButton.setBackground(Color.red);
        LogoutButton.setForeground(Color.white);
        LogoutButton.setUI(new RoundButtonUI(new Color(0x000000)));

        SettingsPanel.add(LogoutButton);


        JTextField searchField = new JTextField("Type to Search...");
        searchField.setBounds(75, 15, 1000, 30);
        searchField.setFont(new Font("Arial", Font.BOLD, 15));
        searchField.setBackground(new java.awt.Color(0x555555));
        searchField.setForeground(Color.WHITE);
        searchField.setCaretColor(Color.WHITE);

        AdminElements.add(searchField);

        JPanel SearchPanel = new JPanel();
        SearchPanel.setBounds(75, 15, 1000, 30);
        SearchPanel.setFont(new Font("Arial", Font.BOLD, 15));
        SearchPanel.setBackground(new java.awt.Color(0x555555));

        AdminElements.add(SearchPanel);

        JLabel SettingText = new JLabel("Settings");
        SettingText.setBounds(15, 10, 300, 55);
        SettingText.setForeground(Color.white);
        SettingText.setFont(new Font("Inter", Font.BOLD, 48));

        SettingsPanel.add(SettingText);


        JPanel EmptyPanel = new JPanel();
        EmptyPanel.setBounds(300, 0, 900, 750);
        EmptyPanel.setLayout(null);
        EmptyPanel.setOpaque(false);
        EmptyPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                timer2.start();
            }
        });
        EmptyPanel.setVisible(false);

        AdminElements.add(EmptyPanel);
        
        JButton ExitSettings = new JButton();
        ExitSettings.setBounds(270, 10, 20, 20);
        ExitSettings.setFont(new Font("Inter", Font.BOLD, 2));
        ExitSettings.setBackground(Color.red);
        ExitSettings.setForeground(Color.white);
        ExitSettings.setUI(new RoundButtonUI(new Color(0x000000)));

        timer2 = new Timer(10, e->{
            if(x == -300){
                timer2.stop();
            }else{
                x-= xVelocity;
                SettingsPanel.setBounds(x, 0, 300, 750);
            }
        });

        ExitSettings.addActionListener(e->{
            timer2.start();
            EmptyPanel.setVisible(false);
            searchField.setVisible(true);
        });

        SettingsPanel.add(ExitSettings);



        JButton SettingsButton = new JButton();
        SettingsButton.setBounds(15, 10, 40, 40);
        SettingsButton.setFont(new Font("Inter", Font.BOLD, 18));
        SettingsButton.setBackground(Color.red);
        SettingsButton.setForeground(Color.white);
        SettingsButton.setUI(new RoundButtonUI(new Color(0x000000)));

        timer = new Timer(10, e->{
            if(x == 0){
                timer.stop();
            }else{
                x+= xVelocity;
                SettingsPanel.setBounds(x, 0, 300, 750);
            }
        });

        SettingsButton.addActionListener(e->{
            timer.start();
            EmptyPanel.setVisible(true);
            searchField.setVisible(false);
        });

        AdminElements.add(SettingsButton);

        AdminElements.setComponentZOrder(SettingsPanel, 0);
        AdminElements.setComponentZOrder(SettingsButton, 1);
        AdminElements.setComponentZOrder(searchField, 1);
        AdminElements.setComponentZOrder(welcomeLabel, 1);


        return AdminElements;
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ChangeTheme) {
            if (Counter % 2 == 0) {
                Counter++;
                this.BlurPanel.setBackground(new java.awt.Color(0xFFFFFF));
                return;
            } else {
                Counter++;
                this.BlurPanel.setBackground(new java.awt.Color(0x000000));
                return;

            }
        }
    }



    
        
        
        
        /*

        // Only add welcome label if UserAccount is not null
        // if (UserAccount != null) {
        // JLabel usernamelbl = new JLabel("Welcome, " + UserAccount.username + "!");
        // usernamelbl.setBounds(50, 120, 300, 50);
        // usernamelbl.setFont(new Font("Segoe UI", Font.BOLD, 25));
        // usernamelbl.setForeground(Color.red);
        // HomePanel.add(usernamelbl);
        // } else {
        // JLabel usernamelbl = new JLabel("Welcome, nkmk!");
        // usernamelbl.setBounds(50, 120, 300, 50);
        // usernamelbl.setFont(new Font("Segoe UI", Font.BOLD, 25));
        // usernamelbl.setForeground(Color.red);
        // HomePanel.add(usernamelbl);

        JLabel welcomeLabel = new JLabel("Welcome, ");
        welcomeLabel.setBounds(50, 50, 300, 50);
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
        welcomeLabel.setForeground(Color.black);

        HomePanel.add(welcomeLabel);

        JPanel SettingsPanel = new JPanel();
        SettingsPanel.setBounds(-300, 0, 300, 750);
        SettingsPanel.setLayout(null);
        SettingsPanel.setOpaque(true);
        SettingsPanel.setVisible(true);
        SettingsPanel.setBackground(new Color(0x2D3142));

        HomePanel.add(SettingsPanel);

        JPanel BalancePanel = new JPanel();
        BalancePanel.setBounds(20, 70, 250, 120);
        BalancePanel.setLayout(null);
        BalancePanel.setBackground(new Color(0xBFC0C0));

        SettingsPanel.add(BalancePanel);

        JLabel BalanceLabel = new JLabel(" Balance");
        BalanceLabel.setBounds(10, 10, 100, 30);
        BalanceLabel.setForeground(Color.white);
        BalanceLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));

        BalancePanel.add(BalanceLabel);

        JLabel BalanceValue = new JLabel("$56,00 ");
        BalanceValue.setFont(new Font("Arial", Font.BOLD, 24));
        BalanceValue.setForeground(new Color(0xFF6700));
        BalanceValue.setBounds(10, 55, 100, 30);

        BalancePanel.add(BalanceValue);

        JButton Dipostebalance = new JButton("");
        Dipostebalance.setBounds(190, 30, 50, 50);
        Dipostebalance.setBackground(new Color(0xFF6700));
        Dipostebalance.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Dipostebalance.addActionListener(e -> {
            JOptionPane.showMessageDialog(HomePanel, "Deposit functionality is not available yet.");
        });
        Dipostebalance.setUI(new RoundButtonUI(new Color(0x000000)));

        BalancePanel.add(Dipostebalance);

        JButton AccountSettings = new JButton("Account settings");
        AccountSettings.setBounds(20, 210, 250, 30);
        AccountSettings.setFont(new Font("Segoe UI", Font.BOLD, 18));
        AccountSettings.setBackground(new Color(0xBFC0C0));
        AccountSettings.setForeground(Color.white);
        AccountSettings.setCursor(new Cursor(Cursor.HAND_CURSOR));
        AccountSettings.setUI(new RoundButtonUI(new Color(0x000000)));

        SettingsPanel.add(AccountSettings);

        JButton AddFilter = new JButton("apply more filters");
        AddFilter.setBounds(20, 270, 250, 30);
        AddFilter.setFont(new Font("Segoe UI", Font.BOLD, 18));
        AddFilter.setBackground(new Color(0xBFC0C0));
        AddFilter.setForeground(Color.white);
        AddFilter.setCursor(new Cursor(Cursor.HAND_CURSOR));
        AddFilter.setUI(new RoundButtonUI(new Color(0x000000)));

        SettingsPanel.add(AddFilter);

        JButton BookedButton = new JButton("Booked");
        BookedButton.setBounds(20, 330, 250, 30);
        BookedButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        BookedButton.setBackground(new Color(0xBFC0C0));
        BookedButton.setForeground(Color.white);
        BookedButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BookedButton.setUI(new RoundButtonUI(new Color(0x000000)));

        SettingsPanel.add(BookedButton);

        JButton ChangeTheme = new JButton("change theme");
        ChangeTheme.setBounds(20, 390, 250, 30);
        ChangeTheme.setFont(new Font("Segoe UI", Font.BOLD, 18));
        ChangeTheme.setBackground(new Color(0xBFC0C0));
        ChangeTheme.setForeground(Color.white);
        ChangeTheme.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ChangeTheme.setUI(new RoundButtonUI(new Color(0x000000)));

        SettingsPanel.add(ChangeTheme);


        JButton ChangeAccButton = new JButton("Change accounts");
        ChangeAccButton.setBounds(20, 590, 250, 30);
        ChangeAccButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        ChangeAccButton.setBackground(new Color(0xBFC0C0));
        ChangeAccButton.setForeground(Color.white);
        ChangeAccButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ChangeAccButton.setUI(new RoundButtonUI(new Color(0x000000)));

        ChangeAccButton.addActionListener(e -> {
            MainCardLayout.show(MainPanel, "log in");
        });

        SettingsPanel.add(ChangeAccButton);

        JButton LogoutButton = new JButton("Log out");
        LogoutButton.setBounds(20, 650, 250, 30);
        LogoutButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        LogoutButton.setBackground(new Color(0xFF6700));
        LogoutButton.setForeground(Color.white);
        LogoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        LogoutButton.setUI(new RoundButtonUI(new Color(0x000000)));

        SettingsPanel.add(LogoutButton);



        JPanel SearchPanel = new JPanel();
        SearchPanel.setBounds(75, 15, 1000, 30);
        SearchPanel.setBackground(new java.awt.Color(0x3A6EA5));

        HomePanel.add(SearchPanel);

        JTextField searchField = new JTextField("Type to Search...");
        searchField.setBounds(75, 15, 1000, 30);
        searchField.setFont(new Font("Arial", Font.BOLD, 15));
        searchField.setBackground(new java.awt.Color(0x3A6EA5));
        searchField.setForeground(Color.WHITE);
        searchField.setCaretColor(Color.WHITE);
        searchField.setCursor(new Cursor(Cursor.HAND_CURSOR));

        searchField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (searchField.getText().equals("Type to Search...")) {
                    searchField.setText("");
                    searchField.setForeground(Color.white);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (searchField.getText().isEmpty() || searchField.getText().trim().isEmpty()) {
                    searchField.setText("Type to Search...");
                    searchField.setForeground(Color.white);
                }
            }

        });

        HomePanel.add(searchField);

        JLabel SettingText = new JLabel("Settings");
        SettingText.setBounds(15, 10, 300, 55);
        SettingText.setForeground(Color.white);
        SettingText.setFont(new Font("Inter", Font.BOLD, 48));

        SettingsPanel.add(SettingText);


        TransparentPanel EmptyPanel2 = new TransparentPanel(0.75f);
        EmptyPanel2.setBounds(300, 0, 900, 750);
        EmptyPanel2.setBackground(Color.black);
        EmptyPanel2.setLayout(null);
        EmptyPanel2.setOpaque(true);
        EmptyPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                timer4.start();
                searchField.setText("Type to Search...");
                EmptyPanel2.setVisible(false);
                searchField.setVisible(true);
            }
        });
        EmptyPanel2.setVisible(false);

        HomePanel.add(EmptyPanel2);
        
        JButton ExitSettings = new JButton();
        ExitSettings.setBounds(270, 10, 20, 20);
        ExitSettings.setFont(new Font("Inter", Font.BOLD, 2));
        ExitSettings.setBackground(new Color(0xFF6700));
        ExitSettings.setForeground(Color.white);
        ExitSettings.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ExitSettings.setUI(new RoundButtonUI(new Color(0x000000)));

        timer4 = new Timer(10, e->{
            if(x2 == -300){
                timer4.stop();
            }else{
                x2-= x2Velocity;
                SettingsPanel.setBounds(x2, 0, 300, 750);
            }
        });

        ExitSettings.addActionListener(e->{
            timer4.start();
            searchField.setText("Type to Search...");
            EmptyPanel2.setVisible(false);
            searchField.setVisible(true);
        });

        SettingsPanel.add(ExitSettings);



        JButton SettingsButton = new JButton();
        SettingsButton.setBounds(15, 10, 40, 40);
        SettingsButton.setFont(new Font("Inter", Font.BOLD, 18));
        SettingsButton.setBackground(new Color(0xFF6700));
        SettingsButton.setForeground(Color.white);
        SettingsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        SettingsButton.setUI(new RoundButtonUI(new Color(0x000000)));

        timer3 = new Timer(10, e->{
            if(x2 == 0){
                timer3.stop();
            }else{
                x2+= x2Velocity;
                SettingsPanel.setBounds(x2, 0, 300, 750);
            }
        });

        SettingsButton.addActionListener(e->{
            timer3.start();
            EmptyPanel2.setVisible(true);
            searchField.setVisible(false);
        });

        HomePanel.add(SettingsButton);

        // ----------Slide Panel--------------------------------

        JPanel slidePanel = new JPanel();
        slidePanel.setBounds(90, 100, 987, 310);
        slidePanel.setLayout(null);
        slidePanel.setBackground(new Color(0x4F5D75));

        JLabel Img = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon("");
                Image img = icon.getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        Img.setBounds(0, 0, 987, 310);
        slidePanel.add(Img);

        // Films Grid Section
        JPanel filmsGridPanel = new JPanel();
        filmsGridPanel.setLayout(new GridLayout(0, 5, 59, 20));  // Unlimited rows, 4 columns
        filmsGridPanel.setBackground(new Color(0xFFFFFF));

        JPanel EmptyPanel = new JPanel();
        EmptyPanel.setLayout(null);
        EmptyPanel.setOpaque(false);
        EmptyPanel.setBounds(0, 0, 1200, 2000);

        EmptyPanel.add(slidePanel);

        JScrollPane scrollPane = new JScrollPane(filmsGridPanel); // create scroll ghir l hada l panel
        scrollPane.setBounds(90, 450, 987, 450);
        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.getViewport().setBackground(new Color(0xFFFFFF));

        filmsGridPanel.addMouseWheelListener(e -> {
            JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();// had scroll par rapport l y
            int notches = e.getWheelRotation();
            int currentValue = verticalScrollBar.getValue();
            int scrollAmount = 30; // Adjust scroll speed
            verticalScrollBar.setValue(currentValue + (notches * scrollAmount));
        });

        for (int i = 0; i < 23; i++) { // hna lazem nhto les film f arrays list w nhsbo la longeur ta3hom

            JPanel filmPanel = new JPanel();
            filmPanel.setLayout(null);
            filmPanel.setPreferredSize(new Dimension(150, 210));
            filmPanel.setLayout(null);
            filmPanel.setOpaque(false);

            // Hayla hadi :-)
            filmPanel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    filmPanel.setBorder(BorderFactory.createLineBorder(new Color(0xFF6700), 5));// ta3 ki t intiracti m3a l panel
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    filmPanel.setBorder(null);
                }

                public void mouseClicked(java.awt.event.MouseEvent evt) {

                    JOptionPane.showMessageDialog(null, "Opening film details...");
                }
            });

            JPanel FilmInfo = new JPanel();
            FilmInfo.setLayout(null);
            FilmInfo.setBackground(new Color(0x3A6EA5));
            FilmInfo.setLayout(null);
            FilmInfo.setBounds(0, 0, 150, 175);// Hayla hadi :-)
            FilmInfo.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    FilmInfo.setBorder(BorderFactory.createLineBorder(new Color(0xFF6700), 5));// ta3 ki t intiracti m3a l panel
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    FilmInfo.setBorder(null);
                }

                public void mouseClicked(java.awt.event.MouseEvent evt) {

                    JOptionPane.showMessageDialog(null, "Opening film details...");
                }
            });

            filmPanel.add(FilmInfo);

            JButton BuyButton = new JButton("buy now");
            BuyButton.setBounds(0, 185, 150, 25);
            BuyButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
            BuyButton.setBackground(new Color(0xFF6700));
            BuyButton.setForeground(Color.white);
            BuyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            BuyButton.setUI(new RoundButtonUI(new Color(0x000000)));

            filmPanel.add(BuyButton);

            filmsGridPanel.add(filmPanel);
        }

        EmptyPanel.add(scrollPane);

        JScrollPane scrollPane2 = new JScrollPane(EmptyPanel); // create scroll ghir l hada l panel
        scrollPane2.setBounds(0, 0, 1200, 750);
        scrollPane2.setBorder(null);
        scrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane2.getViewport().setBackground(new Color(0xFFFFFF));

        EmptyPanel.addMouseWheelListener(e -> {
            JScrollBar verticalScrollBar = scrollPane2.getVerticalScrollBar();// had scroll par rapport l y
            int notches = e.getWheelRotation();
            int currentValue = verticalScrollBar.getValue();
            int scrollAmount = 30; // Adjust scroll speed
            verticalScrollBar.setValue(currentValue + (notches * scrollAmount));
        });

        HomePanel.add(scrollPane2);

        HomePanel.setComponentZOrder(SettingsPanel, 0);
        HomePanel.setComponentZOrder(EmptyPanel2, 1);
        HomePanel.setComponentZOrder(SettingsButton, 2);
        HomePanel.setComponentZOrder(SearchPanel, 2);
        HomePanel.setComponentZOrder(welcomeLabel, 2);


        JLabel nowShowingLabel = new JLabel("Our Movies");
        nowShowingLabel.setBounds(90, 420, 200, 20);
        nowShowingLabel.setForeground(Color.black);
        nowShowingLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        EmptyPanel.add(nowShowingLabel);*/

}

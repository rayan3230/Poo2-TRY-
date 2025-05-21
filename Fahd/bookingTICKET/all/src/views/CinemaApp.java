package views;

import Model.*;
import controller.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class CinemaApp extends JFrame implements ActionListener {

    // Declare dashboard panels as instance variables so they are accessible throughout the class
    private JPanel MoviesDashboard;
    private JPanel UserInsightsDashboard;
    private JPanel BroadcastDashboard;
    private JPanel theaterDashboard;

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
    public static Movie.MovieAgeRating ChosenAge;
    public static Broadcast CurrentBroadcast;
    public static Client currentClient;

    // log in elements : ------------------------------------------------
    public JPanel WelcomePanel;
    public JPanel LogInPanel;
    public JPanel SignInPanel;
    public JPanel ForgotPasswordPanel;
    public JPanel ClientPanel;
    public JPanel AdminPanel;
    public JPanel MainPanel;
    public JPanel BuyMoviePanel;

    public ArrayList<Movie> FavList;

    // fonctionnalities elements ---------------------------------------
    public Timer timer, timer2;
    public int x = 1500;
    public int xVelocity = 30;
    public int Counter = 0;
    public JScrollPane scrollPane3, scrollPane4;
    public static int numberVip, numberRegular;

    // decorative Panels ------------------------------------------------
    public TransparentPanel BlurPanel, BlurPanel2, BlurPanel3;

    // layout manager -----------------------------------------------------
    public CardLayout MainCardLayout;

    // Add this field at the top of the class with other fields
    private String currentCard = "home";

    // User ID ------------------------------------------------------------
    public int USERID ;

    public CinemaApp() {
        // Initialize managers
        movieManager = new MovieManager();
        clientManager = new ClientManager();
        adminManager = new AdminManager();
        theaterManager = new TheaterManager();
        bookingManager = new BookingManager();
        broadcastManager = new BroadcastManager();

        FavList = new ArrayList<>();
        FavList.add(movieManager.movies.get(movieManager.GetMovieByName("Invincible")));
        FavList.add(movieManager.movies.get(movieManager.GetMovieByName("The Batman")));
        FavList.add(movieManager.movies.get(movieManager.GetMovieByName("Blair Witch")));

        BuyMoviePanel = CreateBuyMoviePanel(movieManager.movies.get(movieManager.GetMovieByName("Invincible")));

        // Initialize components
        this.setTitle("MovieBooking App");
        ImageIcon AppLogo = new ImageIcon("Images/Logo.png");
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
        JPanel SignInPanel = CreateSignInPanel();

        // log in panel ----------------------------------------------------
        JPanel LoginPanel = createLoginPanel();

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
        MainPanel.add(LoginPanel, "LogIn");
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
                "Images/MilesBackground.png");
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

    public JPanel createLoginPanel() {
        // Colors
        Color bgcolor = new Color(0x121213);
        Color secondarycolor = new Color(0x151517);



            JPanel loginPanel = new JPanel();
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
            movingimage.setBounds(126, 493, 135, 10);
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
            imagPanel.setRoundedBorder(Color.white, 1);
            imagPanel.setOpaque(false);
            cardPanel.add(imagPanel);
    
            String[] imagePaths = {
                "Fahd/bookingTICKET/all/img/logmovies/image1.png",
                "Fahd/bookingTICKET/all/img/logmovies/image2.png",
                "Fahd/bookingTICKET/all/img/logmovies/image3.png",
            };
    
            // Timer to change images
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                int currentIndex = 0;
    
                public void run() {
                    rect3.setBackground(Color.gray);
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
            TextfieldBehave(UserField, "enter your username or email");

            cardPanel.add(UserField);
    
            JLabel passwordLabel = new JLabel("Password");
            passwordLabel.setBounds(435, 227, 100, 18);
            passwordLabel.setForeground(Color.white);
            passwordLabel.setFont(new Font("Roboto", Font.BOLD, 15));
            cardPanel.add(passwordLabel);
    
            JPasswordField passwordField = new JPasswordField();
            passwordField.setBounds(435, 251, 390, 40);
            passwordField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.white, 1),
            new EmptyBorder(5, 10, 5, 10) // Add padding inside the text field
            ));
            passwordField.setForeground(Color.white);
            passwordField.setBackground(secondarycolor);
            passwordField.setCaretColor(Color.white);
            passwordField.setForeground(Color.GRAY);
            TextfieldBehave(passwordField, "Enter your Password");

            cardPanel.add(passwordField);
    
            RoundedButton loginButton = new RoundedButton("Login",3);
            loginButton.setBounds(513, 320, 220, 39);
            loginButton.setBackground(bgcolor);
            loginButton.setForeground(Color.white);
            loginButton.setFont(new Font("Roboto", Font.BOLD, 16));
            loginButton.setOpaque(false);
            loginButton.setRoundedBorder(Color.WHITE, 1);
            loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    loginButton.setRoundedBorder(Color.red, 1);
                    loginButton.setForeground(Color.red);
                }
    
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    loginButton.setRoundedBorder(Color.WHITE, 1);
                    loginButton.setForeground(Color.white);
                }
            });
            loginButton.addActionListener(e -> {

            });

            loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

            cardPanel.add(loginButton);
    
            JButton goToSignUpButton = new JButton("Don't have an account? Sign up");
            goToSignUpButton.setBounds(400, 390, 300, 20);
            goToSignUpButton.setForeground(Color.white);
            goToSignUpButton.setFont(new Font("Roboto", Font.BOLD, 14));
            goToSignUpButton.setBorderPainted(false);
            goToSignUpButton.setContentAreaFilled(false);
            goToSignUpButton.setFocusPainted(false);
            goToSignUpButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    goToSignUpButton.setForeground(Color.red);
                }
    
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    goToSignUpButton.setForeground(Color.white);
                }
            });
            goToSignUpButton.addActionListener(event -> MainCardLayout.show(this.MainPanel, "SignIn"));
            goToSignUpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            cardPanel.add(goToSignUpButton);

            loginPanel.add(cardPanel);
            return loginPanel;
    }

    public JPanel CreateSignInPanel() {

        // Colors
        Color bgcolor = new Color(0x121213);
        Color secondarycolor = new Color(0x151517);

        JPanel signUpPanel = new JPanel();
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
        //imagPanel.setBackgroundImage("Poo2-TRY-//All/bookingTICKET/images/image.png");
        imagPanel.setRoundedBorder(Color.white, 1);
        imagPanel.setOpaque(false);
        cardPanel.add(imagPanel);
    
         String[] imagePaths = {
            "Fahd/bookingTICKET/all/img/logmovies/image1.png",
            "Fahd/bookingTICKET/all/img/logmovies/image2.png",
            "Fahd/bookingTICKET/all/img/logmovies/image3.png",
        };
    
        // Timer to change images
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                int currentIndex = 0;
    
                @Override
                public void run() {
                    imagPanel.setBackgroundImage(imagePaths[currentIndex]);
                    currentIndex = (currentIndex + 1) % (imagePaths.length );
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
            signinbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            signinbutton.setRoundedBorder(Color.WHITE, 1);
            signinbutton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    signinbutton.setRoundedBorder(Color.red, 1);
                    signinbutton.setForeground(Color.red);
                }
    
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    signinbutton.setRoundedBorder(Color.WHITE, 1);
                    signinbutton.setForeground(Color.white);
                }
            });
            signinbutton.addActionListener(event -> {
                
            });

            signinbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            cardPanel.add(signinbutton);
    
            JButton goToLoginButton = new JButton("Already have an account? Login");
            goToLoginButton.setBounds(395, 95, 250, 30);
            goToLoginButton.setForeground(Color.white);
            goToLoginButton.setFont(new Font("Roboto", Font.PLAIN, 12));
            goToLoginButton.setBorderPainted(false);
            goToLoginButton.setContentAreaFilled(false);
            goToLoginButton.setFocusPainted(false);
            goToLoginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            cardPanel.add(goToLoginButton);
    
            goToLoginButton.addActionListener(event -> MainCardLayout.show(this.MainPanel, "LogIn"));
    
            signUpPanel.add(cardPanel);
            return signUpPanel;
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
            int film = i;
            RoundedPanel moviePanel = new RoundedPanel(35);
            moviePanel.setLayout(null);
            moviePanel.setBackground(new Color(0x292929));
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
                    BuyMoviePanel = CreateBuyMoviePanel(movieManager.movies.get(film));
                    ContentPanel.add(BuyMoviePanel, "buy movie");
                    ((CardLayout) ContentPanel.getLayout()).show(ContentPanel, "buy movie");
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
            int film = i;
            RoundedPanel moviePanel = new RoundedPanel(35);
            moviePanel.setLayout(null);
            moviePanel.setBackground(new Color(0x292929));

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
                    JPanel BuyMoviePanel = CreateBuyMoviePanel(movieManager.movies.get(
                            movieManager.GetMovieByName(movieManager.movies.get(PromotionNumbers[film]).Title)
                        )
                    );
                    ContentPanel.add(BuyMoviePanel, "buy movie");
                    ((CardLayout) ContentPanel.getLayout()).show(ContentPanel, "buy movie");
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
            int film = i;
            if(ChosenGenre == null){
                RoundedPanel moviePanel = new RoundedPanel(35);
                moviePanel.setLayout(null);
                moviePanel.setBackground(new Color(0x292929));

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
                        BuyMoviePanel = CreateBuyMoviePanel(movieManager.movies.get(film));
                        ContentPanel.add(BuyMoviePanel, "buy movie");
                        ((CardLayout) ContentPanel.getLayout()).show(ContentPanel, "buy movie");
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
                moviePanel.setBackground(new Color(0x292929));

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
                        BuyMoviePanel = CreateBuyMoviePanel(movieManager.movies.get(film));
                        ContentPanel.add(BuyMoviePanel, "buy movie");
                        ((CardLayout) ContentPanel.getLayout()).show(ContentPanel, "buy movie");
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
        JPanel BroadcastDashboard = new JPanel();
        BroadcastDashboard.setLayout(null);
        BroadcastDashboard.setBounds(0, 0, 1400, 750);
        BroadcastDashboard.setBackground(new Color(0x121213));

        JLabel Broadcastlbl = new JLabel("Broadcast  Dashboard");
        Broadcastlbl.setBounds(35, 26, 300, 30);
        Broadcastlbl.setForeground(Color.WHITE);
        Broadcastlbl.setFont(new Font("Bebas Neue", Font.BOLD, 23));
        BroadcastDashboard.add(Broadcastlbl);


        JLabel Movielblbroad = new JLabel("   Movie");
        Movielblbroad.setBounds(170, 87, 200, 30);
        Movielblbroad.setForeground(Color.WHITE);
        Movielblbroad.setFont(new Font("Bebas Neue", Font.PLAIN, 13));
        BroadcastDashboard.add(Movielblbroad);

        JLabel Theaterlblbroad = new JLabel("Theater");
        Theaterlblbroad.setBounds(390, 87, 200, 30);
        Theaterlblbroad.setForeground(Color.WHITE);
        Theaterlblbroad.setFont(new Font("Bebas Neue", Font.PLAIN, 13));
        BroadcastDashboard.add(Theaterlblbroad);

        JLabel Datelblbroad = new JLabel("Date");
        Datelblbroad.setBounds(610, 87, 200, 30);
        Datelblbroad.setForeground(Color.WHITE);
        Datelblbroad.setFont(new Font("Bebas Neue", Font.PLAIN, 13));
        BroadcastDashboard.add(Datelblbroad);  

        JLabel TicketLabel = new JLabel("Ticket number");
        TicketLabel.setBounds(830, 87, 200, 30);
        TicketLabel.setForeground(Color.WHITE);
        TicketLabel.setFont(new Font("Bebas Neue", Font.PLAIN, 13));
        BroadcastDashboard.add(TicketLabel);  

        JLabel SelectlblBroad = new JLabel("Select");
        SelectlblBroad.setBounds(30, 87, 200, 30);
        SelectlblBroad.setForeground(Color.WHITE);
        SelectlblBroad.setFont(new Font("Bebas Neue", Font.PLAIN, 13));
        BroadcastDashboard.add(SelectlblBroad);

        JSeparator separatorhorBroad = new JSeparator();
        separatorhorBroad.setOrientation(SwingConstants.HORIZONTAL);
        separatorhorBroad.setBackground(Color.white);
        separatorhorBroad.setForeground(Color.white); 
        separatorhorBroad.setBounds(21, 120, 950, 1);
        BroadcastDashboard.add(separatorhorBroad);
   
        JPanel Broadcast = new JPanel();
        Broadcast.setLayout(null);
        Broadcast.setBounds(5, 130, 700, 440);
        Broadcast.setBackground(new Color(0x121213));


        JPanel contentPanelBroad = new JPanel();
        contentPanelBroad.setLayout(null);
        contentPanelBroad.setBackground(new Color(0x121213));


        int totalHeightBroad = broadcastManager.broadcasts.size() * 50; 
        contentPanelBroad.setPreferredSize(new Dimension(650, Math.max(500, totalHeightBroad)));

        ArrayList<JCheckBox> checkBoxesBroadcast = new ArrayList<JCheckBox>();/*

                try (Connection conn = DatabaseConnection.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                "SELECT broadcasts.BroadcastID, movies.Title AS MovieTitle, theaters.TheaterName AS TheaterName, " +
                "broadcasts.Language, broadcasts.BroadcastDate " +
                "FROM broadcasts " +
                "JOIN movies ON broadcasts.MovieID = movies.MovieID " +
                "JOIN theaters ON broadcasts.TheaterID = theaters.TheaterID")) {

            int rowIndex = 0;
            while (rs.next()) {
                JPanel BroadcastRow = new JPanel();
                BroadcastRow.setLayout(null);
                BroadcastRow.setBounds(0, rowIndex * 50, 700, 40);
                BroadcastRow.setBackground(new Color(30, 30, 30));

                JLabel MovieTitleLabel = new JLabel(rs.getString("MovieTitle"));
                MovieTitleLabel.setBounds(170, 5, 200, 30);
                MovieTitleLabel.setForeground(Color.white);
                MovieTitleLabel.setFont(new Font("Bebas Neue", Font.PLAIN, 13));
                BroadcastRow.add(MovieTitleLabel);

                JLabel TheaterNameLabel = new JLabel(rs.getString("TheaterName"));
                TheaterNameLabel.setBounds(390, 5, 200, 30);
                TheaterNameLabel.setForeground(Color.white);
                TheaterNameLabel.setFont(new Font("Bebas Neue", Font.PLAIN, 13));
                BroadcastRow.add(TheaterNameLabel);

                JLabel BroadcastDateLabel = new JLabel(rs.getDate("BroadcastDate").toString());
                BroadcastDateLabel.setBounds(610, 5, 200, 30);
                BroadcastDateLabel.setForeground(Color.white);
                BroadcastDateLabel.setFont(new Font("Bebas Neue", Font.PLAIN, 13));
                BroadcastRow.add(BroadcastDateLabel);

                JCheckBox selectCheckBox = new JCheckBox();
                selectCheckBox.setBounds(30, 5, 20, 20);
                selectCheckBox.setBackground(new Color(30, 30, 30));
                selectCheckBox.setForeground(Color.white);
                selectCheckBox.setFont(new Font("Bebas Neue", Font.PLAIN, 13));
                BroadcastRow.add(selectCheckBox);
                checkBoxesBroadcast.add(selectCheckBox);

                contentPanelBroad.add(BroadcastRow);
                rowIndex++;
            }

            // Update the preferred size of the content panel based on the number of rows
            contentPanelBroad.setPreferredSize(new Dimension(650, Math.max(500, rowIndex * 50)));

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching broadcast data from the database!", "Error", JOptionPane.ERROR_MESSAGE);
        }*/

      
        JScrollPane scrollPanelBroadcast = new JScrollPane(contentPanelBroad);
        scrollPanelBroadcast.setBounds(5, 130, 700, 440);
        scrollPanelBroadcast.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPanelBroadcast.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanelBroadcast.setBorder(null);
        scrollPanelBroadcast.getVerticalScrollBar().setUnitIncrement(16);
        scrollPanelBroadcast.getViewport().setBackground(new Color(0x121213));

       
        contentPanelBroad.addMouseWheelListener(e -> {
            JScrollBar verticalScrollBar = scrollPanelBroadcast.getVerticalScrollBar();
            int notches = e.getWheelRotation();
            int currentValue = verticalScrollBar.getValue();
            int scrollAmount = 30; 
            verticalScrollBar.setValue(currentValue + (notches * scrollAmount));
        });

        BroadcastDashboard.add(scrollPanelBroadcast);

        // fav panel FavoritePanel

        JPanel FavoritePanel = new JPanel();
        FavoritePanel.setLayout(null);
        FavoritePanel.setOpaque(true);
        FavoritePanel.setBackground(new Color(0x121213));
        FavoritePanel.setPreferredSize(new Dimension(955, 20000));

        JScrollPane scrollPane3 = new JScrollPane(FavoritePanel);
        scrollPane3.setBounds(0, 0, 955, 750);
        scrollPane3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPane3.setOpaque(false);
        scrollPane3.setBorder(null);

        FavoritePanel.addMouseWheelListener(e -> {
            JScrollBar verticalScrollBar = scrollPane3.getVerticalScrollBar();// had scroll par rapport l y
            int notches = e.getWheelRotation();
            int currentValue = verticalScrollBar.getValue();
            int scrollAmount = 30; // Adjust scroll speed
            verticalScrollBar.setValue(currentValue + (notches * scrollAmount));
        });

        JLabel FavText = new JLabel("Your favorite movies");
        FavText.setBounds(25, 15, 425, 40);
        FavText.setFont(new Font("Inter", Font.BOLD, 32));
        FavText.setForeground(Color.white);

        FavoritePanel.add(FavText);


        JPanel FavMovieList = new JPanel();
        FavMovieList.setOpaque(false);
        FavMovieList.setBounds(25, 70, 915, FavList.size() * 350 + FavList.size() * 20);
        FavMovieList.setLayout(new GridLayout(0, 2, 40, 20));

        FavoritePanel.add(FavMovieList);

        for (int i = 0; i < FavList.size(); i++) {
            int film = i;
            RoundedPanel moviePanel = new RoundedPanel(35);
            moviePanel.setLayout(null);
            moviePanel.setBackground(new Color(0x292929));

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
                    BuyMoviePanel = CreateBuyMoviePanel(movieManager.movies.get(film));
                    ContentPanel.add(BuyMoviePanel, "buy movie");
                    ((CardLayout) ContentPanel.getLayout()).show(ContentPanel, "buy movie");
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

            FavMovieList.add(moviePanel);
        }


        JPanel BuySettings = new JPanel();
        BuySettings.setBounds(900, 0, 300, 750);
        BuySettings.setLayout(null);
        BuySettings.setBackground(new Color(0x292929));
        BuySettings.setVisible(false);

        ClientPanel.add(BuySettings);

        ContentPanel.add(scrollPane, "home");
        ContentPanel.add(scrollPane2, "all movies");
        ContentPanel.add(BuyMoviePanel, "buy movie");
        ContentPanel.add(BroadcastDashboard, "history");
        ContentPanel.add(scrollPane3, "fav movies");
        ((CardLayout) ContentPanel.getLayout()).show(ContentPanel, "history");
        // -----------------------------------------------------------------------------------------------

        // ------------Left panel--------------------------------------------------------
        RoundedPanel LeftPanel = new RoundedPanel(35);
        LeftPanel.setBounds(25, 25, 200, 650);
        LeftPanel.setBackground(new Color(0x292929));
        LeftPanel.setLayout(null);

        JLabel LogoName = new JLabel("INEMA");
        LogoName.setBounds(45, 25, 100, 20);
        LogoName.setForeground(Color.WHITE);
        LogoName.setFont(new Font("Bebas Neue", Font.BOLD, 24));
        LeftPanel.add(LogoName);
        JLabel CLogored = new JLabel("C");
        CLogored.setBounds(25, 25, 30, 20);
        CLogored.setForeground(Color.red);
        CLogored.setFont(new Font("Bebas Neue", Font.BOLD, 24));
        LeftPanel.add(CLogored);

        // Home button
        RoundedButton homebutton = new RoundedButton("Home", 20);
        homebutton.setBounds(10, 100, 150, 40);
        homebutton.setForeground(Color.WHITE);
        homebutton.setBackground(new Color(0, 0, 0, 0));
        homebutton.setContentAreaFilled(false);
        homebutton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        homebutton.setHorizontalAlignment(SwingConstants.LEFT);
        homebutton.setHoverEffect(new Color(0, 0, 0 , 0), new Color(20, 20, 20));
        homebutton.addActionListener(e ->{
            
            if (currentCard.equals("buy movie")) {
                ContentPanel.remove(BuyMoviePanel);
            }
            showCard(ContentPanel, "home");
            
        });
        LeftPanel.add(homebutton);

        RoundedButton moviesButton = new RoundedButton("All Movies", 20);
        moviesButton.setBounds(10, 160, 150, 40);
        moviesButton.setForeground(Color.WHITE);
        moviesButton.setBackground(new Color(0, 0, 0, 0));
        moviesButton.setContentAreaFilled(false);
        moviesButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        moviesButton.setHorizontalAlignment(SwingConstants.LEFT);
        moviesButton.addActionListener(e -> {
            if (currentCard.equals("buy movie")) {
                ContentPanel.remove(BuyMoviePanel);
            }
            showCard(ContentPanel, "all movies");
        });
        moviesButton.setHoverEffect(new Color(0, 0, 0 , 0), new Color(20, 20, 20));
        LeftPanel.add(moviesButton);

        RoundedButton History = new RoundedButton("History", 20);
        History.setBounds(10, 220, 150, 40);
        History.setForeground(Color.WHITE);
        History.setBackground(new Color(0, 0, 0, 0));
        History.setContentAreaFilled(false);
        History.setFont(new Font("Segoe UI", Font.BOLD, 14));
        History.setHorizontalAlignment(SwingConstants.LEFT);
        History.addActionListener(e -> {
            if (currentCard.equals("buy movie")) {
                ContentPanel.remove(BuyMoviePanel);
            }
            showCard(ContentPanel, "history");
        });
        History.setHoverEffect(new Color(0, 0, 0 , 0), new Color(20, 20, 20));
        LeftPanel.add(History);

        RoundedButton Favorite = new RoundedButton("Favorite", 20);
        Favorite.setBounds(10, 280, 150, 40);
        Favorite.setForeground(Color.WHITE);
        Favorite.setBackground(new Color(0, 0, 0, 0));
        Favorite.setContentAreaFilled(false);
        Favorite.setFont(new Font("Segoe UI", Font.BOLD, 14));
        Favorite.setHorizontalAlignment(SwingConstants.LEFT);
        Favorite.addActionListener(e -> {
            if (currentCard.equals("buy movie")) {
                ContentPanel.remove(BuyMoviePanel);
            }
            showCard(ContentPanel, "fav movies");
        });
        Favorite.setHoverEffect(new Color(0, 0, 0 , 0), new Color(20, 20, 20));
        LeftPanel.add(Favorite);
        

        JSeparator separatorLeft = new JSeparator();
        separatorLeft.setOrientation(SwingConstants.HORIZONTAL);
        separatorLeft.setBackground(Color.white);
        separatorLeft.setForeground(Color.white);
        separatorLeft.setBounds(10, 460, 150, 1);
        LeftPanel.add(separatorLeft);

        RoundedButton Logoutbutton = new RoundedButton("Log out", 20);
        Logoutbutton.setBounds(10, 500, 150, 40);
        Logoutbutton.setForeground(Color.WHITE);
        Logoutbutton.setBackground(new Color(0, 0, 0, 0));
        Logoutbutton.setContentAreaFilled(false);
        Logoutbutton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        Logoutbutton.setHorizontalAlignment(SwingConstants.LEFT);
        Logoutbutton.setHoverEffect(new Color(0, 0, 0 , 0), new Color(20, 20, 20));
        Logoutbutton.addActionListener(e ->{

            int response = JOptionPane.showConfirmDialog(
                null, 
                "Are you sure you want to proceed?", 
                "Confirmation", 
                JOptionPane.YES_NO_OPTION
            );
            if (response == JOptionPane.YES_OPTION) {
                if (currentCard.equals("buy movie")) {
                    ContentPanel.remove(BuyMoviePanel);
                }
                MainCardLayout.show(MainPanel, "LogIn");
            }  
        });
        LeftPanel.add(Logoutbutton);

        ClientPanel.add(LeftPanel);
        // --------------------------------------------------------------------------------------------

        // ------------upper panel---------------------------------------------------------

        // filter button --------------
        Movie.MovieGenre[] genres = Movie.MovieGenre.values();
        
        JComboBox<Movie.MovieGenre> genreComboBox = new JComboBox<>(genres);
        genreComboBox.setBounds(250, 25, 100, 40);
        genreComboBox.setFont(new Font("Inter", Font.BOLD, 10));
        genreComboBox.setBackground(new Color(0x292929));
        genreComboBox.setForeground(Color.white);
        genreComboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));

        genreComboBox.setUI(new RoundComboBoxUI(new Color(0x292929), new Color(0x292929), 35));


        // Add action listener to handle genre selection
        genreComboBox.addActionListener(e -> {
            ChosenGenre = (Movie.MovieGenre) genreComboBox.getSelectedItem();
            updateMovieList(AllMovieList, AllMoviePanel, ContentPanel);
            updateFavList(FavMovieList, FavoritePanel, ContentPanel);
        });

        // Custom renderer for the combo box
        genreComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setForeground(Color.white);
                label.setBackground(isSelected ? new Color(0x313131) : new Color(0x292929));
                label.setFont(new Font("Inter", Font.BOLD, 15));
                return label;
            }
        });

        ClientPanel.add(genreComboBox);

        // Age filter button -----------------
        Movie.MovieAgeRating[] ages = Movie.MovieAgeRating.values();

        JComboBox<Movie.MovieAgeRating> AgeFilter = new JComboBox<>(ages);
        AgeFilter.setBounds(997, 25, 75, 40);
        AgeFilter.setFont(new Font("Inter", Font.BOLD, 12));
        AgeFilter.setBackground(new Color(0x292929));
        AgeFilter.setForeground(Color.white);
        AgeFilter.setCursor(new Cursor(Cursor.HAND_CURSOR));

        AgeFilter.setUI(new RoundComboBoxUI(new Color(0x292929), new Color(0x292929), 35));



        // Add action listener to handle genre selection
        AgeFilter.addActionListener(e -> {
            ChosenAge = (Movie.MovieAgeRating) AgeFilter.getSelectedItem();
            updateMovieList(AllMovieList, AllMoviePanel, ContentPanel);
            updateFavList(FavMovieList, FavoritePanel, ContentPanel);
        });

        // Custom renderer for the combo box
        genreComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setForeground(Color.white);
                label.setBackground(isSelected ? new Color(0x313131) : new Color(0x292929));
                label.setFont(new Font("Inter", Font.BOLD, 15));
                return label;
            }
        });

        ClientPanel.add(genreComboBox);

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
            MainCardLayout.show(MainPanel, "Account");
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
        SearchBar.setBounds(375, 25, 600, 40);
        SearchBar.setBackground(new Color(0x292929));
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

        // Add key listener for search functionality
        SearchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String searchText = SearchField.getText().toLowerCase();
                
                // Clear and rebuild the AllMovieList panel
                AllMovieList.removeAll();
                
                // Add movies based on search text
                for (int i = 0; i < MovieManager.movies.size(); i++) {
                    int film = i;
                    Movie movie = movieManager.movies.get(i);
                    // If search is empty or movie title contains search text
                    if (searchText.isEmpty() || movie.Title.toLowerCase().contains(searchText)) {
                        RoundedPanel moviePanel = new RoundedPanel(35);
                        moviePanel.setLayout(null);
                        moviePanel.setBackground(new Color(0x292929));

                        RoundedPanel MovieBanner = new RoundedPanel(35);
                        MovieBanner.setBounds(5, 5, 425, 250);
                        MovieBanner.setBackground(new Color(0x414141));
                        MovieBanner.setLayout(null);

                        moviePanel.add(MovieBanner);

                        moviePanel.addMouseListener(new java.awt.event.MouseAdapter() {
                            public void mouseEntered(java.awt.event.MouseEvent evt) {
                                moviePanel.setBorder(BorderFactory.createLineBorder(new Color(0xFF6700), 3, true));
                            }
                            
                            public void mouseExited(java.awt.event.MouseEvent evt) {
                                moviePanel.setBorder(null);
                            }
                            
                            public void mouseClicked(java.awt.event.MouseEvent evt) {
                                BuyMoviePanel = CreateBuyMoviePanel(movieManager.movies.get(film));
                                ContentPanel.add(BuyMoviePanel, "buy movie");
                                ((CardLayout) ContentPanel.getLayout()).show(ContentPanel, "buy movie");
                            }
                        });

                        ImageIcon BannerIcon = resizedIcon(movie.ImagePath2, 425, 250);
                        JLabel BannerLabel = new JLabel(BannerIcon);
                        BannerLabel.setBounds(0, 0, 425, 250);

                        MovieBanner.add(BannerLabel);

                        JLabel MovieTitle = new JLabel(movie.Title);
                        MovieTitle.setBounds(5, 260, 425, 40);
                        MovieTitle.setFont(new Font("Inter", Font.BOLD, 20));
                        MovieTitle.setForeground(Color.white);

                        moviePanel.add(MovieTitle);

                        JLabel MovieDuration = new JLabel("<html>" + movie.Description + "</html>");
                        MovieDuration.setBounds(5, 290, 425, 150);
                        MovieDuration.setFont(new Font("Inter", Font.PLAIN, 14));
                        MovieDuration.setForeground(Color.white);

                        moviePanel.add(MovieDuration);

                        JLabel Author = new JLabel("By " + movie.Director);
                        Author.setBounds(5, 450, 425, 30);
                        Author.setFont(new Font("Inter", Font.BOLD, 16));
                        Author.setForeground(Color.white);

                        moviePanel.add(Author);

                        AllMovieList.add(moviePanel);
                    }
                }

                // Calculate grid layout based on number of matching movies
                int matchingMovies = 0;
                for (int i = 0; i < MovieManager.movies.size(); i++) {
                    int film = i;
                    Movie movie = movieManager.movies.get(i);
                    if (searchText.isEmpty() || movie.Title.toLowerCase().contains(searchText)) {
                        matchingMovies++;
                    }
                }
                
                int rows = (int) Math.ceil(matchingMovies / 2.0);
                AllMovieList.setLayout(new GridLayout(rows, 2, 40, 20));

                // Update the size of AllMovieList panel based on content
                int width = 915;
                if (matchingMovies == 1) {
                    width = 450;
                }
                AllMovieList.setBounds(25, 70, width, rows * 500 + (rows - 1) * 20);

                // Repaint and revalidate the panels
                AllMovieList.revalidate();
                AllMovieList.repaint();
                AllMoviePanel.revalidate();
                AllMoviePanel.repaint();
            }
        });

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
        ClientPanel.setComponentZOrder(genreComboBox, 2);
        ClientPanel.setComponentZOrder(AgeFilter, 2);
        ClientPanel.setComponentZOrder(AccountButton, 2);
        ClientPanel.setComponentZOrder(ContentPanel, 3);
        ClientPanel.setComponentZOrder(BuySettings, 0);

        return ClientPanel;
    }

    public JPanel CreateBuyMoviePanel(Movie movie){
        // Create a container panel that will hold all content
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(null);
        containerPanel.setBackground(new Color(0x121213));
        containerPanel.setPreferredSize(new Dimension(955, 1000)); // Increased height to accommodate all content

        // Create the main content panel
        JPanel MoviePanel = new JPanel();
        MoviePanel.setLayout(null);
        MoviePanel.setOpaque(true);
        MoviePanel.setBackground(new Color(0x121213));
        MoviePanel.setBounds(0, 0, 955, 1200);

        // Movie banner with overlay gradient
        JPanel BannerPanel = new JPanel();
        BannerPanel.setBounds(25, 0, 900, 400);
        BannerPanel.setLayout(null);

        // Add movie banner image
        ImageIcon imageIcon = resizedIcon(movie.ImagePath2, 900, 400);
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, 0, 900, 400);
        BannerPanel.add(imageLabel);

        // Add gradient overlay
        JPanel gradientOverlay = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(
                    0, 0, new Color(0, 0, 0, 0),
                    0, getHeight(), new Color(0, 0, 0, 200)
                );
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        gradientOverlay.setBounds(0, 0, 955, 400);
        gradientOverlay.setOpaque(false);
        BannerPanel.add(gradientOverlay);

        // Add movie title on banner
        JLabel MovieTitle = new JLabel("<html>" + movie.Title + "</html>");
        MovieTitle.setBounds(40, 300, 800, 50);
        MovieTitle.setForeground(Color.white);
        MovieTitle.setFont(new Font("Inter", Font.BOLD, 36));
        BannerPanel.add(MovieTitle);

        MoviePanel.add(BannerPanel);

        // Content panel below banner
        JPanel ContentPanel = new JPanel();
        ContentPanel.setBounds(40, 420, 875, 300);
        ContentPanel.setBackground(new Color(0x1E1E1E));
        ContentPanel.setLayout(null);
        ContentPanel.setBorder(BorderFactory.createLineBorder(new Color(0x333333), 1, true));

        // Description section
        JLabel DescriptionLabel = new JLabel("<html>" + movie.Description + "</html>");
        DescriptionLabel.setBounds(30, 30, 375, 240);
        DescriptionLabel.setForeground(Color.white);
        DescriptionLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        ContentPanel.add(DescriptionLabel);

        // Info box with modern styling
        JPanel InfoBoxPanel = new JPanel();
        InfoBoxPanel.setBounds(450, 30, 375, 240);
        InfoBoxPanel.setBackground(new Color(0x252525));
        InfoBoxPanel.setLayout(null);
        InfoBoxPanel.setBorder(BorderFactory.createLineBorder(new Color(0x333333), 1, true));

        // Add movie details with icons
        String[] details = {
            "Genre: " + movie.Genre,
            "Release Date: " + movie.ReleaseDate,
            "Duration: " + movie.Duration + " hour(s)",
            "Rating: " + movie.Rating + "/10",
            "Age Rating: " + movie.AgeRating,
            "Cast: " + movie.Cast,
            "Director: " + movie.Director
        };

        for (int i = 0; i < details.length; i++) {
            JLabel detailLabel = new JLabel(details[i]);
            detailLabel.setBounds(20, 20 + (i * 30), 335, 25);
            detailLabel.setForeground(Color.white);
            detailLabel.setFont(new Font("Inter", Font.PLAIN, 14));
            InfoBoxPanel.add(detailLabel);
        }

        ContentPanel.add(InfoBoxPanel);
        MoviePanel.add(ContentPanel);

        // Action buttons panel
        JPanel ActionPanel = new JPanel();
        ActionPanel.setBounds(40, 740, 875, 60);
        ActionPanel.setBackground(new Color(0x1E1E1E));
        ActionPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        ActionPanel.setBorder(BorderFactory.createLineBorder(new Color(0x333333), 1, true));

        // Watch Trailer button
        JButton TrailerButton = new JButton("Watch Trailer");
        TrailerButton.setPreferredSize(new Dimension(180, 45));
        TrailerButton.setFont(new Font("Inter", Font.BOLD, 16));
        TrailerButton.setForeground(Color.white);
        TrailerButton.setBackground(new Color(0xE50914));
        TrailerButton.setFocusPainted(false);
        TrailerButton.setBorderPainted(false);
        TrailerButton.setUI(new RoundButtonUI(new Color(0x000000)));
        TrailerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        TrailerButton.addActionListener(e -> {
            // Handle trailer button click
        });

        // Book Now button
        JButton BookButton = new JButton("Book Now");
        BookButton.setPreferredSize(new Dimension(180, 45));
        BookButton.setFont(new Font("Inter", Font.BOLD, 16));
        BookButton.setForeground(Color.white);
        BookButton.setBackground(new Color(0x2D2D2D));
        BookButton.setFocusPainted(false);
        BookButton.setBorderPainted(false);
        BookButton.setUI(new RoundButtonUI(new Color(0x000000)));
        BookButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BookButton.addActionListener(e -> {

            // Create a new frame for booking
            JFrame bookingFrame = new JFrame("Book Movie");
            bookingFrame.setSize(450, 720);
            bookingFrame.setLocationRelativeTo(null);
            bookingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            bookingFrame.setResizable(false);
            
            // Create a panel for the booking frame
            JPanel bookingPanel = new JPanel();
            bookingPanel.setLayout(null);
            bookingPanel.setBackground(new Color(0X212121));

            //booking fields 
            JLabel BookLabel = new JLabel("Book your seat");
            BookLabel.setBounds(25, 25, 400, 50);
            BookLabel.setFont(new Font("Inter", Font.BOLD, 26));
            BookLabel.setForeground(Color.WHITE);

            bookingPanel.add(BookLabel);

            //booking fields 
            JLabel ChooseLanguage = new JLabel("Choose you broadcast language");
            ChooseLanguage.setBounds(25, 75, 400, 30);
            ChooseLanguage.setFont(new Font("Inter", Font.BOLD, 18));
            ChooseLanguage.setForeground(Color.WHITE);

            bookingPanel.add(ChooseLanguage);

            Movie.Language[] options = Movie.Language.values();
        
            JComboBox<Movie.Language> Languages = new JComboBox<>(options);
            Languages.setBounds(25, 110, 400, 40);
            Languages.setFont(new Font("Inter", Font.BOLD, 15));
            Languages.setBackground(new Color(0x333333));
            Languages.setForeground(Color.white);
            Languages.setCursor(new Cursor(Cursor.HAND_CURSOR));

            Languages.setUI(new RoundComboBoxUI(new Color(0x333333), new Color(0xAAAAAA), 15));

            bookingPanel.add(Languages);


            JLabel SeatLabel = new JLabel("Vip seat");
            SeatLabel.setBounds(25, 165, 400, 30);
            SeatLabel.setFont(new Font("Inter", Font.BOLD, 18));
            SeatLabel.setForeground(Color.WHITE);

            bookingPanel.add(SeatLabel);

            JLabel ReguSeatLabel = new JLabel("Regular seat");
            ReguSeatLabel.setBounds(237, 165, 400, 30);
            ReguSeatLabel.setFont(new Font("Inter", Font.BOLD, 18));
            ReguSeatLabel.setForeground(Color.WHITE);

            bookingPanel.add(ReguSeatLabel);

            

            RoundedPanel NbrVipSeat = new RoundedPanel(15);
            NbrVipSeat.setBounds(25, 200, 175, 40);
            NbrVipSeat.setBackground(new Color(0x333333));
            NbrVipSeat.setLayout(null);
            NbrVipSeat.setBorder(BorderFactory.createLineBorder(new Color(0xAAAAAA), 1, true));

            bookingPanel.add(NbrVipSeat);

            JTextField NbrVipSeatField = new JTextField();
            NbrVipSeatField.setBounds(10, 0, 150, 45);
            NbrVipSeatField.setFont(new Font("Inter", Font.BOLD, 15));
            NbrVipSeatField.setForeground(Color.white);
            NbrVipSeatField.setCaretColor(Color.white);
            NbrVipSeatField.setOpaque(false);
            NbrVipSeatField.setBorder(null);

            setIntegerOnly(NbrVipSeatField);
            TextfieldBehave(NbrVipSeatField, "0");

            RoundedPanel NbrRegularSeat = new RoundedPanel(15);
            NbrRegularSeat.setBounds(237, 200, 175, 40);
            NbrRegularSeat.setBackground(new Color(0x333333));
            NbrRegularSeat.setLayout(null);
            NbrRegularSeat.setBorder(BorderFactory.createLineBorder(new Color(0xAAAAAA), 1, true));

            bookingPanel.add(NbrRegularSeat);

            JTextField NbrRegularSeatField = new JTextField();
            NbrRegularSeatField.setBounds(10, 0, 150, 45);
            NbrRegularSeatField.setFont(new Font("Inter", Font.BOLD, 15));
            NbrRegularSeatField.setForeground(Color.white);
            NbrRegularSeatField.setCaretColor(Color.white);
            NbrRegularSeatField.setOpaque(false);
            NbrRegularSeatField.setBorder(null);

            setIntegerOnly(NbrRegularSeatField);
            TextfieldBehave(NbrRegularSeatField, "0");

            JLabel VipCount = new JLabel("0 * 1000");
            VipCount.setBounds(300, 380, 400, 30);
            VipCount.setFont(new Font("Inter", Font.BOLD, 18));
            VipCount.setForeground(Color.WHITE);

            bookingPanel.add(VipCount);

            JLabel RegularCount = new JLabel("0 * 800");
            RegularCount.setBounds(300, 420, 400, 30);
            RegularCount.setFont(new Font("Inter", Font.BOLD, 18));
            RegularCount.setForeground(Color.WHITE);

            bookingPanel.add(RegularCount);

            JLabel TotalCount = new JLabel("0 DA");
            TotalCount.setBounds(300, 480, 400, 30);
            TotalCount.setFont(new Font("Inter", Font.BOLD, 18));
            TotalCount.setForeground(Color.WHITE);

            bookingPanel.add(TotalCount);

            NbrVipSeatField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    String VipBoughtSeats = NbrVipSeatField.getText().toLowerCase();
                    
                    // Handle empty input
                    if (VipBoughtSeats.isEmpty()) {
                        VipCount.setText("0 * 1000");
                        return;
                    }
                    VipCount.setText(VipBoughtSeats + " * 1000");
                    numberVip = Integer.parseInt(VipBoughtSeats.trim());
                    
                    TotalCount.setText((numberRegular * 800 + numberVip * 1000) + " DA");

                    // Repaint and revalidate the panels
                    VipCount.revalidate();
                    VipCount.repaint();
                    bookingFrame.revalidate();
                    bookingFrame.repaint();
                }
            });

            NbrRegularSeatField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    String RegularBoughtSeats = NbrRegularSeatField.getText().toLowerCase();
                    
                    // Handle empty input
                    if (RegularBoughtSeats.isEmpty()) {
                        RegularCount.setText("0 * 800");
                        return;
                    }
                    RegularCount.setText(RegularBoughtSeats + " * 800");
                    numberRegular = Integer.parseInt(RegularBoughtSeats.trim());

                    TotalCount.setText((numberRegular * 800 + numberVip * 1000) + " DA");

                    // Repaint and revalidate the panels
                    RegularCount.revalidate();
                    RegularCount.repaint();
                    bookingFrame.revalidate();
                    bookingFrame.repaint();
                }
            });

            JLabel BraodOptionLabel = new JLabel("Choose a broadcast");
            BraodOptionLabel.setBounds(25, 255, 400, 30);
            BraodOptionLabel.setFont(new Font("Inter", Font.BOLD, 18));
            BraodOptionLabel.setForeground(Color.WHITE);

            bookingPanel.add(BraodOptionLabel);

            NbrVipSeat.add(NbrVipSeatField);
            NbrRegularSeat.add(NbrRegularSeatField);

            LocalDate[] broadoptions = new LocalDate[25];
            int i = 0;
            for(Broadcast broad : broadcastManager.broadcasts){
                if(broad.movie == movie){
                    broadoptions[i] = broad.Date;
                    i++;
                }
            }

            JComboBox<LocalDate> BraodOptions = new JComboBox<>(broadoptions);
            BraodOptions.setBounds(25, 290, 400, 40);
            BraodOptions.setFont(new Font("Inter", Font.BOLD, 15));
            BraodOptions.setBackground(new Color(0x333333));
            BraodOptions.setForeground(Color.white);
            BraodOptions.setCursor(new Cursor(Cursor.HAND_CURSOR));

            BraodOptions.setUI(new RoundComboBoxUI(new Color(0x333333), new Color(0xAAAAAA), 15));

            bookingPanel.add(BraodOptions);

            JLabel VipSeatNumber = new JLabel("Vip tickets     ");
            VipSeatNumber.setBounds(25, 380, 400, 30);
            VipSeatNumber.setFont(new Font("Inter", Font.BOLD, 18));
            VipSeatNumber.setForeground(Color.WHITE);

            bookingPanel.add(VipSeatNumber);

            JLabel RegularSeatNumber = new JLabel("Regular tickets     ");
            RegularSeatNumber.setBounds(25, 420, 400, 30);
            RegularSeatNumber.setFont(new Font("Inter", Font.BOLD, 18));
            RegularSeatNumber.setForeground(Color.WHITE);

            bookingPanel.add(RegularSeatNumber);

            JLabel Separator = new JLabel("------------------------------------------------------------------------------");
            Separator.setBounds(25, 450, 400, 30);
            Separator.setFont(new Font("Inter", Font.BOLD, 14));
            Separator.setForeground(Color.WHITE);

            bookingPanel.add(Separator);

            JLabel TotalNumber = new JLabel("your total     ");
            TotalNumber.setBounds(25, 480, 400, 30);
            TotalNumber.setFont(new Font("Inter", Font.BOLD, 18));
            TotalNumber.setForeground(Color.WHITE);

            bookingPanel.add(TotalNumber);

            JButton BookButton2 = new JButton("Book");
            BookButton2.setBounds(25, 580, 375, 40);
            BookButton2.setFont(new Font("Inter", Font.BOLD, 16));
            BookButton2.setForeground(Color.WHITE);
            BookButton2.setBackground(new Color(0xE50914));
            BookButton2.setFocusPainted(false);
            BookButton2.setBorderPainted(false);
            BookButton2.setUI(new RoundButtonUI(new Color(0x000000)));
            BookButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
            BookButton2.addActionListener(e2 -> {
                Theater room = broadcastManager.getBroadcastByMovieAndDate(movie, (LocalDate) BraodOptions.getSelectedItem()).Room;
                if (room == null) {
                    JOptionPane.showMessageDialog(bookingFrame, "No room available for this broadcast.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (room.VipReservedPlaces + numberVip > room.VipCapacity) {
                    JOptionPane.showMessageDialog(bookingFrame, "Not enough VIP seats available.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (room.NormalReservedPlaces + numberRegular > room.NormalCapacity) {
                    JOptionPane.showMessageDialog(bookingFrame, "Not enough Regular seats available.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (numberVip == 0 && numberRegular == 0) {
                    JOptionPane.showMessageDialog(bookingFrame, "Please select at least one seat.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (numberVip < 0 || numberRegular < 0) {
                    JOptionPane.showMessageDialog(bookingFrame, "Please enter a valid number of seats.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (numberVip > 0) {
                    room.VipReservedPlaces += numberVip;
                }
                if (numberRegular > 0) {
                    room.NormalReservedPlaces += numberRegular;
                }
                if (room.VipReservedPlaces == room.VipCapacity) {
                    JOptionPane.showMessageDialog(bookingFrame, "Not enough VIP seats available.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (room.NormalReservedPlaces == room.NormalCapacity) {
                    JOptionPane.showMessageDialog(bookingFrame, "Not enough Regular seats available.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (room.VipReservedPlaces + numberVip > room.VipCapacity) {
                    JOptionPane.showMessageDialog(bookingFrame, "Not enough VIP seats available.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (room.NormalReservedPlaces + numberRegular > room.NormalCapacity) {
                    JOptionPane.showMessageDialog(bookingFrame, "Not enough Regular seats available.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                for(int j =0; j< numberVip; j++){
                    bookingManager.BookTicket(currentClient,
                    broadcastManager.getBroadcastByMovieAndDate(movie, (LocalDate) BraodOptions.getSelectedItem()), 
                    Ticket.TicketType.VIP);
                }

                for(int j =0; j< numberRegular; j++){
                    bookingManager.BookTicket(currentClient,
                    broadcastManager.getBroadcastByMovieAndDate(movie, (LocalDate) BraodOptions.getSelectedItem()), 
                    Ticket.TicketType.Normal);
                }
                JOptionPane.showMessageDialog(bookingFrame, "Your tickets have been booked successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        
            });

            bookingPanel.add(BookButton2);

            // Add the panel to the frame
            bookingFrame.add(bookingPanel);
            
            // Make the frame visible
            bookingFrame.setVisible(true);

        });

        ActionPanel.add(TrailerButton);
        ActionPanel.add(BookButton);
        MoviePanel.add(ActionPanel);

        // Add the MoviePanel to the container
        containerPanel.add(MoviePanel);

        // Create a scroll pane with hidden scrollbars
        JScrollPane scrollPane = new JScrollPane(containerPanel);
        scrollPane.setBounds(0, 0, 955, 750);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        // Add mouse wheel listener for smooth scrolling
        containerPanel.addMouseWheelListener(e -> {
            JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
            int notches = e.getWheelRotation();
            int currentValue = verticalScrollBar.getValue();
            int scrollAmount = 30; // Adjust scroll speed
            verticalScrollBar.setValue(currentValue + (notches * scrollAmount));
        });

        // Create a panel to hold the scroll pane
        JPanel finalPanel = new JPanel();
        finalPanel.setLayout(null);
        finalPanel.setBounds(0, 0, 955, 750);
        finalPanel.add(scrollPane);

        return finalPanel;
    }
    
    // handle events-----------------------------------------------------------------
    public void HandleLogIn(String email, String password) {
        // handle log in
        /*if (CinemaManager.isAdmin(email, password)) {
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
        */
    }

    public void HandleSignIn(JTextField username, JPasswordField password, JTextField email, JTextField cardNumber,
            JTextField ccvnbr, JTextField PhoneNumber) {
        // handle SignIn
        /*try {
        
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
        }*/
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

    // Add this method to the class
    private void showCard(JPanel panel, String cardName) {
        ((CardLayout) panel.getLayout()).show(panel, cardName);
        currentCard = cardName;
    }

    public void setIntegerOnly(JTextField textField) {
        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("\\d*")) {
                    super.insertString(fb, offset, string, attr);
                }
            }
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("\\d*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }

    private void updateMovieList(JPanel AllMovieList, JPanel AllMoviePanel, JPanel ContentPanel) {
        AllMovieList.removeAll();

        int matchingMovies = 0;
        for (int i = 0; i < MovieManager.movies.size(); i++) {
            int film = i;
            Movie movie = movieManager.movies.get(i);
            boolean genreMatch = (ChosenGenre == null || ChosenGenre == Movie.MovieGenre.None || movie.Genre == ChosenGenre);
            boolean ageMatch = (ChosenAge == null || ChosenAge == Movie.MovieAgeRating.G || movie.AgeRating == ChosenAge);

            if (genreMatch && ageMatch) {
                matchingMovies++;
                RoundedPanel moviePanel = new RoundedPanel(35);
                moviePanel.setLayout(null);
                moviePanel.setBackground(new Color(0x292929));

                RoundedPanel MovieBanner = new RoundedPanel(35);
                MovieBanner.setBounds(5, 5, 425, 250);
                MovieBanner.setBackground(new Color(0x414141));
                MovieBanner.setLayout(null);

                moviePanel.add(MovieBanner);

                moviePanel.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        moviePanel.setBorder(BorderFactory.createLineBorder(new Color(0xFF6700), 3, true));
                    }
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        moviePanel.setBorder(null);
                    }
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        BuyMoviePanel = CreateBuyMoviePanel(movieManager.movies.get(film));
                        ContentPanel.add(BuyMoviePanel, "buy movie");
                        ((CardLayout) ContentPanel.getLayout()).show(ContentPanel, "buy movie");
                    }
                });

                ImageIcon BannerIcon = resizedIcon(movie.ImagePath2, 425, 250);
                JLabel BannerLabel = new JLabel(BannerIcon);
                BannerLabel.setBounds(0, 0, 425, 250);
                MovieBanner.add(BannerLabel);

                JLabel MovieTitle = new JLabel(movie.Title);
                MovieTitle.setBounds(5, 260, 425, 40);
                MovieTitle.setFont(new Font("Inter", Font.BOLD, 20));
                MovieTitle.setForeground(Color.white);
                moviePanel.add(MovieTitle);

                JLabel MovieDuration = new JLabel("<html>" + movie.Description + "</html>");
                MovieDuration.setBounds(5, 290, 425, 150);
                MovieDuration.setFont(new Font("Inter", Font.PLAIN, 14));
                MovieDuration.setForeground(Color.white);
                moviePanel.add(MovieDuration);

                JLabel Author = new JLabel("By " + movie.Director);
                Author.setBounds(5, 450, 425, 30);
                Author.setFont(new Font("Inter", Font.BOLD, 16));
                Author.setForeground(Color.white);
                moviePanel.add(Author);

                AllMovieList.add(moviePanel);
            }
        }

        int rows = (int) Math.ceil(matchingMovies / 2.0);
        AllMovieList.setLayout(new GridLayout(rows, 2, 40, 20));
        int width = (matchingMovies == 1) ? 450 : 915;
        AllMovieList.setBounds(25, 70, width, rows * 500 + (rows - 1) * 20);

        AllMovieList.revalidate();
        AllMovieList.repaint();
        AllMoviePanel.revalidate();
        AllMoviePanel.repaint();
    }

    private void updateFavList(JPanel FavMovieList, JPanel FavMoviePanel, JPanel ContentPanel) {
        FavMovieList.removeAll();

        int matchingMovies = 0;
        for (int i = 0; i < FavList.size(); i++) {
            Movie movie = FavList.get(i);
            boolean genreMatch = (ChosenGenre == null || ChosenGenre == Movie.MovieGenre.None || movie.Genre == ChosenGenre);
            boolean ageMatch = (ChosenAge == null || ChosenAge == Movie.MovieAgeRating.G || movie.AgeRating == ChosenAge);

            if (genreMatch && ageMatch) {
                matchingMovies++;
                RoundedPanel moviePanel = new RoundedPanel(35);
                moviePanel.setLayout(null);
                moviePanel.setBackground(new Color(0x292929));

                RoundedPanel MovieBanner = new RoundedPanel(35);
                MovieBanner.setBounds(5, 5, 425, 250);
                MovieBanner.setBackground(new Color(0x414141));
                MovieBanner.setLayout(null);

                moviePanel.add(MovieBanner);

                moviePanel.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        moviePanel.setBorder(BorderFactory.createLineBorder(new Color(0xFF6700), 3, true));
                    }
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        moviePanel.setBorder(null);
                    }
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        BuyMoviePanel = CreateBuyMoviePanel(movie);
                        ContentPanel.add(BuyMoviePanel, "buy movie");
                        ((CardLayout) ContentPanel.getLayout()).show(ContentPanel, "buy movie");
                    }
                });

                ImageIcon BannerIcon = resizedIcon(movie.ImagePath2, 425, 250);
                JLabel BannerLabel = new JLabel(BannerIcon);
                BannerLabel.setBounds(0, 0, 425, 250);
                MovieBanner.add(BannerLabel);

                JLabel MovieTitle = new JLabel(movie.Title);
                MovieTitle.setBounds(5, 260, 425, 40);
                MovieTitle.setFont(new Font("Inter", Font.BOLD, 20));
                MovieTitle.setForeground(Color.white);
                moviePanel.add(MovieTitle);

                JLabel MovieDuration = new JLabel("<html>" + movie.Description + "</html>");
                MovieDuration.setBounds(5, 290, 425, 150);
                MovieDuration.setFont(new Font("Inter", Font.PLAIN, 14));
                MovieDuration.setForeground(Color.white);
                moviePanel.add(MovieDuration);

                JLabel Author = new JLabel("By " + movie.Director);
                Author.setBounds(5, 450, 425, 30);
                Author.setFont(new Font("Inter", Font.BOLD, 16));
                Author.setForeground(Color.white);
                moviePanel.add(Author);

                FavMovieList.add(moviePanel);
            }
        }

        int rows = (int) Math.ceil(matchingMovies / 2.0);
        FavMovieList.setLayout(new GridLayout(rows, 2, 40, 20));
        int width = (matchingMovies == 1) ? 450 : 915;
        FavMovieList.setBounds(25, 70, width, rows * 500 + (rows - 1) * 20);

        FavMovieList.revalidate();
        FavMovieList.repaint();
        FavMoviePanel.revalidate();
        FavMoviePanel.repaint();
    }

}

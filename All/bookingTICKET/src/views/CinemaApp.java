package views;

import java.awt.*;
import java.util.Timer;
import javax.swing.*;


public class CinemaApp extends JFrame {
    // log in elements : ------------------------------------------------
    public JPanel WelcomePanel;
    public JPanel LogInPanel;
    public JPanel SignInPanel;
    public JPanel ForgotPasswordPanel;
    public JPanel ClientPanel;
    public JPanel AdminPanel;
    public JPanel MainPanel;

    //fonctionnalities elements ---------------------------------------
    public Timer timer, timer2, timer3, timer4;
    public int x = -300;
    public int xVelocity = 30;
    public int x2 = -300;
    public int x2Velocity = 30;
    public JScrollPane scrollPane3, scrollPane4;

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

        //Account Panel--------------------------------------------------------
        JPanel AccountPanel = CreateAccountPanel();

        //Account admin Panel--------------------------------------------------------
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
        MainCardLayout.show(MainPanel, "Welcome");

        // Revalidate and repaint to ensure the SettingsPanel is displayed
        this.revalidate();
        this.repaint();

    }

    // create components ------------------------------------------------------------------
    
    public JPanel CreateBackGroundPanel() {

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

    public JPanel CreateWelcomePanel(){
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
            MainCardLayout.show(MainPanel, "log in");
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
            MainCardLayout.show(MainPanel, "register");
        });

        WelcomeElements.add(SignIn);

        JTextField AdressInput = new JTextField();
        AdressInput.setBounds(285, 430, 500, 45);
        AdressInput.setFont(new Font("Arial", Font.BOLD, 20));
        AdressInput.setBackground(new java.awt.Color(0xBBBBBB));
        AdressInput.setForeground(Color.BLACK);
        AdressInput.setCaretColor(Color.WHITE);

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

        return SignInElements;
    }

    public JPanel CreateLogInElementsPanel() {
        JPanel LogInElements = new JPanel();

        return LogInElements;
    }

    public JPanel CreateForgotPasswordPanel() {
        JPanel ForgotPasswordElements = new JPanel();

        return ForgotPasswordElements;
    }

    public JPanel CreateClientInterface() {
        JPanel ClientElements = new JPanel();

        return ClientElements;
    }

    public JPanel CreateAdminInterface() {
        JPanel AdminElements = new JPanel();

        return AdminElements;
    }

    public JPanel CreateAccountPanel() {
        JPanel AccountPanel = new JPanel();

        return AccountPanel;
    }

    public JPanel CreateAccountAdminPanel() {
        JPanel AccountAdminPanel = new JPanel();

        return AccountAdminPanel;
    }



     public ImageIcon resizedIcon(String path , int height , int width){ // hadi bch tbdl l img l size li rak habo w trj3 direct ImageIcon t7yo direct f label ou f button

        ImageIcon icon = new ImageIcon(path);
        Image image = icon.getImage().getScaledInstance(height, width, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(image);
        

        return  resizedIcon;
    }

    public void validateInput(JTextField textField, String regex) { // hadi tcoloriyi l border ta3 textfield 3la hsab type li rak hab l user ydkhlo f textfield

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
         //   JOptionPane.showMessageDialog(this, "Please enter a valid input", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void TextAreaBehave(JTextArea textField, String placeholder) {// hadi tktb dakhel l textarea ida makach focus 3lih ida kayen tfasi klch ida tnha l focus w user maktb walo t3awed tktb wch kan fiha
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

    public void TextfieldBehave(JTextField textField, String placeholder) {// kima TextAreaBehave nrk hadi 3la textfield mais brk 
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


}

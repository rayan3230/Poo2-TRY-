package GuiManagement;

import MainClasses.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CinemaApp extends JFrame implements ActionListener  {

    //main panel -----------------------------------------------------
    public JPanel MainPanel;
    public JPanel OpenPanel;
    public JPanel LogPanel;
    public JPanel SignPanel;

    //Action manager--------------------------------------------------
    public static int Counter = 0;
    //cinema manager---------------------------------------------------
    public Cinema CinemaManager;

    //sign in panels --------------------------------------------------
    public JPanel SignInBackgroundPanel;
    public JPanel FinishSignInBackgroundPanel;
    public JPanel LogInBackgroundPanel;
    public TransparentPanel BlurPanel;
    public JPanel SignInElements;
    public JPanel LogInElements;

    //log in elements : 
    public JPanel LogInPanel;
    public JLabel LogInText1, LogInText2, LogInText3;
    public JTextField LogAdressInput, LogPassWord;
    public JButton LogInButton, SignInReturn;

    //sign in elements : 
    public JLabel PooMovie, WelcomText1, WelcomText2, DescriptionText;
    public JButton SignIn, LogIn, ChangeTheme;
    public JTextField AdressInput;

    //Finish signing in panel ------------------------------------------------
    public JPanel FinishSignInPanel;
    public TransparentPanel BlurPanel2;
    public JLabel PooMovie2;

    //finish sign up elements panels---------------------------------------------------
    public JPanel SignUpPanel;
    public JButton SignUp;
    public JTextField SignAdressInput, SignPassWord;
    public JLabel SignUpText1;

    //decorative Panels ------------------------------------------------
    public JPanel RedPanel, BluePanel;

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
        OpenPanel = new JPanel();
        OpenPanel.setBounds(0, 0, 1200, 750);
        OpenPanel.setLayout(null);
        OpenPanel.setOpaque(false);

        SignInBackgroundPanel = CreatBackGround1Panel();
        SignInElements = CreatSignInElementsPanel();

        OpenPanel.add(SignInBackgroundPanel);
        OpenPanel.add(SignInElements);

        OpenPanel.setComponentZOrder(SignInElements, 0);
        OpenPanel.setComponentZOrder(SignInBackgroundPanel, 1);

        //sign in panel ---------------------------------------------------
        SignPanel = new JPanel(MainCardLayout);
        SignPanel.setBounds(0, 0, 1200, 750);
        SignPanel.setLayout(null);
        SignPanel.setOpaque(false);

        FinishSignInBackgroundPanel = CreatBackGround2Panel();
        FinishSignInPanel = CreatFinishSignInPanel();

        SignPanel.add(FinishSignInBackgroundPanel);
        SignPanel.add(FinishSignInPanel);

        SignPanel.setComponentZOrder(FinishSignInPanel, 0);
        SignPanel.setComponentZOrder(FinishSignInBackgroundPanel, 1);

        //log in panel ----------------------------------------------------
        LogPanel = new JPanel(MainCardLayout);
        LogPanel.setBounds(0, 0, 1200, 750);
        LogPanel.setLayout(null);
        LogPanel.setOpaque(false);

        MainPanel.add(OpenPanel, "open");
        MainPanel.add(SignPanel, "sign in");

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


        BackgroundPanel.add(Background);
        BackgroundPanel.add(BlurPanel);

        BackgroundPanel.setComponentZOrder(Background, 1);
        BackgroundPanel.setComponentZOrder(BlurPanel, 0);

        return BackgroundPanel;
    }

    public JPanel CreatBackGround2Panel(){

        JPanel BackgroundPanel = new JPanel();
        BackgroundPanel.setBounds(0, 0, 1200, 750);

        //the background image :
        Image BackgroundImage = new ImageIcon("Poo2-TRY-\\Fahd\\bookingTICKET\\Images\\BackGround.jpg").getImage();
        JLabel Background = new JLabel();
        Background.setBounds(-15, -15, BackgroundPanel.getWidth(), BackgroundPanel.getHeight());
        Background.setIcon(new ImageIcon(BackgroundImage));
        BackgroundPanel.setLayout(null);

        //Blur panel--------------------------------------------------
        BlurPanel2 = new TransparentPanel(0.85f);
        BlurPanel2.setBounds(0, 0, 1200, 750);
        BlurPanel2.setLayout(null);
        BlurPanel2.setBackground(new java.awt.Color(0xCCCCCC));

        BlurPanel2.setVisible(true);


        BackgroundPanel.add(Background);
        BackgroundPanel.add(BlurPanel2);

        BackgroundPanel.setComponentZOrder(Background, 1);
        BackgroundPanel.setComponentZOrder(BlurPanel2, 0);

        return BackgroundPanel;
    }

    public JPanel CreatSignInElementsPanel(){
        // sign in elements panel ------------------------------------
        SignInElements = new JPanel();
        SignInElements.setBounds(0, 0, 1200, 750);
        SignInElements.setLayout(null);
        SignInElements.setOpaque(false);

        PooMovie = new JLabel("PooMovie");
        PooMovie.setBounds(30, 35, 200, 50);
        PooMovie.setFont(new Font("Inter", Font.BOLD, 35));
        PooMovie.setForeground(new java.awt.Color(0xFF0000));

        SignInElements.add(PooMovie);

        WelcomText1 = new JLabel("Unlimited films in theaters,");//and more to come
        WelcomText1.setBounds(332, 222, 575, 115);
        WelcomText1.setFont(new Font("Inter", Font.BOLD, 40));
        WelcomText1.setForeground(Color.white);

        WelcomText2 = new JLabel("and more to come");
        WelcomText2.setBounds(400, 270, 575, 115);
        WelcomText2.setFont(new Font("Inter", Font.BOLD, 40));
        WelcomText2.setForeground(Color.white);

        SignInElements.add(WelcomText1);
        SignInElements.add(WelcomText2);

        DescriptionText = new JLabel("Experience the magic of PooMovie, where unlimited films await you.");
        DescriptionText.setBounds(340, 310, 1160, 115);
        DescriptionText.setFont(new Font("Inter", Font.BOLD, 15));
        DescriptionText.setForeground(Color.white);

        SignInElements.add(DescriptionText);

        // Sign in and Log in buttons ------------------------------------

        LogIn = new JButton("log In");
        LogIn.setBounds(1090, 40, 75, 30);
        LogIn.setBackground(Color.RED);
        LogIn.setForeground(Color.white);
        LogIn.setFont(new Font("Inter", Font.BOLD, 15));
        LogIn.setFocusable(false);
        LogIn.setUI(new RoundButtonUI(new Color(0x000000)));

        SignInElements.add(LogIn);

        SignIn = new JButton("Sign in");
        SignIn.setBounds(790, 430, 130, 45);
        SignIn.setBackground(Color.RED);
        SignIn.setForeground(Color.white);
        SignIn.setFont(new Font("Inter", Font.BOLD, 15));
        SignIn.setFocusable(false);
        SignIn.setUI(new RoundButtonUI(new Color(0x000000)));

        SignInElements.add(SignIn);

        ChangeTheme = new JButton("Change theme");
        ChangeTheme.setBounds(950, 40, 130, 30);
        ChangeTheme.setBackground(Color.WHITE);
        ChangeTheme.setFont(new Font("Inter", Font.BOLD, 12));
        ChangeTheme.setFocusable(false);
        ChangeTheme.setUI(new RoundButtonUI(new Color(0x000000)));

        ChangeTheme.addActionListener(e-> ChnageThemeAction());

        SignInElements.add(ChangeTheme);

        AdressInput = new JTextField();
        AdressInput.setBounds(285, 430, 500, 45);
        AdressInput.setFont(new Font("Arial", Font.BOLD, 20));
        AdressInput.setBackground(new java.awt.Color(0x222222));
        AdressInput.setForeground(Color.WHITE);
        AdressInput.setCaretColor(Color.WHITE);

        SignInElements.add(AdressInput);

        RedPanel = new JPanel();
        RedPanel.setBounds(0, 710, 1200, 60);
        RedPanel.setBackground(new java.awt.Color(0x550000));

        SignInElements.add(RedPanel);

        BluePanel = new JPanel();
        BluePanel.setBounds(0, 725, 1200, 60);
        BluePanel.setBackground(new java.awt.Color(0x000044));

        SignInElements.add(BluePanel);

        SignInElements.setComponentZOrder(BluePanel, 0);
        SignInElements.setComponentZOrder(RedPanel, 1);

        return SignInElements;
    }

    public JPanel CreatLogInElementsPanel(){
        LogInElements = new JPanel();
        LogInElements.setBounds(360, 115, 470, 690);
        LogInElements.setBackground(Color.BLACK);
        LogInElements.setLayout(null);
        LogInElements.setOpaque(true);

        LogInButton = new JButton();

        return LogInElements;
    }


    public JPanel CreatFinishSignInPanel(){
        //Finish signing in panel ------------------------------------------------
        FinishSignInPanel = new JPanel();
        FinishSignInPanel.setBounds(0, 0, 1200, 750);
        FinishSignInPanel.setLayout(null);
        FinishSignInPanel.setOpaque(false);

        PooMovie2 = new JLabel("PooMovie");
        PooMovie2.setBounds(30, 35, 200, 50);
        PooMovie2.setFont(new Font("Inter", Font.BOLD, 35));
        PooMovie2.setForeground(new java.awt.Color(0xFF0000));

        FinishSignInPanel.add(PooMovie2);

        SignUpPanel = CreatSignUpPanel();
        FinishSignInPanel.add(SignUpPanel);

        RedPanel = new JPanel();
        RedPanel.setBounds(0, 710, 1200, 60);
        RedPanel.setBackground(new java.awt.Color(0x550000));

        FinishSignInPanel.add(RedPanel);

        BluePanel = new JPanel();
        BluePanel.setBounds(0, 725, 1200, 60);
        BluePanel.setBackground(new java.awt.Color(0x000044));

        FinishSignInPanel.add(BluePanel);

        FinishSignInPanel.setComponentZOrder(BluePanel, 0);
        FinishSignInPanel.setComponentZOrder(RedPanel, 1);

        return FinishSignInPanel;
    }

    public JPanel CreatSignUpPanel(){
        //signUP panel -----------------------------------------------------------
        SignUpPanel = new JPanel();
        SignUpPanel.setBounds(200, 130, 800, 400);
        SignUpPanel.setLayout(null);
        SignUpPanel.setBackground(Color.WHITE);

        SignAdressInput = new JTextField();
        SignAdressInput.setBounds(50, 100, 700, 50);
        SignAdressInput.setFont(new Font("Inter", Font.BOLD, 25));
        SignAdressInput.setCaretColor(Color.BLACK);
        SignAdressInput.setBackground(new java.awt.Color(0xDDDDDD));
        SignAdressInput.setForeground(Color.BLACK);

        SignUpPanel.add(SignAdressInput);

        SignPassWord = new JTextField();
        SignPassWord.setBounds(50, 175, 700, 50);
        SignPassWord.setFont(new Font("Inter", Font.BOLD, 25));
        SignPassWord.setCaretColor(Color.BLACK);
        SignPassWord.setBackground(new java.awt.Color(0xDDDDDD));
        SignPassWord.setForeground(Color.BLACK);

        SignUpPanel.add(SignPassWord);

        SignUp = new JButton("Sign up");
        SignUp.setBounds(210, 260, 370, 60);
        SignUp.setBackground(Color.RED);
        SignUp.setForeground(Color.white);
        SignUp.setFont(new Font("Inter", Font.BOLD, 20));
        SignUp.setFocusable(false);
        SignUp.setUI(new RoundButtonUI(new Color(0x000000)));

        SignUpPanel.add(SignUp);

        JLabel FinishSignUpText = new JLabel("Finish settings up your account ");
        FinishSignUpText.setBounds(50, 25, 550, 50);
        FinishSignUpText.setFont(new Font("Inter", Font.BOLD, 30));
        FinishSignUpText.setForeground(new java.awt.Color(0x000000));

        SignUpPanel.add(FinishSignUpText);
        
        return SignUpPanel;
    }

    public void ChnageThemeAction(){

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
            return;
            
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
        return;
    }

    public void SignInAction(){

    }

    public void FinishSignInAction(){

    }

    public void LogInAction(){

    }

    public void FinishLogInAction(){

    }

    public void SignInSecond(){

    }

    public static void main(String[] args) {
        CinemaApp Frame = new CinemaApp();
        Frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}

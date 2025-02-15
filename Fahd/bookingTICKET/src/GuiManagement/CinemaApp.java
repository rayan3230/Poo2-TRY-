package GuiManagement;

import MainClasses.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CinemaApp extends JFrame implements ActionListener  {

    //Action manager--------------------------------------------------
    public static int Counter = 0;
    //cinema manager---------------------------------------------------
    public Cinema CinemaManager;

    //sign in panels --------------------------------------------------
    public JPanel SignInPanel;
    public TransparentPanel BlurPanel;
    public JPanel SignInElements;

    //sign in elements : 
    public JLabel PooMovie, WelcomText1, WelcomText2, DescriptionText;
    public JButton SignIn, LogIn, ChangeTheme;
    public JTextField AdressInput;

    //Finish signing in panel ------------------------------------------------
    public JPanel FinishSignInPanel;
    public TransparentPanel BlurPanel2;
    public JPanel FinishSignInElements;

    //finish sign up elements panels---------------------------------------------------
    public JPanel SignUpPanel;
    public JButton SignUp;
    public JTextField AdressInput2, PassWord;
    public JLabel SignUpText1;

    //decorative Panels ------------------------------------------------
    public JPanel RedPanel, BluePanel;

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

        // sign in elements panel ------------------------------------
        SignInElements = new JPanel();
        SignInElements.setBounds(0, 0, 1200, 750);
        SignInElements.setLayout(null);
        SignInElements.setOpaque(false);
        SignInElements.setVisible(true);

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

        this.add(SignInElements);
        this.setComponentZOrder(SignInElements, 0);


        //Blur panel--------------------------------------------------
        BlurPanel = new TransparentPanel(0.85f);
        BlurPanel.setBounds(0, 0, 1200, 750);
        BlurPanel.setLayout(null);
        BlurPanel.setBackground(new java.awt.Color(0x000000));

        this.add(BlurPanel);

        SignInPanel = new JPanel();
        SignInPanel.setBounds(0, 0, 1200, 750);
        Image BackgroundImage = new ImageIcon("Poo2-TRY-\\Fahd\\bookingTICKET\\Images\\BackGround.jpg").getImage();
        JLabel Background = new JLabel();
        Background.setBounds(-15, -15, SignInPanel.getWidth(), SignInPanel.getHeight());
        Background.setIcon(new ImageIcon(BackgroundImage));
        SignInPanel.setLayout(null);
        SignInPanel.add(Background);

        this.add(SignInPanel);

        // Set the z-order to control which panel is on top
        this.setComponentZOrder(BlurPanel, 1); // BlurPanel on top
        this.setComponentZOrder(SignInPanel, 2); // SignInPanel below BlurPanel


        // Revalidate and repaint to ensure the SettingsPanel is displayed
        this.revalidate();
        this.repaint();
    }

    public void ChnageThemeAction(){

        if(Counter%2 == 0){
            BlurPanel.setBackground(new java.awt.Color(0xFFFFFF));
            ChangeTheme.setBackground(new java.awt.Color(0x000000));
            ChangeTheme.setForeground(Color.WHITE);
            WelcomText1.setForeground(new java.awt.Color(0x000000));
            WelcomText2.setForeground(new java.awt.Color(0x000000));
            DescriptionText.setForeground(new java.awt.Color(0x000000));
            AdressInput.setBackground(new java.awt.Color(0x777777));

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

        // Revalidate and repaint to ensure the SettingsPanel is displayed
        this.revalidate();
        this.repaint();

        Counter++;
        return;
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

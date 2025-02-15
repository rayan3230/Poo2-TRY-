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

    //Log in panels --------------------------------------------------
    public JPanel LogInPanel;
    public JPanel BlurPanel;
    public JPanel LogInElements;

    //Log in elements : 
    public JLabel PooMovie, WelcomText1, WelcomText2, DescriptionText;
    public JButton AdressInput, SignIn, LogIn, ChangeTheme;

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

        // Log in elements panel ------------------------------------
        LogInElements = new JPanel();
        LogInElements.setBounds(0, 0, 1200, 750);
        LogInElements.setLayout(null);
        LogInElements.setOpaque(false);
        LogInElements.setVisible(true);

        PooMovie = new JLabel("PooMovie");
        PooMovie.setBounds(20, 30, 200, 50);
        PooMovie.setFont(new Font("Inter", Font.BOLD, 32));
        PooMovie.setForeground(new java.awt.Color(0xFF0000));

        LogInElements.add(PooMovie);

        WelcomText1 = new JLabel("Unlimited films in theaters");//and more to come
        WelcomText1.setBounds(320, 222, 575, 115);
        WelcomText1.setFont(new Font("Inter", Font.BOLD, 40));
        WelcomText1.setForeground(Color.white);
        WelcomText2 = new JLabel("and more to come");
        WelcomText2.setBounds(320, 300, 575, 115);
        WelcomText2.setFont(new Font("Inter", Font.BOLD, 40));
        WelcomText2.setForeground(Color.white);

        LogInElements.add(WelcomText1);
        LogInElements.add(WelcomText2);

        this.add(LogInElements);
        this.setComponentZOrder(LogInElements, 0);


        //Blur panel--------------------------------------------------
        BlurPanel = new TransparentPanel(0.85f);
        BlurPanel.setBounds(0, 0, 1200, 750);
        BlurPanel.setLayout(null);
        BlurPanel.setBackground(new java.awt.Color(0x000000));

        this.add(BlurPanel);

        LogInPanel = new JPanel();
        LogInPanel.setBounds(0, 0, 1200, 750);
        Image BackgroundImage = new ImageIcon("Poo2-TRY-\\Fahd\\bookingTICKET\\Images\\BackGround.jpg").getImage();
        JLabel Background = new JLabel();
        Background.setBounds(-15, -15, LogInPanel.getWidth(), LogInPanel.getHeight());
        Background.setIcon(new ImageIcon(BackgroundImage));
        LogInPanel.setLayout(null);
        LogInPanel.add(Background);

        this.add(LogInPanel);

        // Set the z-order to control which panel is on top
        this.setComponentZOrder(BlurPanel, 1); // BlurPanel on top
        this.setComponentZOrder(LogInPanel, 2); // LogInPanel below BlurPanel


        // Revalidate and repaint to ensure the SettingsPanel is displayed
        this.revalidate();
        this.repaint();
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

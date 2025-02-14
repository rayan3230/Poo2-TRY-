package GuiManagement;

import MainClasses.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MovieApp extends JFrame implements ActionListener {

    //Action manager--------------------------------------------------

    //cinema manager---------------------------------------------------
    public Cinema CinemaManager;

    //settings configuration variables---------------------------------
    public JButton Settings;

    //Animation settings needed : 
    public JPanel SettingsPanel;
    public Timer timer;
    public int xVelocity = 20;
    public int x = -260;

    //search bar configuration variables--------------------------------
    public JPanel SearchBarPanel;
    public JTextField SearchBarTextField;

    //filter configuration variables------------------------------------
    public JLabel FilterText;

    public JLabel Genre, AgeRestriction, Duration, Rating;
    public JButton GenreButton, AgeRestrictionButton, DurationButton, RatingButton;

    //movie panels configuration variables------------------------------

    //panels :
    public JPanel Movie1, Movie2, Movie3, Movie4, Movie5, Movie6, Movie7, Movie8, Movie9;
    //Buttons :
    public JButton Movie1ticket, Movie2ticket, Movie3ticket, Movie4ticket, Movie5ticket, 
            Movie6ticket, Movie7ticket, Movie8ticket, Movie9ticket;

    public MovieApp() {
        this.setTitle("MovieBooking App");
        ImageIcon AppLogo = new ImageIcon("Poo2-TRY-\\Fahd\\bookingTICKET\\Images\\AppLogo.jpg");
        this.setIconImage(AppLogo.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1100, 650);
        this.setLocationRelativeTo(null);
        this.setVisible(false);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(new java.awt.Color(0xD2D2D2));
        

        // Settings Button to open the SettingsPanel-------------------------
        Settings = new JButton();
        Settings.setBounds(15, 10, 40, 44);
        Settings.setBackground(new Color(0x005DD8));
        Settings.setFocusable(false);
        Settings.setUI(new RoundButtonUI(new Color(0x000000))); // Set custom UI
        Settings.addActionListener(e-> SettingsButtonPress());

        this.add(Settings);

        // Filter text -------------------------------------------------------
        FilterText = new JLabel("Filters : ");
        FilterText.setBounds(75, 85, 80, 24);
        FilterText.setFont(new Font("Arial", Font.BOLD, 20));
        FilterText.setBackground(new java.awt.Color(0x595959));
        
        this.add(FilterText);

        Genre = new JLabel("Genre");
        Genre.setBounds(180, 85, 70, 24);
        Genre.setFont(new Font("Arial", Font.BOLD, 17));
        Genre.setBackground(new java.awt.Color(0x595959));
        GenreButton = new JButton();
        GenreButton.setBounds(240, 88, 17, 17);
        GenreButton.setBackground(new java.awt.Color(0xA0B2ED));
        GenreButton.setFocusable(false);
        GenreButton.setUI(new RoundButtonUI(new Color(0x000000))); // Set custom UI

        this.add(Genre);
        this.add(GenreButton);

        AgeRestriction = new JLabel("Age Restriction");
        AgeRestriction.setBounds(312, 85, 150, 24);
        AgeRestriction.setFont(new Font("Arial", Font.BOLD, 17));
        AgeRestriction.setBackground(new java.awt.Color(0x595959));
        AgeRestrictionButton = new JButton();
        AgeRestrictionButton.setBounds(450, 88, 17, 17);
        AgeRestrictionButton.setBackground(new java.awt.Color(0xA0B2ED));
        AgeRestrictionButton.setFocusable(false);
        AgeRestrictionButton.setUI(new RoundButtonUI(new Color(0x000000))); // Set custom UI

        this.add(AgeRestriction);
        this.add(AgeRestrictionButton);

        Duration = new JLabel("Duration");
        Duration.setBounds(524, 85, 80, 24);
        Duration.setFont(new Font("Arial", Font.BOLD, 17));
        Duration.setBackground(new java.awt.Color(0x595959));
        DurationButton = new JButton();
        DurationButton.setBounds(610, 88, 17, 17);
        DurationButton.setBackground(new java.awt.Color(0xA0B2ED));
        DurationButton.setFocusable(false);
        DurationButton.setUI(new RoundButtonUI(new Color(0x000000))); // Set custom UI

        this.add(Duration);
        this.add(DurationButton);

        Rating = new JLabel("Rating");
        Rating.setBounds(671, 85, 80, 24);
        Rating.setFont(new Font("Arial", Font.BOLD, 17));
        Rating.setBackground(new java.awt.Color(0x595959));
        RatingButton = new JButton();
        RatingButton.setBounds(740, 88, 17, 17);
        RatingButton.setBackground(new java.awt.Color(0xA0B2ED));
        RatingButton.setFocusable(false);
        RatingButton.setUI(new RoundButtonUI(new Color(0x000000))); // Set custom UI

        this.add(Rating);
        this.add(RatingButton);

        // search bar to filter movies by name ----------------------------
        SearchBarPanel = new JPanel();
        SearchBarPanel.setBounds(75, 15, 1000, 30);
        SearchBarPanel.setFont(new Font("Arial", Font.BOLD, 17));
        SearchBarPanel.setBackground(new java.awt.Color(0x012757));
        SearchBarPanel.setForeground(Color.WHITE);
        SearchBarPanel.setLayout(null);

        this.add(SearchBarPanel);

        //movie panels ----------------------------------------------------
        Movie1 = new JPanel();
        Movie1.setBounds(78, 150, 150, 150);
        Movie1.setBackground(new java.awt.Color(0xFFF0DA));
        Movie1.setLayout(null);
        Movie1ticket = new JButton();
        Movie1ticket.setBounds(78, 320, 150, 25);
        Movie1ticket.setBackground(new java.awt.Color(0x27A600));
        Movie1ticket.setFocusable(false);
        Movie1ticket.setUI(new RoundButtonUI(new Color(0x000000)));

        this.add(Movie1);
        this.add(Movie1ticket);

        Movie2 = new JPanel();
        Movie2.setBounds(277, 150, 150, 150);
        Movie2.setBackground(new java.awt.Color(0xFFF0DA));
        Movie2ticket = new JButton();
        Movie2ticket.setBounds(277, 320, 150, 25);
        Movie2ticket.setBackground(new java.awt.Color(0x27A600));
        Movie2ticket.setFocusable(false);
        Movie2ticket.setUI(new RoundButtonUI(new Color(0x000000)));

        this.add(Movie2);
        this.add(Movie2ticket);

        Movie3 = new JPanel();
        Movie3.setBounds(474, 150, 150, 150);
        Movie3.setBackground(new java.awt.Color(0xFFF0DA));
        Movie3ticket = new JButton();
        Movie3ticket.setBounds(474, 320, 150, 25);
        Movie3ticket.setBackground(new java.awt.Color(0x27A600));
        Movie3ticket.setFocusable(false);
        Movie3ticket.setUI(new RoundButtonUI(new Color(0x000000)));

        this.add(Movie3);
        this.add(Movie3ticket);

        Movie4 = new JPanel();
        Movie4.setBounds(672, 150, 150, 150);
        Movie4.setBackground(new java.awt.Color(0xFFF0DA));
        Movie4ticket = new JButton();
        Movie4ticket.setBounds(672, 320, 150, 25);
        Movie4ticket.setBackground(new java.awt.Color(0x27A600));
        Movie4ticket.setFocusable(false);
        Movie4ticket.setUI(new RoundButtonUI(new Color(0x000000)));

        this.add(Movie4);
        this.add(Movie4ticket);

        Movie5 = new JPanel();
        Movie5.setBounds(871, 150, 150, 150);
        Movie5.setBackground(new java.awt.Color(0xFFF0DA));
        Movie5ticket = new JButton();
        Movie5ticket.setBounds(871, 320, 150, 25);
        Movie5ticket.setBackground(new java.awt.Color(0x27A600));
        Movie5ticket.setFocusable(false);
        Movie5ticket.setUI(new RoundButtonUI(new Color(0x000000)));

        this.add(Movie5);
        this.add(Movie5ticket);

        Movie6 = new JPanel();
        Movie6.setBounds(78, 398, 150, 150);
        Movie6.setBackground(new java.awt.Color(0xFFF0DA));
        Movie6ticket = new JButton();
        Movie6ticket.setBounds(78, 568, 150, 25);
        Movie6ticket.setBackground(new java.awt.Color(0x27A600));
        Movie6ticket.setFocusable(false);
        Movie6ticket.setUI(new RoundButtonUI(new Color(0x000000)));

        this.add(Movie6);
        this.add(Movie6ticket);

        Movie7 = new JPanel();
        Movie7.setBounds(277, 398, 150, 150);
        Movie7.setBackground(new java.awt.Color(0xFFF0DA));
        Movie7ticket = new JButton();
        Movie7ticket.setBounds(277, 568, 150, 25);
        Movie7ticket.setBackground(new java.awt.Color(0x27A600));
        Movie7ticket.setFocusable(false);
        Movie7ticket.setUI(new RoundButtonUI(new Color(0x000000)));

        this.add(Movie7);
        this.add(Movie7ticket);

        Movie8 = new JPanel();
        Movie8.setBounds(474, 398, 150, 150);
        Movie8.setBackground(new java.awt.Color(0xFFF0DA));
        Movie8ticket = new JButton();
        Movie8ticket.setBounds(474, 568, 150, 25);
        Movie8ticket.setBackground(new java.awt.Color(0x27A600));
        Movie8ticket.setFocusable(false);
        Movie8ticket.setUI(new RoundButtonUI(new Color(0x000000)));

        this.add(Movie8);
        this.add(Movie8ticket);

        Movie9 = new JPanel();
        Movie9.setBounds(672, 398, 150, 150);
        Movie9.setBackground(new java.awt.Color(0xFFF0DA));
        Movie9ticket = new JButton();
        Movie9ticket.setBounds(672, 568, 150, 25);
        Movie9ticket.setBackground(new java.awt.Color(0x27A600));
        Movie9ticket.setFocusable(false);
        Movie9ticket.setUI(new RoundButtonUI(new Color(0x000000)));

        this.add(Movie9);
        this.add(Movie9ticket);


        SearchBarTextField = new JTextField();
        SearchBarTextField.setBounds(0, 0, 1000, 30);
        SearchBarTextField.setFont(new Font("Arial", Font.BOLD, 17));
        SearchBarTextField.setBackground(new java.awt.Color(0x012757));
        SearchBarTextField.setForeground(Color.WHITE);
        SearchBarTextField.setCaretColor(Color.WHITE);
        SearchBarPanel.add(SearchBarTextField);

        // Revalidate and repaint to ensure the SettingsPanel is displayed
        this.revalidate();
        this.repaint();
        

    }

    public void SettingsButtonPress(){
        SettingsPanel = new JPanel();
        SettingsPanel.setBounds(x, 0, 260, 650);
        SettingsPanel.setBackground(new java.awt.Color(0x00357B));
        SettingsPanel.setVisible(true);

        JLabel SettingsText = new JLabel("Settings");
        SettingsText.setBounds(48, 16, 240, 30);
        SettingsText.setFont(new Font("Arial", Font.BOLD, 40));
        SettingsText.setBackground(Color.WHITE);

        SettingsPanel.add(SettingsText);

        JButton EditAccount = new JButton();
        EditAccount.setBounds(48, 83, 225, 30);
        EditAccount.setBackground(new Color(0x777777));
        EditAccount.setFocusable(false);
        EditAccount.setUI(new RoundButtonUI(new Color(0x000000))); // Set custom UI

        SettingsPanel.add(EditAccount);

        JButton MoreFilters = new JButton();
        MoreFilters.setBounds(48, 142, 225, 30);
        MoreFilters.setBackground(new Color(0x777777));
        MoreFilters.setFocusable(false);
        MoreFilters.setUI(new RoundButtonUI(new Color(0x000000))); // Set custom UI

        SettingsPanel.add(MoreFilters);

        JButton DarkTheme = new JButton();
        DarkTheme.setBounds(48, 201, 225, 30);
        DarkTheme.setBackground(new Color(0x777777));
        DarkTheme.setFocusable(false);
        DarkTheme.setUI(new RoundButtonUI(new Color(0x000000))); // Set custom UI

        SettingsPanel.add(DarkTheme);

        JButton LogOut = new JButton();
        LogOut.setBounds(48, 260, 225, 30);
        LogOut.setBackground(new Color(0x777777));
        LogOut.setFocusable(false);
        LogOut.setUI(new RoundButtonUI(new Color(0x000000))); // Set custom UI

        SettingsPanel.add(LogOut);
        
        JButton Exit = new JButton();
        Exit.setBounds(233, 15, 30, 30);
        Exit.setBackground(new Color(0x777777));
        Exit.setFocusable(false);
        Exit.setUI(new RoundButtonUI(new Color(0x000000))); // Set custom UI

        JLabel X = new JLabel("X");
        X.setBounds(239, 15, 30, 30);
        X.setFont(new Font("Arial", Font.BOLD, 15));
        X.setBackground(Color.WHITE);

        SettingsPanel.add(Exit);
        SettingsPanel.add(X);

        // Revalidate and repaint to ensure the SettingsPanel is displayed
        this.revalidate();
        this.repaint();

        timer = new Timer(10, e -> SlideSettingsPanel());
        timer.start();

    }

    public void SlideSettingsPanel(){
        if(x == 0){
            timer.stop();
            return;
        }
        SettingsPanel.setVisible(true);
        SettingsPanel.setBounds(x, 0, 260, 650);
        x += xVelocity;
    }

    public static void main(String[] args) {
        MovieApp Frame = new MovieApp();
        Frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Settings){
            // Revalidate and repaint to ensure the SettingsPanel is displayed
            this.revalidate();
            this.repaint();
        }
        
    }

}

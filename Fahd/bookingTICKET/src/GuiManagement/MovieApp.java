package GuiManagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MovieApp extends JFrame implements ActionListener {

    public static JButton Settings;

    public static JPanel SearchBarPanel;
    public static JTextField SearchBarTextField;

    public static JLabel FilterText;

    public static JLabel Genre;
    public static JButton GenreButton;

    public static JLabel AgeRestriction;
    public static JButton AgeRestrictionButton;

    public static JLabel Duration;
    public static JButton DurationButton;

    public static JLabel Rating;
    public static JButton RatingButton;

    public static JPanel Movie1;
    public static JButton Movie1ticket;

    public static JPanel Movie2;
    public static JButton Movie2ticket;

    public static JPanel Movie3;
    public static JButton Movie3ticket;

    public static JPanel Movie4;
    public static JButton Movie4ticket;

    public static JPanel Movie5;
    public static JButton Movie5ticket;

    public static JPanel Movie6;
    public static JButton Movie6ticket;

    public static JPanel Movie7;
    public static JButton Movie7ticket;

    public static JPanel Movie8;
    public static JButton Movie8ticket;

    public static JPanel Movie9;
    public static JButton Movie9ticket;

    public MovieApp() {
        this.setTitle("MovieBooking App");
        ImageIcon AppLogo = new ImageIcon("Poo2-TRY-\\Fahd\\bookingTICKET\\Images\\AppLogo.jpg");
        this.setIconImage(AppLogo.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1100, 650);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(new java.awt.Color(0xD2D2D2));
        

        // Settings Button to open the SettingsPanel-------------------------
        Settings = new JButton();
        Settings.setBounds(15, 10, 40, 44);
        Settings.setBackground(new Color(0x005DD8));
        Settings.setFocusable(false);
        Settings.setUI(new RoundButtonUI(new Color(0x000000))); // Set custom UI

        // Filter text -------------------------------------------------------
        FilterText = new JLabel("Filters : ");
        FilterText.setBounds(75, 85, 80, 24);
        FilterText.setFont(new Font("Arial", Font.BOLD, 20));
        FilterText.setBackground(new java.awt.Color(0x595959));

        Genre = new JLabel("Genre");
        Genre.setBounds(180, 85, 70, 24);
        Genre.setFont(new Font("Arial", Font.BOLD, 17));
        Genre.setBackground(new java.awt.Color(0x595959));
        GenreButton = new JButton();
        GenreButton.setBounds(240, 88, 17, 17);
        GenreButton.setBackground(new java.awt.Color(0xA0B2ED));
        GenreButton.setFocusable(false);
        GenreButton.setUI(new RoundButtonUI(new Color(0x000000))); // Set custom UI

        AgeRestriction = new JLabel("Age Restriction");
        AgeRestriction.setBounds(312, 85, 150, 24);
        AgeRestriction.setFont(new Font("Arial", Font.BOLD, 17));
        AgeRestriction.setBackground(new java.awt.Color(0x595959));

        Duration = new JLabel("Duration");
        Duration.setBounds(564, 85, 80, 24);
        Duration.setFont(new Font("Arial", Font.BOLD, 17));
        Duration.setBackground(new java.awt.Color(0x595959));

        Rating = new JLabel("Rating");
        Rating.setBounds(711, 85, 80, 24);
        Rating.setFont(new Font("Arial", Font.BOLD, 17));
        Rating.setBackground(new java.awt.Color(0x595959));

        // search bar to filter movies by name ----------------------------
        SearchBarPanel = new JPanel();
        SearchBarPanel.setBounds(75, 15, 1000, 30);
        SearchBarPanel.setFont(new Font("Arial", Font.BOLD, 17));
        SearchBarPanel.setBackground(new java.awt.Color(0x012757));
        SearchBarPanel.setForeground(Color.WHITE);
        SearchBarPanel.setLayout(null);

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

        Movie2 = new JPanel();
        Movie2.setBounds(277, 150, 150, 150);
        Movie2.setBackground(new java.awt.Color(0xFFF0DA));
        Movie2ticket = new JButton();
        Movie2ticket.setBounds(277, 320, 150, 25);
        Movie2ticket.setBackground(new java.awt.Color(0x27A600));
        Movie2ticket.setFocusable(false);
        Movie2ticket.setUI(new RoundButtonUI(new Color(0x000000)));

        Movie3 = new JPanel();
        Movie3.setBounds(474, 150, 150, 150);
        Movie3.setBackground(new java.awt.Color(0xFFF0DA));
        Movie3ticket = new JButton();
        Movie3ticket.setBounds(474, 320, 150, 25);
        Movie3ticket.setBackground(new java.awt.Color(0x27A600));
        Movie3ticket.setFocusable(false);
        Movie3ticket.setUI(new RoundButtonUI(new Color(0x000000)));

        Movie4 = new JPanel();
        Movie4.setBounds(672, 150, 150, 150);
        Movie4.setBackground(new java.awt.Color(0xFFF0DA));
        Movie4ticket = new JButton();
        Movie4ticket.setBounds(672, 320, 150, 25);
        Movie4ticket.setBackground(new java.awt.Color(0x27A600));
        Movie4ticket.setFocusable(false);
        Movie4ticket.setUI(new RoundButtonUI(new Color(0x000000)));

        Movie5 = new JPanel();
        Movie5.setBounds(871, 150, 150, 150);
        Movie5.setBackground(new java.awt.Color(0xFFF0DA));
        Movie5ticket = new JButton();
        Movie5ticket.setBounds(871, 320, 150, 25);
        Movie5ticket.setBackground(new java.awt.Color(0x27A600));
        Movie5ticket.setFocusable(false);
        Movie5ticket.setUI(new RoundButtonUI(new Color(0x000000)));

        Movie6 = new JPanel();
        Movie6.setBounds(78, 398, 150, 150);
        Movie6.setBackground(new java.awt.Color(0xFFF0DA));
        Movie6ticket = new JButton();
        Movie6ticket.setBounds(78, 568, 150, 25);
        Movie6ticket.setBackground(new java.awt.Color(0x27A600));
        Movie6ticket.setFocusable(false);
        Movie6ticket.setUI(new RoundButtonUI(new Color(0x000000)));

        Movie7 = new JPanel();
        Movie7.setBounds(277, 398, 150, 150);
        Movie7.setBackground(new java.awt.Color(0xFFF0DA));
        Movie7ticket = new JButton();
        Movie7ticket.setBounds(277, 568, 150, 25);
        Movie7ticket.setBackground(new java.awt.Color(0x27A600));
        Movie7ticket.setFocusable(false);
        Movie7ticket.setUI(new RoundButtonUI(new Color(0x000000)));

        Movie8 = new JPanel();
        Movie8.setBounds(474, 398, 150, 150);
        Movie8.setBackground(new java.awt.Color(0xFFF0DA));
        Movie8ticket = new JButton();
        Movie8ticket.setBounds(474, 568, 150, 25);
        Movie8ticket.setBackground(new java.awt.Color(0x27A600));
        Movie8ticket.setFocusable(false);
        Movie8ticket.setUI(new RoundButtonUI(new Color(0x000000)));

        Movie9 = new JPanel();
        Movie9.setBounds(672, 398, 150, 150);
        Movie9.setBackground(new java.awt.Color(0xFFF0DA));
        Movie9ticket = new JButton();
        Movie9ticket.setBounds(672, 568, 150, 25);
        Movie9ticket.setBackground(new java.awt.Color(0x27A600));
        Movie9ticket.setFocusable(false);
        Movie9ticket.setUI(new RoundButtonUI(new Color(0x000000)));

        this.add(Settings);

        this.add(Movie1);
        this.add(Movie1ticket);

        this.add(Movie2);
        this.add(Movie2ticket);

        this.add(Movie3);
        this.add(Movie3ticket);

        this.add(Movie4);
        this.add(Movie4ticket);

        this.add(Movie5);
        this.add(Movie5ticket);

        this.add(Movie6);
        this.add(Movie6ticket);

        this.add(Movie7);
        this.add(Movie7ticket);

        this.add(Movie8);
        this.add(Movie8ticket);

        this.add(Movie9);
        this.add(Movie9ticket);


        this.add(FilterText);

        this.add(Genre);
        this.add(GenreButton);

        this.add(AgeRestriction);
        this.add(Duration);
        this.add(Rating);

        this.add(SearchBarPanel);
        

        SearchBarTextField = new JTextField();
        SearchBarTextField.setBounds(0, 0, 1000, 30);
        SearchBarTextField.setFont(new Font("Arial", Font.BOLD, 17));
        SearchBarTextField.setBackground(new java.awt.Color(0x012757));
        SearchBarTextField.setForeground(Color.WHITE);
        SearchBarTextField.setCaretColor(Color.WHITE);
        SearchBarPanel.add(SearchBarTextField);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        MovieApp Frame = new MovieApp();
    }

}

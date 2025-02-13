package GuiManagement;

import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicButtonUI;

public class MovieApp extends JFrame implements ActionListener {

    public static JButton Settings;

    public static JPanel SearchBarPanel;

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
    public static JPanel Movie2;
    public static JPanel Movie3;
    public static JPanel Movie4;
    public static JPanel Movie5;
    public static JPanel Movie6;
    public static JPanel Movie7;
    public static JPanel Movie8;
    public static JPanel Movie9;

    public MovieApp() {
        this.setTitle("MovieBooking App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1100, 650);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(new java.awt.Color(0xD2D2D2));

        // Settings Button to open the SettingsPanel-------------------------
        Settings = new JButton();
        Settings.setBounds(15, 10, 40, 40);
        Settings.setBackground(new Color(0x005DD8));
        Settings.setFocusable(false);
        Settings.setUI(new RoundButtonUI(new java.awt.Color(0x000000)));

        // Filter text -------------------------------------------------------
        FilterText = new JLabel("Filters : ");
        FilterText.setBounds(75, 85, 80, 24);
        FilterText.setFont(new Font("Arial", Font.BOLD, 20));
        FilterText.setBackground(new java.awt.Color(0x595959));

        Genre = new JLabel("Genre");
        Genre.setBounds(180, 85, 70, 24);
        Genre.setFont(new Font("Arial", Font.BOLD, 17));
        Genre.setBackground(new java.awt.Color(0x595959));

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
        JTextField SearchBarTextField = new JTextField();
        SearchBarPanel.setBounds(10, 10, 1000, 30);
        SearchBarPanel.setFont(new Font("Arial", Font.BOLD, 17));
        SearchBarPanel.setBackground(new java.awt.Color(0x012757));
        SearchBarPanel.setForeground(Color.WHITE);
        SearchBarPanel.add(SearchBarTextField);

        this.add(Settings);
        this.add(FilterText);
        this.add(Genre);
        this.add(AgeRestriction);
        this.add(Duration);
        this.add(Rating);
        this.add(SearchBarPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        MovieApp Frame = new MovieApp();

    }

}

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

    public static JLabel FilterText;
    public static JLabel Genre;
    public static JLabel AgeRestriction;
    public static JLabel Duration;
    public static JLabel Rating;

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
        this.setBackground(new java.awt.Color(0xDEDEDE));

        Settings = new JButton();
        Settings.setBounds(15, 10, 40, 40);
        Settings.setBackground(new Color(0x005DD8));
        Settings.setFocusable(false);
        Settings.setUI(new RoundButtonUI());

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

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        MovieApp Frame = new MovieApp();
        Frame.add(Settings);
        Frame.add(FilterText);
        Frame.add(Genre);
        Frame.add(AgeRestriction);
        Frame.add(Duration);
        Frame.add(Rating);
    }

}

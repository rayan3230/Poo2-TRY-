package GuiManagement;

import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.Border;

public class MovieApp extends JFrame {
    public static JLabel FilterText;
    public static JLabel Genre;
    public static JLabel AgeRestriction;
    public static JLabel Duration;
    public static JLabel Rating;

    public MovieApp() {
        this.setTitle("MovieBooking App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1100, 650);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(null);
        this.setBackground(new java.awt.Color(0xDEDEDE));

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

    public static void main(String[] args) {
        MovieApp Frame = new MovieApp();
        Frame.add(FilterText);
        Frame.add(Genre);
        Frame.add(AgeRestriction);
        Frame.add(Duration);
        Frame.add(Rating);
    }
}

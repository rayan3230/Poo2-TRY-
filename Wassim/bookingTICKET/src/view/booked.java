package view;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class booked extends JFrame {

    private JPanel mainPanel;
    private JComboBox<String> movieComboBox;
    private JButton bookSeatButton;
    private JLabel statusLabel;
    private JTextField searchBar;
    private List<String> movies;
    private String userName;

    public booked() {
        this.userName = userName;

        setTitle("Movie Booking System");
        setSize(1100, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel(null); // Use null layout for absolute positioning
        add(mainPanel);

        // Initialize movie list
        movies = new ArrayList<>();
        movies.add("Movie 1");
        movies.add("Movie 2");
        movies.add("Movie 3");

        // Navigation bar panel
        JPanel navPanel = new JPanel(null);
        navPanel.setBounds(0, 0, 200, 800);
        navPanel.setBackground(new Color(0x0B0B0B));

        JButton homeButton = new JButton("Home");
        homeButton.setBounds(0, 50, 200, 30);
        homeButton.setForeground(Color.WHITE);
        homeButton.setBackground(new Color(0x161414));
        homeButton.setBorder(new MatteBorder(0, 0, 0, 2, Color.WHITE)); // White right border
        homeButton.setFocusable(false);
        navPanel.add(homeButton);

        JButton settingsButton = new JButton("Settings");
        settingsButton.setBounds(0, 100, 200, 30);
        settingsButton.setForeground(Color.WHITE);
        settingsButton.setBackground(new Color(0x161414));
        settingsButton.setBorder(new MatteBorder(0, 0, 0, 2, Color.WHITE)); // White right border
        settingsButton.setFocusable(false);
        navPanel.add(settingsButton);

        JButton bookingsButton = new JButton("Bookings Made");
        bookingsButton.setBounds(0, 150, 200, 30);
        bookingsButton.setForeground(Color.WHITE);
        bookingsButton.setBackground(new Color(0x161414));
        bookingsButton.setBorder(new MatteBorder(0, 0, 0, 2, new Color(0xFF0000))); // Red right border
        bookingsButton.setFocusable(false);
        navPanel.add(bookingsButton);

        mainPanel.add(navPanel);

        // Search and filter panel
        JPanel searchPanel = new JPanel(null);
        searchPanel.setBounds(200, 0, 900, 50);
        searchPanel.setBackground(new Color(0x0B0B0B));
        JLabel searchLabel = new JLabel("Search:");
        searchLabel.setBounds(10, 10, 50, 30);
        searchPanel.add(searchLabel);
        searchLabel.setForeground(Color.WHITE);
        searchBar = new JTextField(20);
        searchBar.setBounds(70, 10, 200, 30);
        searchPanel.add(searchBar);

        JLabel filterLabel = new JLabel("Genre:");
        filterLabel.setBounds(300, 10, 50, 30);
        filterLabel.setForeground(Color.WHITE);
        searchPanel.add(filterLabel);

        movieComboBox = new JComboBox<>(movies.toArray(new String[0]));
        movieComboBox.setBounds(360, 10, 80, 30);
        searchPanel.add(movieComboBox);

        mainPanel.add(searchPanel);

        // Main content panel
        JPanel contentPanel = new JPanel(null);
        contentPanel.setBounds(200, 50, 900, 750);
        contentPanel.setBackground(Color.black);

        // Remove cards panel
        // JPanel cardsPanel = new JPanel(null);
        // cardsPanel.setBounds((900-200*3-50*2)/2, 0, 900, 500); // Adjusted bounds
        // cardsPanel.setBackground(Color.BLACK);
        // cardsPanel.setForeground(Color.WHITE);
        // int cardWidth = 230;
        // int cardHeight = 130;
        // int gap = 50;
        // for (int i = 0; i < 6; i++) {
        //     JButton cardButton = new JButton();
        //     cardButton.setBounds((i % 3) * (cardWidth + gap), (i / 3) * (cardHeight + gap), cardWidth, cardHeight);
        //     Border lineBorder = BorderFactory.createLineBorder(Color.WHITE);
        //     cardButton.setBackground(Color.DARK_GRAY);

        //     // Customize the picture for each button
        //     ImageIcon movieIcon = new ImageIcon("Poo2-TRY-\\\\\\\\Wassim\\\\\\\\bookingTICKET\\\\\\\\images\\\\\\\\movie" + (i + 1) + ".png");
        //     cardButton.setIcon(movieIcon);
        //     cardButton.setHorizontalAlignment(SwingConstants.CENTER);
        //     cardButton.setVerticalAlignment(SwingConstants.CENTER);

        //     cardsPanel.add(cardButton);
        // }
        // contentPanel.add(cardsPanel);

        mainPanel.add(contentPanel);

        searchBar.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterMovies();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterMovies();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterMovies();
            }
        });

        setVisible(true);
    }

    private void filterMovies() {
        String searchText = searchBar.getText().toLowerCase();
        movieComboBox.removeAllItems();
        for (String movie : movies) {
            if (movie.toLowerCase().contains(searchText)) {
                movieComboBox.addItem(movie);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new booked();
            }
        });
    }
}
package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class userinterface extends JFrame {

    private JPanel mainPanel;
    private JComboBox<String> movieComboBox;
    private JButton bookSeatButton;
    private JLabel statusLabel;
    private JTextField searchBar;
    private List<String> movies;
    private String userName;
    private JPanel contentPanel;
    private JButton cardButton1, cardButton2, bigBox, cardButton3, cardButton4;

    public userinterface() {
        this.userName = userName;

        setTitle("Movie Booking System");
        setSize(1100, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        mainPanel = new JPanel(null);

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
        homeButton.setBounds(0, 50, 198, 30);
        homeButton.setForeground(Color.WHITE);
        homeButton.setBackground(new Color(0x161414));
        homeButton.setBorder(new MatteBorder(0, 0, 0, 2, new Color(0xFF0000))); // White right border
        homeButton.setFocusable(false);
        navPanel.add(homeButton);

        JButton settingsButton = new JButton("Settings");
        settingsButton.setBounds(0, 100, 198, 30);
        settingsButton.setForeground(Color.WHITE);
        settingsButton.setBackground(new Color(0x161414));
        settingsButton.setBorder(new MatteBorder(0, 0, 0, 2, Color.WHITE)); // White right border
        settingsButton.setFocusable(false);
        navPanel.add(settingsButton);

        JButton bookingsButton = new JButton("Bookings Made");
        bookingsButton.setBounds(0, 150, 198, 30);
        bookingsButton.setForeground(Color.WHITE);
        bookingsButton.setBackground(new Color(0x161414));
        bookingsButton.setBorder(new MatteBorder(0, 0, 0, 2, new Color(0xFFFFFF))); // Red right border
        bookingsButton.setFocusable(false);
        bookingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new booked();
                dispose();
            }
        });
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

        contentPanel = new JPanel(null);
        contentPanel.setBackground(Color.black);
        contentPanel.setPreferredSize(new Dimension(900, 1000));
        
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBounds(190, 50, 900, 750);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        contentPanel.addMouseWheelListener(e->{
            JScrollBar vertical = scrollPane.getVerticalScrollBar();
            int scroll = e.getWheelRotation() ;
            vertical.setValue(vertical.getValue() + scroll * 10);
            
        });

        mainPanel.add(scrollPane);

        cardButton1 = createCardButton();
        contentPanel.add(cardButton1);

        cardButton2 = createCardButton();
        contentPanel.add(cardButton2);

        bigBox = createCardButton();
        contentPanel.add(bigBox);

        cardButton3 = createCardButton();
        contentPanel.add(cardButton3);

        cardButton4 = createCardButton();
        contentPanel.add(cardButton4);

        contentPanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                centerBoxes();
            }
        });

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

        setContentPane(mainPanel);

        setVisible(true);
    }

    private RoundedButton createCardButton() {
        RoundedButton cardButton = new RoundedButton(10);
        //cardButton.setFocusPainted(false);
        cardButton.setPreferredSize(new Dimension(250, 150));
        cardButton.setBackground(Color.DARK_GRAY);
        cardButton.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        ImageIcon movieIcon = new ImageIcon("path/to/your/image.png");
        cardButton.setIcon(movieIcon);
        cardButton.setHorizontalAlignment(SwingConstants.CENTER);
        cardButton.setVerticalAlignment(SwingConstants.CENTER);

        return cardButton;
    }

    private void centerBoxes() {
        int cardWidth = 350;
        int cardHeight = 150;
        int spacing = 20;

        int centerX = (contentPanel.getWidth() - (cardWidth + spacing)) / 2;


        cardButton1.setBounds(200+centerX - cardWidth - spacing / 2, 100 - cardHeight - spacing / 2, cardWidth, cardHeight);
        cardButton2.setBounds(200+centerX + spacing / 2, 100 - cardHeight - spacing / 2, cardWidth, cardHeight);
        bigBox.setBounds(200+centerX - cardWidth, 150, cardWidth * 2 + spacing, cardHeight * 2 + spacing);
        cardButton3.setBounds(200+centerX - cardWidth - spacing / 2, 180 + cardHeight * 2 + spacing * 3 / 2, cardWidth, cardHeight);
        cardButton4.setBounds(200+centerX + spacing / 2, 180 + cardHeight * 2 + spacing * 3 / 2, cardWidth, cardHeight);
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
                new userinterface();
            }
        });
    }
}

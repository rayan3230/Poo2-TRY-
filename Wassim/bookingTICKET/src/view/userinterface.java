package view;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class userinterface extends JFrame {
    
    private JPanel mainPanel;
    private JComboBox<String> movieComboBox;
    private JTextArea accountDetailsTextArea;
    private JButton bookSeatButton;
    private JLabel statusLabel;
    private JTextField searchBar;
    private List<String> movies;

    public userinterface() {
        setTitle("Movie Booking System");
        setSize(1100, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Initialize movie list
        movies = new ArrayList<>();
        movies.add("Movie 1");
        movies.add("Movie 2");
        movies.add("Movie 3");

        // Search bar panel
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());
        searchPanel.add(new JLabel("Search:"));
        searchBar = new JTextField(20);
        searchPanel.add(searchBar);
        mainPanel.add(searchPanel, BorderLayout.NORTH);

        // Movie selection panel
        JPanel moviePanel = new JPanel();
        moviePanel.setLayout(new FlowLayout());
        moviePanel.add(new JLabel("Select Movie:"));
        movieComboBox = new JComboBox<>(movies.toArray(new String[0]));
        moviePanel.add(movieComboBox);
        mainPanel.add(moviePanel, BorderLayout.NORTH);

        // Account details panel
        JPanel accountPanel = new JPanel();
        accountPanel.setLayout(new BorderLayout());
        accountPanel.add(new JLabel("Account Details:"), BorderLayout.NORTH);
        accountDetailsTextArea = new JTextArea(10, 30);
        accountDetailsTextArea.setEditable(false);
        accountPanel.add(new JScrollPane(accountDetailsTextArea), BorderLayout.CENTER);
        mainPanel.add(accountPanel, BorderLayout.CENTER);

        // Movie cards panel
        JPanel cardsPanel = new JPanel();
        cardsPanel.setLayout(new GridLayout(2, 3, 10, 10));
        for (int i = 1; i <= 6; i++) {
            JPanel card = new JPanel();
            card.setLayout(new BorderLayout());
            card.add(new JLabel("Movie " + i), BorderLayout.CENTER);
            cardsPanel.add(card);
        }
        mainPanel.add(cardsPanel, BorderLayout.CENTER);

        // Booking panel
        JPanel bookingPanel = new JPanel();
        bookingPanel.setLayout(new FlowLayout());
        bookSeatButton = new JButton("Book Seat");
        bookingPanel.add(bookSeatButton);
        statusLabel = new JLabel(" ");
        bookingPanel.add(statusLabel);
        mainPanel.add(bookingPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // Add action listener for booking button
        bookSeatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedMovie = (String) movieComboBox.getSelectedItem();
                statusLabel.setText("Seat booked for " + selectedMovie);
            }
        });

        // Add document listener for search bar
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

        // Dummy account details
        accountDetailsTextArea.setText("Name: John Doe\nBalance: $100\nMembership: Gold");

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
                new userinterface();
            }
        });
    }
}

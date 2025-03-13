import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {

public static class OdeonSwingApp extends JFrame {
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public OdeonSwingApp() {
        setTitle("Odeon Cinema Booking");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Create and add panels to the cardPanel
        cardPanel.add(createLoginPanel(), "LOGIN");
        cardPanel.add(createMovieSelectionPanel(), "MOVIE_SELECTION");
        cardPanel.add(createBookingConfirmationPanel(), "BOOKING_CONFIRMATION");

        add(cardPanel);
        cardLayout.show(cardPanel, "LOGIN");
    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simple validation
                if (new String(passField.getPassword()).equals("password")) {
                    cardLayout.show(cardPanel, "MOVIE_SELECTION");
                } else {
                    JOptionPane.showMessageDialog(panel, "Invalid username or password");
                }
            }
        });

        panel.add(userLabel);
        panel.add(userField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(new JLabel()); // Empty label for layout
        panel.add(loginButton);

        return panel;
    }

    private JPanel createMovieSelectionPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("Select a Movie:", SwingConstants.CENTER);
        String[] movies = {"Movie 1", "Movie 2", "Movie 3"};
        JList<String> movieList = new JList<>(movies);
        JButton bookButton = new JButton("Book");

        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedMovie = movieList.getSelectedValue();
                if (selectedMovie != null) {
                    JOptionPane.showMessageDialog(panel, "Booking confirmed for: " + selectedMovie);
                    cardLayout.show(cardPanel, "BOOKING_CONFIRMATION");
                } else {
                    JOptionPane.showMessageDialog(panel, "Please select a movie");
                }
            }
        });

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(new JScrollPane(movieList), BorderLayout.CENTER);
        panel.add(bookButton, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createBookingConfirmationPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel confirmationLabel = new JLabel("Thank you for booking with Odeon!", SwingConstants.CENTER);
        JButton logoutButton = new JButton("Logout");

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "LOGIN");
            }
        });

        panel.add(confirmationLabel, BorderLayout.CENTER);
        panel.add(logoutButton, BorderLayout.SOUTH);

        return panel;
    }

    public static void main(String[] args) {        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new OdeonSwingApp().setVisible(true);
            }
        });
    }
}
}

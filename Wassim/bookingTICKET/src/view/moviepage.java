package view;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;



public class moviepage extends JFrame {

    public moviepage() {
        // Set up the main frame
        setTitle("Movie Page");
        setSize(1100, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the main panel with black background
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.BLACK);
        mainPanel.setLayout(new BorderLayout());

        // Create the top panel with an image background
        JPanel topPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    Image bgImage = ImageIO.read(new File("Poo2-TRY-\\\\Wassim\\\\bookingTICKET\\\\images\\\\frametop.png"));
                    g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        topPanel.setLayout(new BorderLayout());
        topPanel.setPreferredSize(new Dimension(1100, 438));

        // Create a panel for the movie title and description
        JPanel textPanel = new JPanel();
        textPanel.setOpaque(false);
        textPanel.setLayout(null);

        JLabel titleLabel = new JLabel("Movie Title");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(20, 200, 300, 30);
        JLabel descriptionLabel = new JLabel("<html>Movie description goes here. This is a sample description.</html>");
        descriptionLabel.setForeground(Color.WHITE);
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        descriptionLabel.setBounds(20, 230, 500, 100);

        textPanel.add(Box.createVerticalGlue());
        textPanel.add(titleLabel);
        textPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        textPanel.add(descriptionLabel);
        textPanel.add(Box.createVerticalGlue());

        topPanel.add(textPanel, BorderLayout.CENTER);

        mainPanel.add(topPanel, BorderLayout.NORTH);

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new moviepage().setVisible(true);
        });
    }
}

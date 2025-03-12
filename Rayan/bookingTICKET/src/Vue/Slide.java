package Vue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Slide extends JFrame {
    private JPanel slidingPanel;
    private JButton toggleButton;
    private Timer timer;
    private boolean isPanelVisible = false;
    private int panelWidth = 200; // Width of the sliding panel
    private int slideSpeed = 10;  // Speed of the slide (pixels per timer tick)

    public Slide() {
        // Set up the main frame
        setTitle("Sliding Panel Example");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the sliding panel
        slidingPanel = new JPanel();
        slidingPanel.setBackground(Color.BLUE);
        slidingPanel.setPreferredSize(new Dimension(panelWidth, getHeight()));
        slidingPanel.setBounds(-panelWidth, 0, panelWidth, getHeight()); // Start off-screen

        // Add components to the sliding panel
        JLabel label = new JLabel("Sliding Panel");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        slidingPanel.add(label);

        // Add the sliding panel to the frame
        add(slidingPanel, BorderLayout.WEST);

        // Create a button to toggle the sliding panel
        toggleButton = new JButton("Toggle Panel");
        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                togglePanel();
            }
        });
        add(toggleButton, BorderLayout.NORTH);

        // Set up the timer for the sliding animation
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slidePanel();
            }
        });

        // Make the frame visible
        setVisible(true);
    }

    // Method to toggle the sliding panel
    private void togglePanel() {
        isPanelVisible = !isPanelVisible;
        timer.start();
    }

    // Method to handle the sliding animation
    private void slidePanel() {
        int targetX = isPanelVisible ? 0 : -panelWidth; // Target position
        int currentX = slidingPanel.getX();

        if (currentX < targetX) {
            slidingPanel.setLocation(Math.min(currentX + slideSpeed, targetX), 0);
        } else if (currentX > targetX) {
            slidingPanel.setLocation(Math.max(currentX - slideSpeed, targetX), 0);
        }

        // Stop the timer when the target position is reached
        if (currentX == targetX) {
            timer.stop();
        }
    }

    public static void main(String[] args) {
        // Run the application on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Slide();
            }
        });
    }
}
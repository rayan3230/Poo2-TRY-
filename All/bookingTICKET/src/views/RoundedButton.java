package views;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

public class RoundedButton extends JButton {
    private int radius;
    private Color normalColor; // Normal background color
    private Color hoverColor;  // Background color on hover

    public RoundedButton(String text, int radius) {
        super(text);
        this.radius = radius;

        // Disable default button styling
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
    }

    // Method to set the hover effect
    public void setHoverEffect(Color normalColor, Color hoverColor) {
        this.normalColor = normalColor;
        this.hoverColor = hoverColor;

        // Set initial background color
        setBackground(normalColor);

        // Add mouse listener for hover effect
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverColor); // Change color on hover
                repaint(); // Repaint to update the button appearance
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(normalColor); // Revert to normal color
                repaint(); // Repaint to update the button appearance
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set the background color based on the button state
        if (getModel().isPressed()) {
            g2.setColor(getBackground().darker()); // Darker color when pressed
        } else {
            g2.setColor(getBackground()); // Normal or hover color
        }

        // Draw the rounded rectangle background
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), radius, radius));
        g2.dispose();

        // Paint the text and icon
        super.paintComponent(g);
    }

    // Optional: Remove or comment out the paintBorder method
    /*
    @Override
    protected void paintBorder(Graphics g) {
        // Border painting removed
    }
    */
}
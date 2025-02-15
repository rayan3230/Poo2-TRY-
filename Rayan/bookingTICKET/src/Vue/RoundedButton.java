package Vue;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

/**
 * A custom JButton with rounded corners.
 */
public class RoundedButton extends JButton {
    private int cornerRadius;

    /**
     * Creates a new RoundedButton with the specified text and corner radius.
     *
     * @param text         The text to display on the button.
     * @param cornerRadius The radius of the button's rounded corners.
     */
    public RoundedButton(String text, int cornerRadius) {
        super(text);
        this.cornerRadius = cornerRadius;
        setContentAreaFilled(false); // Make the button transparent
        setFocusPainted(false); // Remove the focus border
        setBorderPainted(false); // Remove the default border
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the rounded rectangle background
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));

        // Draw the text
        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Do not paint the default border
    }

    /**
     * Sets the corner radius of the button.
     *
     * @param cornerRadius The new corner radius.
     */
    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        repaint(); // Redraw the button with the new corner radius
    }

    /**
     * Gets the current corner radius of the button.
     *
     * @return The current corner radius.
     */
    public int getCornerRadius() {
        return cornerRadius;
    }
}

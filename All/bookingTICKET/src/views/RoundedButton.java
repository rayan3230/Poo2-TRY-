package views;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

public class RoundedButton extends JButton {
    private int radius;
    private boolean hasBorder = false;
    private Color borderColor;
    private float borderThickness;

    public RoundedButton(String text, int radius) {
        super(text);
        this.radius = radius;
        setContentAreaFilled(false);
        setBorderPainted(false); // Disable border painting
        setFocusPainted(false);
    }

    public void setRoundedBorder(Color color, float thickness) {
        this.hasBorder = true;
        this.borderColor = color;
        this.borderThickness = thickness;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (getModel().isPressed()) {
            g2.setColor(getBackground().darker());
        } else if (getModel().isRollover()) {
            g2.setColor(getBackground().brighter());
        } else {
            g2.setColor(getBackground());
        }

        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), radius, radius));

        if (hasBorder) {
            g2.setColor(borderColor);
            g2.setStroke(new BasicStroke(borderThickness));
            g2.draw(new RoundRectangle2D.Double(borderThickness / 2, borderThickness / 2, getWidth() - borderThickness, getHeight() - borderThickness, radius, radius));
        }

        g2.dispose();
        super.paintComponent(g);
    }

    // Remove or comment out the paintBorder method
    /*
    @Override
    protected void paintBorder(Graphics g) {
        // Border painting removed
    }
    */
}
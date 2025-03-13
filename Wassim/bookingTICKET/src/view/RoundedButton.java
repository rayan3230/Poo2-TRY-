package view;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

public class RoundedButton extends JButton {
    private int cornerRadius; // Controls how round the button is

    public RoundedButton(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        setContentAreaFilled(false); // Makes sure the custom paint works
        setFocusPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Background color
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth() , getHeight(), cornerRadius, cornerRadius));
        g2.dispose();
        super.paintComponent(g);
    }

}

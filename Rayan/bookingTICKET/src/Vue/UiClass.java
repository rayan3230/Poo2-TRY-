package Vue;

import java.awt.*;
import javax.swing.*;

public class UiClass extends JFrame{

   public UiClass(){

    setTitle("POO_Movies");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 1200, 750);
    setLocationRelativeTo(null);
    setLayout(null);
    setResizable(false);

   
    JPanel welcomepanel = new JPanel() {
        ImageIcon bgIcon = new ImageIcon("Poo2-TRY-/Rayan/bookingTICKET/img/BackGround 4.png");
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            // Draw the background image with reduced opacity
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
            g2d.drawImage(bgIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            // Draw a semi-transparent black overlay to darken the background
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
            g2d.setColor(Color.black);
            g2d.fillRect(0, 0, getWidth(), getHeight());
            g2d.dispose();
        }
    };
    welcomepanel.setLayout(null);
    welcomepanel.setBounds(0, 0, 1200, 750);
    setContentPane(welcomepanel);
    
    
    JLabel LogoName = new JLabel("LaLaLand");
    LogoName.setBounds(20, 0, 192, 52);
    LogoName.setFont(new Font("Holtwood One SC", Font.PLAIN, 32));
    LogoName.setForeground(Color.red);
    welcomepanel.add(LogoName);
    
    JLabel WelcomingMessage1 = new JLabel("Films et séries en ");
    WelcomingMessage1.setBounds(460, 222, 580, 120);
    WelcomingMessage1.setFont(new Font("Inter", Font.BOLD, 35));
    WelcomingMessage1.setForeground(Color.white);
    welcomepanel.add(WelcomingMessage1);

    JLabel WelcomingMessage2 = new JLabel("illimité, et bien plus");
    WelcomingMessage2.setBounds(446, 270, 580, 120);
    WelcomingMessage2.setFont(new Font("Holtwood One SC", Font.BOLD, 35));
    WelcomingMessage2.setForeground(Color.white);
    welcomepanel.add(WelcomingMessage2);

    JLabel WelcomingMessage3 = new JLabel("Notre projet poo de vente de ticket et booking pour des film en salle de cinema");
    WelcomingMessage3.setBounds(310, 330, 1160, 120);
    WelcomingMessage3.setFont(new Font("Inter", Font.BOLD, 17));
    WelcomingMessage3.setForeground(Color.white);
    welcomepanel.add(WelcomingMessage3);


    JButton LoginButton = new JButton();
    LoginButton.setBounds(1100, 10, 75, 30);
    LoginButton.setText("Login");
    LoginButton.setForeground(Color.white);
    LoginButton.setBackground(new Color(255, 0, 0)); // Background color (RED)
    LoginButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
    LoginButton.setFocusPainted(false); // Removes the dotted border when focused
    LoginButton.setBorderPainted(false); // Removes the button border
    LoginButton.setOpaque(true);
    LoginButton.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            LoginButton.setBackground(Color.gray); // Darker red on hover
        }
    
        public void mouseExited(java.awt.event.MouseEvent evt) {
            LoginButton.setBackground(new Color(255, 0, 0)); // Original red when not hovering
        }
    });
    welcomepanel.add(LoginButton);


    JButton RegisterButton = new JButton();
    RegisterButton.setBounds(940, 10, 150, 30);
    RegisterButton.setText("Register");
    RegisterButton.setForeground(Color.white);
    RegisterButton.setBackground(Color.gray); // Background color (GREEN)
    RegisterButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
    RegisterButton.setFocusPainted(false); // Removes the dotted border when focused
    RegisterButton.setBorderPainted(false); // Removes the button border
    RegisterButton.setOpaque(true);
    RegisterButton.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            RegisterButton.setBackground(new Color(200, 0, 0)); // Darker red on hover
        }
    
        public void mouseExited(java.awt.event.MouseEvent evt) {
            RegisterButton.setBackground(Color.gray); // Original red when not hovering
        }
    });
    welcomepanel.add(RegisterButton);

    JPanel InputPanel = new JPanel();
    InputPanel.setBounds(300, 440, 500, 50);
    InputPanel.setBackground(Color.gray);
    InputPanel.setLayout(null);
    welcomepanel.add(InputPanel);

    JTextField TextField = new JTextField();
    TextField.setBounds(0, 0, 500, 50);
    TextField.setOpaque(false); // Removes the background of the text field
    TextField.setFont(new Font("Arial", Font.BOLD, 17));
    TextField.setBackground(Color.gray);
    TextField.setForeground(Color.WHITE);
    TextField.setCaretColor(Color.WHITE);
    TextField.setBorder(BorderFactory.createEmptyBorder());
    InputPanel.add(TextField);





    JButton Button = new JButton();
    Button.setBounds(820, 440, 130, 50);
    Button.setForeground(Color.white);
    Button.setBackground(Color.red); // Background color (RED)
    Button.setFont(new Font("Arial", Font.BOLD, 24));
    Button.setFocusPainted(false); // Removes the dotted border when focused
    Button.setBorderPainted(false); // Removes the button border
    Button.setOpaque(true);
    Button.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            System.exit(0); // Close the application when the X button is clicked
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            Button.setBackground(Color.black); // Darker red on hover
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            Button.setBackground(Color.red); // Original red when not hovering
        }   
    });
    welcomepanel.add(Button);


  


    











   }

   public static void main(String[] args) {
    
        try {
            UiClass frame = new UiClass();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
  
    }

}

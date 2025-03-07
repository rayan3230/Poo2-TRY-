package views;

import java.awt.*;
import java.util.Timer;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class CinemaApp extends JFrame {
    // log in elements :
    public JPanel WelcomePanel;
    public JPanel LogInPanel;
    public JPanel SignInPanel;
    public JPanel RegisterPanel;
    public JPanel ForgotPasswordPanel;
    public JPanel ClientPanel;
    public JPanel AdminPanel;
    public JPanel MainPanel;

    //fonctionnalities elements ---------------------------------------
    public Timer timer, timer2, timer3, timer4;
    public int x = -300;
    public int xVelocity = 30;
    public int x2 = -300;
    public int x2Velocity = 30;
    public JScrollPane scrollPane3, scrollPane4;

    // layout manager -----------------------------------------------------
    public CardLayout MainCardLayout;
    public CinemaApp() {
       // setUndecorated(true); 
       setTitle("POO_Movies");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       ImageIcon AppLogo = new ImageIcon("All\\bookingTICKET\\img\\Logo.png");
       this.setIconImage(AppLogo.getImage());
       setBounds(100, 100, 1200, 750);
       setLocationRelativeTo(null);
       setResizable(false);

        MainCardLayout = new CardLayout();
        MainPanel = new JPanel(MainCardLayout);

        WelcomePanel = createWelcomePanel();
        MainPanel.add(WelcomePanel, "welcome");


        setContentPane(MainPanel);
        MainCardLayout.show(MainPanel, "welcome");




    }


































     public ImageIcon resizedIcon(String path , int height , int width){ // hadi bch tbdl l img l size li rak habo w trj3 direct ImageIcon t7yo direct f label ou f button

        ImageIcon icon = new ImageIcon(path);
        Image image = icon.getImage().getScaledInstance(height, width, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(image);
        

        return  resizedIcon;
    }

    public void validateInput(JTextField textField, String regex) { // hadi tcoloriyi l border ta3 textfield 3la hsab type li rak hab l user ydkhlo f textfield

        String input = textField.getText().trim();
        if (input.equals("   Movie Name") || input.equals("   Film duration") || 
            input.equals("   Film Rating") || input.equals("0da")) {
            textField.setBorder(BorderFactory.createLineBorder(new Color(80, 77, 74))); 
            return;
        }
    
       
        if (input.matches(regex)) {
            textField.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        } else {
            textField.setBorder(BorderFactory.createLineBorder(Color.RED)); 
         //   JOptionPane.showMessageDialog(this, "Please enter a valid input", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void TextAreaBehave(JTextArea textField, String placeholder) {// hadi tktb dakhel l textarea ida makach focus 3lih ida kayen tfasi klch ida tnha l focus w user maktb walo t3awed tktb wch kan fiha
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY);

        textField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (textField.getText().equals(placeholder)) {
                    SwingUtilities.invokeLater(() -> {
                        textField.setText("");
                        textField.setForeground(Color.WHITE);
                    });
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (textField.getText().isEmpty()) {
                    SwingUtilities.invokeLater(() -> {
                        textField.setText(placeholder);
                        textField.setForeground(Color.GRAY);
                    });
                }
            }
        });
    }
    public void TextfieldBehave(JTextField textField, String placeholder) {// kima TextAreaBehave nrk hadi 3la textfield mais brk 
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY);

        textField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (textField.getText().equals(placeholder)) {
                    SwingUtilities.invokeLater(() -> {
                        textField.setText("");
                        textField.setForeground(Color.WHITE);
                    });
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (textField.getText().isEmpty()) {
                    SwingUtilities.invokeLater(() -> {
                        textField.setText(placeholder);
                        textField.setForeground(Color.GRAY);
                    });
                }
            }
        });
    }

    public static void main(String[] args) {
        CinemaApp frame = new CinemaApp();
        frame.setVisible(true);
    }


}

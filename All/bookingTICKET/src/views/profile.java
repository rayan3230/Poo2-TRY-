package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class profile extends JFrame {
    



    public profile() {
        setTitle("profile / Sign-Up");
        setSize(1200, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        JPanel profile = createprofile();
        add(profile);

    }


    public static JPanel createprofile(){

        Color bgcolor = new Color(0x121213);
        Color secondarycolor = new Color(0x151517);

        JPanel profile = new JPanel();
        profile.setBounds(0, 0, 1200, 750);
        profile.setBackground(bgcolor);
        profile.setLayout(null);

        JPanel leftpanel = new JPanel();
        leftpanel.setBounds(0, 0, 215, 750);
        leftpanel.setBackground(secondarycolor);
        profile.add(leftpanel);

        JPanel rightpanel = new JPanel();
        rightpanel.setBounds(215, 0, 985, 750);
        rightpanel.setBackground(Color.black);
        rightpanel.setLayout(null);
        

        JLabel title = new JLabel("Update Account");
        title.setBounds(45, 37, 285, 50);
        title.setForeground(Color.white);
        title.setFont(new Font("Poppins", Font.PLAIN, 32));
        rightpanel.add(title);

        RoundedPanel imageframe = new RoundedPanel(8);
        imageframe.setBounds(45, 110, 270, 260);
        imageframe.setBackground(secondarycolor);
        imageframe.setRoundedBorder(new Color(0x363030), 1);
        rightpanel.add(imageframe);

        RoundedPanel infoframe = new RoundedPanel(1);
        infoframe.setBounds(373, 110, 568, 261);
        infoframe.setBackground(bgcolor);
        infoframe.setLayout(null);
        infoframe.setRoundedBorder(new Color(0x363030), 1);
        rightpanel.add(infoframe);

        JLabel name = new JLabel("");
        name.setFont(new Font("Poppins", Font.BOLD, 20));
        name.setBounds(33, 12, 200, 50);
        name.setForeground(Color.white);
        infoframe.add(name);


        JLabel username = new JLabel("Username :"); 
        username.setBounds(33, 59, 100, 50);
        username.setForeground(Color.white);
        infoframe.add(username);


        JLabel email = new JLabel("Email :");
        email.setBounds(33, 97, 100, 50);
        email.setForeground(Color.white);
        infoframe.add(email);


        JLabel age = new JLabel("Age :");
        age.setBounds(33, 135, 100, 50);
        age.setForeground(Color.white);
        infoframe.add(age);


        JLabel phonenum = new JLabel("Phone Number :");
        phonenum.setBounds(33, 173, 100, 50);
        phonenum.setForeground(Color.white);
        infoframe.add(phonenum);


        JLabel curbalance = new JLabel("Current Balance :");
        curbalance.setBounds(33, 211, 100, 50);
        curbalance.setForeground(Color.white);
        infoframe.add(curbalance);


        RoundedButton mylist = new RoundedButton("My List",3);
        mylist.setBounds(45, 400, 271, 141);
        mylist.setFont(new Font("Poppins", Font.PLAIN, 20));
        mylist.setBackground(secondarycolor);
        mylist.setRoundedBorder(new Color(0x363030), 1);
        mylist.setForeground(Color.white);
        mylist.setFocusPainted(false);
        mylist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            mylist.setRoundedBorder(Color.red, 1);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            mylist.setRoundedBorder(new Color(0x363030), 1);
            }
        });
        rightpanel.add(mylist);

        RoundedPanel actions = new RoundedPanel(8);
        actions.setBounds(373, 400, 568, 141);
        actions.setBackground(secondarycolor);
        actions.setRoundedBorder(new Color(0x363030), 1);
        actions.setLayout(null);
        rightpanel.add(actions,1);

        JLabel actiontitle = new JLabel("Your Actions");
        actiontitle.setBounds(20, 10, 200, 50);
        actiontitle.setForeground(Color.white);
        actiontitle.setFont(new Font("Poppins", Font.BOLD, 20));
        actions.add(actiontitle);

        JButton changeimg = new JButton("Change Image");
        changeimg.setBounds(22, 75, 170, 40);
        changeimg.setBorder(null);
        changeimg.setFocusPainted(false);
        changeimg.setBackground(Color.white);
        changeimg.setForeground(Color.black);
        actions.add(changeimg);

        JButton removeimg = new JButton("Remove Image");
        removeimg.setBounds(211, 75, 170, 40);
        removeimg.setBorder(null);
        removeimg.setFocusPainted(false);
        removeimg.setBackground(Color.white);
        removeimg.setForeground(Color.black);
        actions.add(removeimg);


        JButton Editebalance = new JButton("Edit Balance");
        Editebalance.setBounds(400, 75, 145, 40);
        Editebalance.setBorder(null);
        Editebalance.setFocusPainted(false);
        Editebalance.setBackground(Color.white);
        Editebalance.setForeground(Color.black);
        actions.add(Editebalance);

        RoundedPanel Accountpanel = new RoundedPanel(1);
        Accountpanel.setBounds(44, 567, 897, 125);
        Accountpanel.setBackground(secondarycolor);
        Accountpanel.setLayout(null);
        Accountpanel.setRoundedBorder(new Color(0x363030), 1);
        rightpanel.add(Accountpanel);

        JLabel accounttitle = new JLabel("Account Related");
        accounttitle.setBounds(316, 10, 300, 50);
        accounttitle.setForeground(Color.white);
        accounttitle.setFont(new Font("Poppins", Font.BOLD, 20));
        Accountpanel.add(accounttitle);

        JPanel editpanel = new JPanel();
        editpanel.setBounds(985, 0, 291, 750); 
        editpanel.setBackground(secondarycolor);
        editpanel.setLayout(null);
        rightpanel.add(editpanel, 0);

        JLabel editlabel = new JLabel("Edit Profile");
        editlabel.setBounds(23, 44, 200, 50);
        editlabel.setForeground(Color.white);
        editlabel.setFont(new Font("Poppins", Font.BOLD, 20));
        editpanel.add(editlabel);

        JLabel editusername = new JLabel("Username");
        editusername.setBounds(23, 127, 150, 30);
        editusername.setForeground(Color.white);
        editpanel.add(editusername);

        JCheckBox editusernamebox = new JCheckBox();
        editusernamebox.setBounds(253, 135, 20, 20);
        editusernamebox.setBackground(secondarycolor);
        editpanel.add(editusernamebox);

        JTextField editusernametext = new JTextField();
        editusernametext.setBounds(23, 163, 245, 40);
        editusernametext.setBackground(secondarycolor);
        editusernametext.setForeground(Color.white);
        editusernametext.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.white, 1), new EmptyBorder(0, 10, 0, 0)));
        editusernametext.setCaretColor(Color.white);
        editpanel.add(editusernametext);
        
        JLabel editEmail = new JLabel("Email");
        editEmail.setBounds(23, 222, 150, 30);
        editEmail.setForeground(Color.white);
        editpanel.add(editEmail);

        JCheckBox editemailnamebox = new JCheckBox();
        editemailnamebox.setBounds(253, 222, 20, 20);
        editemailnamebox.setBackground(secondarycolor);
        editpanel.add(editemailnamebox);

        JTextField editemailtext = new JTextField();
        editemailtext.setBounds(23, 260, 242, 40);
        editemailtext.setBackground(secondarycolor);
        editemailtext.setForeground(Color.white);
        editemailtext.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.white, 1), new EmptyBorder(0, 10, 0, 0)));
        editemailtext.setCaretColor(Color.white);
        editpanel.add(editemailtext);

        

        JButton changepersinfo = new JButton("Change Personal Information");
        changepersinfo.setBounds(190, 65, 298, 40);
        changepersinfo.setBorder(null);
        changepersinfo.setFocusPainted(false);
        changepersinfo.setBackground(Color.white);
        changepersinfo.setForeground(Color.black);
        changepersinfo.addActionListener(e -> {

            // Animation to slide the panel in
            Timer timer = new Timer(5, new ActionListener() {
                int x = 1200;
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (x > 694) {
                        x -= 15;
                        editpanel.setBounds(x, 0, 291, 750);
                        rightpanel.revalidate();
                        rightpanel.repaint();
                    } else {
                        ((Timer)e.getSource()).stop();
                    }
                }
            });
            timer.start();
        });
        Accountpanel.add(changepersinfo);

        JButton DeleteAcc = new JButton("Delete Account");
        DeleteAcc.setBounds(507, 65, 200, 40);
        DeleteAcc.setBorder(null);
        DeleteAcc.setFocusPainted(false);
        DeleteAcc.setBackground(Color.RED);
        DeleteAcc.setForeground(Color.white);
        Accountpanel.add(DeleteAcc);


        ImageIcon image = new ImageIcon("Poo2-TRY-\\All\\bookingTICKET\\images\\image.png");
        JLabel imagelabel = new JLabel(image);
        imagelabel.setBounds(0, 0, 900, 750);
        image.setImage(image.getImage().getScaledInstance(imagelabel.getWidth(), imagelabel.getHeight(), Image.SCALE_SMOOTH));
        rightpanel.add(imagelabel);


        profile.add(rightpanel);
        return profile;
    }

    public static void main(String[] args) {
        profile profile = new profile();
        profile.setVisible(true);
    }
}

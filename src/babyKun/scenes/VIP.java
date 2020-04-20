/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package babyKun.scenes;

/**
 *
 * @author Jack
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.Color;

public class VIP extends JPanel {

    /**
     * Define Jcomponents
     */
    private JTextField nameText;
    private JTextField emailText;
    private JTextField mobileText;
    public boolean ifCorrectEmail;
    public boolean ifCorrectMobile;
    public boolean ifCorrectChoice;
    public boolean closeWindow;
    public mainJFrame mj;
    public static String name;

    /**
     * Constructor for the loyalcard JPanel. This JFrame will be invoked once
     * user click Apply for VIP.
     */
    public VIP(mainJFrame mj) {

        this.setVisible(true);
        this.setLayout(null);
        this.mj = mj;

        ifCorrectEmail = false;
        ifCorrectMobile = false;
        ifCorrectChoice = false;

        setBounds(100, 100, 700, 500);

        // After press enter, Jtext will check if the text contains numbers.
        // if no, go to next step, otherwises enter again
        nameText = new JTextField();

        // After press enter, Email text component will lock email details.
        // Check if this box is blank, if is ask user to enter again.
        emailText = new JTextField();
        emailText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {

                        if (emailText.getText().trim().length() == 0) {
                            throw new Exception();
                        }

                        emailText.setEnabled(false);
                        ifCorrectEmail = true;

                    } catch (Exception ex) {
                        emailText.setText("");
                        JOptionPane.showMessageDialog(null, "Please enter your correct email", "Email cannot be blank!",
                                JOptionPane.ERROR_MESSAGE);

                    }

                }

            }
        });
        emailText.setBounds(484, 157, 177, 26);
        this.add(emailText);
        emailText.setColumns(10);

        // After press enter, mobile text component will lock mobile details.
        // Check if this box contains letters, if is ask user to enter again.
        mobileText = new JTextField();
        mobileText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {

                        if (!mobileText.getText().matches(".*\\d.*") || mobileText.getText().trim().length() == 0) {
                            throw new Exception();
                        }

                        mobileText.setEnabled(false);
                        ifCorrectMobile = true;
                    } catch (Exception ex) {
                        mobileText.setText("");
                        JOptionPane.showMessageDialog(null, "Please enter your correct mobile numbers",
                                "Mobile numbers should not contain letters", JOptionPane.ERROR_MESSAGE);

                    }

                }
            }

        });
        mobileText.setBounds(484, 258, 177, 26);
        this.add(mobileText);
        mobileText.setColumns(10);

        // Funny part! The user has to tick the label to go to next step. lol
        final JRadioButton choiceType = new JRadioButton("Absolutely!");
        choiceType.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (choiceType.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Thank you, my friend!", "Have a good day!",
                            JOptionPane.INFORMATION_MESSAGE);
                    ifCorrectChoice = true;
                    choiceType.setEnabled(false);
                }
            }
        });
        choiceType.setBounds(484, 359, 141, 23);
        this.add(choiceType);

        // Desciption labels
        JLabel vipLabel = new JLabel("VIP Application Form");
        vipLabel.setFont(new Font("Zapfino", Font.BOLD, 16));
        vipLabel.setBounds(306, 41, 248, 54);
        this.add(vipLabel);

        JLabel trickyLabel = new JLabel("Do you think this assginment can receive");
        trickyLabel.setBounds(127, 359, 268, 16);
        this.add(trickyLabel);

        JLabel phoneLabel = new JLabel("Please enter your mobile numbers. (No letters)");
        phoneLabel.setBounds(127, 258, 316, 16);
        this.add(phoneLabel);

        JLabel emailLabel = new JLabel("Please enter your email address.");
        emailLabel.setBounds(127, 157, 213, 16);
        this.add(emailLabel);

        // Submit button. Once click, current Jframe will be closed, and the trigger for
        // discount will be open
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (ifCorrectChoice && ifCorrectMobile && ifCorrectEmail) {
                    JOptionPane.showMessageDialog(null, "Dear " + name
                            + ", \nYou have successfully resigistered as our VIP customer, \nand now you can enjoy 20% for all our products!!",
                            "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                    Shop.ifDiscount = true;
                    close();
                } else {
                    JOptionPane.showMessageDialog(null, "Please finish all the fields and press enter!", "Not Done Yet",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        submitButton.setBounds(484, 436, 117, 29);
        this.add(submitButton);

        // Discription labels
        JLabel secondTrickyLabel = new JLabel("50 marks out of 50?");
        secondTrickyLabel.setBounds(127, 378, 248, 16);
        this.add(secondTrickyLabel);

        JLabel warningLabel = new JLabel("Please type 'Enter' after you finish each component!");
        warningLabel.setForeground(Color.RED);
        warningLabel.setBounds(262, 103, 334, 16);
        this.add(warningLabel);
    }

    // Method to quit current JFrame
    public void close() {
        goToShop();
    }

    public void goToShop() {

        JPanel shop = new Shop(this.mj);
        this.mj.getContentPane().removeAll();
        this.mj.add(shop);
        this.mj.revalidate();
        this.mj.repaint();
    }

}

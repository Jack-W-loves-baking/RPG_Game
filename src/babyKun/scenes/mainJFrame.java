/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package babyKun.scenes;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Jack
 */
public class mainJFrame extends javax.swing.JFrame {

    /**
     * Define instances
     */
    Container cn;
    Timer tmPanel;
    Timer tmWord;
    int counter = 0;
    String text;

    /**
     * Constructor to set up JFrame
     */
    public mainJFrame() {
        this.setResizable(false);

        initComponents();
        this.setLocationRelativeTo(null);
        movingWord();

    }

    /**
     * Subtitle scroll effect. Each letter will appear on by one
     */
    public void movingWord() {
        text = topleft.getText();
        ActionListener flyingWord = new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                counter++;
                if (counter > text.length()) {
                    topleft.setText("");
                    counter = 0;
                } else {
                    topleft.setText(text.substring(0, counter));

                }

            }
        };

        tmWord = new Timer(80, flyingWord);
        tmWord.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        topleft = new javax.swing.JLabel();
        topleft1 = new javax.swing.JLabel();
        movePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        exitPic = new javax.swing.JLabel();
        videoLabel = new javax.swing.JLabel();
        endButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        backGroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("babyKun");
        getContentPane().setLayout(new java.awt.CardLayout());

        mainPanel.setBackground(new java.awt.Color(0, 0, 0));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        topleft.setFont(new java.awt.Font("Ayuthaya", 1, 14)); // NOI18N
        topleft.setForeground(new java.awt.Color(255, 255, 255));
        topleft.setText("Awaiting Response...");
        mainPanel.add(topleft, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, -1));

        topleft1.setFont(new java.awt.Font("Ayuthaya", 1, 14)); // NOI18N
        topleft1.setForeground(new java.awt.Color(255, 255, 255));
        topleft1.setText("Video call invited by Kun ");
        mainPanel.add(topleft1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, -1));

        movePanel.setBackground(new java.awt.Color(0, 0, 0));
        movePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/accept.png"))); // NOI18N
        movePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 50, 60));

        exitPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/exit.png"))); // NOI18N
        movePanel.add(exitPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, -1, -1));

        videoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/play1.gif"))); // NOI18N
        movePanel.add(videoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 320, 220));

        endButton.setBorderPainted(false);
        endButton.setContentAreaFilled(false);
        endButton.setFocusPainted(false);
        endButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endButtonActionPerformed(evt);
            }
        });
        movePanel.add(endButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 60, 50));

        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        movePanel.add(startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 50, 60));

        backGroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/phone.png"))); // NOI18N
        backGroundLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        movePanel.add(backGroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 700, 380));

        mainPanel.add(movePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 700, 390));

        getContentPane().add(mainPanel, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * OptionPane will pop up, if yes, exit the program
     *
     * @param evt click exitButton
     */
    private void endButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endButtonActionPerformed
        //Exit Button if use click the cross.
        int yesToExit = JOptionPane.showConfirmDialog(null,
                "You sure to terminate the connection?", "Warning!",
                JOptionPane.YES_NO_OPTION);

        if (yesToExit == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_endButtonActionPerformed

    /**
     * Will pop up the panel in story class.
     *
     * @param evt click startButton
     */
    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed

        //clear current panel and add Prestart Panel.
        JPanel prestart = new PreStart(this);

        this.getContentPane().removeAll();
        this.add(prestart);
        this.revalidate();
        this.repaint();

    }//GEN-LAST:event_startButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainJFrame().setVisible(true);
            }
        });
    }

    public JPanel getMainPanel() {
        return this.mainPanel;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backGroundLabel;
    private javax.swing.JButton endButton;
    private javax.swing.JLabel exitPic;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel movePanel;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel topleft;
    private javax.swing.JLabel topleft1;
    private javax.swing.JLabel videoLabel;
    // End of variables declaration//GEN-END:variables
}

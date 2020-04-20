/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package babyKun.scenes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Jack
 */
public class SceneOne extends javax.swing.JPanel {

    /**
     * Define instances
     */
    public mainJFrame mj;
    int chapterOneX;
    int chapterOneY;
    Timer chapterOne_1;
    int chapterOneX_2;
    int chapterOneY_2;
    Timer chapterOne_2;

    /**
     * Constructor for SceneOne;
     *
     * @param mj frame main class mainJFrame to ensure all the panels are on one
     * JFrame
     */
    public SceneOne(mainJFrame mj) {
        this.mj = mj;
        initComponents();
        movingSubtitle();
        movingWhaleOne();
    }

    /**
     * Action to move the the word
     */
    public void movingSubtitle() {

        chapterOneX = chapterOne.getLocation().x;
        chapterOneY = chapterOne.getLocation().y;

        ActionListener flyingWord = new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                if (chapterOneX >= 490) {
                    chapterOneX -= 20;
                    chapterOne.setLocation(chapterOneX, chapterOneY);
                } else {
                    chapterOne_1.stop();
                    nextButton.setVisible(true);
                }

            }
        };

        chapterOne_1 = new Timer(70, flyingWord);
        chapterOne_1.start();
    }

    //clear and add Questions Panel
    public void goToQuestions() {
        JPanel sQuestions = new Questions(this.mj);
        this.mj.getContentPane().removeAll();
        this.mj.add(sQuestions);
        this.mj.revalidate();
        this.mj.repaint();
    }

    //Action of moving background pic.
    public void movingWhaleOne() {

        chapterOneX_2 = lastPic.getLocation().x;
        chapterOneY_2 = lastPic.getLocation().y;

        ActionListener flyingPic = new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                if (chapterOneX_2 <= 0) {
                    chapterOneX_2 += 1;
                    lastPic.setLocation(chapterOneX_2, chapterOneY_2);
                } else {
                    chapterOne_2.stop();

                }

            }
        };

        chapterOne_2 = new Timer(70, flyingPic);
        chapterOne_2.start();
    }

    //clear current and add Map Panel.
    public void goToMap() {
        Map map = new Map(this.mj);
        this.mj.getContentPane().removeAll();
        this.mj.add(map);
        this.mj.revalidate();
        this.mj.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chapterOne = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();
        lastPic = new javax.swing.JLabel();

        setLayout(null);

        chapterOne.setFont(new java.awt.Font("Meiryo", 1, 18)); // NOI18N
        chapterOne.setForeground(new java.awt.Color(51, 51, 51));
        chapterOne.setText("Chapter One - End");
        chapterOne.setToolTipText("");
        add(chapterOne);
        chapterOne.setBounds(640, 380, 180, 40);

        nextButton.setForeground(new java.awt.Color(102, 102, 102));
        nextButton.setText("Next>>");
        nextButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nextButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nextButtonMouseExited(evt);
            }
        });
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        add(nextButton);
        nextButton.setBounds(610, 440, 80, 25);

        lastPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/questionBackground.png"))); // NOI18N
        add(lastPic);
        lastPic.setBounds(-10, 0, 720, 500);
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButtonMouseExited
        nextButton.setSize(78, 26);
    }//GEN-LAST:event_nextButtonMouseExited

    private void nextButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButtonMouseEntered
        nextButton.setSize(75, 25);
    }//GEN-LAST:event_nextButtonMouseEntered

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        goToMap();
    }//GEN-LAST:event_nextButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel chapterOne;
    private javax.swing.JLabel lastPic;
    private javax.swing.JButton nextButton;
    // End of variables declaration//GEN-END:variables
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package babyKun.scenes;

import static babyKun.scenes.Fight.countVictories;
import static babyKun.scenes.Fight.enemyCurrentHealth;
import static babyKun.scenes.Fight.kunCurrentHealth;
import static babyKun.scenes.Fight.kunCurrentMana;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Jack
 */
public class Map extends javax.swing.JPanel {

    /**
     * Define instances
     */
    mainJFrame mj;
    String eName;
    Random rd;
    int chance;

    /**
     * static variables passed from fight.If true, a cross will be shown on top
     * of boss labels, and cannot fight again with that boss.
     */
    public static boolean gorillaCross = false;
    public static boolean batCross = false;
    public static boolean scorpionCross = false;
    public static boolean snakeCross = false;

    ArrayList<Integer> arr = new ArrayList<Integer>();
    babyKun.database.DataBase db;

    /**
     * Constructor for Map
     *
     * @param frame frame main class mainJFrame to ensure all the panels are on
     * one JFrame
     */
    public Map(mainJFrame frame) {
        this.mj = frame;

        initComponents();
        crossLabel.setVisible(false);
        crossLabel1.setVisible(false);
        crossLabel2.setVisible(false);
        crossLabel3.setVisible(false);

        /**
         * If true, a cross will be shown on top of boss labels, and cannot
         * fight again with that boss.
         */
        if (gorillaCross) {
            crossLabel.setVisible(true);
            gorillaButton.setEnabled(false);
        }

        if (batCross) {
            crossLabel1.setVisible(true);
            batButton.setEnabled(false);
        }

        if (scorpionCross) {
            crossLabel2.setVisible(true);
            scorpionButton.setEnabled(false);
        }

        if (snakeCross) {
            crossLabel3.setVisible(true);
            snakeButton.setEnabled(false);
        }

    }

    /**
     * Remove current Jpanel and add Fight panel.
     */
    public void goToFight() {

        JPanel fight = new Fight(this.mj);
        this.mj.getContentPane().removeAll();
        this.mj.add(fight);
        this.mj.revalidate();
        this.mj.repaint();
    }

    /**
     * Remove current Jpanel and add Shop panel.
     */
    public void goToShop() {

        JPanel shop = new Shop(this.mj);
        this.mj.getContentPane().removeAll();
        this.mj.add(shop);
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

        explanLabel = new javax.swing.JLabel();
        gorillaButton = new javax.swing.JButton();
        dragButton = new javax.swing.JButton();
        snakeButton = new javax.swing.JButton();
        scorpionButton = new javax.swing.JButton();
        batButton = new javax.swing.JButton();
        crossLabel = new javax.swing.JLabel();
        crossLabel1 = new javax.swing.JLabel();
        crossLabel2 = new javax.swing.JLabel();
        crossLabel3 = new javax.swing.JLabel();
        batLabel = new javax.swing.JLabel();
        gorillaLabel = new javax.swing.JLabel();
        scorpionLabel = new javax.swing.JLabel();
        snakeLabel = new javax.swing.JLabel();
        dragonLabel = new javax.swing.JLabel();
        mapLabel = new javax.swing.JLabel();
        levelUp = new javax.swing.JButton();
        shopButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));
        setLayout(null);

        explanLabel.setForeground(new java.awt.Color(255, 51, 51));
        explanLabel.setText("*Please click the boss you want to fight against, or leveling up with minions.");
        add(explanLabel);
        explanLabel.setBounds(110, 410, 530, 16);

        gorillaButton.setBorderPainted(false);
        gorillaButton.setContentAreaFilled(false);
        gorillaButton.setFocusPainted(false);
        gorillaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gorillaButtonActionPerformed(evt);
            }
        });
        add(gorillaButton);
        gorillaButton.setBounds(130, 110, 60, 70);

        dragButton.setBorderPainted(false);
        dragButton.setContentAreaFilled(false);
        dragButton.setFocusPainted(false);
        dragButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dragButtonActionPerformed(evt);
            }
        });
        add(dragButton);
        dragButton.setBounds(260, 60, 80, 80);

        snakeButton.setBorderPainted(false);
        snakeButton.setContentAreaFilled(false);
        snakeButton.setFocusPainted(false);
        snakeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                snakeButtonActionPerformed(evt);
            }
        });
        add(snakeButton);
        snakeButton.setBounds(330, 180, 60, 60);

        scorpionButton.setBorderPainted(false);
        scorpionButton.setContentAreaFilled(false);
        scorpionButton.setFocusPainted(false);
        scorpionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scorpionButtonActionPerformed(evt);
            }
        });
        add(scorpionButton);
        scorpionButton.setBounds(260, 260, 50, 60);

        batButton.setBorderPainted(false);
        batButton.setContentAreaFilled(false);
        batButton.setFocusPainted(false);
        batButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batButtonActionPerformed(evt);
            }
        });
        add(batButton);
        batButton.setBounds(200, 190, 60, 50);

        crossLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/redCross.png"))); // NOI18N
        add(crossLabel);
        crossLabel.setBounds(130, 110, 70, 70);

        crossLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/redCross.png"))); // NOI18N
        add(crossLabel1);
        crossLabel1.setBounds(190, 180, 70, 70);

        crossLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/redCross.png"))); // NOI18N
        add(crossLabel2);
        crossLabel2.setBounds(260, 260, 70, 70);

        crossLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/redCross.png"))); // NOI18N
        add(crossLabel3);
        crossLabel3.setBounds(330, 180, 70, 70);

        batLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/batIcon.png"))); // NOI18N
        batLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                batLabelMouseClicked(evt);
            }
        });
        add(batLabel);
        batLabel.setBounds(180, 180, 120, 60);

        gorillaLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/GorillaIcon.png"))); // NOI18N
        gorillaLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gorillaLabelMouseClicked(evt);
            }
        });
        add(gorillaLabel);
        gorillaLabel.setBounds(130, 110, 60, 70);

        scorpionLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/scorpionIcon.png"))); // NOI18N
        scorpionLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scorpionLabelMouseClicked(evt);
            }
        });
        add(scorpionLabel);
        scorpionLabel.setBounds(240, 240, 90, 100);

        snakeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/snakeIcon.png"))); // NOI18N
        snakeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                snakeLabelMouseClicked(evt);
            }
        });
        add(snakeLabel);
        snakeLabel.setBounds(320, 160, 80, 90);

        dragonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/dragonIcon.png"))); // NOI18N
        dragonLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dragonLabelMouseClicked(evt);
            }
        });
        add(dragonLabel);
        dragonLabel.setBounds(260, 60, 80, 90);

        mapLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/treasureMap.png"))); // NOI18N
        mapLabel.setText("jLabel1");
        add(mapLabel);
        mapLabel.setBounds(10, 30, 694, 380);

        levelUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/unicon.png"))); // NOI18N
        levelUp.setText("Leveling");
        levelUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                levelUpActionPerformed(evt);
            }
        });
        add(levelUp);
        levelUp.setBounds(190, 440, 140, 40);

        shopButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/witch.png"))); // NOI18N
        shopButton.setText("Shop");
        shopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shopButtonActionPerformed(evt);
            }
        });
        add(shopButton);
        shopButton.setBounds(370, 440, 130, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void shopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shopButtonActionPerformed
        goToShop();
    }//GEN-LAST:event_shopButtonActionPerformed

    private void levelUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_levelUpActionPerformed

        //50% to fight with a pirate or a monster.
        rd = new Random();
        chance = rd.nextInt(2);
        db = new babyKun.database.DataBase();
        db.createEnermyDB();

        if (chance == 1) {

            Fight.enemyName = EnemyInfo.enemyName = "Pirate";
            Fight.enemyAttributes = db.EnemyAttributes("Pirate");

        } else {
            Fight.enemyName = EnemyInfo.enemyName = "monster";
            Fight.enemyAttributes = db.EnemyAttributes("Skeleton");
        }

        Fight.background = "treeFight";

        goToFight();
    }//GEN-LAST:event_levelUpActionPerformed

    private void gorillaLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gorillaLabelMouseClicked

    }//GEN-LAST:event_gorillaLabelMouseClicked

    private void batLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_batLabelMouseClicked

    }//GEN-LAST:event_batLabelMouseClicked

    private void scorpionLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scorpionLabelMouseClicked

    }//GEN-LAST:event_scorpionLabelMouseClicked

    private void snakeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_snakeLabelMouseClicked

    }//GEN-LAST:event_snakeLabelMouseClicked

    private void dragonLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragonLabelMouseClicked

    }//GEN-LAST:event_dragonLabelMouseClicked

    private void gorillaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gorillaButtonActionPerformed

        //Initilize enemy as Gorilla and intilize enemy Jtable attributes as in the database
        Fight.background = "treeFight";
        EnemyInfo.enemyName = Fight.enemyName = "Gorilla";

        db = new babyKun.database.DataBase();
        db.createEnermyDB();
        Fight.enemyAttributes = db.EnemyAttributes("Gorilla");
        Enemy.winGorilla = true;

        goToFight();
    }//GEN-LAST:event_gorillaButtonActionPerformed

    private void dragButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dragButtonActionPerformed
        //Can only fight with the drag when beated all the rest of bosses.
        if (Fight.countVictories >= 4) {
            //Initilize enemy as dragon and intilize enemy Jtable attributes as in the database
            Fight.background = "ruinedFight";
            EnemyInfo.enemyName = Fight.enemyName = "Dragon";
            db = new babyKun.database.DataBase();
            db.createEnermyDB();
            Fight.enemyAttributes = db.EnemyAttributes("Dragon");
            Enemy.winDragon = true;

            goToFight();
        } else {
            JOptionPane.showMessageDialog(null, "Beat all the prior bosses,\nthen eligible to fight with me!");
        }
    }//GEN-LAST:event_dragButtonActionPerformed

    private void snakeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_snakeButtonActionPerformed
        //Initilize snake as Gorilla and intilize enemy Jtable attributes as in the database
        Fight.background = "treeFight";
        EnemyInfo.enemyName = Fight.enemyName = "Snake";
        db = new babyKun.database.DataBase();
        db.createEnermyDB();
        Fight.enemyAttributes = db.EnemyAttributes("Snake");
        Enemy.winSnake = true;

        goToFight();
    }//GEN-LAST:event_snakeButtonActionPerformed

    private void scorpionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scorpionButtonActionPerformed
        //Initilize enemy as scorpion and intilize enemy Jtable attributes as in the database
        Fight.background = "treeFight";
        EnemyInfo.enemyName = Fight.enemyName = "Scorpion";
        db = new babyKun.database.DataBase();
        db.createEnermyDB();
        Fight.enemyAttributes = db.EnemyAttributes("Scorpion");
        Enemy.winScorpion = true;

        goToFight();
    }//GEN-LAST:event_scorpionButtonActionPerformed

    private void batButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batButtonActionPerformed
        //Initilize enemy as bat and intilize enemy Jtable attributes as in the database
        Fight.background = "treeFight";
        EnemyInfo.enemyName = Fight.enemyName = "Bat";
        db = new babyKun.database.DataBase();
        db.createEnermyDB();
        Fight.enemyAttributes = db.EnemyAttributes("Bat");
        Enemy.winBat = true;

        goToFight();
    }//GEN-LAST:event_batButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batButton;
    private javax.swing.JLabel batLabel;
    private javax.swing.JLabel crossLabel;
    private javax.swing.JLabel crossLabel1;
    private javax.swing.JLabel crossLabel2;
    private javax.swing.JLabel crossLabel3;
    private javax.swing.JButton dragButton;
    private javax.swing.JLabel dragonLabel;
    private javax.swing.JLabel explanLabel;
    private javax.swing.JButton gorillaButton;
    private javax.swing.JLabel gorillaLabel;
    private javax.swing.JButton levelUp;
    private javax.swing.JLabel mapLabel;
    private javax.swing.JButton scorpionButton;
    private javax.swing.JLabel scorpionLabel;
    private javax.swing.JButton shopButton;
    private javax.swing.JButton snakeButton;
    private javax.swing.JLabel snakeLabel;
    // End of variables declaration//GEN-END:variables
}

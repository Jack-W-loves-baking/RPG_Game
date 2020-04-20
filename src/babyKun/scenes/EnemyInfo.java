/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package babyKun.scenes;

import static babyKun.scenes.Fight.enemyName;
import static babyKun.scenes.GenerateKun.kunName;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class EnemyInfo extends javax.swing.JPanel {

    /**
     * Define instances.
     */
    public mainJFrame mj;
    DefaultTableModel model;
    ArrayList<Integer> arr = new ArrayList<Integer>();

    /**
     * static enemyName passed from Map class
     */
    public static String enemyName;
    babyKun.database.DataBase db;

    /**
     * Constructor for EnemyInfo
     *
     * @param mj frame main class mainJFrame to ensure all the panels are on one
     */
    public EnemyInfo(mainJFrame mj) {
        this.mj = mj;

        initComponents();
        changeIcon();
        updataTable();
    }

    /**
     * Update Jtable details.
     */
    public void updataTable() {
        model = (DefaultTableModel) cTable.getModel();
        model.insertRow(model.getRowCount(), new Object[]{enemyName, Fight.enemyAttributes.get(0), Fight.enemyAttributes.get(1), Fight.enemyAttributes.get(2), Fight.enemyAttributes.get(3), Fight.enemyAttributes.get(4) + "%"});
    }

    /**
     * change the icon for the Jlabel based on enemyName passed.
     */
    public void changeIcon() {

        String iconLocation = "/babyKun/icons/" + enemyName + ".png";
        enemyLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(iconLocation)));

    }

    /**
     * remove current panel and add Fight panel.
     */
    public void goToFight() {
        JPanel fight = new Fight(this.mj);
        this.mj.getContentPane().removeAll();
        this.mj.add(fight);
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

        backButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        cTable = new javax.swing.JTable();
        text1 = new javax.swing.JLabel();
        text2 = new javax.swing.JLabel();
        dialog = new javax.swing.JLabel();
        enemyLabel = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setLayout(null);

        backButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/castle.png"))); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton);
        backButton.setBounds(550, 440, 140, 40);

        cTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Enemy", "Health", "Mana", "Attack", "Defence", "CriticalChance"
            }
        ));
        jScrollPane1.setViewportView(cTable);

        add(jScrollPane1);
        jScrollPane1.setBounds(40, 320, 630, 50);

        text1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text1.setText("Come on!");
        add(text1);
        text1.setBounds(410, 130, 100, 17);

        text2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text2.setText("Show me somthing!");
        add(text2);
        text2.setBounds(410, 150, 140, 17);

        dialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/dialog.gif"))); // NOI18N
        add(dialog);
        dialog.setBounds(370, 80, 210, 130);

        enemyLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/bat.png"))); // NOI18N
        add(enemyLabel);
        enemyLabel.setBounds(220, 70, 210, 240);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/treeFight.gif"))); // NOI18N
        add(background);
        background.setBounds(0, 0, 700, 500);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        goToFight();
    }//GEN-LAST:event_backButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel background;
    private javax.swing.JTable cTable;
    private javax.swing.JLabel dialog;
    private javax.swing.JLabel enemyLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel text1;
    private javax.swing.JLabel text2;
    // End of variables declaration//GEN-END:variables
}
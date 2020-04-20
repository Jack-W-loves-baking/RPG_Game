/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package babyKun.scenes;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Jack
 */
public class Questions extends javax.swing.JPanel {

    /**
     * Creates define instances
     */
    public mainJFrame mj;
    public static String userName = "";
    public int point = 0;
    boolean firstQ = false;
    boolean secondQ = false;

    /**
     * Constructor for Questions
     *
     * @param frame frame main class mainJFrame to ensure all the panels are on
     * one JFrame
     */
    public Questions(mainJFrame frame) {
        this.mj = frame;
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        q1Panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        q1Question = new javax.swing.JTextArea();
        q1QuestionA = new javax.swing.JRadioButton();
        q1QuestionB = new javax.swing.JRadioButton();
        q1QuestionC = new javax.swing.JRadioButton();
        q2Panel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        q1Question1 = new javax.swing.JTextArea();
        q1QuestionA1 = new javax.swing.JRadioButton();
        q1QuestionB1 = new javax.swing.JRadioButton();
        q1QuestionC1 = new javax.swing.JRadioButton();
        q3Panel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        q1Question2 = new javax.swing.JTextArea();
        q1QuestionA2 = new javax.swing.JRadioButton();
        q1QuestionB2 = new javax.swing.JRadioButton();
        q1QuestionC2 = new javax.swing.JRadioButton();
        q1confirmButton2 = new javax.swing.JButton();
        contentOne = new javax.swing.JLabel();
        contentTwo = new javax.swing.JLabel();
        whaleLabel = new javax.swing.JLabel();
        dialogLabel = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setLayout(null);

        q1Question.setColumns(20);
        q1Question.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        q1Question.setRows(5);
        q1Question.setText("Hi "+userName+",\n\n"+"Do you think \nshopping is more exciting\nthan reading?");
        q1Question.setWrapStyleWord(true);
        jScrollPane1.setViewportView(q1Question);

        q1QuestionA.setText("Yes, definately!");

        q1QuestionB.setText("Just so so.");

        q1QuestionC.setText("Not at all.");

        javax.swing.GroupLayout q1PanelLayout = new javax.swing.GroupLayout(q1Panel);
        q1Panel.setLayout(q1PanelLayout);
        q1PanelLayout.setHorizontalGroup(
            q1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(q1PanelLayout.createSequentialGroup()
                .addGroup(q1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(q1PanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(q1PanelLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(q1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(q1QuestionB, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(q1QuestionA)
                            .addComponent(q1QuestionC, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        q1PanelLayout.setVerticalGroup(
            q1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(q1PanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(q1QuestionA)
                .addGap(18, 18, 18)
                .addComponent(q1QuestionB)
                .addGap(18, 18, 18)
                .addComponent(q1QuestionC)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Question 1", q1Panel);

        q1Question1.setColumns(20);
        q1Question1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        q1Question1.setRows(5);
        q1Question1.setText("Hi "+userName+",\n\n"+"Do you like\ncats more than dogs?");
        q1Question1.setWrapStyleWord(true);
        jScrollPane2.setViewportView(q1Question1);

        q1QuestionA1.setText("Yes, definately!");

        q1QuestionB1.setText("Just so so.");

        q1QuestionC1.setText("Not at all.");

        javax.swing.GroupLayout q2PanelLayout = new javax.swing.GroupLayout(q2Panel);
        q2Panel.setLayout(q2PanelLayout);
        q2PanelLayout.setHorizontalGroup(
            q2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(q2PanelLayout.createSequentialGroup()
                .addGroup(q2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(q2PanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(q2PanelLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(q2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(q1QuestionB1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(q1QuestionC1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(q1QuestionA1, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        q2PanelLayout.setVerticalGroup(
            q2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(q2PanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(q1QuestionA1)
                .addGap(18, 18, 18)
                .addComponent(q1QuestionB1)
                .addGap(18, 18, 18)
                .addComponent(q1QuestionC1)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Question 2", q2Panel);

        q1Question2.setColumns(20);
        q1Question2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        q1Question2.setRows(5);
        q1Question2.setText("Hi "+userName+",\n\n"+"Do you like\nthe colour of Blue?");
        q1Question2.setWrapStyleWord(true);
        jScrollPane3.setViewportView(q1Question2);

        q1QuestionA2.setText("Yes, definately!");

        q1QuestionB2.setText("Just so so.");

        q1QuestionC2.setText("Not at all.");

        q1confirmButton2.setText("Submit");
        q1confirmButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                q1confirmButton2MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                q1confirmButton2MouseEntered(evt);
            }
        });
        q1confirmButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                q1confirmButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout q3PanelLayout = new javax.swing.GroupLayout(q3Panel);
        q3Panel.setLayout(q3PanelLayout);
        q3PanelLayout.setHorizontalGroup(
            q3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(q3PanelLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(q3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(q1QuestionB2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(q1QuestionA2)
                    .addComponent(q1QuestionC2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(q1confirmButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, q3PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        q3PanelLayout.setVerticalGroup(
            q3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(q3PanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(q1QuestionA2)
                .addGap(18, 18, 18)
                .addComponent(q1QuestionB2)
                .addGap(18, 18, 18)
                .addComponent(q1QuestionC2)
                .addGap(18, 18, 18)
                .addComponent(q1confirmButton2)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Question 3", q3Panel);

        add(tabbedPane);
        tabbedPane.setBounds(340, 100, 320, 370);

        contentOne.setBackground(new java.awt.Color(0, 0, 0));
        contentOne.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        contentOne.setText("Answer three questions,");
        add(contentOne);
        contentOne.setBounds(150, 270, 170, 20);

        contentTwo.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        contentTwo.setText("get your own Kun!");
        add(contentTwo);
        contentTwo.setBounds(170, 290, 130, 16);

        whaleLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/whaleGif.gif"))); // NOI18N
        whaleLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        add(whaleLabel);
        whaleLabel.setBounds(10, 280, 200, 200);

        dialogLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dialogLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/dialog.gif"))); // NOI18N
        dialogLabel.setText("jLabel2");
        add(dialogLabel);
        dialogLabel.setBounds(130, 230, 200, 120);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/questionBackground.png"))); // NOI18N
        add(background);
        background.setBounds(0, 0, 700, 500);
    }// </editor-fold>//GEN-END:initComponents

    private void q1confirmButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_q1confirmButton2ActionPerformed
        //User has to answer all of the questions.
        if ((q1QuestionA2.isSelected() && q1QuestionB2.isSelected())
                //cannot select more than 1 answer per question
                || (q1QuestionA2.isSelected() && q1QuestionC2.isSelected())
                || (q1QuestionC2.isSelected() && q1QuestionB2.isSelected()) || (q1QuestionA1.isSelected() && q1QuestionB1.isSelected())
                || (q1QuestionA1.isSelected() && q1QuestionC1.isSelected())
                || (q1QuestionC1.isSelected() && q1QuestionB1.isSelected()) || (q1QuestionA.isSelected() && q1QuestionB.isSelected())
                || (q1QuestionA.isSelected() && q1QuestionC.isSelected())
                || (q1QuestionC.isSelected() && q1QuestionB.isSelected())) {
            JOptionPane.showMessageDialog(null, "Please choose one option per question!");
            //cannot be blank
        } else if ((!q1QuestionA2.isSelected() && !q1QuestionB2.isSelected() && !q1QuestionC2.isSelected())
                || (!q1QuestionA1.isSelected() && !q1QuestionB1.isSelected() && !q1QuestionC1.isSelected())
                || (!q1QuestionA.isSelected() && !q1QuestionB.isSelected() && !q1QuestionC.isSelected())) {
            JOptionPane.showMessageDialog(null, "Please choose at least one option per question!");

        } else {

            int yesOrNo = JOptionPane.showConfirmDialog(null, "You sure to sumbit?", "Please confirm", JOptionPane.YES_NO_OPTION);
            if (yesOrNo == 0) {

                String name = "";
                boolean running = true;
                //calculate the score based on the questions answered.
                Generate:
                while (running) {
                    name = JOptionPane.showInputDialog("Please give your Kun a name");
                    if (name != null && name.length() > 0 && !name.matches(".*\\d.*")) {

                        if (q1QuestionA2.isSelected()) {
                            point += 3;
                        }
                        if (q1QuestionA1.isSelected()) {
                            point += 3;
                        }
                        if (q1QuestionA.isSelected()) {
                            point += 3;
                        }

                        if (q1QuestionB2.isSelected()) {
                            point += 2;
                        }
                        if (q1QuestionB1.isSelected()) {
                            point += 2;
                        }
                        if (q1QuestionB.isSelected()) {
                            point += 2;
                        }

                        if (q1QuestionC.isSelected()) {
                            point += 1;
                        }
                        if (q1QuestionC2.isSelected()) {
                            point += 1;
                        }
                        if (q1QuestionC1.isSelected()) {
                            point += 1;
                        }

                        running = false;

                    } else {
                        JOptionPane.showMessageDialog(null, "Please give a good name - No numbers :)");
                        continue Generate;
                    }
                }
                //assgin values to relevant class
                GenerateKun.score = point;
                GenerateKun.kunName = name;
                Bag.kunName = name;
                JPanel kunGenerate = new GenerateKun(this.mj);

                this.mj.getContentPane().removeAll();
                this.mj.add(kunGenerate);
                this.mj.revalidate();
                this.mj.repaint();
            }
        }
    }//GEN-LAST:event_q1confirmButton2ActionPerformed

    private void q1confirmButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_q1confirmButton2MouseEntered
        q1confirmButton2.setSize(115, 30);
    }//GEN-LAST:event_q1confirmButton2MouseEntered

    private void q1confirmButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_q1confirmButton2MouseExited
        q1confirmButton2.setSize(112, 29);
    }//GEN-LAST:event_q1confirmButton2MouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel contentOne;
    private javax.swing.JLabel contentTwo;
    private javax.swing.JLabel dialogLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel q1Panel;
    private javax.swing.JTextArea q1Question;
    private javax.swing.JTextArea q1Question1;
    private javax.swing.JTextArea q1Question2;
    private javax.swing.JRadioButton q1QuestionA;
    private javax.swing.JRadioButton q1QuestionA1;
    private javax.swing.JRadioButton q1QuestionA2;
    private javax.swing.JRadioButton q1QuestionB;
    private javax.swing.JRadioButton q1QuestionB1;
    private javax.swing.JRadioButton q1QuestionB2;
    private javax.swing.JRadioButton q1QuestionC;
    private javax.swing.JRadioButton q1QuestionC1;
    private javax.swing.JRadioButton q1QuestionC2;
    private javax.swing.JButton q1confirmButton2;
    private javax.swing.JPanel q2Panel;
    private javax.swing.JPanel q3Panel;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JLabel whaleLabel;
    // End of variables declaration//GEN-END:variables
}

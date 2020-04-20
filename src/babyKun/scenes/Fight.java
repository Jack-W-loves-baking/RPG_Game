/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package babyKun.scenes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;

/**
 *
 * @author Jack
 */
public class Fight extends javax.swing.JPanel {

    /**
     * Define variables.
     */
    mainJFrame frame;
    static String enemyName;
    static String background;
    Timer enemyMoveTimer;
    int enemyLocationX;
    int enemyLocationY;
    int boxLocationX;
    int boxLocationY;
    String iconLocation;
    String backgroundLocation;
    static Kun kun;
    Enemy enemy;
    babyKun.database.DataBase db;
    Timer boxTimer;
    Timer hitEnemyTimer;
    Timer hitKunTimer;
    Timer criticalToKun;
    Timer criticalToEnemy;
    int countHit;
    public static int countVictories = 0;

    //static list passed from GenerateKun and Map.
    static ArrayList<Integer> kunAttributes = new ArrayList<Integer>();
    static ArrayList<Integer> enemyAttributes = new ArrayList<Integer>();

    //Value passed from Kun and Enemy class
    public static int kunCurrentHealth;
    public static int kunCurrentMana;
    static int enemyCurrentHealth;

    //initilize fight related variables
    static int kunLevel = 1;
    static int currentExp = 0;
    final int expGain = 5;
    final int expBossGain = 15;
    final int expRequiredScale = 5;
    final int attributeGainedPerLevel = 5;
    final int healthManaGarinedPerLevel = 20;
    Random rd;
    int chance;
    int type;
    boolean resetHPMP = true;

    /**
     * Constructor for Fight class.
     *
     * @param mj frame main class mainJFrame to ensure all the panels are on one
     * JFrame.
     */
    public Fight(mainJFrame mj) {
        this.frame = mj;

        UIManager.put("ProgressBar.background", Color.RED);
        UIManager.put("ProgressBar.foreground", Color.GREEN);

        //initlize all the relevant components
        initComponents();
        initFightLabel();
        changeIcon();
        moveEnemy();

        //initilize Kun and enemy
        initKun();
        initEnemy();

        //Trigger to prevent currentHealth = maxHealth every time Fight Panel refreshes
        if (Kun.ifReset) {

            kunCurrentHealth = Kun.currentHealth;
            kunCurrentMana = Kun.currentMana;
            enemyCurrentHealth = Kun.currentEnemyHealth;

        }

        if (Kun.ifRun) {
            kunCurrentHealth = Kun.currentHealth;
            kunCurrentMana = Kun.currentMana;
            enemyCurrentHealth = enemy.getHealth();
        }

        //Initilize Jprocess bars
        initHealthBar();
        changeKunHPMPLabel();
        changeEnemyHPLabel();
    }

    //Initilize status for labels
    void initFightLabel() {
        enemyLabel.setVisible(true);
        boxLabel.setVisible(false);
        attackEnemyLabel.setVisible(false);
        attackKunLabel.setVisible(false);
        criticaltoKunPanel.setVisible(false);
        criticaltoEnemyPanel.setVisible(false);
    }

    //initilize Kun's attributes.
    void initKun() {

        kun = new Kun(kunAttributes.get(0), kunAttributes.get(1), kunAttributes.get(2), kunAttributes.get(3), kunAttributes.get(4), kunAttributes.get(5));

        kunCurrentHealth = kun.getHealth();
        kunCurrentMana = kun.getMana();

    }

    //initilize enemy's attributes.
    void initEnemy() {
        enemy = new Enemy(enemyAttributes.get(0), enemyAttributes.get(1), enemyAttributes.get(2), enemyAttributes.get(3), enemyAttributes.get(4));
        enemyCurrentHealth = enemy.getHealth();
    }

    //change enemy and background icons based on the enemy selected.
    public void changeIcon() {

        iconLocation = "/babyKun/icons/" + enemyName + ".png";
        backgroundLocation = "/babyKun/icons/" + background + ".gif";
        enemyLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(iconLocation)));
        fightBackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource(backgroundLocation)));
    }

    //Update kun's health and mp amounts.
    public void changeKunHPMPLabel() {

        healthNumber.setText(Integer.toString(kunCurrentHealth) + "/" + Integer.toString(kunAttributes.get(0)));
        manaNumber.setText(Integer.toString(kunCurrentMana) + "/" + Integer.toString(kunAttributes.get(1)));

    }

    // Update enemy's health amount.
    public void changeEnemyHPLabel() {
        enemyHealthLabel.setText(Integer.toString(enemyCurrentHealth) + "/" + Integer.toString(enemyAttributes.get(0)));
    }

    void initHealthBar() {

        //Set up the background and foreground colour of JprogressBar
        healthBar.setBackground(Color.red);
        healthBar.setBackground(Color.green);

        manaBar.setBackground(Color.red);
        manaBar.setBackground(Color.green);

        enemyHealthBar.setBackground(Color.red);
        enemyHealthBar.setBackground(Color.green);

        //initi EXP, KUNhealth,KunMana, enemyHealth max value and current value for JprogressBar.
        ExpBar.setBackground(Color.red);
        ExpBar.setBackground(Color.green);

        healthBar.setMaximum(kun.getHealth());
        healthBar.setValue(kunCurrentHealth);

        manaBar.setMaximum(kun.getMana());
        manaBar.setValue(kunCurrentMana);

        enemyHealthBar.setMaximum(enemy.getHealth());
        enemyHealthBar.setValue(enemyCurrentHealth);

        //set up the exp bar, which is equal to 5*current level.
        ExpBar.setMaximum(kunLevel * expRequiredScale);
        ExpBar.setValue(currentExp);
    }

    //update Kun's exp bar
    void updateKunExpBar() {
        ExpBar.setValue(currentExp);

    }

    //update kun's health bar
    void updateKunHealthBar() {
        healthBar.setValue(kunCurrentHealth);
    }

    //update kun's name bar
    void updateKunManaBar() {
        manaBar.setValue(kunCurrentMana);
    }

    //update enemy health bar
    void updateEnemyHealthBar() {
        enemyHealthBar.setValue(enemyCurrentHealth);
    }

    //clear current panel and add Map panel to JFrame
    public void goToMap() {
        JPanel map = new Map(this.frame);
        this.frame.getContentPane().removeAll();
        this.frame.add(map);
        this.frame.revalidate();
        this.frame.repaint();
    }

    //clear current panel and add enemyInfo panel to JFrame
    public void goToInfo() {

        JPanel info = new EnemyInfo(this.frame);
        this.frame.getContentPane().removeAll();
        this.frame.add(info);
        this.frame.revalidate();
        this.frame.repaint();
    }

    //clear current panel and add Bag panel to JFrame
    public void goToBag() {
        JPanel bag = new Bag(this.frame);
        this.frame.getContentPane().removeAll();
        this.frame.add(bag);
        this.frame.revalidate();
        this.frame.repaint();
    }

    //actions of moving enemyLabel
    public void moveEnemy() {
        enemyLocationX = enemyLabel.getLocation().x;
        enemyLocationY = enemyLabel.getLocation().y;

        ActionListener flyingPic = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                if (enemyLocationX >= 330) {
                    enemyLocationX -= 20;
                    enemyLabel.setLocation(enemyLocationX, enemyLocationY);
                } else {

                    enemyMoveTimer.stop();

                }

            }
        };

        enemyMoveTimer = new Timer(70, flyingPic);
        enemyMoveTimer.start();

    }

    /**
     * Method to initilize the following process after user used ability attack.
     */
    void abilityAttack() {

        rd = new Random();
        chance = rd.nextInt(100);
//first consider if user has enough mana
        if (kunCurrentMana >= 10) {
            //than consider if this action will be critical damge based on the critical chance of Kun
            if (chance <= kun.getCriticalChance()) {
                enemyCurrentHealth -= 50;
                hitEnemy();
            } else {
                enemyCurrentHealth -= (int) 50 * 1.5;
                hitEnemyCritical();
            }

            //if after the damage , enemy is still alive, we update all the relevant process bars, jLabels.
            if (enemyCurrentHealth > 0) {

                changeEnemyHPLabel();
                updateEnemyHealthBar();
                kunCurrentMana -= 10;
                updateKunManaBar();
                changeKunHPMPLabel();
            } else {
                //Otherwise, enemy die, we win.
                win();
            }
        } else {
            //If not enough mana, nothing would happen
            JOptionPane.showMessageDialog(null, "Not enough Mana, get more in the shop!");
        }
    }

    /**
     * Method to initilize the following procedure after user click attack.
     */
    void attack() {

        //Consider if the damage is critical.
        rd = new Random();
        chance = rd.nextInt(100);

        //If the enemy's defence is higher than Kun's attack, we make the damage a positive value of 1.
        int damage = (kun.getAttack() - enemy.getDefence());
        if (damage < 0) {
            damage = 1;
            hitEnemy();
        } else if (chance <= kun.getCriticalChance()) {
            damage = (int) (damage * 1.5);
            hitEnemyCritical();
        } else {
            hitEnemy();
        }

        //Otherwise, we did the damage to the enemy by the formula (attack- defence)
        enemyCurrentHealth -= damage;

        //Enemy still alive, update relevant Jcomponents.
        if (enemyCurrentHealth > 0) {
            changeEnemyHPLabel();
            updateEnemyHealthBar();
        } else {
            //enemy died, we win.
            win();
        }

    }

    /**
     * Method to initlize the procedure enemy hit Kun
     */
    void attackKun() {
        hitKun();

        //consider if the damage is critical
        rd = new Random();
        chance = rd.nextInt(100);

        int damage = enemy.getAttack() - kun.getDefence();

        //if our defence is too high, we receive 1 damage.
        if (damage < 0) {
            damage = 1;
            hitKun();
        } else if (chance <= enemy.getCriticalChance()) {
            damage = (int) damage * 2;
            hitKunCritical();
        } else {
            hitKun();

        }
        kunCurrentHealth -= damage;

        //if Kun still alive, update relevant Jcomponents.
        if (kunCurrentHealth > 0) {

            updateKunHealthBar();
            changeKunHPMPLabel();

        } else {
            //we die, we can choose to retry or go back to map, buy more items.
            kunCurrentHealth = 0;
            updateKunHealthBar();
            changeKunHPMPLabel();

            int yesOrNot = JOptionPane.showConfirmDialog(null, Bag.kunName + " has been defeated!\nDo you want to retry?", "ohhhh...You die!", JOptionPane.ERROR_MESSAGE);
            if (yesOrNot == 1) {
                goToMap();
            } else {
                JPanel fight = new Fight(this.frame);
                this.frame.getContentPane().removeAll();
                this.frame.add(fight);
                this.frame.revalidate();
                this.frame.repaint();
            }
        }

    }

    //Switch to last scene.
    void goToFinalScene() {
        JPanel last = new FinalScene(this.frame);
        this.frame.getContentPane().removeAll();
        this.frame.add(last);
        this.frame.revalidate();
        this.frame.repaint();
    }

    /**
     * Method to initilize the procedure after we win the fight.
     */
    void win() {

        //Enemy health will be 0, cannot be negative amount.
        enemyCurrentHealth = 0;
        //update relevant Jcomponents.
        changeEnemyHPLabel();
        updateEnemyHealthBar();
        currentExp += expGain;
        enemyLabel.setVisible(false);
        updateKunExpBar();
        JOptionPane.showMessageDialog(null, "You win!!");
        //get items.
        winItem();
        //check if level up
        leveLUp();

        //if we win the boss, there will be cross of top of each of them. If we beat all of the bosses, we can fight with the dragon.
        if (Enemy.winBat) {
            Map.batCross = true;
            countVictories++;
            goToMap();
        }

        if (Enemy.winGorilla) {
            Map.gorillaCross = true;
            countVictories++;
            goToMap();
        }
        if (Enemy.winScorpion) {
            Map.scorpionCross = true;
            countVictories++;
            goToMap();
        }
        if (Enemy.winSnake) {
            Map.snakeCross = true;
            countVictories++;
            goToMap();
        }
        if (Enemy.winDragon) {
            goToFinalScene();

        } else {
            goToMap();
        }
    }

    /**
     * Get money, item based on the luck of Kun.
     */
    void winItem() {

        rd = new Random();
        chance = rd.nextInt(100);
        type = rd.nextInt(3);
        //each time win, get $200;
        Basket.balance += 200;
        JOptionPane.showMessageDialog(null, "You have got $500", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);

        // chance of luck% to get items.
        if (chance <= kun.getLuck()) {
            movingBox();

            if (type == 0) {
                Bag.numberOfHP++;
                JOptionPane.showMessageDialog(null, "You have got Health Potion * 1", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
            } else if (type == 1) {
                Bag.numberOfMP++;
                JOptionPane.showMessageDialog(null, "You have got Mana Potion * 1", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                Bag.numberOfMP++;
                Bag.numberOfHP++;
                JOptionPane.showMessageDialog(null, "You have got Health Potion * 1\nYou have got Mana Potion * 1", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
            }

        }

    }

    //set the status for the monsters
    public void setMonsterStatus() {

        Enemy.winBat = false;
        Enemy.winSnake = false;
        Enemy.winScorpion = false;
        Enemy.winGorilla = false;
        Enemy.winDragon = false;

    }

    //method to initilize the procedure after level up.
    void leveLUp() {

        // show the new attributes. +50 for HP and MP, +5 for rest attributes.
        if (currentExp == kunLevel * expRequiredScale) {
            kunLevel++;
            currentExp = 0;
            JOptionPane.showMessageDialog(null, "Congrats for Level up!" + "\n" + GenerateKun.kunName + " is now Level " + Integer.toString(kunLevel) + "!");
            JOptionPane.showMessageDialog(null, "Health: " + Integer.toString(kun.getHealth()) + " --> " + Integer.toString(kun.getHealth() + healthManaGarinedPerLevel) + "\n"
                    + "Mana: " + Integer.toString(kun.getMana()) + " --> " + Integer.toString(kun.getMana() + healthManaGarinedPerLevel) + "\n"
                    + "Attack: " + Integer.toString(kun.getAttack()) + " --> " + Integer.toString(kun.getAttack() + attributeGainedPerLevel) + "\n"
                    + "Defence: " + Integer.toString(kun.getDefence()) + " --> " + Integer.toString(kun.getDefence() + attributeGainedPerLevel));
            kun.setAttack(kun.getAttack() + attributeGainedPerLevel);
            kun.setHealth(kun.getHealth() + healthManaGarinedPerLevel);
            kun.setMana(kun.getMana() + healthManaGarinedPerLevel);
            kun.setDefence(kun.getDefence() + attributeGainedPerLevel);
            kunAttributes.clear();
            kunAttributes.add(kun.getHealth());
            kunAttributes.add(kun.getMana());
            kunAttributes.add(kun.getAttack());
            kunAttributes.add(kun.getDefence());
            kunAttributes.add(kun.getLuck());
            kunAttributes.add(kun.getCriticalChance());

        }
    }

    //hitEffect, pic pops up.
    public void hitEnemy() {

        countHit = 0;
        attackEnemyLabel.setVisible(true);
        ActionListener hitEnemy = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                countHit++;
                if (countHit > 10) {
                    attackEnemyLabel.setVisible(false);
                    hitEnemyTimer.stop();

                }

            }
        };

        hitEnemyTimer = new Timer(70, hitEnemy);
        hitEnemyTimer.start();
    }

    //hiteffect, pic pop up.
    public void hitKun() {

        countHit = 0;
        attackKunLabel.setVisible(true);
        ActionListener hitEnemy = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                countHit++;
                if (countHit > 10) {
                    attackKunLabel.setVisible(false);
                    hitKunTimer.stop();

                }

            }
        };

        hitKunTimer = new Timer(70, hitEnemy);
        hitKunTimer.start();
    }

    //critical effect, pic pops up.
    public void hitEnemyCritical() {

        countHit = 0;
        criticaltoEnemyPanel.setVisible(true);
        ActionListener citicalToEnemy = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                countHit++;
                if (countHit > 10) {
                    criticaltoEnemyPanel.setVisible(false);
                    criticalToEnemy.stop();

                }

            }
        };

        criticalToEnemy = new Timer(70, citicalToEnemy);
        criticalToEnemy.start();
    }

    //critical effect, pic pops up.
    public void hitKunCritical() {

        countHit = 0;
        criticaltoKunPanel.setVisible(true);
        ActionListener citicalToKun = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                countHit++;
                if (countHit > 10) {
                    criticaltoKunPanel.setVisible(false);
                    criticalToKun.stop();

                }

            }
        };

        criticalToKun = new Timer(70, citicalToKun);
        criticalToKun.start();
    }

    //box effect, pic pops up. For win items.
    public void movingBox() {

        boxLabel.setVisible(true);

        boxLocationX = boxLabel.getLocation().x;
        boxLocationY = boxLabel.getLocation().y;

        ActionListener flyingBox = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                if (boxLocationX <= 360) {
                    boxLocationX += 40;
                    boxLabel.setLocation(boxLocationX, boxLocationY);
                } else {

                    boxTimer.stop();

                }

            }
        };

        boxTimer = new Timer(70, flyingBox);
        boxTimer.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boxLabel = new javax.swing.JLabel();
        criticaltoEnemyPanel = new javax.swing.JPanel();
        criticalLabel1 = new javax.swing.JLabel();
        criticalPic1 = new javax.swing.JLabel();
        criticaltoKunPanel = new javax.swing.JPanel();
        criticalLabel = new javax.swing.JLabel();
        criticalPic = new javax.swing.JLabel();
        attackEnemyLabel = new javax.swing.JLabel();
        attackKunLabel = new javax.swing.JLabel();
        enemyLabel = new javax.swing.JLabel();
        infoButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        attackButton = new javax.swing.JButton();
        AbilityButton = new javax.swing.JButton();
        BagButton = new javax.swing.JButton();
        RunButton = new javax.swing.JButton();
        manaBar = new javax.swing.JProgressBar();
        healthBar = new javax.swing.JProgressBar();
        ExpBar = new javax.swing.JProgressBar();
        MPLabel = new javax.swing.JLabel();
        manaNumber = new javax.swing.JLabel();
        HPLabel = new javax.swing.JLabel();
        healthNumber = new javax.swing.JLabel();
        expLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        HPLabel1 = new javax.swing.JLabel();
        enemyHealthBar = new javax.swing.JProgressBar();
        enemyHealthLabel = new javax.swing.JLabel();
        fighterLabel = new javax.swing.JLabel();
        fightBackGround = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(700, 500));
        setLayout(null);

        boxLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/BOX.png"))); // NOI18N
        add(boxLabel);
        boxLabel.setBounds(0, 130, 195, 200);

        criticaltoEnemyPanel.setOpaque(false);
        criticaltoEnemyPanel.setLayout(null);

        criticalLabel1.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        criticalLabel1.setText("Critical!");
        criticalLabel1.setToolTipText("");
        criticaltoEnemyPanel.add(criticalLabel1);
        criticalLabel1.setBounds(30, 60, 60, 17);

        criticalPic1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/critical.png"))); // NOI18N
        criticaltoEnemyPanel.add(criticalPic1);
        criticalPic1.setBounds(0, 10, 120, 110);

        add(criticaltoEnemyPanel);
        criticaltoEnemyPanel.setBounds(380, 90, 120, 130);

        criticaltoKunPanel.setOpaque(false);
        criticaltoKunPanel.setLayout(null);

        criticalLabel.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        criticalLabel.setText("Critical!");
        criticalLabel.setToolTipText("");
        criticaltoKunPanel.add(criticalLabel);
        criticalLabel.setBounds(30, 60, 60, 17);

        criticalPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/critical.png"))); // NOI18N
        criticaltoKunPanel.add(criticalPic);
        criticalPic.setBounds(0, 10, 140, 110);

        add(criticaltoKunPanel);
        criticaltoKunPanel.setBounds(0, 290, 180, 110);

        attackEnemyLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/attackBoom.png"))); // NOI18N
        add(attackEnemyLabel);
        attackEnemyLabel.setBounds(400, 130, 70, 60);

        attackKunLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/attackBoom.png"))); // NOI18N
        add(attackKunLabel);
        attackKunLabel.setBounds(100, 350, 70, 60);

        enemyLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/bat.png"))); // NOI18N
        add(enemyLabel);
        enemyLabel.setBounds(700, 92, 220, 230);

        infoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/unicon.png"))); // NOI18N
        infoButton.setText("Enemy Info");
        infoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoButtonActionPerformed(evt);
            }
        });
        add(infoButton);
        infoButton.setBounds(470, 50, 240, 40);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(null);

        attackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/bow.png"))); // NOI18N
        attackButton.setText("Attack");
        attackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attackButtonActionPerformed(evt);
            }
        });
        jPanel1.add(attackButton);
        attackButton.setBounds(270, 10, 120, 40);

        AbilityButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/drag.png"))); // NOI18N
        AbilityButton.setText("Ability");
        AbilityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbilityButtonActionPerformed(evt);
            }
        });
        jPanel1.add(AbilityButton);
        AbilityButton.setBounds(400, 10, 120, 40);

        BagButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/letter.png"))); // NOI18N
        BagButton.setText("Bag");
        BagButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BagButtonActionPerformed(evt);
            }
        });
        jPanel1.add(BagButton);
        BagButton.setBounds(270, 60, 120, 40);

        RunButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/castle.png"))); // NOI18N
        RunButton.setText("Run");
        RunButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RunButtonActionPerformed(evt);
            }
        });
        jPanel1.add(RunButton);
        RunButton.setBounds(400, 60, 120, 40);

        manaBar.setBackground(new java.awt.Color(0, 0, 0));
        manaBar.setForeground(new java.awt.Color(51, 255, 51));
        manaBar.setToolTipText("");
        manaBar.setValue(100);
        manaBar.setString("");
        jPanel1.add(manaBar);
        manaBar.setBounds(40, 50, 140, 20);

        healthBar.setBackground(new java.awt.Color(0, 0, 0));
        healthBar.setForeground(new java.awt.Color(51, 255, 51));
        healthBar.setToolTipText("");
        healthBar.setValue(100);
        healthBar.setString("");
        jPanel1.add(healthBar);
        healthBar.setBounds(40, 20, 140, 20);

        ExpBar.setBackground(new java.awt.Color(0, 0, 0));
        ExpBar.setForeground(new java.awt.Color(51, 255, 51));
        ExpBar.setToolTipText("");
        ExpBar.setValue(100);
        ExpBar.setString("");
        jPanel1.add(ExpBar);
        ExpBar.setBounds(50, 80, 130, 20);

        MPLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        MPLabel.setForeground(new java.awt.Color(255, 255, 255));
        MPLabel.setText("MP:");
        jPanel1.add(MPLabel);
        MPLabel.setBounds(10, 50, 30, 17);

        manaNumber.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        manaNumber.setForeground(new java.awt.Color(255, 255, 255));
        manaNumber.setText("0/0");
        jPanel1.add(manaNumber);
        manaNumber.setBounds(190, 50, 60, 16);

        HPLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        HPLabel.setForeground(new java.awt.Color(255, 255, 255));
        HPLabel.setText("HP:");
        jPanel1.add(HPLabel);
        HPLabel.setBounds(10, 20, 30, 17);

        healthNumber.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        healthNumber.setForeground(new java.awt.Color(255, 255, 255));
        healthNumber.setText("0/0");
        jPanel1.add(healthNumber);
        healthNumber.setBounds(190, 20, 50, 16);

        expLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        expLabel.setForeground(new java.awt.Color(255, 255, 255));
        expLabel.setText("EXP:");
        jPanel1.add(expLabel);
        expLabel.setBounds(10, 80, 40, 17);

        add(jPanel1);
        jPanel1.setBounds(150, 370, 530, 110);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(null);

        HPLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        HPLabel1.setForeground(new java.awt.Color(255, 255, 255));
        HPLabel1.setText("HP:");
        jPanel2.add(HPLabel1);
        HPLabel1.setBounds(10, 10, 30, 17);

        enemyHealthBar.setBackground(new java.awt.Color(0, 0, 0));
        enemyHealthBar.setForeground(new java.awt.Color(51, 255, 51));
        enemyHealthBar.setToolTipText("");
        enemyHealthBar.setValue(90);
        enemyHealthBar.setString("100%");
        jPanel2.add(enemyHealthBar);
        enemyHealthBar.setBounds(40, 10, 140, 20);

        enemyHealthLabel.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        enemyHealthLabel.setForeground(new java.awt.Color(255, 255, 255));
        enemyHealthLabel.setText("0/0");
        jPanel2.add(enemyHealthLabel);
        enemyHealthLabel.setBounds(180, 10, 50, 16);

        add(jPanel2);
        jPanel2.setBounds(470, 10, 230, 40);

        fighterLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/fightIcon.png"))); // NOI18N
        add(fighterLabel);
        fighterLabel.setBounds(-20, 320, 200, 190);

        fightBackGround.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fightBackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/babyKun/icons/treeFight.gif"))); // NOI18N
        add(fightBackGround);
        fightBackGround.setBounds(0, 0, 700, 370);
    }// </editor-fold>//GEN-END:initComponents

    private void AbilityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbilityButtonActionPerformed

        //Add a time between abilityAttack() and attackKun() as should not happen at the same time.
        abilityAttack();
        AbilityButton.setEnabled(false);
        int delay = 1000;
        Timer timer = new Timer(delay, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                attackKun();
                AbilityButton.setEnabled(true);
            }
        });
        timer.setRepeats(false);
        timer.start();
    }//GEN-LAST:event_AbilityButtonActionPerformed

    private void RunButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RunButtonActionPerformed
        //if run, current health should not be max health
        Kun.currentHealth = kunCurrentHealth;
        Kun.currentMana = kunCurrentMana;
        Kun.currentEnemyHealth = enemyCurrentHealth;
        Kun.ifRun = true;
        setMonsterStatus();
        goToMap();
    }//GEN-LAST:event_RunButtonActionPerformed

    private void infoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoButtonActionPerformed
        //check the info for enemy, but current hp should remains.
        Kun.currentHealth = kunCurrentHealth;
        Kun.currentMana = kunCurrentMana;
        Kun.currentEnemyHealth = enemyCurrentHealth;
        Kun.ifReset = true;

        goToInfo();
    }//GEN-LAST:event_infoButtonActionPerformed

    private void BagButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BagButtonActionPerformed
        Kun.currentHealth = kunCurrentHealth;
        Kun.currentMana = kunCurrentMana;
        Kun.currentEnemyHealth = enemyCurrentHealth;
        Kun.ifReset = true;

        goToBag();
    }//GEN-LAST:event_BagButtonActionPerformed

    private void attackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attackButtonActionPerformed
        //Add a time between attack() and attackKun() as should not happen at the same time.
        attack();
        attackButton.setEnabled(false);
        int delay = 1000;
        Timer timer = new Timer(delay, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                attackKun();
                attackButton.setEnabled(true);
            }
        });
        timer.setRepeats(false);
        timer.start();

    }//GEN-LAST:event_attackButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AbilityButton;
    private javax.swing.JButton BagButton;
    private javax.swing.JProgressBar ExpBar;
    private javax.swing.JLabel HPLabel;
    private javax.swing.JLabel HPLabel1;
    private javax.swing.JLabel MPLabel;
    private javax.swing.JButton RunButton;
    private javax.swing.JButton attackButton;
    private javax.swing.JLabel attackEnemyLabel;
    private javax.swing.JLabel attackKunLabel;
    private javax.swing.JLabel boxLabel;
    private javax.swing.JLabel criticalLabel;
    private javax.swing.JLabel criticalLabel1;
    private javax.swing.JLabel criticalPic;
    private javax.swing.JLabel criticalPic1;
    private javax.swing.JPanel criticaltoEnemyPanel;
    private javax.swing.JPanel criticaltoKunPanel;
    private javax.swing.JProgressBar enemyHealthBar;
    private javax.swing.JLabel enemyHealthLabel;
    private javax.swing.JLabel enemyLabel;
    private javax.swing.JLabel expLabel;
    private javax.swing.JLabel fightBackGround;
    private javax.swing.JLabel fighterLabel;
    private javax.swing.JProgressBar healthBar;
    private javax.swing.JLabel healthNumber;
    private javax.swing.JButton infoButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar manaBar;
    private javax.swing.JLabel manaNumber;
    // End of variables declaration//GEN-END:variables
}

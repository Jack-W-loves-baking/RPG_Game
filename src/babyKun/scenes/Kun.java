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
public class Kun {

    /**
     * Define attributes of Kun
     */
    private int health;
    private int mana;
    private int attack;
    private int defence;
    private int luck;
    private int criticalChance;

    /**
     * static attributes passed from fight.
     */
    public static int currentHealth;
    public static int currentMana;
    public static int currentEnemyHealth;

    /**
     * Very important!! Otherwise, everytime Fight class refreshes will
     * initilize current health as the max amount, which will be an error. so it
     * is important to initlize part of it based on the control of triggers.
     */
    public static boolean ifReset = false;
    public static boolean ifRun = false;

    /**
     * Constructor for Kun
     *
     * @param health kun's health
     * @param mana kun mana
     * @param attack kun attack
     * @param defence kun defence
     * @param luck kun luck
     * @param criticalChance kun criticalChance
     */
    public Kun(int health, int mana, int attack, int defence, int luck, int criticalChance) {

        setHealth(health);
        setMana(mana);
        setAttack(attack);
        setDefence(defence);
        setLuck(luck);
        setCriticalChance(criticalChance);

    }

    //Getter and setter for all the attributes.
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public int getCriticalChance() {
        return criticalChance;
    }

    public void setCriticalChance(int criticalChance) {
        this.criticalChance = criticalChance;
    }

}

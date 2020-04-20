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
public class Enemy {

    /**
     * define instances for enemy
     */
    private int health;
    private int mana;
    private int attack;
    private int defence;
    private int luck;
    private int criticalChance;

    /**
     * static instances - triggers for bosses. if boss died then true;
     */
    public static boolean winGorilla = false;
    public static boolean winSnake = false;
    public static boolean winScorpion = false;
    public static boolean winDragon = false;
    public static boolean winBat = false;

    /**
     * Constructor for enemy
     *
     * @param health enemy max health
     * @param mana max mana
     * @param attack attack in database
     * @param defence defence in database
     * @param criticalChance criticalChance% in database
     */
    public Enemy(int health, int mana, int attack, int defence, int criticalChance) {

        setHealth(health);
        setMana(mana);
        setAttack(attack);
        setDefence(defence);
        setCriticalChance(criticalChance);

    }

    /**
     * getter for health
     *
     * @return latest health
     */
    public int getHealth() {
        return health;
    }

    /**
     * setter for health
     *
     * @param health current health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * getter for mana
     *
     * @return latest mana
     */
    public int getMana() {
        return mana;
    }

    /**
     * setter for mana
     *
     * @param mana current mana
     */
    public void setMana(int mana) {
        this.mana = mana;
    }

    /**
     * getter for attack
     *
     * @return attack
     */
    public int getAttack() {
        return attack;
    }

    /**
     * setter for attack
     *
     * @param attack
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * getter for defence
     *
     * @return latest defence
     */
    public int getDefence() {
        return defence;
    }

    /**
     * setter for defence
     *
     * @param defence
     */
    public void setDefence(int defence) {
        this.defence = defence;
    }

    /**
     * getter for luck
     *
     * @return latest luck
     */
    public int getLuck() {
        return luck;
    }

    /**
     * setter for luck
     *
     * @param luck
     */
    public void setLuck(int luck) {
        this.luck = luck;
    }

    /**
     * getter for CriticalChance
     *
     * @return latest CriticalChance
     */
    public int getCriticalChance() {
        return criticalChance;
    }

    /**
     * setter for criticalChance
     *
     * @param criticalChance
     */
    public void setCriticalChance(int criticalChance) {
        this.criticalChance = criticalChance;
    }

}

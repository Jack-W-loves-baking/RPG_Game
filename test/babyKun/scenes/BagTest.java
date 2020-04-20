/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package babyKun.scenes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jack
 */
public class BagTest {

    mainJFrame mj = new mainJFrame();
    Bag b = new Bag(mj);

    public BagTest() {
    }

    /**
     * Test of itemAdded method, of class Bag.
     */
    @Test
    public void testRemainedHealth() {
        System.out.println("remainedHealth");

        int total = 0;
        int defence = 100;
        int attack = 0;
        int expResult = 0;
        int result = b.remainedHealth(total, defence, attack);
        assertEquals(expResult, result);

        int total2 = 1;
        int defence2 = 100;
        int attack2 = 0;
        int expResult2 = 1;
        int result2 = b.remainedHealth(total2, defence2, attack2);
        assertEquals(expResult2, result2);

    }

    /**
     * Test of ifDrinkHealthPotion method, of class Fight.
     */
    @Test
    public void testIfDrinkHealthPotion() {
        System.out.println("ifDrinkHealthPotion");

        int total = 0;
        int remained = 0;
        int healthAmount = 100;
        boolean expResult = false;
        boolean result = b.ifDrinkHealthPotion(total, remained, healthAmount);
        assertEquals(expResult, result);

    }

}

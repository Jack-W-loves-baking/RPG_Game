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
public class ShopTest {

    public ShopTest() {
    }

    /**
     * Test of afterDiscount method, of class Shop.
     */
    @Test
    public void testAfterDiscount() {
        System.out.println("afterDiscount");
        mainJFrame mj = new mainJFrame();
        Shop s = new Shop(mj);
        double price = 300;
        double discount = 0.2;
        double expect = 240;
        assertEquals(expect, s.afterDiscount(price, discount), 0.0);
    }

}

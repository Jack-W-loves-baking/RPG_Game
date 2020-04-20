/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package babyKun.scenes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
public class BasketTest {

    mainJFrame mj = new mainJFrame();
    Basket b = new Basket(mj);

    public BasketTest() {
    }

    /**
     * Test of totalAmount method, of class Basket.
     */
    @Test
    public void testTotalAmount_ArrayList() {

        System.out.println("totalAmount");
        ArrayList<Integer> arr = null;
        int expResult = 0;
        int result = b.totalAmount(arr);
        assertEquals(expResult, result);

        System.out.println("totalAmount");
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        arr1.add(1);
        arr1.add(2);
        arr1.add(100);
        arr1.add(6);
        int expResult1 = 109;
        int result1 = b.totalAmount(arr1);
        assertEquals(expResult1, result1);

    }

    /**
     * Test of clearDuplicate method, of class Basket.
     */
    @Test
    public void testClearDuplicate() {
        System.out.println("clearDuplicate");
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(1);
        arr.add(2);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        ArrayList<Integer> expResult = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> result = b.clearDuplicate(arr);
        assertEquals(expResult, result);

    }

}

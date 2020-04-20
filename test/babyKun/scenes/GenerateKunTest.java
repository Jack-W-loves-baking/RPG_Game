/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package babyKun.scenes;

import javax.swing.JFrame;
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
public class GenerateKunTest {

    public GenerateKunTest() {
    }

    /**
     * Test of calculateC method, of class GenerateKun.
     */
    @Test
    public void testCalculateC() {
        mainJFrame mj = new mainJFrame();
        GenerateKun g = new GenerateKun(mj);
        System.out.println("calculateC");
        int number = 0;
        String result = g.calculateC(number);
        String expResult = "Strong";
        assertEquals(expResult, result);

        int number2 = 3;
        String result2 = g.calculateC(number2);
        String expResult2 = "Quiet";
        assertEquals(expResult2, result2);

    }

}

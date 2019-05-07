/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino_project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Apostolos
 */
public class HumanTest {
    
    public HumanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of fillhand method, of class Human.
     */
    @Test
    public void testFillhand() {
        System.out.println("fillhand");
        SetOfTiles set = null;
        Human instance = null;
        instance.fillhand(set);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Human.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Human instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ClearHand method, of class Human.
     */
    @Test
    public void testClearHand() {
        System.out.println("ClearHand");
        Human instance = null;
        instance.ClearHand();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHandpoints method, of class Human.
     */
    @Test
    public void testGetHandpoints() {
        System.out.println("getHandpoints");
        Human instance = null;
        int expResult = 0;
        int result = instance.getHandpoints();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHighiestDoubleTile method, of class Human.
     */
    @Test
    public void testGetHighiestDoubleTile() {
        System.out.println("getHighiestDoubleTile");
        Human instance = null;
        int expResult = 0;
        int result = instance.getHighiestDoubleTile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPoints method, of class Human.
     */
    @Test
    public void testAddPoints() {
        System.out.println("addPoints");
        int x = 0;
        Human instance = null;
        instance.addPoints(x);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetPoints method, of class Human.
     */
    @Test
    public void testGetPoints() {
        System.out.println("GetPoints");
        Human instance = null;
        int expResult = 0;
        int result = instance.GetPoints();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeTileByIndex method, of class Human.
     */
    @Test
    public void testRemoveTileByIndex() {
        System.out.println("removeTileByIndex");
        int x = 0;
        Human instance = null;
        boolean expResult = false;
        boolean result = instance.removeTileByIndex(x);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTileByIndex method, of class Human.
     */
    @Test
    public void testGetTileByIndex() {
        System.out.println("getTileByIndex");
        int x = 0;
        Human instance = null;
        Tile expResult = null;
        Tile result = instance.getTileByIndex(x);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handIsEmpty method, of class Human.
     */
    @Test
    public void testHandIsEmpty() {
        System.out.println("handIsEmpty");
        Human instance = null;
        boolean expResult = false;
        boolean result = instance.handIsEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHand method, of class Human.
     */
    @Test
    public void testGetHand() {
        System.out.println("getHand");
        Human instance = null;
        SetOfTiles expResult = null;
        SetOfTiles result = instance.getHand();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

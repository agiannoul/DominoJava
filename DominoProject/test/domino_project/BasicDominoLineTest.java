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
public class BasicDominoLineTest {
    
    public BasicDominoLineTest() {
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
     * Test of addTileOnBeginning method, of class BasicDominoLine.
     */
    @Test
    public void testAddTileOnBeginning() {
        System.out.println("addTileOnBeginning");
        Tile tile = new Tile(11,11);
        BasicDominoLine instance = new BasicDominoLine();
        instance.addTileOnBeginning(tile);
        assertEquals(instance.getSetOfTiles().getFirstTile(), tile);
        
    }

    /**
     * Test of addTileAtTheEnd method, of class BasicDominoLine.
     */
    @Test
    public void testAddTileAtTheEnd() {
        System.out.println("addTileAtTheEnd");
        Tile tile = new Tile(11,11);;
        BasicDominoLine instance = new BasicDominoLine();
        instance.addTileAtTheEnd(tile);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getSetOfTiles().getFirstTile(), tile);
    }

    /**
     * Test of fitsOnBeginning method, of class BasicDominoLine.
     */
    @Test
    public void testFitsOnBeginning() {
        System.out.println("fitsOnBeginning");
        Tile tile = new Tile(11,11);;
        BasicDominoLine instance = new BasicDominoLine();
        instance.addTileAtTheEnd(tile);
        short expResult = 0;
        short result = instance.fitsOnBeginning(new Tile(11,0));
        assertEquals(1, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of fitsAtTheEnd method, of class BasicDominoLine.
     */
    @Test
    public void testFitsAtTheEnd() {
        System.out.println("fitsAtTheEnd");
         Tile tile = new Tile(11,11);;
        BasicDominoLine instance = new BasicDominoLine();
        instance.addTileAtTheEnd(tile);
        short expResult = 0;
        short result = instance.fitsAtTheEnd(new Tile(11,0));
        assertEquals(1, result);
    }

    /**
     * Test of getSetOfTiles method, of class BasicDominoLine.
     */
    @Test
    public void testGetSetOfTiles() {
        System.out.println("getSetOfTiles");
         Tile tile = new Tile(11,11);
        BasicDominoLine instance = new BasicDominoLine();
        instance.addTileAtTheEnd(tile);
        instance.addTileAtTheEnd(tile);
        instance.addTileAtTheEnd(tile);
        int expResult = 3;
        SetOfTiles result = instance.getSetOfTiles();
        assertEquals(expResult, result.getSize());
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of isEmpty method, of class BasicDominoLine.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        BasicDominoLine instance = new BasicDominoLine();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of Clear method, of class BasicDominoLine.
     */
    @Test
    public void testClear() {
        System.out.println("Clear");
       BasicDominoLine instance = new BasicDominoLine();
       Tile tile = new Tile(11,11);
        instance.addTileAtTheEnd(tile);
        instance.addTileAtTheEnd(tile);
        instance.addTileAtTheEnd(tile);
        instance.Clear();
        assertEquals(instance.isEmpty(), true);   
    }
    
}

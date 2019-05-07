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
public class TileTest {
    
    public TileTest() {
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
     * Test of getT1 method, of class Tile.
     */
    @Test
    public void testGetT1() {
        System.out.println("getT1");
        Tile instance = new Tile(5,3);
        int expResult = 5;
        int result = instance.getT1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getT2 method, of class Tile.
     */
    @Test
    public void testGetT2() {
        System.out.println("getT2");
        Tile instance =  new Tile(5,3);
        int expResult = 3;
        int result = instance.getT2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of reverseTile method, of class Tile.
     */
    @Test
    public void testReverseTile() {
        System.out.println("reverseTile");
        Tile instance = new Tile(5,3);
        instance.reverseTile();
        Tile tile = new Tile(3,5);
        assertEquals(true, tile.equalTile(instance));
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of matchSideOfTile method, of class Tile.
     */
    @Test
    public void testMatchSideOfTile() {
        System.out.println("matchSideOfTile");
        int tile_num = 0;
        Tile instance = new Tile(5,3);
        short expResult = 2;
        short result = instance.matchSideOfTile(3);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
     public void testMatchSideOfTile1() {
        System.out.println("matchSideOfTile");
        int tile_num = 0;
        Tile instance = new Tile(5,3);
        short expResult = 1;
        short result = instance.matchSideOfTile(5);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
     
      public void testMatchSideOfTile2() {
        System.out.println("matchSideOfTile");
        int tile_num = 0;
        Tile instance = new Tile(5,3);
        short expResult = -1;
        short result = instance.matchSideOfTile(1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    /**
     * Test of equalTile method, of class Tile.
     */
    @Test
    public void testEqualTile() {
        System.out.println("equalTile");
        Tile tile = new Tile(1,2);
        Tile instance = new Tile(2,1);
        boolean expResult = true;
        boolean result = instance.equalTile(tile);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isDouble method, of class Tile.
     */
    @Test
    public void testIsDouble() {
        System.out.println("isDouble");
        Tile instance = new Tile(2,2);
        boolean expResult = true;
        boolean result = instance.isDouble();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getDouble method, of class Tile.
     */
    @Test
    public void testGetDouble() {
        System.out.println("getDouble");
        Tile instance = new Tile(1,2);
        int expResult = -1;
        int result = instance.getDouble();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getSum method, of class Tile.
     */
    @Test
    public void testGetSum() {
        System.out.println("getSum");
        Tile instance = new Tile(5,6);
        int expResult = 11;
        int result = instance.getSum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

   
    
}

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
public class DominoLineTest {
    
    public DominoLineTest() {
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
     * Test of addTileOnBeginning method, of class BasicDominoLine.
     */
    @Test
    public void testAddTileOnBeginning() {
        System.out.println("addTileOnBeginning");
        Tile tile = new Tile(1,2);
        BasicDominoLine instance = new BasicDominoLine();
        instance.addTileOnBeginning(tile);
        assertEquals( true,tile.equalTile(instance.getFirstTile()));

        
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of addTileAtTheEnd method, of class BasicDominoLine.
     */
    @Test
    public void testAddTileAtTheEnd() {
        System.out.println("addTileAtTheEnd");
        Tile tile =new Tile(1,2);
        BasicDominoLine instance = new BasicDominoLine();
        instance.addTileAtTheEnd(tile);
        assertEquals( true,tile.equalTile(instance.getLastTile()));
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getLastTile method, of class BasicDominoLine.
     */
    @Test
    public void testGetLastTile() {
        System.out.println("getLastTile");
        BasicDominoLine instance = new BasicDominoLine();
        Tile tile = new Tile(1,2);
        instance.addTileAtTheEnd(tile);
        Tile tile2 = new Tile(1,2);
        instance.addTileAtTheEnd(tile);
        
        Tile result = instance.getLastTile();
        assertEquals(true, result.equalTile(tile2));
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getFirstTile method, of class BasicDominoLine.
     */
    @Test
    public void testGetFirstTile() {
        System.out.println("getFirstTile");
        BasicDominoLine instance = new BasicDominoLine();
        Tile tile = new Tile(1,1);
        instance.addTileOnBeginning(tile);
        Tile tile2 = new Tile(1,2);
        instance.addTileOnBeginning(tile2);
        Tile result = instance.getFirstTile();
        assertEquals(true, result.equalTile(tile2));
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of fitsOnBeginning method, of class BasicDominoLine.
     */
    @Test
    public void testFitsOnBeginning() {
        System.out.println("fitsOnBeginning");
        BasicDominoLine instance = new BasicDominoLine();
        Tile tile = new Tile(1,1);
        instance.addTileOnBeginning(tile);
        Tile tile2 = new Tile(1,2);
        instance.addTileOnBeginning(tile2);
        short expResult = 1;
        short result = instance.fitsOnBeginning(new Tile(1,0));
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of fitsAtTheEnd method, of class BasicDominoLine.
     */
    @Test
    public void testFitsAtTheEnd() {
        System.out.println("fitsAtTheEnd");
                BasicDominoLine instance = new BasicDominoLine();

        Tile tile = new Tile(1,2);
        instance.addTileOnBeginning(tile);
        Tile tile2 = new Tile(1,1);
        instance.addTileOnBeginning(tile2);
        short expResult = 1;
        short result = instance.fitsAtTheEnd(new Tile(2,0));
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getSetOfTiles method, of class BasicDominoLine.
     */
    @Test
    public void testGetSetOfTiles() {
        System.out.println("getSetOfTiles");
        BasicDominoLine instance = new BasicDominoLine();
        
        SetOfTiles result = instance.getSetOfTiles();
        assertEquals(true, result.isEmpty());
        // TODO review the generated test code and remove the default call to fail.
    }
    
}

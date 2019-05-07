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
public class SetOfTilesTest {
    
    public SetOfTilesTest() {
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
     * Test of addTile method, of class SetOfTiles.
     */
    @Test
    public void testAddTile() {
        System.out.println("addTile");
        Tile tile = new Tile(5,3);
        SetOfTiles instance = new SetOfTiles();
        boolean expResult = true;
        boolean result = instance.addTile(tile);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of addTileByIndex method, of class SetOfTiles.
     */
    @Test
    public void testAddTileByIndex() {
        System.out.println("addTileByIndex");
        
        
         SetOfTiles instance = new SetOfTiles();
        for(int j=0;j<5;j++){
            Tile tile = new Tile(5,j);
            instance.addTileByIndex(tile, j);
        }
        for(int j=0;j<5;j++){
            Tile tile = new Tile(j,3);
            instance.addTileByIndex(tile, j);
        }
        
        assertEquals(instance.getLastTile().equalTile(new Tile(5,4)), true );
        
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of isEmpty method, of class SetOfTiles.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        SetOfTiles instance = new SetOfTiles();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of removeLastTile method, of class SetOfTiles.
     */
    @Test
    public void testRemoveLastTile() {
        System.out.println("removeLastTile");
        SetOfTiles instance = new SetOfTiles();
        for(int j=0;j<5;j++){
            Tile tile = new Tile(5,j);
            instance.addTileByIndex(tile, j);
        }
        for(int j=0;j<5;j++){
            Tile tile = new Tile(j,6);
            instance.addTileByIndex(tile, j);
        }
        boolean expResult = true;
        boolean result = instance.removeLastTile();
        assertEquals(expResult && instance.getLastTile().equalTile(new Tile(5,3)), result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of removeByIndex method, of class SetOfTiles.
     */
    @Test
    public void testRemoveByIndex() {
        System.out.println("removeByIndex");
        int i = 6;
        SetOfTiles instance = new SetOfTiles();
        for(int j=0;j<5;j++){
            Tile tile = new Tile(5,j);
            instance.addTileByIndex(tile, j);
        }
        for(int j=0;j<5;j++){
            Tile tile = new Tile(j,6);
            instance.addTileByIndex(tile, j);
        }
        boolean expResult = true;
        boolean result = instance.removeByIndex(i);
        assertEquals(expResult && instance.getTileByIndex(i).equalTile(new Tile(5,2)), result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getLastTile method, of class SetOfTiles.
     */
    @Test
    public void testGetLastTile() {
        System.out.println("getLastTile");
        SetOfTiles instance = new SetOfTiles();
        Tile tile = new Tile(1,1);
        instance.addTile(tile);
        Tile tile2= new Tile(1,2);
        instance.addTile(tile2);
        
        assertEquals(true, instance.getLastTile().equalTile(tile2));
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getFirstTile method, of class SetOfTiles.
     */
    @Test
    public void testGetFirstTile() {
        System.out.println("getFirstTile");
        SetOfTiles instance = new SetOfTiles();
        Tile tile = new Tile(0,0);
         instance.addTile(tile);
        assertEquals(true, instance.getFirstTile().equalTile(tile));
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTileByIndex method, of class SetOfTiles.
     */
    @Test
    public void testGetTileByIndex() {
        System.out.println("getTileByIndex");
        int i = 0;
        SetOfTiles instance = new SetOfTiles();
        Tile tile = new Tile(0,0);
         instance.addTileByIndex(tile, i);
        assertEquals(true, instance.getTileByIndex(i).equalTile(tile));
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of fillSet28 method, of class SetOfTiles.
     */
    @Test
    public void testFillSet28() {
        System.out.println("fillSet28");
        SetOfTiles instance = new SetOfTiles();
        instance.fillSet28();
         assertEquals(28, instance.getSize());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getSize method, of class SetOfTiles.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        SetOfTiles instance = new SetOfTiles();
        for(int j=0;j<5;j++){
            Tile tile = new Tile(5,j);
            instance.addTileByIndex(tile, j);
        }
        for(int j=0;j<5;j++){
            Tile tile = new Tile(j,6);
            instance.addTileByIndex(tile, j);
        }
        int expResult = 10;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}

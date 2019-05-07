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
public class BotTest {
    
    public BotTest() {
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
     * Test of fillhand method, of class Bot.
     */
    @Test
    public void testFillhand() {
        System.out.println("fillhand");
        SetOfTiles set = new SetOfTiles();
        set.fillSet28();
        Bot instance = new Bot("ABot");
        instance.fillhand(set);
        assertEquals( 28 ,instance.getHand().getSize() );
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of ClearHand method, of class Bot.
     */
    @Test
    public void testClearHand() {
        System.out.println("ClearHand");
        Bot instance = new Bot("ABOT");
        SetOfTiles set = new SetOfTiles();
        set.fillSet28();
        instance.fillhand(set);
        instance.ClearHand();
        assertEquals(true,instance.handIsEmpty());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getHandpoints method, of class Bot.
     */
    @Test
    public void testGetHandpoints() {
        System.out.println("getHandpoints");
        Bot instance = new Bot("ABOT");
        int expResult = 0;
        int result = instance.getHandpoints();
        assertEquals(0, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getHighiestDoubleTile method, of class Bot.
     */
    @Test
    public void testGetHighiestDoubleTile() {
        System.out.println("getHighiestDoubleTile");
        Bot instance = new Bot("ABOT");
        SetOfTiles set = new SetOfTiles();
        set.fillSet28();
        instance.fillhand(set);
        int result = instance.getHighiestDoubleTile();
        assertEquals(6, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of GetPoints method, of class Bot.
     */
    @Test
    public void testGetPoints() {
        System.out.println("GetPoints");
        Bot instance = new Bot("ABOT");
        int expResult = 0;
        int result = instance.GetPoints();
        assertEquals(0, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of removeTileByIndex method, of class Bot.
     */
    @Test
    public void testRemoveTileByIndex() {
        System.out.println("removeTileByIndex");
        int x = 0;
        Bot instance = new Bot("ABOT");
        SetOfTiles set = new SetOfTiles();
        set.fillSet28();
        instance.fillhand(set);
        instance.removeTileByIndex(0);
        instance.removeTileByIndex(26);
        assertEquals( 26,instance.getHand().getSize());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTileByIndex method, of class Bot.
     */
    @Test
    public void testGetTileByIndex() {
        System.out.println("getTileByIndex");
        Bot instance = new Bot("ABOT");
        SetOfTiles set = new SetOfTiles();
        set.addTile(new Tile(1,1));
        instance.fillhand(set);
        Tile tile=instance.getTileByIndex(0);
        assertEquals(true, tile.equalTile(new Tile(1,1)));
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isAbleToPlay method, of class Bot.
     */
 

    /**
     * Test of handIsEmpty method, of class Bot.
     */
    @Test
    public void testHandIsEmpty() {
        System.out.println("handIsEmpty");
        Bot instance = new Bot("ABOT");
        boolean result = instance.handIsEmpty();
        assertEquals(true, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of pickTileToPlay method, of class Bot.
     */
    @Test
    public void testPickTileToPlay() {
        System.out.println("pickTileToPlay");
        Bot instance = new Bot("ABOT");
        SetOfTiles set = new SetOfTiles();
        set.addTile(new Tile(1,1));
        instance.fillhand(set);
        int expResult = 0;
        int result = instance.pickTileToPlay(1, 2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of addPoints method, of class Bot.
     */
    @Test
    public void testAddPoints() {
        System.out.println("addPoints");
        int x = 5;
        Bot instance = new Bot("ABOT");
        instance.addPoints(x);
        assertEquals(5, instance.GetPoints());
        // TODO review the generated test code and remove the default call to fail.
    }

    
}

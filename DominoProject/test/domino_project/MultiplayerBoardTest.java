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
public class MultiplayerBoardTest {
    
    public MultiplayerBoardTest() {
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
     * Test of fillBoard method, of class MultiplayerBoard.
     */
    @Test
    public void testFillBoard() {
        System.out.println("fillBoard");
         MultiplayerBoard instance = new BoardHungarian();
        instance.fillBoard();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(28,instance.set.getSize());
    }

    /**
     * Test of clearBoard method, of class MultiplayerBoard.
     */
    @Test
    public void testClearBoard() {
        System.out.println("clearBoard");
         MultiplayerBoard instance = new BoardHungarian();
        ((BoardHungarian)(instance)).clearBoard();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(0,instance.set.getSize());
    }

    /**
     * Test of giveLastTiles method, of class MultiplayerBoard.
     */
    @Test
    public void testGiveLastTiles() {
        System.out.println("giveLastTiles");
        int x = 10;
        MultiplayerBoard instance = new BoardHungarian();
        SetOfTiles expResult = null;
        instance.fillBoard();
        SetOfTiles result = instance.giveLastTiles(x);
        assertEquals(10, result.getSize());
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of addTileOnBeggining method, of class MultiplayerBoard.
     */
    @Test
    public void testAddTileOnBeggining() {
        System.out.println("addTileOnBeggining");
        Tile tile1 = new Tile(11,11);
        MultiplayerBoard instance = new BoardHungarian();
        instance.addTileOnBeggining(tile1);
        // TODO review the generated test code and remove the default call to fail.
       assertEquals(tile1, instance.getLine().getSetOfTiles().getFirstTile());
    }

    /**
     * Test of addTileAtTheEnd method, of class MultiplayerBoard.
     */
    @Test
    public void testAddTileAtTheEnd() {
        System.out.println("addTileAtTheEnd");
        Tile tile1 = new Tile(11,11);
        MultiplayerBoard instance = new BoardHungarian();
        instance.addTileAtTheEnd(tile1);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(tile1, instance.getLine().getSetOfTiles().getLastTile());
    }
    
}

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
public class BoardHungarianTest {
    
    public BoardHungarianTest() {
    }
    
    
    

    /**
     * Test of fillBoard method, of class BoardHungarian.
     */
    @Test
    public void testFillBoard() {
        System.out.println("fillBoard");
        BoardHungarian instance = new BoardHungarian();
        instance.fillBoard();
        SetOfTiles SET = instance.giveLastTiles(28);
        assertEquals(28, SET.getSize());

        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of clearBoard method, of class BoardHungarian.
     */
    @Test
    public void testClearBoardHungarian() {
        System.out.println("clearBoardHungarian");
        BoardHungarian instance = new BoardHungarian();
        instance.clearBoard();
        SetOfTiles SET = instance.giveLastTiles(4);
        assertEquals(0, SET.getSize());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of addTileOnBeggining method, of class BoardHungarian.
     */
    @Test
    public void testAddTileOnBeggining() {
        System.out.println("addTileOnBeggining");
        Tile tile1 = new Tile(1,1);
        BoardHungarian instance = new BoardHungarian();
        instance.addTileOnBeggining(tile1);
        assertEquals(true, instance.getLine().getSetOfTiles().getFirstTile().equalTile(tile1));
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of addTileAtTheEnd method, of class BoardHungarian.
     */
    @Test
    public void testAddTileAtTheEnd() {
        System.out.println("addTileAtTheEnd");
        Tile tile1 = new Tile(1,2);
        BoardHungarian instance = new BoardHungarian();
        instance.addTileAtTheEnd(tile1);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(true, instance.getLine().getSetOfTiles().getLastTile().equalTile(tile1));
    }


    /**
     * Test of placeTileToLine method, of class BoardHungarian.
     */
    @Test
    public void testPlaceTileToLine() {
        System.out.println("PlaceTileToLine");
        Tile tile = new Tile(1,2);
        Tile tile1 = new Tile (1,1);
        int choice = 0;
        BoardHungarian instance = new BoardHungarian();
        instance.addTileOnBeggining(tile1);
        instance.placeTileToLine(tile, choice);
        assertEquals(true, instance.getLine().getSetOfTiles().getFirstTile().equalTile(tile1));
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of checkIfFits method, of class BoardHungarian.
     */
    @Test
    public void testCheckIfFits() {
        System.out.println("checkIfFits");
        Tile tile = new Tile(1,2);
        BoardHungarian instance = new BoardHungarian();
        Tile tile1 = new Tile (1,1);
        int choice = 0;
        instance.addTileOnBeggining(tile1);
        boolean expResult = true;
        boolean result = instance.checkIfFits(tile1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of giveLastTiles method, of class BoardHungarian.
     */
    @Test
    public void testGiveLastTiles() {
        System.out.println("giveLastTiles");
        int x = 3;
        BoardHungarian instance = new BoardHungarian();
        instance.fillBoard();
        SetOfTiles result = instance.giveLastTiles(x);
        assertEquals(3, result.getSize());
        // TODO review the generated test code and remove the default call to fail.
    }
    
}

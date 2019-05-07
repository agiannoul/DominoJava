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
public class BoardSolo1Test {

    public BoardSolo1Test() {
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
     * Test of putFromPanelToEndOFLine method, of class BoardSolo1.
     */
    @Test
    public void testPutFromPanelToEndOFLine() {
        System.out.println("putFromPanelToEndOFLine");
        int x = 0;
        boolean reverse = false;
        BoardSolo1 instance = new BoardSolo1();
        instance.putFromPanelToEndOFLine(x, reverse);
        assertEquals(1, instance.getLine().getSetOfTiles().getSize());

        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of putFromPanelToStartOFLine method, of class BoardSolo1.
     */
    @Test
    public void testPutFromPanelToStartOFLine() {
        System.out.println("putFromPanelToStartOFLine");
        int x = 0;
        boolean reverse = false;
        BoardSolo1 instance = new BoardSolo1();
        instance.putFromPanelToEndOFLine(x, reverse);
        Tile tile = new Tile(instance.getPanel().getLastOfRow(x).getT1(), instance.getPanel().getLastOfRow(x).getT2());
        instance.putFromPanelToStartOFLine(x, reverse);
        assertEquals(true, instance.getLine().getSetOfTiles().getFirstTile().equalTile(tile));
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of placeTileToLine method, of class BoardSolo1.
     */
    @Test
    public void testPlaceTileToLine() {
        System.out.println("PlaceTileToLine");
        Tile tile = new Tile(1,1);
        int choice = 0;
        BoardSolo1 instance = new BoardSolo1();
        instance.placeTileToLine(tile, 1);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of checkIfFits method, of class BoardSolo1.
     */
    @Test
    public void testCheckIfFits() {
        System.out.println("checkIfFits");
        BoardSolo1 instance = new BoardSolo1();
        instance.getLine().addTileAtTheEnd(new Tile(1, 1));
        boolean expResult = true;
        boolean result = instance.checkIfFits(new Tile(1, 2));
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of continuePlaying method, of class BoardSolo1.
     */
    @Test
    public void testContinuePlaying() {
        System.out.println("continuePlaying");
        BoardSolo1 instance = new BoardSolo1();
        for (int j = 0; j < 4; j++) {

            for (int i = 0; i < 7; i++) {
                instance.getPanel().removeLastOfRow(j);
            }
        }

        boolean expResult = false;
        boolean result = instance.continuePlaying();
        assertEquals(expResult, result);

        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of checkVictory method, of class BoardSolo1.
     */
    @Test
    public void testCheckVictory() {
        System.out.println("checkVictory");
        BoardSolo1 instance = new BoardSolo1();
        boolean expResult = false;
        boolean result = instance.checkVictory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

   
}

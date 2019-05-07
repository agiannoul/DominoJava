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
public class CardinalDominoLineTest {
    
    public CardinalDominoLineTest() {
    }
    
   
    @Test
    public void testFitsOnBeginning() {
        System.out.println("fitsOnBeginning");
        Tile tile = new Tile(4,5);
        Tile tile1 = new Tile(3,2);
        CardinalDominoLine instance = new CardinalDominoLine();
        short expResult = 1;
        instance.addTileAtTheEnd(tile);
        short result = instance.fitsOnBeginning(tile1);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of fitsAtTheEnd method, of class CardinalDominoLine.
     */
    @Test
    public void testFitsAtTheEnd() {
        System.out.println("fitsOnBeginning");
        Tile tile = new Tile(4,5);
        Tile tile1 = new Tile(3,2);
        CardinalDominoLine instance = new CardinalDominoLine();
        short expResult = 2;
        instance.addTileAtTheEnd(tile);
        short result = instance.fitsAtTheEnd(tile1);
        assertEquals(expResult, result);
        
    }

    
}

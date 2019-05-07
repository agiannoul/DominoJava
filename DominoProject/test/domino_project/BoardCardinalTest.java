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
public class BoardCardinalTest {
    
   

    /**
     * Test of checkIfFits method, of class BoardCardinal.
     */
    @Test
    public void testCheckIfFits() {
        System.out.println("checkIfFits");
        Tile tile = new Tile(3,3);
        BoardCardinal instance = new BoardCardinal();
        instance.addTileOnBeggining(new Tile(1,1));
        boolean expResult = false;
        boolean result = instance.checkIfFits(tile);
        assertEquals(expResult, result);
        
    }
    /**
     * Test of checkIfFits method, of class BoardCardinal.
     */
    @Test
    public void testCheckIfFits2() {
        System.out.println("checkIfFits");
        Tile tile = new Tile(4,1);
        BoardCardinal instance = new BoardCardinal();
        instance.addTileOnBeggining(new Tile(1,3));
        boolean expResult = true;
        boolean result = instance.checkIfFits(tile);
        assertEquals(expResult, result);
        
    }
    
}

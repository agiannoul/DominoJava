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
public class PanelOfTilesTest {
    
    public PanelOfTilesTest() {
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
     * Test of getNumberOfRows method, of class PanelOfTiles.
     */
    @Test
    public void testGetNumberOfRows() {
        System.out.println("getNumberOfRows");
        PanelOfTiles instance = new PanelOfTiles();
        int expResult = 4;
        int result = instance.getNumberOfRows();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getLastOfRow method, of class PanelOfTiles.
     */
    @Test
    public void testGetLastOfRow() {
        System.out.println("getLastOfRow");
        int row = 0;
        PanelOfTiles instance = new PanelOfTiles();
        Tile result = instance.getLastOfRow(row);
        assertEquals(true, result.equalTile(instance.getSetOfRow(0).getLastTile()));
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isRowEmpty method, of class PanelOfTiles.
     */
    @Test
    public void testIsRowEmpty() {
        System.out.println("isRowEmpty");
        int row = 0;
        PanelOfTiles instance = new PanelOfTiles();
        instance.removeLastOfRow(row);
        instance.removeLastOfRow(row);
        instance.removeLastOfRow(row);
        instance.removeLastOfRow(row);
        instance.removeLastOfRow(row);
        instance.removeLastOfRow(row);
        instance.removeLastOfRow(row);
        
        boolean expResult = true;
        boolean result = instance.isRowEmpty(row);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of removeLastOfRow method, of class PanelOfTiles.
     */
    @Test
    public void testRemoveLastOfRow() {
        System.out.println("removeLastOfRow");
        int row = 0;
        PanelOfTiles instance = new PanelOfTiles();
        instance.removeLastOfRow(row);
        assertEquals(6, instance.getSetOfRow(row).getSize());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getSetOfRow method, of class PanelOfTiles.
     */
    @Test
    public void testGetSetOfRow() {
        System.out.println("getSetOfRow");
        int row = 0;
        PanelOfTiles instance = new PanelOfTiles();
        SetOfTiles result = instance.getSetOfRow(row);
        instance.removeLastOfRow(row);
        
        assertEquals(true, result.getTileByIndex(5).equalTile(instance.getLastOfRow(row)));
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of panelIsEmpty method, of class PanelOfTiles.
     */
    @Test
    public void testPanelIsEmpty() {
        System.out.println("panelIsEmpty");
        PanelOfTiles instance = new PanelOfTiles();
        boolean expResult = instance.isRowEmpty(0) && instance.isRowEmpty(1) && instance.isRowEmpty(2) && instance.isRowEmpty(3);
        boolean result = instance.panelIsEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}

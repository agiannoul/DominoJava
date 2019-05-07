package domino_project;
import Gui.Solo1Gui;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * This class represents the logic of a Solo1 type of Domino Game. A player
 * plays alone and picks Tiles from a Panel Of Tiles(last of a row) and puts
 * them in the line so that they match a side.This keeps going till he can't put
 * any on the Line(lose) or the Panel is Empty(win). It consists of a BoardSolo1,
 * a boolean to decide if victory or defeata
 * and a Solo1Gui variable for Graphical User Interface.Solo1Game
 * implements Runnable.
 *
 * @author Apatsidis Ioannis
 * @author Giannoulidis Apostolos
 */
public class Solo1Game implements Runnable{

    private BoardSolo1 board;
    private Solo1Gui gui;
    private boolean victory=false;
    /**
     * Class Constructor.
     * Creates a BoardSolo1 and a Solo1Gui.
     * @param gui Solo1Gui given to this gui variable
     */
    public Solo1Game(Solo1Gui gui) {
        
        this.gui = gui;
        gui.setDefaultCloseOperation(gui.DISPOSE_ON_CLOSE);
        
        
        board = new BoardSolo1();
    }
 /**
     * Returns the row,in this board's PanelOfTiles, that the tile read from
     * user belongs to. Shows invalid input if tile doesn't fit on this board's
     * DominoLine and keeps on asking till valid input.
     *
     * @return row that the tile read from user belongs to
     */
    private int readTile() {
        int row;
        gui.setFalseButtonPressed();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Solo1Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        row = gui.readTileFromPanel();
        
        
         
        
        Tile tile= new Tile(11,11);
        boolean done;
        if (row!=-1 && board.getPanel().getLastOfRow(row) != null) {
            tile = board.getPanel().getLastOfRow(row);
            done = true;
        } else {
            done = false;
        }

        while (!done||  !board.checkIfFits(tile) ) {
            //cui.createWhiteSpaces(1); OXI GIA GUI
            
            if(row!=-1){
                gui.showInvalidInput();
            }
            
            
           
            gui.setFalseButtonPressed();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Solo1Game.class.getName()).log(Level.SEVERE, null, ex);
            }
            row = gui.readTileFromPanel();
            
            
            if (row!=-1 && board.getPanel().getLastOfRow(row) != null) {
                tile = board.getPanel().getLastOfRow(row);
                done = true;
            } else {
                done = false;
            }

        }
        
        return row;
    }
/**
     * This method removes the tile to be put in, from this board's PanelOfTiles
     * and determines where the tile should be put in, if it fits on both sides.
     *
     * @param tile tile to be put on this board's DominoLine
     * @param row the row at this board's PanelOfTiles that the tile belongs to
     */
    private void PlaceTile(Tile tile, int row) {
        int fits = board.getLine().fitsOnBeginning(tile);
        int fits2 = board.getLine().fitsAtTheEnd(tile);
        int choice = 1;
        if (fits > 0 && fits2 > 0) {
            // 8a ginei h 1 h 2
            choice = gui.giveChoice();
        }
        board.placeTileToLine(tile, choice);

        board.getPanel().removeLastOfRow(row);
    }
/**
     * Shows the Board of this Solo1Game .(PanelOfTiles+DominoLine)
     */
    private void showBoard() {
        gui.showPanel(board.getPanel());
        if (!board.getLine().isEmpty()) {
            BasicDominoLine l= (BasicDominoLine) board.getLine();
            gui.showSetOfTiles(l.getSetOfTiles());
        }
    }
/**
 * This method represents the main loop of the Solo1 game. It keeps checking
 * whether the player can keep on playing and makes their moves till the game
 * is over.Shows result at the end(victory/defeat).
 */
    public void gameLoop() {
        gui.welcomeToSolo1(board.getPanel());  
        while (board.continuePlaying()) {
            int row = readTile();
            Tile tile = board.getPanel().getLastOfRow(row);
            PlaceTile(tile, row);
            showBoard();

        }

        //epistrefei an nikhse h oxi 
            gui.showResult(board.getPanel().panelIsEmpty());
  
    }
  /**
     * Returns the PanelOfTiles of this board.
     *
     * @return a PanelOfTiles of this board.
     */
    public PanelOfTiles getPanel(){
        return board.getPanel();
    }

    @Override
    public void run() {
        gameLoop();
    }
    
    
}

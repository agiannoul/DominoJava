
package domino_project;

/**
 * This class represents the board of Solo1 type of DominoGame. The board
 * consists of a PanelOfTiles from where the Tiles are given to the player and
 * of a DominoLine on where the player puts their Tiles(from extending Board).
 *
 * @author Apatsidis Ioannis
 * @author Giannoulidis Apostolos
 */
public class BoardSolo1 extends Board {

    private PanelOfTiles panel;
    
    /**
     * Class Constructor. 
     * Creates a PanelOfTiles and a DominoLine.
     */
    public BoardSolo1() {
        super.line=new BasicDominoLine();
        panel = new PanelOfTiles();
    }
    /**
     * * This method removes the tile of a specified(x) row of the PanelOfTiles of
     * this board and puts it at the End of the DominoLine of this board.Tile
     * gets reversed if needed.
     * 
     * @param x the row(in PanelOfTiles) of which to get the Tile
     * @param reverse a boolean representing if tile needs to be reversed(true)
     * or not(false) to be put on the DominoLine
     */
    public void putFromPanelToEndOFLine(int x, boolean reverse) {
        Tile tile = panel.getLastOfRow(x);
        if (reverse) {
            tile.reverseTile();
        }
        panel.removeLastOfRow(x);
        line.addTileAtTheEnd(tile);
    }
        /**
         * This method removes the tile of a specified(x) row of the PanelOfTiles of
     * this board and puts it on the Beggining of the DominoLine of this
     * board.Tile gets reversed if needed.
     *
     * @param x the row(in PanelOfTiles) of which to get the Tile
     * @param reverse a boolean representing if tile needs to be reversed(true)
     * or not(false) to be put on the DominoLine
         */
    public void putFromPanelToStartOFLine(int x, boolean reverse) {
        Tile tile = panel.getLastOfRow(x);
        if (reverse) {
            tile.reverseTile();
        }
        panel.removeLastOfRow(x);
        line.addTileOnBeginning(tile);
    }

    
/**
     * This method checks whether a player can continue playing this game or
     * not. If any of the Last Tiles of any existing row of the PanelOfTiles of
     * this board fits on line, they can continue playing.
     *
     * @return true if continue-playing is possible,otherwise false
     */
  

    public boolean continuePlaying() {
        boolean state = false;
        for (int i = 0; i < 4 && state == false; i++) {
            if (!panel.isRowEmpty(i)) {
                state = checkIfFits(panel.getLastOfRow(i));
            }
        }
        return state;
    }

    /**
     * Checks whether we have a victory or not.If the panel is empty we have
     * victory,otherwise we don't.
     *
     * @return true if panel has no elements ,otherwise false.
     */
    public boolean checkVictory() {
        return panel.panelIsEmpty();
    }
    /**
     * Returns the PanelOfTiles of this board.
     *
     * @return a PanelOfTiles of this board.
     */
    public PanelOfTiles getPanel() {
        return panel;
    }

}
